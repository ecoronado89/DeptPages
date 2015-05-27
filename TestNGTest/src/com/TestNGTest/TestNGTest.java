package com.TestNGTest;


import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestNGTest extends Util.Packages {
	
	Boolean Available = false;
  
 @Test 
public void main(){
	  
	try{  
			  	
		driver.findElement(By.xpath("id('swatch1_0_0')")).click();
		driver.findElement(By.xpath("id('ShoeSize1_0_0')")).click();
		driver.findElement(By.xpath("id('ppAddToBagBtn_0')")).click();
	   
		  
		
		Available = Util.Packages.isElementPresent(driver, By.xpath("id('ui-dialog-title-1')"));
		
		if(Available = true)
		{
		  System.out.println("ELEMENT FIND");

		}
		else{
		  System.out.println("ELEMENT NOT FIND"); 
		}
				
		} catch (Error e){
		  verificationErrors.append(e.toString());
		}
  }

@Test
public void ValidName(){
	
	Available = Util.Packages.isElementPresent(driver, By.xpath("id('ppName')"));
	WebElement Name = driver.findElement(By.xpath("id('ppName')"));
	String HName = Name.getText();
	try{
		
		if(Available = true)
		{
			System.out.println("VALID NAME FIND: " + HName);
		}
		else{
			System.out.println("INVALID NAME");
		}
	}
	catch (Error e){
	  verificationErrors.append(e.toString());
	}
}

@Test
public void SizeChart(){
	
	Available = Util.Packages.isElementPresent(driver, By.xpath("id('attrSwatchContainer0_0_0')"));
	
	try{
		
		if(Available = true)
		{
			System.out.println("SIZE CHART AVAILABLE");
		}
		else{
			System.out.println("SIZE CHART UNAVAILABLE");
		}
	}
	catch (Error e){
	  verificationErrors.append(e.toString());
	}
}
   
}
