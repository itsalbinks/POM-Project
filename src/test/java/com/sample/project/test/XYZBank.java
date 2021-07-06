package com.sample.project.test;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pageClasses.CustomerPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XYZBank extends BaseClass{
	
	CustomerPage obj;
	
	@Test(priority = 1)
	public void addCustomerTest() {
		
		obj = new CustomerPage(driver, wait);
		obj.addCustomer("Mahesh", "Babu", "65620");
		Alert Al= driver.switchTo().alert();
		String alerttext=Al.getText();
		Assert.assertTrue(alerttext.contains("Customer added successfully"));
		Al.accept();
		
	}
	
	@Test(priority = 2)
	public void openAccountTest() {
	
		obj.openAccount("Mahesh Babu", "Dollar");
		Alert Al= driver.switchTo().alert();
		String alerttext=Al.getText();
		Assert.assertTrue(alerttext.contains("Account created successfully"));
		Al.accept();

	}
	
	@Test(priority = 3)
	public void searchCustomer() {
		
		obj.searchCustomer("Mahesh");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		String before_xpath= "//table[@class='table table-bordered table-striped']/tbody/tr[";
		String after_xpath= "]/td[1]";
		for(int i=1; i<=2; i++) {
			String name= driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			if(name.contains("Mahesh")) {
				Assert.assertTrue(true);
				break;
			}
		}

	}

}
