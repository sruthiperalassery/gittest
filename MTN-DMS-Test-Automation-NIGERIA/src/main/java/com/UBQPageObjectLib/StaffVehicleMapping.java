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
public class StaffVehicleMapping extends WebDriverCommonLib {

	WebDriver driver;

	// ----------------------Constructor----------------------//
	public StaffVehicleMapping(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

	// ---For Select SBU ---//
	@FindBy(how = How.XPATH, using = "//select[@id='SBUList']")
	private WebElement sbulist;

	// ---For Select Vehicle ---//
	@FindBy(how = How.XPATH, using = "//select[@id='vehicle']")
	private WebElement selectvehicle;

	// ---For Select SalesMan ---//
	@FindBy(how = How.XPATH, using = "//select[@id='salesMan']")
	private WebElement selectsalesman;

	// ---For Save Btn ---//
	@FindBy(how = How.XPATH, using = "//input[@id='saveButton']")
	private WebElement savebtn;

	// ---For Clear Btn ---//
	@FindBy(how = How.XPATH, using = "//input[@id='clearButton']")
	private WebElement clearbtn;

	// ---For StaffVehicleListLink ---//
	@FindBy(how = How.XPATH, using = "//form[@id='staffVehicleMapForm']/fieldset/table/tbody/tr[4]/td/a")
	private WebElement StaffVehicleListLink;

	// ---For newWindowElement---//
	@FindBy(how = How.TAG_NAME, using = "html")
	private WebElement newWindowElement;

	// ----------------------Functions----------------------//

	// For Select Sbu List
	public void selectsbulist(String sbu) {
		selectvalue(sbu, sbulist);
	}

	// For Select Vehicle
	public void selectvehicle(String vehicleno) {
		selectvalue(vehicleno, selectvehicle);
	}

	// For Select salesman
	public void selectsalesman(String salesman) {
		selectvalue(salesman, selectsalesman);
	}

	// For Click Ok
	public void clickSaveBtn() {
		buttonClick(savebtn);
	}

	// For Click Clear
	public void clickclearBtn() {
		buttonClick(clearbtn);
	}

	// For Click StaffVehicleListLink
	public void clickStaffVehicleListLink() {
		buttonClick(StaffVehicleListLink);
	}

	public int getNumOfRows() {
		List<WebElement> size = driver.findElements(By.xpath("//form[@id='staffVehicleMapPreview']/table/tbody/tr"));
		// System.out.println(size.size());
		return size.size();
	}

	public String getSBUName() {
		WebElement element = driver.findElement(
				By.xpath("//*[@id='staffVehicleMapPreview']/table/tbody/tr[" + getNumOfRows() + "]/td[1]"));
		highLightElement(driver, element);
		return element.getText();
	}

	public String getSalesmanName() {
		WebElement element = driver.findElement(
				By.xpath("//*[@id='staffVehicleMapPreview']/table/tbody/tr[" + getNumOfRows() + "]/td[2]"));
		highLightElement(driver, element);
		return element.getText();
	}

	public String getVehicleNo() {
		WebElement element = driver.findElement(
				By.xpath("//*[@id='staffVehicleMapPreview']/table/tbody/tr[" + getNumOfRows() + "]/td[3]"));
		highLightElement(driver, element);
		return element.getText();
	}

	public String getVehicleName() {
		WebElement element = driver.findElement(
				By.xpath("//*[@id='staffVehicleMapPreview']/table/tbody/tr[" + getNumOfRows() + "]/td[4]"));
		highLightElement(driver, element);
		return element.getText();
	}

	public int getdatafrommultiplerows(int rnum, int cnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[" + cnum + "]"));
		highLightElement(driver, element);
		int value = Integer.parseInt(element.getText().trim());
		// System.out.println(value);
		return value;

	}

	public void closenewwindow() {
		newWindowElement.sendKeys(Keys.CONTROL, "W");
	}

}
