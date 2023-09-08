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
public class StockTransfer extends WebDriverCommonLib {

	public WebDriver driver;

	// ----------------------Constructor----------------------//
	public StockTransfer(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

	// ---For STdate---//
	@FindBy(how = How.XPATH, using = "//input[@id='sm_date']")
	private WebElement STdate;

	// ---For SBU ---//
	@FindBy(how = How.XPATH, using = "//select[@id='SBU']")
	private WebElement SBU;

	// ---For FromStore ---//
	@FindBy(how = How.XPATH, using = "//select[@id='source_store']")
	private WebElement FromStore;

	// ---For ToEntity ---//
	@FindBy(how = How.XPATH, using = "//select[@id='destEntity']")
	private WebElement ToEntity;

	// ---For DispDate ---//
	@FindBy(how = How.XPATH, using = "//input[@id='dis_date']")
	private WebElement DispDate;

	// ---For LRno---//
	@FindBy(how = How.XPATH, using = "//input[@id='lrno']")
	private WebElement LRno;

	// ---For TransferReason ---//
	@FindBy(how = How.XPATH, using = "//select[@id='transferReason']")
	private WebElement TransferReason;

	// ---For Savebtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='save_btn']")
	private WebElement Savebtn;

	// ---For Clearbtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='cancel']")
	private WebElement Clearbtn;

	// ---For RowCheckbox---//
	@FindBy(how = How.XPATH, using = "//input[@id='custom_code']")
	private WebElement RowCheckbox;

	// ---For RowProductCode---//
	@FindBy(how = How.XPATH, using = "//input[@id='custom_code']")
	private WebElement RowProductCode;

	// ---For RowProductname---//
	@FindBy(how = How.XPATH, using = "//input[@id='productName']")
	private WebElement RowProductname;

	// ---For RowProductBatchNo---//
	@FindBy(how = How.XPATH, using = "//input[@id='batchNoDisp']")
	private WebElement RowProductBatchNo;

	// ---For RowProductMRP---//
	@FindBy(how = How.XPATH, using = "//select[@id='mrp']")
	private WebElement RowProductMRP;

	// ---For RowProductRRP---//
	@FindBy(how = How.XPATH, using = "//input[@id='source_stock']")
	private WebElement RowProductCurrentStock;

	// ---For RowProductRRP---//
	@FindBy(how = How.XPATH, using = "//input[@id='qty']")
	private WebElement RowProductTransferQty;

	// Distributor Details

	// ---For OwnerName---//
	@FindBy(how = How.XPATH, using = "//td[@id='ownerName']")
	private WebElement OwnerName;

	// ---For OwnerAddress---//
	@FindBy(how = How.XPATH, using = "//td[@id='addStr']")
	private WebElement OwnerAddress;

	// ---For CityName---//
	@FindBy(how = How.XPATH, using = "//td[@id='cityName']")
	private WebElement CityName;

	// ---For PhoneNo---//
	@FindBy(how = How.XPATH, using = "//td[@id='phoneNo']")
	private WebElement PhoneNo;

	// ----------------------Functions----------------------//

	public void enterDate(String cmdate) {
		entervalue(cmdate, STdate);

	}

	public String getStockTransferDate() {
		return getvalue(STdate);

	}

	public void enterDispdate(String dispdate) {
		entervalue(dispdate, DispDate);

	}

	public void enterLRNo(String lrno) {
		entervalue(lrno, LRno);

	}

	public void selectSBU(String sbu) {
		selectvalue(sbu, SBU);
	}

	public String getSBU() {
		return getselectDrpdwnValue(SBU);

	}

	public void selectFromStore(String fstore) {
		selectvalue(fstore, FromStore);

	}

	public String getFromStore() {
		return getselectDrpdwnValue(FromStore);

	}

	public void selectToEntity(String tstore) {
		selectvalue(tstore, ToEntity);

	}

	public String getToEntity() {
		return getselectDrpdwnValue(ToEntity);

	}

	public void selectReason(String reason) {
		selectvalue(reason, TransferReason);

	}

	public String getReason() {
		return getselectDrpdwnValue(TransferReason);
	}

	public void SelectProductCode() {
		RowProductCode.sendKeys(Keys.SPACE, Keys.TAB);
	}

	// ---For getNumOfProductRows---//
	public int getNumOfProductRows() {
		List<WebElement> size = driver.findElements(By.xpath("//table[@id='sm_dyna_table']/tbody/tr"));
		return size.size();
	}

	// ---- for searchProductFormPopup ---- //
	public void searchProductFormPopupFromRow(int row) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='sm_dyna_table']/tbody/tr[" + row + "]/td[3]/input"));
		element.sendKeys(Keys.SPACE, Keys.TAB);
	}

	// ---- for getProductCodeAtRow ---- //
	public String getProductCodeAtRow(int row) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='sm_dyna_table']/tbody/tr[" + row + "]/td[2]/input"));
		return getvalue(element);
	}

	// ---- for getProductBatchAtRow ---- //
	public String getProductBatchAtRow(int row) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='sm_dyna_table']/tbody/tr[" + row + "]/td[4]/input"));
		return getvalue(element);
	}

	// ---- for ClickonSerialNoLinkAtRow ---- //
	public void ClickonSerialNoLinkAtRow(int row) {
		WebElement element = driver.findElement(By.xpath("//table[@id='sm_dyna_table']/tbody/tr[" + row + "]/td[5]/a"));
		buttonClick(element);
	}

	// ---- for getProductMRPAtRow ---- //
	public String getProductMRPAtRow(int row) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='sm_dyna_table']/tbody/tr[" + row + "]/td[6]/select"));
		return getselectDrpdwnValue(element);
	}

	// ---- for getCurrentStockQtyAtRow ---- //
	public String getProductCurrentQtyAtRow(int row) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='sm_dyna_table']/tbody/tr[" + row + "]/td[9]/input"));
		return getvalue(element);
	}

	// ---- for getTransferQtyAtRow ---- //
	public String getTransferQtyAtRow(int row) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='sm_dyna_table']/tbody/tr[" + row + "]/td[10]/input"));
		return getvalue(element);
	}

	public String getProductCode() {
		return getvalue(RowProductCode);
	}

	public String getProductname() {
		return getvalue(RowProductname);
	}

	public String getBatchNo() {
		return getvalue(RowProductBatchNo);
	}

	public String getProductMRP() {
		return getvalue(RowProductMRP);
	}

	public String getCurrentStockQty() {
		return getvalue(RowProductCurrentStock);
	}

	public String getTransferStockQty() {
		return getvalue(RowProductTransferQty);

	}

	public void enterTransferStockQty(String transferStockQty) {
		entervalue(transferStockQty, RowProductTransferQty);
		// JavascriptExecutor jse = (JavascriptExecutor) driver;
		// jse.executeScript("arguments[0].value=" + transferStockQty + ";",                                                            
		// RowProductTransferQty);
	}

	public void clickOnSaveBtn() {
		buttonClick(Savebtn);
	}

	public void clickOnclearBtn() {
		buttonClick(Clearbtn);
	}

	public String getOwnerName() {
		return getText(OwnerName);
	}

	public String getOwnerAddress() {
		return getText(OwnerAddress);
	}

	public String getOwnerCity() {
		return getText(CityName);
	}

	public String getOwnerPhone() {
		return getText(PhoneNo);
	}

}
