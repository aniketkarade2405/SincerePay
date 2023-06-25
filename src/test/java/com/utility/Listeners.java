package com.utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.Base_Class;

public class Listeners extends Base_Class implements ITestListener {
	public static WebDriver driver;
	
	//get exetentreport method directly call through ESR but method return extentreport object extent so we import ER
	 ExtentReports extent = ExtentReportGenerators.getExtentReports();  
	// multiple test attach on single report so we call TL class
	 ThreadLocal<ExtentTest> extenttest = new ThreadLocal<ExtentTest>();
	 
	    public void onTestStart(ITestResult result) { //method name
	//from whicj package, which class, test case name info
	//Set class name method name on report by using extent
	    ObjectRepo.test = extent.createTest(result.getTestClass().getName()+"=="+result.getMethod().getMethodName());
	    extenttest.set(ObjectRepo.test); //attach particular test on report

	}
       public void onTestSuccess(ITestResult result) {
    	   ObjectRepo.test.log(Status.PASS, "Test case pas");
  // how to capture screenshot when we send ss to senior through mail by using Base64 istead of File
    //	   String src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64); //return type of Base64 is String
   	//	   ObjectRepo.test.addScreenCaptureFromBase64String(src);
   		   
   	}
       public void onTestFailure(ITestResult result) {
      	   ObjectRepo.test.log(Status.FAIL, "Test case fail");
     // 	   how to capture screenshot when we send ss to senior through mail by using Base64 istead of File
     	  String src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64); //return type of Base64 is String
      	   		   ObjectRepo.test.addScreenCaptureFromBase64String(src);
      	
      	
   		
   	}
       public void onTestSkipped(ITestResult result) {
    	   ObjectRepo.test.log(Status.SKIP,"Test Case Skip");
   	}
	   public void onFinish(ITestContext context)    {
		// at the end we flush the report
		   extent.flush();
	}

	

	

	

	
	
	   

}
