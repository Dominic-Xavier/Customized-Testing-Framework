package com.Reports;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Baseclass.WebTestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Reports extends WebTestBase{
	
	private static ExtentReports reports;
	private static ExtentSparkReporter extentx;
	private static ExtentTest createTest;
	private static String classNames;
	
	public Reports(Class<?> className) {
		classNames = className.getPackageName()+"."+className.getCanonicalName();
		reports = new ExtentReports();
		extentx = new ExtentSparkReporter("./Reports/"+classNames);
	}
	
	public static void logs(String msg, ReportStatus reportStatus) {
		switch (reportStatus) {
		case BUSINESS:
			reports.attachReporter(extentx);
			createTest = reports.createTest(classNames+"_"+getRandomNumber());
		break;
			
		case PASS:
			createTest.log(Status.PASS, msg);
			createTest.addScreenCaptureFromPath("");
		break;
		
		case FAIL:
			createTest.log(Status.FAIL, msg);
		break;
		
		case Pass:
			createTest.addScreenCaptureFromPath("");
			createTest.log(Status.PASS, msg);
		break;
		
		case Fail:
			createTest.addScreenCaptureFromPath("");
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
		File DestFile=new File("./Reports/Screenshot/Run"+getRandomNumber());
		File checkFileExists = new File("./Reports/Screenshot");
		if(!checkFileExists.exists() && !checkFileExists.isDirectory()) {
			if(checkFileExists.mkdir())
				System.out.println("File Created Successfully...!");
		}
		FileUtils.copyFile(SrcFile, DestFile);
	}
	
	public static void takeFullScreenShot() throws IOException {
		File DestFile=new File("./Reports/Screenshot");
		if(!DestFile.exists() && !DestFile.isDirectory()) {
			if(DestFile.mkdir())
				System.out.println("Directory Created Successfully....!");
		}
		Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(fpScreenshot.getImage(),"PNG",new File("D/Reports/Screenshot/Run"+getRandomNumber()+".png"));
	}
}
