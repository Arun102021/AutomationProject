package com.hybrid.framework.platforms;

import static com.hybrid.framework.reports.Reports.*;
import static com.hybrid.framework.execution.Execution.*;
import static com.hybrid.framework.platforms.Browserstack.*;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.hybrid.framework.execution.Execution;

@SuppressWarnings("unused")
public class Browsers {
	
	public static void Browser() throws BiffException, IOException, WriteException, MalformedURLException, InterruptedException {
		
		// Read the exist input file and create the output result for test-cases
			
		try{
			wbook = Workbook.getWorkbook(new File("Testinput/V5Beta-1.xls"));  
			wwbCopy = Workbook.createWorkbook(new File("Test-result/Test_Result.xls"), wbook);   
			shSheet = wwbCopy.getSheet(1);
		   } catch (Exception e) {
		     	 e.printStackTrace();
		   }
		System.out.println("******Testcases Started******");
				
		// Get the method name from Parameterization class for browser
			
			String browser = getContent(Filepath, SheetName, "Browser", 1);
			if(browser.equalsIgnoreCase("Firefox")){
		    
			// Set firefox profile
			ProfilesIni ini = new ProfilesIni();
			FirefoxProfile fp = ini.getProfile("default");
			//System.setProperty("webdriver.gecko.driver","Users/arunsubramani/Downloads/HybridFramework 2/Drivers/chromedriver");
			System.setProperty("webdriver.gecko.driver","Drivers/geckodriver");
			//fp.setPreference("http.proxyHost", "10.200.1.3");
			//fp.setPreference("http.proxyPort", "3128");
			driver = new FirefoxDriver(fp);
			String fSize = getContent(Filepath, SheetName, "Dimension", 1);
			
			Dimension fDmn = new Dimension(Integer.valueOf(fSize.split("\\*")[0]), Integer.valueOf(fSize.split("\\*")[1]));
			Execution.driver.manage().window().setSize(fDmn);
			
		// Get the method name from Parameterization class for URL
			String statusCode = getContent(Filepath, SheetName, "URL", 1);
			Execution.driver.get(statusCode);	
			URL code = new URL(statusCode);
			
		// To set the status for test link
		try{	
			HttpURLConnection http = (HttpURLConnection)code.openConnection();
			int status = http.getResponseCode();
			if(status>=400 || status>=500){
				setXLValues("configuration", 3, 1, "Fail");
				setXLValues("configuration", 4, 1, String.valueOf(status));
				
			} else
			 {			
			setXLValues("configuration", 4, 1, String.valueOf(status));
			setXLValues("configuration", 3, 1, "Pass");
			 }
			
			}catch (Exception e){
				e.printStackTrace();
				}
		 } 		
		// Chrome driver platform
		
		else if(browser.equalsIgnoreCase("chrome"))
		{			
			//System.setProperty("http.proxyHost", "10.200.1.3");
			//System.setProperty("http.proxyPort", "3128");
			System.setProperty("webdriver.chrome.driver" , "Drivers/chromedriver 3" );
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--test-type");
			//option.addArguments("--disable-dev-shm-usage");
			//option.addArguments("--no-sandbox");
			//option.setExperimentalOption("useAutomationExtension", false);
			//option.addArguments("--headless");
			option.addArguments("--window-size=1368,768");
			
			//option.addArguments("--disable-gpu");
			//option.addArguments("--screenshot");

			driver = new ChromeDriver(option);
			DesiredCapabilities dc = DesiredCapabilities.chrome();
			dc.setCapability(ChromeOptions.CAPABILITY, option);
			//driver = new RemoteWebDriver(new URL("http://ogone.rmsid.com:9515"), dc);
			String cSize = getContent(Filepath, SheetName, "Dimension", 1);
			Dimension dmn = new Dimension(Integer.valueOf(cSize.split("\\*")[0]), Integer.valueOf(cSize.split("\\*")[1]));
			Execution.driver.manage().window().setSize(dmn);
			
			String statusCodechrome = getContent(Filepath, SheetName, "URL", 1);
			Execution.driver.get(statusCodechrome);
			URL codeChrome = new URL(statusCodechrome);
			try{
				HttpURLConnection http = (HttpURLConnection)codeChrome.openConnection();
				int status = http.getResponseCode();
				if(status>=400 || status>=500){
					setXLValues("configuration", 3, 1, "Fail");
					setXLValues("configuration", 4, 1, String.valueOf(status));
					
				} else
				 {			
				setXLValues("configuration", 4, 1, String.valueOf(status));
				setXLValues("configuration", 3, 1, "Pass");
				 }
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		// Browser Stack Integration:			
		// Internet explorer driver platform
				
		else if(browser.equalsIgnoreCase("BS-Windows-Chrome"))
		{
			/*System.setProperty("webdriver.ie.driver", "Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			Execution.driver.manage().window().maximize();
			Execution.driver.get(getContent(Filepath, SheetName, "URL", 1));*/
			Browserstack.windowsChrome();
		}	
		//else if(browser.equalsIgnoreCase("Mobile"))
		//{AppiumSetup.Mob();}
		
		else if(browser.equalsIgnoreCase("BS-Windows-Firefox"))
		{Browserstack.windowsFirefox();}
			
		else if(browser.equalsIgnoreCase("BS-Windows-IE"))
		{Browserstack.windowsIE();}	
			
		else if(browser.equalsIgnoreCase("BS-Mac-Safari"))
		{Browserstack.macSafari();}	
			
		else if(browser.equalsIgnoreCase("BS-Mac-Chrome"))
		{Browserstack.macChrome();}		
		
		else if(browser.equalsIgnoreCase("BS-Mac-Firefox"))
		{Browserstack.macFirefox();}
			
		else if(browser.equalsIgnoreCase("BS-Mac-Opera"))
		{Browserstack.macChrome();}
		
		else if(browser.equalsIgnoreCase("BS-Win7-IE"))
		{Browserstack.Win7IE();}
			
			
	}		
}									