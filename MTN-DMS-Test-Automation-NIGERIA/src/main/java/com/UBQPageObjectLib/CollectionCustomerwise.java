package com.UBQPageObjectLib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.UBQGenericLib.WebDriverCommonLib;

public class CollectionCustomerwise extends WebDriverCommonLib {

	WebDriver driver;

	// ----------------------Constructor----------------------//
	public CollectionCustomerwise(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

	// ---For SBU---//
	@FindBy(how = How.XPATH, using = "//select[@id='SBU']")
	private WebElement SBU;

	// ---For Salesman---//
	@FindBy(how = How.XPATH, using = "//select[@id='salesman']")
	private WebElement Salesman;

	// ---For Route---//
	@FindBy(how = How.XPATH, using = "//select[@id='beat']")
	private WebElement Route;

	// ---For Customer---//
	@FindBy(how = How.XPATH, using = "//select[@id='shop']")
	private WebElement Customer;

	// ---For CustomerACBalance---//
	@FindBy(how = How.XPATH, using = "//input[@id='customerBalance']")
	private WebElement CustomerACBalance;

	// ---For SalesInvoicewise---//
	// ---For InvoiceRange ---//
	@FindBy(how = How.XPATH, using = "//input[@id='invoiceRange']")
	private WebElement InvoiceRange;

	// ---For InvoiceSeries ---//
	@FindBy(how = How.XPATH, using = "//select[@id='billSeriesprefix']")
	private WebElement InvoiceSeries;

	// ---For ViewBtn ---//
	@FindBy(how = How.XPATH, using = "//input[@id='view']")
	private WebElement ViewBtn;

	// ---For ReceiptradoioBtn ---//
	@FindBy(how = How.XPATH, using = "//input[@id='0receiptoption']")
	private WebElement ReceiptradoioBtn;

	// ---For CollectionDate ---//
	@FindBy(how = How.XPATH, using = "//input[@id='receiptDate']")
	private WebElement CollectionDate;

	// ---For Amount ---//
	@FindBy(how = How.XPATH, using = "//input[@id='receiptAmount']")
	private WebElement Amount;

	// ---For AmounttoAdjust ---//
	@FindBy(how = How.XPATH, using = "//input[@id='amounttoAdjust']")
	private WebElement AmounttoAdjust;

	// ---For Modeofpayment ---//

	// ---For ChequeOption ---//
	@FindBy(how = How.XPATH, using = "//div[@id='receiptDetailEntryDiv']/table/tbody/tr[2]/td[1]/table/tbody/tr[2]/td/input")
	private WebElement ChequeOption;

	// ---For EmoneyOption ---//
	@FindBy(how = How.XPATH, using = "//div[@id='receiptDetailEntryDiv']/table/tbody/tr[2]/td[1]/table/tbody/tr[3]/td/input")
	private WebElement draftOption;

	// ---For CashOption ---//
	@FindBy(how = How.XPATH, using = "//div[@id='receiptDetailEntryDiv']/table/tbody/tr[2]/td[1]/table/tbody/tr[4]/td/input")
	private WebElement CashOption;
	
	// ---For CollectorName ---//
	@FindBy(how = How.XPATH, using = "//input[@id='collectorName']")
	private WebElement CollectorName;

	// ---For GLAC ---//
	@FindBy(how = How.XPATH, using = "//select[@id='awBank']")
	
	private WebElement GLAC;

	// ---For Bank ---//
	@FindBy(how = How.XPATH, using = "//input[@id='bankName']")
	private WebElement Bank;

	// ---For ChequeNo/Transaction Reference No. ---//
	@FindBy(how = How.XPATH, using = "//input[@id='chequeNo']")
	private WebElement ChequeNo;

	// ---For Datefield ---//
	@FindBy(how = How.XPATH, using = "//input[@id='chequeDate']")
	private WebElement Datefield;

	// ---For WriteOffradoioBtn ---//
	@FindBy(how = How.XPATH, using = "//input[@id='1receiptoption']")
	private WebElement WriteOffradoioBtn;

	// ---For AdjustAdvanceradoioBtn ---//
	@FindBy(how = How.XPATH, using = "//input[@id='2receiptoption']")
	private WebElement AdjustAdvanceradoioBtn;

	// ---For AdvanceAmount ---//
	@FindBy(how = How.XPATH, using = "//input[@id='advanceAmount']")
	private WebElement AdvanceAmount;

	// ---For RowwiseCheckbox ---//
	@FindBy(how = How.XPATH, using = "//table[@id='invoiceTab']/tbody/tr/td[1]/input")
	private WebElement RowwiseCheckbox;

	// ---For SalesInvoiceNo ---//
	@FindBy(how = How.XPATH, using = "//table[@id='invoiceTab']/tbody/tr/td[2]")
	private WebElement SalesInvoiceNo;

	// ---For Datecolumn ---//
	@FindBy(how = How.XPATH, using = "//table[@id='invoiceTab']/tbody/tr/td[3]")
	private WebElement Datecolumn;

	// ---For InvoiceAmt ---//
	@FindBy(how = How.XPATH, using = "//table[@id='invoiceTab']/tbody/tr/td[4]")
	private WebElement InvoiceAmt;

	// ---For PaidAmt ---//
	@FindBy(how = How.XPATH, using = "//table[@id='invoiceTab']/tbody/tr/td[5]")
	private WebElement PaidAmt;

	// ---For DueAmt ---//
	@FindBy(how = How.XPATH, using = "//table[@id='invoiceTab']/tbody/tr/td[6]")
	private WebElement DueAmt;

	// ---For Currentpayment ---//
	@FindBy(how = How.XPATH, using = "//table[@id='invoiceTab']/tbody/tr/td[7]")
	private WebElement Currentpayment;

	// ---For Noofrecordsfound ---//
	@FindBy(how = How.XPATH, using = "//td[@id='noofRecord']")
	private WebElement Noofrecordsfound;

	// ---For Totaladjustedamount ---//
	@FindBy(how = How.XPATH, using = "//input[@id='adjustedAmount']")
	private WebElement Totaladjustedamount;

	// ---For Savebtn ---//
	@FindBy(how = How.XPATH, using = "//input[@id='Submit']")
	private WebElement Savebtn;

	// ---For Clearbtn ---//
	@FindBy(how = How.XPATH, using = "//input[@id='cancel']")
	private WebElement Clearbtn;


	// ----------------------Basic functions----------------------//

	public void selectSBU(String sbu) {
		selectvalue(sbu, SBU);
	}
	
	// ---get select category---//
	public String getselectSBU() {
		return getselectDrpdwnValue(SBU);
	}
	
	
	public void selectPayModeOption(String paymode) {
		if (paymode.contains("Cheque")) {
			buttonClick(ChequeOption);
		}else if (paymode.contains("Draft")) {
			buttonClick(draftOption);
		}else{
			buttonClick(CashOption);
		}
	}

	public void selectSalesman(String salesman) {
		selectvalue(salesman, Salesman);
	}

	public void selectRoute(String beat) {
		selectvalue(beat, Route);
	}

	public void selectCustomer(String shop) {
		selectvalue(shop, Customer);
	}

	public float  getCustomerACBalance() {
		String []record =getvalue(CustomerACBalance).split(" ");
		String no = record[0];
		return Float.parseFloat(no);
	}

	public void enterInvoiceRange(String invrange) {
		entervalue(invrange, InvoiceRange);
	}

	public void selectInvoiceSeries(String invseries) {
		selectvalue(invseries, InvoiceSeries);
	}

	public void clickViewBtn() {
		buttonClick(ViewBtn);
	}

	public void clickReceiptradoioBtn() {
		buttonClick(ReceiptradoioBtn);
	}

	public void enterCollectionDate(String coldate) {
		entervalue(coldate, CollectionDate);
	}
	
	public String getCollectionDate() {
		return getvalue(CollectionDate);
	}

	public void enterAmount(String amt) {
		entervalue(amt, Amount);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Amount.sendKeys(Keys.TAB);
	}
	public String getAmount() {
		return getvalue(Amount);
	}

	public void enterAmounttoAdjust(String amttoadjust) {
		entervalue(amttoadjust, AmounttoAdjust);
	}
	
	public String getAmounttoAdjust() {
		return getvalue(AmounttoAdjust);
	}

	public void enterCollectorName(String collectorname) {
		entervalue(collectorname, CollectorName);
	}
	public String getCollectorName() {
		return getvalue(CollectorName);
	}

	public void selectGLAC(String glacc) {
		selectvalue(glacc, GLAC);
	}
	
	public void enterBank(String bnk) {
		entervalue(bnk, Bank);
		
	}

	public String getBank() {
		return getvalue(Bank);
	}
	
	public void enterChequeNo(String chqno) {
		entervalue(chqno, ChequeNo);
	}

	public String getChequeNo() {
		return getvalue(ChequeNo);
	}
	
	public void enterDatefield(String datefld) {
		entervalue(datefld, Datefield);
	}
	
	public String getDatefield() {
		return getvalue(Datefield);
	}
	
	public void clickWriteOffradioBtn() {
		buttonClick(WriteOffradoioBtn);
	}

	public void clickAdjustAdvanceradioBtn() {
		buttonClick(AdjustAdvanceradoioBtn);
	}

	public String getAdvanceAmount() {
		return getvalue(AdvanceAmount);
	}

	public int getNumberofRows() {
		List<WebElement> size = driver.findElements(By.xpath("//table[@id='invoiceTab']/tbody/tr"));
		return size.size();
	}
	
	public void selectRowwiseCheckbox(int row) {
		WebElement element = driver.findElement(By.xpath("//table[@id='invoiceTab']/tbody/tr["+row+"]/td[1]/input"));
		element.click();
	}
	public void selectRowwisedeCheckbox(int row) {
		WebElement element = driver.findElement(By.xpath("//table[@id='invoiceTab']/tbody/tr["+row+"]/td[1]/input"));
		element.click();
	}

	public String getSalesInvoiceNo(int row) {
		WebElement element = driver.findElement(By.xpath("//table[@id='invoiceTab']/tbody/tr["+row+"]/td[2]"));
		String val = getText(element);
		return val;
	}

	public String getDate(int row) {
		WebElement element = driver.findElement(By.xpath("//table[@id='invoiceTab']/tbody/tr["+row+"]/td[3]"));
		String val = getText(element);
		return val;
	}

	public String getInvoiceAmt(int row) {
		WebElement element = driver.findElement(By.xpath("//table[@id='invoiceTab']/tbody/tr["+row+"]/td[4]"));
		String val = getText(element);
		return val;
	}

	public String getPaidAmt(int row) {
		WebElement element = driver.findElement(By.xpath("//table[@id='invoiceTab']/tbody/tr["+row+"]/td[5]"));
		String val = getText(element);
		return val;
	}

	public String getDueAmt(int row) {
		WebElement element = driver.findElement(By.xpath("//table[@id='invoiceTab']/tbody/tr["+row+"]/td[6]"));
		String val = getText(element);
		return val;
	}

	public String getCurrentpayment(int row) {
		WebElement element = driver.findElement(By.xpath("//table[@id='invoiceTab']/tbody/tr["+row+"]/td[7]/input"));
		String val = getvalue(element);
		return val;
	}

	public int getNoofrecordsfound() {
		String []record =getText(Noofrecordsfound).split(": ");
		String no = record[1];
		return Integer.parseInt(no);
	}

	public String getTotaladjustedamount() {
		return getvalue(Totaladjustedamount);
	}

	public void clickSavebtn() {
		buttonClick(Savebtn);
	}

	public void clickClearbtn() {
		buttonClick(Clearbtn);
	}

}
