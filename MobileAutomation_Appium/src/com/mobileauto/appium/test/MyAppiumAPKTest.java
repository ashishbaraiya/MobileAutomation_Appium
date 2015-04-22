package com.mobileauto.appium.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
 
public class MyAppiumAPKTest {
  
    AppiumDriver driver;
    DesiredCapabilities capabilities;
 
    @BeforeClass
    public void setUp() throws Exception {
      
        // set up appium
//        File appDir = new File("{pathApk file}");
//        File app = new File(appDir, "{APK file Name}"); //my case “demo1.apk”
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities = DesiredCapabilities.android();
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability(CapabilityType.VERSION, "5.0.1");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appPackage", "com.android.calculator2");  //my case com.gorillalogic.monkeytalk.demo1
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");  //my case RootActivity
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities) {
			
			public MobileElement scrollToExact(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			public MobileElement scrollTo(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
		};
    }
 
    @Test
    public void calculatorAppTest() throws Exception {
       //locate the Text on the calculator by using By.name()
       WebElement two=driver.findElement(By.name("2"));
       two.click();
       WebElement plus=driver.findElement(By.name("+"));
       plus.click();
       WebElement four=driver.findElement(By.name("4"));
       four.click();
       WebElement equalTo=driver.findElement(By.name("="));
       equalTo.click();
       
       WebElement results=driver.findElement(By.className("android.widget.EditText"));
       
    	//Check the calculated value on the edit box
    assert results.getText().equals("6"):"Actual value is : "+results.getText()+" did not match with expected value: 6";

    }

    @AfterClass
    public void teardown(){
    	//close the app
    	driver.quit();
    }    
    
}