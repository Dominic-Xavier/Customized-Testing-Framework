package com.Reports;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.customException.FolderNotCreated;
import com.excelSheet.DataProviders;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Reports extends DataProviders{
	
	private static ExtentReports reports;
	private static ExtentSparkReporter extentx;
	private static File report;
	private static WebDriver driver;
	private static String reportName;
	
	public ExtentReports createReport(String className) throws FolderNotCreated, IOException {
		String Document_Title = getData("Document Title");
		String Report_Name = getData("Report Name");
		String Company_Name = getData("Company Name");
		String Project_Name = getData("Project Name");
		String OS = getData("OS");
		String date_time_Pattern = getData("Date&Time Pattern");
		String name = className+getRandomNumber();
		reportName = name;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(date_time_Pattern);
		LocalDateTime now = LocalDateTime.now();
		String dateTime = dtf.format(now);
		report = new File("./Reports/"+name+"/Screenshot/");
		if(!report.isDirectory())
			if(report.mkdirs())
				System.out.println("Reports Folder Created...!");
			else
				throw new FolderNotCreated("Reports folder not created...!");
		reports = new ExtentReports();
		extentx = new ExtentSparkReporter("./Reports/"+name+"/Report.html");
		extentx.config().setDocumentTitle(Document_Title);
		extentx.config().setReportName(Report_Name);
		reports.attachReporter(extentx);
		
		reports.setSystemInfo("Company Name", Company_Name);
		reports.setSystemInfo("Project Name", Project_Name);
		reports.setSystemInfo("OS", OS);
		reports.setSystemInfo("Date and Time", dateTime);
		return reports;
	}
	
	public ExtentTest createTest(String testName, String description, WebDriver driver) {
		Reports.driver = driver;
		return reports.createTest(testName, description);
	}
	
	public static void log(ExtentTest createTest,String msg, ReportStatus reportStatus) throws IOException {
		
		String imagePath = "./Reports/"+reportName+"/Screenshot/";
		
		switch (reportStatus) {
		
		/*case BUSINESS:
			reports.attachReporter(extentx);
			createTest = reports.createTest(classNames+"_"+getRandomNumber());
		break;*/
			
		case PASS:
			String imageName = takeFullScreenShot();
			createTest.addScreenCaptureFromPath(imagePath+imageName);
			createTest.info(msg);
			createTest.log(Status.PASS, msg);
		break;
		
		case FAIL:
			String imageName1 = takeFullScreenShot();
			createTest.addScreenCaptureFromPath(imagePath+imageName1);
			createTest.log(Status.FAIL, msg);
		break;
		
		case Pass:
			String imageName2 = takeScreenShot();
			createTest.addScreenCaptureFromPath(imagePath+imageName2);
			createTest.log(Status.PASS, msg);
		break;
		
		case Fail:
			String imageName3 = takeScreenShot();
			createTest.addScreenCaptureFromPath(imagePath+imageName3);
			createTest.log(Status.FAIL, msg);
		break;
		
		case pass:
			createTest.log(Status.PASS, msg);
		break;	
		
		case fail:
			createTest.log(Status.FAIL, msg);
		break;
		}
	}
	
	public void closeReport() {
		reports.flush();
	}
	
	public static String takeScreenShot() throws IOException {
		String imageName = "img"+getRandomNumber()+".png";
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File("./Reports/"+reportName+"/Screenshot/"+imageName); 
		FileUtils.copyFile(SrcFile, DestFile);
		return imageName;
	}
	
	public static String takeFullScreenShot() throws IOException {
		String imageName = "img"+getRandomNumber()+".png";
		Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(fpScreenshot.getImage(),"PNG",new File("./Reports/"+reportName+"/Screenshot/"+imageName));
		return imageName;
	}
	
	public static long getRandomNumber() {
		Random random = new Random();
		return random.nextLong();
	}
}