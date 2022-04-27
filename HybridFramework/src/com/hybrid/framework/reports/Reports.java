package com.hybrid.framework.reports;

import static com.hybrid.framework.execution.Execution.driver;
import static com.hybrid.framework.execution.Execution.SheetName1;
import static com.hybrid.framework.execution.Execution.wwbCopy;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import jxl.write.Label;
import jxl.write.WritableHyperlink;
import jxl.write.WritableSheet;
import jxl.write.WriteException;

import com.hybrid.framework.execution.Execution;

@SuppressWarnings("unused")
public class Reports {
	
	public static String screenPath = "Screenshots/";
	public static UUID dynamic;
	public static String filePath;
	
	public static void setXLValues(String sheetName, int columnNo, int rowNo, String xlData) throws WriteException{
		
		
		WritableSheet ws = wwbCopy.getSheet(sheetName);
		Label le = new Label(columnNo, rowNo, xlData);
		try{
			
			ws.addCell(le);
			if(xlData.equalsIgnoreCase("Fail")){
				getScreenshot(Execution.gxpath);
				WritableHyperlink wa = new WritableHyperlink(ws.findCell("Screenshot").getColumn(), rowNo, new File(Reports.filePath));
				ws.addHyperlink(wa);
			}
			}catch (Exception e){
			}
		}                 
			
	public static void setReports(String sheetName, int columnNo, int rowNo, String xlReport){
			
			WritableSheet ws = wwbCopy.getSheet(sheetName);
			Label le = new Label(columnNo, rowNo, xlReport);
			try{
				
				ws.addCell(le);
						
			}catch (Exception e){
				
				System.out.println("XL Report status column ");
				e.printStackTrace();
				
				
			}	
				
		}	
	public static void success(String pass , String msg, int statusRow , int reportStatus) throws WriteException 
    {
        String startTimes = sdf.format(new Date().getTime());
        String endTimes = sdf.format(new Date().getTime());
       setXLValues(SheetName1, 9, statusRow, pass);
       setReports(SheetName1, 12, reportStatus, msg);
       setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));        
    } 

    public static void failure(String fail , String msg, int statusRow , int reportStatus , String xpath) throws WriteException, IOException 
    {
        String startTimes = sdf.format(new Date().getTime());
        String endTimes = sdf.format(new Date().getTime());
       setXLValues(SheetName1, 9, statusRow, fail);
       setReports(SheetName1, 12, reportStatus, msg);
       setXLValues(SheetName1, 11, reportStatus, getCurrentTime(startTimes, endTimes));
       getScreenshot(xpath);        
    } 
		//Screensot.java inside Reports
		public static String getScreenshot(String xpath) throws IOException{
			
			
			WebElement autoCapt = Execution.driver.findElement(By.xpath(xpath));   
			//Get entire page screenshot
			File screenshot = ((TakesScreenshot)Execution.driver).getScreenshotAs(OutputType.FILE);
			BufferedImage bi = ImageIO.read(screenshot);
			//Get the location of element on the page
			Point p = autoCapt.getLocation();
			bi.getTransparency();
			Graphics g = bi.getGraphics();
			g.setColor(Color.RED.brighter());
			
			//Get width and height of the element
			g.drawRect(p.getX(), p.getY(), autoCapt.getSize().width, autoCapt.getSize().height);
			g.setFont(new Font("verdana", Font.BOLD, 16));
			g.setColor(Color.RED.brighter());
			g.dispose();
			ImageIO.write(bi, "png", screenshot);
			//Copy the element screenshot to disk
			File newFile = new File(screenPath + Execution.testCaseID + ".png");
			FileUtils.copyFile(screenshot, newFile );
			filePath=newFile.getAbsolutePath();
			return filePath;
			
		}	
			
		//TimeTaken.java inside Reports
		public static SimpleDateFormat sdf = new SimpleDateFormat("ss");

		public static String getCurrentTime(String startTime, String endTime){
			
			int timetaken = Integer.valueOf(endTime)-Integer.valueOf(startTime);
			if(timetaken>60){
			timetaken = timetaken/60;
			return timetaken+" Min(s)";
			}else{
				return timetaken + " sec(s)";
		}	
			
	}		
}			
			