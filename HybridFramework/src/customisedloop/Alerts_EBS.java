package customisedloop;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Alerts_EBS {
 public static void main(String[] args) throws InterruptedException { 
	 System.setProperty("webdriver.chrome.driver" , "Drivers/chromedriver 3" );	   
	    String baseURL = "https://v5tp.testrmsid.com/#/login";
           
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
		driver.get(baseURL);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("arunsubramani@merchantrms.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Tp@12345");
		driver.findElement(By.xpath("//button[@id='myDiv']")).click();
		//Selecting Items in a Multiple SELECT elements
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='select2-chosen-2']\n")).click();  //a[normalize-space()='Alerts']
		driver.findElement(By.xpath(".//*[@id='s2id_autogen2_search']\n")).sendKeys("1070");
		driver.findElement(By.xpath(".//div[@class=\"select2-result-label\"]/span\n")).click();
		Thread.sleep(3000);
	
	   driver.get("https://v5tp.testrmsid.com/#/components/alert");
		Thread.sleep(2000);
		//Loop
		for(int v=7;v<80;++v){
		driver.findElement(By.xpath(".//*[@id='alertsList']/div/div[1]/div/a")).click();
		Select alert = new Select(driver.findElement(By.xpath(".//*[@id='builder-basic_rule_0']/div[3]/select")));
		alert.selectByIndex(v);
	    driver.findElement(By.xpath(".//*[@id='builder-basic_rule_0']/div[5]/input")).sendKeys("21548123123123");
	    WebElement option = alert.getFirstSelectedOption();
	    String text = option.getText();
	    //Enter Name
	    driver.findElement(By.xpath(".//*[@id='alerts-title']")).sendKeys(text);
	    //Enter Description
	    driver.findElement(By.xpath(".//*[@id='alerts-description']")).sendKeys(text);
	    System.out.println(text);
	    //Select Not Equal
	    driver.findElement(By.xpath(".//*[@id='builder-basic_rule_0']//option[contains(text(), 'not equal')]")).click();
	    //Enter Email
	    driver.findElement(By.xpath(".//*[@id='alerts_mail_to']")).sendKeys("arunsubramani@merchantrms.com");
	    //scroll
	    JavascriptExecutor je = (JavascriptExecutor) driver;
	    WebElement element = driver.findElement(By.xpath(".//*[@id='alert-add']/div[8]/button[2]"));
	    je.executeScript("arguments[0].scrollIntoView(true);",element);
	    // Click Active
	    driver.findElement(By.xpath(".//*[@id='alert-add']/div[7]/div/input")).click();
	    //Click Save 
	    driver.findElement(By.xpath(".//*[@id='alert-add']/div[8]/button[2]")).click();
		}
		driver.get("https://testrmsid.com/v4/app/user/login/action/logout/");
		
		//Next Set of alerts
		
		driver.findElement(By.xpath(".//*[@id='frm_username']")).sendKeys("arunsubramani@merchantrms.com");
		driver.findElement(By.xpath(".//*[@id='frm_password']")).sendKeys("Mrms@123");
		driver.findElement(By.xpath(".//*[@id='frmLogin']/button")).click();
		//Selecting Items in a Multiple SELECT elements
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='select2-chosen-2']\n")).click();
		driver.findElement(By.xpath(".//*[@id='s2id_autogen2_search']\n")).sendKeys("1070");
		driver.findElement(By.xpath(".//div[@class=\"select2-result-label\"]/span\n")).click();
		Thread.sleep(3000);
	
		driver.get("https://testrmsid.com/v4/app/rms/alerts/");
		Thread.sleep(2000);
		//Loop
		for(int v=80;v<134;++v){
		driver.findElement(By.xpath(".//*[@id='alertsList']/div/div[1]/div/a")).click();
		Select alert = new Select(driver.findElement(By.xpath(".//*[@id='builder-basic_rule_0']/div[3]/select")));
		alert.selectByIndex(v);
	    driver.findElement(By.xpath(".//*[@id='builder-basic_rule_0']/div[5]/input")).sendKeys("21548123123123");
	    WebElement option = alert.getFirstSelectedOption();
	    String text = option.getText();
	    //Enter Name
	    driver.findElement(By.xpath(".//*[@id='alerts-title']")).sendKeys(text);
	    //Enter Description
	    driver.findElement(By.xpath(".//*[@id='alerts-description']")).sendKeys(text);
	    System.out.println(text);
	    //Select Not Equal
	    driver.findElement(By.xpath(".//*[@id='builder-basic_rule_0']//option[contains(text(), 'not equal')]")).click();
	    //Enter Email
	    driver.findElement(By.xpath(".//*[@id='alerts_mail_to']")).sendKeys("arunsubramani@merchantrms.com");
	    //scroll
	    JavascriptExecutor je = (JavascriptExecutor) driver;
	    WebElement element = driver.findElement(By.xpath(".//*[@id='alert-add']/div[8]/button[2]"));
	    je.executeScript("arguments[0].scrollIntoView(true);",element);
	    // Click Active
	    driver.findElement(By.xpath(".//*[@id='alert-add']/div[7]/div/input")).click();
	    //Click Save 
	    driver.findElement(By.xpath(".//*[@id='alert-add']/div[8]/button[2]")).click();
		}
		
		// Txn Post
		driver.get("https://testrmsid.com/v44/test/post.php");
		Thread.sleep(2000);
		 driver.findElement(By.xpath(".//input[@name='Site']")).clear();
         driver.findElement(By.xpath(".//input[@name='Site']")).sendKeys("1070");
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
        // System.out.println(randomNumbers);
                   //System.out.println("usename"+v+"@gmail.com");      
                   driver.findElement(By.xpath(".//*[@id='submitted']")).click();
                   Thread.sleep(1000);
                   driver.get("https://testrmsid.com/v4/app/rms/alerts/");
           		Thread.sleep(2000);
		
		//Delete Alert
		driver.findElement(By.xpath(".//*[@id='alertMgrtable_length']/label/select")).click();
		driver.findElement(By.xpath(".//*[@id='alertMgrtable_length']/label/select//option[contains(text(), '100')]")).click();
		driver.findElement(By.xpath(".//*[@id='checkAll']")).click();
		driver.findElement(By.xpath(".//*[@id='alertsList']/div/div[1]/div/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//button[@class='swal2-confirm btn btn-success']")).click();
		Thread.sleep(4000);
		//Next 100
		driver.findElement(By.xpath(".//*[@id='alertMgrtable_length']/label/select")).click();
		driver.findElement(By.xpath(".//*[@id='alertMgrtable_length']/label/select//option[contains(text(), '100')]")).click();
		driver.findElement(By.xpath(".//*[@id='checkAll']")).click();
		driver.findElement(By.xpath(".//*[@id='alertsList']/div/div[1]/div/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//button[@class='swal2-confirm btn btn-success']")).click();
		driver.close();
 }
 
}
