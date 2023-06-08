package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {
	
	public static WebDriver driver;
	
	@Parameters("Browser")
	public static WebDriver initialization(){
	 
		 WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
			option.addArguments("disable-notification");
			driver = new ChromeDriver(option);
			driver.manage().window().maximize();
			return driver;
		
	}

}
