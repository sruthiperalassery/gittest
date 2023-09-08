package com.UBQPageObjectLib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.UBQGenericLib.WebDriverCommonLib;

/**
 * @author Basanagouda
 *
 */
public class HomePage extends WebDriverCommonLib {
	WebDriver driver;

	// ----------------------Constructor----------------------//

	public HomePage(WebDriver driver) {
		this.driver = driver;

	}

	// ----------------------UI Elements----------------------//

	// ---For MenuClick---//
	@FindBy(how = How.XPATH, using = "//div[@id='menuButton']/table/tbody/tr/td[1]")
	private WebElement MenuClick;

	// ---For MenuType---//
	@FindBy(how = How.XPATH, using = "//label[@class='switch']")
	private WebElement MenuType;
		
	// ---For RefreshBtn---//
	@FindBy(how = How.XPATH, using = "//div[@id='menuButton']/table/tbody/tr/td[2]")
	private WebElement RefreshBtn;

	// ---For NavBox---//
	@FindBy(how = How.XPATH, using = "//nav[@id='menu22']/a[1]")
	private WebElement NavBox;

	// ---For SignOut---//
	@FindBy(how = How.XPATH, using = "//a[@id='signOutTag']")
	private WebElement SignOut;

	// --------For SearchBtn---------//
	@FindBy(how = How.XPATH, using = "//div[@id='genericSearchDiv']/table/tbody/tr/td[5]/img")
	private WebElement SearchBtn;

	// ---------For AdvanceSearchBtn----------//
	@FindBy(how = How.XPATH, using = "//div[@id='genericSearchDiv']/table/tbody/tr/td[7]/input")
	private WebElement AdvanceSearchBtn;
	
	//--------For UserName----------------//
	@FindBy(how = How.XPATH, using = "//body[@id='desktopBody']/div[12]/table/tbody/tr/td[2]")
	private WebElement UserName;

	// -------For WorklistClick-------------//
	@FindBy(how = How.XPATH, using = "//body[@id='desktopBody']/div[13]/table/tbody/tr/td[1]/div/img")
	private  WebElement WorklistClick;

	//------------For MenuCloseBtn----------//
	@FindBy(how = How.XPATH, using = "//img[@id='menuClosebtn']")
	private  WebElement MenuCloseBtn;
	
	// ---For popupselectoption---//
	@FindBy(how = How.XPATH, using = "//select[@id='results_list']/option[1]")
	private WebElement popupselectoption;

	// ---For PopupOkbtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='okBtn']")
	private WebElement PopupOkbtn;

	// ---For PopupCancelbtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='cancelBtn']")
	private WebElement PopupCancelbtn;

	// ---For SelectAttribute---//
	@FindBy(how = How.XPATH, using = "//select[@id='searchAttribute']")
	private WebElement SelectAttribute;

	// ---For SearchTextBox---//
	@FindBy(how = How.XPATH, using = "//input[@id='searchTextBox']")
	private WebElement MainSearchTextBox;

	// ---For MainSearchBtn---//
	@FindBy(how = How.XPATH, using = "//div[@id='genericSearchDiv']/table/tbody/tr/td[5]/img")
	private WebElement MainSearchBtn;
	
	// ---For PopupClosebtn---//
	@FindBy(how = How.XPATH, using = "//div[@id='desktopPopUpDiv0']/div/table/tbody/tr/td/input")
	private WebElement PopupClosebtn;

	// ----------------Staff Details PopUp-----//
	// ---For PopupStaffName---//
	@FindBy(how = How.XPATH, using = "//div[@id='staffList']/div/table/tbody/tr/td[2]/span")
	private WebElement PopupStaffName;

	// ---For PopupStaffCode---//
	@FindBy(how = How.XPATH, using = "//div[@id='staffList']/div/table/tbody/tr/td[3]/span")
	private WebElement PopupStaffCode;

	// ---For PopupStaffType---//
	@FindBy(how = How.XPATH, using = "//div[@id='staffList']/div/table/tbody/tr/td[4]/span")
	private WebElement PopupStaffType;

