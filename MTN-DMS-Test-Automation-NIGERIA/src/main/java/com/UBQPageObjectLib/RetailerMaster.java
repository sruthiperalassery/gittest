package com.UBQPageObjectLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.UBQGenericLib.WebDriverCommonLib;

/**
 * @author
 *
 */
public class RetailerMaster extends WebDriverCommonLib {
	WebDriver driver;

	// ----------------------Constructor----------------------//

	public RetailerMaster(WebDriver driver) {
		this.driver = driver;

	}

	// ----------------------UI Elements----------------------//

	// ---Business uid---//
	@FindBy(how = How.XPATH, using = "//input[@id='custUID']")
	private WebElement custUID;

	// ---Business code---//
	@FindBy(how = How.XPATH, using = "//input[@id='cust_code']")
	private WebElement custcode;

	// ---appointdateButton---//
	@FindBy(how = How.XPATH, using = "//input[@id='appointdateButton']")
	private WebElement appointdate;

	// ---appointdatefield---//
	@FindBy(how = How.XPATH, using = "//input[@id='appointmentDate']")
	private WebElement appointdatefield;

	// ---Sbu---//
	@FindBy(how = How.XPATH, using = "//select[@id='SBU']")
	private WebElement Sbu;

	// ---msisdnNo---//
	@FindBy(how = How.XPATH, using = "//input[@id='custEvdAccId']")
	private WebElement EvdAccountID;

	// ---msisdnNo---//
	@FindBy(how = How.XPATH, using = "//input[@id='msisdnNo']")
	private WebElement MSSISDN;

	// ---edaBtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='cust_EDate']")
	private WebElement edaBtn;

	// ---edafield---//
	@FindBy(how = How.XPATH, using = "//input[@id='DOA']")
	private WebElement edafield;

	// ---cust_name---//
	@FindBy(how = How.XPATH, using = "//input[@id='cust_name']")
	private WebElement custName;

	// ---momoMSSISDN---//
	@FindBy(how = How.XPATH, using = "//input[@id='custMomoMsisdnNo']")
	private WebElement momoMSSISDN;

	// ---MomoAccId---//
	@FindBy(how = How.XPATH, using = "//input[@id='custMomoAccId']")
	private WebElement MomoAccId;

	// ---SimswapMsisdn---//
	@FindBy(how = How.XPATH, using = "//input[@id='custSimswapMsisdn']")
	private WebElement SimswapMsisdn;

	// ---ActivationMsisdn---//
	@FindBy(how = How.XPATH, using = "//input[@id='custActivationMsisdn']")
	private WebElement ActivationMsisdn;

	// ---custLatitude---//
	@FindBy(how = How.XPATH, using = "//input[@id='custLatitude']")
	private WebElement custLatitude;

	// ---custLangitude---//
	@FindBy(how = How.XPATH, using = "//input[@id='custLangitude']")
	private WebElement custLangitude;

	// ---DsaName---//
	@FindBy(how = How.XPATH, using = "//select[@id='salesman_display']")
	private WebElement DsaName;

	// ---custbeat---//
	@FindBy(how = How.XPATH, using = "//select[@id='cust_beat']")
	private WebElement custbeat;

	// ---RetailerName---//
	@FindBy(how = How.XPATH, using = "//input[@id='owner_name']")
	private WebElement RetailerName;

	// ---custIsSimRetailer---//
	@FindBy(how = How.XPATH, using = "//input[@id='custIsSimRetailer']")
	private WebElement SimRetailer;

	// ---custIsExclusive---//
	@FindBy(how = How.XPATH, using = "//input[@id='custIsExclusive']")
	private WebElement custIsExclusive;

	// ---AddressBtn---//
	@FindBy(how = How.XPATH, using = "//a[@id='saveBtn100000012']")
	private WebElement AddressBtn;

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

	// ---AltPhNo---//
	@FindBy(how = How.XPATH, using = "//input[@id='altPhNo']")
	private WebElement AltPhNo;

	// ---FaxNo---//
	@FindBy(how = How.XPATH, using = "//input[@id='fax']")
	private WebElement FaxNo;

	// ---emailId---//
	@FindBy(how = How.XPATH, using = "//input[@id='emailId']")
	private WebElement emailId;

	// ---okbtn--//
	@FindBy(how = How.XPATH, using = "//input[@id='saveBtn']")
	private WebElement okbtn;

