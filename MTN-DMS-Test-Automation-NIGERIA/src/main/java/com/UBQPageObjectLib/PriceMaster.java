package com.UBQPageObjectLib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.UBQGenericLib.WebDriverCommonLib;

/**
 * @author Praneeth
 *
 */
public class PriceMaster extends WebDriverCommonLib {
	WebDriver driver;

	// ----------------------Constructor----------------------//
	public PriceMaster(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

	// ---Entertexttosearch---//
	@FindBy(how = How.XPATH, using = "//input[@id='searchTxt']")
	private WebElement TextSearch;

	// ---Select SBU---//
	@FindBy(how = How.XPATH, using = "//select[@id='SBU']")
	private WebElement SBU;
	
	// ---Select customcode---//
	@FindBy(how = How.XPATH, using = "//input[@id='prod_custom_code']")
	private WebElement customcode;

	
	// ---Select prodcustomcode---//
	@FindBy(how = How.XPATH, using = "//input[@id='prod_code']")
	private WebElement prodcustomcode;
	
	// ---Select productName---//
	@FindBy(how = How.XPATH, using = "//input[@id='prod_name']")
	private WebElement productName;
	
	// ---Select Pcs---//
	@FindBy(how = How.XPATH, using = "//input[@id='prod_cbb_size']")
	private WebElement Pcs;

	
	// ---Select SearchBtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='searchBtn']")
	private WebElement SearchBtn;
	
	// --- ProdType---//
	@FindBy(how = How.XPATH, using = "//input[@id='pr_context_type']")
	private WebElement ProdType;
	
	
	// --- MRP---//
	@FindBy(how = How.XPATH, using = "//input[@id='pr_mrp_pkt__disp__']")
	private WebElement MRP;
	
	
	// --- DTRRate---//
	@FindBy(how = How.XPATH, using = "//input[@id='pr_dtr_rate__disp__']")
	private WebElement DTRRate;
	
	
	// --- DTRRateTax---//
	@FindBy(how = How.XPATH, using = "//input[@id='pr_dtr_rate_tax__disp__']")
	private WebElement DTRRateTax;
	
	// --- DLRRate---//
	@FindBy(how = How.XPATH, using = "//input[@id='pr_dlr_rate__disp__']")
	private WebElement DLRRate;
	
	// --- MRP---//
	@FindBy(how = How.XPATH, using = "//input[@id='pr_dlr_rate_tax__disp__']")
	private WebElement DLRRateTax;
	
	
	// --- PopupProductSelect---//
	@FindBy(how = How.XPATH, using = "//input[@id='prod_code']")
	private WebElement PopupProductSelect;
	
	// --- PopupOktn---//
	@FindBy(how = How.XPATH, using = "//input[@id='ok']")
	private WebElement PopupOktn;
	
	// ----------------------Basic functions----------------------//

	// --------For enterTextSearch-----------//
	public void EnterTexttoSearch(String search) {
		entervalue(search, TextSearch);
	}

	// --------For getTextSearch-----------//
	public String getEnteredsearchedText() {
		return getvalue(TextSearch);
	}

	// ---For Select SBU---//
	public void selectSBU(String sbu) {
		selectvalue(sbu, SBU);

	}

	// ---For getSBU---//
	public String getBeatSBU() {
		return getselectDrpdwnValue(SBU);

	}
	
	// --------For enter custom code-----------//
	public void Entercustomcode(String ccode) {
		entervalue(ccode, customcode);
	}

	// --------For get custom code-----------//
	public String getEnteredcustomcode() {
		return getvalue(customcode);
	}
	
	// --------For enter custom code-----------//
	public void Enterprodcustomcode(String pcode) {
		entervalue(pcode, prodcustomcode);
	}

	// --------For get custom code-----------//
	public String getEnteredprodcustomcode() {
		return getvalue(prodcustomcode);
	}
	
	// --------For enter productName-----------//
	public void EnterproductName(String pname) {
		entervalue(pname, productName);
	}

	// --------For get productName-----------//
	public String getEnteredproductName() {
		return getvalue(productName);
	}

	
	// --------For enter productName-----------//
	public void EnterPcs(String pcs) {
		entervalue(pcs, Pcs);
	}

	// --------For get productName-----------//
	public String getEnteredPcs() {
		return getvalue(Pcs);
	}

	// ---For SearchBtn---//
	public void clickSearchBtn() {
		buttonClick(SearchBtn);

	}
	
	// --------For getProdType-----------//
	public String getProdType() {
		return getvalue(ProdType);
	}
	
	// --------For getMRP-----------//
	public String getMRP() {
		return getvalue(MRP);
	}
	
	// --------For getDTRRatee-----------//
	public String getDTRRate() {
		return getvalue(DTRRate);
	}
	
	// --------For getDTRRateTax-----------//
	public String getDTRRateTax() {
		return getvalue(DTRRateTax);
	}
	
	// --------For getDTRRateTax-----------//
	public String getDLRRate() {
		return getvalue(DLRRate);
	}
	
	// --------For getDTRRateTax-----------//
	public String getDLRRateTax() {
		return getvalue(DLRRateTax);
	}
	
	// ---For SearchBtn---//
	public void clickonPopupProductSelect() {
		buttonClick(PopupProductSelect);

	}
	
	// ---For SearchBtn---//
	public void clickonPopupOktn() {
		buttonClick(PopupOktn);

	}
	
	// ---For getNumOfProductRows---//
	public int getNumOfMainProductRows() {
		List<WebElement> size = driver.findElements(By.xpath("//table[@id='sm_dyna_table']/tbody/tr"));
		return size.size();
	}
}

