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
public class PaymentToSupplier extends WebDriverCommonLib {

	WebDriver driver;

	// ----------------------Constructor----------------------//
	public PaymentToSupplier(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

	// ---For ChequeMode---//
	@FindBy(how = How.XPATH, using = "//input[@id='radiobutton1']")
	private WebElement ChequeMode;

	// ---For DraftMode---//
		@FindBy(how = How.XPATH, using = "//input[@id='radiobutton2']")
		private WebElement DraftMode;
	
	// ---For EmoneyMode---//
	@FindBy(how = How.XPATH, using = "//input[@id='radiobutton3']")
	private WebElement EmoneyMode;

	// ---For BanknamefoCheque---//
	@FindBy(how = How.XPATH, using = "//select[@id='bank1']")
	private WebElement BanknameforCheque;

	// ---For BanknamefoEmoney---//
	@FindBy(how = How.XPATH, using = "//select[@id='bank']")
	private WebElement BanknameforEmoney;

	// ---For ChequeNo---//
	@FindBy(how = How.XPATH, using = "//input[@id='cheque_no']")
	private WebElement ChequeNo;

	// ---For Draftno---//
	@FindBy(how = How.XPATH, using = "//input[@id='draft_no']")
	private WebElement Draftno;

	// ---For EmoneyAmt---//
	@FindBy(how = How.XPATH, using = "//input[@id='amount']")
	private WebElement EmoneyAmt;

	// ---For EmoneyAmt---//
	@FindBy(how = How.XPATH, using = "//input[@id='issuedate']")
	private WebElement EmoneyDate;

	// ---For AddCheckbox---//
	@FindBy(how = How.XPATH, using = "//input[@id='chkAdd']")
	private WebElement AddCheckbox;

	// ---For Addcheques---//
	@FindBy(how = How.XPATH, using = "//input[@id='add_cheques']")
	private WebElement Addcheques;

	// ---For Save Btn---//
	@FindBy(how = How.XPATH, using = "//input[@id='save']")
	private WebElement savebtn;

	// ---For Save Btn---//
	@FindBy(how = How.XPATH, using = "//input[@id='cancel']")
	private WebElement ClearBtn;

	// ---For SearchDate---//
	@FindBy(how = How.XPATH, using = "//input[@id='searchDate']")
	private WebElement SearchDate;

	// ---For GoBtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='chqSearch']")
	private WebElement GoBtn;

	// ---For DeleteBtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='xdelete']")
	private WebElement DeleteBtn;

	// ---For DeleteBtn---//
	@FindBy(how = How.XPATH, using = "//div[@id='resultDiv']/table/tbody/tr/td[1]/input")
	private WebElement CheckBoxTodelete;

	// ---For RenferenceNo---//
	@FindBy(how = How.XPATH, using = "//div[@id='resultDiv']/table/tbody/tr/td[2]")
	private WebElement RenferenceNo;

	// ---For BankName---//
	@FindBy(how = How.XPATH, using = "//div[@id='resultDiv']/table/tbody/tr/td[3]")
	private WebElement BankName;

	// ---For BranchName---//
	@FindBy(how = How.XPATH, using = "//div[@id='resultDiv']/table/tbody/tr/td[4]")
	private WebElement BranchName;

	// ---For dataofissue---//
	@FindBy(how = How.XPATH, using = "//div[@id='resultDiv']/table/tbody/tr/td[5]")
	private WebElement dataofissue;

	// ---For dataofissue---//
	@FindBy(how = How.XPATH, using = "//div[@id='resultDiv']/table/tbody/tr/td[6]")
	private WebElement issueAmt;

	// ---For Status---//
	@FindBy(how = How.XPATH, using = "//div[@id='resultDiv']/table/tbody/tr/td[7]")
	private WebElement Status;

	// ----------------------Functions----------------------//

	public void SelectChequeAspaymentMode() {
		buttonClick(ChequeMode);
	}

	public void SelectDraftAspaymentMode() {
		buttonClick(DraftMode);
	}
	
	public void SelectEmoneyAspaymentMode() {
		buttonClick(EmoneyMode);
	}

	public void SelectBankforCheque(String bank) {
		selectvalue(bank, BanknameforCheque);
	}

	public void SelectBankforEmoney(String bank) {
		selectvalue(bank, BanknameforEmoney);
	}

	public void EnterEmoneyReffNo(String reffno) {
		entervalue(reffno, Draftno);
	}

	public void EnterChequeReffNo(String chequeno) {
		entervalue(chequeno, ChequeNo);
	}

	public void EnterEmoneyDate(String date) {
		entervalue(date, EmoneyDate);
	}

	public void EnterEmoneyAmt(String Amt) {
		entervalue(Amt, EmoneyAmt);
	}

	public void EnterSequencialCheques(String sequence) {
		entervalue(sequence, Addcheques);
	}

	public void ClickonSavebtn() {
		buttonClick(savebtn);
	}

	public void selectaddcheckbox() {
		buttonClick(AddCheckbox);
	}

	public void ClickonCancelbtn() {
		buttonClick(ClearBtn);
	}

	public void EnterSearchDate(String date) {
		entervalue(date, SearchDate);
	}

	public void ClickonGobtn() {
		buttonClick(GoBtn);
	}

	public void ClickonDeletebtn() {
		buttonClick(DeleteBtn);
	}

	public void CheckboxselecttoDelete() {
		buttonClick(CheckBoxTodelete);
	}

	public String getReffNumber() {
		return getText(RenferenceNo);
	}

	public String getBankName() {
		return getText(BankName);
	}

	public String getBranchName() {
		return getText(BranchName);
	}

	public String getissueDate() {
		return getText(dataofissue);
	}

	public String getissueAmt() {
		return getText(issueAmt);
	}

	public String getissueStatus() {
		return getText(Status);
	}
	
	public int getNumOfRows() {
		List<WebElement> size = driver.findElements(By.xpath("//div[@id='resultDiv']/table/tbody/tr"));
		return size.size();
	}
	
	public String getdatafrommultiplerows(int rnum, int cnum) {
		WebElement element = driver
				.findElement(By.xpath("//div[@id='resultDiv']/table/tbody/tr[" + rnum + "]/td[" + cnum + "]"));
		highLightElement(driver, element);
		String value =element.getText().trim();
		// System.out.println(value);
		return value;

	}
	
	public void clickoncheckbox(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//div[@id='resultDiv']/table/tbody/tr[" + rnum + "]/td[1]"));
		highLightElement(driver, element);
		element.click();
	}

}
