package org.bas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.server.handler.WebDriverHandler;

public class BaseClass {

	public static WebDriver driver;
	
	public static void launchbrowser() {

		WebDriverManager.chromedriver().setup();
		
		driver= new ChromeDriver();
		
	}
	public static void windowMaximize() {

		driver.manage().window().maximize();
	}
	
	public static void launchUrl(String url) {
   driver.get(url);
	}
	
	public static void pageTitle() {

		 String title= driver.getTitle();
		 System.out.println(title);
	}
	
	public static void pageUrl() {
    
		String url= driver.getCurrentUrl();
		
		System.out.println(url);
	}
	
	public static  void passText(String txt,WebElement ele) {
    
		ele.sendKeys(txt);
	}
	
	public static void closeEntireBrowser() {
    
		driver.quit();
	}
	
	public static void clickbtn(WebElement ele) {
		ele.click();
}	
	
	public static void Screenshot(String imgname) throws IOException {
    
		TakesScreenshot ts =  (TakesScreenshot) driver;
		File image = ts.getScreenshotAs(OutputType.FILE);
		File F = new File("location + imgName.png");
		FileUtils.copyFile(image, F);
		
	}
	
	public static Actions a;
     
	public static void movethecursor(WebElement targetwebElement) {
   a = new Actions(driver);
   
   a.moveToElement(targetwebElement).perform();
	}
	
	public static void dragdrop(WebElement dragwebElement,WebElement dropwebElement) {

		   a = new Actions(driver);
		   a.dragAndDrop(dragwebElement, dropwebElement).perform();
		   
		   
	}
	
	public static JavascriptExecutor js;
	
	public static void scrollThepage(WebElement tarwebEle) {

		
		js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", tarwebEle);
	}
	
	public static void scroll(WebElement element) {
		 
		js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);

	}
	public static void excelRead(String sheetName,int rowNum, int cellNum) throws IOException {

		File F = new File("C:\\Users\\ss\\eclipse-workspace\\MavenInstalltion\\Excel\\Value.xlsx");
		FileInputStream fis= new FileInputStream(F);
		Workbook wb= new XSSFWorkbook(fis);
		Sheet mysheet= wb.getSheet("Datas");
		
		Row r = mysheet.getRow(rowNum);
		Cell c= r.getCell(cellNum);
		
		int cellType= c.getCellType();
		
		
		String Value = " ";
		
		if(cellType==1) {
			
			
			String value2= c.getStringCellValue();	
		}
		
		else if (DateUtil.isCellDateFormatted(c)){
			Date dd= c.getDateCellValue();
			
			SimpleDateFormat s = new SimpleDateFormat(Value);
			String value1= s.format(dd);
			
		}
		
		else {
			 double d = c.getNumericCellValue();
			 long l= (long)d;
		
			 String valueOf = String.valueOf(1);
			 
			 
		}
	}
    
	public static void createNewExcelFile(int rownum, int cellNum, String writeData) throws IOException {

    	File f = new File("C:\\Users\\ss\\eclipse-workspace\\MavenInstalltion\\Excel\\Value.xlsx");
		Workbook w= new XSSFWorkbook();
		Sheet newSheet= w.createSheet("Datas");
    	Row newRow= newSheet.createRow(rownum);
    	Cell newCell = newRow.createCell(cellNum);
    	newCell.setCellValue(writeData);
    	FileOutputStream fos= new FileOutputStream(f);
    	
	}
  
    
    public static void createCell(int rowNum, int cellNum, String newData) throws IOException {

    	
    	File f = new File("C:\\Users\\ss\\eclipse-workspace\\MavenInstalltion\\Excel\\Value.xlsx");
    	FileInputStream fis= new FileInputStream(f);
		Workbook w= new XSSFWorkbook();
		Sheet s= w.getSheet("Datas");
    	Row r= s.getRow(rowNum);
    	Cell c= r.createCell(cellNum);
    	c.setCellValue(newData);
    	FileOutputStream fos= new FileOutputStream(f);
    	w.write(fos);

    	
	}
    public static void CreateRow(int creRow, int creCell, String newData) throws IOException {
		// TODO Auto-generated method stub
    	File f = new File("C:\\Users\\ss\\eclipse-workspace\\MavenInstalltion\\Excel\\Value.xlsx");
    	FileInputStream fis= new FileInputStream(f);
		Workbook wb= new XSSFWorkbook(fis);
		Sheet s = wb.createSheet("Datas");
    	Row r= s.createRow(creRow);
    	Cell c= r.createCell(creCell);
    	c.setCellValue(newData);
    	FileOutputStream fos= new FileOutputStream(f);

    	wb.write(fos);

	}
	
    public static void updateDataToParticularCell(int gettheRow, int gettheCell, String existingData, String writeNewData) throws IOException {
		// TODO Auto-generated method stub
    	File f = new File("C:\\Users\\ss\\eclipse-workspace\\MavenInstalltion\\Excel\\Value.xlsx");
    	FileInputStream fis= new FileInputStream(f);

		Workbook wb= new XSSFWorkbook(fis);
		Sheet s= wb.createSheet("Datas");
    	Row r= s.createRow(gettheRow);
    	Cell c= r.createCell(gettheCell);
    	String str=c.getStringCellValue();

    	if(str.equals(existingData)) {
	
    		c.setCellValue(writeNewData);
	
    	}	
    	FileOutputStream fos= new FileOutputStream(f);
    	wb.write(fos);


	}
}
