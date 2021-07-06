package com.sample.project.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	WebDriver driver;
	WebDriverWait wait;
	@BeforeTest
	public void SetUp() {
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("http://www.way2automation.com/angularjs-protractor/banking/#/manager/addCust");
		driver.manage().window().maximize();
	}
	

	@AfterTest
	public void tearDown() {
		
		driver.quit();
	}
	
	
}
