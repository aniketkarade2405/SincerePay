package com.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class new_tc {
	
	WebDriver driver;

    public new_tc(WebDriver driver) {
    	
    	PageFactory.initElements(driver, this);
    }
	
	@FindBy(xpath="//a[contains(text(),'Services')]")
    private WebElement servicesButton;
	
	@FindBy(xpath="//a[@href='/OfflineBook']")
	private WebElement offlineBookButton;
	
	@FindBy(id="OpType")
	private WebElement selectOpTypeButton;
	
	@FindBy(xpath="//ul[@role='listbox']/li")
	private List<WebElement> dropdownElements;
	 
	
	@FindBy(xpath="//label[contains(text(),'Operator')]//parent::div//child::div")
	private WebElement selectOperatorButton;
	
	@FindBy(xpath="//div[@id='OfflineProductMasterID']")
	private WebElement selectPackageButton;
	
	@FindBy(xpath="//input[@name='PackageMRP']")
	private WebElement packageMRP;
	
	@FindBy(xpath="//input[@name='BookingAmount']")
	private WebElement bookingAmount;
	
	@FindBy(xpath="//input[@name='Description']")
	private WebElement description;
	
	@FindBy(xpath="//input[@name='Validity']")
	private WebElement validity;
	
	@FindBy(xpath="//input[@placeholder='Contact Number']")
	private WebElement contactNumber;
	
	@FindBy(xpath="//input[@placeholder='Person Name']")
	private WebElement personName;
	
	@FindBy(xpath="//input[@placeholder='Address']")
	private WebElement address;
	
	@FindBy(xpath="//input[@placeholder='Pincode']")
	private WebElement pincode;
	
	@FindBy(xpath="(//span[@class=\"MuiButton-label-495\"])[2]")
	private WebElement selectBook;
	
	@FindBy(xpath="(//span[@class=\"MuiButton-label-495\"])[5]")
	private WebElement transaction;
	
	public void clickOnServicesButton() {
		servicesButton.click();
	}

	public void clickOnofflineBookButton() {
		
		offlineBookButton.click();
	}
	
	public void clickOnOpTypeButton() {
		selectOpTypeButton.click();
	}
	
	public List<WebElement> getDropdownElements() {
		List<WebElement> elements = dropdownElements;
		for(WebElement element: elements) {
			System.out.println(element.getText());
		}
		System.out.println(elements);
		
		return elements;
	}
	
	public void clickOnOperatorButton() {
		selectOperatorButton.click();
	}
	
	public void clickOnPackageButton() {
		selectPackageButton.click();
	}
	
	public String getPackageMRP() {
		return packageMRP.getText();
	}
	
	public String getBookingAmount () {
		return bookingAmount.getText();
	}
	
	public String getDescription () {
		return description.getText();
	}
	
	public String getValidity () {
		return validity.getText();
	}
	
	public void setContactNumber (String number) {
		contactNumber.sendKeys(number);
	}
	
	public void setPersonName (String name) {
		personName.sendKeys(name);
	}
	
	public void setAddress (String add) {
		address.sendKeys(add);
	}
	
	public void setPincode (String pin) {
		pincode.sendKeys(pin);
	}
	public void clickOnBook() {
		selectBook.click();
	}
	public void selectYesDoTransaction() {
		transaction.click();
	}

}
