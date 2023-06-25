package com.test;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.Base_Class;
import com.pom.Login;
import com.pom.PrepaidActivation;
import com.pom.new_tc;
import com.utility.ExcelCode;
import com.utility.ScreenshotCode;

public class PrepaidActivationPage extends Base_Class {
	@BeforeTest
	@Parameters("Browser")
	 public void openbrowser(String browser) throws InterruptedException {
		if(browser.equalsIgnoreCase("chrome")) {
			 driver = Base_Class.openChromebrowser();
			 Thread.sleep(1000);
			 System.out.println("chrome is launched successfully");
		} 
		else if (browser.equalsIgnoreCase("edge")) {
			 driver = Base_Class.openEdgebrowser();
			 Thread.sleep(1000);

			 System.out.println("edge is launched successfully");
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver = Base_Class.openFirefoxbrowser();
			 Thread.sleep(1000);

			System.out.println("firefox is launched successfully");
		}
		 
		 driver.get("https://sincerepay.co.in/Login");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 }
	 @BeforeMethod
	 public void SincereLogin() throws EncryptedDocumentException, IOException  {
		 Login login = new Login(driver);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		 String user = ExcelCode.getData(1, 0);
		 login.putuser("8983537692");
//		 String password = ExcelCode.getData(1, 1);
		 login.putpassword("98080525");
		 login.clicklogin();
		 String title =driver.getTitle();
		 System.out.println("Title: "+title);
		 System.out.println("Login is Successfully");
	 }
		 
	 @Test
	 public void verifyPrepaidActivation() throws InterruptedException, EncryptedDocumentException, IOException {
		 SoftAssert soft = new SoftAssert();
		 PrepaidActivation PA = new PrepaidActivation(driver);
		 PA.clickServicesButton();
		 PA.clickPrepaidActivationButton();
		 PA.clickOnSelectOperatorButton();
		 PA.clickOnAirtel();
		 PA.clickOnActivationType();
		 PA.clickOnNewConnection();
		 String contactnumber = ExcelCode.getData(1, 2);
	     PA.setAlternateMobileNumber(contactnumber);
	     String personName = ExcelCode.getData(1, 3);
	     PA.setName(personName);
         String address = ExcelCode.getData(1, 4);
	     PA.setAddress(address);
	     String pincode = ExcelCode.getData(1, 5);
	     PA.setPincode(pincode);
	     PA.clickOnRequest();
	     PA.clickOnYesDoTransaction();
	     PA.clickOnReset();
	     
	 }

	     @AfterMethod
	     public void failTestCase1(ITestResult result) throws IOException {
	 		PrepaidActivation PA = new PrepaidActivation(driver);
	 		PA.clickServicesButton();
	 		PA.clickPrepaidActivationButton();
	 		String personName = ExcelCode.getData(2, 3);
	 	    PA.setName(personName);
	 	    if(ITestResult.SUCCESS==result.getStatus()) {
	 	    	ScreenshotCode.getScreenshotAs(driver);
	 	    	if(ITestResult.FAILURE==result.getStatus())
	 	    	{
	 	    		ScreenshotCode.getScreenshotAs(driver);
	 	    	}
	 		}
	 		else {
	 			System.out.println("screenshot");
	 			ScreenshotCode.getScreenshotAs(driver);
	 		}
	 		
	 	
	    	 
	     }
	     
	    }
      
		 

	 
	 
	 
