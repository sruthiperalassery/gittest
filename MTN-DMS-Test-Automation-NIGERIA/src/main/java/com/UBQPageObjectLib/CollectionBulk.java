package com.UBQPageObjectLib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.UBQGenericLib.WebDriverCommonLib;

public class CollectionBulk extends WebDriverCommonLib {

	WebDriver driver;

	// ----------------------Constructor----------------------//
	public CollectionBulk(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

	// ---For CustomerType---//
	@FindBy(how = How.XPATH, using = "//select[@id='entityType']")
	private WebElement CustomerType;

	// ---For Customer---//
	@FindBy(how = How.XPATH, using = "//select[@id='partyNameSelect']")
	private WebElement Customer;

	// ---For CustomerWiseOption---//
	@FindBy(how = How.XPATH, using = "//input[@id='opt0']")
	private WebElement CustomerWiseOption;

	// ---For BillWiseOption---//
	@FindBy(how = How.XPATH, using = "//input[@id='opt2']")
	private WebElement BillWiseOption;

	// ---For PaymentModeAll---//
	@FindBy(how = How.XPATH, using = "//input[@id='paymentTerm0']")
	private WebElement PaymentModeAll;

	// ---For PaymentModeCash---//
	@FindBy(how = How.XPATH, using = "//input[@id='paymentTerm1']")
	private WebElement PaymentModeCash;

	// ---For PaymentModeCheque---//
	@FindBy(how = How.XPATH, using = "//input[@id='paymentTerm2']")
	private WebElement PaymentModeCheque;

	// ---For PaymentModeDraft---//
	@FindBy(how = How.XPATH, using = "//input[@id='paymentTerm3']")
	private WebElement PaymentModeDraft;

	// ---For PaymentModeMT---//
	@FindBy(how = How.XPATH, using = "//input[@id='paymentTerm4']")
	private WebElement PaymentModeMT;

	// ---For BilldateFrom---//
	@FindBy(how = How.XPATH, using = "//input[@id='fromDate']")
	private WebElement BilldateFrom;

	// ---For BilldateTo---//
	@FindBy(how = How.XPATH, using = "//input[@id='toDate']")
	private WebElement BilldateTo;

	// ---For BillNo---//
	@FindBy(how = How.XPATH, using = "//input[@id='toDate']")
	private WebElement BillNo;

	// ---For LoadBillsBtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='view']")
	private WebElement LoadBillsBtn;

	// ---For CollectorName---//
	@FindBy(how = How.XPATH, using = "//input[@id='collectorName']")
	private WebElement CollectorName;

	// ---For CollectionDate---//
	@FindBy(how = How.XPATH, using = "//input[@id='collectionDate']")
	private WebElement CollectionDate;

	// ---For SelectBank---//
	@FindBy(how = How.XPATH, using = "//input[@id='awBank']")
	private WebElement SelectBank;

	// ---For TotalAmtCollected---//
	@FindBy(how = How.XPATH, using = "//input[@id='totalAmountcollected']")
	private WebElement TotalAmtCollected;

	// ---For SaveBtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='save']")
	private WebElement SaveBtn;

	// ---For CancelBtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='cancel']")
	private WebElement CancelBtn;

	// For CustomerType
	public void selectCustomerType(String customerType) {
		selectDrpdwnByTxt(CustomerType, customerType);
	}

	// For Customer
	public void selectCustomer(String customer) {
		selectDrpdwnByTxt(Customer, customer);
	}

	// For selectFileterCriteria
	public void selectFileterCriteria(String option) {
		if (option.contains("Customer wise")) {
			buttonClick(CustomerWiseOption);
		} else if (option.contains("Bill Wise")) {
			buttonClick(CustomerWiseOption);
		}
	}

	// For selectPaymentMode
	public void selectPaymentMode(String mode) {
		if (mode.contains("All")) {
			buttonClick(PaymentModeAll);
		} else if (mode.contains("Cash")) {
			buttonClick(PaymentModeCash);
		} else if (mode.contains("Cheque")) {
			buttonClick(PaymentModeCheque);
		} else if (mode.contains("MT")) {
			buttonClick(PaymentModeMT);
		}
	}

	// For EnterBillDateFrom
	public void EnterBillDateFrom(String from) {
		entervalue(from, BilldateFrom);
	}

	// For EnterBillDateTo
	public void EnterBillDateTo(String to) {
		entervalue(to, BilldateTo);
	}

	// For EnterBillNo
	public void EnterBillNo(String billno) {
		entervalue(billno, BillNo);
	}

	// For EnterCollectorName
	public void EnterCollectorName(String collector) {
		entervalue(collector, CollectorName);
	}

	// For EnterCollectionDate
	public void EnterCollectionDate(String collDate) {
		entervalue(collDate, CollectionDate);
	}

	// For SelectBank
	public void SelectBank(String bank) {
		entervalue(bank, SelectBank);
	}

	// For getTotalAmt
	public String  getTotalAmt() {
		return getvalue(TotalAmtCollected);
	}

	// For clickLoadBillsBtn
	public void clickLoadBillsBtn() {
		buttonClick(LoadBillsBtn);
	}

	// For clickSaveBtn
	public void clickSaveBtn() {
		buttonClick(SaveBtn);
	}

	// For clickClearBtn
	public void clickClearBtn() {
		buttonClick(CancelBtn);
	}

	public int getNumberofRows() {
		List<WebElement> size = driver.findElements(By.xpath("//table[@id='invoiceTab']/tbody/tr"));
		return size.size();
	}

	public void selectRowwiseCheckbox(int row) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='invoiceTab']/tbody/tr[" + row + "]/td[1]/input"));
		element.click();
	}

	public void selectRowwisedeCheckbox(int row) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='invoiceTab']/tbody/tr[" + row + "]/td[1]/input"));
		element.click();
	}

	public String getSalesInvoiceNo(int row) {
		WebElement element = driver.findElement(By.xpath("//table[@id='invoiceTab']/tbody/tr[" + row + "]/td[1]"));
		String val = getText(element);
		return val;
	}
	public String getSalesInvoiceCustomer(int row) {
		WebElement element = driver.findElement(By.xpath("//table[@id='invoiceTab']/tbody/tr[" + row + "]/td[2]"));
		String val = getText(element);
		return val;
	}

	public String getSalesInvoiceDate(int row) {
		WebElement element = driver.findElement(By.xpath("//table[@id='invoiceTab']/tbody/tr[" + row + "]/td[3]"));
		String val = getText(element);
		return val;
	}

	public String getSalesInvoicePayMode(int row) {
		WebElement element = driver.findElement(By.xpath("//table[@id='invoiceTab']/tbody/tr[" + row + "]/td[4]"));
		String val = getText(element);
		return val;
	}

	public void EnterChequeOrDraftRefNo(int row, String value) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='invoiceTab']/tbody/tr[" + row + "]/td[5]/input"));
		entervalue(value, element);
	}

	public String getChequeOrDraftRefNo(int row) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='invoiceTab']/tbody/tr[" + row + "]/td[5]/input"));
		String val = getvalue(element);
		return val;
	}

	public void EnterManualReciptNo(int row, String value) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='invoiceTab']/tbody/tr[" + row + "]/td[6]/input"));
		entervalue(value, element);
	}

	public String getManualReciptNo(int row) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='invoiceTab']/tbody/tr[" + row + "]/td[6]/input"));
		String val = getvalue(element);
		return val;
	}

	public void EnterDate(int row, String value) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='invoiceTab']/tbody/tr[" + row + "]/td[7]/input"));
		entervalue(value, element);
	}

	public String getDate(int row) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='invoiceTab']/tbody/tr[" + row + "]/td[7]/input"));
		String val = getvalue(element);
		return val;
	}

	public void EnterBankName(int row, String value) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='invoiceTab']/tbody/tr[" + row + "]/td[7]/input"));
		entervalue(value, element);
	}

	public String getBankName(int row) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='invoiceTab']/tbody/tr[" + row + "]/td[7]/input"));
		String val = getvalue(element);
		return val;
	}

	public String getBillAmt(int row) {
		WebElement element = driver.findElement(By.xpath("//table[@id='invoiceTab']/tbody/tr[" + row + "]/td[9]"));
		String val = getText(element);
		return val;
	}

	public String getDueAmt(int row) {
		WebElement element = driver.findElement(By.xpath("//table[@id='invoiceTab']/tbody/tr[" + row + "]/td[10]"));
		String val = getText(element);
		return val;
	}

	public void EnterPaymentAmt(int row) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='invoiceTab']/tbody/tr[" + row + "]/td[11]/input"));
		entervalue(value, element);
	}

	public String getPaymentAmt(int row) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='invoiceTab']/tbody/tr[" + row + "]/td[11]/input"));
		String val = getvalue(element);
		return val;
	}

	public String getType(int row) {
		WebElement element = driver.findElement(By.xpath("//table[@id='invoiceTab']/tbody/tr[" + row + "]/td[12]"));
		String val = getText(element);
		return val;
	}

}
