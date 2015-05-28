package com.TestNGTest;


import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;

public class TestNGTest extends Util.Packages {
	
	Boolean Available = false;
  
 @Test 
public void ValidatePromo(){
	  
	try{  
			  	
		driver.findElement(By.xpath("id('swatch1_0_0')")).click();
		driver.findElement(By.xpath("id('ShoeSize1_0_0')")).click();
		driver.findElement(By.xpath("id('ppAddToBagBtn_0')")).click();	   	  
	
		WebElement Temp = driver.findElement(By.xpath("//*[@id='alternateProductPage']/div[4]/div[2]/div[4]/div/button[2]"));
		Temp.click();

				
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
