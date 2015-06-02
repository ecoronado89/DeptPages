package com.TestNGTest;


import java.util.List;
import java.util.Random;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//import org.testng.Assert;

public class TestNGTest extends Util.Packages {
	
	Boolean Available = false;
  
 @Test 
public void ValidatePromo(){
	  
	try{  
		
		List<WebElement> Swatches = driver.findElements(By.xpath("//*[@id='colorSwatchContainer0_0_0']/ul/li"));
		
		
		
		
			 Random rand = new Random();
			 	int randomNum;
			    randomNum = rand.nextInt((Swatches.size()));
			    
			    System.out.println(randomNum);
			    driver.findElement(By.xpath("//*[@id='colorSwatchContainer0_0_0']/ul/li["+randomNum+"]")).click();
			    driver.findElement(By.xpath("//*[@id='attrSwatchContainer0_0_0']/ul/li[1]")).click();
			    driver.findElement(By.xpath("id('ppAddToBagBtn_0')")).click();
			    AddToSB();

			
		WebElement Temp = driver.findElement(By.xpath("//*[@id='alternateProductPage']/div[4]/div[2]/div[4]/div/button[2]"));
		Temp.click();
			
		} catch (Error e){
		  verificationErrors.append(e.toString());
		}
  }
 
 public void AddToSB(){
	 try{
		 Available = Util.Packages.isElementPresent(driver, By.xpath("//*[@id='alternateProductPage']/div[4]/div[2]/div[1]/div/div/ul/li[4]/div/strong"));
		 if(Available = true)
			 System.out.println("Promo applied");
		 else
			 System.out.println("Promo not applied");
	 }catch(Error e){
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
			System.out.println("Product Name: " + HName);
		else
			System.out.println("INVALID NAME");
	}
	catch (Error e){
	  verificationErrors.append(e.toString());
	}
}


@Test
public void SizeChart(){
	
	@SuppressWarnings("unused")
	Boolean X = false;
	X = Util.Packages.isElementPresent(driver, By.xpath("//*[@id='attrStchContainer0_0_0']/a"));
	
	try{
		
		if(X = true)
		{
			System.out.println("Size Chart present");
		}
		else{
			System.out.println("Size Chart Unavailable");
		}
	}
	catch (Error e){
	  verificationErrors.append(e.toString());
	}
}
   
}
