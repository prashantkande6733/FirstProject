package com.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.pages.Pages;
import com.utility.PropertiesUtils;

public class BaseClass {

	public static WebDriver driver;
	public static Logger Log = Logger.getLogger(BaseClass.class);
	public static ExtentReports report;
	public static ExtentTest test;
	public static ExtentSparkReporter spark;

	// Browser Initialized
	public static WebDriver Initialization() {

		Log.info("Initialising Browser");
		String browser = PropertiesUtils.getProperty("browser");
		Log.info(browser + "Browser Is Initialized");

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}
		if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("Webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		}
		Log.info("Brower is Maximized");
		driver.manage().window().maximize();
		driver.get(PropertiesUtils.getProperty("url"));
		Log.info("Load is apply over a browser");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

	public void ReportInitialised() {
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/Report/ExtendReports.html");
		report = new ExtentReports();
		report.attachReporter(spark);

	}

	public String takesScreenshot(String name) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + name + ".jpg";

		try {
			FileUtils.copyFile(src, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;

	}

	public Pages loadPage() {
		Pages pg = new Pages(driver);

		return pg;

	}

}
