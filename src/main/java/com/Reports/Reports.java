package com.Reports;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Baseclass.WebTestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.customException.FolderNotCreated;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Reports extends WebTestBase{
	
	private static ExtentReports reports;
	private static ExtentSparkReporter extentx;
	private static ExtentTest createTest;
	private static String classNames;
	private static File report;
	private static Reports reports1;
	
	private Reports(Class<?> className) throws FolderNotCreated {
		classNames = className.getName();
		String ClassName = classNames.split("\\.")[1];
		System.out.println("ClassName is "+ClassName);
		report = new File("./Reports/"+ClassName+getRandomNumber()+"/Screenshot/");
		if(!report.isDirectory())
			if(report.mkdirs())
				System.out.println("Folder Created...!");
			else
				throw new FolderNotCreated("Reports folder not created...!");
		reports = new ExtentReports();
		extentx = new ExtentSparkReporter("./Reports/"+classNames);
	}
	
	public synchronized static Reports getInstaice(Class<?> className) throws FolderNotCreated {
		if(reports1==null) 
			reports1 = new Reports(className);
		return reports1;
	}
	
	public void logs(String msg, ReportStatus reportStatus) throws IOException {
		
		switch (reportStatus) {
		
		/*case BUSINESS:
			reports.attachReporter(extentx);
			createTest = reports.createTest(classNames+"_"+getRandomNumber());
		break;*/
			
		case PASS:
			takeFullScreenShot();
			createTest.addScreenCaptureFromPath("");
			createTest.log(Status.PASS, msg);
		break;
		
		case FAIL:
			takeFullScreenShot();
			createTest.addScreenCaptureFromPath("");
			createTest.log(Status.FAIL, msg);
		break;
		
		case Pass:
			takeScreenShot();
			createTest.addScreenCaptureFromPath("");
			createTest.log(Status.PASS, msg);
		break;
		
		case Fail:
			takeScreenShot();
			createTest.addScreenCaptureFromPath("");
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
	
	public void closeBusinessStep() {
		reports.flush();
	}
	
	public static void takeScreenShot() throws IOException {
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("./Reports/Screenshot/");
		File checkFileExists = new File("./Reports/Screenshot");
		if(!checkFileExists.exists() && !checkFileExists.isDirectory()) {
			if(checkFileExists.mkdir())
				System.out.println("File Created Successfully...!");
		}
		FileUtils.copyFile(SrcFile, DestFile);
	}
	
	public static void takeFullScreenShot() throws IOException {
		File DestFile=new File("./Reports/Screenshot/");
		if(!DestFile.exists() && !DestFile.isDirectory()) {
			if(DestFile.mkdir())
				System.out.println("Directory Created Successfully....!");
		}
		Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(fpScreenshot.getImage(),"PNG",new File("D/Reports/Screenshot/Run"+getRandomNumber()+".png"));
	}
	
	public static long getRandomNumber() {
		Random random = new Random();
		return random.nextLong();
	}
}
