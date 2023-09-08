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
public class PurchaseOrder extends WebDriverCommonLib {

	public WebDriver driver;

	// ----------------------Constructor----------------------//
	public PurchaseOrder(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

	// ---For Select SBU---//
	@FindBy(how = How.XPATH, using = "//select[@id='SBU']")
	private WebElement SBU;

	// ---For Select Channel---//
	@FindBy(how = How.XPATH, using = "//select[@id='channel']")
	private WebElement Channel;

	// ---For UOM---//
	@FindBy(how = How.XPATH, using = "//select[@id='uomVal']")
	private WebElement uomVal;

	// ---For Draft Button ---//
	@FindBy(how = How.XPATH, using = "//input[@id='actionBtnSAVE_DRAFT']")
	private WebElement saveOrder;

	// ---For Confirm Button ---//
	@FindBy(how = How.XPATH, using = "//input[@id='actionBtnCONFIRM']")
	private WebElement confirmOrder;

	// ---For Confirm&Send Button ---//
	@FindBy(how = How.XPATH, using = "//input[@id='actionBtnCONFIRM_SAVE']")
	private WebElement confirmSend;

	// ---For clearBtn ---//
	@FindBy(how = How.XPATH, using = "//td[@id='actionableBtnCell']/input[5]")
	private WebElement clearBtn;

	// ---For closeBtn ---//
	@FindBy(how = How.XPATH, using = "//input[@id='closeCurTab']")
	private WebElement closeBtn;

	// ---For ReverseBtn ---//
	@FindBy(how = How.XPATH, using = "//input[@id='actionBtnReverse']")
	private WebElement ReverseBtn;

	// ---For Total AMT ---//
	@FindBy(how = How.XPATH, using = "//label[@id='totAmount']")
	private WebElement TotalAmt;

	// ----------------------Functions----------------------//

	public void selectSBU(String sbu) {
		selectvalue(sbu, SBU);
	}

	public String getSBU() {
		return getselectDrpdwnValue(SBU);
	}

	public void selectchannel(String channel) {
		selectvalue(channel, Channel);
	}

	public String getchannel() {
		return getselectDrpdwnValue(Channel);
	}

	public void selectUOM(String uom) {
		selectvalue(uom, uomVal);
	}

	public void ClickDraftBtn() {
		buttonClick(saveOrder);

	}

	public void ClickonConfirmBtn() {
		buttonClick(confirmOrder);

	}

	public void ClickConfirmSendBtn() {
		buttonClick(confirmSend);

	}

	public void ClickClearBtn() {
		buttonClick(clearBtn);

	}

	public void ClickCloseBtn() {
		buttonClick(closeBtn);

	}

	public void ClickReverseBtn() {
		buttonClick(ReverseBtn);

	}

	public String getTotalAmt() {
		return getText(TotalAmt);

	}

	// not completed
	// For getNumOfProductRows
	public int getNumOfProductRows() {
		List<WebElement> size = driver.findElements(By.xpath("//table[@id='resultTab']/tbody/tr"));
		return size.size();
	}

	// For SelectProductCodeForMultipleRows
	public void SelectProductCodeForMultipleRows(int row) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='resultTab']/tbody/tr[" + row + "]/td[2]/input[14]"));
		highLightElement(driver, element);
		element.sendKeys(Keys.SPACE);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		element.sendKeys(Keys.TAB);
	}

	// For getInputValuesForMultipleRows
	public String getproductcodeForMultipleRows(int row, int col) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='resultTab']/tbody/tr[" + row + "]/td[" + col + "]/input[14]"));
		return getvalue(element);
	}

	// For EnterInputValuesForMultipleRows
	public void EnterInputValuesForMultipleRows(int row, int col, String value) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='resultTab']/tbody/tr[" + row + "]/td[" + col + "]/input"));
		element.clear();
		element.sendKeys(value, Keys.TAB);
	}

	// For EnterSelectValuesForMultipleRows
	public void EnterSelectValuesForMultipleRows(int row, int col, String value) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='resultTab']/tbody/tr[" + row + "]/td[" + col + "]/select"));
		selectvalue(value, element);
	}

	// For getInputValuesForMultipleRows
	public String getInputValuesForMultipleRows(int row, int col) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='resultTab']/tbody/tr[" + row + "]/td[" + col + "]/input"));
		return getvalue(element);
	}

	// For getSelectValuesForMultipleRows
	public String getSelectValuesForMultipleRows(int row, int col) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='resultTab']/tbody/tr[" + row + "]/td[" + col + "]/select"));
		return getselectDrpdwnValue(element);
	}

	public String getStringdatafrommultipleProductrows(int rnum, int cnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='resultTab']/tbody/tr[" + rnum + "]/td[" + cnum + "]/label"));
		highLightElement(driver, element);
		String value = element.getText().trim();
		// System.out.println(value);
		return value;

	}

	public String getStringdatafrommultipleProductrowvalue(int rnum, int cnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='listTable']/tbody/tr[" + rnum + "]/td[" + cnum + "]/input[2]"));
		highLightElement(driver, element);
		String value = getvalue(element);
		// System.out.println(value);
		return value;

	}

}