	// ---ChannelDiv--//
	@FindBy(how = How.XPATH, using = "//span[@id='expandChannelDiv']")
	private WebElement channelhierarchyarrow;

	// ---Channel--//
	@FindBy(how = How.XPATH, using = "//select[@id='shopperChannel']")
	private WebElement RetChannel;

	// ---Classification--//
	@FindBy(how = How.XPATH, using = "//select[@id='SEL_COMBO~2']")
	private WebElement RetClassification;

	// ---Classification--//
	@FindBy(how = How.XPATH, using = "//select[@id='SEL_COMBO~6']")
	private WebElement RetailerBusinessType;

	// ---Activatebtn--//
	@FindBy(how = How.XPATH, using = "//span[@id='expandDeregDiv']")
	private WebElement Activatebtn;

	// ---Savebtn--//
	@FindBy(how = How.XPATH, using = "//input[@id='actionBtnSUBMIT']")
	private WebElement Savebtn;

	// ---Activebtn--//
	@FindBy(how = How.XPATH, using = "//input[@value='ACTIVATED']")
	private WebElement Activebtn;

	// ---Newbtn--//
	@FindBy(how = How.XPATH, using = "//input[@value='DRAFT']")
	private WebElement Newbtn;

	// ---Dormantbtn--//
	@FindBy(how = How.XPATH, using = "//input[@value='SUSPENDED']")
	private WebElement Dormantbtn;

	// ---contact person---//

	// ---contactpersonLink--//
	@FindBy(how = How.XPATH, using = "//a[@id='ownerDetailsLink']")
	private WebElement contactpersonLink;

	// ---contactpersonTitle--//
	@FindBy(how = How.XPATH, using = "//select[@id='custTitle']")
	private WebElement contactpersonTitle;

	// ---contactpersonName--//
	@FindBy(how = How.XPATH, using = "//input[@id='profileName']")
	private WebElement contactpersonName;

	// ---contactpersonLastName--//
	@FindBy(how = How.XPATH, using = "//input[@id='profileLastName']")
	private WebElement contactpersonLastName;

	// ---contactpersonpopupokbtn--//
	@FindBy(how = How.XPATH, using = "//input[@id='saveBtn']")
	private WebElement contpersonpopupokbtn;

	// ---contpersonpopupsubmitbtn--//
	@FindBy(how = How.XPATH, using = "//input[@value='Submit']")
	private WebElement contpersonpopupsubmitbtn;

	// ---contpersonpopupclosebtn--//
	@FindBy(how = How.XPATH, using = "//input[@value='Close']")
	private WebElement contpersonpopupclosebtn;

	// ---contpersonpopupclearbtn--//
	@FindBy(how = How.XPATH, using = "(//input[@value='Clear'])[1]")
	private WebElement contpersonpopupclearbtn;

	// ---contpersonpopupaddressLink--//
	@FindBy(how = How.XPATH, using = "//a[@id='saveBtn100000007']")
	private WebElement contpersonpopupaddressLink;

	// ---custTinno--//
	@FindBy(how = How.XPATH, using = "//input[@id='cust_tin_no']")
	private WebElement custTinno;

	// ---TaxType--//
	@FindBy(how = How.XPATH, using = "//select[@id='cust_dd_tax_type_index']")
	private WebElement custTaxType;

	// ---CustBillseries--//
	@FindBy(how = How.XPATH, using = "//select[@id='bill_series_rid']")
	private WebElement CustBillseries;

	// ---CustcreditLimit--//
	@FindBy(how = How.XPATH, using = "//input[@id='cust_credit_limit']")
	private WebElement CustcreditLimit;

	// ---popupXbutton--//
	@FindBy(how = How.XPATH, using = "//input[@class='visible']")
	private WebElement popupXbutton;

	// --------------------Bank Details-----------------------//

	// ---Bankdetailsarrowbtn--//
	@FindBy(how = How.XPATH, using = "//span[@id='expandBankArrow']")
	private WebElement Bankdetailsarrowbtn;

	// ---bankName--//
	@FindBy(how = How.XPATH, using = "//input[@id='bankName']")
	private WebElement bankName;

	// ---accName--//
	@FindBy(how = How.XPATH, using = "//input[@id='accName']")
	private WebElement BankaccName;

	// ---BankaccNum--//
	@FindBy(how = How.XPATH, using = "//input[@id='accNum']")
	private WebElement BankaccNum;

