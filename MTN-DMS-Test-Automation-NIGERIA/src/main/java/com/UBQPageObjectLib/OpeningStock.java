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
public class OpeningStock extends WebDriverCommonLib {

	public WebDriver driver;

	// ----------------------Constructor----------------------//
	public OpeningStock(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

	// ---For Category ---//
	@FindBy(how = How.XPATH, using = "//select[@id='brand']")
	private WebElement Category;

	// ---For SkuGroup ---//
	@FindBy(how = How.XPATH, using = "//select[@id='skugroup']")
	private WebElement Skugroup;

	// ---For Store ---//
	@FindBy(how = How.XPATH, using = "//select[@id='store']")
	private WebElement Store;

	// ---For SKU ---//
	@FindBy(how = How.XPATH, using = "//input[@id='skuDesc']")
	private WebElement SKU;

	// ---For OPDate ---//
	@FindBy(how = How.XPATH, using = "//input[@id='op_date']")
	private WebElement OPDate;

	// ---For ViewBtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='viewBtn']")
	private WebElement ViewBtn;

	// ---For SaveBtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='save_btn3']")
	private WebElement SaveBtn;

	// ---For Clearbtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='delBtn']")
	private WebElement Clearbtn;

	// ---For ProductCode---//
	@FindBy(how = How.XPATH, using = "//input[@id='prod_code']")
	private WebElement ProductCode;

	// ---For ProductName---//
	@FindBy(how = How.XPATH, using = "//input[@id='productName1']")
	private WebElement ProductName;

	// ---For BatchNo---//
	@FindBy(how = How.XPATH, using = "//input[@id='inputBatchNo']")
	private WebElement BatchNo;

	// ---For RRPAmt---//
	@FindBy(how = How.XPATH, using = "//input[@id='mrp']")
	private WebElement RRPAmt;

	// ---For PurRateCases---//
	@FindBy(how = How.XPATH, using = "//input[@id='ratePerDoz']")
	private WebElement PurRateCases;

	// ---For SalesRateCases---//
	@FindBy(how = How.XPATH, using = "//input[@id='salesRate']")
	private WebElement SalesRateCases;

	// ---For TradeDiscPic---//
	@FindBy(how = How.XPATH, using = "//input[@id='tradeDiscPer']")
	private WebElement TradeDiscPic;

	// ---For ProdQty---//
	@FindBy(how = How.XPATH, using = "//input[@id='prod_pkt_qty']")
	private WebElement ProdQty;

	// ---For PackDate---//
	@FindBy(how = How.XPATH, using = "//input[@id='packDate1']")
	private WebElement PackDate;

	// ---For PackDate---//
	@FindBy(how = How.LINK_TEXT, using = "Upload Opening Stock Details from File")
	private WebElement UploadLink;

	// ---For PackDate---//
	@FindBy(how = How.LINK_TEXT, using = "Click here to go back to Opening Stock Entry")
	private WebElement BackLink;

	// ----------------------Functions----------------------//

	// ---------For selectCategory------------//
	public void selectCategory(String category) {
		selectvalue(category, Category);
	}

	// ---------For getSelectedCategory--------//
	public String getSelectedCategory() {
		return getselectDrpdwnValue(Category);
	}

	// --------For selectSkugroup----------//
	public void selectSkugroup(String skugroup) {
		selectvalue(skugroup, Skugroup);
	}

	public void selectStore(String store) {
		selectvalue(store, Store);
	}

	public String getSelectedStore() {
		return getselectDrpdwnValue(Store);
	}

	public void enterSKU(String sku) {
		entervalue(sku, SKU);
	}

	public String getSKU() {
		return getvalue(SKU);
	}

	public String getProductCode() {
		return getvalue(ProductCode);
	}

	public String getProductName() {
		return getvalue(ProductName);
	}

	public void enterOPDate(String opdate) {
		entervalue(opdate, OPDate);
	}

	// ----------For getOPDate----------------//
	public String getOPDate() {
		return getvalue(OPDate);
	}

	// ---For getNumOfProductRows---//
	public int getNumOfProductRows() {
		List<WebElement> size = driver.findElements(By.xpath("//table[@id='batchesTable']/tbody/tr"));
		return size.size();
	}

	// ---- for getProductCodeAtRow ---- //
	public String getProductCodeAtRow(int row) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + row + "]/td[2]/input"));
		return getvalue(element);
	}

	// ---- for getProductNameAtRow ---- //
	public String getProductNameAtRow(int row) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + row + "]/td[3]/input"));
		return getvalue(element);
	}

	// ---- for getProductMRPAtRow ---- //
	public String getProductMRPAtRow(int row) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + row + "]/td[4]/input"));
		return getvalue(element);
	}

	// ---- for enterPackDateAtRow ---- //
	public void enterPackDateAtRow(int row, String packdate) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + row + "]/td[5]/input"));
		entervalue(packdate, element);
	}
	// ---- for enterPackDateAtRow ---- //
	public void enterProductMRPAtRow(int row, String MRP) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + row + "]/td[4]/input"));
		entervalue(MRP, element);
	}

	// -----------For getPackDateAtRow---------------//

	public String getPackDateAtRow(int row) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + row + "]/td[5]/input"));
		return getvalue(element);
	}

	// ---- for ClickonSerialNoLinkAtRow ---- //
	public void ClickonSerialNoLinkAtRow(int row) {
		WebElement element = driver.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + row + "]/td[6]/a"));
		buttonClick(element);
	}

	// ----------For getQtyAtRow-------------//
	public String getQtyAtRow(int row) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + row + "]/td[7]/input"));
		return getvalue(element);
	}

	// ----------For checkQtyFiledEditableOrNOtAtRow---------------//
	public boolean checkQtyFiledEditableOrNOtAtRow(int row) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + row + "]/td[7]/input"));
		String status = element.getAttribute("readonly");
		if (status.contains("true")) {
			return true;
		} else {
			return false;
		}
	}

	// ------------For enterQtyAtRow---------------//
	public void enterQtyAtRow(int row, String qty) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + row + "]/td[7]/input"));
		entervalue(qty, element);
	}

	// ----------For checkSerialnoFiledEditableOrNOtAtRow---------------//
	public boolean checkSerialnoFiledEditableOrNOtAtRow(int row) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + row + "]/td[6]/input"));
		if (element.isEnabled()) {
			return true;
		} else {
			return false;
		}

	}

	public void enterBatchNo(String batchNo) {
		entervalue(batchNo, BatchNo);
	}

	public void enterRrpAmt(String Amt) {
		entervalue(Amt, RRPAmt);
	}

	public String getRrpAmt() {
		return getvalue(RRPAmt);
	}

	public void enterPurchseRate(String purrate) {
		enterNumvalue(purrate, PurRateCases, driver);
	}

	public String getPurchseRate() {
		return getvalue(PurRateCases);
	}

	public void enterSaleRate(String salerate) {
		highLightElement(driver, SalesRateCases);
		SalesRateCases.clear();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(getAlertmsg());
		acceptAlert();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SalesRateCases.sendKeys(salerate, Keys.TAB);

	}

	public String getSaleRate() {
		return getvalue(SalesRateCases);
	}

	public void dataclearfun() {
		PurRateCases.clear();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SalesRateCases.clear();

	}

	public void enterSaleRate1() {
		SalesRateCases.sendKeys(Keys.TAB);
	}

	public void enterTradeDisc(String discount) {
		entervalue(discount, TradeDiscPic);
	}

	public void enterPackDate(String pckdate) {
		entervalue(pckdate, PackDate);

	}

	public void enterQty(String qty) {
		enterNumvalue(qty, ProdQty, driver);
	}

	public void clickOnSaveBtn() {
		buttonClick(SaveBtn);
	}

	public void clickOnViewBtn() {
		buttonClick(ViewBtn);
	}

	public void clickOnclearBtn() {
		buttonClick(Clearbtn);
	}

}
