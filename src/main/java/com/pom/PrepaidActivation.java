package com.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrepaidActivation {
	
	WebDriver driver;
	@FindBy(xpath="(//a[@class=\"nav-link dropdown-toggle\"])[2]")
	private WebElement clickOnServices;
	
	@FindBy(xpath="//a[@href=\"/PrepaidActivation\"]")
	private WebElement ClickOnPrepaidActivation;
	
	@FindBy(id="OperatorID")
	private WebElement ClickOnSelectOperatprButton;
	
	@FindBy(xpath="//li[@data-value=\"14\"]")
	private WebElement selectAirtel;
	
	@FindBy(id="ActivationType")
	private WebElement clickOnActivationTypeButton;
	
	@FindBy(xpath="//li[@data-value=\"NewConnection\"]")
	private WebElement selectNewConnection;
		
//	@FindBy(xpath="//ul[@role='listbox']/li")
//	private List<WebElement> dropdownElements;
	
	@FindBy(name="AlternateNumber")
	private WebElement AlternateMobileNumber;
	
	@FindBy(name="Name")
	private WebElement name;
	
	@FindBy(name="Address")
	private WebElement address;
	
	@FindBy(name="Pincode")
	private WebElement pincode;
	
	@FindBy(xpath="(//span[@class=\"MuiButton-label-495\"])[2]")
	private WebElement request;
	
	@FindBy(xpath="(//span[@class=\"MuiButton-label-495\"])[5]")
	private WebElement yesDoTransaction;
	
	@FindBy(xpath="(//span[@class=\"MuiButton-label-495\"])[3]")
	private  WebElement reset;
	
	public PrepaidActivation(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void clickServicesButton() {
		clickOnServices.click();
	}
	public void clickPrepaidActivationButton() {
		ClickOnPrepaidActivation.click();
	}
	public void clickOnSelectOperatorButton() {
		ClickOnSelectOperatprButton.click();
	}
	public void clickOnAirtel() {
		selectAirtel.click();
	}
	public void clickOnActivationType() {
		clickOnActivationTypeButton.click();
	}
	public void clickOnNewConnection() {
		selectNewConnection.click();
	}
//	public List<WebElement> getDropdownElements() {
//		List<WebElement> elements = dropdownElements;
//		for(WebElement element: elements) {
//			System.out.println(element.getText());
//		}
//		System.out.println(elements);
//		return elements;
//	}
	
	public void setAlternateMobileNumber (String number) {
		AlternateMobileNumber.sendKeys(number);
	}
	public void setName(String Name) {
		name.sendKeys(Name);
	}
	public void setAddress(String Address) {
		address.sendKeys(Address);
	}
	public void setPincode(String Pincode) {
		pincode.sendKeys(Pincode);
	}
	public void clickOnRequest() {
		request.click();
	}
	public void clickOnYesDoTransaction() {
		yesDoTransaction.click();
	}
	public void clickOnReset() {
		reset.click();
	}
	
		
		

}