	// ---BankaccStatus--//
	@FindBy(how = How.XPATH, using = "//select[@id='accStatusCombo']")
	private WebElement BankaccStatus;

	// ---bankBranch--//
	@FindBy(how = How.XPATH, using = "//input[@id='bankBranchTown']")
	private WebElement Bankbranch;
	
	
	// ---bankBranch--//
	@FindBy(how = How.XPATH, using = "//input[@id='cust_credit_limit']")
	private WebElement Creditlimit;

	// -----------------------Functions-----------------------//
	// ---Business uid---//
	public void entercustUID(String Uid) {
		entervalue(Uid, custUID);
	}

	// ---get Business uid---//
	public String getcustUID() {
		return getvalue(custUID);
	}

	// ---Business code--//
	public void entercustcode(String code) {
		entervalue(code, custcode);
	}

	// ---get Business code---//
	public String getcustcode() {
		return getvalue(custcode);
	}

	// ---select appointdate---//
	public void clickappointdatetoSelect(String date) {
		buttonClick(appointdate);
		selectDateFromCalender(date);
	}

	// ---get appointdatefield---//
	public String getenteredappointmentDate() {
		return getvalue(appointdatefield);
	}

	// ---select Sbu--//
	public void selectSbu(String sbu) {
		selectvalue(sbu, Sbu);

	}

	// ---get select sbu---//
	public String getselectSbu() {
		return getselectDrpdwnValue(Sbu);
	}

	// ---entermomoMSSISDN---//
	public void enterMSSISDN(String mmi) {
		entervalue(mmi, MSSISDN);
	}

	// ---get momoMSSISDN---//
	public String getMSSISDN() {
		return getvalue(MSSISDN);
	}

	// ---entermomoMSSISDN---//
	public void enterEVDAccountId(String evd) {
		entervalue(evd, EvdAccountID);
	}

	// ---get momoMSSISDN---//
	public String getEVDAccountId() {
		return getvalue(EvdAccountID);
	}

	// ---select edaBtn---//
	public void clickedaDatetoSelect(String date) {
		buttonClick(edaBtn);
		selectDateFromCalender(date);
	}

	// ---get edafield---//
	public String getentereddedaDate() {
		return getvalue(edafield);
	}

	// ---Business custName---//
	public void entercustName(String name) {
		entervalue(name, custName);
	}

	// ---get BusinesscustName---//
	public String getcustName() {
		return getvalue(custName);
	}

	// ---entermomoMSSISDN---//
	public void entermomoMSSISDN(String mmi) {
		entervalue(mmi, momoMSSISDN);
	}

	// ---get momoMSSISDN---//
	public String getmomoMSSISDN() {
		return getvalue(momoMSSISDN);
	}

	// ---enterMomoAccIdN---//
	public void enterMomoAccId(String Momacc) {
		entervalue(Momacc, MomoAccId);
	}

	// ---get MomoAccId---//
	public String getMomoAccId() {
		return getvalue(MomoAccId);
	}

	// ---enterSimswapMsisdn---//
	public void enterSimswapMsisdn(String sim) {
		entervalue(sim, SimswapMsisdn);
	}

	// ---get SimswapMsisdn---//
	public String getSimswapMsisdn() {
		return getvalue(SimswapMsisdn);
	}

	// ---enterActivationMsisdn---//
	public void enterActivationMsisdn(String Act) {
		entervalue(Act, ActivationMsisdn);
	}

	// ---get ActivationMsisdn---//
	public String getActivationMsisdn() {
		return getvalue(SimswapMsisdn);
	}

	// ---custLatitude---//
	public void entercustLatitude(String Lat) {
		entervalue(Lat, custLatitude);
	}

	// ---get custLatitude---//
	public String getcustLatitude() {
		return getvalue(custLatitude);
	}

	// ---custLatitude---//
	public void entercustLangitude(String Lang) {
		entervalue(Lang, custLangitude);
	}

	// ---get custLatitude---//
	public String getcustLangitude() {
		return getvalue(custLangitude);
	}

	// ---select dsa--//
	public void selectDsaName(String dsa) {
		selectvalue(dsa, DsaName);

	}

	// ---get select dsa---//
	public String getselectDsaName() {
		return getselectDrpdwnValue(DsaName);
	}

