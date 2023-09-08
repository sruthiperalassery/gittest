package com.UBQPageObjectLib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.UBQGenericLib.WebDriverCommonLib;

public class CollectionBrowser extends WebDriverCommonLib {

	WebDriver driver;

	// ----------------------Constructor----------------------//
	public CollectionBrowser(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

	// ---For Select Customer ---//
	// ---For CustomerType---//
	@FindBy(how = How.XPATH, using = "//select[@id='entityType']")
	private WebElement CustomerType;

	// ---For CustomerName---//
	@FindBy(how = How.XPATH, using = "//select[@id='partyNameSelect']")
	private WebElement CustomerName;

	// ---For Receipt Detail ---//
	// ---For FromDate ---//
	@FindBy(how = How.XPATH, using = "//input[@id='fromDate']")
	private WebElement FromDate;

	// ---For ToDate ---//
	@FindBy(how = How.XPATH, using = "//input[@id='toDate']")
	private WebElement ToDate;

	// ---For PaymentMode Radiobuttons ---//
	// ---For AllPM ---//
	@FindBy(how = How.XPATH, using = "//input[@id='payModeAll']")
	private WebElement AllPM;

	// ---For Cash ---//
	@FindBy(how = How.XPATH, using = "//input[@id='payModeCash']")
	private WebElement Cash;

	// ---For Cheque ---//
	@FindBy(how = How.XPATH, using = "//input[@id='payModeCheque']")
	private WebElement Cheque;

	// ---For EMoney ---//
	@FindBy(how = How.XPATH, using = "//input[@id='payModeDraft']")
	private WebElement EMoney;

	// ---For Cheque/Ref No. field---//
	@FindBy(how = How.XPATH, using = "//input[@id='chequeNo']")
	private WebElement ChequeNofield;

	// ---For Status Radiobuttons ---//
	// ---For AllStatus ---//
	@FindBy(how = How.XPATH, using = "//input[@id='statusAll']")
	private WebElement AllStatus;

	// ---For Submitted ---//
	@FindBy(how = How.XPATH, using = "//input[@id='statusSubmitted']")
	private WebElement Submitted;

	// ---For ChequeDeposited ---//
	@FindBy(how = How.XPATH, using = "//input[@id='statusDeposited']")
	private WebElement ChequeDeposited;

	// ---For ChequeRealized ---//
	@FindBy(how = How.XPATH, using = "//input[@id='statusRealized']")
	private WebElement ChequeRealized;

	// ---For ChequeBounced ---//
	@FindBy(how = How.XPATH, using = "//input[@id='statusBounced']")
	private WebElement ChequeBounced;

	// ---For Cancelled ---//
	@FindBy(how = How.XPATH, using = "//input[@id='statusCancelled']")
	private WebElement Cancelled;

	// ---For ViewBtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='cmdView']")
	private WebElement ViewBtn;

	// ---For ClearBtn ---//
	@FindBy(how = How.XPATH, using = "//input[@id='cmdClear']")
	private WebElement ClearBtn;

	// ---For RowwiseCheckbox ---//
	@FindBy(how = How.XPATH, using = "//table[@id='receiptTab']/tbody/tr[1]/td[1]/input")
	private WebElement RowwiseCheckbox;

	// ---For ReceiptNo ---//
	@FindBy(how = How.XPATH, using = "//table[@id='receiptTab']/tbody/tr[1]/td[1]/a")
	private WebElement ReceiptNo;

	// ---For CollectionDate ---//
	@FindBy(how = How.XPATH, using = "//table[@id='receiptTab']/tbody/tr[1]/td[2]")
	private WebElement CollectionDate;

	// ---For Customer ---//
	@FindBy(how = How.XPATH, using = "//table[@id='receiptTab']/tbody/tr[1]/td[3]")
	private WebElement Customer;

	// ---For Type ---//
	@FindBy(how = How.XPATH, using = "//table[@id='receiptTab']/tbody/tr[1]/td[4]")
	private WebElement Type;

	// ---For ReceiptAmount ---//
	@FindBy(how = How.XPATH, using = "//table[@id='receiptTab']/tbody/tr[1]/td[5]")
	private WebElement ReceiptAmount;

	// ---For AmounttoAdjust ---//
	@FindBy(how = How.XPATH, using = "//table[@id='receiptTab']/tbody/tr[1]/td[6]")
	private WebElement AmounttoAdjust;

	// ---For Chq/Ref. No column ---//
	@FindBy(how = How.XPATH, using = "//table[@id='receiptTab']/tbody/tr[1]/td[7]")
	private WebElement ChqNocolumn;

	// ---For Date ---//
	@FindBy(how = How.XPATH, using = "//table[@id='receiptTab']/tbody/tr[1]/td[8]")
	private WebElement Date;

	// ---For Bank ---//
	@FindBy(how = How.XPATH, using = "//table[@id='receiptTab']/tbody/tr[1]/td[9]")
	private WebElement Bank;

	// ---For Paymode ---//
	@FindBy(how = How.XPATH, using = "//table[@id='receiptTab']/tbody/tr[1]/td[10]")
	private WebElement Paymode;

	// ---For MarkasDepositedBtn ---//
	@FindBy(how = How.XPATH, using = "//input[@id='deposit']")
	private WebElement MarkasDepositedBtn;

	// ---For MarkasRealizedBtn ---//
	@FindBy(how = How.XPATH, using = "//input[@id='realize']")
	private WebElement MarkasRealizedBtn;

	// ---For MarkasBouncedBtn ---//
	@FindBy(how = How.XPATH, using = "//input[@id='bounce']")
	private WebElement MarkasBouncedBtn;

	// ---For CancelReceiptBtn ---//
	@FindBy(how = How.XPATH, using = "//input[@id='cancelReceipt']")
	private WebElement CancelReceiptBtn;

	// ---For totalAmt1 ---//
	@FindBy(how = How.XPATH, using = "//td[@id='totamount']/label[1]")
	private WebElement totalAmt1;

	// ---For totalAmt2 ---//
	@FindBy(how = How.XPATH, using = "//td[@id='totamount']/label[2]")
	private WebElement totalAmt2;

	// ---For rowcount ---//
	@FindBy(how = How.XPATH, using = "//td[@id='rows']")
	private WebElement rowcount;
	
	// ---For PopupDate ---//
		@FindBy(how = How.XPATH, using = "//input[@id='date']")
		private WebElement PopupDate;
		
		// ---For PopupOkBtn ---//
				@FindBy(how = How.XPATH, using = "//input[@id='okBtn']")
				private WebElement PopupOkBtn;	
	
	

	// ----------------------Basic functions----------------------//

	public void selectCustomerType(String custtype) {
		selectvalue(custtype, CustomerType);
	}

	public void selectCustomerName(String custname) {
		selectvalue(custname, CustomerName);
	}

	public void enterFromDate(String fromdate) {
		entervalue(fromdate, FromDate);
	}

	public void enterToDate(String todate) {
		entervalue(todate, ToDate);
	}

	public void selectpaymode(String paymode) {
		if (paymode.equalsIgnoreCase("All")) {
			buttonClick(AllPM);
		} else if (paymode.equalsIgnoreCase("Cash")) {
			buttonClick(Cash);
		} else if (paymode.equalsIgnoreCase("Cheque")) {
			buttonClick(Cheque);
		} else if (paymode.equalsIgnoreCase("EMoney")) {
			buttonClick(EMoney);
		}
	}

	public void enterChequeNofield(String chequeno) {
		entervalue(chequeno, ChequeNofield);
	}

	public void selectStatus(String status) {
		if (status.equalsIgnoreCase("All")) {
			buttonClick(AllStatus);
		} else if (status.equalsIgnoreCase("Submitted")) {
			buttonClick(Submitted);
		} else if (status.equalsIgnoreCase("ChequeDeposited")) {
			buttonClick(ChequeDeposited);
		} else if (status.equalsIgnoreCase("ChequeRealized")) {
			buttonClick(ChequeRealized);
		} else if (status.equalsIgnoreCase("ChequeBounced")) {
			buttonClick(ChequeBounced);
		} else if (status.equalsIgnoreCase("Cancelled")) {
			buttonClick(Cancelled);
		}
	}

	public void clickViewBtn() {
		buttonClick(ViewBtn);
	}

	public void clickClearBtn() {
		buttonClick(ClearBtn);
	}

	public int getNumOfRows() {
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='receiptTab']/tbody/tr"));
		return rows.size();

	}

