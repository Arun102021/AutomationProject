package com.hybrid.framework.execution;

import static com.hybrid.framework.platforms.Browsers.*;
import static com.hybrid.framework.reports.Reports.setXLValues;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.WebDriver;  

import com.hybrid.framework.platforms.*;

import jxl.read.biff.BiffException;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;


	                                                                                                                     
public class Execution {
	
public static String Filepath = "Testinput/V5Beta-1.xls";  ///home/arun/eclipse-workspace/HybridFramework/Testinput/V5Beta.xls
public static String SheetName = "Configuration";
public static String SheetName1 = "APIForm";
public static Workbook wbook;
public static WritableWorkbook wwbCopy;
public static Sheet shSheet;
public static String testCaseID;
public static WebDriver driver;	
public static String gxpath;
	   	
// Read the XL report
public static String getContent(String Filepath, String SheetName, String Columnname, int Rowno) throws BiffException, IOException{
	@SuppressWarnings("unused")
	String currentUsersHomeDir = System.getProperty("user.home");
	//System.out.println(currentUsersHomeDir);
	//System.out.println(new File(Filepath).getAbsolutePath());
	//F.getAbsolutePath();
	//System.out.println(F.getAbsolutePath());
		Workbook wb = Workbook.getWorkbook(new File(Filepath));
		String getContentFromXl = wb.getSheet(SheetName).getCell(wb.getSheet(SheetName).findCell(Columnname).getColumn(), Rowno).getContents();
		return getContentFromXl;
		
}	    
// To read the column values in XL using while loop
		 
public static void run() throws BiffException, IOException, WriteException, InterruptedException{
	int a=1;
		
	while(true){
	String Testcaseid = getContent(Filepath, SheetName1, "Testcase id", a);
	String Description = getContent(Filepath, SheetName1, "Testcase description", a);
	//s.getCell(s.findCell("S. No").getColumn(), row).getContents();
	String actioncoloumn = getContent(Filepath, SheetName1, "Action", a);
	String values = getContent(Filepath, SheetName1, "Values", a);
	String xpath = 	getContent(Filepath, SheetName1, "X-path Locator", a);
	String end = getContent(Filepath, SheetName1, "Testcase id", a);
	testCaseID = end;
	gxpath=xpath;
	String expected = getContent(Filepath, SheetName1, "Expected Content", a);
	//String readyTest = getContent(Filepath, SheetName1, "Ready to test � (Yes/No)", a);
	String readyTest = getContent(Filepath, SheetName1, "Ready to test – (Yes/No)", a);
	if(end.equalsIgnoreCase("end")){
		break;
	}	
			
	if(readyTest.equalsIgnoreCase("yes")){
		Keywords.keyword(actioncoloumn, xpath, values, expected, a, a);
	}	
	
else{	
		
	//System.out.println("Not Tested, Set the \"end\" position part correctly in XLSheet");
	if(!readyTest.isEmpty() && readyTest.length()!=0){
	setXLValues(SheetName1, 9, a, "Not ready");
	}	
}	
	System.out.println("TC-ID => "+Testcaseid+" => "+Description);
a++;	
	}
}	
public static void exit() throws WriteException, IOException{
	wwbCopy.write();
	wwbCopy.close();
	wbook.close();
	driver.quit();
	System.out.println("******Testcases Completed******");
}	
// Main functions
	
public static void main(String[] args) throws BiffException, IOException, WriteException, InterruptedException, AddressException, MessagingException, MalformedURLException {
	 //sheet1 sheet2 sheet3
	String a[] = {"WhiteBlackList"};
	args  = a;
	for(String sheet:args) {
	Execution.SheetName1 = sheet;
	Browser();
	run();
    exit();
    System.out.println("******Wait for Email Notification******");
    EmailAttachment.mail();
	}
	}				
}