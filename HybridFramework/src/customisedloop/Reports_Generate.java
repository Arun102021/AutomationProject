//package customisedloop;
//
//public class Reports_Generate {
//
//}



	package customisedloop;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reports_Generate {
	public static String driverPath = "Drivers/chromedriver 3";
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static <IWebElement> void main(String[] args) throws InterruptedException {
		Login();
		
		//EXCEL
		for(int v=1;v<25;++v){
				if((v>18 && v<21)) {
					continue;
			}
			driver.navigate().to("https://v5tp.testrmsid.com/#/app/reporting/action/list/reportId/" + v + "");
		
			System.out.println(v);
			Thread.sleep(1000);
			//Check All
			if ( !driver.findElement(By.xpath(".//*[@id='checkAll']")).isSelected() )
			{    driver.findElement(By.xpath(".//*[@id='checkAll']")).click();}
			
			     WebElement output = driver.findElement(By.xpath(".//*[@id='Format']")); 
				 JavascriptExecutor scroll = (JavascriptExecutor)driver;
				 scroll.executeScript("arguments[0].click();", output);	
				 Select Output= new Select(driver.findElement(By.xpath(".//*[@id='Format']")));
				 Output.selectByVisibleText("EXCEL");
				 //date created
				 try {
				 Select Date= new Select(driver.findElement(By.xpath(".//*[@id='DateCreated']")));
				 Date.selectByVisibleText("Last Fourteen Days");	}
				 catch(Exception e)
					{System.out.println("There is no Date Created");	}
				 //Nexus
				 try {
					 driver.findElement(By.xpath(".//*[@id='search_nexus_id']")).sendKeys("1");
					 driver.findElement(By.xpath(".//*[@id='frmReport']/div/div[2]/div/div[2]/div")).click();
					 Thread.sleep(1000);
					 	}
					 catch(Exception e)
						{System.out.println("The is not Nexus Label Report");	}	
				 
					//Site&Temp
				try{
					Select temp= new Select(driver.findElement(By.xpath(".//*[@id='Template']")));
					temp.selectByVisibleText("New v44");
					Select Site= new Select(driver.findElement(By.xpath(".//*[@id='Site']")));
					Site.selectByVisibleText("test-New Test");	}
				catch(Exception e)
				{System.out.println("There is no Site and Template Present");	}	
				try{
					 WebElement now = driver.findElement(By.xpath(".//*[@id='report_now']"));
					 JavascriptExecutor scroll1 = (JavascriptExecutor)driver;
					 scroll1.executeScript("arguments[0].click();", now);
					 WebElement now1 = driver.findElement(By.xpath(".//*[@id='frmReport']/div/div[4]/div/div[2]/div[2]/div[4]/div[1]/input"));
					 JavascriptExecutor scroll2 = (JavascriptExecutor)driver;
					 scroll2.executeScript("arguments[0].click();", now1);
					 driver.navigate().back();
					 //driver.findElement(By.xpath(".//*[@id='frmReport']/div/div[4]/div/div[2]/div[2]/div[4]/div[1]/input")).click();
					 Thread.sleep(2000);
					 save();
				}
				catch(Exception e)
				{System.out.println("There is no Generate now option");
	
				driver.navigate().back();}
				}
	/*	//VIEW
		
		for(int v=1;v<25;++v){
			if((v>1 && v<3 || v>9 && v<11 || v>15 && v<24)) {
				continue;
		}
		driver.navigate().to("https://testrmsid.com/v4/app/reporting/action/list/reportId/" + v + "");
		System.out.println(v);
		Thread.sleep(1000);
		//Check All
		if ( !driver.findElement(By.xpath(".//*[@id='checkAll']")).isSelected() )
		{    driver.findElement(By.xpath(".//*[@id='checkAll']")).click();}
		
		//Generate Now
		WebElement now = driver.findElement(By.xpath(".//*[@id='report_now']"));
		 JavascriptExecutor scroll1 = (JavascriptExecutor)driver;
		 scroll1.executeScript("arguments[0].click();", now);
		     WebElement output = driver.findElement(By.xpath(".//*[@id='Format']"));
			 JavascriptExecutor scroll = (JavascriptExecutor)driver;
			 scroll.executeScript("arguments[0].click();", output);	
			 Select Output= new Select(driver.findElement(By.xpath(".//*[@id='Format']")));
			 Output.selectByVisibleText("VIEW");
			 Select Date= new Select(driver.findElement(By.xpath(".//*[@id='DateCreated']")));
			 Date.selectByVisibleText("Last Fourteen Days");	
				//Site&Temp
			try{
				Select temp= new Select(driver.findElement(By.xpath(".//*[@id='Template']")));
				temp.selectByVisibleText("New v44");
				Select Site= new Select(driver.findElement(By.xpath(".//*[@id='Site']")));
				Site.selectByVisibleText("test-New Test");	}
			catch(Exception e)
			{System.out.println("There is no Site and Template Present");	}	
			try{
				
				 WebElement now1 = driver.findElement(By.xpath(".//*[@id='frmReport']/div/div[4]/div/div[2]/div[2]/div[4]/div[1]/input"));
				 JavascriptExecutor scroll2 = (JavascriptExecutor)driver;
				 scroll2.executeScript("arguments[0].click();", now1);
				 driver.navigate().back();
				 //driver.findElement(By.xpath(".//*[@id='frmReport']/div/div[4]/div/div[2]/div[2]/div[4]/div[1]/input")).click();
				 Thread.sleep(2000);
				 save();
			}
			catch(Exception e)
			{System.out.println("There is no Generate now option");

			driver.navigate().back();}
			}*/
		
		//XML
		for(int v=1;v<25;++v){
			if((v>18 && v<21)) {
				continue;
			}
			driver.navigate().to("https://v5tp.testrmsid.com/#/app/reporting/action/list/reportId/" + v + "");
			System.out.println(v);
			
			//Check All
			if ( !driver.findElement(By.xpath(".//*[@id='checkAll']")).isSelected() )
			{    driver.findElement(By.xpath(".//*[@id='checkAll']")).click();}
			
			     WebElement output = driver.findElement(By.xpath(".//*[@id='Format']"));
				 JavascriptExecutor scroll = (JavascriptExecutor)driver;
				 scroll.executeScript("arguments[0].click();", output);	
				 Select Output= new Select(driver.findElement(By.xpath(".//*[@id='Format']")));
				 Output.selectByVisibleText("XML");
				 //date created
				 try {
				 Select Date= new Select(driver.findElement(By.xpath(".//*[@id='DateCreated']")));
				 Date.selectByVisibleText("Last Fourteen Days");	}
				 catch(Exception e)
					{System.out.println("There is no Date Created");	}
				 //Nexus Label
				 try {
					 driver.findElement(By.xpath(".//*[@id='search_nexus_id']")).sendKeys("1");
					 driver.findElement(By.xpath(".//*[@id='frmReport']/div/div[2]/div/div[2]/div")).click();
					 Thread.sleep(1000);
					 	}
					 catch(Exception e)
				 {System.out.println("The is not Nexus Label Report");	}	
				
				 //Site&Temp
				try{
					Select temp= new Select(driver.findElement(By.xpath(".//*[@id='Template']")));
					temp.selectByVisibleText("New v44");
					Select Site= new Select(driver.findElement(By.xpath(".//*[@id='Site']")));
					Site.selectByVisibleText("test-New Test");	}
				catch(Exception e)
				{System.out.println("There is no Site and Template Present");	}	
				try{
					 WebElement now = driver.findElement(By.xpath(".//*[@id='report_now']"));
					 JavascriptExecutor scroll1 = (JavascriptExecutor)driver;
					 scroll1.executeScript("arguments[0].click();", now);
					 WebElement now1 = driver.findElement(By.xpath(".//*[@id='frmReport']/div/div[4]/div/div[2]/div[2]/div[4]/div[1]/input"));
					 JavascriptExecutor scroll2 = (JavascriptExecutor)driver;
					 scroll2.executeScript("arguments[0].click();", now1);
					 driver.navigate().back();
					 //driver.findElement(By.xpath(".//*[@id='frmReport']/div/div[4]/div/div[2]/div[2]/div[4]/div[1]/input")).click();
					 Thread.sleep(2000);
					 save();
				}
				catch(Exception e)
				{System.out.println("There is no Generate now option");
	
				driver.navigate().back();}
						  			}
		for(int v=1;v<25;++v){
			if((v>18 && v<21)) {
				continue;
			}
			driver.navigate().to("https://v5tp.testrmsid.com/#/app/reporting/action/list/reportId/" + v + "");
		    System.out.println(v);
			
			//Check All
			if ( !driver.findElement(By.xpath(".//*[@id='checkAll']")).isSelected() )
			{    driver.findElement(By.xpath(".//*[@id='checkAll']")).click();}
			
			     WebElement output = driver.findElement(By.xpath(".//*[@id='Format']"));
				 JavascriptExecutor scroll = (JavascriptExecutor)driver;
				 scroll.executeScript("arguments[0].click();", output);	
				 Select Output= new Select(driver.findElement(By.xpath(".//*[@id='Format']")));
				 Output.selectByVisibleText("CSV");
				 //date created
				 try {
				 Select Date= new Select(driver.findElement(By.xpath(".//*[@id='DateCreated']")));
				 Date.selectByVisibleText("Last Fourteen Days");	}
				 catch(Exception e)
					{System.out.println("There is no Date Created");	}
				 
				 //Nexus Label
				 try {
					 driver.findElement(By.xpath(".//*[@id='search_nexus_id']")).sendKeys("1");
					 driver.findElement(By.xpath(".//*[@id='frmReport']/div/div[2]/div/div[2]/div")).click();
					 Thread.sleep(1000);
					 	}
					 catch(Exception e)
				 {System.out.println("The is not Nexus Label Report");	}
					//Site&Temp
				try{
					Select temp= new Select(driver.findElement(By.xpath(".//*[@id='Template']")));
					temp.selectByVisibleText("New v44");
					Select Site= new Select(driver.findElement(By.xpath(".//*[@id='Site']")));
					Site.selectByVisibleText("test-New Test");	}
				catch(Exception e)
				{System.out.println("There is no Site and Template Present");	}	
				try{
					 WebElement now = driver.findElement(By.xpath(".//*[@id='report_now']"));
					 JavascriptExecutor scroll1 = (JavascriptExecutor)driver;
					 scroll1.executeScript("arguments[0].click();", now);
					 WebElement now1 = driver.findElement(By.xpath(".//*[@id='frmReport']/div/div[4]/div/div[2]/div[2]/div[4]/div[1]/input"));
					 JavascriptExecutor scroll2 = (JavascriptExecutor)driver;
					 scroll2.executeScript("arguments[0].click();", now1);
					 driver.navigate().back();
					 //driver.findElement(By.xpath(".//*[@id='frmReport']/div/div[4]/div/div[2]/div[2]/div[4]/div[1]/input")).click();
					 Thread.sleep(2000);
					 save();
				}
				catch(Exception e)
				{System.out.println("There is no Generate now option");
	
				driver.navigate().back();}
		}
		for(int v=1;v<25;++v){
			if((v>18 && v<21)) {
				continue;
			}
			driver.navigate().to("https://v5tp.testrmsid.com/#/app/reporting/action/list/reportId/" + v + "");
			System.out.println(v);
			
			//Check All
			if ( !driver.findElement(By.xpath(".//*[@id='checkAll']")).isSelected() )
			{    driver.findElement(By.xpath(".//*[@id='checkAll']")).click();}
			
			     WebElement output = driver.findElement(By.xpath(".//*[@id='Format']"));
				 JavascriptExecutor scroll = (JavascriptExecutor)driver;
				 scroll.executeScript("arguments[0].click();", output);	
				 Select Output= new Select(driver.findElement(By.xpath(".//*[@id='Format']")));
				 Output.selectByVisibleText("HTML");
				 
				 //date created
				 try {
				 Select Date= new Select(driver.findElement(By.xpath(".//*[@id='DateCreated']")));
				 Date.selectByVisibleText("Last Fourteen Days");	}
				 catch(Exception e)
					{System.out.println("There is no Date Created");	}
				 
				 //Nexus Label
				 try {
					 driver.findElement(By.xpath(".//*[@id='search_nexus_id']")).sendKeys("1");
					 driver.findElement(By.xpath(".//*[@id='frmReport']/div/div[2]/div/div[2]/div")).click();
					 Thread.sleep(1000);
					 	}
					 catch(Exception e)
				 {System.out.println("The is not Nexus Label Report");	}
					//Site&Temp
				try{
					Select temp= new Select(driver.findElement(By.xpath(".//*[@id='Template']")));
					temp.selectByVisibleText("New v44");
					Select Site= new Select(driver.findElement(By.xpath(".//*[@id='Site']")));
					Site.selectByVisibleText("test-New Test");	}
				catch(Exception e)
				{System.out.println("There is no Site and Template Present");	}	
				try{
					 WebElement now = driver.findElement(By.xpath(".//*[@id='report_now']"));
					 JavascriptExecutor scroll1 = (JavascriptExecutor)driver;
					 scroll1.executeScript("arguments[0].click();", now);
					 WebElement now1 = driver.findElement(By.xpath(".//*[@id='frmReport']/div/div[4]/div/div[2]/div[2]/div[4]/div[1]/input"));
					 JavascriptExecutor scroll2 = (JavascriptExecutor)driver;
					 scroll2.executeScript("arguments[0].click();", now1);
					 String originalHandle = driver.getWindowHandle();

					    //Do something to open new tabs

					    for(String handle : driver.getWindowHandles()) {
					        if (!handle.equals(originalHandle)) {
					            driver.switchTo().window(handle);
					            Thread.sleep(1000);
					            driver.close();
					        }
					    }

					    driver.switchTo().window(originalHandle);
		
					 driver.navigate().back();
					 //driver.findElement(By.xpath(".//*[@id='frmReport']/div/div[4]/div/div[2]/div[2]/div[4]/div[1]/input")).click();
					 Thread.sleep(2000);
					 save();
				}
				catch(Exception e)
				{System.out.println("There is no Generate now option");
				
				driver.navigate().back();}
				
			 //Save Doc
		
		  			}
		for(int v=1;v<12;++v){
			if((v>1 && v<3 || v>3&&v<8 || v>8&&v<9 || v>9&&v<10 || v>10&&v<11 )) {
				continue;
			}
			
			driver.navigate().to("https://v5tp.testrmsid.com/#/app/reporting/action/list/reportId/" + v + "");
			System.out.println(v);
			
			//Check All
			if ( !driver.findElement(By.xpath(".//*[@id='checkAll']")).isSelected() )
			{    driver.findElement(By.xpath(".//*[@id='checkAll']")).click();}
			
			     WebElement output = driver.findElement(By.xpath(".//*[@id='Format']"));
				 JavascriptExecutor scroll = (JavascriptExecutor)driver;
				 scroll.executeScript("arguments[0].click();", output);	
				 Select Output= new Select(driver.findElement(By.xpath(".//*[@id='Format']")));
				 Output.selectByVisibleText("PDF");
				 //date created
				 try {
				 Select Date= new Select(driver.findElement(By.xpath(".//*[@id='DateCreated']")));
				 Date.selectByVisibleText("Last Fourteen Days");	}
				 catch(Exception e)
					{System.out.println("There is no Date Created");	}
				 
				 //Nexus Label
				 try {
					 driver.findElement(By.xpath(".//*[@id='search_nexus_id']")).sendKeys("1");
					 driver.findElement(By.xpath(".//*[@id='frmReport']/div/div[2]/div/div[2]/div")).click();
					 Thread.sleep(1000);
					 	}
					 catch(Exception e)
						{
						 System.out.println("There is no Date Created");
						}
					//Site&Temp
				try{
					Select temp= new Select(driver.findElement(By.xpath(".//*[@id='Template']")));
					temp.selectByVisibleText("New v44");
					Select Site= new Select(driver.findElement(By.xpath(".//*[@id='Site']")));
					Site.selectByVisibleText("test-New Test");	}
				catch(Exception e)
				{System.out.println("There is no Site and Template Present");	}	
				try{
					 WebElement now = driver.findElement(By.xpath(".//*[@id='report_now']"));
					 JavascriptExecutor scroll1 = (JavascriptExecutor)driver;
					 scroll1.executeScript("arguments[0].click();", now);
					 WebElement now1 = driver.findElement(By.xpath(".//*[@id='frmReport']/div/div[4]/div/div[2]/div[2]/div[4]/div[1]/input"));
					 JavascriptExecutor scroll2 = (JavascriptExecutor)driver;
					 scroll2.executeScript("arguments[0].click();", now1);
					 driver.navigate().back();
					 //driver.findElement(By.xpath(".//*[@id='frmReport']/div/div[4]/div/div[2]/div[2]/div[4]/div[1]/input")).click();
					 Thread.sleep(2000);
					 save();
				}
				catch(Exception e)
				{System.out.println("There is no Generate now option");
	
				driver.navigate().back();}
				
			 //Save Doc
		
		  			}

	driver.close();
	
	
	}
		public static void Login() throws InterruptedException {
		    System.out.println("launching chrome browser");
		    System.setProperty("webdriver.chrome.driver" , driverPath );
		    driver = new ChromeDriver();
		    driver.navigate().to("https://v5tp.testrmsid.com/#/login");
		    driver.manage().window().maximize();
		    driver.findElement(By.xpath("//input[@id='username']")).sendKeys("aruns@merchantrms.com");
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Tp@12345");  //*[@id="myDiv"]
		    driver.findElement(By.xpath("//button[@id='myDiv']")).click();
		    //Change Sitegroup
		    driver.findElement(By.xpath("//*[@id=\"menu-sitegroup\"]")).click();  //*[@id="menu-sitegroup"]
		    driver.findElement(By.xpath("//div[contains(text(),'1001-Retail E-Commerce')]")).sendKeys("1001");
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//div[contains(text(),'1001-Retail E-Commerce")).click();
Thread.sleep(3000);
		    driver.navigate().to("https://v5tp.testrmsid.com/#/app/reporting/action/list");
		    }
		public static void save() throws InterruptedException {
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			//chromePrefs.put("download.default_directory", downloadFilepath);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(ChromeOptions.CAPABILITY, options);
		    }
		
		}

