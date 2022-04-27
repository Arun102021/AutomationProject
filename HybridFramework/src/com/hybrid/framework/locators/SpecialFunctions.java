package com.hybrid.framework.locators;
//import static com.hybrid.framework.execution.Execution.driver;
import static com.hybrid.framework.reports.Reports.sdf;
import static org.junit.Assert.fail;
import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.hybrid.framework.execution.Execution;
import com.hybrid.framework.reports.Reports;


@SuppressWarnings("unused")
public class SpecialFunctions {
	static String startTimes = sdf.format(new Date().getTime());
	static String endTimes =null;
	
	//private Browser
public static void cprivateb(String value)throws InterruptedException, AWTException{
        
       // Execution.driver.quit();
	   System.setProperty("webdriver.chrome.driver" , "Drivers/chromedriver 3" );
       
       DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options1 = new ChromeOptions();
       options1.addArguments("-incognito");
       capabilities.setCapability(ChromeOptions.CAPABILITY, options1); 
       
       Execution.driver = new ChromeDriver(capabilities);
       Execution.driver.manage().window().maximize();
	   	  
       Execution.driver.get(value);
}	   	
	   	
	// Re-usability of xpath element
	public static void srollelementview(String xpath) throws RowsExceededException, WriteException, InterruptedException 	{
		WebElement element = Execution.driver.findElement(By.xpath(xpath));
		((JavascriptExecutor) Execution.driver).executeScript("arguments[0].scrollIntoView(true);", element);
		}
	public static void end(String xpath)	{
		Execution.driver.findElement(By.xpath(xpath)).sendKeys(Keys.END);
		}
	public static void enterbutton(String xpath)	{
		
		Execution.driver.findElement(By.xpath(xpath)).sendKeys(Keys.RETURN);
		}
	
	public static void rightarrow(String xpath, String value) throws InterruptedException{
		for (int i = 0; i < Integer.valueOf(value); i++){
		Execution.driver.findElement(By.xpath(xpath)).sendKeys(Keys.ARROW_RIGHT);
		 //wait 200 milli second
		  Thread.sleep(200);
		} }		
	public static void downarrow(String xpath, String value) throws InterruptedException{
		for (int i = 0; i < Integer.valueOf(value); i++){
		Execution.driver.findElement(By.xpath(xpath)).sendKeys(Keys.ARROW_DOWN);
		 //wait 200 milli second
		  Thread.sleep(200);
		} }	
	
	public static String generateRandomString(int length){
			return RandomStringUtils.randomAlphabetic(length);
		 }
	public static String generateRandomNumber(int length){
		  return RandomStringUtils.randomNumeric(length);
		 }
	public static void clickmultiple(String xpath, String values) throws InterruptedException{
		for (int i = 0; i < Integer.valueOf(values); i++){
		 //click the button
		  Execution.driver.findElement(By.xpath(xpath)).click();
		 //wait 200 milli second
		  Thread.sleep(200);
		  //check that data is being generated correctly
		}
		}
	public static String generateEmail(int length) {
		  String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
		    "1234567890" +   //numbers
		    "_-.";   //special characters
		  String email="";
		  String temp=RandomStringUtils.random(length,allowedChars);
		  email=temp.substring(0,temp.length()-9)+"@mrms.com";
		  return email;
		 }
	
	public static String generateCombination(int length) {
		  String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
				    "1234567890" +   //numbers
				    "!@#$%^&*()_-.";   //special characters
		  String comb="";
		  String temp=RandomStringUtils.random(length,allowedChars);
		  comb=temp.substring(0,temp.length());
		  return comb;
		 }
	
	public static String generateSpecialChar(int length) {
		  String allowedChars="!@#$%^&*()_-.";   //special characters
		  String comb="";
		  String temp=RandomStringUtils.random(length,allowedChars);
		  comb=temp.substring(0,temp.length());
		  return comb;
		 }
	/*public static void Backspace(String xpath,int rows){
		java.util.List<WebElement> e= Execution.driver.findElements(By.xpath(xpath));
		for (WebElement ele:e) {
		ele.sendKeys(Keys.BACK_SPACE);
		}
		}	*/
	public static void captureScreenShot(String filePath) {
		File screenshot = ((TakesScreenshot)Execution.driver).getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(screenshot, new File(Reports.filePath));
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} 
		}
	
	public static void Backspace(String xpath, String value) throws InterruptedException{
        for (int i = 0; i < Integer.valueOf(value); i++){
        Execution.driver.findElement(By.xpath(xpath)).sendKeys(Keys.BACK_SPACE);
         //wait 200 milli second
          //Thread.sleep(200);
        } }      
	public static void clickall(String xpath){
		java.util.List<WebElement> e= Execution.driver.findElements(By.xpath(xpath));
		for (WebElement ele:e) {
		ele.click();
		}
		}
	public static void cbs(String xpath){
	java.util.List<WebElement> cb1= Execution.driver.findElements(By.xpath(xpath));
	endTimes = sdf.format(new Date().getTime());
	
	if(((WebElement) cb1).isSelected())
		for (WebElement ele:cb1) {
			ele.click();
			}
	}
	
}