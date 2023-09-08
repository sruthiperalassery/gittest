
package com.UBQPageObjectLib;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.UBQGenericLib.WebDriverCommonLib;

/**
 * @author Basanagouda
 *
 */
public class DealerMaster extends WebDriverCommonLib {

	WebDriver driver;
	Random random = new Random();

	// ----------------------Constructor----------------------//

	public DealerMaster(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

	// ---For RetailerStatus---//
		@FindBy(how = How.XPATH, using = "//label[@id='currentstates']/b")
		private WebElement RetailerStatus;

		// ---For RetailerUID---//
		@FindBy(how = How.XPATH, using = "//input[@id='custUID']")
		private WebElement RetailerUID;

		// ---For RetailerCode---//
		@FindBy(how = How.XPATH, using = "//input[@id='cust_code']")
		private WebElement RetailerCode;

		// ---For Select SBU---//
		@FindBy(how = How.XPATH, using = "//select[@id='SBU']")
		private WebElement SelectSBU;

		// ---For Retailer name---//
		@FindBy(how = How.XPATH, using = "//input[@id='cust_name']")
		private WebElement RetailerName;

		// ---For AppointmentDate---//
		@FindBy(how = How.XPATH, using = "//input[@id='appointmentDate']")
		private WebElement AppointmentDate;

		// ---For AppointmentDate---//
		@FindBy(how = How.XPATH, using = "//input[@id='DOA']")
		private WebElement DateofActivation;

		// ---For SalesmanName---//
		@FindBy(how = How.XPATH, using = "//select[@id='salesman_display']")
		private WebElement SalesmanName;

		// ---For BeatName---//
		@FindBy(how = How.XPATH, using = "//select[@id='cust_beat']")
		private WebElement Clustername;

		// ----For MSISDN number---//
		@FindBy(how = How.XPATH, using = "//input[@id='msisdnNo']")
		private WebElement MsisdnNo;

		// ----For MOMOMSISDN number---//
		@FindBy(how = How.XPATH, using = "//input[@id='custMomoMsisdnNo']")
		private WebElement MomomsisdnNo;

		// ----For Street group---//
		@FindBy(how = How.XPATH, using = "//input[@id='streetGroupCode']")
		private WebElement Streetgroup;

		// ----For SubStreet group---//
		@FindBy(how = How.XPATH, using = "//input[@id='subStrGroupCode']")
		private WebElement Substreetgroup;

		// ----For Company Reg Number---//
		@FindBy(how = How.XPATH, using = "//input[@id='cmpyRegNo']")
		private WebElement Comregnum;

		// ----For Type of company---//
		@FindBy(how = How.XPATH, using = "//input[@id='typeofCmpy']")
		private WebElement Typeofcompany;

		// ----For Accountgroup---//
		@FindBy(how = How.XPATH, using = "//input[@id='acGroup']")
		private WebElement Accountgroup;

		// ----For Accountgroup code---//
		@FindBy(how = How.XPATH, using = "//input[@id='acGroupCode']")
		private WebElement Accountgroupcode;

		// ----For Is sim retailer check box---//
		@FindBy(how = How.XPATH, using = "//input[@id='custIsSimRetailer']")
		private WebElement Issimretailercheckbox;

		// ----For Is Exclusive---//
		@FindBy(how = How.XPATH, using = "//input[@id='custIsExclusive']")
		private WebElement Isexclusive;

		// ----For latitude---//
		@FindBy(how = How.XPATH, using = "//input[@id='custLatitude']")
		private WebElement Latitude;

		// ----For latitude---//
		@FindBy(how = How.XPATH, using = "//input[@id='custLangitude']")
		private WebElement Langitude;

		// -------Documents fields---------//

		// ---For Documents link---//
		@FindBy(how = How.XPATH, using = "//a[@id='documentsDetailsLink']")
		private WebElement Documentslink;

		// ---For File type---//
		@FindBy(how = How.XPATH, using = "//select[@id='fileType']")
		private WebElement Filetype;

		// ---For Document description---//
		@FindBy(how = How.XPATH, using = "//input[@id='attachmentDesc']")
		private WebElement Documentdescription;

		// ---For File---//
		@FindBy(how = How.XPATH, using = "//input[@id='file']")
		private WebElement File;

		// ---For upload button---//
		@FindBy(how = How.XPATH, using = "//*[@id='desktopPopUpWorkArea0']/div/form/table/tbody/tr[3]/td/input")
		private WebElement Uploadbtn;

		// -------contact information--------//

		// ---For NormalAddressAddBtn---//
		@FindBy(how = How.XPATH, using = "//a[@id='saveBtn0']")
		private WebElement NormalAddressAddBtn;

		// ---For Address fields---//
		@FindBy(how = How.XPATH, using = "//input[@id='shopName']")
		private WebElement Addressfield;

		// ---For CopyFromAddresslink--//
		@FindBy(how = How.XPATH, using = "//label[@id='viewAddress']")
		private WebElement CopyFromAddresslink;

		// ---For StateCombo--//
		@FindBy(how = How.XPATH, using = "//select[@id='stateCombo']")
		private WebElement StateCombo;

		// ---For MobiNo--//
		@FindBy(how = How.XPATH, using = "//input[@id='mobNo']")
		private WebElement MobiNo;

		// ---For FaxNo--//
		@FindBy(how = How.XPATH, using = "//input[@id='phNo']")
		private WebElement FaxNo;

		// ---For EmailId--//
		@FindBy(how = How.XPATH, using = "//input[@id='emailId']")
		private WebElement EmailId;

		// ---For ZipCode--//
		@FindBy(how = How.XPATH, using = "//input[@id='zipCode']")
		private WebElement ZipCode;

		// ---For Alternate mobile number--//
		@FindBy(how = How.XPATH, using = "//input[@id='custAltMob']")
		private WebElement Alternatemobilenumber;

		// ---For OkBtn--//
		@FindBy(how = How.XPATH, using = "//input[@id='saveBtn']")
		private WebElement OkBtn;

		// -------Owner information-------//

		@FindBy(how = How.XPATH, using = "//a[@id='ownerDetailsLink']")
		private WebElement Owneraddressdetailslink;

		// ---For Title--//
		@FindBy(how = How.XPATH, using = "//input[@id='custTitle']")
		private WebElement Title;

		// ---For Date of birth--//
		@FindBy(how = How.XPATH, using = "//input[@id='sDOB']")
		private WebElement Dateofbirth;

		// ---For Owner name--//
		@FindBy(how = How.XPATH, using = "//input[@id='profileName']")
		private WebElement Name;

		// ---For Date of joining--//
		@FindBy(how = How.XPATH, using = "//input[@id='sDOJ']")
		private WebElement Dateofjoining;

		// ---For Effective date of activation--//
		@FindBy(how = How.XPATH, using = "//input[@id='sEDOA']")
		private WebElement Effectivedateofactivation;

		// ---For owner msisdn number--//
		@FindBy(how = How.XPATH, using = "//input[@id='msisdnNo']")
		private WebElement Msisdnnumber;

		// ---------contact addresss---------//

		// ---For Add button--//
		@FindBy(how = How.XPATH, using = "//a[@id='saveBtn100000007']")
		private WebElement Addbtn;

		// ---For Enter remarks--//
		@FindBy(how = How.XPATH, using = "//textarea[@id='remarks']")
		private WebElement Remarks;

		// ---For Add documents--//
		@FindBy(how = How.XPATH, using = "//a[@id='documentsDetailsLink']")
		private WebElement Adddocumentslink;

		// -------For Assign/assigned equipments------------//

		// -------For Assign/assigned equipments link------------//
		@FindBy(how = How.XPATH, using = "//*[@id='staffForm']/table[1]/tbody/tr[1]/td/fieldset/table/tbody/tr[11]/td/a")
		private WebElement AssignAssignedequipments;

		// -------For Existing items field------------//
		@FindBy(how = How.XPATH, using = "//input[@id='assetItem']")
		private WebElement Existingitems;

		// -------For Serial number field------------//
		@FindBy(how = How.XPATH, using = "//input[@id='serialNo']")
		private WebElement Serialnumber;

		// -------For Item type field------------//
		@FindBy(how = How.XPATH, using = "//input[@id='assetType']")
		private WebElement Itemtype;

		// -------For Make field------------//
		@FindBy(how = How.XPATH, using = "//input[@id='assetMake']")
		private WebElement Make;

		// -------For Model field------------//
		@FindBy(how = How.XPATH, using = "//input[@id='assetModel']")
		private WebElement Model;

		// -------For History link------------//
		@FindBy(how = How.XPATH, using = "//*[@id='asset']/td[7]/a")
		private WebElement Hystory;

		// -------For Save button------------//
		@FindBy(how = How.XPATH, using = "//input[@id='saveBtn']")
		private WebElement Savebtn;

		// -------For Clear button------------//
		@FindBy(how = How.XPATH, using = "//input[@id='clearBtn']")
		private WebElement Clearbtn;

		// -------For De-registration / Re Activate link------------//
		@FindBy(how = How.XPATH, using = "//*[@id='reactive']/span[2]/span")
		private WebElement Reactivatelink;

		// -------For Activated radio button------------//
		@FindBy(how = How.XPATH, using = "//input[@id='actionActivated']")
		private WebElement Activatedradiobtn;

		// -------For Submit button------------//
		@FindBy(how = How.XPATH, using = "//input[@id='actionBtnSUBMIT']")
		private WebElement Submitbtn;

		// -------For Close button------------//
		@FindBy(how = How.XPATH, using = "//input[@id='clearBtn']")
		private WebElement Closebtn;

		// -------For Clear button------------//
		@FindBy(how = How.XPATH, using = "//td[@id='actionableBtnCell']/input[3]")
		private WebElement Clearbutton;

		// ---For PanNo---//
		@FindBy(how = How.XPATH, using = "//input[@id='cust_lst_no']")
		private WebElement PanNo;

		// ---For TaxType---//
		@FindBy(how = How.XPATH, using = "//select[@id='cust_dd_tax_type_index']")
		private WebElement TaxType;

		// ---For BillSeries---//
		@FindBy(how = How.XPATH, using = "//select[@id='bill_series_rid']")
		private WebElement BillSeries;

		// ---For ChannelLink---//
		@FindBy(how = How.XPATH, using = "//td[@id='channel']/span[2]/span")
		private WebElement ChannelLink;

		// ---For SeelctChannel---//
		@FindBy(how = How.XPATH, using = "//select[@id='shopperChannel']")
		private WebElement SelectChannel;

		// ---For SelectClassification---//
		@FindBy(how = How.XPATH, using = "//select[@id='SEL_COMBO~2']")
		private WebElement SelectClassification;

		// ---For Dealer business type---//
		@FindBy(how = How.XPATH, using = "//*[@id='SEL_COMBO~6']")
		private WebElement Dealerbussinesstype;

		// ---For ChannelcloseBtn--//
		@FindBy(how = How.XPATH, using = "//input[@id='close']")
		private WebElement ChannelcloseBtn;

		// ---For Asset details--//
		@FindBy(how = How.XPATH, using = "//a[@id='assetspopup']")
		private WebElement Assetdetails;

		// ---For ApproveBtn--//
		@FindBy(how = How.XPATH, using = "//input[@id='actionBtnSAVE']")
		private WebElement ApproveBtn;

		// ---ForSaveBtn--//
		@FindBy(how = How.XPATH, using = "//input[@id='actionBtnSUBMIT']")
		private WebElement SaveBtn;

		// ---For RejectBtn--//
		@FindBy(how = How.XPATH, using = "//input[@id='actionBtnREJECT']")
		private WebElement RejectBtn;

		// ---For ClearBtn--//
		@FindBy(how = How.XPATH, using = "//input[@id='clearBtn']")
		private WebElement ClearBtn;

		// ---For CloseBtn--//
		@FindBy(how = How.XPATH, using = "//td[@id='actionableBtnCell']/input[3]")
		private WebElement CloseBtn;

		// ----------------------Basic Functions----------------------//

		// ---For getRetailerStatus--//
		public String getDealerStatus() {
			return getText(RetailerStatus);
		}

		// ---For getDealerUID--//
		public String getDealerUID() {
			return getvalue(RetailerUID);
		}

		// ---For getDealerCode--//
		public String getDealerCode() {
			return getvalue(RetailerCode);
		}

		// ---For SelectSBU--//
		public void selectSBU(String sbu) {
			selectvalue(sbu, SelectSBU);
			// selectDrpdwnRamdomly(SelectSBU);
		}

		// ---For SelectSBU--//
		public String getSBU() {
			return getselectDrpdwnValue(SelectSBU);
		}

		// ---For enterRetailername--//
		public void enterRetailername(String Dealer) {
			entervalue(Dealer, RetailerName);
		}

		// ---For enterRetailername--//
		public String getRetailername() {
			return getvalue(RetailerName);
		}

		// ---For selectSalesMan--//
		public void selectSalesMan(String salesman) {
			selectvalue(salesman, SalesmanName);
		}

		// ---For getSalesMan--//
		public String getSalesMan() {
			return getselectDrpdwnValue(SalesmanName);
		}

		// ---For selectcluster--//
		public void selectBeat(String beat) {
			selectvalue(beat, Clustername);
		}

		// ---For getcluster--//
		public String getBeat() {
			return getselectDrpdwnValue(Clustername);
		}

		// ---For enterMSISDN number--//
		public void enterMSISDNno(String MSISDN) {
			entervalue(MSISDN, MsisdnNo);
		}

		// ---For getMSISDN number--//
		public String getMSISDNnumber() {
			return getvalue(MsisdnNo);
		}

		// ---For enterMOMOMSISDN Number--//
		public void enterMOMOMSISDNno(String MOMOMSISDN) {
			entervalue(MOMOMSISDN, MomomsisdnNo);
		}

		// ---For getMOMOMSISDN number--//
		public String getMOMOMSISDNnumber() {
			return getvalue(MomomsisdnNo);
		}

		// ---For enter Street group --//
		public void enterStreetgroup(String streetgroup) {
			entervalue(streetgroup, Streetgroup);
		}

		// ---For get Street group--//
		public String getStreetgroup() {
			return getvalue(Streetgroup);
		}

		// ---For enter Street group --//
		public void enterSubStreetgroup(String substreetgroup) {
			entervalue(substreetgroup, Substreetgroup);
		}

		// ---For get Street group--//
		public String getSubStreetgroup() {
			return getvalue(Substreetgroup);
		}

		// ---For enter company registration number --//
		public void entercompanyregistrationnumber(String comregnum) {
			entervalue(comregnum, Comregnum);
		}

		// ---For get company registration number--//
		public String getcompanyregnumber() {
			return getvalue(Comregnum);
		}

		// ---For enter Type of company --//
		public void entertypeofcompany(String typeofcom) {
			entervalue(typeofcom, Typeofcompany);
		}

		// ---For get Type of company--//
		public String gettypeofcompany() {
			return getvalue(Typeofcompany);
		}

		// ---For enter account group--//
		public void enteraccountgroup(String accgroup) {
			entervalue(accgroup, Accountgroup);
		}

		// ---For get account group--//
		public String getaccountgroup() {
			return getvalue(Accountgroup);
		}

		// ---For enter account group code--//
		public void enteraccountgroupcode(String accgroupcode) {
			entervalue(accgroupcode, Accountgroupcode);
		}

		// ---For get account group--//
		public String getaccountgroupcode() {
			return getvalue(Accountgroupcode);
		}

		// ---For enter Latitude-//
		public void enterlatitude(String latitude) {
			entervalue(latitude, Latitude);
		}

		// ---For get Latitude--//
		public String getlatitude() {
			return getvalue(Latitude);
		}

		// ---For enter Longitude-//
		public void enterlangitude(String langitude) {
			entervalue(langitude, Langitude);
		}

		// ---For get Longitude--//
		public String getlangitude() {
			return getvalue(Langitude);
		}

		// ---For Select file type--//
		public void selectfiletype(String filetype) {
			selectvalue(filetype, Filetype);

		}

		// ---For get file type--//
		public String getfiletype() {
			return getselectDrpdwnValue(Filetype);
		}

		// ---For enter document description-//
		public void enterdocumentdescription(String docdes) {
			entervalue(docdes, Documentdescription);
		}

		// ---For get document description--//
		public String getdocumentdescription() {
			return getvalue(Documentdescription);
		}

		// ---For enter owner title-//
		public void enterownertitle(String title) {
			entervalue(title, Title);
		}

		// ---For get owner title--//
		public String getownertitle() {
			return getvalue(Title);
		}

		// ---For enter Date of birth-//
		public void enterdateofbirth(String dateofbirth) {
			entervalue(dateofbirth, Dateofbirth);
		}

		// ---For get date of birth--//
		public String getdateofbirth() {
			return getvalue(Dateofbirth);
		}

		// ---For enter owner name-//
		public void enterownername(String ownername) {
			entervalue(ownername, Name);
		}

		// ---For get owner name--//
		public String getownername() {
			return getvalue(Name);
		}

		// ---For enter Date of joining-//
		public void enterdateofjoining(String dateofjoining) {
			entervalue(dateofjoining, Dateofjoining);
		}

		// ---For get date of joining--//
		public String getdateofjoining() {
			return getvalue(Dateofjoining);
		}

		// ---For enter effective date of activation-//
		public void entereffectivedateofactivation(String dateofactivation) {
			entervalue(dateofactivation, Effectivedateofactivation);
		}

		// ---For get effective date of activation--//
		public String getdateofacivation() {
			return getvalue(Effectivedateofactivation);
		}

		// ---For enter owner MSISDN number-//
		public void enterownermsisdn(String msisdn) {
			entervalue(msisdn, Msisdnnumber);
		}

		// ---For get owner MSISDN number--//
		public String getownermsisdn() {
			return getvalue(Msisdnnumber);
		}

		// ---For enterAppointmentdate--//
		public void enterAppointmentdate(String appdate) {
			entervalue(appdate, AppointmentDate);
		}

		// ---For getAppointmentdate--//
		public String getAppointmentdate() {
			return getvalue(AppointmentDate);
		}

		// ---For enterEffectivedate--//
		public void enterEffectivedate(String appdate) {
			entervalue(appdate, DateofActivation);
		}

		// ---For getEffectivedate--//
		public String getEffectivedate() {
			return getvalue(DateofActivation);
		}

		// ---For enterPanNo--//
		public void enterPanNo(String panNo) {
			entervalue(panNo, PanNo);
		}

		// ---For getPanNo--//
		public String getPanNo() {
			return getvalue(PanNo);
		}

		// ---For selectTaxType--//
		public void selectTaxType(String taxtype) {
			selectvalue(taxtype, TaxType);
			// selectDrpdwnRamdomly(TaxType);
		}

		// ---For getTaxType--//
		public String getTaxType() {
			return getselectDrpdwnValue(TaxType);
		}

		// ---For selectBillSeries--//
		public void selectBillSeries(String billSeries) {
			selectvalue(billSeries, BillSeries);
		}

		// ---For getBillSeries--//
		public String getBillSeries() {
			return getselectDrpdwnValue(BillSeries);
		}

		// ---For clickonChannelHerarchyLink--//
		public void clickonChannelHerarchyLink() {
			buttonClick(ChannelLink);
		}

		// ---For selectChannel--//
		public void selectChannel(String channel) {
			selectvalue(channel, SelectChannel);
			// selectDrpdwnRamdomly(SelectChannel);
		}

		// ---For getChannel--//
		public String getChannel() {
			return getselectDrpdwnValue(SelectChannel);
		}

		// ---For selectClassification--//
		public void selectClassification(String classification) {
			selectvalue(classification, SelectClassification);
			// selectDrpdwnRamdomly(SelectClassification);
		}

		// ---For getClassification--//
		public String getClassification() {
			return getselectDrpdwnValue(SelectClassification);
		}

		// ---For clickonChannelClose--//
		public void clickonChannelClose() {
			buttonClick(ChannelcloseBtn);
		}

		// ---For clickonaddaddress--//
		public void clickonaddaddress() {
			buttonClick(NormalAddressAddBtn);
		}

		// ---For enterAddress--//
		public void enterAddress(String address) {
			entervalue(address, Addressfield);
		}

		// ---For getAddress--//
		public String getAddress() {
			return getvalue(Addressfield);
		}

		// ---For selectState--//
		public void selectState(String state) {
			selectvalue(state, StateCombo);
			// selectDrpdwnRamdomly(StateCombo);
		}

		// ---For getState--//
		public String getState() {
			return getselectDrpdwnValue(StateCombo);
		}

		// ---For enterMainStreet--//
		public void selectArea(String area) {

			WebElement element = driver.findElement(By.xpath("//a[text()='" + area + "']"));
			highLightElement(driver, element);
			element.click();
		}

		// ---For enterMainStreet--//
		public void selectStreet(String mainStreet) {
			WebElement element = driver.findElement(By.xpath("//a[text()='" + mainStreet + "']"));
			highLightElement(driver, element);
			element.click();
		}

		// ---For enterZipCode--//
		public void enterZipCode(String zip) {
			entervalue(zip, ZipCode);
		}

		// ---For getZipCode--//
		public String getZipCode() {
			return getvalue(ZipCode);
		}

		// ---For enterFaxNo--//
		public void enterFaxNo(String fax) {
			entervalue(fax, FaxNo);
		}

		// ---For getFaxNo--//
		public String getFaxNo() {
			return getvalue(FaxNo);
		}

		// ---For enterPhoneNo--//
		public void enterPhoneNo(String phone) {
			entervalue(phone, MobiNo);
		}

		// ---For getPhoneno--//
		public String getPhoneno() {
			return getvalue(MobiNo);
		}

		// ---For enterPhoneNo--//
		public void enterAlterPhoneNo(String phone) {
			entervalue(phone, Alternatemobilenumber);
		}

		// ---For getPhoneno--//
		public String getAlterPhoneno() {
			return getvalue(Alternatemobilenumber);
		}

		// ---For enterRetailerlername--//
		public void enterMSISDN(String MSISDN) {
			entervalue(MSISDN, RetailerName);
		}

		// ---For enterEmailId--//
		public void enterEmailId(String email) {
			entervalue(email, EmailId);
		}

		// ---For getEmailId--//
		public String getEmailId() {
			return getvalue(EmailId);
		}

		// ---For clickonokbtn--//
		public void clickonokbtn() {
			buttonClick(OkBtn);
		}

		// ---For Ok Btn--//
		public void clickonMainSavebtn() {
			buttonClick(Submitbtn);
		}

		// ---For Clear Btn--//
		public void clickonClearbtn() {
			buttonClick(Clearbutton);
		}

		// ---For Close Btn--//
		public void clickonClosebtn() {
			buttonClick(CloseBtn);
		}

		public int getNumOfRows() {
			List<WebElement> size = driver.findElements(By.xpath("//div[@id='resultDiv']/table/tbody/tr"));
			return size.size();
		}

		public void ClickonEditBtn() {
			int row = getNumOfRows();
			for (int i = 1; i <= row; i++) {
				if (i == row) {
					WebElement element = driver
							.findElement(By.xpath("//div[@id='resultDiv']/table/tbody/tr[" + i + "]/td[6]/img"));
					element.click();
				}
			}

		}

}
