package com.hybrid.framework.locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hybrid.framework.execution.Execution;

public class XpathLocator {

	// Re-usability of xpath element
	public static WebElement getXpathElement(String xpath){
		
		try{
		WebDriverWait Ww = new WebDriverWait(Execution.driver, 25);		
		return Ww.until(ExpectedConditions.visibilityOfElementLocated(((By.xpath(xpath)))));
		}catch(Exception e){
			
			
		}
		return null;
	}
	
	
	/*public static void WaitTime(long value) throws InterruptedException{
		Thread.sleep(value);
		
	}*/


	public static void WaitTime(long value) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(value);
	}
}