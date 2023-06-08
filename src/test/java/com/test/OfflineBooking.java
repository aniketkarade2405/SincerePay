package com.test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.Base_Class;
import com.pom.Login;
import com.pom.new_tc;
import com.utility.ExcelCode;
import com.utility.ScreenshotCode;

public class OfflineBooking extends Base_Class  {
	
	@BeforeTest
	 public void openbrowser() {
		 driver = Base_Class.initialization();
		 driver.get("https://sincerepay.co.in/Login");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 
		  }
	 @BeforeMethod
	 public void SincereLogin() throws EncryptedDocumentException, IOException  {
		 Login login = new Login(driver);
	//	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	//	 String user = ExcelCode.getData(1, 0);
		 login.putuser("8983537692");
	//	 String password = ExcelCode.getData(1, 1);
		 login.putpassword("98080525");
		 login.clicklogin();
		 String title =driver.getTitle();
		 System.out.println("Title: "+title);
		 System.out.println("Login is Successfully");
	}
	@Test
	public void verifyOfflineBooking() throws InterruptedException, EncryptedDocumentException, IOException {
		
		SoftAssert soft = new SoftAssert();
//		Creating object of pom class 
		new_tc TC = new new_tc(driver);
		
//		Execution started by using methods crested in pom class
		TC.clickOnServicesButton();
		TC.clickOnofflineBookButton();
		TC.clickOnOpTypeButton();
		Thread.sleep(1000);
		
//		Collecting WebElements of OpType dropdown
	//	List<WebElement> opTypeDropdownElements = TC.getDropdownElements();
		List<WebElement> opTypeDropdownElements = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		opTypeDropdownElements.remove(0);
		int countOfOpTypeDropdownElements = opTypeDropdownElements.size(); 
		System.out.println("Count of OpType Dropdown Elements: "+countOfOpTypeDropdownElements);
		
//		Iterating over each OpType dropdown element
		for(int i=0; i<countOfOpTypeDropdownElements; i++) {
			Actions act = new Actions(driver);
			act.moveToElement(opTypeDropdownElements.get(i)).click().build().perform();
			Thread.sleep(1000);

//			after selecting OpType element, clicking on Operator button
		    TC.clickOnOperatorButton();
			Thread.sleep(1000);
			
//		   collecting WebElements of Operator dropdown
	//	   List<WebElement> operatorTypeDropdownElements = TC.getDropdownElements();
		   List<WebElement> operatorTypeDropdownElements = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		   operatorTypeDropdownElements.remove(0);
		   int countOfOperatorTypeDropdownElements = operatorTypeDropdownElements.size();
		   System.out.println("Count of Operator Type Dropdown Elements: "+countOfOperatorTypeDropdownElements);

//		   Iterating over each OperatorTypeDropdown element
		     for(int j=0; j<countOfOperatorTypeDropdownElements; j++){
			   act.moveToElement(operatorTypeDropdownElements.get(j)).click().build().perform();
			   Thread.sleep(1000);

//			   after selecting operator element, clicking on package button
			   TC.clickOnPackageButton();
			   Thread.sleep(1000);
			  
//			   collecting WebElements of package dropdown
	//		   List<WebElement> packageNameDropdownElements = TC.getDropdownElements();
			   List<WebElement> packageNameDropdownElements = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
			   packageNameDropdownElements.remove(0);
			   int countOfPackageNameDropdownElements = packageNameDropdownElements.size();
			   System.out.println("Count of Package Name Dropdown Elements: "+countOfPackageNameDropdownElements);
			   if(packageNameDropdownElements.size()==1) {
				   act.moveToElement(packageNameDropdownElements.get(0)).click().build().perform();
				   Thread.sleep(1000);
			       System.out.println(TC.getPackageMRP());
			       System.out.println(TC.getDescription());
			       System.out.println(TC.getValidity());
			       String contactnumber = ExcelCode.getData(1, 2);
			       TC.setContactNumber(contactnumber);
			       String personName = ExcelCode.getData(1, 3);
			       TC.setPersonName(personName);
			       String address = ExcelCode.getData(1, 4);
			       TC.setAddress(address);
			       String pincode = ExcelCode.getData(1, 5);
			       TC.setPincode(pincode);
			       TC.clickOnBook();
			       Thread.sleep(1000);
			       TC.selectYesDoTransaction();
			       Thread.sleep(1000);
			       soft.assertTrue(true); 
			   }  
			   else if(packageNameDropdownElements.size()>1) {
				   for(int k=0; k<=countOfPackageNameDropdownElements; k++) {
					   act.moveToElement(packageNameDropdownElements.get(k)).click().build().perform();
					   Thread.sleep(1000);
				       System.out.println(TC.getPackageMRP());
				       System.out.println(TC.getDescription());
				       System.out.println(TC.getValidity());
				       String contactnumber = ExcelCode.getData(1, 2);
				       TC.setContactNumber(contactnumber);
				       String personName = ExcelCode.getData(1, 3);
				       TC.setPersonName(personName);
				       String address = ExcelCode.getData(1, 4);
				       TC.setAddress(address);
				       String pincode = ExcelCode.getData(1, 5);
				       TC.setPincode(pincode);
				       Thread.sleep(1000);
				       soft.assertTrue(true);
				       TC.clickOnPackageButton();
				       packageNameDropdownElements = TC.getDropdownElements();
				       packageNameDropdownElements.remove(0);
				   }

			   }
			   else {
				   act.sendKeys(Keys.ENTER).build().perform();
				   soft.assertTrue(false);
				   
				   Thread.sleep(1000);

			   }
			   if( j<(countOfOperatorTypeDropdownElements-1)){
				   TC.clickOnOperatorButton();
				   Thread.sleep(1000);
				   operatorTypeDropdownElements = TC.getDropdownElements();
				   operatorTypeDropdownElements.remove(0);
				   countOfOperatorTypeDropdownElements = operatorTypeDropdownElements.size();
				   
				}
			   
		   }
		   if( i<(countOfOpTypeDropdownElements-1)){

			   TC.clickOnOpTypeButton();
			   Thread.sleep(1000);
			   opTypeDropdownElements = TC.getDropdownElements();
			   opTypeDropdownElements.remove(0);
			   countOfOpTypeDropdownElements = opTypeDropdownElements.size();
		   }
		}
		soft.assertAll();
	}
	@AfterMethod
	public void failTestCase(ITestResult result) throws IOException {
		new_tc TC = new new_tc(driver);
		TC.clickOnServicesButton();
		TC.clickOnofflineBookButton();
		String personName = ExcelCode.getData(2, 3);
	    TC.setPersonName(personName);
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
