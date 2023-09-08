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
public class HoldOrReleaseStock extends WebDriverCommonLib {

	public WebDriver driver;

	// ----------------------Constructor----------------------//
	public HoldOrReleaseStock(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

	// ---For Store---//
	@FindBy(how = How.XPATH, using = "//select[@id='source_store']")
	private WebElement Store;

	// ----------------For Date----------------//
	@FindBy(how = How.XPATH, using = "//input[@id='sm_date']")
	private WebElement Date;

	// ---For SBU---//
	@FindBy(how = How.XPATH, using = "//select[@id='SBU']")
	private WebElement SBU;

	// ---For HoldStock ---//
	@FindBy(how = How.XPATH, using = "//input[@id='holdStock']")
	private WebElement HoldStock;

	// ---For ReleaseStock ---//
	@FindBy(how = How.XPATH, using = "//input[@id='releaseStock']")
	private WebElement ReleaseStock;

	// ---For ProductName ---//
	@FindBy(how = How.XPATH, using = "//input[@id='productName']")
	private WebElement ProductName;

	// ---For ProductbatchNo ---//
	@FindBy(how = How.XPATH, using = "//input[@id='batchNoTxt']")
	private WebElement ProductbatchNo;

	// ---For ProductMRP ---//
	@FindBy(how = How.XPATH, using = "//input[@id='prodMrp']")
	private WebElement ProductMRP;

	// ---For ProductQty ---//
	@FindBy(how = How.XPATH, using = "//input[@id='qty1']")
	private WebElement ProductQty;

	// ---For Savebtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='save_btn3']")
	private WebElement Savebtn;

	// ---For Clearbtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='cancel']")
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

	public void selectOption(String option){
		if(option.equalsIgnoreCase("Hold Stock")){
			buttonClick(HoldStock);
		}
		else if (option.equalsIgnoreCase("Release Stock")) {
			buttonClick(ReleaseStock);
		}
			
	}

	public void SelectProductCodeAtRow(int rnum) {
		 WebElement ProductCode =  driver.findElement(By.xpath("//table[@id='stt_dyna_table']/tbody/tr[" + rnum + "]/td[2]/input"));
		 ProductCode.sendKeys(Keys.SPACE, Keys.TAB);
	}

	public int getNumOfRows() {
		List<WebElement> size = driver.findElements(By.xpath("//table[@id='stt_dyna_table']/tbody/tr"));
		return size.size();
	}

	// -----------------For getRowWiseProductCode------//
	public String getRowWiseProductCode(int rnum) {
		WebElement element = driver.findElement(
				By.xpath("//table[@id='stt_dyna_table']/tbody/tr[" + rnum + "]/td[2]/input['custom_code']"));
		highLightElement(driver, element);

		return getvalue(element);

	}

	// -----------------For getRowWiseProductName------//
	public String getRowWiseProductName(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='stt_dyna_table']/tbody/tr[" + rnum + "]/td[3]/input"));
		highLightElement(driver, element);
		return getvalue(element);

	}

	// -----------------For getRowWiseBatchNo------//
	public String getRowWiseBatchNo(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='stt_dyna_table']/tbody/tr[" + rnum + "]/td[4]/input"));
		highLightElement(driver, element);
		return getvalue(element);

	}

	// -----------------For getRowWiseMRP------//
	public String getRowWiseMRP(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='stt_dyna_table']/tbody/tr[" + rnum + "]/td[5]/input"));
		highLightElement(driver, element);
		return getvalue(element);

	}
	
	// -----------------For getRowWiseMRP------//
		public void enterQtyatRow(int rnum,Long value) {
			WebElement element = driver
					.findElement(By.xpath("//table[@id='stt_dyna_table']/tbody/tr[" + rnum + "]/td[7]/input"));
			entervalue(String.valueOf(value), element);

		}

	// -----------------------For check serialnos is enabled or
	// not--------------//
	public boolean serialNoIsEnabledOrNotAtRow(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='stt_dyna_table']/tbody/tr[" + rnum + "]/td[6]/a"));
		if (element.isEnabled()) {
			return true;
		} else {
			return false;
		}
	}
	
	
	//----------------------Click on serial number link---------------//
	public void ClickonSerialNoLinkAtRow(int rnum){
		WebElement element = driver
				.findElement(By.xpath("//table[@id='stt_dyna_table']/tbody/tr[" + rnum + "]/td[6]/a"));
		buttonClick(element);
	}

	// -----------for QtyIsReadOnly----------//
	public boolean checkQtyIsReadOnlyAtRow(int rnum) {
		String state = driver.findElement(By.xpath("//table[@id='stt_dyna_table']/tbody/tr[" + rnum + "]/td[7]/input"))
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
				.findElement(By.xpath("//table[@id='stt_dyna_table']/tbody/tr[" + rnum + "]/td[7]/input"));
		highLightElement(driver, element);
		return getvalue(element);

	}

	// ----------For clickOnSaveBtn---------------//
	public void clickOnSaveBtn() {
		buttonClick(Savebtn);
	}

	// ----------For clickOnclearBtn---------------//
	public void clickOnclearBtn() {
		buttonClick(Clearbtn);
	}

}
