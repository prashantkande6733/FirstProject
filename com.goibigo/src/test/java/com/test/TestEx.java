package com.test;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.Pages;

public class TestEx extends BaseClass {
	
	WebDriver driver;
	
	@BeforeSuite
	public void setup(){
		driver = Initialization();
		loadPage();
		ReportInitialised();
		takesScreenshot("name");
	}

	@Test
	public void verify_Hotel() throws AWTException, InterruptedException{
		Pages page = new Pages(driver);
		page.HotelSearch();
		Assert.assertTrue(true);
			
		}
	}


	
	
	


