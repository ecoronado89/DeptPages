package ProductPages;

import java.util.concurrent.TimeUnit;
import java.util.Properties;
import java.io.FileInputStream;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Utils.Constants;

public class TestCase {
	protected FirefoxDriver driver;
	
	@BeforeSuite (alwaysRun = true)
	@Parameters({"automationfile"})
	public void initFramework(@Optional("automation.properties") String configfile) throws Exception 
	{
		Properties p = new Properties();
		FileInputStream  conf = new FileInputStream(configfile);
		p.load(conf);

		Constants.setDefaultTimeOut((byte) Integer.parseInt(p.getProperty( "DEFAULTTIMEOUT" ).toString()));
		Constants.setBaseURL(p.getProperty( "BASEURL" ).toString());
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{	
		driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().addCookie(new Cookie("LLBUSONLY", "value"));
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.DEFAULTTIMEOUT, TimeUnit.SECONDS);
		driver.get(Constants.BASEURL);
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException 
	{
		driver.close();
		driver.quit();
	}	
}