	// ---For PopupStaffMobile---//
	@FindBy(how = How.XPATH, using = "//div[@id='staffList']/div/table/tbody/tr/td[5]/span")
	private WebElement PopupStaffMobile;
	
	// ---For PopupStaffMobile---//
	@FindBy(how = How.XPATH, using = "//div[@id='staffList']/div/table/tbody/tr/td[6]/span")
	private WebElement PopupStaffEmail;

	// ---For Openview---//
	@FindBy(how = How.XPATH, using = "//table[@id='contextTable']/tbody/tr[1]/td[3]/span")
	private WebElement Openview;

	// ---For OpenInNewWindowview---//
	@FindBy(how = How.XPATH, using = "//table[@id='contextTable']/tbody/tr[2]/td[3]/span")
	private WebElement OpenInNewWindowview;

	// ---For divpresent---//
	@FindBy(how = How.XPATH, using = "//div[@id='desktopPopUpDiv0']")
	private WebElement divPresent;

	// Product Search

	// ---For ProductsearchOkbtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='ok']")
	private WebElement Productsearchokbtn;

	// ---For ProductsearchCancelbtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='cancel']")
	private WebElement ProductsearchCancelbtn;

	// ---For ProductListbtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='list']")
	private WebElement ProductListbtn;

	// ---For ProductSelectBrand---//
	@FindBy(how = How.XPATH, using = "//input[@id='BrandTypeText']")
	private WebElement ProductSelectBrand;

	// ---For ProductSelectBrand---//
	@FindBy(how = How.XPATH, using = "//input[@id='styleTypeText']")
	private WebElement ProductSelectStyle;

	// ---For ProductSelectPackSize---//
	@FindBy(how = How.XPATH, using = "//select[@id='Pack']")
	private WebElement ProductSelectPackSize;

	// ---For ProductSelectPackSize---//
	@FindBy(how = How.XPATH, using = "//table[@id='listTable']/tbody/tr")
	private WebElement ProductSelectfirstrow;

	// ---For ProductSelectCode---//
	@FindBy(how = How.XPATH, using = "//table[@id='listTable']/tbody/tr[1]/td[1]/input[4]")
	private WebElement ProductSelectCode;

	// ---For ProductSelectName---//
	@FindBy(how = How.XPATH, using = "//table[@id='listTable']/tbody/tr[1]/td[2]")
	private WebElement ProductSelectName;

	// ---For ProductSelectMRP---//
	@FindBy(how = How.XPATH, using = "//table[@id='listTable']/tbody/tr[1]/td[3]")
	private WebElement ProductSelectMRP;

	// ---For ProductSelectQty---//
	@FindBy(how = How.XPATH, using = "//table[@id='listTable']/tbody/tr[1]/td[4]")
	private WebElement ProductSelectQty;

	// ---For ProductSelectBatchNo---//
	@FindBy(how = How.XPATH, using = "//table[@id='listTable']/tbody/tr[1]/td[5]")
	private WebElement ProductSelectBatchNo;

	// ---For StockMenu---//
	@FindBy(how = How.XPATH, using = "//tr[@id='parentFeatureTR12']/td")
	private WebElement StockMenu;

	// ---For purchaseMenu---//
	@FindBy(how = How.XPATH, using = "//tr[@id='parentFeatureTR10']/td")
	private WebElement PurchaseMenu;

	// ---For CalculationPopupokbtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='ok']")
	private WebElement CalculationPopupokbtn;

	// ----------------------Basic Functions----------------------//

	/*// ---For ClickOnMenuItem---//
	public void ClickOnMenuItem(String FunctionName) {
		WebElement element = driver.findElement(By.xpath("//td[contains(text()," + "'" + FunctionName + "'" + ")]"));
		if (element.isEnabled()) {
			highLightElement(driver, element);
			element.click();
			// Actions act = new Actions(driver);
			// act.moveToElement(element).click().build().perform();
			logger.info("Clicked on " + FunctionName);
		} else {
			Assert.assertTrue(false, "Unable to Click on element");
			logger.error("Unable to Click on element");
		}
	}*/

