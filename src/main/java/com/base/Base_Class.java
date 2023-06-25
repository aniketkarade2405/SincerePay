package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {
	
	public static  WebDriver driver;
	
	
	
	public static WebDriver openChromebrowser(){
	  	
		 WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
			option.addArguments("disable-notification");
			driver = new ChromeDriver(option);
			driver.manage().window().maximize();
			return driver;
	}
	public static WebDriver openEdgebrowser() {
		WebDriverManager.edgedriver().setup();
		EdgeOptions edgeoptions = new EdgeOptions();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	public static WebDriver openFirefoxbrowser() {
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions firefoxoptions = new FirefoxOptions();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;	
	}
	
	
}