	// ---select beat--//
	public void selectcustbeat(String beat) {
		selectvalue(beat, custbeat);

	}

	// ---get select beat---//
	public String getselectcustbeat() {
		return getselectDrpdwnValue(custbeat);
	}

	// ---custLatitude---//
	public void enterRetailerName(String Reat) {
		entervalue(Reat, RetailerName);
	}

	// ---get custLatitude---//
	public String getRetailerName() {
		return getvalue(RetailerName);
	}

	// ---select SimRetailer checkbox---//
	public void selectcheckboxSimRetailer() {
		checkboxselect(SimRetailer);
	}

	// ---select SimRetailer checkbox---//
	public boolean isSimRetailerSelected() {
		return checkboxIsselected(SimRetailer);
	}

	// ---select Activated radiobtn ---//
	public boolean isActivatedSelected() {
		return radiobtnIsselected(Activebtn);
	}

	// ---select SimRetailer checkbox---//
	public void selectcheckboxIsExclusive() {
		checkboxselect(custIsExclusive);
	}

	// ---Addressbtn---//
	public void ClickAddressLink() {
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

	// ---get pinCode---//
	public String getpinCode() {
		return getvalue(pinCode);
	}

	// ---enterphNo---//
	public void enterphNo(String phNoo) {
		entervalue(phNoo, phNo);
	}

	// ---get phNo---//
	public String getphNo() {
		return getvalue(phNo);
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

	// ---channel hierarchy arrow btn---//
	public void ClickchannehierarchyarrowBtn() {
		buttonClick(channelhierarchyarrow);
	}

	// ---select channel--//
	public void selectRetChannel(String channel) {
		selectvalue(channel, RetChannel);

	}

	// ---get select channel---//
	public String getselectedRetChannel() {
		return getselectDrpdwnValue(RetChannel);
	}

	// ---select classif--//
	public void selectRetClassification(String classif) {
		selectvalue(classif, RetClassification);

	}

	// ---get select classif---//
	public String getselectedRetClassification() {
		return getselectDrpdwnValue(RetClassification);
	}

	// ---select BusinessType--//
	public void selectRetailerBusinessType(String BusType) {
		selectvalue(BusType, RetailerBusinessType);

	}

	// ---get select BusinessType---//
	public String getselectedRetailerBusinessType() {
		return getselectDrpdwnValue(RetailerBusinessType);
	}

	// ---ArrowBtn---//
	public void ClickReActivatedbtn() {
		// selectRadioButton(Activatebtn);
		buttonClick(Activatebtn);

	}

	// ---Activebtn---//
	public void clickActivebtn() {
		buttonClick(Activebtn);

	}

	// ---Newbtn---//
	public void clickonNewbtn() {
		buttonClick(Newbtn);

	}

	// ---Newbtn---//
	public void clickonDormantbtn() {
		buttonClick(Dormantbtn);

	}

	// ---Savebtn---//
	public void ClickSavebtn() {
		buttonClick(Savebtn);
	}

	// ---Activebtn---//
	public void getvalueofradiobutton() {
		// selectRadioButton(Activebtn);
		// buttonClick(Activebtn);
		System.out.println(getvalue(Activebtn));

	}

	// ---select contactpersonTitle--//
	public void selectcontactpersonTitle(String title) {
		selectvalue(title, contactpersonTitle);

	}

	// ---get selected contactpersonTitle---//
	public String getselectedcontactpersonTitle() {
		return getselectDrpdwnValue(contactpersonTitle);
	}

	// ---entercustTinno---//
	public void entercontactpersonName(String name) {
		entervalue(name, contactpersonName);
	}

	// ---get custTinno---//
	public String getcontactpersonName() {
		return getvalue(contactpersonName);
	}

	// ---entercustTinno---//
	public void entercontactpersonLastName(String ln) {
		entervalue(ln, contactpersonLastName);
	}

	// ---get custTinno---//
	public String getcontactpersonLastName() {
		return getvalue(contactpersonLastName);
	}

	// ---contactpersonLink---//
	public void clickcontactpersonLink() {
		buttonClick(contactpersonLink);
	}

	// ---contpersonpopupokbtn---//
	public void clickcontpersonpopupokbtn() {
		buttonClick(contpersonpopupokbtn);
	}

	// ---contpersonpopupsubmitbtn---//
	public void clickcontpersonpopupsubmitbtn() {
		buttonClick(contpersonpopupsubmitbtn);
	}

	// ---contpersonpopupclosebtn---//
	public void clickcontpersonpopupclosebtn() {
		buttonClick(contpersonpopupclosebtn);
	}

	// ---contpersonpopupclearbtn---//
	public void clickcontpersonpopupclearbtn() {
		buttonClick(contpersonpopupclearbtn);
	}

	// ---contpersonpopupaddressLink---//
	public void clickcontpersonpopupaddressLink() {
		buttonClick(contpersonpopupaddressLink);
	}

	// ---entercustTinno---//
	public void entercustTinno(String tin) {
		entervalue(tin, custTinno);
	}

	// ---get custTinno---//
	public String getcustTinno() {
		return getvalue(custTinno);
	}

	// ---select custTaxType--//
	public void selectcustTaxType(String tax) {
		selectvalue(tax, custTaxType);

	}

	// ---get selected custTaxType---//
	public String getselectedcustTaxType() {
		return getselectDrpdwnValue(custTaxType);
	}

	// ---select CustBillseries--//
	public void selectCustBillseries(String bill) {
		selectvalue(bill, CustBillseries);

	}

	// ---get selected CustBillseries---//
	public String getselectedCustBillseries() {
		return getselectDrpdwnValue(CustBillseries);
	}

	// ---entercustTinno---//
	public void enterCustcreditLimit(String credit) {
		entervalue(credit, CustcreditLimit);
	}

	// ---get custTinno---//
	public String getCustcreditLimit() {
		return getvalue(CustcreditLimit);
	}

	// --------------Bank details functions------------//

	// ---Bankdetailsarrowbtn---//
	public void clickonBankdetailsarrowbtn() {
		buttonClick(Bankdetailsarrowbtn);
	}

	// ---enterbankName---//
	public void enterbankName(String bname) {
		entervalue(bname, bankName);
	}

	// ---get bankName---//
	public String getbankName() {
		return getvalue(bankName);
	}

	// ---enterBankaccName---//
	public void enterBankaccName(String bacc) {
		entervalue(bacc, BankaccName);
	}

	// ---get BankaccName---//
	public String getBankaccName() {
		return getvalue(BankaccName);
	}

	// ---enterBankaccNum---//
	public void enterBankaccNum(String bno) {
		entervalue(bno, BankaccNum);
	}

	// ---get BankaccNum---//
	public String getBankaccNum() {
		return getvalue(BankaccNum);
	}

	// ---select CustBillseries--//
	public void selectBankaccStatus(String status) {
		selectvalue(status, BankaccStatus);

	}

	// ---get selected CustBillseries---//
	public String getselectedBankaccStatus() {
		return getselectDrpdwnValue(BankaccStatus);
	}

	// ---enterBankbranch---//
	public void enterBankbranch(String bno) {
		entervalue(bno, Bankbranch);
	}

	// ---get Bankbranch---//
	public String getBankbranch() {
		return getvalue(Bankbranch);
	}

	// ---Bankdetailsarrowbtn---//
	public void clickXbtn() {
		buttonClick(popupXbutton);
	}

	// ---FullName--//
	@FindBy(how = How.XPATH, using = "//table[@id='staffListTabCType']/tbody/tr")
	private WebElement FullName;

	// ---conPersonTitleOnMainScreen--//
	@FindBy(how = How.XPATH, using = "//table[@id='staffListTabCType']/tbody/tr/td[2]/span")
	private WebElement conPersonTitleOnMainScreen;

	// ---conPersonNameOnMainScreen--//
	@FindBy(how = How.XPATH, using = "//table[@id='staffListTabCType']/tbody/tr/td[3]/span")
	private WebElement conPersonNameOnMainScreen;

	public String getconPersonTitleOnMainScreen() {
		return getText(conPersonTitleOnMainScreen);
	}

	public String getconPersonNameOnMainScreen() {
		return getText(conPersonNameOnMainScreen);
	}

	// ---clickonEditcontper---//
	public void clickoncontperName() {
		buttonClick(FullName);
	}
	
	// ---custLatitude---//
		public void enterCreditLimit(String cre) {
			entervalue(cre, Creditlimit);
		}

		// ---get custLatitude---//
		public String getCreditLimit() {
			return getvalue(Creditlimit);
		}
		
		public void Creditlimit(){
			 
		//int val=rem.getCreditLimit();
			
			
		}

}
