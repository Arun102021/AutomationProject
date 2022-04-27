package customisedloop;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Schedule_Ogone {
	public static String driverPath = "Drivers/chromedriver";
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static <IWebElement> void main(String[] args) throws InterruptedException {
		Login();
		
		//EXCEL
		for(int v=1;v<33;++v){
				if((v>19 && v<28 || v>29 && v<31)) {
					continue;
			}
			driver.navigate().to("https://ogone.rmsid.com/console45/app/reporting/reporting/action/selectFields/reportId/" + v + "");
			System.out.println(v);
			
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
					temp.selectByVisibleText("console45");
					Select Site= new Select(driver.findElement(By.xpath(".//*[@id='Site']")));
					Site.selectByVisibleText("45-Console45");	}
				catch(Exception e)
				{System.out.println("There is no Site and Template Present");	}	
				//schedule
				 WebElement hiddenElement = driver.findElement(By.xpath(".//*[@id='schedule_chk']"));
				    JavascriptExecutor js = (JavascriptExecutor)driver;
				    js.executeScript("arguments[0].click();", hiddenElement);
				 Actions actionObject = new Actions(driver);
				actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
				Thread.sleep(1000);
	            driver.findElement(By.xpath(".//*[@id='radio_id_Weekly']")).click();
				driver.findElement(By.xpath(".//*[@id='frequency_day[]-2']")).click();
				driver.findElement(By.xpath(".//*[@id='frequency_day[]-3']")).click();
				driver.findElement(By.xpath(".//*[@id='frequency_day[]-4']")).click();
				driver.findElement(By.xpath(".//*[@id='frequency_day[]-5']")).click();
				driver.findElement(By.xpath(".//*[@id='frequency_day[]-6']")).click();
				driver.findElement(By.xpath(".//*[@id='frequency_day[]-7']")).click();
				Select time= new Select(driver.findElement(By.xpath(".//*[@id='schedule_cont']/div/div[3]/div[2]/select")));
				 time.selectByVisibleText("13:00");
				 
				 actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();	 
			driver.findElement(By.xpath(".//*[@id='reportemail']")).clear();
		    driver.findElement(By.xpath(".//*[@id='reportemail']")).sendKeys("arunsubramani@merchantrms.com");
		    WebElement now = driver.findElement(By.xpath(".//*[@id='frmReport']/div/div[4]/div/div[2]/div[2]/div[4]/div[2]/input"));
			 JavascriptExecutor scroll1 = (JavascriptExecutor)driver;
			 scroll1.executeScript("arguments[0].click();", now);
		}
		
		
		//HTML
		for(int v=1;v<33;++v){
			if((v>19 && v<28 || v>29 && v<31)) {
				continue;
			}
			driver.navigate().to("https://ogone.rmsid.com/console45/app/reporting/reporting/action/selectFields/reportId/" + v + "");
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
					temp.selectByVisibleText("console45");
					Select Site= new Select(driver.findElement(By.xpath(".//*[@id='Site']")));
					Site.selectByVisibleText("45-Console45");	}
				catch(Exception e)
				{System.out.println("There is no Site and Template Present");	}	
				//schedule 
				WebElement hiddenElement = driver.findElement(By.xpath(".//*[@id='schedule_chk']"));
			    JavascriptExecutor js = (JavascriptExecutor)driver;
			    js.executeScript("arguments[0].click();", hiddenElement);
				 Actions actionObject = new Actions(driver);
				 actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
				 Thread.sleep(1000);
	            driver.findElement(By.xpath(".//*[@id='radio_id_Weekly']")).click();
				driver.findElement(By.xpath(".//*[@id='frequency_day[]-2']")).click();
				driver.findElement(By.xpath(".//*[@id='frequency_day[]-3']")).click();
				driver.findElement(By.xpath(".//*[@id='frequency_day[]-4']")).click();
				driver.findElement(By.xpath(".//*[@id='frequency_day[]-5']")).click();
				driver.findElement(By.xpath(".//*[@id='frequency_day[]-6']")).click();
				driver.findElement(By.xpath(".//*[@id='frequency_day[]-7']")).click();
				Select time= new Select(driver.findElement(By.xpath(".//*[@id='schedule_cont']/div/div[3]/div[2]/select")));
				 time.selectByVisibleText("13:00");
				 actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();	 
			driver.findElement(By.xpath(".//*[@id='reportemail']")).clear();
		    driver.findElement(By.xpath(".//*[@id='reportemail']")).sendKeys("arunsubramani@merchantrms.com");
		    WebElement now = driver.findElement(By.xpath(".//*[@id='frmReport']/div/div[4]/div/div[2]/div[2]/div[4]/div[2]/input"));
			 JavascriptExecutor scroll1 = (JavascriptExecutor)driver;
			 scroll1.executeScript("arguments[0].click();", now);
		}
		
		
		//XML
		for(int v=1;v<33;++v){
			if((v>19 && v<28 || v>29 && v<31)) {
				continue;
			}
			driver.navigate().to("https://ogone.rmsid.com/console45/app/reporting/reporting/action/selectFields/reportId/" + v + "");
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
					temp.selectByVisibleText("console45");
					Select Site= new Select(driver.findElement(By.xpath(".//*[@id='Site']")));
					Site.selectByVisibleText("45-Console45");	}
				catch(Exception e)
				{System.out.println("There is no Site and Template Present");	}	
				//schedule
				 Actions actionObject = new Actions(driver);
				 WebElement hiddenElement = driver.findElement(By.xpath(".//*[@id='schedule_chk']"));
				    JavascriptExecutor js = (JavascriptExecutor)driver;
				    js.executeScript("arguments[0].click();", hiddenElement);
				    actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
				    Thread.sleep(1000);
	            driver.findElement(By.xpath(".//*[@id='radio_id_Weekly']")).click();
				driver.findElement(By.xpath(".//*[@id='frequency_day[]-2']")).click();
				driver.findElement(By.xpath(".//*[@id='frequency_day[]-3']")).click();
				driver.findElement(By.xpath(".//*[@id='frequency_day[]-4']")).click();
				driver.findElement(By.xpath(".//*[@id='frequency_day[]-5']")).click();
				driver.findElement(By.xpath(".//*[@id='frequency_day[]-6']")).click();
				driver.findElement(By.xpath(".//*[@id='frequency_day[]-7']")).click();
				Select time= new Select(driver.findElement(By.xpath(".//*[@id='schedule_cont']/div/div[3]/div[2]/select")));
				 time.selectByVisibleText("13:00");
				 actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();	 
			driver.findElement(By.xpath(".//*[@id='reportemail']")).clear();
		    driver.findElement(By.xpath(".//*[@id='reportemail']")).sendKeys("arunsubramani@merchantrms.com");
		    WebElement now = driver.findElement(By.xpath(".//*[@id='frmReport']/div/div[4]/div/div[2]/div[2]/div[4]/div[2]/input"));
			 JavascriptExecutor scroll1 = (JavascriptExecutor)driver;
			 scroll1.executeScript("arguments[0].click();", now);
		}
		
		//CSV
		for(int v=1;v<33;++v){
			if((v>19 && v<28 || v>29 && v<31)) {
				continue;
			}
			driver.navigate().to("https://ogone.rmsid.com/console45/app/reporting/reporting/action/selectFields/reportId/" + v + "");
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
					temp.selectByVisibleText("console45");
					Select Site= new Select(driver.findElement(By.xpath(".//*[@id='Site']")));
					Site.selectByVisibleText("45-Console45");	}
				catch(Exception e)
				{System.out.println("There is no Site and Template Present");	}	
				//schedule
				 WebElement hiddenElement = driver.findElement(By.xpath(".//*[@id='schedule_chk']"));
				    JavascriptExecutor js = (JavascriptExecutor)driver;
				    js.executeScript("arguments[0].click();", hiddenElement);
				 Actions actionObject = new Actions(driver);
				 actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
				 Thread.sleep(1000);
	            driver.findElement(By.xpath(".//*[@id='radio_id_Weekly']")).click();
				driver.findElement(By.xpath(".//*[@id='frequency_day[]-2']")).click();
				driver.findElement(By.xpath(".//*[@id='frequency_day[]-3']")).click();
				driver.findElement(By.xpath(".//*[@id='frequency_day[]-4']")).click();
				driver.findElement(By.xpath(".//*[@id='frequency_day[]-5']")).click();
				driver.findElement(By.xpath(".//*[@id='frequency_day[]-6']")).click();
				driver.findElement(By.xpath(".//*[@id='frequency_day[]-7']")).click();
				Select time= new Select(driver.findElement(By.xpath(".//*[@id='schedule_cont']/div/div[3]/div[2]/select")));
				 time.selectByVisibleText("13:00");
				 actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();	 
			driver.findElement(By.xpath(".//*[@id='reportemail']")).clear();
		    driver.findElement(By.xpath(".//*[@id='reportemail']")).sendKeys("arunsubramani@merchantrms.com");
		    WebElement now = driver.findElement(By.xpath(".//*[@id='frmReport']/div/div[4]/div/div[2]/div[2]/div[4]/div[2]/input"));
			 JavascriptExecutor scroll1 = (JavascriptExecutor)driver;
			 scroll1.executeScript("arguments[0].click();", now);
			 //driver.findElement(By.xpath("")).click();
			 
		}
		
		
		//PDF
		for(int v=1;v<13;++v){
			if((v>1 && v<3 || v>3&&v<8 || v>8&&v<10 || v>9&&v<10 )) {
				continue;
			}
			driver.navigate().to("https://ogone.rmsid.com/console45/app/reporting/reporting/action/selectFields/reportId/" + v + "");
			System.out.println(v);
			
			//Check All
			if ( !driver.findElement(By.xpath(".//*[@id='checkAll']")).isSelected() )
			{    driver.findElement(By.xpath(".//*[@id='checkAll']")).click();}
			 try{
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
					temp.selectByVisibleText("console45");
					Select Site= new Select(driver.findElement(By.xpath(".//*[@id='Site']")));
					Site.selectByVisibleText("45-Console45");	}
				catch(Exception e)
				{System.out.println("There is no Site and Template Present");	}	
				//schedule
				 WebElement hiddenElement = driver.findElement(By.xpath(".//*[@id='schedule_chk']"));
				    JavascriptExecutor js = (JavascriptExecutor)driver;
				    js.executeScript("arguments[0].click();", hiddenElement);
				 Actions actionObject = new Actions(driver);
				 actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
				 Thread.sleep(1000);
	            driver.findElement(By.xpath(".//*[@id='radio_id_Weekly']")).click();
				driver.findElement(By.xpath(".//*[@id='frequency_day[]-2']")).click();
				driver.findElement(By.xpath(".//*[@id='frequency_day[]-3']")).click();
				driver.findElement(By.xpath(".//*[@id='frequency_day[]-4']")).click();
				driver.findElement(By.xpath(".//*[@id='frequency_day[]-5']")).click();
				driver.findElement(By.xpath(".//*[@id='frequency_day[]-6']")).click();
				driver.findElement(By.xpath(".//*[@id='frequency_day[]-7']")).click();
				Select time= new Select(driver.findElement(By.xpath(".//*[@id='schedule_cont']/div/div[3]/div[2]/select")));
				 time.selectByVisibleText("13:00");
				 actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();	 
			driver.findElement(By.xpath(".//*[@id='reportemail']")).clear();
		    driver.findElement(By.xpath(".//*[@id='reportemail']")).sendKeys("arunsubramani@merchantrms.com");
		    WebElement now = driver.findElement(By.xpath(".//*[@id='frmReport']/div/div[4]/div/div[2]/div[2]/div[4]/div[2]/input"));
			 JavascriptExecutor scroll1 = (JavascriptExecutor)driver;
			 scroll1.executeScript("arguments[0].click();", now);
				 }
				 catch(Exception e)
					{driver.navigate().back();	}	
				 
		}
		driver.quit();
		  			}
	
	public static void Login() throws InterruptedException {
	    System.out.println("launching chrome browser");
	    System.setProperty("webdriver.chrome.driver" , driverPath );
	    driver = new ChromeDriver();
	    driver.navigate().to("https://ogone.rmsid.com/console45/");
	    driver.manage().window().maximize();
	    driver.findElement(By.xpath(".//*[@id='frm_username']")).sendKeys("arunsubramani@merchantrms.com");
		driver.findElement(By.xpath(".//*[@id='frm_password']")).sendKeys("Mrms@123");
	    driver.findElement(By.xpath(".//*[@id='frmLogin']/button")).click();
	    Thread.sleep(5000);
	    //Change Sitegroup
	    driver.findElement(By.xpath(".//*[@id='select2-chosen-2']\n")).click();
	    driver.findElement(By.xpath(".//*[@id='s2id_autogen2_search']\n")).sendKeys("1287");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(".//div[@class=\"select2-result-label\"]/span\n")).click();
Thread.sleep(3000);
	    driver.navigate().to("https://ogone.rmsid.com/console45/www/app/reporting/action/list/");
	    }
}