	// ---For ClickOnSubMenuItem---//
	public void ClickOnSubMenuItem(String FunctionName) {
		WebElement element = driver.findElement(By.xpath("//td[contains(text()," + "'" + FunctionName + "'" + ")]"));
		if (element.isEnabled()) {
			Actions act = new Actions(driver);
			act.moveToElement(element).build().perform();
			highLightElement(driver, element);
			element.click();
			// Actions act = new Actions(driver);
			// act.moveToElement(element).click().build().perform();
			logger.info("Clicked on " + FunctionName);
		} else {
			Assert.assertTrue(false, "Unable to Click on element");
			logger.error("Unable to Click on element");
		}}
    

	// ---For MenuClick---//
	public void ClickOnMenu() {
		buttonClick(MenuClick);
	}
	
	//---For Menutype
	public void ClickonMenutype()
	{
		buttonClick(MenuType);
	}

	// ---For RefreshBtn---//
	public void ClickOnRefresh() {
		buttonClick(RefreshBtn);
	}

	// ---For NavBox---//
	public void ClickOnNavBox() {
		buttonClick(NavBox);
	}

	// ---For SignOut---//
	public void ClickOnSignOut() {
		buttonClick(SignOut);
	}

	// ---For Tab Close function---//
	public void ClickOnTabClose(String modulename) {
		buttonClick(driver
				.findElement(By.xpath("//label[text()=" + "'" + modulename + "'" + "]/following-sibling::label/b")));
	}

	public void PopupSelectOption() {
		buttonClick(popupselectoption);
	}

	public void ClickOnOkBtn() {
		buttonClick(PopupOkbtn);

	}

	public void ClickOnCancelBtn() {
		buttonClick(PopupCancelbtn);

	}

	public void SelectAttribute(String attributeName) {
		selectvalue(attributeName, SelectAttribute);

	}

	public void enterMainSearchtext(String searchtext) {
		entervalue(searchtext, MainSearchTextBox);

	}

	public void ClickOnMainSearchBtn() {
		buttonClick(MainSearchBtn);

	}

	// ---- Staff Details Function ---//
	public String getPopupStaffName() {
		return getText(PopupStaffName);

	}

	public String getPopupStaffCode() {
		return getText(PopupStaffCode);

	}

	public String getPopupStaffType() {
		return getText(PopupStaffType);

	}

	public String getPopupStaffMobile() {
		return getText(PopupStaffMobile);

	}
	
	public String getPopupStaffEmail() {
		return getText(PopupStaffEmail);

	}

	public void ClickOnveiwinNewTabForStaff() {
		buttonClick(PopupStaffName);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		buttonClick(Openview);

	}

	// ----------------Dealer Details PopUp-----//
	public int getNumOfDealerlist() {
		List<WebElement> size = driver.findElements(By.xpath("//div[@id='cpListDiv']/div[2]/div/table/tbody/tr"));
		return size.size();
	}

	// ---- Dealer Details Function ---//
	public String getPopupDealerName(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//div[@id='cpListDiv']/div[2]/div/table/tbody/tr[" + rnum + "]/td[1]/span"));
		highLightElement(driver, element);
		String value = (String) element.getText().trim();
		// System.out.println(value);
		return value;

	}
	
	public String getPopupDealerStatus(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//div[@id='cpListDiv']/div[2]/div/table/tbody/tr[" + rnum + "]/td[9]/span"));
		highLightElement(driver, element);
		return value;
	}


	public String getPopupDealerCode(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//div[@id='cpListDiv']/div[2]/div/table/tbody/tr[" + rnum + "]/td[2]/span"));
		highLightElement(driver, element);
		String value = element.getText().trim();
		// System.out.println(value);
		return value;

	}

	public String getPopupDealerSalesPerson(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//div[@id='cpListDiv']/div[2]/div/table/tbody/tr[" + rnum + "]/td[3]/span"));
		highLightElement(driver, element);
		String value = element.getText().trim();
		// System.out.println(value);
		return value;

	}

	public String getPopupDealerBeat(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//div[@id='cpListDiv']/div[2]/div/table/tbody/tr[" + rnum + "]/td[4]/span"));
		highLightElement(driver, element);
		String value = element.getText().trim();
		// System.out.println(value);
		return value;

	}

