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
public class ManualCrNoteUpdate extends WebDriverCommonLib {

	public WebDriver driver;

	// ----------------------Constructor----------------------//
	public ManualCrNoteUpdate(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

	// ---For Input FromDate---//
	@FindBy(how = How.XPATH, using = "//input[@id='fromDate']")
	private WebElement fromDate;

	// ---For Input ToDate---//
	@FindBy(how = How.XPATH, using = "//input[@id='toDate']")
	private WebElement toDate;

	// ---For Select Salesman---//
	@FindBy(how = How.XPATH, using = "//select[@id='salesman']")
	private WebElement salesman;

	// ---For Select Route---//
	@FindBy(how = How.XPATH, using = "//select[@id='beat']")
	private WebElement beat;

	// ---For Select Shop---//
	@FindBy(how = How.XPATH, using = "//select[@id='shop']")
	private WebElement shop;

	// ---For Select Status Button ---//
	// ---For Select UnConsumed Button ---//
	@FindBy(how = How.XPATH, using = "//form[@id='scmMCNBrowserFilterForm']/table/tbody/tr[2]/td/table/tbody/tr[3]/td/table/tbody/tr/td[2]/input[1]")
	private WebElement UnConsumed;

	// ---For Select Consumed Button ---//
	@FindBy(how = How.XPATH, using = "//form[@id='scmMCNBrowserFilterForm']/table/tbody/tr[2]/td/table/tbody/tr[3]/td/table/tbody/tr/td[2]/input[2]")
	private WebElement Consumed;

	// ---For Select Reversed Button ---//
	@FindBy(how = How.XPATH, using = "//form[@id='scmMCNBrowserFilterForm']/table/tbody/tr[2]/td/table/tbody/tr[3]/td/table/tbody/tr/td[2]/input[3]")
	private WebElement Reversed;

	// ---For Select All Button ---//
	@FindBy(how = How.XPATH, using = "//form[@id='scmMCNBrowserFilterForm']/table/tbody/tr[2]/td/table/tbody/tr[3]/td/table/tbody/tr/td[2]/input[4]")
	private WebElement All;

	// ---For View Button ---//
	@FindBy(how = How.XPATH, using = "//input[@id='viewButton']")
	private WebElement viewButton;

	// ---For Clear Button ---//
	@FindBy(how = How.XPATH, using = "//input[@id='clearButton']")
	private WebElement clearButton;

	// ---For selectAllCheckbox ---//
	@FindBy(how = How.XPATH, using = "//input[@id='selectAll']")
	private WebElement selectAllCheckbox;

	// ---For selectsingleCheckbox ---//
	@FindBy(how = How.XPATH, using = "//div[@id='detailsDiv']/table/tbody/tr[1]/td[1]/span/input")
	private WebElement selectsingleCheckbox;

	// ---For MCNnumber ---//
	@FindBy(how = How.XPATH, using = "//div[@id='detailsDiv']/table/tbody/tr[1]/td[2]/span/a")
	private WebElement MCNnumber;

	// ---For MCNDate ---//
	@FindBy(how = How.XPATH, using = "//div[@id='detailsDiv']/table/tbody/tr[1]/td[3]/span")
	private WebElement MCNDate;

	// ---For MCNShop ---//
	@FindBy(how = How.XPATH, using = "//div[@id='detailsDiv']/table/tbody/tr[1]/td[4]/span")
	private WebElement MCNShop;

	// ---For MCNStatus ---//
	@FindBy(how = How.XPATH, using = "//div[@id='detailsDiv']/table/tbody/tr[1]/td[5]/span")
	private WebElement MCNStatus;

	// ---For ReverseSelected ---//
	@FindBy(how = How.XPATH, using = "//form[@id='MCNBrowserListForm']/table/tbody/tr[2]/td/table/tbody/tr/td[2]/input[1]")
	private WebElement ReverseSelected;

	// ---For Preview ---//
	@FindBy(how = How.XPATH, using = "//input[@value='Preview']")
	private WebElement Preview;
	
	// ---For newWindowElement---//
		@FindBy(how = How.TAG_NAME, using = "html")
		private WebElement newWindowElement;

	// ----------------------Functions----------------------//

	public void enterFromDate(String strtdate) {
		entervalue(strtdate, fromDate);
	}

	public String getFromDate() {
		return getvalue(fromDate);
	}

	public void enterToDate(String enddate) {
		entervalue(enddate, toDate);
	}

	public String getToDate() {
		return getvalue(toDate);
	}

	public void selectSalesman(String dsr) {
		selectvalue(dsr, salesman);
	}

	public String getSalesman() {
		return getText(salesman);
	}

	public void selectRoute(String route) {
		selectvalue(route, beat);
	}

	public String getRoute() {
		return getText(beat);
	}

	public void selectShop(String dlr) {
		selectvalue(dlr, shop);
	}
	
	public void selectStatusOption(String status) {
		if(status.contains("UnConsumed")){
		buttonClick(UnConsumed);
		}else if (status.contains("Consumed")) {
			buttonClick(Consumed);
		}else if (status.contains("Reversed")) {
			buttonClick(Reversed);
		}else {
			buttonClick(All);
		}
	}

	

	public void ClickViewBtn() {
		buttonClick(viewButton);

	}

	public void ClickClearBtn() {
		buttonClick(clearButton);

	}

	public void ClickOnSelectAllCheckbox() {
		buttonClick(selectAllCheckbox);
	}

	public void ClickOnSelectSingleCheckbox() {
		buttonClick(selectsingleCheckbox);
	}

	public String getMCNnumber() {
		return getText(MCNnumber);
	}
	
	public void clickonMCNnumber() {
		buttonClick(MCNnumber);
	}

	public String getMCNDate() {
		return getText(MCNDate);
	}

	public String getMCNShop() {
		return getText(MCNShop);
	}

	public String getMCNStatus() {
		return getText(MCNStatus);
	}

	public void ClickOnReverseSelected() {
		buttonClick(ReverseSelected);
	}

	public void ClickOnPreview() {
		buttonClick(Preview);
	}
	
	public void closenewwindow() {
		newWindowElement.sendKeys(Keys.CONTROL);
		newWindowElement.sendKeys("W");
	}

}
