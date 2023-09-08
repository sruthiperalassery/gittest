/**
 * 
 */
package com.UBQPageObjectLib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.UBQGenericLib.WebDriverCommonLib;

/**
 * @author Basanagouda
 *
 */
public class PurchaseInvoiceBrowser extends WebDriverCommonLib {

	public WebDriver driver;

	// ----------------------Constructor----------------------//
	public PurchaseInvoiceBrowser(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

	// ---For Enter Order Number---//
	@FindBy(how = How.XPATH, using = "//input[@id='billNo']")
	private WebElement InvoiceNo;
	
	// ---For FromDate---//
	@FindBy(how = How.XPATH, using = "//input[@id='fromDate']")
	private WebElement FromDate;

	// ---For ToDate ---//
	@FindBy(how = How.XPATH, using = "//input[@id='toDate']")
	private WebElement ToDate;
	
	// ---For StatusInTransit ---//
		@FindBy(how = How.XPATH, using = "//form[@id='PIBrowserForm']/table/tbody/tr/td/table/tbody/tr[5]/td[2]/label[1]/input")
		private WebElement StatusInTransit;
		
		// ---For StatusConfirmed ---//
				@FindBy(how = How.XPATH, using = "//form[@id='PIBrowserForm']/table/tbody/tr/td/table/tbody/tr[5]/td[2]/label[2]/input")
				private WebElement StatusConfirmed;
	
				
				
				
	// ---For View Btn ---//
	@FindBy(how = How.XPATH, using = "//input[@id='viewButton']")
	private WebElement ViewBtn;

	// ---For Clear Btn ---//
	@FindBy(how = How.XPATH, using = "//input[@id='clearButton']")
	private WebElement ClearBtn;

	// ---For Numberofrows---//
	@FindBy(how = How.XPATH, using = "//td[@id='noOfRows']")
	private WebElement Numberofrows;
	
	// ---For Openview---//
		@FindBy(how = How.XPATH, using = "//table[@id='contextTable']/tbody/tr[1]/td[3]/span")
		private WebElement Openview;

		// ---For OpenInNewWindowview---//
		@FindBy(how = How.XPATH, using = "//table[@id='contextTable']/tbody/tr[2]/td[3]/span")
		private WebElement OpenInNewWindowview;

	// ----------------------Functions----------------------//

	public void EnterPurchaseInvoiceNo(String invoiceNo) {
		entervalue(invoiceNo, InvoiceNo);
	}

	public void EnterFromDate(String fdate) {
		entervalue(fdate, FromDate);
	}
	
	public void SelectIntransitoption() {
		buttonClick(StatusInTransit);

	}
	
	public void SelectConfirmedoption() {
		buttonClick(StatusConfirmed);

	}

	public void EnterToDate(String tdate) {
		entervalue(tdate, ToDate);
	}

	
	public void ClickClearBtn() {
		buttonClick(ClearBtn);

	}

	public void ClickViewBtn() {
		buttonClick(ViewBtn);

	}

	public int getnoofrows() {
		String data = getText(Numberofrows);
		String[] val = data.split(":");
		return Integer.parseInt(val[1]);

	}
	
	// For getNumOfProductRows
	public int getNumOfInvoiceRows() {
		List<WebElement> size = driver.findElements(By.xpath("//table[@id='updatedProductsTable']/"));
		return size.size();
	}

	// For getInputValuesForMultipleRows
	public String getproductcodeForMultipleRows(int row, int col) {
		WebElement element = driver.findElement(
				By.xpath("//table[@id='resultTab']/tbody/tr["+row +"]/td[" + col + "]/input[13]"));
		return getvalue(element);
	}
					
		
}
