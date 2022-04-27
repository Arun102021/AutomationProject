package customisedloop;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Alerts_Ogone {
 public static void main(String[] args) throws InterruptedException { 
	 System.setProperty("webdriver.chrome.driver" , "Drivers/chromedriver" );	   
	    String baseURL = "https://v5.testrmsid.com:8080/#/login";
            
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
		driver.get(baseURL);
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("alerts_admin_v5@mrms.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Password_alerts@111");
		driver.findElement(By.xpath("//*[@id=\"myDiv\"]")).click();
		Thread.sleep(2000);
	
       // driver.get("https://v5.testrmsid.com:8080/#/components/alert");
		Thread.sleep(2000);
		String[] textArray = new String[10];
		String text = "";
	    String[] cond = {"(.//div[@class='item' and contains(text(),'equal')])[1]","(.//div[@class='item' and contains(text(),'equal')])[2]",".//div[@class='item' and contains(text(),'greater')]","(.//div[@class='item' and contains(text(),'equal')])[3]","(.//div[@class='item' and contains(text(),'less')]","(.//div[@class='item' and contains(text(),'equal')])[4]"};
	    int start = 6;
	    int[] fields = {7};
	    int a = 0;
	    for (int k = 0; k < cond.length; k++)
	    {
	    	System.out.println(k);
	    	driver.get("https://v5.testrmsid.com:8080/#/components/alert");
	    	
	    	for(int j=0; j < fields.length; j++) 
		    {
		    
	    		System.out.println(start);
	    		System.out.println(j);
	    		System.out.println(fields[j]);
	    		
		    	for (int v = start; v <= fields[j]; v++) 
		    	{
	    	    		
		    		Thread.sleep(6000);
	    			driver.findElement(By.xpath("//*[@id='benesApp']/div[5]/div/div[3]/div[1]/div/div[2]/div/div[1]/div/button[2]")).click();
	    			Thread.sleep(2000);
	    			Select alert = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
	    			alert.selectByIndex(v);
	    			driver.findElement(By.xpath("//button[contains(text(),'Add Alerts')]")).click();
	    			if(k == 4)
	    			{
	    				driver.findElement(By.xpath("//div[@class='form-group']//input[@type='text']")).sendKeys("1");	
	    			}
	    			else
	    			{
	    		    driver.findElement(By.xpath("//div[@class='form-group']//input[@type='text']")).sendKeys("0");
	    			}
	    		    WebElement option = alert.getFirstSelectedOption();
	    
	    		    textArray[a] = option.getText();
	    		    
	    		    text = option.getText();
	    		    a++;
	    		    //Enter Name
	    		    driver.findElement(By.xpath("//*[@id=\"modal-scrollable___BV_modal_body_\"]/div/form/div[1]/div/div[1]/div/input")).sendKeys(text);
	    		    //Enter Description
	    		    driver.findElement(By.xpath("//*[@id=\"modal-scrollable___BV_modal_body_\"]/div/form/div[2]/div/div[1]/div/input")).sendKeys(text);
	    		    System.out.println(text);
	    		    //Select Not Equal
	    		   // driver.findElement(By.xpath(".//*[@id='builder-basic_rule_0']//option[contains(text(), 'not equal')]")).click();
	    		    driver.findElement(By.xpath("//div[@class='ui fluid search selection dropdown form-control']//i[@class='dropdown icon']")).click();
	    		    Thread.sleep(2000);
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
		    	//start = fields[j]; // 7,8,9,10
    			
	    	}	
	   	//Txn Post
			driver.get("https://v5.testrmsid.com:8081/IPSForm.php");
			Thread.sleep(2000);
			 driver.findElement(By.xpath(".//input[@name='Site']")).clear();
	         driver.findElement(By.xpath(".//input[@name='Site']")).sendKeys("alerts");
	      
			 driver.findElement(By.xpath(".//input[@name='SessionID']")).clear();
		
	         driver.findElement(By.xpath(".//input[@name='CardNumberHash']")).clear();
	         driver.findElement(By.xpath(".//input[@name='CardNumberHash']")).sendKeys("1ff1de774005f8da13f42943881c655f");
	      
	         driver.findElement(By.xpath(".//input[@name='CustEmail']")).clear();
	         driver.findElement(By.xpath(".//input[@name='CustEmail']")).sendKeys("18test@gmail.com");
	    
	         driver.findElement(By.xpath(".//input[@name='CustPhone']")).clear();
	         driver.findElement(By.xpath(".//input[@name='CustPhone']")).sendKeys("9912345123");  
	     
	         driver.findElement(By.xpath(".//input[@name='Address']")).clear();
	         driver.findElement(By.xpath(".//input[@name='Address']")).sendKeys("bill, address");
	     
	         driver.findElement(By.xpath(".//input[@name='ShipAddress']")).clear();
	         driver.findElement(By.xpath(".//input[@name='ShipAddress']")).sendKeys("ship, address");
	     
	         driver.findElement(By.xpath(".//input[@name='ShipEmail']")).clear();
	         driver.findElement(By.xpath(".//input[@name='ShipEmail']")).sendKeys("ship@email.com");
	        
	         driver.findElement(By.xpath(".//input[@name='ShipPhone']")).clear();
	         driver.findElement(By.xpath(".//input[@name='ShipPhone']")).sendKeys("758266234");
	       
	                       
	         driver.findElement(By.xpath(".//*[@id='submitted']")).click();
	         //Thread.sleep(500000); 
	         System.out.println("test");
	         
	         
	       //Dashboard check   
	         driver.get("https://v5.testrmsid.com:8080/#/"); 
	         Thread.sleep(6000);
	         JavascriptExecutor js = (JavascriptExecutor) driver;
	         js.executeScript("window.scrollBy(0,2000)");
	         for (int aid = 0; aid < textArray.length; aid++) 
	         {
	        	 if (textArray[aid] != null) {
	        		  
	        		 String alerttitle = textArray[aid];
	        		 driver.findElement(By.xpath("(//*[@id='filter-text-box'])[1]")).clear();
	        		 driver.findElement(By.xpath("(//*[@id='filter-text-box'])[1]")).sendKeys(alerttitle);
	    	         Thread.sleep(6000);
	    	         String actual = driver.findElement(By.xpath("(.//div[@col-id='title'])[2]")).getText();
	    	        // System.out.println(actual);
	    	        // System.out.println(alerttitle);
	    	         if(actual.equals(alerttitle))
	    	         {
	    	        	 System.out.println(alerttitle);
	    	        	 System.out.println("alert FOUND in dashboard");
	    	        	 
	    	         }
	    	         else
	    	         {
	    	        	 System.out.println(alerttitle);
	    	        	 System.out.println("alert NOT FOUND in dashboard");
	    	        	 
	    	         }
	        	 }
	        	 
	         }
	         
	    
	         
	         //Delete Alert          
	 		driver.get("https://v5.testrmsid.com:8080/#/components/alert");
	 		Thread.sleep(6000);
	 		driver.findElement(By.xpath("//input[@id='perpage']")).click();
	 		driver.findElement(By.xpath("/html/body/div[2]/div/div[5]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div[2]/div[3]")).click();
	 		driver.findElement(By.xpath("//div[@class='ag-header-select-all ag-labeled ag-label-align-right ag-checkbox']//div[@class='ag-wrapper ag-input-wrapper']//div//span[@class='ag-icon ag-icon-checkbox-unchecked']")).click();
	 		driver.findElement(By.xpath("//*[@id=\"delete\"]")).click();
	 		Thread.sleep(1000);
	 		driver.findElement(By.xpath("//button[@id='delete-toastr-confirm']")).click();
	    	
	    }
	    //driver.quit();
}
}


