package customisedloop;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Mail_EBS {
	public static String driverPath = "Drivers/chromedriver";
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static <IWebElement> void main(String[] args) throws InterruptedException {
		Login();
		
		for(int v=1;v<25;++v){
			if((v>18 && v<21)) {
				continue;}
			driver.navigate().to("https://testrmsid.com/v4/app/reporting/action/list/reportId/" + v + "");
			System.out.println(v);
			
			//Check All
			try {
			if ( !driver.findElement(By.xpath(".//*[@id='checkAll']")).isSelected() )
			{    driver.findElement(By.xpath(".//*[@id='checkAll']")).click();}}
			catch(Exception e) {
				System.out.println("No click all option");
			}
			
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
					temp.selectByVisibleText("NewTesttt");
					Select Site= new Select(driver.findElement(By.xpath(".//*[@id='Site']")));
					Site.selectByVisibleText("1070-asdas");	}
				catch(Exception e)
				{System.out.println("There is no Site and Template Present");	}	
			driver.findElement(By.xpath(".//*[@id='reportemail']")).clear();
		    driver.findElement(By.xpath(".//*[@id='reportemail']")).sendKeys("prathyusha@merchantrms.com");
		    WebElement now = driver.findElement(By.xpath(".//*[@id='frmReport']/div/div[4]/div/div[2]/div[2]/div[4]/div[1]/input"));
			 JavascriptExecutor scroll1 = (JavascriptExecutor)driver;
			 scroll1.executeScript("arguments[0].click();", now);	
		  			}
		for(int v=1;v<25;++v){
			if((v>18 && v<21)) {
				continue;}
			driver.navigate().to("https://testrmsid.com/v4/app/reporting/action/list/reportId/" + v + "");
			System.out.println(v);
			
			//Check All
			try {
				if ( !driver.findElement(By.xpath(".//*[@id='checkAll']")).isSelected() )
				{    driver.findElement(By.xpath(".//*[@id='checkAll']")).click();}}
				catch(Exception e) {
					System.out.println("No click all option");
				}
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
					temp.selectByVisibleText("NewTesttt");
					Select Site= new Select(driver.findElement(By.xpath(".//*[@id='Site']")));
					Site.selectByVisibleText("1070-asdas");	}
				catch(Exception e)
				{System.out.println("There is no Site and Template Present");	}	
			driver.findElement(By.xpath(".//*[@id='reportemail']")).clear();
		    driver.findElement(By.xpath(".//*[@id='reportemail']")).sendKeys("prathyusha@merchantrms.com");
		    WebElement now = driver.findElement(By.xpath(".//*[@id='frmReport']/div/div[4]/div/div[2]/div[2]/div[4]/div[1]/input"));
			 JavascriptExecutor scroll1 = (JavascriptExecutor)driver;
			 scroll1.executeScript("arguments[0].click();", now);	
		  			}
		for(int v=1;v<25;++v){
			if((v>18 && v<21)) {
				continue;}
			driver.navigate().to("https://testrmsid.com/v4/app/reporting/action/list/reportId/" + v + "");
			System.out.println(v);
			
			//Check All
			try {
				if ( !driver.findElement(By.xpath(".//*[@id='checkAll']")).isSelected() )
				{    driver.findElement(By.xpath(".//*[@id='checkAll']")).click();}}
				catch(Exception e) {
					System.out.println("No click all option");
				}
			
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
					temp.selectByVisibleText("NewTesttt");
					Select Site= new Select(driver.findElement(By.xpath(".//*[@id='Site']")));
					Site.selectByVisibleText("1070-asdas");	}
				catch(Exception e)
				{System.out.println("There is no Site and Template Present");	}	
			driver.findElement(By.xpath(".//*[@id='reportemail']")).clear();
		    driver.findElement(By.xpath(".//*[@id='reportemail']")).sendKeys("prathyusha@merchantrms.com");
		    WebElement now = driver.findElement(By.xpath(".//*[@id='frmReport']/div/div[4]/div/div[2]/div[2]/div[4]/div[1]/input"));
			 JavascriptExecutor scroll1 = (JavascriptExecutor)driver;
			 scroll1.executeScript("arguments[0].click();", now);	
		  			}

		for(int v=1;v<25;++v){
			if((v>18 && v<21)) {
				continue;}
			driver.navigate().to("https://testrmsid.com/v4/app/reporting/action/list/reportId/" + v + "");
			System.out.println(v);
			//Check All
			try {
				if ( !driver.findElement(By.xpath(".//*[@id='checkAll']")).isSelected() )
				{    driver.findElement(By.xpath(".//*[@id='checkAll']")).click();}}
				catch(Exception e) {
					System.out.println("No click all option");
				}
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
					temp.selectByVisibleText("NewTesttt");
					Select Site= new Select(driver.findElement(By.xpath(".//*[@id='Site']")));
					Site.selectByVisibleText("1070-asdas");	}
				catch(Exception e)
				{System.out.println("There is no Site and Template Present");	}	
			driver.findElement(By.xpath(".//*[@id='reportemail']")).clear();
		    driver.findElement(By.xpath(".//*[@id='reportemail']")).sendKeys("prathyusha@merchantrms.com");
		    WebElement now = driver.findElement(By.xpath(".//*[@id='frmReport']/div/div[4]/div/div[2]/div[2]/div[4]/div[1]/input"));
			 JavascriptExecutor scroll1 = (JavascriptExecutor)driver;
			 scroll1.executeScript("arguments[0].click();", now);	
		  			}
	
		for(int v=1;v<12;++v){
			if((v>1 && v<3 || v>3&&v<8 || v>8&&v<9 || v>9&&v<10 || v>10&&v<11 )) {
				continue;
			}
			driver.navigate().to("https://testrmsid.com/v4/app/reporting/action/list/reportId/" + v + "");
			System.out.println(v);
			//Check All
			try {
				if ( !driver.findElement(By.xpath(".//*[@id='checkAll']")).isSelected() )
				{    driver.findElement(By.xpath(".//*[@id='checkAll']")).click();}}
				catch(Exception e) {
					System.out.println("No click all option");
				}
			
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
					temp.selectByVisibleText("NewTesttt");
					Select Site= new Select(driver.findElement(By.xpath(".//*[@id='Site']")));
					Site.selectByVisibleText("1070-asdas");	}
				catch(Exception e)
				{System.out.println("There is no Site and Template Present");	}	
			driver.findElement(By.xpath(".//*[@id='reportemail']")).clear();
		    driver.findElement(By.xpath(".//*[@id='reportemail']")).sendKeys("prathyusha@merchantrms.com");
		    WebElement now = driver.findElement(By.xpath(".//*[@id='frmReport']/div/div[4]/div/div[2]/div[2]/div[4]/div[1]/input"));
			 JavascriptExecutor scroll1 = (JavascriptExecutor)driver;
			 scroll1.executeScript("arguments[0].click();", now);	
		  			}


		driver.quit();
	}
	public static void Login() throws InterruptedException {
	    System.out.println("launching chrome browser");
	    System.setProperty("webdriver.chrome.driver" , driverPath );
	    driver = new ChromeDriver();
	    driver.navigate().to("https://testrmsid.com/v4/app/");
	    driver.manage().window().maximize();
	    driver.findElement(By.xpath(".//*[@id='frm_username']")).sendKeys("prathyusha@merchantrms.com");
		driver.findElement(By.xpath(".//*[@id='frm_password']")).sendKeys("Welcome@123");
	    driver.findElement(By.xpath(".//*[@id='frmLogin']/button")).click();
            Thread.sleep(5000);
	    //Change Sitegroup
	    driver.findElement(By.xpath(".//*[@id='select2-chosen-2']\n")).click();
	    driver.findElement(By.xpath(".//*[@id='s2id_autogen2_search']\n")).sendKeys("1070");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(".//div[@class=\"select2-result-label\"]/span\n")).click();
Thread.sleep(3000);
	    driver.navigate().to("https://testrmsid.com/v4/app/reporting/action/list/");
	    }

	
	}
