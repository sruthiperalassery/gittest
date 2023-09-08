/**
 * 
 */
package com.UBQPageObjectLib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.UBQGenericLib.WebDriverCommonLib;

/**
 * @author Basanagouda
 *
 */
public class StockBrowser extends WebDriverCommonLib {

	public WebDriver driver;

	// ----------------------Constructor----------------------//
	public StockBrowser(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

	// ---For PrintStockPosition---//
	@FindBy(how = How.XPATH, using = "//input[@id='stkPosition']")
	private WebElement PrintStockPosition;

	// ---For PrintStockBook ---//
	@FindBy(how = How.XPATH, using = "//input[@id='stkBook']")
	private WebElement PrintStockBook;

	// ---For PrintClosingStock ---//
	@FindBy(how = How.XPATH, using = "//input[@id='stkClosing']")
	private WebElement PrintClosingStock;

	// ---For PrintInTransitStock ---//
	@FindBy(how = How.XPATH, using = "//input[@id='transitStk']")
	private WebElement PrintInTransitStock;

	// ---For SBU ---//
	@FindBy(how = How.XPATH, using = "//select[@id='SBU']")
	private WebElement SBU;

	// ---For company ---//
	@FindBy(how = How.XPATH, using = "//select[@id='companyCombo']")
	private WebElement Company;

	// ---For Store ---//
	@FindBy(how = How.XPATH, using = "//select[@id='locationRID']")
	private WebElement Store;

	// ---For SkuSelection---//
	@FindBy(how = How.XPATH, using = "//input[@id='skuSelection']")
	private WebElement EnterSku;

	// ---For Selecteditem---//
	@FindBy(how = How.XPATH, using = "//textarea[@id='itemSelected']")
	private WebElement Selecteditem;

	// ---For FromDate---//
	@FindBy(how = How.XPATH, using = "//input[@id='fromDate']")
	private WebElement FromDate;

	// ---For ToDate---//
	@FindBy(how = How.XPATH, using = "//input[@id='toDate']")
	private WebElement ToDate;

	// ---For StockDate---//
	@FindBy(how = How.XPATH, using = "//input[@id='stockDate']")
	private WebElement StockDate;

	// ---For ClosingStockGood---//
	@FindBy(how = How.XPATH, using = "//input[@id='good']")
	private WebElement ClosingStockGood;

	// ---For ClosingStockDamage---//
	@FindBy(how = How.XPATH, using = "//input[@id='damage']")
	private WebElement ClosingStockDamage;

	// ---For ClosingStockdate---//
	@FindBy(how = How.XPATH, using = "//input[@id='stockDate']")
	private WebElement ClosingStockdate;

	// ---For ClosingStockAvailableCheckbox---//
	@FindBy(how = How.XPATH, using = "//input[@id='availableStk']")
	private WebElement ClosingStockAvailableCheckbox;

	// ---For ViewBtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='viewBtn']")
	private WebElement ViewBtn;

	// ---For PreviewBtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='printBtn']")
	private WebElement PreviewBtn;

	// ---For ExcelExportBtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='excelBtn']")
	private WebElement ExcelExportBtn;

	// ---For ClearBtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='clear']")
	private WebElement ClearBtn;

	// ---For PopupOkbtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='ok']")
	private WebElement PopupOkbtn;

	// ---For PopupCancelbtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='cancelBtn']")
	private WebElement PopupCancelbtn;

	// ---For Productdetailsrow---//
	@FindBy(how = How.XPATH, using = "//table[@id='batchesTable']/tbody/tr")
	private WebElement Productdetailsrow;

	// ---For ProductCode---//
	@FindBy(how = How.XPATH, using = "//table[@id='batchesTable']/tbody/tr[1]/td[1]")
	private WebElement ProductCode;

	// ---For Productname---//
	@FindBy(how = How.XPATH, using = "//table[@id='batchesTable']/tbody/tr[1]/td[2]")
	private WebElement Productname;

	// ---For ProductBackNo---//
	@FindBy(how = How.XPATH, using = "//table[@id='batchesTable']/tbody/tr[1]/td[3]")
	private WebElement ProductBatchNo;

	// ---For ProductExpiryDate---//
	@FindBy(how = How.XPATH, using = "//table[@id='batchesTable']/tbody/tr[1]/td[4]")
	private WebElement ProductExpiryDate;

	// ---For ProductPCsInCase---//
	@FindBy(how = How.XPATH, using = "//table[@id='batchesTable']/tbody/tr[1]/td[4]")
	private WebElement ProductPCsInCase;

	// ---For ProductMRP---//
	@FindBy(how = How.XPATH, using = "//table[@id='batchesTable']/tbody/tr[1]/td[5]")
	private WebElement ProductMRP;

	// ---For ProductFreeStock---//
	@FindBy(how = How.XPATH, using = "//table[@id='batchesTable']/tbody/tr[1]/td[7]")
	private WebElement ProductFreeStock;

	// ---For ProductSalableStock---//
	@FindBy(how = How.XPATH, using = "//table[@id='batchesTable']/tbody/tr[1]/td[7]")
	private WebElement ProductSalableStock;

	// ---For ProductHoldStock---//
	@FindBy(how = How.XPATH, using = "//table[@id='batchesTable']/tbody/tr[1]/td[8]")
	private WebElement ProductHoldStock;

	// ---For ProductDamageStock---//
	@FindBy(how = How.XPATH, using = "//table[@id='batchesTable']/tbody/tr[1]/td[9]")
	private WebElement ProductDamageStock;

	// ---For ProductRecons.Stock---//
	@FindBy(how = How.XPATH, using = "//table[@id='batchesTable']/tbody/tr[1]/td[10]")
	private WebElement ProductReconsStock;

	// ---For ProductInTransitLossStock---//
	@FindBy(how = How.XPATH, using = "//table[@id='batchesTable']/tbody/tr[1]/td[11]")
	private WebElement ProductInTransitLossStock;

	// ---For popupOkBtn---//
	//@FindBy(how = How.XPATH, using = "//select[@id='results_list']/option[1]")
//	private WebElement popupselectProduct;

	// ---For newWindowElement---//
	@FindBy(how = How.TAG_NAME, using = "html")
	private WebElement newWindowElement;

	// ---For popupOkBtn---//
	@FindBy(how = How.XPATH, using = "//tr[@id='optionTr']/td[1]")
	private WebElement popupselectProduct;

	// ----------------------Functions----------------------//

	// For ClickonPrintStockBook
	public void ClickonPrintStockBook() {
		buttonClick(PrintStockBook);
	}

	// For ClickonPrintStockPosition
	public void ClickonPrintStockPosition() {
		buttonClick(PrintStockPosition);
	}

	// For ClickonPrintClosingStock
	public void ClickonPrintClosingStock() {
		buttonClick(PrintClosingStock);
	}

	public void ClickonPrintInTransitStock() {
		buttonClick(PrintInTransitStock);
	}

	public void ClickonPreviewBtn() {
		buttonClick(PreviewBtn);
	}

	public void ClickonExcelExportBtn() {
		buttonClick(ExcelExportBtn);
	}

	public void ClickonClearBtn() {
		buttonClick(ClearBtn);
	}

	// For ClickonPrintClosingStockGood
	public void ClickonPrintClosingStockGood() {
		buttonClick(ClosingStockGood);
	}

	// For ClickonPrintClosingStockDamage
	public void ClickonPrintClosingStockDamage() {
		buttonClick(ClosingStockDamage);
	}

	public void selectSBU(String sbu) {
		selectvalue(sbu, SBU);
	}

	public String getSBU() {
		return getselectDrpdwnValue(SBU);
	}

	public void selectCompany(String company) {
		selectvalue(company, Company);
	}

	public String getCompany() {
		return getselectDrpdwnValue(Company);

	}

	public void selectStore(String store) {
		selectvalue(store, Store);
	}

	public String getStore() {
		return getselectDrpdwnValue(Store);
	}

	public void enterProductCode(String enterSku) {
		entervalue(enterSku, EnterSku);
		EnterSku.sendKeys(Keys.SPACE, Keys.TAB);
	}

	//public void PopupProductSelect() {
		// selectvalue(product, popupselectProduct);
	//	buttonClick(popupselectProduct);
	//}

	public void PopupProductSelect() {
		//selectvalue(product, popupselectProduct);
		buttonClick(popupselectProduct);
	}

	public String getSelecteditemname() {
		return getvalue(Selecteditem);
	}

	public void enterFromdate(String fromdate) {
		entervalue(fromdate, FromDate);
	}

	public void enterTodate(String todate) {
		entervalue(todate, ToDate);
	}

	public void enterStockdate(String stockdate) {
		entervalue(stockdate, StockDate);
	}

	public void clickOnViewBtn() {
		buttonClick(ViewBtn);
	}

	public void clickOnPopupokBtn() {
		buttonClick(PopupOkbtn);
	}

	public void clickOnPopupCancelBtn() {
		buttonClick(PopupCancelbtn);
	}

	public void Productdetails(int rownum, int colnum) {
		buttonClick(PopupCancelbtn);
	}

	public String getproductCode() {
		return getText(ProductCode);
	}

	public String getproductname() {
		return getText(Productname);
	}

	public String getProductBatchNo() {
		return getText(ProductBatchNo);
	}

	public String getproductExpiryDate() {
		return getText(ProductExpiryDate);
	}

	public String getproductPcsInCases() {
		return getText(ProductPCsInCase);
	}

	public String getproductMRP() {
		return getText(ProductMRP);
	}

	public String getproductFreeStock() {
		return getText(ProductFreeStock);
	}

	public String getproductSalableStock() {
		return getText(ProductSalableStock);
	}

	public String getproductHoldStock() {
		return getText(ProductHoldStock);
	}

	public String getproductDamageStock() {
		return getText(ProductDamageStock);
	}

	public String getproductRecnStock() {
		return getText(ProductReconsStock);
	}

	public String getproductInTransitStock() {
		return getText(ProductInTransitLossStock);
	}

	public void closenewwindow() {
		newWindowElement.sendKeys(Keys.CONTROL);
		newWindowElement.sendKeys("W");
	}

	public void ClosingStockAvailableCheckboxSelect() {
		checkboxselect(ClosingStockAvailableCheckbox);
	}

	public void ClosingStockAvailableCheckboxDeSelect() {
		checkboxdeselect(ClosingStockAvailableCheckbox);
	}

	public int getNumOfRows() {
		List<WebElement> size = driver.findElements(By.xpath("//table[@id='batchesTable']/tbody/tr"));
		return size.size();
	}

	public int getNumOfcolumns() {
		List<WebElement> size = driver.findElements(By.xpath("//table[@id='batchesTable']/tbody/tr[1]/td"));
		return size.size();
	}

	public int getdatafrommultiplerows(int rnum, int cnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[" + cnum + "]"));
		highLightElement(driver, element);
		int value = Integer.parseInt(element.getText().trim());
		// System.out.println(value);
		return value;

	}

	public String getStringdatafrommultiplerows(int rnum, int cnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[" + cnum + "]"));
		highLightElement(driver, element);
		// System.out.println(value);
		return getText(element);

	}

	public String getStringdatafrommultipleProductrowvalue(int rnum, int cnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[" + cnum + "]/a"));
		highLightElement(driver, element);
		String value = getText(element);
		// System.out.println(value);
		return value;

	}

	// -------------------------- Product search window --------------------------- //

	// ---For getNumOfProductRows---//
	public int getNumOfPopupProductRows() {
		List<WebElement> size = driver.findElements(By.xpath("//table[@id='listTable']/tbody/tr"));
		return size.size();
	}

	// ---For getProductCodeAtRow---//
	public String getPopupProductCodeAtRow(int row) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='listTable']/tbody/tr[" + row + "]/td[1]/input[@id='prod_code']"));
		return getvalue(element);
	}

	// ---For ClickOnProductCodeAtRow---//
	public void ClickOnPopupProductCodeAtRow(int row) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='listTable']/tbody/tr[" + row + "]/td[1]/input[@id='prod_code']"));
		buttonClick(element);
	}

	// ---For getProductNameAtRow---//
	public String getPopupProductNameAtRow(int row) {
		WebElement element = driver.findElement(By.xpath("//table[@id='listTable']/tbody/tr[" + row + "]/td[2]"));
		return getText(element);
	}

	// ---For getProductMRPAtRow---//
	public String getPopupProductMRPAtRow(int row) {
		WebElement element = driver.findElement(By.xpath("//table[@id='listTable']/tbody/tr[" + row + "]/td[3]"));
		return getText(element);
	}

	// ---For getProductStockQtyAtRow---//
	public String getPopupProductStockQtyAtRow(int row) {
		WebElement element = driver.findElement(By.xpath("//table[@id='listTable']/tbody/tr[" + row + "]/td[4]"));
		return getText(element);
	}

	// ---For getProductBatchNoAtRow---//
	public String getPopupProductBatchNoAtRow(int row) {
		WebElement element = driver.findElement(By.xpath("//table[@id='listTable']/tbody/tr[" + row + "]/td[5]"));
		return getText(element);
	}

	
	
	// -------------------------- Serials search window --------------------------- //
	
	// ---For getSerialNoPopuptitle---//
	public String getSerialNoPopuptitle() {
		WebElement element = driver.findElement(By.xpath("//td[@id='desktopPopUpTitle0']"));
		return getText(element);
	}
	
	// ---For ClickOnSerialNumberDetailList---//
	public void ClickOnSerialNumberDetailList() {
		WebElement element = driver.findElement(By.xpath("//a[@id='detailList']"));
		buttonClick(element);
	}
	
	// ---For ClickOnSerialPopupCloseBtn---//
		public void ClickOnSerialPopupCloseBtn() {
			WebElement element = driver.findElement(By.xpath("//div[@id='desktopPopUpDiv0']/table/tbody/tr[1]/td[2]/input"));
			buttonClick(element);                            
		}
	
	
	// ---For getNumOfSerialPopupProductRows---//
		public int getNumOfSerialPopupProductRows() {
			List<WebElement> size = driver.findElements(By.xpath("//table[@id='batchserialsummarypoptable']/tbody/tr"));
			return size.size();
		}
		
		// ---For getSerialPopupBatchNumberAtRow---//
		public String getSerialPopupBatchNumberAtRow(int row) {
			WebElement element = driver.findElement(By.xpath("//table[@id='batchserialsummarypoptable']/tbody/tr["+row+"]/td[1]"));
			return getText(element);
		}
	
		// ---For getSerialPopupFromSerialNoAtRow---//
		public String getSerialPopupFromSerialNoAtRow(int row) {
			WebElement element = driver.findElement(By.xpath("//table[@id='batchserialsummarypoptable']/tbody/tr["+row+"]/td[2]"));
			Actions act = new Actions(driver);
			act.moveToElement(element).build().perform();
			return getText(element);
		}
		
		// ---For getSerialPopupToSerialNoAtRow---//
		public String getSerialPopupToSerialNoAtRow(int row) {
			WebElement element = driver.findElement(By.xpath("//table[@id='batchserialsummarypoptable']/tbody/tr["+row+"]/td[3]"));
			Actions act = new Actions(driver);
			act.moveToElement(element).build().perform();
			return getText(element);
		}
		// ---For getSerialPopupCurrentStateAtRow---//
		public String getSerialPopupCurrentStateAtRow(int row) {
			WebElement element = driver.findElement(By.xpath("//table[@id='batchserialsummarypoptable']/tbody/tr["+row+"]/td[4]"));
			Actions act = new Actions(driver);
			act.moveToElement(element).build().perform();
			return getText(element);
		}
		
		
		// -------------------------- Main product details --------------------------- //
		// ---For getNumOfProductRows---//
		public int getNumOfMainProductRows() {
			List<WebElement> size = driver.findElements(By.xpath("//table[@id='batchesTable']/tbody/tr"));
			return size.size();
		}
		public void clickOnProductCodeAtRow(int rnum) {
			WebElement element = driver.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[1]/a"));

			buttonClick(element);

		}
		public String getProductCodeAtRow(int rnum) {
			WebElement element = driver.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[1]/a"));
			return getText(element);

		}
	
		public String getProductNameAtRow(int rnum) {
			WebElement element = driver.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[2]"));
			return getText(element);

		}
	
		public String getBatchNoAtRow(int rnum) {
			WebElement element = driver.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[3]"));
			return getText(element);

		}
		public String getPcsinCaseBoxAtRow(int rnum) {
			WebElement element = driver.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[4]"));
			return getText(element);

		}
		public String getMRPAtRow(int rnum) {
			WebElement element = driver.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[5]"));
			return getText(element);

		}
		public String getSalableStockAtRow(int rnum) {
			WebElement element = driver.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[7]"));
			return getText(element);
		}
		public String getHoldStockAtRow(int rnum) {
			WebElement element = driver.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[8]"));
			return getText(element);

		}
		public String getDamageStockAtRow(int rnum) {
			WebElement element = driver.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[9]"));
			return getText(element);

		}
		public String getReconsStockAtRow(int rnum) {
			WebElement element = driver.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[10]"));
			return getText(element);


		}
		public String getInTransitLossAtRow(int rnum) {
			WebElement element = driver.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[11]"));
			return getText(element);


		}
		public String getMissingStockAtRow(int rnum) {
			WebElement element = driver.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[12]"));
			return getText(element);


		}
		public String getStolenStockAtRow(int rnum) {
			WebElement element = driver.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[13]"));
			return getText(element);

		}
		public String getBurntStockAtRow(int rnum) {
			WebElement element = driver.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[14]"));
			return getText(element);

		}
		public String getCombiStockAtRow(int rnum) {
			WebElement element = driver.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[15]"));
			return getText(element);

		}
}
