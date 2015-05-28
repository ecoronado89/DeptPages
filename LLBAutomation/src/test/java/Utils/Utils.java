package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Utils {

	public static void moveTo(WebElement element, WebDriver driver) {
		Actions builder = new Actions(driver); 
		builder.moveToElement(element).perform();		
	}
	
	public static boolean iselementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);     
			return true;     
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean iselementPresent(WebElement element) {
		try {
			if(element.isDisplayed())     
				return true;     
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}
 
	 public static void manualPageRefresh(WebDriver driver){
		 driver.navigate().refresh();  
	 }
	 
	 public static void goToProductPage(WebDriver driver, String pageID){
		 driver.get(Constants.BASEURL+"/llb/shop/"+pageID);  
	 }
	 
	 public static void assertSoft(boolean success, String message, StringBuilder messages) {
		 if (!success) messages.append(message);
	 }

	 public static void isAssertEmpty(StringBuilder sb) {
		 if (sb.length() > 0) {
			 throw new AssertionError(sb.toString());
		 }
	 }

}
