package ProductPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import Utils.Utils;

public class BasicTC extends TestCase{

	
	@Test (groups = {"smoke"})
	public void verifyCurrentPage()
	{
		StringBuilder verifyResults = new StringBuilder();

		Utils.goToProductPage((WebDriver)driver, "32711");
		
		//if page is available
		Utils.assertSoft(!driver.getTitle().equalsIgnoreCase("L.L.Bean: Page Not Available"), "The Page is currently NOT AVAILABLE", verifyResults);	
		
		//if page is a product page
		Utils.assertSoft(Utils.iselementPresent(driver, By.id("alternateProductPage")), "Current page is Not a Product Page", verifyResults);
	
		
		/*TODO
		 * falta validacion sold out
		 * product name
		 * tabs
		 * swatches
		 * imagenes
		 */
		
		
		Utils.isAssertEmpty(verifyResults);
	}
	
	@Test (groups = {"smoke"}, dependsOnMethods = {"verifyCurrentPage"})
	private void verifyImages()
	{	

		Utils.goToProductPage((WebDriver)driver, "32711");
		WebElement ImageFile = driver.findElement(By.xpath("//img[@id='backImageSjElement4_img']"));
        
        Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
        Assert.assertTrue(ImagePresent, "Hero Image is not present on page ");
	}
}
