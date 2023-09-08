package com.UBQPageObjectLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.UBQGenericLib.WebDriverCommonLib;

public class BankAccounts extends WebDriverCommonLib {
	WebDriver driver;

	// ----------------------Constructor----------------------//
	public BankAccounts(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

	// ---For BankName---//
	@FindBy(how = How.ID, using = "bnk_name")
	private WebElement BankName;

	// ---For Entity Name---//
	@FindBy(how = How.ID, using = "bnk_branch")
	private WebElement BankBranch;

	// ---For User Name---//
	@FindBy(how = How.ID, using = "bnk_account_type")
	private WebElement BankAccountType;

	// ---For Password---//
	@FindBy(how = How.ID, using = "bnk_account_number")
	private WebElement BankAccountNumber;

	// ---For IFSC---//
	@FindBy(how = How.ID, using = "bnk_ifsc_code")
	private WebElement BankAccountIfsc;

	// ---For SaveBtn---//
	@FindBy(how = How.ID, using = "saveBtn")
	private WebElement SaveBtn;

	// ---For ClearBtn---//
	@FindBy(how = How.ID, using = "cancel")
	private WebElement ClearBtn;

	// ---For SearchTxt---//
	@FindBy(how = How.ID, using = "searchTxt")
	private WebElement SearchTxt;

	// ---For SearchBtn---//
	@FindBy(how = How.ID, using = "searchBtn")
	private WebElement SearchBtn;

	// ---For popupokbtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='okBtn']")
	private WebElement PopupOkBtn;

	// ---For popuCancelBtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='cancelBtn']")
	private WebElement PopupCancelBtn;

	// ---For popupokbtn---//
	@FindBy(how = How.XPATH, using = "//select[@id='results_list']/option[1]")
	private WebElement popupselectProduct;

	// ----------------------Basic functions----------------------//

	// ---For enterBankName---//
	public void enterBankName(String bankname) {
		entervalue(bankname, BankName);
	}

	// ---For getBankName---//
	public String getBankName() {
		return getvalue(BankName);
	}

	// ---For enterBankBranch---//
	public void enterBankBranch(String bankbranch) {
		entervalue(bankbranch, BankBranch);
	}

	// ---For getBankBranch---//
	public String getBankBranch() {
		return getvalue(BankBranch);
	}

	// ---For BankAccountType---//
	public void BankAccountType(String bankaccounttype) {
		entervalue(bankaccounttype, BankAccountType);

	}

	// ---For getBankAccountType---//
	public String getBankAccountType() {
		return getvalue(BankAccountType);
	}

	// ---For BankAccountNumber---//
	public void BankAccountNumber(String bankaccountnumber) {
		entervalue(bankaccountnumber, BankAccountNumber);
	}

	// ---For getBankAccountType---//
	public String getBankAccountNumber() {
		return getvalue(BankAccountNumber);
	}

	// ---For BankAccountIfsc---//
	public void BankAccountIfsc(String ifsc) {
		entervalue(ifsc, BankAccountIfsc);
	}

	// ---For getBankAccountIfsc---//
	public String getBankAccountIfsc() {
		return getvalue(BankAccountIfsc);
	}

	// ---For ClickOnSaveBtn---//
	public void ClickOnSaveBtn() {
		buttonClick(SaveBtn);
	}

	// ---For ClickOnClearBtn---//
	public void ClickOnClearBtn() {
		buttonClick(ClearBtn);
	}

	// ---For EnterPassword---//
	public void BankSearchtext(String bankaccounttext) {
		entervalue(bankaccounttext, SearchTxt);
	}

	// ---For ClickOnSearchBtn---//
	public void ClickOnSearchBtn() {
		buttonClick(SearchBtn);
	}

	public void clickOnPopupokBtn() {
		buttonClick(PopupOkBtn);
	}

	public void clickOnPopupCancelBtn() {
		buttonClick(PopupCancelBtn);
	}

	public void PopupProductSelect() {
		buttonClick(popupselectProduct);
	}

}
