package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver driver;
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(name="UserName")
	private WebElement username;
	
	@FindBy(name="Password")
	private WebElement password;
	
	@FindBy(xpath="//span[@class=\"MuiButton-label-271\"]")
	private WebElement loginbutton;
	
	
	
	public void putuser(String userName) {
		username.sendKeys(userName);
	}
	public void putpassword(String Password) {
		password.sendKeys(Password);
	}
	public void clicklogin() {
		loginbutton.click();
	}
	

}
