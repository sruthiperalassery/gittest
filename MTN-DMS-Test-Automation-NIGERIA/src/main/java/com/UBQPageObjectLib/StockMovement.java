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
public class StockMovement extends WebDriverCommonLib {

	public WebDriver driver;

	// ----------------------Constructor----------------------//
	public StockMovement(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

	// ---For StockMovementDate ---//
	@FindBy(how = How.XPATH, using = "//input[@id='sm_date']")
	private WebElement StockMovementDate;

	// ---For SBU---//
	@FindBy(how = How.XPATH, using = "//select[@id='SBU']")
	private WebElement SBU;

	// ---For FromStore---//
	@FindBy(how = How.XPATH, using = "//select[@id='source_store']")
	private WebElement FromStore;

	// ---For ToStore ---//
	@FindBy(how = How.XPATH, using = "//select[@id='dest_store']")
	private WebElement ToStore;

	
	// ---For SubmitBtn ---//
	@FindBy(how = How.XPATH, using = "//input[@id='save_btn']")
	private WebElement SaveBtn;
	
	 

	//---Ok Btn---//
	@FindBy(how = How.XPATH,using = "//input[@id='ok'])[1]")
	private WebElement OkBtn;
	
	//---ClearBtn---//
	@FindBy(how =How.XPATH,using = "((//input[@id='cancel'])[1]")
	private WebElement CancelBtn;
	
	//---ClearBtn---//
	@FindBy(how =How.XPATH,using = "((//input[@id='cancel'])[1]")
	private WebElement CancelBtn1;
	
	
	//---Transferqty---//
	@FindBy(how =How.XPATH,using = "((//input[@id='qty'])[1]")
	private WebElement PackQty;
	
	
	// ----------------------Functions----------------------//

	public void enterStockMovementDate(String date) {
		entervalue(date, StockMovementDate);
	}
	
	//----------For get stockmovement date------------//
	public String getStockMoveMentDate(){
		return getvalue(StockMovementDate);
	}
	//---Select SBU---//
	public void selectSBU(String sbu) {
		selectvalue(sbu, SBU);
	}
	//---getSbu---//
	public String getSBU() {
		return getvalue(SBU);
	}
	
	//---From Date---//
	public void selectFromStore(String fromstore) {
		selectvalue(fromstore, FromStore);
	}
    
	//---To Store---//
	public void selectToStore(String tostore) {
		selectvalue(tostore, ToStore);
	}
	
	//---getFromstore---//
	public String getFromStore(){
		return getselectDrpdwnValue(FromStore);
	}
	
	//---getTostore---//
	public String getToStore(){
		return getselectDrpdwnValue(ToStore);
	}

    //---Select ProductName---//
	public void selectProductNameAtRow(int rnum) {
		 WebElement ProductName =  driver.findElement(By.xpath("//table[@id='sm_dyna_table']/tbody/tr[" + rnum + "]/td[3]/input[1]"));
		 ProductName.sendKeys(Keys.SPACE, Keys.TAB);
	}
	
	 //---Select ProductName---//
		public String getSelectProductNameAtRow(int rnum) {
			 WebElement ProductName =  driver.findElement(By.xpath("//table[@id='sm_dyna_table']/tbody/tr[" + rnum + "]/td[3]/input[1]"));
			 return getvalue(ProductName);
		}
		
	//---getProductcode---//
	public String getSelectedProductCodeAtRow(int rnum) {
		WebElement ProductCode =  driver.findElement(By.xpath("//table[@id='sm_dyna_table']/tbody/tr[" + rnum + "]/td[2]/input[1]"));
		return getvalue(ProductCode);
	}
	
	
	//---getBatchNo---//
	public String getSelectedBatchNoAtRow(int rnum) {
		WebElement BatchNo =  driver.findElement(By.xpath("//table[@id='sm_dyna_table']/tbody/tr[" + rnum + "]/td[4]/input[1]"));
		return getvalue(BatchNo);
	}
	// ---- for ClickonSerialNoLinkAtRow ---- //
	public void ClickonSelectedSerialNoLinkAtRow(int row) {
		WebElement SerialNo = driver
				.findElement(By.xpath("//table[@id='sm_dyna_table']/tbody/tr[" + row + "]/td[6]/a[1]/img[1]"));
		buttonClick(SerialNo);
	}
	
	//---ghetMrp---//
	public String getSelectedMRPAtRow(int row) {
		WebElement MRP =  driver.findElement(By.xpath("//table[@id='sm_dyna_table']/tbody/tr[" + row + "]/td[7]/select[1]"));
		return getselectDrpdwnValue(MRP);
	}
	// ---- for getProductPackDateAtRow ---- //
	public String getSelectedProductPackDateAtRow(int row) {
		WebElement PackDate = driver
				.findElement(By.xpath("//table[@id='sm_dyna_table']/tbody/tr[" + row + "]/td[8]/input[1]"));
		return getselectDrpdwnValue(PackDate);
	}

	// ---- for getSuggestedQtyAtRow ---- //
	public String getSelectedSuggestedQtyAtRow(int row) {
		WebElement Suggqty = driver
				.findElement(By.xpath("//table[@id='sm_dyna_table']/tbody/tr[" + row + "]/td[11]/input[1]"));
		return getvalue(Suggqty);
	}

	
	// ---- for getRemainingQtyAtRow ---- //
	public String getSelectedRemainingQtyAtRow(int row) {
		WebElement Remqty = driver
				.findElement(By.xpath("//table[@id='sm_dyna_table']/tbody/tr[" + row + "]/td[12]/input[1]"));
		return getvalue(Remqty);
	}

	// ---- for getTransferedQtyAtRow ---- //
	public String getSelectedTransferedQtyAtRow(int row) {
		WebElement Transqty = driver
				.findElement(By.xpath("//table[@id='sm_dyna_table']/tbody/tr[" + row + "]/td[13]/input[1]"));
		return getvalue(Transqty);
	}
	// ---- for getCurrentStockSourceAtRow ---- //
	public String getSelectedSourceAtRow(int row) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='sm_dyna_table']/tbody/tr[" + row + "]/td[14]/input[2]"));
		return getvalue(element);
	}

	// ---- for getCurrentStockDestinationAtRow ---- //
	public String getSelectedDestinationAtRow(int row) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='sm_dyna_table']/tbody/tr[" + row + "]/td[15]/input[2]"));
		return getvalue(element);
	}
	
	public void enterPackQty(String packQty) {
		entervalue(packQty, PackQty);
	}

	
	// ---- for enterNonDescTransferQtyAtRow ---- //
		public void enterNonDescTransferQtyAtRow(int row,String value) {
			WebElement TransferQt = driver
					.findElement(By.xpath("//table[@id='sm_dyna_table']/tbody/tr[" + row + "]/td[16]/input[1]"));
			entervalue(value, TransferQt);
		}
	
	// ---- for getTransferQtyAtRow ---- //
	public String getSelectedTransferQtyAtRow(int row) {
		WebElement TransferQt = driver
				.findElement(By.xpath("//table[@id='sm_dyna_table']/tbody/tr[" + row + "]/td[16]/input[1]"));
		return getvalue(TransferQt);
	}

	
	public String getSelectedUOM(int row) {
		WebElement UOM = driver.findElement(By.xpath("//table[@id='sm_dyna_table']/tbody/tr[" + row + "]/td[16]/input[1]"));
		return getselectDrpdwnValue(UOM);
	}



	public int getNumOfRows() {
		List<WebElement> size = driver.findElements(By.xpath("//table[@id='sm_dyna_table']/tbody/tr"));
		return size.size();

	}
	
    //---OkBtn--//  
	public void clickokBtn() {
		buttonClick(OkBtn);
	}
   
	//---cancelBtn--//  
	public void clearBtn() {
		buttonClick(CancelBtn);
		
	}
	//---cancel1Btn--//  
	public void clearBtn1() {
		buttonClick(CancelBtn1);
		
	}
	
	//---SaveBtn--//  
	public void SaveBtn() {
		buttonClick(SaveBtn);
		
	}
	
	
	
	

}
