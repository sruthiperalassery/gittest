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
public class PaymentTracking extends WebDriverCommonLib {

	public WebDriver driver;

	// ----------------------Constructor----------------------//
	public PaymentTracking(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

	// ---For Input Cheque---//
	@FindBy(how = How.XPATH, using = "//input[@id='cheque_draft0']")
	private WebElement Cheque;

	// ---For Input ChequeUsed/Not realized ---//
	@FindBy(how = How.XPATH, using = "//input[@id='cheque_select0']")
	private WebElement ChequeUsed;

	// ---For Input ChequeUnUsed ---//
	@FindBy(how = How.XPATH, using = "//input[@id='cheque_select1']")
	private WebElement ChequeUnUsed;

	// ---For Input ChequeRealized ---//
	@FindBy(how = How.XPATH, using = "//input[@id='cheque_select2']")
	private WebElement ChequeRealized;

	// ---For Input ChequeAll ---//
	@FindBy(how = How.XPATH, using = "//input[@id='cheque_select3']")
	private WebElement ChequeAll;

	// ---For Input Draft ---//
	@FindBy(how = How.XPATH, using = "//input[@id='cheque_draft1']")
	private WebElement Draft;

	// ---For Input E-Money ---//
	@FindBy(how = How.XPATH, using = "//input[@id='cheque_draft2']")
	private WebElement EMoney;

	// ---For Input Used ---//
	@FindBy(how = How.XPATH, using = "//input[@id='draft_select0']")
	private WebElement Used;

	// ---For Input UnUsed ---//
	@FindBy(how = How.XPATH, using = "//input[@id='draft_select1']")
	private WebElement UnUsed;

	// ---For Input All ---//
	@FindBy(how = How.XPATH, using = "//input[@id='draft_select2']")
	private WebElement All;

	// ---For Select Bank ---//
	@FindBy(how = How.XPATH, using = "//select[@id='bank']")
	private WebElement Bank;

	// ---For Input Ref. No. ---//
	@FindBy(how = How.XPATH, using = "//input[@id='searchTxt']")
	private WebElement RefNo;

	// ---For ViewBtn ---//
	@FindBy(how = How.XPATH, using = "//input[@id='view']")
	private WebElement ViewBtn;

	// ---For ClearBtn ---//
	@FindBy(how = How.XPATH, using = "//input[@id='clearfilters']")
	private WebElement ClearBtn;

	// ---For Cheque ---//
	// ---For ChequeNo ---//
	@FindBy(how = How.XPATH, using = "//table[@id='chequeTab']/tbody/tr[1]/td[1]")
	private WebElement ChequeNo;

	// ---For ChequeBank ---//
	@FindBy(how = How.XPATH, using = "//table[@id='chequeTab']/tbody/tr[1]/td[2]")
	private WebElement ChequeBank;

	// ---For ChequeRealization Date ---//
	@FindBy(how = How.XPATH, using = "//table[@id='chequeTab']/tbody/tr[1]/td[3]")
	private WebElement ChequeRealizationDate;

	// ---For ChequeAmount ---//
	@FindBy(how = How.XPATH, using = "//table[@id='chequeTab']/tbody/tr[1]/td[4]/input")
	private WebElement ChequeAmount;

	// ---For ChequePurInvNo ---//
	@FindBy(how = How.XPATH, using = "//table[@id='chequeTab']/tbody/tr[1]/td[5]/input")
	private WebElement ChequePurInvNo;

	// ---For ChequeIssue Date ---//
	@FindBy(how = How.XPATH, using = "//table[@id='chequeTab']/tbody/tr[1]/td[6]")
	private WebElement ChequeIssueDate;

	// ---For E-Money ---//
	// ---For EMoneyRef. No. ---//
	@FindBy(how = How.XPATH, using = "//table[@id='draftTab']/tbody/tr[1]/td[1]")
	private WebElement EMoneyRefNo;

	// ---For EMoneyBank ---//
	@FindBy(how = How.XPATH, using = "//table[@id='draftTab']/tbody/tr[1]/td[2]")
	private WebElement EMoneyBank;

	// ---For EMoneyAmount ---//
	@FindBy(how = How.XPATH, using = "//table[@id='draftTab']/tbody/tr[1]/td[3]/input")
	private WebElement EMoneyAmount;

	// ---For EMoneyBalance Amount ---//
	@FindBy(how = How.XPATH, using = "//table[@id='draftTab']/tbody/tr[1]/td[4]/input")
	private WebElement EMoneyBalanceAmount;

	// ---For EMoneyPurInvNo ---//
	@FindBy(how = How.XPATH, using = "//table[@id='draftTab']/tbody/tr[1]/td[6]")
	private WebElement EMoneyPurInvNo;

	// ---For EMoneyPurInvDate ---//
	@FindBy(how = How.XPATH, using = "//table[@id='draftTab']/tbody/tr[1]/td[7]")
	private WebElement EMoneyPurInvDate;

	// ---For EMoneyAmount adjusted ---//
	@FindBy(how = How.XPATH, using = "//table[@id='draftTab']/tbody/tr[1]/td[8]/input")
	private WebElement EMoneyAmountadjusted;

	// ----------------------Functions----------------------//

	public void ClickCheque() {
		buttonClick(Cheque);
	}

	public void ClickChequeUsed() {
		buttonClick(ChequeUsed);

	}

	public void ClickChequeUnUsed() {
		buttonClick(ChequeUnUsed);

	}

	public void ClickChequeRealized() {
		buttonClick(ChequeRealized);

	}

	public void ClickChequeAll() {
		buttonClick(ChequeAll);

	}

	public void ClickDraft() {
		buttonClick(Draft);

	}

	public void ClickEMoney() {
		buttonClick(EMoney);
	}

	public void ClickUsed() {
		buttonClick(Used);

	}

	public void ClickEmoneyUnUsed() {
		buttonClick(UnUsed);

	}

	public void ClickAll() {
		buttonClick(All);

	}

	public void selectBank(String bnk) {
		selectvalue(bnk, Bank);
	}

	public void enterRefNo(String refno) {
		entervalue(refno, RefNo);

	}

	public void ClickViewBtn() {
		buttonClick(ViewBtn);

	}

	public void ClickClearBtn() {
		buttonClick(ClearBtn);

	}

	public String getChequeNo() {
		return getText(ChequeNo);
	}

	public String getChequeBank() {
		return getText(ChequeBank);
	}

	public String getChequeRealizationDate() {
		return getText(ChequeRealizationDate);
	}

	public String getChequeAmount() {
		return getvalue(ChequeAmount);
	}

	public String getChequePurInvNo() {
		return getvalue(ChequePurInvNo);
	}

	public String getChequeIssueDate() {
		return getText(ChequeIssueDate);
	}

	public String getRefNo() {
		return getText(RefNo);
	}

	public String getEMoneyBank() {
		return getText(EMoneyBank);
	}

	public String getEMoneyAmount() {
		return getvalue(EMoneyAmount);
	}

	public String getEMoneyBalanceAmount() {
		return getvalue(EMoneyBalanceAmount);
	}

	public String getEMoneyPurInvNo() {
		return getText(EMoneyPurInvNo);
	}

	public String getEMoneyPurInvDate() {
		return getText(EMoneyPurInvDate);
	}

	public String getEMoneyAmountadjusted() {
		return getvalue(EMoneyAmountadjusted);
	}

	public int getNumOfRows() {
		List<WebElement> size = driver.findElements(By.xpath("//table[@id='chequeTab']/tbody/tr"));
		return size.size();
	}
	
	public int getNumOfRowsDraft() {
		List<WebElement> size = driver.findElements(By.xpath("//table[@id='draftTab']/tbody/tr"));
		return size.size();
	}

	public String getdatafrommultiplerows(int rnum, int cnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='chequeTab']/tbody/tr[" + rnum + "]/td[" + cnum + "]"));
		highLightElement(driver, element);
		String value = element.getText().trim();
		// System.out.println(value);
		return value;

	}
	public String getdatafrommultiplerowsDraft(int rnum, int cnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='draftTab']/tbody/tr[" + rnum + "]/td[" + cnum + "]"));
		highLightElement(driver, element);
		String value = element.getText().trim();
		// System.out.println(value);
		return value;

	}
	public String getvaluefrommultiplerowsDraft(int rnum, int cnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='draftTab']/tbody/tr[" + rnum + "]/td[" + cnum + "]/input"));
		highLightElement(driver, element);
		String value = getvalue(element);
		// System.out.println(value);
		return value;

	}
}
