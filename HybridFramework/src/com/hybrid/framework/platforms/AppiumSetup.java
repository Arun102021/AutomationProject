/*package com.hybrid.framework.platforms;
import java.awt.RenderingHints.Key;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.hybrid.framework.execution.Keywords;

import com.hybrid.framework.execution.Execution;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

@SuppressWarnings("unused")
public class AppiumSetup  {
	@SuppressWarnings("rawtypes")
	public static void Mob() throws InterruptedException{
	 			// set up appium and tell from where it can install the apk file from
					// computer to device
					File appDir = new File("/home/naveennatarajan/Documents/Appium");
					File app = new File(appDir, "app-debug.apk");
					DesiredCapabilities capabilities = new DesiredCapabilities();
					capabilities.setCapability("appPackage", "com.tendercuts.app");        
			        capabilities.setCapability("appActivity", "com.tendercuts.app.MainActivity"); 
			        capabilities.setCapability("device", "Android");
					capabilities.setCapability("deviceName", "Redmi");
					capabilities.setCapability("platformName", "Android");
					capabilities.setCapability("platformVersion", "7.1");
					capabilities.setCapability("app", app.getAbsolutePath());
					try {
						Execution.driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}
					Execution.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	System.out.println("Port executed");
				
        System.out.println("Login Page Started");
        ((AppiumDriver) Execution.driver).context("WEBVIEW_com.tendercuts.app");
        Thread.sleep(10000);
        WaitAndClick(".//ion-content/div[2]/ion-card[1]/ion-grid/a");
        WaitAndSendKeys("//*[@id='username']/input", "9176669888");
        WaitAndSendKeys("//*[@id='password']/input", "naveen111");
        WaitAndClick("//button[@id='login-submit']");
        WaitAndClick("//*[@id='inbound-address-0']");
        WaitAndClick("//*[@id='tab-t5-0']/ion-icon");
        WaitAndClick("//*[@id='tab-t5-1']/ion-icon");
        WaitAndClick("//*[@id='tab-t5-2']/ion-icon");
        WaitAndClick("//*[@id='tab-t5-3']/ion-icon");
        System.out.println("Framework Started");
        Thread.sleep(7000);
        }
	
	public static void WaitAndClick(String xpath)	 {
		try {
			Keywords.initilizaeWait(Execution.driver);
			Keywords.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			Execution.driver.findElement(By.xpath(xpath)).click();
		} catch (NoSuchElementException e) {
			System.out.println("Timeout Error or Element Not Available");
			e.printStackTrace();
		}
		}
	public static void WaitAndSendKeys(String xpath, String value)	 {
		try {
			Keywords.initilizaeWait(Execution.driver);
			Keywords.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			Execution.driver.findElement(By.xpath(xpath)).sendKeys(value);
		} catch (NoSuchElementException e) {
			System.out.println("xpath not available");
			e.printStackTrace();
		}
	  }
	} 
*/