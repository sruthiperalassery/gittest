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
public class StaffEntry extends WebDriverCommonLib {
	WebDriver driver;

	// ----------------------Constructor----------------------//

	public StaffEntry(WebDriver driver) {
		this.driver = driver;

	}

	// ----------------------UI Elements----------------------//

	// ---Category---//
	@FindBy(how = How.XPATH, using = "//select[@id='sCategory']")
	private WebElement Category;

	// ---Title---//
	@FindBy(how = How.XPATH, using = "//select[@id='custTitle']")
	private WebElement Title;

	// ---Name---//
	@FindBy(how = How.XPATH, using = "//input[@id='profileName']")
	private WebElement Name;

	// ---LastName---//
	@FindBy(how = How.XPATH, using = "//input[@id='profileLastName']")
	private WebElement LastName;

	// ---momoAccountId---//
	@FindBy(how = How.XPATH, using = "//input[@id='momoAccountId']")
	private WebElement momoAccountId;

	// ---momoMSSISDN---//
	@FindBy(how = How.XPATH, using = "//input[@id='momoMSSISDN']")
	private WebElement momoMSSISDN;

	// ---evdAccountId---//
	@FindBy(how = How.XPATH, using = "//input[@id='evdAccountId']")
	private WebElement evdAccountId;

	// ---evdMSSISDN---//
	@FindBy(how = How.XPATH, using = "//input[@id='evdMSSISDN']")
	private WebElement evdMSSISDN;

	// ---dobBtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='BDate']")
	private WebElement dobBtn;

	// ---dobfield---//
	@FindBy(how = How.XPATH, using = "//input[@id='sDOB']")
	private WebElement dobfield;

	// ---dojBtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='JDate']")
	private WebElement dojBtn;
	
	// ---dojfield---//
	@FindBy(how = How.XPATH, using = "//input[@id='sDOJ']")
	private WebElement dojfield;
	
	// ---edaBtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='sEDate']")
	private WebElement edaBtn;
	
	// ---edafield---//
	@FindBy(how = How.XPATH, using = "//input[@id='sEDOA']")
	private WebElement edafield;

	// ---AddressBtn---//
	@FindBy(how = How.XPATH, using = "//a[@id='saveBtn100000007']")
	private WebElement AddressBtn;

	// ---imeinumber---//
	@FindBy(how = How.XPATH, using = "//input[@id='imeinumber']")
	private WebElement IMEInumber;
	
	// ---shopName---//
	@FindBy(how = How.XPATH, using = "//input[@id='shopName']")
	private WebElement shopName;

	// ---streetAdds---//
	@FindBy(how = How.XPATH, using = "//input[@id='streetAdds']")
	private WebElement streetAdds;

	// ---landmark---//
	@FindBy(how = How.XPATH, using = "//input[@id='landmark']")
	private WebElement landmark;

	// ---city---//
	@FindBy(how = How.XPATH, using = "//select[@id='cityCombo']")
	private WebElement cityCombo;

	// ---stateCombo---//
	@FindBy(how = How.XPATH, using = "//select[@id='stateCombo']")
	private WebElement stateCombo;

	// ---pinCode---//
	@FindBy(how = How.XPATH, using = "//input[@id='pinCode']")
	private WebElement pinCode;

	// ---phNo---//
	@FindBy(how = How.XPATH, using = "//input[@id='phNo']")
	private WebElement phNo;

	// ---emailId---//
	@FindBy(how = How.XPATH, using = "//input[@id='emailId']")
	private WebElement emailId;

	// ---okbtn--//
	@FindBy(how = How.XPATH, using = "//input[@id='saveBtn']")
	private WebElement okbtn;

	// ---ArrowBtn--//
	@FindBy(how = How.XPATH, using = "//span[@id='expandDeregDiv']")
	private WebElement ArrowBtn;

	// ---Activated--//
	@FindBy(how = How.XPATH, using = "//input[@value='Activated']")
	private WebElement Activated;
	
	
	// ---Savebtn--//
	@FindBy(how = How.XPATH, using = "//input[@id='actionBtnSUBMIT']")
	private WebElement Savebtn;
	

	// ---Staffcode--//
	@FindBy(how = How.XPATH, using = "(//input[@id='sCode'])[2]")
	private WebElement Staffcode;
	
	// ---AltPhNo---//
	@FindBy(how = How.XPATH, using = "//input[@id='altPhNo']")
	private WebElement AltPhNo;

	// ---FaxNo---//
	@FindBy(how = How.XPATH, using = "//input[@id='fax']")
	private WebElement FaxNo;
	
	
	// ---popupXbutton--//
	@FindBy(how = How.XPATH, using = "//input[@class='visible']")
	private WebElement popupXbutton;
	

	// -----------------------Functions------------------------//

	// ---select category---//
	public void selectcategory(String Cat) {
		selectvalue(Cat, Category);

	}

	// ---get select category---//
	public String getselectcategory() {
		return getselectDrpdwnValue(Category);
	}

	// ---select Title---//
	public void selectTitle() {
		selectDrpdwnRamdomly(Title);
		
	

	}

	// ---get select Title---//
	public String getselectTitle() {
		return getselectDrpdwnValue(Title);
	}

	// ---enterName---//
	public void enterStaffName(String name) {
		entervalue(name, Name);
	}

	// ---get select Name---//
	public String getstaffName() {
		return getvalue(Name);
	}

	// ---enterLastName---//
	public void enterStaffLastName(String Lname) {
		entervalue(Lname, LastName);
	}

	// ---get select LastName---//
	public String getStaffLastName() {
		return getvalue(LastName);
	}

