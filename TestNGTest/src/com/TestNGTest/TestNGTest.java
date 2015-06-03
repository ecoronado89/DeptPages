package com.TestNGTest;


import java.util.List;
import java.util.Random;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


//import org.testng.Assert;

public class TestNGTest extends Util.Packages {
	
	Boolean Available = false;
  
 @Test 
public void ValidatePromo(){
	  
	try{  
		
		List<WebElement> Swatches = driver.findElements(By.xpath("//*[@id='colorSwatchContainer0_0_0']/ul/li"));
		List<WebElement> Sizes = driver.findElements(By.xpath("//*[@id='attrSwatchContainer0_0_0']/ul/li"));
	
		Boolean OOS = true;
		Boolean SOOS = true;
		
	while(OOS == true && SOOS == true)
	{
	
		int randomSwatch = Random(Swatches.size());
		String ValSwatch = driver.findElement(By.xpath("//*[@id='swatch"+randomSwatch+"_0_0']")).getAttribute("msg");
			
	   	if(ValSwatch.equalsIgnoreCase("Sold Out Online"))
	   	     OOS = true;
		else 
	   	{
			randomSwatch = randomSwatch+1;
	   		driver.findElement(By.xpath("//*[@id='colorSwatchContainer0_0_0']/ul/li["+randomSwatch+"]/a")).click();
	   		
	   		int randomSize = Random(Sizes.size());
			String ValSize = driver.findElement(By.xpath("//*[@id='Size"+randomSize+"_0_0']")).getAttribute("msg");
			
			if(ValSize.equalsIgnoreCase("Sold Out Online"))
		  		SOOS = true;  	
		  	else 
		  	{
		  		randomSize = randomSize+1;
		  		driver.findElement(By.xpath("//*[@id='attrSwatchContainer0_0_0']/ul/li["+randomSize+"]")).click();
		  		SOOS = false;
		  	}
			OOS = false;
	   	}
    }	  
			    			    
			    driver.findElement(By.xpath("id('ppAddToBagBtn_0')")).click();
			    AddToSB();

			
		driver.findElement(By.xpath("//*[@id='alternateProductPage']/div[4]/div[2]/div[4]/div/button[2]")).click();
		
		ShoopingBag();
			
		} catch (Error e){
		  verificationErrors.append(e.toString());
		}
  }

 public void AddToSB(){
	
	try{
		String dscnt = driver.findElement(By.xpath("//*[@id='alternateProductPage']/div[4]/div[2]/div[1]/div/div/ul/li[5]/span")).getAttribute("class");
		if(dscnt.equalsIgnoreCase("CO_SB_ItemPriceRedline"))
			System.out.println("Item Price with discount");
		else
			System.out.println("Promo not applied");
			
	} catch(NoSuchElementException n){
			verificationErrors.append(n.toString());
	}	
 }
 
 public void ShoopingBag()
 {
	 List<WebElement> SBItems = driver.findElements(By.xpath("//*[@id='sb_ShoppingBagItems']"));
	 System.out.println(SBItems.size());
	 for(int count = 0; count < SBItems.size(); count++)
	 {
		 int item = count+1;
		 String YouSave = driver.findElement(By.xpath("//*[@id='sb_ShoppingBagItem_"+item+"']/div/div[2]/div/div[1]/div[2]/div[3]/span[2]")).getAttribute("class");
		 if(YouSave.equalsIgnoreCase("wlsb_savingsMessage"))
		 	 System.out.println("Saving Price Message");
		 
		 else
			 System.out.println("Saving Price Message not displayed");
	 }																	
	
 }
//*[@id="sb_ShoppingBagItem_1"]/div/div[2]/div/div[1]/div[2]/div[3]/span[2]
//*[@id="sb_ShoppingBagItem_2"]/div/div[2]/div/div[1]/div[2]/div[3]/span[2]
//*[@id="sb_ShoppingBagItem_3"]/div/div[2]/div/div[1]/div[2]/div[3]/span[2]
 
 
 /*
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
  */ 
public int Random(int rand)
{
	 Random random = new Random();
	 int randomNum = random.nextInt(rand);
	 return randomNum;
}	


}