	public void dealerview(String dealername) {
		int len = getNumOfDealerlist();

		for (int i = 1; i <= len;) {
			String str = getPopupDealerName(i);
			if (str.equals(dealername)) {
				ClickOnveiwinNewTabForDealer(i);
				break;
			} else {
				i++;
			}

		}
	}

	public String getPopupDealerAddress(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//div[@id='cpListDiv']/div[2]/div/table/tbody/tr[" + rnum + "]/td[5]/span"));
		highLightElement(driver, element);
		String value = element.getText().trim();
		// System.out.println(value);
		return value;

	}

	public String getPopupDealerGSTTinNo(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//div[@id='cpListDiv']/div[2]/div/table/tbody/tr[" + rnum + "]/td[6]/span"));
		highLightElement(driver, element);
		String value = element.getText().trim();
		// System.out.println(value);
		return value;

	}

	public String getPopupDealerMobileNo(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//div[@id='cpListDiv']/div[2]/div/table/tbody/tr[" + rnum + "]/td[7]/span"));
		highLightElement(driver, element);
		String value = element.getText().trim();
		// System.out.println(value);
		return value;

	}

	public String getPopupDealerPhoneNo(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//div[@id='cpListDiv']/div[2]/div/table/tbody/tr[" + rnum + "]/td[8]/span"));
		highLightElement(driver, element);
		String value = element.getText().trim();
		// System.out.println(value);
		return value;

	}

	public void ClickOnveiwinNewTabForDealer(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//div[@id='cpListDiv']/div[2]/div/table/tbody/tr[" + rnum + "]/td[1]/span"));
		buttonClick(element);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		buttonClick(Openview);

	}

	public void ClickOnPopupClose() {
		buttonClick(PopupClosebtn);

	}

	public int getNumOfProductRows() {
		List<WebElement> size = driver.findElements(By.xpath("//table[@id='listTable']/tbody/tr"));
		return size.size();
	}