	// ---entermomoAccountId---//
	public void entermomoAccountId(String mai) {
		entervalue(mai, momoAccountId);
	}

	// ---get momoAccountId---//
	public String getmomoAccountId() {
		return getvalue(momoAccountId);
	}

	// ---entermomoMSSISDN---//
	public void entermomoMSSISDN(String mmi) {
		entervalue(mmi, momoMSSISDN);
	}

	// ---get momoMSSISDN---//
	public String getmomoMSSISDN() {
		return getvalue(momoMSSISDN);
	}

	// ---enterevdAccountId---//
	public void enterevdAccountId(String eai) {
		entervalue(eai, evdAccountId);
	}

	// ---get evdAccountId---//
	public String getevdAccountId() {
		return getvalue(evdAccountId);
	}

	// ---enterevdAccountId---//
	public void enterevdMSSISDN(String emi) {
		entervalue(emi, evdMSSISDN);
	}

	// ---get evdAccountId---//
	public String getevdMSSISDN() {
		return getvalue(evdMSSISDN);
	}

	// ---select dob---//
	public void enterDobDatetoSelect(String date) {
		buttonClick(dobBtn);
		selectDateFromCalender(date);
	}

	// ---get dobBtn---//
	public String getDobDatetoSelect() {
		return getvalue(dobBtn);
	}

	// ---select doj---//
	public void enterDojDatetoSelect(String date) {
		buttonClick(dojBtn);
		selectDateFromCalender(date);
	}

	// ---get dojBtn---//
	public String getDojDatetoSelect() {
		return getvalue(dojBtn);
	}

	// ---select edaBtn---//
	public void enteredaDatetoSelect(String date) {
		buttonClick(edaBtn);
		selectDateFromCalender(date);
	}

	// ---get edaBtn---//
	public String getedaDatetoSelect() {
		return getvalue(edaBtn);
	}

	// ---Savebtn---//
	public void ClickSavebtn() {
		buttonClick(Savebtn);
	}
	
	// ---Addressbtn---//
	public void ClickAddressBtn() {
		buttonClick(AddressBtn);
	}


	// ---entershopName---//
	public void entereshopName(String sn) {
		entervalue(sn, shopName);
	}

	// ---get shopName---//
	public String getshopName() {
		return getvalue(shopName);
	}

	// ---enterstreetAdds---//
	public void enterstreetAdds(String sa) {
		entervalue(sa, streetAdds);
	}

	// ---get streetAdds---//
	public String getstreetAdds() {
		return getvalue(streetAdds);
	}

	// ---enterlandmark---//
	public void enterlandmark(String ln) {
		entervalue(ln, landmark);
	}

	// ---get landmark---//
	public String getlandmark() {
		return getvalue(landmark);
	}

	// ---select City---//
	public void selectCity(String city) {
		selectvalue(city, cityCombo);

	}

	// ---get select city---//
	public String getselectcity() {
		return getselectDrpdwnValue(cityCombo);
	}

	// ---select stateCombo---//
	public void selectstate(String state) {
		selectvalue(state, stateCombo);

	}

	// ---get select stateCombo---//
	public String getselectstate() {
		return getselectDrpdwnValue(stateCombo);
	}

	// ---enterpinCode---//
	public void enterpinCode(String pin) {
		entervalue(pin, pinCode);
	}

	// ---get phNo---//
	public String getpinCode() {
		return getvalue(pinCode);
	}

	// ---enterphNo---//
	public void enterphNo(String phNoo) {
		entervalue(phNoo, phNo);
	}

	// ---get pinCode---//
	public String getphNo() {
		return getvalue(phNo);
	}

	// ---enteremailId---//
	public void enteremailId(String EmailId) {
		entervalue(EmailId, emailId);
	}

	// ---get emailId---//
	public String getemailId() {
		return getvalue(emailId);
	}

	// ---okbtn---//
	public void Clickokbtn() {
		buttonClick(okbtn);
	}

	// ---ArrowBtn---//
	public void ClickArrowBtn() {
		buttonClick(ArrowBtn);
	}

	// ---ArrowBtn---//
	public void ClickActivatedbtn() {
		//selectRadioButton(Activated);
		buttonClick(Activated);
		
	}
	
	// ---entermomoAccountId---//
	public void enterIMEInumber(String imei) {
		entervalue(imei, IMEInumber);
	}

	// ---get momoAccountId---//
	public String getIMEInumber() {
		return getvalue(IMEInumber);
	}
	
	// ---get dobfield---//
	public String getentereddobfield() {
		return getvalue(dobfield);
	}
	// ---get dojfield---//
	public String getentereddojfield() {
		return getvalue(dojfield);
	}
	// ---get edafield---//
	public String getenterededafield() {
		return getvalue(edafield);
	}
	
	// ---select Activated radiobtn ---//
	public boolean isActivatedSelected() {
		return radiobtnIsselected(Activated);
	}

	
	// ---get momoAccountId---//
	public String getstaffcode() {
		return getvalue(Staffcode);
	}
	
	// ---enterAltPhNo---//
	public void enterAltPhNo(String AltphNoo) {
		entervalue(AltphNoo, AltPhNo);
	}

	// ---get AltPhNo---//
	public String getAltPhNo() {
		return getvalue(AltPhNo);
	}

	// ---enterFaxNo---//
	public void enterFaxNo(String phNoo) {
		entervalue(phNoo, FaxNo);
	}

	// ---get FaxNo---//
	public String getFaxNo() {
		return getvalue(FaxNo);
	}
	// ---Bankdetailsarrowbtn---//
	public void clickXbtn() {
		buttonClick(popupXbutton);
	}
	


}
