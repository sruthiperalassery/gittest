/**
 * 
 */
package com.UBQPageObjectLib;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import com.UBQGenericLib.WebDriverCommonLib;

/**
 * @author Basanagouda
 *
 */
public class SupplierMaster extends WebDriverCommonLib {

	public WebDriver driver;

	// ----------------------Constructor----------------------//
	public SupplierMaster(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

	// ---For Supplier name---//
	@FindBy(how = How.XPATH, using = "//input[@id='sup_name']")
	private WebElement SupplierName;

	// ---For Supplier Code---//
	@FindBy(how = How.XPATH, using = "//input[@id='sup_code']")
	private WebElement SupplierCode;

	// ---For Supplier Type---//
	@FindBy(how = How.XPATH, using = "//select[@id='sup_type']")
	private WebElement SupplierType;

	// ---For Supplier Company---//
	@FindBy(how = How.XPATH, using = "//select[@id='parent_company']")
	private WebElement SupplierCompany;

	// ---For Address1---//
	@FindBy(how = How.XPATH, using = "//input[@id='supAddr1']")
	private WebElement SupplierAddress1;

	// ---For Address2---//
	@FindBy(how = How.XPATH, using = "//input[@id='supAddr2']")
	private WebElement SupplierAddress2;

	// ---For State---//
	@FindBy(how = How.XPATH, using = "//input[@id='supState']")
	private WebElement SupplierState;

	// ---For City---//
	@FindBy(how = How.XPATH, using = "//input[@id='supCity']")
	private WebElement SupplierCity;

	// ---For Email---//
	@FindBy(how = How.XPATH, using = "//input[@id='supEmailId']")
	private WebElement SupplierEmailId;

	// ---For Telephone---//
	@FindBy(how = How.XPATH, using = "//input[@id='supTelephone']")
	private WebElement SupplierPhoneno;

	// ---For TinNo---//
	@FindBy(how = How.XPATH, using = "//input[@id='supTin']")
	private WebElement SupplierTinNo;

	// ---For CST---//
	@FindBy(how = How.XPATH, using = "//input[@id='supCST']")
	private WebElement SupplierCst;

	// ---For Is Active Check Box--//
	@FindBy(how = How.XPATH, using = "//input[@id='supIsActive']")
	private WebElement SupplierIsActive;

	// ---For Save Button ---//
	@FindBy(how = How.XPATH, using = "//input[@id='saveBtn']")
	private WebElement SaveBtn;

	// ---For Search box ---//
	@FindBy(how = How.XPATH, using = "//input[@id='searchTxt']")
	private WebElement SearchBox;

	// ---For Search box ---//
	@FindBy(how = How.XPATH, using = "//input[@id='searchBtn']")
	private WebElement SearchBtn;

	// ---For Search box ---//
	@FindBys(@FindBy(how = How.XPATH, using = "//select[@id='results_list']/option"))
	private List<WebElement> ResultList;

	// ---For Search box ---//
	@FindBy(how = How.XPATH, using = "//input[@id='okBtn']")
	private WebElement OkBtn;

	// ----------------------Functions----------------------//

	public void enterSupplierName(String supname) {
		entervalue(supname, SupplierName);
	}

	public String getSupplierName() {
		return getvalue(SupplierName);
	}

	public void enterSuppliercode(String supcode) {
		entervalue(supcode, SupplierCode);
	}

	public String getSuppliercode() {
		return getvalue(SupplierCode);
	}

	public void selectSupplierType(String suptype) {
		selectvalue(suptype, SupplierType);
	}

	public String getSupplierType() {
		return getselectDrpdwnValue(SupplierType);
	}

	public void selectSupplierCompany(String supcompany) {
		selectvalue(supcompany, SupplierCompany);
	}

	public String getSupplierCompany() {
		return getselectDrpdwnValue(SupplierCompany);
	}

	public void enterSupplierAddress1(String SupAddress1) {
		entervalue(SupAddress1, SupplierAddress1);
	}

	public String getSupplierAddress1() {
		return getvalue(SupplierAddress1);
	}

	public void enterSupplierAddress2(String SupAddress2) {
		entervalue(SupAddress2, SupplierAddress2);
	}

	public String getSupplierAddress2() {
		return getvalue(SupplierAddress2);
	}

	public void enterSupplierState(String Supstate) {
		entervalue(Supstate, SupplierState);
	}

	public String getSupplierState() {
		return getvalue(SupplierState);
	}

	public void enterSupplierCity(String Supcity) {
		entervalue(Supcity, SupplierCity);
	}

	public String getSupplierCity() {
		return getvalue(SupplierCity);
	}

	public void enterSupplierEmail(String supemailid) {
		entervalue(supemailid, SupplierEmailId);
	}

	public String getSupplierEmail() {
		return getvalue(SupplierEmailId);
	}

	public void enterSupplierPhoneNo(String suphoneno) {
		entervalue(suphoneno, SupplierPhoneno);
	}

	public String getSupplierPhoneNo() {
		return getvalue(SupplierPhoneno);
	}

	public void enterSupplierTinNo(String suptinno) {
		entervalue(suptinno, SupplierTinNo);
	}

	public String getSupplierTinNo() {
		return getvalue(SupplierTinNo);
	}

	public void enterSupplierCSTNo(String supcstno) {
		entervalue(supcstno, SupplierCst);
	}

	public String getSupplierCSTNo() {
		return getvalue(SupplierCst);
	}

	public void IsActivecheckbox() {
		checkboxselect(SupplierIsActive);

	}

	public void ClickOnSavebtn() {
		buttonClick(SaveBtn);
	}

	public void EnterTextToSearch(String text) {
		entervalue(text, SearchBox);

	}

	public void ClickOnSearchbtn() {
		buttonClick(SearchBtn);

	}

}
