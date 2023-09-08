package com.UBQPageObjectLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.UBQGenericLib.WebDriverCommonLib;

/**
 * @author Basanagouda
 *
 */
public class ProductMaster extends WebDriverCommonLib {
	WebDriver driver;

	// ----------------------Constructor----------------------//

	public ProductMaster(WebDriver driver) {
		this.driver = driver;

	}

	// ----------------------UI Elements----------------------//

	// ---SBU---//
	@FindBy(how = How.XPATH, using = "//select[@id='SBU']")
	private WebElement SBU;

	// ---Company---//
	@FindBy(how = How.XPATH, using = "//select[@id='parent_company']")
	private WebElement Company;

	// ---SKU Code---//
	@FindBy(how = How.XPATH, using = "//input[@id='prod_code']")
	private WebElement SkuCode;

	// ---SKU Code---//
	@FindBy(how = How.XPATH, using = "//input[@id='prod_custom_code']")
	private WebElement CustomCode;

	// ---SKUName---//
	@FindBy(how = How.XPATH, using = "//input[@id='prod_name']")
	private WebElement SkuName;

	// ---SKUName---//
	@FindBy(how = How.XPATH, using = "//input[@id='prod_short_name']")
	private WebElement ShortName;

	// ---Peices in box---//
	@FindBy(how = How.XPATH, using = "//input[@id='pkg_level_1_qty']")
	private WebElement PiecesinBox;

	// ---Checkbox---//
	@FindBy(how = How.XPATH, using = "//input[@id='prod_serialized']")
	private WebElement Checkbox;

	// ---Status---//
	@FindBy(how = How.XPATH, using = "//select[@id='statusvalue']")
	private WebElement Status;

	// ---SaveBtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='saveBtn']")
	private WebElement SaveBtn;

	// ---ClearBtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='clearBtn']")
	private WebElement ClearBtn;

	// ---searchTxt---//
	@FindBy(how = How.XPATH, using = "//input[@id='searchTxt']")
	private WebElement searchTxt;

	// ---SearchBtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='searchBtn']")
	private WebElement SearchBtn;

	// ---selectpopupproductcode---//
	@FindBy(how = How.XPATH, using = "(//td/input[@id='prod_code'])[1]")
	private WebElement PopupProductCode;

	// ---Okbtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='ok']")
	private WebElement Okbtn;

	// ---Popupcancelbtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='submit2']")
	private WebElement Popupcancelbtn;

	// -----------------------------Stock entry--------------------------//
	// ---Category---//
	@FindBy(how = How.XPATH, using = "//select[@id='brand']")
	private WebElement Category;

	// ---Category---//
	@FindBy(how = How.XPATH, using = "//input[@id='skuDesc']")
	private WebElement SKU;

	// ---View button---//
	@FindBy(how = How.XPATH, using = "//input[@id='viewBtn']")
	private WebElement Viewbtn;
	
	// ---clear button---//
	@FindBy(how = How.XPATH, using = "//input[@id='delBtn']")
	private WebElement clearbtn1;
	
	// ---MRP---//
	@FindBy(how = How.XPATH, using = "//input[@id='mrp__disp__']")
	private WebElement MRP;
	
	// ---DTRRATE---//
	@FindBy(how = How.XPATH, using = "//input[@id='ratePerDoz__disp__']")
	private WebElement DTRRate;
	
	// ---DLRRATE---//
	@FindBy(how = How.XPATH, using = "//input[@id='salesRate__disp__']")
	private WebElement DLRRate;

	// ---Packdate---//
	@FindBy(how = How.XPATH, using = "//input[@id='packDate']")
	private WebElement Packdate;
	
	//---click serialNo---//
	@FindBy(how = How.XPATH, using = "//a[@id='itemDetails']")
	private WebElement Clickserialbtn;
	
	//---From serialNo---//
	@FindBy(how = How.XPATH, using = "//input[@id='fromSerial']")
	private WebElement FromserialNo;
	
	//---From Toserial---//
	@FindBy(how = How.XPATH, using = "//input[@id='toSerial']")
	private WebElement Toserial;
	
	//---Popupokbtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='loadButton']")
	private WebElement Popupokbtn;
	
	//---Qty---//
	@FindBy(how = How.XPATH, using = "//input[@id='prod_pkt_qty']")
	private WebElement QTY;
	
	
	//---Savebtn3---//
	@FindBy(how = How.XPATH, using = "//input[@id='save_btn3']")
	private WebElement Savebtn3;
	
	
	// ----------Functions----------//
	// ---Select SBU---//
	public void selectSBU(String sbu) {
		selectvalue(sbu, SBU);
	}

	// ---getSbu---//
	public String getSBU() {
		return getvalue(SBU);
	}

	// ---Select Company---//
	public void selectCompany(String comp) {
		selectvalue(comp, Company);
	}

	// ---getSbu---//
	public String getCompany() {
		return getvalue(Company);
	}

	// ---enterSKUcode---//
	public void enterSkuCode(String Skucode) {
		entervalue(Skucode, SkuCode);
	}

