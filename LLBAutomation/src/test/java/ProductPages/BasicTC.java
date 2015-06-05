package ProductPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.specification.RequestSpecification;

import Utils.Utils;

public class BasicTC extends TestCase{
	private RequestSpecification requestSpecification;//DO NOT MOVE THIS
	
	@Test (groups = {"smoke"})
	public void verifyCurrentPage()
	{
		StringBuilder verifyResults = new StringBuilder();

		//Utils.goToProductPage((WebDriver)driver, "32711");
		
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
		WebElement heroImage = driver.findElementByXPath("id('backImageSjElement4_img')");
        
		String source = heroImage.getAttribute("src"); 
		Assert.assertEquals(requestSpecification.get(source).getStatusCode(), 200, "Hero Image is not being displayed");
		
		driver.findElementByXPath("(id('ppAlternateViews')//a)[2]").click();
		
		Assert.assertEquals(driver.findElementByXPath("id('backImageSjElement4_img')").getAttribute("src"), source, "Alternative View is not being displayed");
		
		
		
		
		
		
		
		//Assert.assertEquals(get(source).getStatusCode(), 200);
		
		
		
        /*Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
        Assert.assertTrue(ImagePresent, "Hero Image is not present on page ");*/
        
        
        /*http://www.hascode.com/2011/10/testing-restful-web-services-made-easy-using-the-rest-assured-framework/
        Response res = get("/service/single-user");
        assertEquals(200, res.getStatusCode());
        
        */
	}
}
