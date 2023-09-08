package com.UBQPageObjectLib;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.UBQGenericLib.WebDriverCommonLib;

public class StockEntry extends WebDriverCommonLib{
	
	WebDriver driver;
	
    // ----------------------Constructor----------------------//
	public StockEntry(WebDriver driver) {
		this.driver = driver;
	}
	
	
	 // ----------------------UI Elements----------------------//
	
	// ---Category---//
	@FindBy(how = How.XPATH, using = "//select[@id='brand']")
	private WebElement Category;
	
	//--------------------For SKU field-------------//
	@FindBy(how = How.XPATH, using = "//input[@id='skuDesc']")
	private WebElement SKUcode;
	
	//--------------------For date field-------------//
	@FindBy(how = How.XPATH, using = "//input[@id='stk_entry_date']")
	private WebElement StockentryDate;
	
	//----------------------For view button-----------//
	@FindBy(how = How.XPATH, using = "//input[@id='viewBtn']")
	private WebElement ViewBtn;
	
	//----------------------For clear button-----------//
    @FindBy(how = How.XPATH, using = "//input[@id='delBtn']")
	private WebElement ClearBtn;
    
   //----------------------For save button-----------//
    @FindBy(how = How.XPATH, using = "//input[@id='save_btn3']")
	private WebElement SaveBtn;
    
  //---From serialNo---//
  	@FindBy(how = How.XPATH, using = "//input[@id='fromSerial']")
  	private WebElement FromserialNo;
  	
  	//---From Toserial---//
  	@FindBy(how = How.XPATH, using = "//input[@id='toSerial']")
  	private WebElement Toserial;
  	
  	//---Popupokbtn---//
  	@FindBy(how = How.XPATH, using = "//input[@id='loadButton']")
  	private WebElement Popupokbtn;
  	
  	//---Popupscanbtn---//
  	@FindBy(how = How.XPATH, using = "(//a[@id='itemDetails'])[1]")
  	private WebElement Popupscanbtn;
  	
  	//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[10]/input

    
    //---------------Basic functions------//
    
  	
  	
	// ---select Category--//
	public void selectCategory(String dsa) {
		selectvalue(dsa, Category);

	}

	// ---get selected Category---//
	public String getselectedCategory() {
		return getselectDrpdwnValue(Category);
	}
    //--------------Enter SKU code---------//
    public void enterSku(String Skucode){
    	entervalue(Skucode, SKUcode);
    }
    
    //--------------get SKU code---------//
    public  String getSku(){
    	return getvalue(SKUcode);
    }
    
    //-----------------enter stock entry date------------//
    public void EnterStockEntryDate(String stockentrydate){
    	entervalue(stockentrydate, StockentryDate);
    }
    
    //-----------------get stock entry date------------//
    public String getStockEntryDate(){
    	return getvalue(StockentryDate);
    }
    
    //-------------For click on view button---------------//
    public void clickOnView(){
    	buttonClick(ViewBtn);
    }
    
    //-----------------For click clear button--------------//
    public void clickOnClear(){
    	buttonClick(ClearBtn);
    }
    
    //-----------------For click save btn--------------//
    public void clickOnSave(){
    	buttonClick(SaveBtn);
    }
    
    //----------------------For get number of rows----------//
    public int getNumOfRows() {
		List<WebElement> size = driver.findElements(By.xpath("//table[@id='batchesTable']/tbody/tr"));
		return size.size();
	}
    
    
       //-----------------For getRowWiseProductCode------//
	public String getRowWiseProductCode(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[2]/input"));
		highLightElement(driver, element);
		// System.out.println(value);
		return getvalue(element);

	}
	
    //-----------------For getRowWiseProductName------//
	public String getRowWiseProductName(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[3]/input"));
		highLightElement(driver, element);
		// System.out.println(value);
		return getvalue(element);

	}
	
	public boolean MrpFieldEnabledOrNot(int rnum){
		WebElement element = driver
				.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[5]/input"));
		if(element.isEnabled()){
			return true;
		}
		else{
			return false;
		}
	}
	
	//-------------For enter MRP----------------//
	public void enterRowWiseMRP(int rnum, String value) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[5]/input"));
		entervalue(value, element);
	}
	
	//--------------For enter DTR rate--------------//
	public void enterRowWiseDTRRate(int rnum, String value) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[6]/input"));
		entervalue(value, element);
	}
	
	//---------------For enter DLR rate--------------//
	public void enterRowWiseDLRRate(int rnum, String value) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[7]/input"));
		entervalue(value, element);
	}
	
	//-----------------For enterRowWisePackDate--------------------//
	public void enterRowWisePackDate(int rnum,String value) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[9]/input"));
		entervalue(value, element);
	}
	
	//-----------------------For check serialnos is disabled or not--------------//
	public boolean serialNoIsDisabledOrNot(int rnum){
		WebElement element = driver
				.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[10]/a"));
		if(!element.isEnabled()){
			return false;
		}
		else{
			return true;
		}
	}
	
	//----------------------For enter Qty -------------------//
	public void enterRowWiseQty(int rnum, String value) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[11]/input"));
		entervalue(value, element);
	}
	
	//-----------------------For QtyFieldISEnabledOrNot--------------//
		public boolean QtyFieldISEnabledOrNot(int rnum){
			WebElement element = driver
					.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[" + rnum + "]/td[11]/input"));
			if(element.isEnabled()){
				return true;
			}
			else{
				return false;
			}
		}
		// ---enterFromserialNo---//
		public void enterFromserialNo(String Fromsl) {
			entervalue(Fromsl, FromserialNo);
		}
		
		// ---get FromserialNo---//
		public String getFromserialNo() {
			return getvalue(FromserialNo);
		}
		
		// ---enterToserial---//
		public void enterToserial(String Tosl) {
			entervalue(Tosl, Toserial);
		}
		
		// ---get Toserial---//
		public String getToserial() {
			return getvalue(Toserial);
		}
		
		// ---Popupokbtn---//
		public void Popupokbtn() {
			buttonClick(Popupokbtn);
		}

		
	    //-------------For Popupscanbtnbutton---------------//
	    public void clickPopupscanbtn(){
	    	buttonClick(Popupscanbtn);
	    }
	    
	    
	  //----------------------Click on serial number link---------------//
		public void ClickonSerialNoLinkAtRow(int rnum){
			WebElement element = driver
					.findElement(By.xpath("//table[@id='batchesTable']/tbody/tr[1]/td[10]/a"));
			buttonClick(element);
		}
}