	// ---getSkucode---//
	public String getSkucode() {
		return getvalue(SkuCode);
	}

	// ---enterCustomcode---//
	public void enterCustomCode(String Custcode) {
		entervalue(Custcode, CustomCode);
	}

	// ---getCustomcode---//
	public String getCustomCode() {
		return getvalue(CustomCode);
	}

	// ---enterSkuName---//
	public void enterSkuName(String Skuname) {
		entervalue(Skuname, SkuName);
	}

	// ---getSkuName---//
	public String getSkuName() {
		return getvalue(SkuName);
	}

	// ---enterShortName---//
	public void enterShortName(String Shortname) {
		entervalue(Shortname, ShortName);
	}

	// ---getShortName---//
	public String getShortName() {
		return getvalue(ShortName);
	}

	// ---enterSPiecesinBox---//
	public void enterPiecesinbox(String pib) {
		entervalue(pib, PiecesinBox);
	}

	// ---getShortName---//
	public String getPiecesinbox() {
		return getvalue(PiecesinBox);
	}

	// ---Checkserialselected---//
	public void serializedcheckboxselected(String propdtype) {
		buttonClick(Checkbox);

	}

	// ---Select Status---//
	public void selectStatus(String status) {
		selectvalue(status, Status);

	}

	// ---getStatus---//
	public String getStatus() {
		return getvalue(Status);
	}

	// ---savebutton---//
	public void savebtn() {
		buttonClick(SaveBtn);
	}

	// ---clearbutton---//
	public void Clearbtn() {
		buttonClick(ClearBtn);
	}

	// ---entersearchTxt---//
	public void entersearchTxt(String ST) {
		entervalue(ST, searchTxt);
	}

	// ---getsearchText---//
	public String getsearchTxt() {
		return getvalue(searchTxt);
	}

	// ---save button---//
	public void SearchBtn() {
		buttonClick(SearchBtn);
	}

	// ---SelectPopupProductcode---//
	public void SelectPopupProductCode() {
		buttonClick(PopupProductCode);
	}

	// ---getSelectPopupProductcode---//
	public String getSelectPopupProductcode() {
		return getvalue(PopupProductCode);
	}

	// ---click okbtn---//
	public void Clickokbtn() {
		buttonClick(Okbtn);
	}

	// ---Popup cancel btn---//
	public void Popupcancelbtn() {
		buttonClick(Popupcancelbtn);
	}
	// -----------------------------Stock entry--------------------------//
	
	// ---select category---//
	public void selectcategory(String Cat) {
		selectvalue(Cat, Category);

	}

	// ---get select category---//
	public String getselectcategory() {
		return getvalue(Category);
	}

	// ---enterSKU---//
	public void enterSKU(String ST) {
		entervalue(ST, SKU);
	}

	// ---get select category---//
	public String getenterSKU() {
		return getvalue(SKU);
	}

	// ---view button---//
	public void Viewbtn() {
		buttonClick(Viewbtn);
	}
	
	// ---Clear button---//
	public void Clearbtn1() {
		buttonClick(clearbtn1);
	}
	
	// ---enterMRP---//
	public void enterMRP(String mrp) {
		entervalue(mrp, MRP);
	}
	
	// ---get MRP---//
	public String getMRP() {
		return getvalue(MRP);
	}
	
	// ---enterDTRRAte---//
	public void enterDTRRate(String dtr) {
		entervalue(dtr, DTRRate);
	}
	
	// ---get DTRRAte---//
	public String getDTRRAte() {
		return getvalue(DTRRate);
	}
	
	// ---enterDLRRAte---//
	public void enterDLRRate(String dlr) {
		entervalue(dlr, DLRRate);
	}
	
	// ---get DLRRAte---//
	public String getDLRRAte() {
		return getvalue(DLRRate);
	}
	
	// ---enterPackdate---//
	public void enterPackdate(String pd) {
		entervalue(pd, Packdate);
	}
	
	// ---get Packdate---//
	public String getPackdate() {
		return getvalue(Packdate);
	}
	
	// ---Clickserialbtn---//
	public void Clickserialbtn() {
		buttonClick(Clickserialbtn);
	}
	
	// ---enterFromserialNo---//
	public void enterFromserialNo(String Fromsl) {
		entervalue(Fromsl, FromserialNo);
	}
	
	// ---get FromserialNo---//
	public String getFromserialNo() {
		return getvalue(FromserialNo);
	}
	
	// ---enterToserial---//
	public void enterToserial(String Tosl) {
		entervalue(Tosl, Toserial);
	}
	
	// ---get Toserial---//
	public String getToserial() {
		return getvalue(Toserial);
	}
	
	// ---Popupokbtn---//
	public void Popupokbtn() {
		buttonClick(Popupokbtn);
	}
	
	// ---enterqty---//
	public void enterQty(String qty) {
		entervalue(qty, QTY);
	}
	
	// ---get Toqty---//
	public String getQty() {
		return getvalue(QTY);
	}
	
	// ---Savebtn3---//
	public void Clicksavebtn3() {
		buttonClick(Savebtn3);
	}
	

	

}
