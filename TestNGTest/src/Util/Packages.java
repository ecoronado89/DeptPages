package Util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Packages {

	public static WebDriver driver;
	public static String baseUrl;
	public static String promocode;
	public static StringBuffer verificationErrors = new StringBuffer();

	
  @BeforeTest
  public void beforeTest() {
	  
		System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
		driver = new ChromeDriver(DesiredCapabilities.chrome());
		baseUrl = "http://ecwebs01.llbean.com/llb/shop/";
		promocode = "?pcd=HRB4MWV6G";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl + "82289" + promocode);
	  
  }
  
  @AfterTest
  public void afterTest() throws Exception {
	  
	  driver.quit();
	  String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	  
  }

private void fail(String verificationErrorString) {
	// TODO Auto-generated method stub
	
}

public static boolean isElementPresent(WebDriver driver, By by)
{
	try{
		driver.findElement(by);
		return true;
	} 
	catch(Exception e){
		return false;
	}
	
}
	
}
