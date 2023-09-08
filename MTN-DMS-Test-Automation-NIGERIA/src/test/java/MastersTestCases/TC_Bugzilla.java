package MastersTestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.UBQGenericLib.ExcelLib;


public class TC_Bugzilla {
	

	HashMap<String, String> BugData = new HashMap<String, String>();
	static File f = null;
	static FileOutputStream fos = null;
	static FileInputStream fis = null;
	static Workbook wb = null;
	static Sheet sh = null;
	static Row row = null;
	static int rowcount;
	
	static
	{
		
		System.setProperty("webdriver.gecko.driver", "Resources/version_22/geckodriver.exe");
		
		
	}
	
	
	public static void createExcelsheet() {
		try {
			fis = new FileInputStream("D:/MTN[CDI]SanityTestReportForProductionEnvironment27062019_26-07-2019.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = WorkbookFactory.create(fis);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void createExcel(String fileLocation, String sheetName) throws IOException {
		f = new File(fileLocation);
		if (f.exists()) {
		} else {
			f.createNewFile();
		}
		fos = new FileOutputStream(f);
		wb.createSheet(sheetName);
		wb.write(fos);
		fos.close();

	}

	public static void deleteExcel(String fileLocation, String fileName) {
		f = new File(fileLocation + "\\" + fileName);
		if (f.exists()) {
			f.delete();
		} else {
		}
	}

	public static String Excelread(String sheetName, int cellnum){
		sh = wb.getSheet(sheetName);
		int rowcount = sh.getLastRowNum();
		Row row = sh.getRow(rowcount);
		Cell cell = row.getCell(cellnum);
		String cellval = cell.getStringCellValue().toString();
		return cellval;

	}
	
public static String[][] ExcelreadFulldata(String sheetName){
		sh = wb.getSheet(sheetName);
		int rowcount = sh.getPhysicalNumberOfRows();
		Row row = sh.createRow(rowcount);
		row = sh.getRow(rowcount-1);
		int cellnum = row.getPhysicalNumberOfCells();
		String getDetails[][] = new String[rowcount][cellnum];
		for (int i = 1; i < rowcount; i++) {
			row = sh.getRow(i);
			for (int j = 0; j < cellnum; j++) {
				Cell cell = row.getCell(j);
				getDetails[i-1][j] = cell.getStringCellValue();
			}
		}
		return getDetails;

		
	}

	public static String Excelread(String sheetName, int rownum, int cellnum){
		sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String cellval = cell.getStringCellValue();
		return cellval;

	}
	
	

	public static int ExcelreadNumber(String sheetName, int rownum, int cellnum) throws Exception {
		sh = wb.getSheet(sheetName);
		int rowcount = sh.getLastRowNum();
		Row row = sh.getRow(rowcount);
		Cell cell = row.getCell(cellnum);
		System.out.println(cell.getNumericCellValue());
		System.out.println(cell.getStringCellValue());
		return (int) cell.getNumericCellValue();
	}

	public Boolean ExcelreadBoolean(String sheetName, int rownum, int cellnum) throws Exception {
		sh = wb.getSheet(sheetName);
		int rowcount = sh.getLastRowNum();
		Row row = sh.getRow(rowcount);
		Cell cell = row.getCell(cellnum);
		return cell.getBooleanCellValue();
	}

	public Date ExcelreadDate(String sheetName, int rownum, int cellnum) throws Exception {
		sh = wb.getSheet(sheetName);
		int rowcount = sh.getLastRowNum();
		Row row = sh.getRow(rowcount);
		Cell cell = row.getCell(cellnum);
		return cell.getDateCellValue();
	}

	public void Excelwrite(String filelocation, String sheetName, String data) {
		try {
			sh = wb.getSheet(sheetName);
			int colnum = sh.getRow(rowcount).getLastCellNum() + 1;
			Cell cell = row.createCell(colnum);
			cell.setCellValue(data);
			fos = new FileOutputStream(filelocation);
			wb.write(fos);
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getCause().getCause();
		}

	}

	public void Excelwrite(String filelocation, String sheetName, String[] data) {
		try {
			sh = wb.getSheet(sheetName);
			rowcount = sh.getPhysicalNumberOfRows();
			@SuppressWarnings("unused")
			Row newrow = sh.createRow(rowcount);
			row = sh.getRow(rowcount);
			int colnum = sh.getRow(rowcount).getLastCellNum() + 1;
			for (int i = colnum; i < data.length; i++) {
				Cell cell = row.createCell(i);
				cell.setCellValue(data[i]);
			}
			fos = new FileOutputStream(filelocation);
			wb.write(fos);
			fos.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void Excelwrite(String filelocation, String sheetName, String[][] data) {
		try {
			sh = wb.getSheet(sheetName);
			for (int i = 0; i < data.length; i++) {
				rowcount = sh.getPhysicalNumberOfRows();
				@SuppressWarnings("unused")
				Row newrow = sh.createRow(rowcount);
				row = sh.getRow(rowcount);
				int colnum = sh.getRow(rowcount).getLastCellNum()+1;
				for (int j = colnum; j < data[i].length; j++) {
					Cell cell = row.createCell(j);
					cell.setCellValue(data[i][j]);
				}
			}
			fos = new FileOutputStream(filelocation);
			wb.write(fos);
			fos.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	
	public void ExcelDeleteData(String filelocation, String sheetName){
		try {
			int count = wb.getNumberOfSheets()-1;
			wb.removeSheetAt(count);
			fos = new FileOutputStream(filelocation);
			wb.write(fos);
			fos.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int getlastrownum(String sheetName) {
		sh = wb.getSheet(sheetName);
		return sh.getLastRowNum();
	}

	public static int getlastcolnum(String sheetName, int rownum) {
		sh = wb.getSheet(sheetName);
		row = sh.getRow(rownum);
		return row.getLastCellNum();
	}
 
  public static void main(String[] args) {
	  WebDriver driver=new FirefoxDriver();
	  
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://122.15.35.61:56/");
		driver.findElement(By.xpath("//a[@id='login_link_top']")).click();
		driver.findElement(By.xpath("//input[@id='Bugzilla_login_top']")).sendKeys("praneeth.kumar@ubq.in");
		driver.findElement(By.xpath("//input[@id='Bugzilla_password_top']")).sendKeys("praneeth.kumar@ubq.in");
		driver.findElement(By.xpath("//input[@id='log_in_top']")).click();
		
		createExcelsheet();
		int noOfRows = getlastrownum("Test Report Details");
		System.out.println(noOfRows);
		for (int i = 1; i <= noOfRows; i++) {
			if (Excelread("Test Report Details",i,10).equalsIgnoreCase("Failed")) {
				int bugnumber = 0;
				try {
					bugnumber = ExcelreadNumber("Test Report Details",i,11);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.findElement(By.xpath("//input[@id='quicksearch_top']")).sendKeys(String.valueOf(bugnumber));
				
				driver.findElement(By.xpath("//input[@id='find_top']")).click();
				
				
				/* WebElement op1 = driver.findElement(By.xpath("//select[@id='priority']"));
				 Select sele=new Select(op1);
				 sele.selectByVisibleText("High");
				 
				 WebElement op2 = driver.findElement(By.xpath("//select[@id='bug_severity']"));
				 Select sele1=new Select(op1);
				 sele1.selectByVisibleText("major");*/
				
				List<WebElement> count = driver.findElements(By.xpath("//table[@class='bz_comment_table']/tbody/tr/td[1]/div"));

				int  rows = count.size() -1 ;
				
				try 
				{
					WebElement span = driver.findElement(
							By.xpath("//table[@class='bz_comment_table']/tbody/tr/td[1]/div["+rows+"]/pre/span"));
					System.out.println(span.getText());
				}
				catch (RuntimeException ee)
				{
				    if (ee.toString().contains("NoSuchElementException"))
				    {
				    	WebElement element = driver.findElement(
								By.xpath("//table[@class='bz_comment_table']/tbody/tr/td[1]/div["+rows+"]/pre"));
						
				  		
						System.out.println(element.getText());
				    }
				}
				
			}else{
				
			}
		}
		
		driver.close();
		
  }
  
  
	}
