package com.mobileauto.appium.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;


//used to verify if URL is malformed
import java.net.MalformedURLException;

//library used to create URL for the Appium server
import java.net.URL;

//library used to create the path to APK
import java.io.File;




//library used to find elements (by id, class, xpath etc)
import org.openqa.selenium.By;

//library for web element
import org.openqa.selenium.WebElement;

//libraries for configuring Desired Capabilities
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
//library for test methods
import org.junit.*;

//library for Appium drivers
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

@Test
public class MyAppiumWebTest {
	
//	File classpathRoot = new File(System.getProperty("user.dir")); // path to Eclipse project
//	File appDir = new File(classpathRoot, "/lib"); // path to <project folder>/Contact Manager
//	File app = new File(appDir, "Chrome.apk");
	AndroidDriver driver;
	DesiredCapabilities capabilities;
	
	@BeforeClass
	public void setup() throws MalformedURLException
	{
		capabilities = new DesiredCapabilities();
		
		//Name of mobile web browser to automate. Should be an empty string if automating an app instead.
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		
		capabilities.setCapability("automationName", "Appium");
		
		//which mobile OS to use: Android, iOS or FirefoxOS
		capabilities.setCapability("platformName", "Android");

		//Mobile OS version – in this case 4.4 since my device is running Android 4.4.2
		capabilities.setCapability(CapabilityType.VERSION, "5.0.1");

		//device name – since this is an actual device name is found using ADB
//		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("deviceName", "Android Emulator");

//		//the absolute local path to the APK
//		capabilities.setCapability("app", app.getAbsolutePath());
//
//		//Java package of the tested Android app
//		capabilities.setCapability("appPackage", "com.example.android.contactmanager");
//
//		// activity name for the Android activity you want to run from your package. This need to be preceded by a . (example: .MainActivity)
//		capabilities.setCapability("appActivity", ".ContactManager");

		// constructor to initialize driver object
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
	}
	
//	@Test
//	public void firstAppiumTest() throws InterruptedException
//	{
//		driver.get("https://in.yahoo.com/?p=us");
//		Thread.sleep(5000);
//		driver.findElement(By.linkText("Tap to install")).click();
//	}
	
	@Test
	public void secondAppiumTest() throws InterruptedException
	{
		  driver.get("https://www.google.com");
	  	  WebElement element1 = driver.findElement(By.name("q"));
	  	  element1.click();
	  	  element1.sendKeys("This is my MobileWeb Automation.");
	  	  Thread.sleep(5000);
	  	  driver.findElement(By.name("btnG")).click();
	  	  Thread.sleep(10000);
	  	  driver.findElement(By.xpath(".//*[@id='rso']/descendant::a[1]")).click();
	  	  Thread.sleep(10000);
	  	  AssertJUnit.assertEquals(driver.getTitle(), "The Basics Of Test Automation For Apps, Games, Mobile Web");
	}
	
	@AfterClass
	public void tearDown() throws MalformedURLException
	{
	  	  driver.quit();
	}

}