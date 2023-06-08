package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import net.bytebuddy.utility.RandomString;

public class ScreenshotCode {
	
	
	public static void getScreenshotAs(WebDriver driver) throws IOException {
		
		Date cd = new Date();
		String a = cd.toString().replaceAll(":", "");
		File s = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File d= new File("C:/Users/ADMIN/eclipse-workspace/sincerpay/Screenshots/"+driver.getTitle()+a +".png");
		FileUtils.copyFile(s, d);
	}
      
	}
	
	
	


