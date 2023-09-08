/**
 * 
 */
package com.UBQPageObjectLib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.UBQGenericLib.WebDriverCommonLib;


/**
 * @author Basanagouda
 *
 */
public class StockTransferBrowser extends WebDriverCommonLib {

	public WebDriver driver;

	// ----------------------Constructor----------------------//
	public StockTransferBrowser(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

	// ---For ReciptNo---//
	@FindBy(how = How.XPATH, using = "//input[@id='docNo']")
	private WebElement ReciptNo;
	
	// ---For ReciptNoview---//
		@FindBy(how = How.XPATH, using = "//input[@id='challanNo']")
		private WebElement ReciptNoview;
		
		// ---For FromParty---//
				@FindBy(how = How.XPATH, using = "//form[@id='stock_movement']/table/tbody/tr[1]/td/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]")
				private WebElement FromParty;

	// ---For SBU ---//
	@FindBy(how = How.XPATH, using = "//select[@id='SBU']")
	private WebElement SBU;

	// ---For DestEntity ---//
	@FindBy(how = How.XPATH, using = "//select[@id='destEntity']")
	private WebElement DestEntity;

	// ---For FromDate---//
	@FindBy(how = How.XPATH, using = "//input[@id='fromDate']")
	private WebElement FromDate;

	// ---For ToDate---//
	@FindBy(how = How.XPATH, using = "//input[@id='toDate']")
	private WebElement ToDate;

	// ---For TransTypeTransferred---//
	@FindBy(how = How.XPATH, using = "//input[@id='transTypeTransfer']")
	private WebElement TransTypeTransferred;

	// ---For TransTypeReccpt---//
	@FindBy(how = How.XPATH, using = "//input[@id='transTypeReccpt']")
	private WebElement TransTypeRecipt;

	// ---For StatusConfirmed---//
	@FindBy(how = How.XPATH, using = "//td[@id='radioForStkTransfer']/label[1]/input")
	private WebElement StatusConfirmedforTransferred;

	// ---For StatusCancelled---//
	@FindBy(how = How.XPATH, using = "//td[@id='radioForStkTransfer']/label[2]/input")
	private WebElement StatusCancelledforTransferred;

	// ---For StatusAll---//
	@FindBy(how = How.XPATH, using = "//td[@id='radioForStkTransfer']/label[3]/input")
	private WebElement StatusAllforTransferred;

	// ---For StatusConfirmed---//
	@FindBy(how = How.XPATH, using = "//td[@id='radioForStkRecpt']/label[1]/input")
	private WebElement StatusDraftforReceived;

	// ---For StatusConfirmed---//
	@FindBy(how = How.XPATH, using = "//td[@id='radioForStkRecpt']/label[2]/input")
	private WebElement StatusConfirmedforReceived;

	// ---For StatusCancelled---//
	@FindBy(how = How.XPATH, using = "//td[@id='radioForStkRecpt']/label[3]/input")
	private WebElement StatusCancelledforReceived;

	// ---For StatusAll---//
	@FindBy(how = How.XPATH, using = "//td[@id='radioForStkRecpt']/label[4]/input")
	private WebElement StatusAllforReceived;

	// ---For PreviewButton---//
	@FindBy(how = How.XPATH, using = "//input[@id='previewButton']")
	private WebElement PreviewButton;

	// ---For ViewButton---//
	@FindBy(how = How.XPATH, using = "//input[@id='viewButton']")
	private WebElement ViewButton;

	// ---For NoRecords---//
	@FindBy(how = How.XPATH, using = "//div[@id='StocktransferBrowserDiv']/table/tbody/tr[2]/td/span")
	public WebElement noRecords;

	// ---For popupokbtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='ok']")
	private WebElement popupokbtn;

	// ---For popupcancelbtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='cancel']")
	private WebElement popupcancelbtn;

	// ---For Clearbtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='clearButton']")
	private WebElement Clearbtn;

	// ---For RowCheckbox---//
	@FindBy(how = How.XPATH, using = "//div[@id='StocktransferBrowserDiv']/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[1]/span/input[1]")
	public WebElement RowCheckbox;

	// ---For ReciNo---//
	@FindBy(how = How.XPATH, using = "//div[@id='StocktransferBrowserDiv']/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[1]/span/a")
	private WebElement ReciNo;

	// ---For Recidate---//
	@FindBy(how = How.XPATH, using = "//div[@id='StocktransferBrowserDiv']/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/span")
	private WebElement Recidate;

	// ---For RowProductBatchNo---//
	@FindBy(how = How.XPATH, using = "//div[@id='StocktransferBrowserDiv']/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[3]")
	private WebElement TransferTo;

	// ---For RowProductRRP---//
	@FindBy(how = How.XPATH, using = "//div[@id='StocktransferBrowserDiv']/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[4]")
	private WebElement RecStatus;



	// ----------------------Functions----------------------//

	public void enterReciptNo(String reciptno) {
		entervalue(reciptno, ReciptNo);

	}

	public void selectEntity(String entity) {
		selectvalue(entity, DestEntity);

	}

	public void selectSBU(String sbu) {
		selectvalue(sbu, SBU);

	}

	public void enterFromDate(String fromdate) {
		entervalue(fromdate, FromDate);
	}
	public String getFromDate(){
		return getvalue(FromDate);
	}

	public void enterToDate(String todate) {
		entervalue(todate, ToDate);
	}
	
	public String getToDate(){
		return getvalue(ToDate);
	}

	public void selectTransferMode(String modetype) {
		if (modetype.contains("Transferred")) {
			buttonClick(TransTypeTransferred);
		} else if (modetype.contains("Received")) {
			buttonClick(TransTypeRecipt);
		} else {
			logger.error("Please check Transfer Mode");
			Assert.assertTrue(false);
		}

	}

	public void selectStatusForTransfred(String status) {
		if (status.contains("Confirmed")) {
			buttonClick(StatusConfirmedforTransferred);
		} else if (status.contains("Canceled")) {
			buttonClick(StatusCancelledforTransferred);
		} else if (status.contains("All")) {
			buttonClick(StatusAllforTransferred);
		} else {
			logger.error("Please check Transfer Mode");
			Assert.assertTrue(false);
		}

	}

	public void selectStatusForReceived(String status) {
		if (status.contains("Confirmed")) {
			buttonClick(StatusConfirmedforReceived);
		} else if (status.contains("Canceled")) {
			buttonClick(StatusCancelledforReceived);
		} else if (status.contains("All")) {
			buttonClick(StatusAllforReceived);
		} else if (status.contains("Draft")) {
			buttonClick(StatusDraftforReceived);
		} else {
			logger.error("Please check Transfer Mode");
			Assert.assertTrue(false);
		}

	}

	public void clickOnViewBtn() {
		buttonClick(ViewButton);
	}

	public void clickOnCheckbox() {
		buttonClick(RowCheckbox);
	}

	public void clickOnclearBtn() {
		buttonClick(Clearbtn);
	}

	public void clickOnPreviewBtn() {
		buttonClick(PreviewButton);
	}
	
	public void clickOnReciptno() {
		buttonClick(ReciNo);
	}

	public String getReciptNo() {
		return getText(ReciNo);
	}
	
	public String getReciptNoOnview() {
		return getvalue(ReciptNoview);
	}
	
	public String getFromParty() {
		return getText(FromParty);
	}


	public String getReciptDate() {
		return getText(Recidate);
	}

	public String getTransferTo() {
		return getText(TransferTo);
	}

	public String getStatus() {
		return getText(RecStatus);
	}

	public String getNoRecordStatus() {
		return getText(noRecords);
	}
	
	public int getNumOfProductRows() {
		List<WebElement> size = driver.findElements(By.xpath("//div[@id='StocktransferBrowserDiv']/table/tbody/tr[2]/td/div/table/tbody/tr"));
		return size.size();
	}
	

}
