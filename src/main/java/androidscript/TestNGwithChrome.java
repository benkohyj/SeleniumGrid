//working codes for google chrome
package androidscript;

import org.testng.annotations.Test;

import java.io.IOException;
//the codes below is for browser using testng
import java.net.MalformedURLException;
import java.net.URL;

//import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGwithChrome {
	
	
	static WebDriver driver1;
	static String nodeUrl;
	
	@BeforeTest
	public void SetUp() throws MalformedURLException
	
	{
	/*	Runtime runtime =  Runtime.getRuntime();
		try {
		  runtime.exec("cmd /c start \"\" C:\\Users\\benkohyj\\desktop\\setuphub.bat");
		  runtime.exec("cmd /c start \"\" C:\\Users\\benkohyj\\desktop\\chromenode.bat");

	    	}
		catch(IOException ioException)
		{
			System.out.println(ioException.getMessage() );
		} */
		nodeUrl = "http://172.19.202.201:4444/wd/hub";
		 
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		driver1 = new RemoteWebDriver(new URL(nodeUrl), capabilities);
		capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
		capabilities.setCapability(CapabilityType.PLATFORM, Platform.ANY);

	}
	
	@Test
	public void Test1()
	
	{
		
		driver1.manage().deleteAllCookies();
		driver1.get("https://www.google.com/");
		driver1.manage().window().maximize();
		driver1.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("sph");
		driver1.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div[2]/div[2]/center/input[1]")).click();


	}
	
	@AfterTest
	public void EndWork()
	
	{  

		driver1.quit();
	}

}