	public int getintdatafrommultipleProductrows(int rnum, int cnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='listTable']/tbody/tr[" + rnum + "]/td[" + cnum + "]"));
		highLightElement(driver, element);
		int value = Integer.parseInt(element.getText().trim());
		// System.out.println(value);
		return value;

	}

	public int getintdatafrommultipleProductrowvalue(int rnum, int cnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='listTable']/tbody/tr[" + rnum + "]/td[" + cnum + "]/input[4]"));
		highLightElement(driver, element);
		int value = Integer.parseInt(getvalue(element));
		// System.out.println(value);
		return value;

	}

	public String getStringdatafrommultipleProductrows(int rnum, int cnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='listTable']/tbody/tr[" + rnum + "]/td[" + cnum + "]"));
		highLightElement(driver, element);
		String value = element.getText().trim();
		// System.out.println(value);
		return value;

	}

	public String getStringdatafrommultipleProductrowvalue(int rnum, int cnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='listTable']/tbody/tr[" + rnum + "]/td[" + cnum + "]/input[4]"));
		highLightElement(driver, element);
		String value = getvalue(element);
		// System.out.println(value);
		return value;

	}

	// For Product Select
	public void enterBrandname(String brand) {
		entervalue(brand, ProductSelectBrand);

	}

	public void enterProductStyle(String style) {
		entervalue(style, ProductSelectStyle);

	}

	public void selectitem(String item) {
		WebElement element = driver.findElement(By.linkText(item));
		highLightElement(driver, element);
		element.click();
	}

	public void SelectproductPackSize(String size) {
		selectvalue(size, ProductSelectPackSize);

	}

	public void ClickonproductListBtn() {
		buttonClick(ProductListbtn);

	}

	public void ClickProductRow(int row) {
		WebElement element = driver.findElement(By.xpath("//table[@id='listTable']/tbody/tr[" + row + "]"));
		highLightElement(driver, element);
		element.click();

	}

	public void SelectProductsearchokbtn() {
		buttonClick(Productsearchokbtn);

	}

	public void SelectProductsearchCancelbtn() {
		buttonClick(ProductsearchCancelbtn);

	}

	public String getProductSelectCode() {
		return getvalue(ProductSelectCode);

	}

	public String getProductSelectName() {
		return getText(ProductSelectName);

	}

	public String getProductSelectMRP() {
		return getText(ProductSelectMRP);

	}

	public String getProductSelectQty() {
		String val = getText(ProductSelectQty);
		String[] res = val.split("/");
		return res[0];

	}

	public String getProductSelectBatchNo() {
		return getText(ProductSelectBatchNo);

	}

	public void ClickOnStockMenu() {
		buttonClick(StockMenu);

	}

	public void ClickOnPurchaseMenu() {
		buttonClick(PurchaseMenu);

	}

	public void scrollproductselectpopup() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollTop = arguments[1];", driver.findElement(By.id("desktopPopUpScroll0")),
				500);
	}

	public boolean divPresent() {
		if (divPresent.isEnabled()) {
			return true;
		} else {
			return false;
		}

	}

	// ------Replacement part------------//

	// ---- Dealer Details Function ---//
	public int getNumOfReplacementRows() {
		List<WebElement> size = driver.findElements(By.xpath("//table[@id='replTable']/tbody/tr"));
		return size.size();
	}

	public void DeSelectreplacementsalesreturn(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='replTable']/tbody/tr[" + rnum + "]/td[1]/input"));
		checkboxdeselect(element);
	}

	public void Selectreplacementsalesreturn(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='replTable']/tbody/tr[" + rnum + "]/td[1]/input"));
		checkboxselect(element);
	}

	public String getreplacementsalesreturnNo(int rnum, int cnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='replTable']/tbody/tr[" + rnum + "]/td[" + cnum + "]"));
		highLightElement(driver, element);
		String value = element.getText().trim();
		// System.out.println(value);
		return value;

	}

	public String getreplacementsalesreturnProductName(int rnum, int cnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='replTable']/tbody/tr[" + rnum + "]/td[" + cnum + "]"));
		highLightElement(driver, element);
		String value = element.getText().trim();
		return value;

	}

	public String getreplacementsalesreturnProductUOM(int rnum, int cnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='replTable']/tbody/tr[" + rnum + "]/td[" + cnum + "]"));
		highLightElement(driver, element);
		String value = element.getText().trim();
		return value;

	}

	public String getreplacementsalesreturnProductQty(int rnum, int cnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='replTable']/tbody/tr[" + rnum + "]/td[" + cnum + "]"));
		highLightElement(driver, element);
		String value = element.getText().trim();
		return value;
	}

	public String getreplacementsalesreturnProductAvlStock(int rnum, int cnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='replTable']/tbody/tr[" + rnum + "]/td[" + cnum + "]/select"));
		String val = getselectDrpdwnValue(element);
		String[] avlqty = val.split(" ");
		return avlqty[0];
	}

	// ------Replacement part------------//

	// ---- Dealer Details Function ---//
	public int getNumOfCreditnoteRows() {
		List<WebElement> size = driver.findElements(By.xpath("//table[@id='creditTable']/tbody/tr"));
		return size.size();
	}

	public void DeSelectCreditnotesalesreturn(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='creditTable']/tbody/tr[" + rnum + "]/td[1]/input"));
		checkboxdeselect(element);
	}

	public void SelectCreditnotesalesreturn(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='creditTable']/tbody/tr[" + rnum + "]/td[1]/input"));
		checkboxselect(element);
	}

	public String getCreditnotesalesreturnNo(int rnum, int cnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='creditTable']/tbody/tr[" + rnum + "]/td[" + cnum + "]"));
		highLightElement(driver, element);
		String value = element.getText().trim();
		// System.out.println(value);
		return value;

	}

	public String getCreditnotesalesreturnProductName(int rnum, int cnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='creditTable']/tbody/tr[" + rnum + "]/td[" + cnum + "]"));
		highLightElement(driver, element);
		String value = element.getText().trim();
		return value;

	}

	public String getCreditnotesalesreturnProductUOM(int rnum, int cnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='creditTable']/tbody/tr[" + rnum + "]/td[" + cnum + "]"));
		highLightElement(driver, element);
		String value = element.getText().trim();
		return value;

	}

	public String getCreditnotesalesreturnProductQty(int rnum, int cnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='creditTable']/tbody/tr[" + rnum + "]/td[" + cnum + "]"));
		highLightElement(driver, element);
		String value = element.getText().trim();
		return value;
	}

	public String getCreditnotesalesreturnAmt(int rnum, int cnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='creditTable']/tbody/tr[" + rnum + "]/td[" + cnum + "]"));
		String val = getselectDrpdwnValue(element);
		String[] avlqty = val.split(" ");
		return avlqty[0];
	}

	public String getCreditnotesalesreturnType(int rnum, int cnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='creditTable']/tbody/tr[" + rnum + "]/td[" + cnum + "]"));
		String val = getselectDrpdwnValue(element);
		String[] avlqty = val.split(" ");
		return avlqty[0];
	}

	// ---For MenuClick---//
	public void ClickOnCalculationPopupOkBtn() {
		buttonClick(CalculationPopupokbtn);
	}

	public int numberofsalesreturnpresent(String Customername) {
		int result = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(mysqlconnpath, mysqluname, mysqlpassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Statement smt = null;
		try {
			smt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = smt.executeQuery(
					"SELECT COUNT(*) FROM uscm_salesreturn_h JOIN uscm_customer_m ON(cust_rid = srh_cust_rid) where cc_replacement_mode = '0' AND cc_status = '0' AND cust_name ="
							+ "'" + Customername + "'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				try {
					result = rs.getInt(1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// For Replacement
	public int numberofSalesreturnReplacementPresent(String Customername) {
		int result = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(mysqlconnpath, mysqluname, mysqlpassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Statement smt = null;
		try {
			smt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = smt.executeQuery(
					"SELECT COUNT(*) FROM uscm_salesreturn_h JOIN uscm_customer_m ON(cust_rid = srh_cust_rid) JOIN uscm_salesreturn_d ON(srh_rid = srd_srh_rid)JOIN uscm_customer_credit ON(srd_rid = cc_srd_rid) WHERE  cc_replacement_mode = '0' AND cc_status = '0' AND cust_name="
							+ "'" + Customername + "'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				try {
					result = rs.getInt(1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// For CrditNote
	public int numberofSalesreturnCreditNotePresent(String Customername) {
		int result = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(mysqlconnpath, mysqluname, mysqlpassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Statement smt = null;
		try {
			smt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = smt.executeQuery(
					"SELECT COUNT(*) FROM uscm_salesreturn_h JOIN uscm_customer_m ON(cust_rid = srh_cust_rid) JOIN uscm_salesreturn_d ON(srh_rid = srd_srh_rid)JOIN uscm_customer_credit ON(srd_rid = cc_srd_rid) WHERE  cc_replacement_mode = '1' AND cc_status = '0' AND cust_name="
							+ "'" + Customername + "'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				try {
					result = rs.getInt(1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// --------------For serial number pop up fields----------------//

	// -------------------------For consecutive serial
	// numbers---------------------//

	public int getNumOfRowsInCosecutiveSerialNoTable() {
		List<WebElement> size = driver.findElements(By.xpath("//table[@id='consecutiveTab']/tbody/tr"));
		return size.size();
	}

	public void enterFromSerialNumbersAtRow(int rnum, String fromserialno) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='consecutiveTab']/tbody/tr[" + rnum + "]/td[2]/input"));
		entervalue(fromserialno, element);
	}

	public void enterToSerialNumbersAtRow(int rnum, String toserialno) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='consecutiveTab']/tbody/tr[" + rnum + "]/td[4]/input"));
		entervalue(toserialno, element);
		driver.findElement(By.xpath("//table[@id='consecutiveTab']/tbody/tr[" + rnum + "]/td[6]/input")).click();
	}

	public String getProductNameAtRow(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='consecutiveTab']/tbody/tr[" + rnum + "]/td[6]/input"));
		return getvalue(element);
	}

	public String getProductQtyAtRow(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='consecutiveTab']/tbody/tr[" + rnum + "]/td[8]/input"));
		return getvalue(element);
	}

	// -----------for checkProductNameIsReadOnly----------//
	public boolean checkProductNameIsReadOnlyAtRow(int rnum) {
		String state = driver.findElement(By.xpath("//table[@id='consecutiveTab']/tbody/tr[" + rnum + "]/td[6]/input"))
				.getAttribute("readonly");

		// System.out.println(state);

		if (state.contains("true")) {
			return true;
		} else {
			return false;
		}
	}

	// -----------for QtyIsReadOnly----------//
	public boolean checkQtyIsReadOnlyAtRow(int rnum) {
		String state = driver.findElement(By.xpath("//table[@id='consecutiveTab']/tbody/tr[" + rnum + "]/td[8]/input"))
				.getAttribute("readonly");
		if (state.contains("true")) {
			return true;
		} else {
			return false;
		}
	}

	// ------------For clickOnPlusButton------------------//
	public void clickOnPlusButtonAtRow(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='consecutiveTab']/tbody/tr[" + rnum + "]/td[9]/input"));
		buttonClick(element);
	}

	// --------------For non-Consecutive table-------------------//

	public int getNumOfRowsInNonCosecutiveSerialNoTable() {
		List<WebElement> size = driver.findElements(By.xpath("//table[@id='nonConsecutiveTab']/tbody/tr"));
		return size.size();
	}

	public void enterNonCosecutiveSerialNumberAtRow(int rnum, String serialnumber) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='nonConsecutiveTab']/tbody/tr[" + rnum + "]/td[2]/input)"));
		entervalue(serialnumber, element);
	}

	// -----------for checkProductNameIsReadOnly----------//
	public boolean checkNonCosecutiveProductNameFieldIsReadOnlyAtRow(int rnum) {
		String state = driver
				.findElement(By.xpath("//table[@id='nonConsecutiveTab']/tbody/tr[" + rnum + "]/td[3]/input"))
				.getAttribute("readonly");
		if (state.contains("true")) {
			return true;
		} else {
			return false;
		}
	}

	public String getNonCosecutiveProductNameAtRow(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='nonConsecutiveTab']/tbody/tr[" + rnum + "]/td[3]/input)"));
		return getvalue(element);
	}

	public void clickOnNonCosecutivePlusSymbolAtRow(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='nonConsecutiveTab']/tbody/tr[" + rnum + "]/td[4]/input)"));
		buttonClick(element);
	}

	// ----------------------For comma separated serial numbers------------//

	public void enterSerialNumberAtCommaSeperatedField(String serialnumbers) {
		WebElement element = driver.findElement(By.xpath("//textarea[@id='serialNoListCommaSeparated']"));
		entervalue(serialnumbers, element);
	}

	// -----------------------For clickOnOkButton------------------------//

	public void clickSerialNoPopUpOkButton() {
		WebElement element = driver.findElement(By.xpath("//input[@id='loadButton']"));
		buttonClick(element);
	}

	// ---------------For clickOnCancelBtn----------------------//
	public void clickSerialNoPopUpCancelButton() {
		WebElement element = driver.findElement(By.xpath("//input[@id='clearButton']"));
		buttonClick(element);
	}

	// ----------------------For uploading serialNo from file---------------//
	public void enterSerialNoFromFile(String Serialnumber) {
		WebElement element = driver.findElement(By.xpath("//input[@id='file']"));
		entervalue(Serialnumber, element);
	}

	// ----------------------For click on View Uploaded Serial Numbers
	// Link--------------//

	public void clickOnViewUploadedSeriaNumbersLink() {
		WebElement element = driver.findElement(By.xpath("//a[@id='fileSerialNums']"));
		buttonClick(element);
	}
	
	public int getNumOfRetailerCount() {
		List<WebElement> size = driver.findElements(By.xpath("//div[@id='cpListDiv']/div[2]/div/table/tbody/tr"));
		return size.size();
	}
	
	// ---For ClickNextBtn---//
		@FindBy(how = How.XPATH, using = "//input[@id='moveForward']")
		private WebElement ClickNextBtn;
	
		
		public void ClickNextBtn() {
			buttonClick(ClickNextBtn);

		}
		
		public boolean isretailerPopupNextBtnEnabled(){
			
			return isButtonEnabled(ClickNextBtn);
		}
	

	
}
