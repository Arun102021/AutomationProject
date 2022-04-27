package customisedloop;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Alerts_O {
 public static void main(String[] args) throws InterruptedException { 
	 System.setProperty("webdriver.chrome.driver" , "/Drivers/chromedriver" );	   
	    String baseURL = "https://v5.testrmsid.com:8080/#/login";
            
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
		driver.get(baseURL);
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("alerts_admin_v5@mrms.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Password_alerts@111");
		driver.findElement(By.xpath("//*[@id=\"myDiv\"]")).click();
		//Selecting Items in a Multiple SELECT elements
		Thread.sleep(4000);
		/*driver.findElement(By.xpath(".//*[@id='select2-chosen-2']\n")).click();
		driver.findElement(By.xpath(".//*[@id='s2id_autogen2_search']\n")).sendKeys("1287");
		driver.findElement(By.xpath(".//div[@class=\"select2-result-label\"]/span\n")).click();
		Thread.sleep(3000); */
	
	    driver.get("https://v5.testrmsid.com:8080/#/components/alert");
		Thread.sleep(2000);
	    String[] cond = {"/html/body/div[7]/div[1]/div/div/div/div/form/div[3]/div/div[2]/div[2]/div/div/div/div[2]/div[2]","/html/body/div[7]/div[1]/div/div/div/div/form/div[3]/div/div[2]/div[2]/div/div/div/div[2]/div[3]"};
	    String[] drop = {"//div[contains(text(),'Last 12 Hrs')]"};
	    int start = 0;
	    int[] fields = {2,5};
	    for (int k = 0; k < cond.length; k++) {
	    	System.out.println(k);
	    	 
	    	for(int j=0; j < fields.length; j++) 
		    {
		    	// 10
	    		System.out.println(start);
	    		System.out.println(j);
	    		System.out.println(fields[j]);
	    		
		    	for (int v = start; v <= fields[j]; v++) {
	    		
	    		// 7,8,9,10	    		
		    		Thread.sleep(2000);
	    			driver.findElement(By.xpath("//*[@id=\"benesApp\"]/div[5]/div/div[3]/div[1]/div/div[2]/div/div[1]/div/button[2]")).click();
	    			Select alert = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
	    			alert.selectByIndex(v);
	    			driver.findElement(By.xpath("//button[contains(text(),'Add Alerts')]")).click();
	    			 driver.findElement(By.xpath("//div[@type='query-builder-rule']//div[@class='form-group']//div[@class='ui fluid search selection dropdown']//i[@class='dropdown icon']")).click();
		    		    driver.findElement(By.xpath(drop[0])).click();
	    		    WebElement option = alert.getFirstSelectedOption();
	    		    String text = option.getText();
	    		    //Enter Name
	    		    driver.findElement(By.xpath("//*[@id=\"modal-scrollable___BV_modal_body_\"]/div/form/div[1]/div/div[1]/div/input")).sendKeys(text);
	    		    //Enter Description
	    		    driver.findElement(By.xpath("//*[@id=\"modal-scrollable___BV_modal_body_\"]/div/form/div[2]/div/div[1]/div/input")).sendKeys(text);
	    		    System.out.println(text);
	    		    //Select Not Equal
	    		   // driver.findElement(By.xpath(".//*[@id='builder-basic_rule_0']//option[contains(text(), 'not equal')]")).click();
	    		    driver.findElement(By.xpath("//div[@class='ui fluid search selection dropdown form-control']//i[@class='dropdown icon']")).click();
	    		    driver.findElement(By.xpath(cond[k])).click();
	    		    //Enter Email
	    		   // driver.findElement(By.xpath(".//*[@id='alerts_mail_to']")).sendKeys("prathyusha@merchantrms.com");
	    		    //scroll
	    		    JavascriptExecutor je = (JavascriptExecutor) driver;
	    		    WebElement element = driver.findElement(By.xpath("//label[contains(text(),'Info')]"));
	    		    je.executeScript("arguments[0].scrollIntoView(true);",element);
	    		    // Click Active
	    		    driver.findElement(By.xpath("//*[@id=\"modal-scrollable___BV_modal_body_\"]/div/form/div[7]/div/div[1]/div/div[1]")).click();
	    		    //Click Save 
	    		    driver.findElement(By.xpath("//*[@id=\"dialog-save\"]")).click();
	    		
	    		    
	    		}
		    	start = fields[j]; // 7,8,9,10
    			
	    	}	    	
	    	
	    } 
	    driver.quit();
		
	
		// Txn Post
		driver.get("https://v5.testrmsid.com:8081/IPSForm.php");
		Thread.sleep(2000);
		 driver.findElement(By.xpath(".//input[@name='Site']")).clear();
         driver.findElement(By.xpath(".//input[@name='Site']")).sendKeys("alerts");
         //SessionID
		 driver.findElement(By.xpath(".//input[@name='SessionID']")).clear();
		 //Cardnumberhash
         driver.findElement(By.xpath(".//input[@name='CardNumberHash']")).clear();
         driver.findElement(By.xpath(".//input[@name='CardNumberHash']")).sendKeys("olao983890ui90iu7nf4294one1c655f");
         //CustEmail
         driver.findElement(By.xpath(".//input[@name='CustEmail']")).clear();
         driver.findElement(By.xpath(".//input[@name='CustEmail']")).sendKeys("14tou@gmail.com");
         //CustPhone
         driver.findElement(By.xpath(".//input[@name='CustPhone']")).clear();
         driver.findElement(By.xpath(".//input[@name='CustPhone']")).sendKeys("7349374932");  
         //Address
         driver.findElement(By.xpath(".//input[@name='Address']")).clear();
         driver.findElement(By.xpath(".//input[@name='Address']")).sendKeys("otyuy,8822");
         //Shipaddress
         driver.findElement(By.xpath(".//input[@name='ShipAddress']")).clear();
         driver.findElement(By.xpath(".//input[@name='ShipAddress']")).sendKeys("juile,7766");
         //ShipEmail
         driver.findElement(By.xpath(".//input[@name='ShipEmail']")).clear();
         driver.findElement(By.xpath(".//input[@name='ShipEmail']")).sendKeys("5iuo@test.com");
         //ShipPhone   
         driver.findElement(By.xpath(".//input[@name='ShipPhone']")).clear();
         driver.findElement(By.xpath(".//input[@name='ShipPhone']")).sendKeys("758266234");
      
         driver.findElement(By.xpath(".//*[@id='submitted']")).click();
        Thread.sleep(1000);
        
      //Delete Alert
		driver.get("https://v5.testrmsid.com:8080/#/components/alert");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='perpage']")).click();
		driver.findElement(By.xpath("//div[@class='item selected'][contains(text(),100)]")).click();
		driver.findElement(By.xpath("//div[@class='ag-header-select-all ag-labeled ag-label-align-right ag-checkbox']//div[@class='ag-wrapper ag-input-wrapper']//div//span[@class='ag-icon ag-icon-checkbox-unchecked']")).click();
		driver.findElement(By.xpath("//*[@id=\"delete\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='delete-toastr-confirm']")).click();
		Thread.sleep(4000);
		driver.quit();
 }
 }
