package com.pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Utility_class;

public class Pages extends Utility_class {
	WebDriver driver;
	Actions actions;
	
	public Pages(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);	
	}

	@FindBy(xpath="//h4[contains(text(), 'India')]")
	private WebElement Radiobtn;
	
	@FindBy(xpath="//input[@aria-autocomplete='list']")
	private WebElement City;
	
	@FindBy(xpath="//div[contains(text(), 'Check-in')]")
	private WebElement Date1;

	@FindBy(xpath="//span[@data-testid='date_13_0_2022']")
	private WebElement CheckIn;
	
	@FindBy(xpath="//span[@data-testid='date_20_0_2022']")
	private WebElement CheckOut;
	
	
	
	
	public boolean HotelSearch () throws AWTException, InterruptedException{
		
		Radiobtn.click();
		City.sendKeys("Goa");
		Robot();
		Thread.sleep(5000);
		Date1.click();
		CheckIn.click();
		CheckOut.click();
		Robot();
		return true;
		
		
		
	}
}
