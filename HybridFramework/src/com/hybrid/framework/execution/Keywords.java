package com.hybrid.framework.execution;

import static com.hybrid.framework.reports.Reports.*;
import static org.junit.Assert.assertTrue;
import static com.hybrid.framework.execution.Execution.*;
import static com.hybrid.framework.locators.XpathLocator.*;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import javax.imageio.ImageIO;

import jxl.write.WriteException;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import com.hybrid.framework.locators.SpecialFunctions;
//import com.hybrid.framework.platforms.AppiumSetup;
import com.hybrid.framework.reports.Reports;

@SuppressWarnings("unused")
public class Keywords {
	
	public static WebDriverWait wait;
	
	
	public static void initilizaeWait(WebDriver driver) {
		wait = new WebDriverWait(driver, 30);
	}
	
	@SuppressWarnings("rawtypes")
	public static void keyword(String actionContent,String xpath,String value,String expected, int statusRow, int reportStatus) throws WriteException, IOException, InterruptedException{
		
		String startTimes = sdf.format(new Date().getTime());
		String endTimes =null;
		
		try{			
			
		switch(actionContent.toLowerCase()){
		
		case "alertsendkeys":			
			Alert alert2 = Execution.driver.switchTo().alert();
			try{
			Execution.driver.switchTo().alert().sendKeys(value);
			alert2.accept();
			endTimes = sdf.format(new Date().getTime());
			setXLValues(SheetName1, 9, statusRow, "Pass");
			setReports(SheetName1, 12, reportStatus, "Alert sendkeys works");
			setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
			} catch (Exception e){			
				endTimes = sdf.format(new Date().getTime());
				setXLValues(SheetName1, 9, statusRow, "Fail");
				setReports(SheetName1, 12, reportStatus, "Alert sendkeys not works");
				setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
			}			
			break; 
		    
		case "alertaccept":	
			
			Alert alert = Execution.driver.switchTo().alert();
			try{
			
			alert.accept();
			endTimes = sdf.format(new Date().getTime());
			setXLValues(SheetName1, 9, statusRow, "Pass");	
			setReports(SheetName1, 12, reportStatus, "Alert works");
			setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
			
			
			} catch (Exception e){
				
				endTimes = sdf.format(new Date().getTime());
				setXLValues(SheetName1, 9, statusRow, "Fail");
				setReports(SheetName1, 12, reportStatus, "Alert not works");
				setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
			}
			break;   
		
		case "alertdismiss":
			
			Alert alert1 = Execution.driver.switchTo().alert();
			try{
			alert1.dismiss();
			endTimes = sdf.format(new Date().getTime());
			setXLValues(SheetName1, 9, statusRow, "Pass");
			setReports(SheetName1, 12, reportStatus, "Alert dismissed");
			setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
			}catch(Exception e){
				endTimes = sdf.format(new Date().getTime());
				setXLValues(SheetName1, 9, statusRow, "Fail");
				setReports(SheetName1, 12, reportStatus, "Alert not works");
				setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));				
			}
			break;	
			
		case "alerttext":

			try {
			// now copy the  screenshot to desired location using copyFile method
			Alert alertDialog = Execution.driver.switchTo().alert();
			String alertText = alertDialog.getText();
			endTimes = sdf.format(new Date().getTime());
			setXLValues(SheetName1, 9, statusRow, "Pass");
			setXLValues(SheetName1, 7, statusRow, alertText);
    		setReports(SheetName1, 12, reportStatus, "Got Text");
            setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
         
			} 
			catch (Exception e)
			{ 
				 System.out.println(e.getMessage()); 
				endTimes = sdf.format(new Date().getTime());
				setXLValues(SheetName1, 9, statusRow, "Fail");
        		setReports(SheetName1, 12, reportStatus, "Not Get Text");
                setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));                
			 }			 
           break;
           
		case "autodownload":
            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", chromePrefs);
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            cap.setCapability(ChromeOptions.CAPABILITY, options);
            endTimes = sdf.format(new Date().getTime());
            try{
                setXLValues(SheetName1, 9, statusRow, "Pass");
                setReports(SheetName1, 12, reportStatus, "Successfully Downloaded");
                setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
           } catch (Exception e){
               
               endTimes = sdf.format(new Date().getTime());
               setXLValues(SheetName1, 9, statusRow, "Fail");
               setReports(SheetName1, 12, reportStatus, "Download Failed");
               setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
           }
           break;  
           
		case "autodownloadf":
            
            try{
               
            	FirefoxProfile firefoxProfile=new FirefoxProfile();
                firefoxProfile.setPreference("browser.download.dir", "Test-result/"); 
                firefoxProfile.setPreference("browser.download.folderList", 2); 
                  //Set Preference to not show file download confirmation dialogue using MIME types Of different file extension types. 
                firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;"
                          + "text/csv;"
                          + "text/xml;"
                          + "text/html");
                firefoxProfile.setPreference( "browser.download.manager.showWhenStarting", false ); 
                firefoxProfile.setPreference( "pdfjs.disabled", true );
           
            endTimes = sdf.format(new Date().getTime());
           
                setXLValues(SheetName1, 9, statusRow, "Pass");
                setReports(SheetName1, 12, reportStatus, "Successfully Downloaded");
                setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
           } catch (Exception e){
             
               endTimes = sdf.format(new Date().getTime());
               setXLValues(SheetName1, 9, statusRow, "Fail");
               setReports(SheetName1, 12, reportStatus, "Download Failed");
               setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
           }
           break;
           
		case "back":
			
			Execution.driver.navigate().back();
			break;   
			
		case "backspace":
			try{
			
			SpecialFunctions.Backspace(xpath, value);	
			endTimes = sdf.format(new Date().getTime());

			setXLValues(SheetName1, 9, statusRow, "Pass");
			setReports(SheetName1, 12, reportStatus, "Text Cleared");
			setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));


			}catch (Exception e) {
				endTimes = sdf.format(new Date().getTime());

				setXLValues(SheetName1, 9, statusRow, "Fail");
				setReports(SheetName1, 12, reportStatus, "Text Not Cleared");
				setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));

				getScreenshot(xpath);
			}
			
			break;	
			
		case "click":
			try{
				
			getXpathElement(xpath).click();
			endTimes = sdf.format(new Date().getTime());
			
			setXLValues(SheetName1, 9, statusRow, "Pass");	
			setReports(SheetName1, 12, reportStatus, "Element clicked");
			setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
			
			} catch (Exception e){
				
				endTimes = sdf.format(new Date().getTime());
				setXLValues(SheetName1, 9, statusRow, "Fail");
				setReports(SheetName1, 12, reportStatus, "Element not clicked");
				setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
			}
			
			break;
			
		case "waitandclick":
			try{
				
			//AppiumSetup.WaitAndClick(xpath);
			endTimes = sdf.format(new Date().getTime());
			
			setXLValues(SheetName1, 9, statusRow, "Pass");	
			setReports(SheetName1, 12, reportStatus, "Element clicked");
			setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
			
			} catch (Exception e){
				
				endTimes = sdf.format(new Date().getTime());
				setXLValues(SheetName1, 9, statusRow, "Fail");
				setReports(SheetName1, 12, reportStatus, "Element not clicked");
				setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
			}
			
			break;
			
		case "waitandsendkeys":
			try{
				
			//AppiumSetup.WaitAndSendKeys(xpath, value);
			endTimes = sdf.format(new Date().getTime());
			
			setXLValues(SheetName1, 9, statusRow, "Pass");	
			setReports(SheetName1, 12, reportStatus, "Element clicked");
			setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
			
			} catch (Exception e){
				
				endTimes = sdf.format(new Date().getTime());
				setXLValues(SheetName1, 9, statusRow, "Fail");
				setReports(SheetName1, 12, reportStatus, "Element not clicked");
				setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
			}
			
			break;	
		case "clear":
			try{
			
			getXpathElement(xpath).clear();	
			endTimes = sdf.format(new Date().getTime());

			setXLValues(SheetName1, 9, statusRow, "Pass");
			setReports(SheetName1, 12, reportStatus, "Text Cleared");
			setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));

			}catch (Exception e) {
				endTimes = sdf.format(new Date().getTime());
				
				setXLValues(SheetName1, 9, statusRow, "Fail");
				setReports(SheetName1, 12, reportStatus, "Text Not Cleared");
				setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
				
				getScreenshot(xpath);
				
			}
			
			break;		
		
		case "clickall":	
			SpecialFunctions.clickall(xpath);
			break;
			
		case "clickmultiple":	
			SpecialFunctions.clickmultiple(xpath, value);
			break;	
		
		case "child1window":    
	           
	           try{
	           
	               Set<String> WINDOWIDS= driver.getWindowHandles();
	               Iterator<String> iter=WINDOWIDS.iterator();    
	               String Window1=iter.next();//Returns first window id
	               String Window2=iter.next();//Returns second window id
	               System.out.println(Window1);
	               System.out.println(Window2);
	               driver.switchTo().window(Window2);
	               Thread.sleep(3000);
	               setXLValues(SheetName1, 9, statusRow, "Pass");    
	               setReports(SheetName1, 12, reportStatus, "Window Handle works");
	               setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
	               
	               } catch (Exception e){
	                  
	                   endTimes = sdf.format(new Date().getTime());
	                   setXLValues(SheetName1, 9, statusRow, "Fail");
	                   setReports(SheetName1, 12, reportStatus, "Window Handle not works");
	                   setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
	               }
	               break;
	               
		case "color":
            try{
            String color = Execution.driver.findElement(By.xpath(xpath)).getCssValue("background-color");
            System.out.println(color);
            endTimes = sdf.format(new Date().getTime());
            setXLValues(SheetName1, 9, statusRow, "Pass");    
            setXLValues(SheetName1, 7, statusRow, color);
            setReports(SheetName1, 12, reportStatus, "Color Same");
            setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
        }   
            catch (Exception e)
            {
        endTimes = sdf.format(new Date().getTime());
        setXLValues(SheetName1, 9, statusRow, "Fail");    
        setReports(SheetName1, 12, reportStatus, "Color not Same");
        setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
            }
        break;
             
		case "colorcomp" :
            try{
                String one = Execution.driver.findElement(By.xpath(xpath)).getCssValue("background-color");
                System.out.println(one);
                String two = Execution.driver.findElement(By.xpath(value)).getCssValue("background-color");
                System.out.println(two);
                    if(one.equals(two)){
                endTimes = sdf.format(new Date().getTime());
                setXLValues(SheetName1, 9, statusRow, "Pass");    
                setReports(SheetName1, 12, reportStatus, "Color Same");
                setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
            }}
        catch (Exception e)
        {
            endTimes = sdf.format(new Date().getTime());
            setXLValues(SheetName1, 9, statusRow, "Pass");    
            setReports(SheetName1, 12, reportStatus, "Color not Same");
            setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
        }
            break;
        
		case "closetab":
            try{
                  ArrayList<String> tabs2 = new ArrayList<String> (Execution.driver.getWindowHandles());
                  Execution.driver.close();
                    Execution.driver.switchTo().window(tabs2.get(0));
             endTimes = sdf.format(new Date().getTime());
                setXLValues(SheetName1, 9, statusRow, "Pass");
                setReports(SheetName1, 12, reportStatus, "Successfully Closed");
                setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
            }catch (Exception e){
                endTimes = sdf.format(new Date().getTime());
                setXLValues(SheetName1, 9, statusRow, "Fail");
                setReports(SheetName1, 12, reportStatus, "Failed to close");
                setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
            }
            break;  
		
		case "checkcontent":
			
			//Select archiveList = new Select(Execution.driver.findElement(By.xpath(xpath)));
            String actual = getXpathElement(xpath).getText();
            //String actual = archiveList.getFirstSelectedOption().getText();
			
			endTimes = sdf.format(new Date().getTime());
			
			
			if(actual.equals(expected)){
			setXLValues(SheetName1, 9, statusRow, "Pass");
			setXLValues(SheetName1, 7, statusRow, actual);
			setReports(SheetName1, 12, reportStatus, "Content matched");
			setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));

			}else 
			{
			
			endTimes = sdf.format(new Date().getTime());
			
			setXLValues(SheetName1, 9, statusRow, "Fail");
			setXLValues(SheetName1, 7, statusRow, actual);
			setReports(SheetName1, 12, reportStatus, "Contents mismatched");		
			setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
			
			}
			break;    
		
		case "checkcb":
			
			WebElement cb1 = Execution.driver.findElement(By.xpath(xpath));
			endTimes = sdf.format(new Date().getTime());
			
			if(cb1.isSelected())
			{
				
				setXLValues(SheetName1, 9, statusRow, "Fail");
				setReports(SheetName1, 12, reportStatus, "Checkbox Already Enabled");
				setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
			}
			else 
			{
				cb1.click();
			endTimes = sdf.format(new Date().getTime());
			
			setXLValues(SheetName1, 9, statusRow, "Pass");
			setReports(SheetName1, 12, reportStatus, "Checkbox checked");		
			setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
			
			}
			break;	
			
		case "chromeprivate":
            SpecialFunctions.cprivateb(value);
               break;	
		
		case "closerobot":	
			
			try{
				
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_ALT);
				r.keyPress(KeyEvent.VK_F4);
				r.keyRelease(KeyEvent.VK_F4);
				r.keyRelease(KeyEvent.VK_ALT);
				endTimes = sdf.format(new Date().getTime());

				setXLValues(SheetName1, 9, statusRow, "Pass");
				setReports(SheetName1, 12, reportStatus, "Alt F4 Pressed");
				setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));


				}catch (Exception e) {
					endTimes = sdf.format(new Date().getTime());

					setXLValues(SheetName1, 9, statusRow, "Fail");
					setReports(SheetName1, 12, reportStatus, "Alt F4 Not Work");
					setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
					
				}
			break;   
		
		case "ctrlw":    
	           try{	                
	                //Execution.driver.findElement(By.xpath(xpath)).sendKeys(Keys.END);
	                Actions actionObject = new Actions(Execution.driver);
	                actionObject.sendKeys(Keys.chord(Keys.CONTROL, "w"));
	                endTimes = sdf.format(new Date().getTime());
	                
	                setXLValues(SheetName1, 9, statusRow, "Pass");
	                setReports(SheetName1, 12, reportStatus, "EndKey Entered");
	                setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));

	                }catch (Exception e) {
	                    endTimes = sdf.format(new Date().getTime());

	                    setXLValues(SheetName1, 9, statusRow, "Fail");
	                    setReports(SheetName1, 12, reportStatus, "EndKey Not entered");
	                    setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));

	                    getScreenshot(xpath);	                    
	                }
	           break;
		
		    
		case "doubleclick":
			try{
				
			WebElement el = getXpathElement(xpath);
			Actions builder = new Actions(Execution.driver);
			builder.doubleClick(el).build().perform();
			endTimes = sdf.format(new Date().getTime());
			
			setXLValues(SheetName1, 9, statusRow, "Pass");	
			setReports(SheetName1, 12, reportStatus, "Element Doubleclicked");
			setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
			
			} catch (Exception e){
				
				endTimes = sdf.format(new Date().getTime());
				setXLValues(SheetName1, 9, statusRow, "Fail");
				setReports(SheetName1, 12, reportStatus, "Element not Doubleclicked");
				setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
			}
			
			break;	
			
		case "dropdown":
			
			try{
				
				Select ddlvalue = new Select(Execution.driver.findElement(By.xpath(xpath)));
				
				ddlvalue.selectByVisibleText(value);
				
			endTimes = sdf.format(new Date().getTime());
			
			setXLValues(SheetName1, 9, statusRow, "Pass");
			setReports(SheetName1, 12, reportStatus, "Dropdown works");
			setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
			
			
			}catch(Exception e){
			
			endTimes = sdf.format(new Date().getTime());
	
			setXLValues(SheetName1, 9, statusRow, "Fail");
			setReports(SheetName1, 12, reportStatus, "Dropdown not works");
			setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));

			}
			break;
			
		case "dragandrop":
            try{
            Actions act=new Actions(driver);
            WebElement drag=driver.findElement(By.xpath(xpath));
            WebElement drop=driver.findElement(By.xpath(value));
            act.dragAndDrop(drag, drop).build().perform();
            setXLValues(SheetName1, 9, statusRow, "Pass");    
            setReports(SheetName1, 12, reportStatus, "Worked");
            setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
            
            } catch (Exception e){
                
                endTimes = sdf.format(new Date().getTime());
                setXLValues(SheetName1, 9, statusRow, "Fail");
                setReports(SheetName1, 12, reportStatus, "Not Worked");
                setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
            }
            
            break;
            
		case "downarrow":                     
			  
			try{
			
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
				endTimes = sdf.format(new Date().getTime());

				setXLValues(SheetName1, 9, statusRow, "Pass");
				setReports(SheetName1, 12, reportStatus, "Enter key Pressed");
				setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));


				}catch (Exception e) {
					endTimes = sdf.format(new Date().getTime());

					setXLValues(SheetName1, 9, statusRow, "Fail");
					setReports(SheetName1, 12, reportStatus, "EnterKey Not Work");
					setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
				}
	
			break;
			
		case "space":                     
			  
			try{
			
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_SPACE);
				r.keyRelease(KeyEvent.VK_SPACE);
				endTimes = sdf.format(new Date().getTime());

				setXLValues(SheetName1, 9, statusRow, "Pass");
				setReports(SheetName1, 12, reportStatus, "Space given");
				setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));


				}catch (Exception e) {
					endTimes = sdf.format(new Date().getTime());

					setXLValues(SheetName1, 9, statusRow, "Fail");
					setReports(SheetName1, 12, reportStatus, "Space not given");
					setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
				}
	
			break;
			
		
		
		case "duplicate":
            boolean isDuplicateFound = Execution.driver.findElements(By.xpath(xpath)).size()>1;
            List <WebElement> NoofDuplicates=Execution.driver.findElements(By.xpath(xpath));  
                if(isDuplicateFound){
                System.out.println("No of Duplicate Count = "+NoofDuplicates.size());
                endTimes = sdf.format(new Date().getTime());
                setXLValues(SheetName1, 9, statusRow, "Fail");
                setReports(SheetName1, 12, reportStatus, "Duplicate Found");
                setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
            }else{
                System.out.println(" Duplicate Not Found");    
                endTimes = sdf.format(new Date().getTime());
                setXLValues(SheetName1, 9, statusRow, "Pass");
                setReports(SheetName1, 12, reportStatus, "Duplicate Not Found");
                setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
            }
            
            break;
            
		case "elementpresent":
	           try{          
	        	   if(Execution.driver.findElements(By.xpath(xpath)).size()!= 0){
	        		   
	               endTimes = sdf.format(new Date().getTime());                
	               setXLValues(SheetName1, 9, statusRow, "Pass");
	               setReports(SheetName1, 12, reportStatus, "Element Present");
	               setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
	               }              
	               }
	   catch (Exception e) {
	                   endTimes = sdf.format(new Date().getTime());                
	                   setXLValues(SheetName1, 9, statusRow, "Fail");
	                   setReports(SheetName1, 12, reportStatus, "Element Not Present");
	                   setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));          
	                   getScreenshot(xpath);
	               }    
	           
	           break;
	    
		case "elementnotpresent":
	           try{          
	        	   if(Execution.driver.findElements(By.xpath(xpath)).size()== 0){
	        		   
	               endTimes = sdf.format(new Date().getTime());                
	               setXLValues(SheetName1, 9, statusRow, "Pass");
	               setReports(SheetName1, 12, reportStatus, "Element Not Available");
	               setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
	               }              
	               }
	   catch (Exception e) {
	                   endTimes = sdf.format(new Date().getTime());                
	                   setXLValues(SheetName1, 9, statusRow, "Fail");
	                   setReports(SheetName1, 12, reportStatus, "Some Element Available");
	                   setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));          
	                   getScreenshot(xpath);
	                   
	               }    
	           
	           break;       
		
		case "enter":
			try{
			
			getXpathElement(xpath).clear();	
			getXpathElement(xpath).sendKeys(value);
			endTimes = sdf.format(new Date().getTime());

			setXLValues(SheetName1, 9, statusRow, "Pass");
			setReports(SheetName1, 12, reportStatus, "Elements entered");
			setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));


			}catch (Exception e) {
				endTimes = sdf.format(new Date().getTime());

				setXLValues(SheetName1, 9, statusRow, "Fail");
				setReports(SheetName1, 12, reportStatus, "Elements not entered");
				setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));

				getScreenshot(xpath);
			}
			
			break; 
			
		case "enterwc":
			try{
			
			//getXpathElement(xpath).clear();	
			getXpathElement(xpath).sendKeys(value);
			endTimes = sdf.format(new Date().getTime());

			setXLValues(SheetName1, 9, statusRow, "Pass");
			setReports(SheetName1, 12, reportStatus, "Elements entered");
			setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));


			}catch (Exception e) {
				endTimes = sdf.format(new Date().getTime());

				setXLValues(SheetName1, 9, statusRow, "Fail");
				setReports(SheetName1, 12, reportStatus, "Elements not entered");
				setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));

				getScreenshot(xpath);
			}
			
			break;    
		case "end":    
	           try{
	                
	                //Execution.driver.findElement(By.xpath(xpath)).sendKeys(Keys.END);
	                Actions actionObject = new Actions(Execution.driver);
	                actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
	                endTimes = sdf.format(new Date().getTime());

	                setXLValues(SheetName1, 9, statusRow, "Pass");
	                setReports(SheetName1, 12, reportStatus, "EndKey Entered");
	                setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));

	                }catch (Exception e) {
	                    endTimes = sdf.format(new Date().getTime());
	                    
	                    setXLValues(SheetName1, 9, statusRow, "Fail");
	                    setReports(SheetName1, 12, reportStatus, "EndKey Not entered");
	                    setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
	                    
	                    getScreenshot(xpath);
	                    
	                }	
	           break;	
		case "escape":	
			
			try{
				
				Execution.driver.findElement(By.xpath(xpath)).sendKeys(Keys.ESCAPE);
				endTimes = sdf.format(new Date().getTime());

				setXLValues(SheetName1, 9, statusRow, "Pass");
				setReports(SheetName1, 12, reportStatus, "Escape Worked");
				setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));

				}catch (Exception e) {
					endTimes = sdf.format(new Date().getTime());

					setXLValues(SheetName1, 9, statusRow, "Fail");
					setReports(SheetName1, 12, reportStatus, "Escape Not Worked");
					setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
					
				}
			break;	
			
		case "escapek":
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ESCAPE).build().perform();
            endTimes = sdf.format(new Date().getTime());
            setXLValues(SheetName1, 9, statusRow, "Pass");
            setReports(SheetName1, 12, reportStatus, "Matched text");
            setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
            break;
            
		case "enterbutton":	
				
			try{
				
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
				endTimes = sdf.format(new Date().getTime());

				setXLValues(SheetName1, 9, statusRow, "Pass");
				setReports(SheetName1, 12, reportStatus, "Enter key Pressed");
				setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
				
				}catch (Exception e) {
					endTimes = sdf.format(new Date().getTime());

					setXLValues(SheetName1, 9, statusRow, "Fail");
					setReports(SheetName1, 12, reportStatus, "EnterKey Not Work");
					setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
					
				}
			break;		
		
		case "entirescreenshot":
	           try{
	               Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
	               ImageIO.write(fpScreenshot.getImage(),"PNG",new File("Screenshots/"+System.currentTimeMillis()+".png"));

	               endTimes = sdf.format(new Date().getTime());
	               setXLValues(SheetName1, 9, statusRow, "Pass");    
	               setReports(SheetName1, 12, reportStatus, "Overall Screenshot taken");
	               setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
	           } catch (Exception e){
	               
	               endTimes = sdf.format(new Date().getTime());
	               setXLValues(SheetName1, 9, statusRow, "Fail");
	               setReports(SheetName1, 12, reportStatus, "Overallscreenshot Not Taken");
	               setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes)); 
	           }
	           
	           break;
	           
		case "elementshot":
            try{
              WebElement webElement = driver.findElement(By.xpath(xpath));
              Screenshot screenshot = new AShot().takeScreenshot(driver,webElement);
               ImageIO.write(screenshot.getImage(),"PNG",new File(System.getProperty("Screenshots/"+System.currentTimeMillis()+value+".png")));
            System.out.println("Taken Screenshot");
            endTimes = sdf.format(new Date().getTime());
            setXLValues(SheetName1, 9, statusRow, "Pass");    
            setReports(SheetName1, 12, reportStatus, "Screenshot taken");
            setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
         } catch (Exception e){
            
            endTimes = sdf.format(new Date().getTime());
            setXLValues(SheetName1, 9, statusRow, "Fail");
            setReports(SheetName1, 12, reportStatus, "screenshot Not Taken");
            setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));

        }
            break;    
            
		case "forward":
			System.out.println("started");
			Execution.driver.navigate().forward();
			System.out.println("F completed");
			break;     
		
		case "fonts":    
	           try{
	        	   WebElement fs4= Execution.driver.findElement(By.xpath(xpath));
	        	   String fs5 = fs4.getCssValue("font-size");
	        	   System.out.println(fs5);
	                endTimes = sdf.format(new Date().getTime());
	                
	                setXLValues(SheetName1, 7, statusRow, fs5);
	                setXLValues(SheetName1, 9, statusRow, "Pass");
	                setReports(SheetName1, 12, reportStatus, "Size of text");
	                setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));

	                }catch (Exception e) {
	                    endTimes = sdf.format(new Date().getTime());
	                    
	                    setXLValues(SheetName1, 9, statusRow, "Fail");
	                    setReports(SheetName1, 12, reportStatus, "Unable to find size check xpath");
	                    setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
	                    
	                    getScreenshot(xpath);
	                    
	                }	
	           break; 
	           
		case "gettext":
			
 				String get = Execution.driver.findElement(By.xpath(xpath)).getText();
 				//String get = getXpathElement(xpath).getText();
 	            
 				endTimes = sdf.format(new Date().getTime());
 			
 				if(get.length()!=0){
 				setXLValues(SheetName1, 9, statusRow, "Pass");
 				setXLValues(SheetName1, 7, statusRow, get);
 				setReports(SheetName1, 12, reportStatus, "get text passed");
 				setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
 				}
		
 				else {
 					setXLValues(SheetName1, 9, statusRow, "Fail");
 	 				setReports(SheetName1, 12, reportStatus, "get text failed");
 	 				setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
 				}
 				break;
         case "cssgettext":
			
			String cssget = driver.findElement(By.cssSelector(xpath)).getText();
            
			endTimes = sdf.format(new Date().getTime());
			
			if(cssget.length()!=0){
			setXLValues(SheetName1, 9, statusRow, "Pass");
			setXLValues(SheetName1, 8, statusRow, cssget);
			setReports(SheetName1, 12, reportStatus, "css get text");
			setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));

			}
			else {
					setXLValues(SheetName1, 9, statusRow, "Fail");
	 				setReports(SheetName1, 12, reportStatus, "css get text failed");
	 				setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
				}
			break;
         case "csscheckcontent":
 			
 			//Select archiveList = new Select(Execution.driver.findElement(By.xpath(xpath)));
             String cssactual = driver.findElement(By.cssSelector(xpath)).getText();
             //String actual = archiveList.getFirstSelectedOption().getText();
 			
 			endTimes = sdf.format(new Date().getTime());
 			
 			
 			if(cssactual.equals(expected)){
 			setXLValues(SheetName1, 9, statusRow, "Pass");
 			setXLValues(SheetName1, 7, statusRow, cssactual);
 			setReports(SheetName1, 12, reportStatus, "Content matched");
 			setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));

 			}else 
 			{
 			
 			endTimes = sdf.format(new Date().getTime());
 			
 			setXLValues(SheetName1, 9, statusRow, "Fail");
 			setXLValues(SheetName1, 7, statusRow, cssactual);
 			setReports(SheetName1, 12, reportStatus, "Contents mismatched");		
 			setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
 			
 			}
 			break;
 			
 				
 				
 		case "gettextcompare":
 		          
 		        	   String gettext1 = getXpathElement(xpath).getText();
 		        	   Execution.driver.navigate().to(value);
 		        	   wait.until(new Function<WebDriver, Boolean>() {
 							public Boolean apply(WebDriver driver) {
 							return String
 							.valueOf(((JavascriptExecutor) Execution.driver).executeScript("return document.readyState"))
 							.equals("complete");
 							}
 							});
 		        	   String gettext2 = getXpathElement(expected).getText();
 		        	   endTimes = sdf.format(new Date().getTime());
 		   			
 		   			if(gettext1.equals(gettext2)){
 		   			setXLValues(SheetName1, 9, statusRow, "Pass");
 		   			setXLValues(SheetName1, 7, statusRow, gettext1);
 		   			setReports(SheetName1, 12, reportStatus, "Content matched");
 		   			setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));

 		   			}else 
 		   			{
 		   			endTimes = sdf.format(new Date().getTime());
 		   			
 		   			setXLValues(SheetName1, 9, statusRow, "Fail");
 		   			setXLValues(SheetName1, 7, statusRow, gettext1);
 		   			setReports(SheetName1, 12, reportStatus, "Contents mismatched");		
 		   			setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
 		   			
 		   			}
 		           
 		   			break;
 		   	
 		case "gettextinput":
 				try{  
 	     	   String gettexti1 = getXpathElement(xpath).getText();
 	     	   Execution.driver.navigate().to(value);
 	     	   wait.until(new Function<WebDriver, Boolean>() {
 						public Boolean apply(WebDriver driver) {
 						return String
 						.valueOf(((JavascriptExecutor) Execution.driver).executeScript("return document.readyState"))
 						.equals("complete");
 						}
 						});
 	     	    getXpathElement(xpath).clear();	
 				getXpathElement(xpath).sendKeys(value);
 				endTimes = sdf.format(new Date().getTime());
 	     	    
 				setXLValues(SheetName1, 9, statusRow, "Pass");
 				setXLValues(SheetName1, 7, statusRow, gettexti1);
 				setReports(SheetName1, 12, reportStatus, "Content matched");
 				setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));

 				}catch (Exception e) {
 				
 				endTimes = sdf.format(new Date().getTime());
 				
 				setXLValues(SheetName1, 9, statusRow, "Fail");
 				setReports(SheetName1, 12, reportStatus, "Contents mismatched");		
 				setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
 				
 				}
 				break;	
 		case "getsize":
 				
 				Dimension dimensionSize = Execution.driver.findElement(By.xpath(xpath)).getSize();
 				
 				int dimensionWidth = dimensionSize.width;
 				int dimensionHeight = dimensionSize.height;
 				
 				try{
 				
 				endTimes = sdf.format(new Date().getTime());
 				
 					
 				setXLValues(SheetName1, 9, statusRow, "Pass");
 				setXLValues(SheetName1, 13, reportStatus, "(" +String.valueOf(dimensionWidth)+" , "+ String.valueOf(dimensionHeight)+ ")");
 				setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
 				setReports(SheetName1, 12, reportStatus, "Size works fine");
 				
 				System.out.println("Dimension width is "+dimensionWidth);
 				System.out.println("Dimension height is "+dimensionHeight);
 				} catch(Exception e){
 					
 					endTimes = sdf.format(new Date().getTime());

 					setXLValues(SheetName1, 9, statusRow, "Fail");
 					setXLValues(SheetName1, 13, reportStatus, String.valueOf(dimensionWidth)+" , "+ String.valueOf(dimensionHeight));
 					setReports(SheetName1, 12, reportStatus, "Size doesn't work");
 					setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
 					
 				}
 				
 				break;
 				
 		case "getlocation":
 				
 				Point point = Execution.driver.findElement(By.xpath(xpath)).getLocation();
 				int xLocation = point.x;
 				int yLocation = point.y;
 				try{
 					
 				endTimes = sdf.format(new Date().getTime());	
 				
 				setXLValues(SheetName1, 9, statusRow, "Pass");
 				setXLValues(SheetName1, 13, reportStatus, "(" +String.valueOf(xLocation)+" , "+ String.valueOf(yLocation)+ ")");
 				setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
 				setReports(SheetName1, 12, reportStatus, "Location works fine");
 				
 				} catch(Exception e){

 					endTimes = sdf.format(new Date().getTime());

 					setXLValues(SheetName1, 9, statusRow, "Fail");
 					setXLValues(SheetName1, 13, reportStatus, String.valueOf(xLocation)+" , "+ String.valueOf(yLocation));
 					setReports(SheetName1, 12, reportStatus, "Location doesn't work");
 					setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));	
 					
 				}
 				break;		
 		
 		case "gettitle":
 			
 			String title = Execution.driver.getTitle();
 			try{
 			
 			setXLValues(SheetName1, 7, statusRow, title);
 			}catch(Exception e){
 				
 				setXLValues(SheetName1, 9, statusRow, "Fail");
 				
 			}
 			
 			break;    
 			
 		case "home":    
            try{		
            			
            Execution.driver.findElement(By.xpath(xpath)).sendKeys(Keys.HOME);
            endTimes = sdf.format(new Date().getTime());

            setXLValues(SheetName1, 9, statusRow, "Pass");
            setReports(SheetName1, 12, reportStatus, "HomeKey Entered");
            setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));

            }catch (Exception e) {
                endTimes = sdf.format(new Date().getTime());

                setXLValues(SheetName1, 9, statusRow, "Fail");
                setReports(SheetName1, 12, reportStatus, "HomeKey Not entered");
                setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
                getScreenshot(xpath);
                
            }	
        break;        
		
		case "Horizontal":
            JavascriptExecutor jsx1 = (JavascriptExecutor) Execution.driver;
            jsx1.executeScript("window.scrollBy(-1500,0)", "");
            String elementId1 = "element-id";
            String html1 =(String) jsx1.executeScript("return document.getElementById('" + elementId1 + "').innerHTML;");
            break;   
        
		case "isempty":
			
			WebElement inputBox = Execution.driver.findElement(By.xpath(xpath));
			String textInsideInputBox = inputBox.getAttribute("value");
			
			endTimes = sdf.format(new Date().getTime());
			
			if(textInsideInputBox.isEmpty())
			{
				setXLValues(SheetName1, 9, statusRow, "Pass");
				setXLValues(SheetName1, 7, statusRow, textInsideInputBox);
				setReports(SheetName1, 12, reportStatus, "Field Empty");
				setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
			}
			else 
			{
			
			endTimes = sdf.format(new Date().getTime());
			
			setXLValues(SheetName1, 9, statusRow, "Fail");
			setXLValues(SheetName1, 7, statusRow, textInsideInputBox);
			setReports(SheetName1, 12, reportStatus, "Field Not Empty");		
			setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
			
			}
			break;
			
