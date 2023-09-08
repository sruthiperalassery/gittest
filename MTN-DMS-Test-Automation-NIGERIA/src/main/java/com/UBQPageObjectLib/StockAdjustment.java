
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
public class StockAdjustment extends WebDriverCommonLib {

	public WebDriver driver;

	// ----------------------Constructor----------------------//
	public StockAdjustment(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

	// ---For Store---//
	@FindBy(how = How.XPATH, using = "//select[@id='locationRID']")
	private WebElement Store;

	// ----------------For Date----------------//
	@FindBy(how = How.XPATH, using = "//input[@id='st_date']")
	private WebElement Date;

	// ---For SBU---//
	@FindBy(how = How.XPATH, using = "//select[@id='SBU']")
	private WebElement SBU;
	
	// ---For Remarks---//
	@FindBy(how = How.XPATH, using = "//textarea[@id='remarks']")
	private WebElement Remarks;

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
		return getselectDrpdwnValue(SBU);
	}

	public void selectStore(String store) {
		selectvalue(store, Store);
	}

	public String getStore() {
		return getselectDrpdwnValue(Store);
	}

	public String getDate() {
		return getvalue(Date);
	}

	public void SelectProductNameAtRow(int rnum) {
		WebElement ProductCode = driver
				.findElement(By.xpath("//table[@id ='batchesTable']/tbody/tr[" + rnum + "]/td[3]/input"));
		ProductCode.sendKeys(Keys.SPACE, Keys.TAB);
	}

	public int getNumOfRows() {
		List<WebElement> size = driver.findElements(By.xpath("//table[@id = 'batchesTable']/tbody/tr"));
		return size.size();
	}

	// -----------------For getRowWiseProductCode------//
	public String getRowWiseProductCode(int rnum) {
		WebElement element = driver.findElement(
				By.xpath("//table[@id ='batchesTable']/tbody/tr[" + rnum + "]/td[2]/input['custom_code']"));
		highLightElement(driver, element);

		return getvalue(element);

	}

	// -----------------For getRowWiseProductName------//
	public String getRowWiseProductName(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id ='batchesTable']/tbody/tr[" + rnum + "]/td[3]/input"));
		highLightElement(driver, element);
		return getvalue(element);

	}

	// -----------------For getRowWiseBatchNo------//
	public String getRowWiseBatchNo(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id ='batchesTable']/tbody/tr[" + rnum + "]/td[4]/input"));
		highLightElement(driver, element);
		return getvalue(element);

	}

	// -----------------For getRowWiseMRP------//
	public String getRowWiseMRP(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id ='batchesTable']/tbody/tr[" + rnum + "]/td[6]/select"));
		highLightElement(driver, element);
		return getvalue(element);

	}

	// -----------------For getRowWiseMRP------//
	public void enterQtyatRow(int rnum, String val) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[9]/input"));
		entervalue(val, element);

	}

	// -----------------------For check serialnos is enabled or
	// not--------------//
	public boolean serialNoIsEnabledOrNotAtRow(int rnum) {
		WebElement element = driver.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[7]/a"));
		if (element.isEnabled()) {
			return true;
		} else {
			return false;
		}
	}

	// ----------------------Click on serial number link---------------//
	public void ClickonSerialNoLinkAtRow(int rnum) {
		WebElement element = driver.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[7]/a"));
		buttonClick(element);
	}

	// -----------------For getRowWiseMRP------//
	public String getRowWiseCureentQty(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id ='batchesTable']/tbody/tr[" + rnum + "]/td[8]/input"));
		highLightElement(driver, element);
		return getvalue(element);

	}

	// -----------for QtyIsReadOnly----------//
	public boolean checkQtyIsReadOnlyAtRow(int rnum) {
		String state = driver.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[9]/input"))
				.getAttribute("readonly");
		if (state.contains("true")) {
			return true;
		} else {
			return false;
		}
	}

	// -----------for CurrQtyIsReadOnly----------//
	public boolean checkCurrQtyIsReadOnlyAtRow(int rnum) {
		String state = driver.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[8]/input"))
				.getAttribute("readonly");
		if (state.contains("true")) {
			return true;
		} else {
			return false;
		}
	}

	// -------------------For getQty-----------------//
	public String getQty(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[9]/input"));
		highLightElement(driver, element);
		return getvalue(element);

	}

	// -----------------For selectReasonatRow------//
	public void selectReasonatRow(int rnum, String value) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[10]/select"));
		selectvalue(value, element);

	}

	// ----------For clickOnSaveBtn---------------//
	public void clickOnSaveBtn() {
		buttonClick(Savebtn);
	}

	// ----------For clickOnclearBtn---------------//
	public void clickOnclearBtn() {
		buttonClick(Clearbtn);
	}
	
	// ---enter Remarks---//
	public void enterRemarks(String remarks) {
		entervalue(remarks, Remarks);
	}

	// ---get Remarks---//
	public String getRemarks() {
		return getvalue(Remarks);
	}
	
	// -----------------For getRowWiseMRP------//


}
