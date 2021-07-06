package com.pageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerPage{
	
	
	WebDriver driver;
	WebDriverWait wait;
	private By lastName=  By.xpath("//input[@placeholder='Last Name']");
	private By postCode= By.xpath("//input[@placeholder='Post Code']");
	private By submitBtn= By.xpath("//button[text()='Add Customer']");
	
	private By openAccountTab= By.xpath("//button[contains(text(),'Open Account')]");
	private By customerDropdown= By.id("userSelect");
	private By currencyDropdown= By.id("currency");
	private By processButton= By.xpath("//button[text()='Process']");
	private By customersTab= By.xpath("//button[contains(text(),'Customers')]");
	private By searchCustomerBox= By.xpath("//input[@placeholder='Search Customer']");
	private By firstName= By.xpath("//input[@placeholder='First Name']");
	
	
	public CustomerPage(WebDriver driver, WebDriverWait wait){
		
		this.driver= driver;
		this.wait= new WebDriverWait(this.driver, 15);
	}
	
	public WebElement getFirstName() {
	
		return driver.findElement(firstName);
	}
	
	public WebElement getLastName() {
		return driver.findElement(lastName);
	}
	
	public WebElement getSubmitButton() {
		
		return driver.findElement(submitBtn);
	}
	
	public WebElement getPostCode() {
		return driver.findElement(postCode);
	}
	
	public WebElement getOpenAccountTab() {
		return driver.findElement(openAccountTab);
	}
	
	public WebElement getCustomerDropdown() {
		return driver.findElement(customerDropdown);
	}
	
	public WebElement getCurrencyDropdown() {
		return driver.findElement(currencyDropdown);
	}
	
	public WebElement getProcessButton() {
		return driver.findElement(processButton);
	}
	
	public WebElement getCustomersTab() {
		return driver.findElement(customersTab);
	}
	
	public WebElement getSearchCustomerBox() {
		return driver.findElement(searchCustomerBox);
	}
	
	
	public void addCustomer(String firstName, String lastname, String postCode) {
		
		getFirstName().sendKeys(firstName);
		getLastName().sendKeys(lastname);
		getPostCode().sendKeys(postCode);
		getSubmitButton().click();
			
	}
	
	public void openAccount(String cusName, String currency) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(openAccountTab));
		getOpenAccountTab().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(customerDropdown));
		Select customer= new Select(getCustomerDropdown());	
		customer.selectByVisibleText(cusName);
		Select currencyValue= new Select(getCurrencyDropdown());
		currencyValue.selectByVisibleText(currency);
		getProcessButton().click();
		
	}
	
	public void searchCustomer(String cusName) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(customersTab));
		getCustomersTab().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchCustomerBox));
		getSearchCustomerBox().sendKeys(cusName);

	}
	
}