case "isenabled":
			
			boolean inputBoxd = Execution.driver.findElement(By.xpath(xpath)).isEnabled();
			
			endTimes = sdf.format(new Date().getTime());
			
			try
			{
				setXLValues(SheetName1, 9, statusRow, "Pass");
				setReports(SheetName1, 12, reportStatus, "Enabled");
				setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
			}
			catch(Exception e)
			{
			
			endTimes = sdf.format(new Date().getTime());
			
			setXLValues(SheetName1, 9, statusRow, "Fail");
			setReports(SheetName1, 12, reportStatus, " Not Enabled");		
			setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
			
			}
			break;	
			
		case "imagecomparison":

            File fileInput = new File(xpath);
            File fileOutPut = new File(value);

            BufferedImage bufileInput = ImageIO.read(fileInput);
            DataBuffer dafileInput = bufileInput.getData().getDataBuffer();
            int sizefileInput = dafileInput.getSize();                    
            BufferedImage bufileOutPut = ImageIO.read(fileOutPut);
            DataBuffer dafileOutPut = bufileOutPut.getData().getDataBuffer();
            int sizefileOutPut = dafileOutPut.getSize();
            Boolean matchFlag = true;
            if(sizefileInput == sizefileOutPut) {    
                setXLValues(SheetName1, 9, statusRow, "Pass");
                //setXLValues(SheetName1, 7, statusRow, actual);
                setReports(SheetName1, 12, reportStatus, "Image matched");
                setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));

                }else 
                {
                
                endTimes = sdf.format(new Date().getTime());
                
                setXLValues(SheetName1, 9, statusRow, "Fail");
                //setXLValues(SheetName1, 7, statusRow, actual);
                setReports(SheetName1, 12, reportStatus, "Image not matched");        
                setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
                
                }
                break; 
        
		case "loop":
            
            for (int j=1;; j++ )
               {
                if(j >Integer.valueOf(value)){
                    break;}
                       
                Execution.driver.findElement(By.xpath(".//input[@name='CustEmail']")).clear();
                Execution.driver.findElement(By.xpath(".//input[@name='CustEmail']")).sendKeys("usename"+j+"@gmail.com");
                Execution.driver.findElement(By.xpath(".//input[@name='CustPhone']")).clear();
                String randomNumbers = RandomStringUtils.randomNumeric(10);
                Execution.driver.findElement(By.xpath(".//input[@name='CustPhone']")).sendKeys(randomNumbers);
                 System.out.println(randomNumbers);
                       System.out.println("usename"+j+"@gmail.com");      
                       Execution.driver.findElement(By.xpath(".//*[@id='submitted']")).click();
                       driver.navigate().back();
               }
  //Nandhini Finished 
        
		case "maximize":
			
			Execution.driver.manage().window().maximize();
			
			break;	
		case "mouseover":
			
			try{
			Actions Mo = new Actions(Execution.driver);
			
			WebElement mousehover = getXpathElement(xpath);
			Mo.moveToElement(mousehover).perform();
			
			endTimes = sdf.format(new Date().getTime());

			setXLValues(SheetName1, 9, statusRow, "Pass");
			setReports(SheetName1, 12, reportStatus, "Mouse-hover works");
			setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));

			}catch (Exception e){

				endTimes = sdf.format(new Date().getTime());
				setXLValues(SheetName1, 9, statusRow, "Fail");
				setReports(SheetName1, 12, reportStatus, "Mouse-hover not works");
				setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));

			}
			
			break;    
			
		case "navigate":
			try{
				
				Execution.driver.navigate().to(value);
				endTimes = sdf.format(new Date().getTime());
				
				setXLValues(SheetName1, 9, statusRow, "Pass");	
				setReports(SheetName1, 12, reportStatus, "Navigated");
				setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
				
				} catch (Exception e){
					
					endTimes = sdf.format(new Date().getTime());
					setXLValues(SheetName1, 9, statusRow, "Fail");
					setReports(SheetName1, 12, reportStatus, "Navigation Not");
					setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
				}
			break;
			
		case "newtab":
	           try{
	        	   Execution.driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
	            endTimes = sdf.format(new Date().getTime());
	               setXLValues(SheetName1, 9, statusRow, "Pass");
	               setReports(SheetName1, 12, reportStatus, "Successfully Opened New tab");
	               setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
	           }catch (Exception e){
	               endTimes = sdf.format(new Date().getTime());
	               setXLValues(SheetName1, 9, statusRow, "Fail");
	               setReports(SheetName1, 12, reportStatus, "New tab Not open");
	               setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
	           }
	           break;	
		
		case "pagetext":
            Execution.driver.getPageSource().contains(value);
            try{
                endTimes = sdf.format(new Date().getTime());
                setXLValues(SheetName1, 9, statusRow, "Pass");    
                setReports(SheetName1, 12, reportStatus, "Text present on the page");
                setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
                
                } catch (Exception e){
                    
                    endTimes = sdf.format(new Date().getTime());
                    setXLValues(SheetName1, 9, statusRow, "Fail");
                    setReports(SheetName1, 12, reportStatus, "Text Not Present");
                    setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
                }
                break;
	
   
	   case "pagination":
	           try{
	               List pagination =Execution.driver.findElements(By.xpath(xpath));
	               int size= pagination.size();
	                           for(int i=1; i<size; ++i){
	                                   driver.navigate().to(value+i);
	                               //Execution.driver.findElement(By.xpath(value+i)).click() ;
	                               Thread.sleep(3000);
	                               String text=Execution.driver.findElement(By.xpath(expected)).getText();
	                               System.out.println(text);
	                               System.out.println("Loop "+i);
	                               endTimes = sdf.format(new Date().getTime());
	                   setXLValues(SheetName1, 9, statusRow, "Pass");
	                   setReports(SheetName1, 12, reportStatus, "Pagination Successfull");
	                   setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
	               } }catch (Exception e){
	                  endTimes = sdf.format(new Date().getTime());
	                  setXLValues(SheetName1, 9, statusRow, "Fail");
	                  setReports(SheetName1, 12, reportStatus, "Pagination Not available");
	                  setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
	              }
	               
	               break;  
		 case "presence":
	           try{
	               
	               if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).isDisplayed()){
	               endTimes = sdf.format(new Date().getTime());                
	               setXLValues(SheetName1, 9, statusRow, "Pass");
	               setReports(SheetName1, 12, reportStatus, "Element Present");
	               setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
	               }              
	               }
	           catch (Exception e) {
	                   endTimes = sdf.format(new Date().getTime());                
	                   setXLValues(SheetName1, 9, statusRow, "Fail");
	                   setReports(SheetName1, 12, reportStatus, "Element Not Present");
	                   setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));          
	                   getScreenshot(xpath);
	                   
	               }    
	           
	           break;	
	   
		 case "parentwindow":
			    try{
			         Set<String> WINDOWIDS= driver.getWindowHandles();
			        Iterator<String> iter=WINDOWIDS.iterator();    
			        String Window1=iter.next();//Returns first window id
			            driver.switchTo().window(Window1);  
			      setXLValues(SheetName1, 9, statusRow, "Pass");    
			      setReports(SheetName1, 12, reportStatus, "Window Handle works");
			      setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
			     
			     
			      } catch (Exception e){
			         
			          endTimes = sdf.format(new Date().getTime());
			          setXLValues(SheetName1, 9, statusRow, "Fail");
			          setReports(SheetName1, 12, reportStatus, "Window Handle not works");
			          setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
			      }
			      break;
		 case "refresh":
				Execution.driver.navigate().refresh();
				
				break;
			
		 case "rightarrow":  
			 
				  try{
					SpecialFunctions.rightarrow(xpath, value);  
					endTimes = sdf.format(new Date().getTime());
					setXLValues(SheetName1, 9, statusRow, "Pass");
					setReports(SheetName1, 12, reportStatus, "RightArrow key Pressed");
					setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
					}catch (Exception e) {
						endTimes = sdf.format(new Date().getTime());
						setXLValues(SheetName1, 9, statusRow, "Fail");
						setReports(SheetName1, 12, reportStatus, "RightArrow Key Not Work");
						setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
					}
				break;
				
			case "randomchar":
				
				getXpathElement(xpath).clear();	
				getXpathElement(xpath).sendKeys(SpecialFunctions.generateRandomString(Integer.parseInt(value)));
				break;
			
			case "randomnum":
				try
				{
				getXpathElement(xpath).clear();	
				getXpathElement(xpath).sendKeys(SpecialFunctions.generateRandomNumber(Integer.parseInt(value)));
				endTimes = sdf.format(new Date().getTime());
				setXLValues(SheetName1, 9, statusRow, "Pass");
				setReports(SheetName1, 12, reportStatus, "random numbers passed");
				setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
				}
				catch(Exception e){
					endTimes = sdf.format(new Date().getTime());
					setXLValues(SheetName1, 9, statusRow, "Fail");
					setReports(SheetName1, 12, reportStatus, "random numbers not passed");
					setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
				}
				break;	
			    
			case "randomemail":
				
				getXpathElement(xpath).clear();	
				getXpathElement(xpath).sendKeys(SpecialFunctions.generateEmail(Integer.parseInt(value)));
				break;
				
			case "randomcomb":
				
				getXpathElement(xpath).clear();	
				getXpathElement(xpath).sendKeys(SpecialFunctions.generateCombination(Integer.parseInt(value)));
				break;	
				
			case "randomspec":
				
				getXpathElement(xpath).clear();	
				getXpathElement(xpath).sendKeys(SpecialFunctions.generateSpecialChar(Integer.parseInt(value)));
				break;	
				
		case "scrollelement":
			SpecialFunctions.srollelementview(xpath);
			break;	
			
		case "scrolldown":                     
			for (int second = 0;; second++) {                   
				if(second >=Integer.valueOf(value)){                       
					break;                   }
				((RemoteWebDriver) Execution.driver).executeScript("window.scrollBy(0,200)", "");
				Thread.sleep(300);         }         
			break;
			
		case "scrollup":                         
			for (int second = 0;; second++) {                       
				if(second >=Integer.valueOf(value)){                           
					break;                       }                   
				((RemoteWebDriver) Execution.driver).executeScript("window.scrollBy(200,0)", "");                           
				Thread.sleep(300);             
				}             
			break;
		
		case "switchtab":
	               try{
	                      ArrayList<String> tabs2 = new ArrayList<String> (Execution.driver.getWindowHandles());
	                      driver.switchTo().window(tabs2.get(1));
	                     
	               endTimes = sdf.format(new Date().getTime());
	               setXLValues(SheetName1, 9, statusRow, "Pass");
	               setReports(SheetName1, 12, reportStatus, "Successfully Switched");
	               setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
	           }catch (Exception e){
	              endTimes = sdf.format(new Date().getTime());
	              setXLValues(SheetName1, 9, statusRow, "Fail");
	              setReports(SheetName1, 12, reportStatus, "Failed to Switch");
	              setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
	          }
	           break;
	   
		case "scrollbottom":	
			//SpecialFunctions.end(xpath);
			JavascriptExecutor jsx = (JavascriptExecutor) Execution.driver;
            jsx.executeScript("window.scrollBy(0,2000)", "");
            String elementId = "element-id";
            String html =(String) jsx.executeScript("return document.getElementById('" + elementId + "').innerHTML;");
            break;
            
		case "sleep":
		Thread.sleep(Integer.parseInt(value));
			break;	
	   
		case "selectoptiontext" :
            
            Select select = new Select(driver.findElement(By.xpath(xpath)));
             String selectedValue = select.getFirstSelectedOption().getText();
              System.out.println(selectedValue);
                setXLValues(SheetName1, 9, statusRow, "Pass");
                setXLValues(SheetName1, 7, statusRow, selectedValue);
                /*setReports(SheetName1, 12, reportStatus, "Got text");
                setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));*/

                break;  
         
		case "scrollclick":
                    try{
                        
                        //getXpathElement(xpath).click();

                             WebElement now = driver.findElement(By.xpath(xpath));
                             JavascriptExecutor scroll1 = (JavascriptExecutor)driver;
                             scroll1.executeScript("arguments[0].click();", now);
                        
                        endTimes = sdf.format(new Date().getTime());
                        
                        setXLValues(SheetName1, 9, statusRow, "Pass");    
                        setReports(SheetName1, 12, reportStatus, "Element clicked");
                        setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
                        
                        } catch (Exception e){
                            
                            endTimes = sdf.format(new Date().getTime());
                            setXLValues(SheetName1, 9, statusRow, "Fail");
                            setReports(SheetName1, 12, reportStatus, "Element not clicked");
                            setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
                        }
                        
                break;
		
	   case "slider":
            try{
            WebElement slider = Execution.driver.findElement(By.xpath(xpath));
            Actions sliderAction = new Actions(driver);
            sliderAction.clickAndHold(slider);
             sliderAction.moveByOffset(Integer.valueOf(value), 0).build().perform();

        endTimes = sdf.format(new Date().getTime());
        setXLValues(SheetName1, 9, statusRow, "Pass");
        setReports(SheetName1, 12, reportStatus, "Slider moved");
        setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));

            } catch (Exception e){
                
                endTimes = sdf.format(new Date().getTime());
                setXLValues(SheetName1, 9, statusRow, "Fail");
                setReports(SheetName1, 12, reportStatus, "Slider Not Moved");
                setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
            }
        break;
        
		case "sort":
	           try {
	           // give attribute in value like (class / name / value / id etc,..)
	           String sort=Execution.driver.findElement(By.xpath(xpath)).getAttribute("class");
	           System.out.println(sort);
	   
	           endTimes = sdf.format(new Date().getTime());  
	           setXLValues(SheetName1, 7, statusRow,sort);
	           setXLValues(SheetName1, 9, statusRow, "Pass");
	           setXLValues(SheetName1, 12, reportStatus, "sort working");
	           setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
	           
	           }
	           catch(Exception e)
	           {
	                endTimes = sdf.format(new Date().getTime());
	                setXLValues(SheetName1, 9, statusRow, "Fail");
	                setXLValues(SheetName1, 12, reportStatus, "sort not working");
	                setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
	               
	                getScreenshot(xpath);
	                
	           }
	           break;
		
		case "tooltip" :
	           try
	           {
	           WebElement elexpath = driver.findElement(By.xpath(xpath));
	           String actualTooltip = elexpath.getAttribute("title");
	           System.out.println(" Tool Tip message:" + actualTooltip);
	           
	           endTimes = sdf.format(new Date().getTime());  
	           setXLValues(SheetName1, 7, statusRow,actualTooltip);
	           setXLValues(SheetName1, 9, statusRow, "Pass");
	           setXLValues(SheetName1, 12, reportStatus, "tooltip captured");
	           setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
	           }
	           catch(Exception e)
	           {
	                endTimes = sdf.format(new Date().getTime());
	                   setXLValues(SheetName1, 9, statusRow, "Fail");
	                   setReports(SheetName1, 12, reportStatus, "tooltip not captured");
	                   setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
	           }
	           
	           break;
	           
		case "uncheckcb":
			
			WebElement cb = Execution.driver.findElement(By.xpath(xpath));
			endTimes = sdf.format(new Date().getTime());
			
			if(cb.isSelected())
			{
				cb.click();
				setXLValues(SheetName1, 9, statusRow, "Pass");
				setReports(SheetName1, 12, reportStatus, "Checkbox is unchecked");
				setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
			}
			else 
			{
			
			endTimes = sdf.format(new Date().getTime());
			
			setXLValues(SheetName1, 9, statusRow, "Fail");
			setReports(SheetName1, 12, reportStatus, "Checkbox Already unchecked");		
			setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
			
			}
			break;
		
		/*case "uploadtxt":    
            
            WebElement uploadElement=Execution.driver.findElement(By.xpath(xpath));
            uploadElement.sendKeys(value);
         
         try{
             
             endTimes = sdf.format(new Date().getTime());    
             
             setXLValues(SheetName1, 9, statusRow, "Pass");
             setXLValues(SheetName1, 13, reportStatus, "Upload Successfully");
             setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
         
             } catch(Exception e){

                 endTimes = sdf.format(new Date().getTime());

                 setXLValues(SheetName1,F 9, statusRow, "Fail");
                 setXLValues(SheetName1, 13, reportStatus, "Not Upload");
                 setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));    
                 
             }
             break; */
		case "uploadtxt":    
	           try
	           {
	           WebElement uploadElement=Execution.driver.findElement(By.xpath(xpath));
	           uploadElement.sendKeys(value);
	           Reports.success("Pass","Upload successfully",statusRow ,reportStatus);
	           }
	           catch(Exception e)
	           {
	           Reports.failure("Fail","Not Uploaded",statusRow ,reportStatus,xpath);
	           }
	        break; 
	        
		case "verifyddl":
			
			Select archiveList = new Select(Execution.driver.findElement(By.xpath(xpath)));
            //String actual = getXpathElement(xpath).getText();
            String ddl = archiveList.getFirstSelectedOption().getText();
			
			endTimes = sdf.format(new Date().getTime());
			
			if(ddl.equals(expected)){
			setXLValues(SheetName1, 9, statusRow, "Pass");
			setXLValues(SheetName1, 7, statusRow, ddl);
			setReports(SheetName1, 12, reportStatus, "Content matched");
			setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
			
			}else 
			{
			
			endTimes = sdf.format(new Date().getTime());

			setXLValues(SheetName1, 9, statusRow, "Fail");
			setXLValues(SheetName1, 7, statusRow, ddl);
			setReports(SheetName1, 12, reportStatus, "Contents mismatched");		
			setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
			
			}
			break;  
		
		case "verifyfontsize":
            
            //String fs=Execution.driver.findElement(By.xpath(xpath)).getCssValue("font-size");
			String fs=Execution.driver.findElement(By.xpath(xpath)).getAttribute(xpath);
            System.out.println(fs);
            
            if(fs.equals(value))
            {
  
            endTimes = sdf.format(new Date().getTime());  
          
            setXLValues(SheetName1, 7, statusRow,fs);
            setXLValues(SheetName1, 9, statusRow, "Pass");
            setXLValues(SheetName1, 12, reportStatus, "fontsize matched");
            setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
            
            }
            else
            {
                 endTimes = sdf.format(new Date().getTime());

                 setXLValues(SheetName1, 9, statusRow, "Fail");
                 setXLValues(SheetName1, 12, reportStatus, "font size not matched");
                 setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
                
                 getScreenshot(xpath);
                
            }
            break;
            
		case "window1":	
			
			try{
			
				Set<String> WINDOWIDS= driver.getWindowHandles();
			    Iterator<String> iter=WINDOWIDS.iterator();    
			    String Window1=iter.next();//Returns first window id
			    String Window2=iter.next();//Returns second window id
			    
			    System.out.println(Window1);
			    System.out.println(Window2);
			    
			    driver.switchTo().window(Window2);

	            Thread.sleep(3000);
	            driver.findElement(By.xpath(xpath)).click();
	            driver.findElement(By.xpath(".//*[@id='frmPosNegDB']/table/tbody/tr/td/div[2]/input")).click();
	            Thread.sleep(2000);
	            
	            driver.switchTo().window(Window1);
	  
	        setXLValues(SheetName1, 9, statusRow, "Pass");	
			setReports(SheetName1, 12, reportStatus, "Window Handle works");
			setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
			
			} catch (Exception e){
				
				endTimes = sdf.format(new Date().getTime());
				setXLValues(SheetName1, 9, statusRow, "Fail");
				setReports(SheetName1, 12, reportStatus, "Window Handle not works");
				setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
			}
			break;	
		       
	   case "waituntilvisible":
            try{
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            //Thread.sleep(9000);
            
            
            endTimes = sdf.format(new Date().getTime());

            setXLValues(SheetName1, 9, statusRow, "Pass");
            setReports(SheetName1, 12, reportStatus, "Wait works");
            setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));


            }catch(Exception e){
            
            endTimes = sdf.format(new Date().getTime());
    
            setXLValues(SheetName1, 9, statusRow, "Pass");
            setReports(SheetName1, 12, reportStatus, "Wait works");
            setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));

            }
            
            break;	
            
		case "waittillpageloads":
		
			try{
				wait.until(new Function<WebDriver, Boolean>() {
					public Boolean apply(WebDriver driver) {
					return String
					.valueOf(((JavascriptExecutor) Execution.driver).executeScript("return document.readyState"))
					.equals("complete");
					}
					});
				endTimes = sdf.format(new Date().getTime());
				
				setXLValues(SheetName1, 9, statusRow, "Pass");	
				setReports(SheetName1, 12, reportStatus, "Waited");
				setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
				
				} catch (Exception e){
					
					endTimes = sdf.format(new Date().getTime());
					setXLValues(SheetName1, 9, statusRow, "Pass");
					setReports(SheetName1, 12, reportStatus, "Waited");
					setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));

				}
				
				break;

		case "waitsec":
			try{
				
				Execution.driver.manage().timeouts().implicitlyWait(Integer.parseInt(value), TimeUnit.SECONDS);
				endTimes = sdf.format(new Date().getTime());
				setXLValues(SheetName1, 9, statusRow, "Pass");	
				setReports(SheetName1, 12, reportStatus, "Waited");
				setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
				
				} catch (Exception e){
					
					endTimes = sdf.format(new Date().getTime());
					setXLValues(SheetName1, 9, statusRow, "Fail");
					setReports(SheetName1, 12, reportStatus, "NotWaited");
					setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
				}
				
			break;
			
		case "zoomout":
            try{
                
                JavascriptExecutor executor = (JavascriptExecutor)driver;
                executor.executeScript("document.body.style.zoom = '"+value+"';");
                endTimes = sdf.format(new Date().getTime());
                setXLValues(SheetName1, 9, statusRow, "Fail");
                setReports(SheetName1, 12, reportStatus, "Zoomed");
                setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));

                } catch (Exception e){
                    
                    endTimes = sdf.format(new Date().getTime());
                    setXLValues(SheetName1, 9, statusRow, "Fail");
                    setReports(SheetName1, 12, reportStatus, "NotWork");
                    setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
                }
                
            break;
            
		case "getcurrenturl":		
			
        	String url = Execution.driver.getCurrentUrl();
        	try{
        		
        		setXLValues(SheetName1, 7, statusRow, url);
        		setXLValues(SheetName1, 9, statusRow, "Pass");
        		setReports(SheetName1, 12, reportStatus, "URL Found");
        	}catch(Exception e){
        		
        		setXLValues(SheetName1, 9, statusRow, "Fail");
        		setReports(SheetName1, 12, reportStatus, "URL NO FOUND");
        		
        	}
        	
        	break;
        	
		case "verifylogin":
			
			String toast=Execution.driver.findElement(By.xpath(xpath)).getText();
				try
				{
					if(toast.equals(value))
					{
						Execution.driver.close();
					}
				setXLValues(SheetName1, 7, statusRow, toast);
        		setXLValues(SheetName1, 9, statusRow, "Pass");
        		setReports(SheetName1, 12, reportStatus, "login UnSuccessfull");
			}
			catch(Exception e)
			{
				setXLValues(SheetName1, 9, statusRow, "Fail");
        		setReports(SheetName1, 12, reportStatus, "login Successfull");
			}
			break;
        }
		}
		catch(Exception e){
			//setXLValues(SheetName1, 9, statusRow, "Element not Found");	
			String url = Execution.driver.getCurrentUrl();
			setXLValues(SheetName1, 7, statusRow, url);
    		setXLValues(SheetName1, 9, statusRow, "Fail");
    		setReports(SheetName1, 12, reportStatus, "Exception URL-Check Xpath ");	
			}
		
	}
	
}