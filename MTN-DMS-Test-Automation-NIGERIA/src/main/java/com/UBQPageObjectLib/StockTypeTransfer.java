/**
 * 
 */
package com.UBQPageObjectLib;

import java.util.List;

import org.openqa.selenium.By;
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
public class StockTypeTransfer extends WebDriverCommonLib {

	public WebDriver driver;

	// ----------------------Constructor----------------------//
	public StockTypeTransfer(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

	// ---------For Date-----------//
	@FindBy(how = How.XPATH, using = "//*[@id='sm_date']")
	private WebElement Date;

	// ---For SBU---//
	@FindBy(how = How.XPATH, using = "//select[@id='SBU']")
	private WebElement SBU;

	// ---For SourceStore---//
	@FindBy(how = How.XPATH, using = "//select[@id='source_store']")
	private WebElement SourceStore;

	// ---For GoodToDamage ---//
	@FindBy(how = How.XPATH, using = "//input[@id='actionType0']")
	private WebElement GoodToDamage;

	// ---For DamageToDamage ---//
	@FindBy(how = How.XPATH, using = "//input[@id='actionType1']")
	private WebElement DamageToGood;

	// ------------For Reconciliation to Damage-------//
	@FindBy(how = How.XPATH, using = "//*[@id='actionType2']")
	private WebElement ReconciliationToDamage;

	// -------------For Reconciliation to Lose----------//
	@FindBy(how = How.XPATH, using = ".//*[@id='actionType3']")
	private WebElement ReconciliationToLose;

	// ---For ProductCode ---//
	@FindBy(how = How.XPATH, using = "//input[@id='custom_code']")
	private WebElement ProductCode;

	// ---For ProductName ---//
	@FindBy(how = How.XPATH, using = "//input[@id='productName']")
	private WebElement ProductName;

	// ---For ProductBatch---//
	@FindBy(how = How.XPATH, using = "//input[@id='batchNoTxt']")
	private WebElement ProductBatch;

	// ---For ProductMRP---//
	@FindBy(how = How.XPATH, using = "//select[@id='prodMrp']")
	private WebElement ProductMRP;

	// ---For ProductPackDate---//
	@FindBy(how = How.XPATH, using = "//select[@id='prod_pkd']")
	private WebElement ProductPackDate;



	// ---For ProductTransQty---//
	@FindBy(how = How.XPATH, using = "//input[@id='qty1']")
	private WebElement ProductTransQty;

	// ---For Savebtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='save_btn3']")
	private WebElement Savebtn;

	// ---For Clearbtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='cancel4']")
	private WebElement Clearbtn;

	// ----------------------Functions----------------------//

	public void selectSBU(String sbu) {
		selectvalue(sbu, SBU);
	}

	public String getSBU() {
		return getvalue(SBU);
	}

	// -------------For getDate--------//
	public String getDate() {
		return getvalue(Date);
	}

	public void selectStore(String store) {
		selectvalue(store, SourceStore);
	}

	// ---------------For getStore----------------//
	public String getStore() {
		return getselectDrpdwnValue(SourceStore);
	}

	public void selecttransfertype(String transfertype) {
		if (transfertype.equalsIgnoreCase("Good To Damage")) {
			buttonClick(GoodToDamage);
		} else if (transfertype.equalsIgnoreCase("Damage To Good")) {
			buttonClick(DamageToGood);
		} else if (transfertype.equalsIgnoreCase("Reconciliation To Damage")) {
			buttonClick(ReconciliationToDamage);
		} else {
			buttonClick(ReconciliationToLose);
		}
	}

	// ---For getNumOfProductRows---//
	public int getNumOfProductRows() {
		List<WebElement> size = driver.findElements(By.xpath("//table[@id='stt_dyna_table']/tbody/tr"));
		return size.size();
	}

	// ---- for searchProductFormPopupForRow ---- //
	public void searchProductFormPopupForRow(int row) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='stt_dyna_table']/tbody/tr[" + row + "]/td[3]/input"));
		element.sendKeys(Keys.SPACE, Keys.TAB);
	}

	// ---- for getProductCodeAtRow ---- //
	public String getProductCodeAtRow(int row) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='stt_dyna_table']/tbody/tr[" + row + "]/td[2]/input"));
		return getvalue(element);
	}

	// ---- for getProductNameAtRow ---- //
	public String getProductNameAtRow(int row) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='stt_dyna_table']/tbody/tr[" + row + "]/td[3]/input"));
		return getvalue(element);
	}

	// ---- for getProductBatchAtRow ---- //
	public String getProductBatchAtRow(int row) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='stt_dyna_table']/tbody/tr[" + row + "]/td[4]/input"));
		return getvalue(element);
	}

	// ---- for getProductMRPAtRow ---- //
	public String getProductMRPAtRow(int row) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='stt_dyna_table']/tbody/tr[" + row + "]/td[5]/select"));
		return getselectDrpdwnValue(element);
	}

	// ---- for ClickonSerialNoLinkAtRow ---- //
	public void ClickonSerialNoLinkAtRow(int row) {
		WebElement element = driver.findElement(
				By.xpath("//table[@id='stt_dyna_table']/tbody/tr[" + row + "]/td[6]/a[@id='itemDetails']"));
		buttonClick(element);
	}

	// ----------For clickOnPlusSymbolAtRow-------------//
	public void clickOnPlusSymbolAtRow(int row) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='stt_dyna_table']/tbody/tr[" + row + "]/td[6]/input[@id='addBtn']"));
		buttonClick(element);
	}

	public void clickOnSaveBtn() {
		buttonClick(Savebtn);
	}

	public void clickOnclearBtn() {
		buttonClick(Clearbtn);
	}

	

}
