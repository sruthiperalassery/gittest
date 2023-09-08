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
public class PurchaseOrderBrowser extends WebDriverCommonLib {

	public WebDriver driver;

	// ----------------------Constructor----------------------//
	public PurchaseOrderBrowser(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

	// ---For Enter Order Number---//
	@FindBy(how = How.XPATH, using = "//input[@id='OrderNo']")
	private WebElement OrderNo;

	// ---For Select SBU---//
	@FindBy(how = How.XPATH, using = "//select[@id='SBU']")
	private WebElement SBU;

	// ---For FromDate---//
	@FindBy(how = How.XPATH, using = "//input[@id='fromDate']")
	private WebElement FromDate;

	// ---For ToDate ---//
	@FindBy(how = How.XPATH, using = "//input[@id='toDate']")
	private WebElement ToDate;

	// ---For DraftStatus ---//
	@FindBy(how = How.XPATH, using = "//form[@id='POBrowserForm']/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr/td[2]/label[1]/input")
	private WebElement draftStatus;

	// ---For confirmStatus ---//
	@FindBy(how = How.XPATH, using = "//form[@id='POBrowserForm']/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr/td[2]/label[2]/input")
	private WebElement confirmStatus;

	// ---For ReverseStatus ---//
	@FindBy(how = How.XPATH, using = "//form[@id='POBrowserForm']/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr/td[2]/label[3]/input")
	private WebElement ReverseStatus;

	// ---For SentStatus---//
	@FindBy(how = How.XPATH, using = "//form[@id='POBrowserForm']/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr/td[2]/label[4]/input")
	private WebElement SentStatus;

	// ---For AllStatus ---//
	@FindBy(how = How.XPATH, using = "//form[@id='POBrowserForm']/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr/td[2]/label[5]/input")
	private WebElement AllStatus;

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

	public void selectSBU(String sbu) {
		selectvalue(sbu, SBU);
	}
	
	

	public void EnterOrderNo(String orderno) {
		entervalue(orderno, OrderNo);
	}

	public void EnterFromDate(String fdate) {
		entervalue(fdate, FromDate);
	}

	public void EnterToDate(String tdate) {
		entervalue(tdate, ToDate);
	}

	public void SelectStatus(String status) {
		if (status.contains("Draft")) {
			draftStatus.click();
		} else if (status.contains("Confirmed")) {
			confirmStatus.click();
		} else if (status.contains("Reversed")) {
			ReverseStatus.click();
		} else if (status.contains("Sent")) {
			SentStatus.click();
		} else {
			AllStatus.click();
		}
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
	public int getNumOfporderRows() {
		List<WebElement> size = driver.findElements(By.xpath("//div[@id='OrderlistDiv']/div[2]/table/tbody/tr"));
		return size.size();
	}

	// For getInputValuesForMultipleRows
	public String getproductcodeForMultipleRows(int row, int col) {
		WebElement element = driver.findElement(
				By.xpath("//table[@id='resultTab']/tbody/tr["+row +"]/td[" + col + "]/input[13]"));
		return getvalue(element);
	}
					
					// For getInputValuesForMultipleRows
					public String getproductcodeofRow(int row, int col) {
						WebElement element = driver.findElement(
								By.xpath("//div[@id='OrderlistDiv']/div[2]/table/tbody/tr[" + row + "]/td[" + col + "]/span[2]/a"));
						return getText(element);
					}

			
			
			public String getStringdatafrommultipleProductrows(int rnum, int cnum) {
				WebElement element = driver
						.findElement(By.xpath("//div[@id='OrderlistDiv']/div[2]/table/tbody/tr[" + rnum + "]/td[" + cnum + "]/span"));
				highLightElement(driver, element);
				String value = element.getText().trim();                                                      
				// System.out.println(value);
				return value;

			}
	// For getInputValuesForMultipleRows
		public void ClickonOrderNo(int row, int col) {
			WebElement element = driver.findElement(
					By.xpath("//div[@id='OrderlistDiv']/div[2]/table/tbody/tr[" + row + "]/td[" + col + "]/span[2]/a"));
			highLightElement(driver, element);
			element.click();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			buttonClick(OpenInNewWindowview);
		}

}
