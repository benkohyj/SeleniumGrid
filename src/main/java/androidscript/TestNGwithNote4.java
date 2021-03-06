//working codes for note4

package androidscript;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.testng.annotations.Test;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.net.URL;

import java.net.MalformedURLException;

import java.util.logging.Level;

public class TestNGwithNote4 {
  //static String reportDirectory = "reports";
 // static String reportFormat = "xml";
 // static String testName = "testname";

	
  private AndroidDriver<AndroidElement> driver2;

  DesiredCapabilities dc = new DesiredCapabilities();
  
  @BeforeMethod
  public void setUp() throws MalformedURLException {

   //   dc.setCapability("reportDirectory", reportDirectory);
    //  dc.setCapability("reportFormat", reportFormat);
   //   dc.setCapability("testName", testName);
	  dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\benkohyj\\AppData\\Roaming\\appiumstudio\\original-apks\\com.experitest.ExperiBank.LoginActivity.2.apk");
	 
//	Runtime runtime =  Runtime.getRuntime();
//	try {
//	  runtime.exec("cmd /c start \"\" C:\\Users\\benkohyj\\desktop\\setuphub.bat");
//	  runtime.exec("cmd /c start \"\" C:\\Users\\benkohyj\\desktop\\s4node.bat");
//	  runtime.exec("cmd /c start \"\" C:\\Users\\benkohyj\\desktop\\note4node.bat");

 //   	}
//	catch(IOException ioException)
//	{
//		System.out.println(ioException.getMessage() );
//	}
	
//For S4	     
	//      dc.setCapability("platformName", "Android");	     
	  //    dc.setCapability("platformVersion", "5.0.1");
	    //  dc.setCapability("udid", "4b816499");
   	     // dc.setCapability("deviceName", "Samsung S4");

//For Note4	     
       	 dc.setCapability("platformName", "Android");
         dc.setCapability("platformVersion", "6.0.1");
         dc.setCapability("udid", "4222c2db");
         dc.setCapability("deviceName", "Samsung Note4");
     	 
     
      dc.setCapability("automationName", "UiAutomator2");

      dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
      dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
      driver2 = new AndroidDriver<>(new URL("http://172.19.202.201:4444/wd/hub"), dc);
      driver2.setLogLevel(Level.INFO);

  } 
  
  
@Test
  public void Note4EriBank() {
	
	
	  driver2.rotate(ScreenOrientation.PORTRAIT);

	  driver2.hideKeyboard();


	  
	  driver2.findElement(By.id("com.experitest.ExperiBank:id/usernameTextField")).sendKeys("company");
	  driver2.findElement(By.id("com.experitest.ExperiBank:id/passwordTextField")).sendKeys("company");
	  driver2.findElement(By.id("com.experitest.ExperiBank:id/loginButton")).click();
	  new WebDriverWait(driver2, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("com.experitest.ExperiBank:id/makePaymentButton")));
      driver2.findElement(By.id("com.experitest.ExperiBank:id/makePaymentButton")).click();
      new WebDriverWait(driver2, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("com.experitest.ExperiBank:id/phoneTextField")));
      driver2.findElement(By.id("com.experitest.ExperiBank:id/phoneTextField")).sendKeys("0541234567");
      driver2.findElement(By.id("com.experitest.ExperiBank:id/nameTextField")).sendKeys("Jon Snow");
      driver2.findElement(By.id("com.experitest.ExperiBank:id/amountTextField")).sendKeys("50");
      driver2.findElement(By.id("com.experitest.ExperiBank:id/countryTextField")).sendKeys("Switzerland");
      driver2.findElement(By.id("com.experitest.ExperiBank:id/sendPaymentButton")).click();
      new WebDriverWait(driver2, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/button1")));
      driver2.findElement(By.id("android:id/button1")).click(); 

  }



  @AfterMethod
  public void tearDown() {
      driver2.quit();
  }
}