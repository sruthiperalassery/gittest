/**
 * 
 */
package com.UBQPageObjectLib;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.UBQGenericLib.WebDriverCommonLib;

/**
 * @author Basanagouda
 *
 */
public class StockReconciliation extends WebDriverCommonLib {

	public WebDriver driver;

	// ----------------------Constructor----------------------//
	public StockReconciliation(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

	// ---For Store---//
	@FindBy(how = How.XPATH, using = "//select[@id='source_store']")
	private WebElement Store;

	// ---For ProductShortCode ---//
	@FindBy(how = How.XPATH, using = "//input[@id='prod_custom_code']")
	private WebElement ProductShortCode;

	// ---For ProductCode ---//
	@FindBy(how = How.XPATH, using = "//input[@id='prod_code']")
	private WebElement ProductCode;

	// ---For ProductName ---//
	@FindBy(how = How.XPATH, using = "//input[@id='productName']")
	private WebElement ProductName;

	// ---For ProductShortname ---//
	@FindBy(how = How.XPATH, using = "//input[@id='prod_short_name']")
	private WebElement ProductShortname;

	// ---For Casesize ---//
	@FindBy(how = How.XPATH, using = "//input[@id='prodCbbSize']")
	private WebElement Casesize;

	// ---For Select transfer type Radiobtns ---//
	// ---For StockinReconciliation to In-Transit Loss ---//
	@FindBy(how = How.XPATH, using = "//input[@id='actionType0']")
	private WebElement StkrecontoIntransit;

	// ---For StockinReconciliation to Damage ---//
	@FindBy(how = How.XPATH, using = "//input[@id='actionType1']")
	private WebElement StkrecontoDmg;

	// ---For In-TransitLoss to StockinReconciliation ---//
	@FindBy(how = How.XPATH, using = "//input[@id='actionType3']")
	private WebElement IntransittoStkrecon;

	// ---For Damage to StockinReconciliation ---//
	@FindBy(how = How.XPATH, using = "//input[@id='actionType2']")
	private WebElement DmgtoStkrecon;

	// ---For StockinReconciliation to Destruction ---//
	@FindBy(how = How.XPATH, using = "//input[@id='actionType4']")
	private WebElement StkrecontoDest;

	// ---For Viewbtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='viewbtn']")
	private WebElement Viewbtn;

	// ---For Savebtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='save_btn3']")
	private WebElement Savebtn;

	// ---For Clearbtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='cancel4']")
	private WebElement Clearbtn;

	// ----------------------Functions----------------------//

	public void selectStore(String store) {
		selectvalue(store, Store);
	}

	public void enterProductShortCode(String productShortCode) {
		entervalue(productShortCode, ProductShortCode);
		ProductShortCode.sendKeys(Keys.TAB);
	}

	public String getProductCode() {
		return getvalue(ProductCode);
	}

	public String getProductName() {
		return getvalue(ProductName);
	}

	public String getProductShortname() {
		return getvalue(ProductShortname);
	}

	public String getCasesize() {
		return getvalue(Casesize);
	}

	public void clickRadioButton(String type) {
		if (type.contains("Stock in Reconciliation to In-Transit Loss")) {
			buttonClick(StkrecontoIntransit);
		} else if (type.contains("Stock in Reconciliation to Damage")) {
			buttonClick(StkrecontoDmg);
		} else if (type.contains("In-Transit Loss to Stock in Reconciliation ")) {
			buttonClick(IntransittoStkrecon);
		} else if (type.contains("Damage to Stock in Reconciliationansit Loss to Stock in Reconciliation")) {
			buttonClick(DmgtoStkrecon);
		} else if (type.contains("Stock in Reconciliation to Destruction")) {
			buttonClick(StkrecontoDest);
		}
	}

	public void clickViewbtn() {
		buttonClick(Viewbtn);
	}

	public void clickSavebtn() {
		buttonClick(Savebtn);
	}

	public void clickClearbtn() {
		buttonClick(Clearbtn);
	}

}