	public void selectRowwiseCheckbox(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='receiptTab']/tbody/tr[" + rnum + "]/td[1]/input"));
		checkboxselect(element);
	}

	public String getReceiptNo(int rnum) {
		WebElement element = driver.findElement(By.xpath("//table[@id='receiptTab']/tbody/tr[" + rnum + "]/td[1]/a"));
		highLightElement(driver, element);
		return element.getText().trim();
	}

	public void ClickOnReceiptNo(int rnum) {
		WebElement element = driver.findElement(By.xpath("//table[@id='receiptTab']/tbody/tr[" + rnum + "]/td[1]/a"));
		buttonClick(element);
	}

	public String getCollectionDate(int rnum) {
		WebElement element = driver.findElement(By.xpath("//table[@id='receiptTab']/tbody/tr[" + rnum + "]/td[2]"));
		highLightElement(driver, element);
		return element.getText().trim();
	}

	public String getCustomer(int rnum) {
		WebElement element = driver.findElement(By.xpath("//table[@id='receiptTab']/tbody/tr[" + rnum + "]/td[3]"));
		highLightElement(driver, element);
		return element.getText().trim();
	}

	public String getCustType(int rnum) {
		WebElement element = driver.findElement(By.xpath("//table[@id='receiptTab']/tbody/tr[" + rnum + "]/td[4]"));
		highLightElement(driver, element);
		return element.getText().trim();
	}

	public String getReceiptAmount(int rnum) {
		WebElement element = driver.findElement(By.xpath("//table[@id='receiptTab']/tbody/tr[" + rnum + "]/td[5]"));
		highLightElement(driver, element);
		return element.getText().trim();
	}

	public String getAmounttoAdjust(int rnum) {
		WebElement element = driver.findElement(By.xpath("//table[@id='receiptTab']/tbody/tr[" + rnum + "]/td[6]"));
		highLightElement(driver, element);
		return element.getText().trim();
	}

	public String getChqreffno(int rnum) {
		WebElement element = driver.findElement(By.xpath("//table[@id='receiptTab']/tbody/tr[" + rnum + "]/td[7]"));
		highLightElement(driver, element);
		return element.getText().trim();
	}

	public String getDate(int rnum) {
		WebElement element = driver.findElement(By.xpath("//table[@id='receiptTab']/tbody/tr[" + rnum + "]/td[8]"));
		highLightElement(driver, element);
		return element.getText().trim();
	}

	public String getBank(int rnum) {
		WebElement element = driver.findElement(By.xpath("//table[@id='receiptTab']/tbody/tr[" + rnum + "]/td[9]"));
		highLightElement(driver, element);
		return element.getText().trim();
	}

	public String getPaymode(int rnum) {
		WebElement element = driver.findElement(By.xpath("//table[@id='receiptTab']/tbody/tr[" + rnum + "]/td[10]"));
		highLightElement(driver, element);
		return element.getText().trim();
	}

	public String getCollectorName(int rnum) {
		WebElement element = driver.findElement(By.xpath("//table[@id='receiptTab']/tbody/tr[" + rnum + "]/td[11]"));
		highLightElement(driver, element);
		return element.getText().trim();
	}

	public void clickMarkasDepositedBtn() {
		buttonClick(MarkasDepositedBtn);
	}

	public void clickMarkasRealizedBtn() {
		buttonClick(MarkasRealizedBtn);
	}

	public void clickMarkasBouncedBtn() {
		buttonClick(MarkasBouncedBtn);
	}

	public void clickCancelReceiptBtn() {
		buttonClick(CancelReceiptBtn);
	}

	public String gettotalReciptAmt() {
		return getText(totalAmt1);

	}

	public String gettotalAdjustAmt() {
		return getText(totalAmt2);

	}

	public int getRowcount() {
		String text[] = getText(rowcount).split(": ");
		return Integer.parseInt(text[1]);

	}
	
	public void enterPopupDate(String value) {
		 entervalue(value, PopupDate);

	}
	
	public String getPopupDate() {
		return getvalue(PopupDate);

	}
	
	public void clickPopupOkBtn() {
		buttonClick(PopupOkBtn);
	}
	
	

}
