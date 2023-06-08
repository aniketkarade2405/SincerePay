package com.test;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.Base_Class;
import com.pom.Login;
import com.pom.PrepaidActivation;
import com.utility.ExcelCode;

public class PrepaidActivationPage extends Base_Class {
	@BeforeTest
	 public void openbrowser() {
		 driver = Base_Class.initialization();
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
		 Thread.sleep(1000);
		 List<WebElement> operatorDropdownElement = PA.getDropdownElements();
		 operatorDropdownElement.remove(0);
		 int countOfOperatorDropdownElements = operatorDropdownElement.size();
		 System.out.println("Count Of Operator Dropdown Elements"+countOfOperatorDropdownElements);
		 
//		 Iterating over each Opeartor dropdown element
			for(int i=0; i<countOfOperatorDropdownElements; i++) {
				Actions act = new Actions(driver);
				act.moveToElement(operatorDropdownElement.get(i)).click().build().perform();
				Thread.sleep(1000);
				
//		after selecting operator clicking on activationType
				PA.clickOnActivationType();
				Thread.sleep(1000);
				
//		Iterating over each activationtype dropdown element
				List<WebElement> activationTypeDropdownElements = PA.getDropdownElements();
				activationTypeDropdownElements.remove(0);
				int countOfactivationTypeDropdownElements = activationTypeDropdownElements.size();
				System.out.println("Count Of ActivationType Dropdown Elements"+countOfactivationTypeDropdownElements);
//				Iterating over each ActivationTypeDropdown element
			     for(int j=0; j<countOfactivationTypeDropdownElements; j++){
				   act.moveToElement(activationTypeDropdownElements.get(j)).click().build().perform();
				   Thread.sleep(1000);		
				   
// 		after selecting activation type set the details
				   String contactnumber = ExcelCode.getData(1, 2);
			       PA.setAlternateMobileNumber(contactnumber);
			       String personName = ExcelCode.getData(1, 3);
			       PA.setName(personName);
			       String address = ExcelCode.getData(1, 4);
			       PA.setAddress(address);
			       String pincode = ExcelCode.getData(1, 5);
			       PA.setPincode(pincode);
			     
//  	after filling details click on request
			       PA.clickOnRequest();
// 		filled information is stores in table
//		click on reset
			       PA.clickOnReset();
			       
				   
		 
		 
	 }

	 }
	 }
	 }
	 
