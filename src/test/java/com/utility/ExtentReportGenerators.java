package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGenerators {
	/*we are using 3 classes of extentreports like ExtentSparkReporter,
	 * ExtentReport and ExtendText*/
	// all methods are static
	public static ExtentReports extent;
	public static ExtentReports getExtentReports() {
		String path = "C:\\Users\\ADMIN\\eclipse-workspace\\sincerpay\\ExtetReports\\index.html";
	// ExtentSparkReporter is responsible for document title, theme, report name
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Excecution Report");
		reporter.config().setReportName("Automation Report");
		reporter.config().setTheme(Theme.DARK);
		
	// extentreport extentsparkreport reference by using extent report
	// all information are set like system name, tester name, browser name
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Device name", "Dell");
		extent.setSystemInfo("Automation Engineer", "Aniket");
		extent.setSystemInfo("Environment", "Stage");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("OS", "Windows11" );
		return extent;
	}
	
	
	

}
