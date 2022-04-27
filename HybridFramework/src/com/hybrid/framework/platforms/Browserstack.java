package com.hybrid.framework.platforms;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.hybrid.framework.execution.Execution;

import java.net.MalformedURLException;
import java.net.URL;

public class Browserstack {
  	
  //public static final String OS = "Windows";
  //public static final String Browser = "Chrome";
  //public static final String verison = "62.0";
  public static final String USERNAME = "USERNAME";
  public static final String AUTOMATE_KEY = "ACCESS_KEY";
  public static final String URL = "https://" + "naveen426" + ":" + "btLu5D578jh47irq2s3e" + "@hub-cloud.browserstack.com/wd/hub";
  
  public static void windowsChrome() throws MalformedURLException {
    
    DesiredCapabilities caps = new DesiredCapabilities();
    
    caps.setCapability("os", "Windows");
    caps.setCapability("browser", "Chrome");
    caps.setCapability("browser_version", "67.0");
    caps.setCapability("os_version", "10");
    caps.setCapability("resolution", "1024x768");
    caps.setCapability("browserstack.debug", "true");
    
    Execution.driver = new RemoteWebDriver(new URL(URL), caps);
    Execution.driver.get("https://testrmsid.com/v44");
    /*WebElement element = driver.findElement(By.name("q"));
    element.sendKeys("BrowserStack");
    element.submit();
    System.out.println(driver.getTitle());
    driver.quit();*/
    
  }
  public static void windowsFirefox() throws MalformedURLException {
	    
	    DesiredCapabilities caps = new DesiredCapabilities();
	    
	    caps.setCapability("os", "Windows");
	    caps.setCapability("browser", "Firefox");
	    caps.setCapability("browser_version", "60.0");
	    caps.setCapability("os_version", "10");
	    caps.setCapability("resolution", "1024x768");
	    caps.setCapability("browserstack.debug", "true");
	    
	    Execution.driver = new RemoteWebDriver(new URL(URL), caps);
	    Execution.driver.get("https://testrmsid.com/v44");
	    
	  }
  public static void windowsIE() throws MalformedURLException {
	    
	    DesiredCapabilities caps = new DesiredCapabilities();
	    
	    caps.setCapability("os", "Windows");
	    caps.setCapability("browser", "IE");
	    caps.setCapability("browser_version", "11.0");
	    caps.setCapability("os_version", "10");
	    caps.setCapability("resolution", "1024x768");
	    caps.setCapability("browserstack.debug", "true");
	    
	    Execution.driver = new RemoteWebDriver(new URL(URL), caps);
	    Execution.driver.get("https://testrmsid.com/v44");
	    
	  }
  public static void macSafari() throws MalformedURLException {
	    
	    DesiredCapabilities caps = new DesiredCapabilities();
	    
	    caps.setCapability("os", "OS X");
	    caps.setCapability("browser", "Safari");
	    caps.setCapability("browser_version", "11.0");
	    caps.setCapability("os_version", "High Sierra");
	    caps.setCapability("resolution", "1024x768");
	    caps.setCapability("browserstack.debug", "true");
	    
	    Execution.driver = new RemoteWebDriver(new URL(URL), caps);
	    Execution.driver.get("https://testrmsid.com/v44");
	    
	  }
  public static void macChrome() throws MalformedURLException {
	    
	    DesiredCapabilities caps = new DesiredCapabilities();
	    
	    caps.setCapability("os", "OS X");
	    caps.setCapability("browser", "Chrome");
	    caps.setCapability("browser_version", "67.0");
	    caps.setCapability("os_version", "High Sierra");
	    caps.setCapability("resolution", "1024x768");
	    caps.setCapability("browserstack.debug", "true");
	    
	    Execution.driver = new RemoteWebDriver(new URL(URL), caps);
	    Execution.driver.get("https://testrmsid.com/v44");
	    
	  }
  public static void macOpera() throws MalformedURLException {
	    
	    DesiredCapabilities caps = new DesiredCapabilities();
	    
	    caps.setCapability("os", "OS X");
	    caps.setCapability("browser", "Opera");
	    caps.setCapability("browser_version", "12.15");
	    caps.setCapability("os_version", "High Sierra");
	    caps.setCapability("resolution", "1024x768");
	    caps.setCapability("browserstack.debug", "true");
	    
	    Execution.driver = new RemoteWebDriver(new URL(URL), caps);
	    Execution.driver.get("https://testrmsid.com/v44");
	    
	  }
  public static void macFirefox() throws MalformedURLException {
	    
	    DesiredCapabilities caps = new DesiredCapabilities();
	    
	    caps.setCapability("os", "OS X");
	    caps.setCapability("browser", "Firefox");
	    caps.setCapability("browser_version", "60.0");
	    caps.setCapability("os_version", "High Sierra");
	    caps.setCapability("resolution", "1024x768");
	    caps.setCapability("browserstack.debug", "true");
	    
	    Execution.driver = new RemoteWebDriver(new URL(URL), caps);
	    Execution.driver.get("https://testrmsid.com/v44");
	    
	  }
  public static void Win7IE() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability("os", "Windows");
	  caps.setCapability("os_version", "7");
	  caps.setCapability("browser", "IE");
	  caps.setCapability("browser_version", "11.0");
	  caps.setCapability("resolution", "1024x768");
	  caps.setCapability("browserstack.debug", "true");
	    
	    Execution.driver = new RemoteWebDriver(new URL(URL), caps);
	    Execution.driver.get("https://testrmsid.com/v44");
	    
	  }
  
  
}