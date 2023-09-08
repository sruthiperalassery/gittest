package com.UBQPageObjectLib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.UBQGenericLib.WebDriverCommonLib;

public class OrderBrowser extends WebDriverCommonLib {

	WebDriver driver;

	// ----------------------Constructor----------------------//
	public OrderBrowser(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

	// ---For SBU---//
	@FindBy(how = How.XPATH, using = "//select[@id='SBU']")
	private WebElement SBU;

	// ---For Customertype---//
	@FindBy(how = How.XPATH, using = "//select[@id='entityId']")
	private WebElement Customertype;

	// ---For Salesman---//
	@FindBy(how = How.XPATH, using = "//select[@id='salesman']")
	private WebElement Salesman;

	// ---For Route---//
	@FindBy(how = How.XPATH, using = "//select[@id='beat']")
	private WebElement Route;

	// ---For CustomerName---//
	@FindBy(how = How.XPATH, using = "//select[@id='customer']")
	private WebElement Customername;

	// ---For BillNo---//
	@FindBy(how = How.XPATH, using = "//input[@id='billNo']")
	private WebElement Orderno;

	// ---For FromDate---//
	@FindBy(how = How.XPATH, using = "//input[@id='fromDate']")
	private WebElement FromDate;

	// ---For ToDate---//
	@FindBy(how = How.XPATH, using = "//input[@id='toDate']")
	private WebElement ToDate;

	// ---For StatusConfirmed---//
	@FindBy(how = How.XPATH, using = "//input[@id='statusConfirmed']")
	private WebElement StatusConfirmed;

	// ---For StatusUnconfirmed---//
	@FindBy(how = How.XPATH, using = "//input[@id='statusUnconfirmed']")
	private WebElement StatusUnconfirmed;

	// ---For StatusReversed---//
	@FindBy(how = How.XPATH, using = "//input[@id='statusReversed']")
	private WebElement StatusReversed;

	// ---For StatusInvoiceGenerated---//
	@FindBy(how = How.XPATH, using = "//input[@id='statusBill Generated']")
	private WebElement StatusInvoiceGenerated;

	// ---For StatusAll---//
	@FindBy(how = How.XPATH, using = "//input[@id='statusAll']")
	private WebElement StatusAll;

	// ---For SlelectAll---//
	@FindBy(how = How.XPATH, using = "//input[@id='selectAll']")
	private WebElement SelectAllCheckbox;

	// ---For ClickonOrder---//
	@FindBy(how = How.XPATH, using = "//div[@id='OrderListDiv']/table/tbody/tr/td[2]/a")
	private WebElement ClickonOrder;

	// ---For ViewButton---//
	@FindBy(how = How.XPATH, using = "//input[@id='viewButton']")
	private WebElement ViewButton;

	// ---For Clear Btn ---//
	@FindBy(how = How.XPATH, using = "//input[@id='clearButton']")
	private WebElement clearbtn;

	// ---For reversebtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='reverse']")
	private WebElement reversebtn;

	// ---For Genbill---//
	@FindBy(how = How.XPATH, using = "//input[@id='genbill']")
	private WebElement Genbill;

	// ---For Genbulkbill---//
	@FindBy(how = How.XPATH, using = "//input[@id='genBulkBill']")
	private WebElement Genbulkbill;
	
	// ---For NoOfRows---//
		@FindBy(how = How.XPATH, using = "//td[@id='noOfRows']")
		private WebElement NoOfRows;
	
	

	// ----------------------Basic functions----------------------//

	// For Select selectSBU
	public void selectSBU(String sbu) {
		selectvalue(sbu, SBU);
	}
	
	// For Select getSBU
		public String getSBU() {
			return getselectDrpdwnValue(SBU);	
		}

	// For Select selectCustomertype
	public void selectCustomertype(String customertype) {
		selectvalue(customertype, Customertype);
	}

	// For Select Salesman
	public void selectSalesman(String salesman) {
		selectvalue(salesman, Salesman);
	}
	
	// For Select getSalesman
			public String getSalesman() {
				return getselectDrpdwnValue(Salesman);
				
			}

	// For Select Route
	public void selectRoute(String route) {
		selectvalue(route, Route);
	}

	// For Select getRoute
				public String getRoute() {
					return getselectDrpdwnValue(Route);
					
				}
				
	// For Select customername
	public void selectCustomer(String customername) {
		selectvalue(customername, Customername);
	}

	// For Select getCustomer
	public String getCustomer() {
		return getselectDrpdwnValue(Customername);
		
	}
	// ---For Billno---//
	public void enterOrderno(String orderno) {
		entervalue(orderno, Orderno);
	}

	// ---For FromDate---//
	public void enterFromDate(String fromdate) {
		entervalue(fromdate, FromDate);
	}

	// ---For ToDate---//
	public void enterToDate(String toDate) {
		entervalue(toDate, ToDate);
	}

	// For Click Status
	public void selectStatusoption(String status) {
		if (status.equalsIgnoreCase("Confirmed")) {
			buttonClick(StatusConfirmed);
		} else if (status.equalsIgnoreCase("Reversed")) {
			buttonClick(StatusReversed);
		} else if (status.equalsIgnoreCase("Bill Generated")) {
			buttonClick(StatusInvoiceGenerated);
		} else if (status.equalsIgnoreCase("All")) {
			buttonClick(StatusAll);
		}
	}

	// For Click Status
	public void selectAllOrders() {
		checkboxselect(SelectAllCheckbox);

	}

	// For Click ClickonOrder
	public void clickOnOrder() {
		buttonClick(ClickonOrder);
	}

	// For Click ViewBtn
	public void clickviewbtn() {
		buttonClick(ViewButton);
	}

	// For Click Clear
	public void clickclearBtn() {
		buttonClick(clearbtn);
	}

	// For Click Clear
	public void clickonReverseBtn() {
		buttonClick(reversebtn);
	}

	// For Click onGeneratebill
	public void clickonGeneratebill() {
		buttonClick(Genbill);
	}

	// For Click onGeneratebill
	public void clickonGeneratebulkbill() {
		buttonClick(Genbulkbill);
	}
	
	// For Click onGeneratebill
		public String getnoofrows() {
			return getText(NoOfRows);
		}

	public int getNumOfRows() {
		List<WebElement> rows = driver.findElements(By.xpath("//div[@id='OrderListDiv']/table/tbody/tr"));
		// System.out.println(rows.size());
		return rows.size();

	}

	public void ClickonOrderCheckbox(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//div[@id='OrderListDiv']/table/tbody/tr[" + rnum + "]/td[1]/span/input"));
		highLightElement(driver, element);
		element.click();
	}

	public void ClickonOrderNumber(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//div[@id='OrderListDiv']/table/tbody/tr[" + rnum + "]/td[2]/a"));
		highLightElement(driver, element);
		element.click();
	}

	public String getOrderNumber(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//div[@id='OrderListDiv']/table/tbody/tr[" + rnum + "]/td[2]/a"));
		highLightElement(driver, element);
		return element.getText().trim();
	}

	public String getOrderDate(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//div[@id='OrderListDiv']/table/tbody/tr[" + rnum + "]/td[3]/span"));
		highLightElement(driver, element);
		return element.getText().trim();
	}

	public String getOrderCustUID(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//div[@id='OrderListDiv']/table/tbody/tr[" + rnum + "]/td[5]/span"));
		highLightElement(driver, element);
		return element.getText().trim();
	}

	public String getCustName(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//div[@id='OrderListDiv']/table/tbody/tr[" + rnum + "]/td[6]/span"));
		highLightElement(driver, element);
		return element.getText().trim();
	}

	public String getCustType(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//div[@id='OrderListDiv']/table/tbody/tr[" + rnum + "]/td[7]/span"));
		highLightElement(driver, element);
		return element.getText().trim();
	}

	public String getOrderStatus(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//div[@id='OrderListDiv']/table/tbody/tr[" + rnum + "]/td[8]/span"));
		highLightElement(driver, element);
		return element.getText().trim();
	}

	public String getOrderAmt(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//div[@id='OrderListDiv']/table/tbody/tr[" + rnum + "]/td[9]/input"));
		return getvalue(element);
	}

	public String getOrderTime(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//div[@id='OrderListDiv']/table/tbody/tr[" + rnum + "]/td[11]/span"));
		highLightElement(driver, element);
		return element.getText().trim();
	}

}
