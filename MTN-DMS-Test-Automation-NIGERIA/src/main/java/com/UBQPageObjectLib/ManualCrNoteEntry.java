/**
 * 
 */
package com.UBQPageObjectLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.UBQGenericLib.WebDriverCommonLib;

/**
 * @author Basanagouda
 *
 */
public class ManualCrNoteEntry extends WebDriverCommonLib {

	public WebDriver driver;

	// ----------------------Constructor----------------------//
	public ManualCrNoteEntry(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

	// ---For Input Date---//
	@FindBy(how = How.XPATH, using = "//input[@id='MCNDate']")
	private WebElement MCNDate;
	
	// ---For MCNnumber---//
		@FindBy(how = How.XPATH, using = "//form[@id='scmMCNEntry']/table/tbody/tr[1]/td/table/tbody/tr[1]/td[3]/span")
		private WebElement MCNnumber;
		
		// ---For MCNnumber---//
				@FindBy(how = How.XPATH, using = "//form[@id='scmMCNEntry']/table/tbody/tr[1]/td/table/tbody/tr[1]/td[4]/span")
				private WebElement MCNStatus;

	// ---For Select Salesman---//
	@FindBy(how = How.XPATH, using = "//select[@id='salesman1']")
	private WebElement Salesman1;

	// ---For Select Route---//
	@FindBy(how = How.XPATH, using = "//select[@id='beat1']")
	private WebElement Beat1;

	// ---For Select Shop---//
	@FindBy(how = How.XPATH, using = "//select[@id='shopSelect']")
	private WebElement ShopSelect;

	// ---For Select Description---//
	@FindBy(how = How.XPATH, using = "//select[@id='reason']")
	private WebElement reason;

	// ---For Input Amount---//
	@FindBy(how = How.XPATH, using = "//input[@id='amount']")
	private WebElement amount;

	// ---For Input Remarks---//
	@FindBy(how = How.XPATH, using = "//input[@id='remarks']")
	private WebElement remarks;

	// ---For Select AllCheckbox---//
	@FindBy(how = How.XPATH, using = "//input[@id='selectAll']")
	private WebElement selectAll;

	// ---For Select RowWiseCheckbox---//
	@FindBy(how = How.XPATH, using = "//input[@id='rowSelection']")
	private WebElement rowSelection;

	// ---For DeleteSelected Button ---//
	@FindBy(how = How.XPATH, using = "//input[@value='Delete Selected']")
	private WebElement DeleteSelected;

	// ---For Confirm Button ---//
	@FindBy(how = How.XPATH, using = "//input[@value='Confirm']")
	private WebElement Confirm;

	// ---For Clear Button ---//
	@FindBy(how = How.XPATH, using = "//input[@id='cancel']")
	private WebElement cancel;

	// ----------------------Functions----------------------//

	public void enterDate(String mcndate) {
		entervalue(mcndate, MCNDate);
	}

	public String getDate() {
		return getvalue(MCNDate);
	}
	
	public String getMCNnumber() {
		return getText(MCNnumber);
	}
	
	public String getMCNStatus() {
		return getText(MCNStatus);
	}

	public void selectSalesman(String salesman) {
		selectvalue(salesman, Salesman1);
	}

	public String getSalesman() {
		return getselectDrpdwnValue(Salesman1);
	}

	public void selectRoute(String beat) {
		selectvalue(beat, Beat1);
	}

	public String getRoute() {
		return getselectDrpdwnValue(Beat1);
	}

	public void selectShop(String shop) {
		selectvalue(shop, ShopSelect);
	}

	public String getShop() {
		return getselectDrpdwnValue(ShopSelect);
	}

	public void selectDescription(String description) {
		selectvalue(description, reason);
	}

	public String getDescription() {
		return getselectDrpdwnValue(reason);
	}

	public void enterAmount(String amt) {
		entervalue(amt, amount);
	}

	public String getAmount() {
		return getvalue(amount);
	}

	public void enterRemarks(String rmks) {
		entervalue(rmks, remarks);
	}

	public String getRemarks() {
		return getvalue(remarks);
	}

	public void selectAllCheckbox(String all) {
		selectvalue(all, selectAll);
	}

	public void selectRowWiseCheckbox(String rowwise) {
		selectvalue(rowwise, rowSelection);
	}

	public void ClickDeleteSelectedBtn() {
		buttonClick(DeleteSelected);

	}

	public void ClickConfirmBtn() {
		buttonClick(Confirm);

	}

	public void ClickClearBtn() {
		buttonClick(cancel);

	}

}
