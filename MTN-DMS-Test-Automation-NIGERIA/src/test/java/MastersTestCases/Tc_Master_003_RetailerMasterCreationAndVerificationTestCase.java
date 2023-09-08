package MastersTestCases; 

import java.util.HashMap;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.UBQGenericLib.BaseClassLoader;
import com.UBQGenericLib.ExcelLib;

/**
 * @author Praneeth
 *
 */
@Listeners(com.UBQGenericLib.SampleListner.class)
public class Tc_Master_003_RetailerMasterCreationAndVerificationTestCase extends BaseClassLoader {
	HashMap<String, String> retailerdata = new HashMap<String, String>();

	@Test
	public void RetailerEntryCreationAndVerificationtestCase() throws Exception {

		retailerdata.put("Sbu", "MTN");
		retailerdata.put("MSSISDN",+225+AutoNumericvalue(8));
		retailerdata.put("BusinessName", Autoalphavalue(10));
		retailerdata.put("MOMOMSSISDN",  +225+AutoNumericvalue(8));
		retailerdata.put("DsaName", "Sanity Test");
		retailerdata.put("Route", "ABOISSO");
		retailerdata.put("RetailerName", Autoalphavalue(8));
		retailerdata.put("ShopName", Autoalphavalue(5));
		retailerdata.put("StreetName", Autoalphavalue(5));
		retailerdata.put("Landmark", Autoalphavalue(8));
		retailerdata.put("City", "Bago");
		retailerdata.put("State", "Yangon");
		retailerdata.put("PinCode", AutoNumericvalue(5));
		retailerdata.put("PhoneNumber", +225+AutoNumericvalue(8));
		retailerdata.put("FaxNumber", +225+AutoNumericvalue(8));
		retailerdata.put("AltPhoneNumber", +225+AutoNumericvalue(8));
		retailerdata.put("Email", "pani8000@gmail.com");
		retailerdata.put("Channel", "INDIRECT");
		retailerdata.put("Classification", "Gold");
		retailerdata.put("BusinessType", "Banks");
		retailerdata.put("appointmentDate", Today());
		retailerdata.put("edaDate", Today());
		retailerdata.put("ContaocPersonTitle", "Mr.");
		retailerdata.put("ContaocPersonName", Autoalphavalue(5));
		retailerdata.put("ContaocPersonLastName",Autoalphavalue(5));
		retailerdata.put("TinNo",AutoNumericvalue(20));
		retailerdata.put("TaxType","VAT for Tax Invoice");
		retailerdata.put("BillSeries","DIST072002059");
		retailerdata.put("CreditLimit", AutoNumericvalue(4));
		retailerdata.put("BankName",Autoalphavalue(5));
		retailerdata.put("AccountName",Autoalphavalue(5));
		retailerdata.put("AccountNumber",AutoNumericvalue(16));
		retailerdata.put("AccountStatus","Active");
		retailerdata.put("BankBranch",Autoalphavalue(5));
		
		if (country.equalsIgnoreCase("Nigeria")) {
			Thread.sleep(1500);
			home.ClickonMenutype();
			Thread.sleep(1500);	
		}
		Thread.sleep(500);
		home.ClickOnMenu();
		Thread.sleep(500);
		home.ClickOnSubMenuItem("Retailer Master");
		logger.info("Clicked on sub menu item Retailer Master");
		Thread.sleep(1000);
		rem.clickappointdatetoSelect(retailerdata.get("appointmentDate"));
		Thread.sleep(500);

		rem.ClickSavebtn();
		Thread.sleep(500);
		if (wcl.getAlertmsg().equalsIgnoreCase("Please select SBU")) {
			wcl.acceptAlert();
			rem.selectSbu(retailerdata.get("Sbu"));

		}
		rem.enterMSSISDN(retailerdata.get("MSSISDN"));
		Thread.sleep(500);
		rem.clickedaDatetoSelect(retailerdata.get("edaDate"));

		rem.ClickSavebtn();
		Thread.sleep(500);
		if (wcl.getAlertmsg().equalsIgnoreCase("Please enter the Business Name")) {
			wcl.acceptAlert();
			rem.entercustName(retailerdata.get("BusinessName"));
		}
		rem.entermomoMSSISDN(retailerdata.get("MOMOMSSISDN"));

		rem.ClickSavebtn();
		Thread.sleep(500);
		if (wcl.getAlertmsg().equalsIgnoreCase("Please select  DSA")) {
			wcl.acceptAlert();
			rem.selectDsaName(retailerdata.get("DsaName"));
		}

		rem.ClickSavebtn();
		Thread.sleep(500);
		if (wcl.getAlertmsg().equalsIgnoreCase("Please Select Route")) {
			wcl.acceptAlert();
			rem.selectcustbeat(retailerdata.get("Route"));
		}

		rem.ClickSavebtn();
		Thread.sleep(500);
		if (wcl.getAlertmsg().equalsIgnoreCase("Please enter the Retailer Name")) {
			wcl.acceptAlert();
			rem.enterRetailerName(retailerdata.get("RetailerName"));
		}
		rem.selectcheckboxSimRetailer();
		rem.ClickSavebtn();
		Thread.sleep(500);
		if (wcl.getAlertmsg().equalsIgnoreCase("Please set  Address")) {
			wcl.acceptAlert();
			rem.ClickAddressLink();

		}
		rem.Clickokbtn();
		Thread.sleep(500);
		if (wcl.getAlertmsg().equalsIgnoreCase("Enter Shop Building Name")) {
			wcl.acceptAlert();
			rem.entereshopName(retailerdata.get("ShopName"));

		}

		rem.Clickokbtn();
		Thread.sleep(500);
		if (wcl.getAlertmsg().equalsIgnoreCase("Enter Street")) {
			wcl.acceptAlert();
			rem.enterstreetAdds(retailerdata.get("StreetName"));

		}

		rem.Clickokbtn();
		Thread.sleep(500);
		if (wcl.getAlertmsg().equalsIgnoreCase("Enter Landmark")) {
			wcl.acceptAlert();
			rem.enterlandmark(retailerdata.get("Landmark"));

		}
		rem.Clickokbtn();
		Thread.sleep(500);
		if (wcl.getAlertmsg().equalsIgnoreCase("Select city")) {
			wcl.acceptAlert();
			rem.selectCity(retailerdata.get("City"));
			
		}

		rem.Clickokbtn();
		Thread.sleep(500);
		if (wcl.getAlertmsg().equalsIgnoreCase("Select State")) {
			wcl.acceptAlert();
			rem.selectstate(retailerdata.get("State"));

		}
		rem.enterpinCode(retailerdata.get("PinCode"));

		rem.Clickokbtn();
		Thread.sleep(500);
		if (wcl.getAlertmsg().equalsIgnoreCase("Please Enter Phone Number")) {
			wcl.acceptAlert();
			rem.enterphNo(retailerdata.get("PhoneNumber"));

		}
		rem.enterAltPhNo(retailerdata.get("AltPhoneNumber"));
		rem.enterFaxNo(retailerdata.get("FaxNumber"));
		rem.enteremailId(retailerdata.get("Email"));

		rem.Clickokbtn();

		rem.clickcontactpersonLink();
		rem.selectcontactpersonTitle(retailerdata.get("ContaocPersonTitle"));
		rem.entercontactpersonName(retailerdata.get("ContaocPersonName"));
		rem.entercontactpersonLastName(retailerdata.get("ContaocPersonLastName"));
		rem.clickcontpersonpopupaddressLink();
		rem.Clickokbtn();
		Thread.sleep(500);
		if (wcl.getAlertmsg().equalsIgnoreCase("Enter Shop Building Name")) {
			wcl.acceptAlert();
			rem.entereshopName(retailerdata.get("ShopName"));

		}

		rem.Clickokbtn();
		Thread.sleep(500);
		if (wcl.getAlertmsg().equalsIgnoreCase("Enter Street")) {
			wcl.acceptAlert();
			rem.enterstreetAdds(retailerdata.get("StreetName"));

		}

		rem.Clickokbtn();
		Thread.sleep(500);
		if (wcl.getAlertmsg().equalsIgnoreCase("Enter Landmark")) {
			wcl.acceptAlert();
			rem.enterlandmark(retailerdata.get("Landmark"));

		}
		rem.Clickokbtn();
		Thread.sleep(500);
		if (wcl.getAlertmsg().equalsIgnoreCase("Select city")) {
			wcl.acceptAlert();
			rem.selectCity(retailerdata.get("City"));

		}

		rem.Clickokbtn();
		Thread.sleep(500);
		if (wcl.getAlertmsg().equalsIgnoreCase("Select State")) {
			wcl.acceptAlert();
			rem.selectstate(retailerdata.get("State"));

		}
		rem.enterpinCode(retailerdata.get("PinCode"));

		rem.Clickokbtn();
		Thread.sleep(500);
		if (wcl.getAlertmsg().equalsIgnoreCase("Please Enter Phone Number")) {
			wcl.acceptAlert();
			rem.enterphNo(retailerdata.get("PhoneNumber"));

		}
		rem.enterAltPhNo(retailerdata.get("AltPhoneNumber"));
		rem.enterFaxNo(retailerdata.get("FaxNumber"));
		rem.enteremailId(retailerdata.get("Email"));

		rem.Clickokbtn();
		Thread.sleep(200);
		rem.clickcontpersonpopupsubmitbtn();
		Thread.sleep(500);
		if (wcl.getAlertmsg().contains("Saved successfully")) {
			wcl.acceptAlert();
			Thread.sleep(500);
		}
		
		rem.entercustTinno(retailerdata.get("TinNo"));
		rem.selectcustTaxType(retailerdata.get("TaxType"));
		rem.selectCustBillseries(retailerdata.get("BillSeries"));
		rem.enterCustcreditLimit(retailerdata.get("CreditLimit"));
		
		
		rem.ClickchannehierarchyarrowBtn();
		rem.ClickSavebtn();
		Thread.sleep(500);
		if (wcl.getAlertmsg().equalsIgnoreCase("Click here to set channel hierarchy")) {
			wcl.acceptAlert();
			
			System.err.println();
			rem.selectRetChannel(retailerdata.get("Channel"));
		}

		rem.ClickSavebtn();
		Thread.sleep(500);
		if (wcl.getAlertmsg().equalsIgnoreCase("Please select customer classification.")) {
			wcl.acceptAlert();
			rem.selectRetClassification(retailerdata.get("Classification"));
		}
		Thread.sleep(200);
		rem.selectRetailerBusinessType(retailerdata.get("BusinessType"));
		
		rem.clickonBankdetailsarrowbtn();
		Thread.sleep(500);
		rem.enterbankName(retailerdata.get("BankName"));
		rem.enterBankaccName(retailerdata.get("AccountName"));
		rem.enterBankaccNum(retailerdata.get("AccountNumber"));
		rem.selectBankaccStatus(retailerdata.get("AccountStatus"));
		rem.enterBankbranch(retailerdata.get("BankBrabch"));
		
		rem.ClickReActivatedbtn();
		Thread.sleep(200);
		rem.clickActivebtn();

		rem.ClickSavebtn();
		Thread.sleep(500);
		if (wcl.getAlertmsg().contains("Saved Successfully")) {
			wcl.acceptAlert();
			Thread.sleep(500);
		}
		

		
		home.ClickOnTabClose("Retailer Master");
		logger.info("Successfully created Retailer");

		Thread.sleep(500);
		home.SelectAttribute("Retailers");
		home.enterMainSearchtext(retailerdata.get("BusinessName"));
		home.ClickOnMainSearchBtn();
		home.getPopupDealerName(1);
		home.getPopupDealerCode(1);
		retailerdata.put("BusinessCode", home.getPopupDealerCode(1));
		home.getPopupDealerSalesPerson(1);
		home.getPopupDealerBeat(1);
		home.getPopupDealerPhoneNo(1);
		home.ClickOnveiwinNewTabForDealer(1);
		
		ast.assertEquals(rem.getenteredappointmentDate(),retailerdata.get("appointmentDate"),"Appointment Date not Matching");
		ast.assertEquals(rem.getselectSbu(),retailerdata.get("Sbu"),"SBU Not Matching");
		ast.assertEquals(rem.getMSSISDN(),retailerdata.get("MSSISDN"),"MSSISDN not Matching");
		ast.assertEquals(rem.getentereddedaDate(),retailerdata.get("edaDate"),"Evd Date not Matching");
		ast.assertEquals(rem.getcustName(),retailerdata.get("BusinessName"),"Business Name not Matching");
		ast.assertEquals(rem.getmomoMSSISDN(),retailerdata.get("MOMOMSSISDN"),"MOMOMSSISDN not Matching");
		ast.assertEquals(rem.getselectDsaName(),retailerdata.get("DsaName"),"DSA Name not Matching");
		ast.assertEquals(rem.getselectcustbeat(),retailerdata.get("Route"),"Route Name not Matching");
		ast.assertEquals(rem.getRetailerName(),retailerdata.get("RetailerName"),"Retailer Name not Matching");
		ast.assertEquals(true,rem.isSimRetailerSelected(),"Is sim Retailer Checkbox is not selected");
		rem.ClickAddressLink();
		ast.assertEquals(rem.getshopName(),retailerdata.get("ShopName"),"ShopName not Matching");
		ast.assertEquals(rem.getstreetAdds(),retailerdata.get("StreetName"),"StreetName not Matching");
		ast.assertEquals(rem.getlandmark(),retailerdata.get("Landmark"),"Landmark is not Matching");
		ast.assertEquals(rem.getselectcity(),retailerdata.get("City"),"City is not Matching");
		ast.assertEquals(rem.getselectstate(),retailerdata.get("State"),"State is not Matching");
		ast.assertEquals(rem.getpinCode(),retailerdata.get("PinCode"),"Pincode is not Matching");
		ast.assertEquals(rem.getphNo(),retailerdata.get("PhoneNumber"),"PhoneNo is not Matching");
		ast.assertEquals(rem.getemailId(),retailerdata.get("Email"),"Email is not Matching");
		ast.assertEquals(rem.getAltPhNo(),retailerdata.get("AltPhoneNumber"),"AltPhoneNumber is not Matching");
		ast.assertEquals(rem.getFaxNo(),retailerdata.get("FaxNumber"),"FaxNumber is not Matching");
		rem.clickXbtn();
		Thread.sleep(500);
		
		ast.assertEquals(rem.getconPersonTitleOnMainScreen(),retailerdata.get("ContaocPersonTitle"),"Title is not Matching");
		ast.assertEquals(rem.getconPersonNameOnMainScreen(),retailerdata.get("ContaocPersonName")+""+retailerdata.get("ContaocPersonLastName"),"Title is not Matching");
		rem.clickoncontperName();
		//rem.clickcontactpersonLink();
		ast.assertEquals(rem.getselectedcontactpersonTitle(),retailerdata.get("ContaocPersonTitle"),"Title is not Matching");
		ast.assertEquals(rem.getcontactpersonName(),retailerdata.get("ContaocPersonName"),"Name is not Matching");
		ast.assertEquals(rem.getcontactpersonLastName(),retailerdata.get("ContaocPersonLastName"),"LastName is not Matching");
		rem.clickcontpersonpopupaddressLink();
		ast.assertEquals(rem.getshopName(),retailerdata.get("ShopName"),"ShopName not Matching");
		ast.assertEquals(rem.getstreetAdds(),retailerdata.get("StreetName"),"StreetName not Matching");
		ast.assertEquals(rem.getlandmark(),retailerdata.get("Landmark"),"Landmark is not Matching");
		ast.assertEquals(rem.getselectcity(),retailerdata.get("City"),"City is not Matching");
		ast.assertEquals(rem.getselectstate(),retailerdata.get("State"),"State is not Matching");
		ast.assertEquals(rem.getpinCode(),retailerdata.get("PinCode"),"Pincode is not Matching");
		ast.assertEquals(rem.getphNo(),retailerdata.get("PhoneNumber"),"PhoneNo is not Matching");
		ast.assertEquals(rem.getemailId(),retailerdata.get("Email"),"Email is not Matching");
		rem.Clickokbtn();
		rem.clickXbtn();
		Thread.sleep(500);
		ast.assertEquals(rem.getcustTinno(),retailerdata.get("TinNo"),"Tinno is not Matching");
		ast.assertEquals(rem.getselectedcustTaxType(),retailerdata.get("TaxType"),"Taxtype is not Matching");
		ast.assertEquals(rem.getselectedCustBillseries(),retailerdata.get("BillSeries"),"Billseries is not Matching");
		ast.assertEquals(rem.getCustcreditLimit(),retailerdata.get("CreditLimit"),"CreditLimit is not Matching");
		rem.ClickchannehierarchyarrowBtn();
		Thread.sleep(200);
		ast.assertEquals(rem.getselectedRetChannel(),retailerdata.get("Channel"),"Retailer channel is not Matching");
		ast.assertEquals(rem.getselectedRetClassification(),retailerdata.get("Classification"),"Retailer classification is not Matching");
		ast.assertEquals(rem.getselectedRetailerBusinessType(),retailerdata.get("BusinessType"),"BusinessType is not matching");
		Thread.sleep(200);
		
		
		rem.clickonBankdetailsarrowbtn();
		Thread.sleep(1000);
		ast.assertEquals(rem.getbankName(),retailerdata.get("BankName"),"BankName is not Matching");
		Thread.sleep(1000);
		ast.assertEquals(rem.getBankaccName(),retailerdata.get("AccountName"),"AccountName is not Matching");
		Thread.sleep(1000);
		ast.assertEquals(rem.getBankaccNum(),retailerdata.get("AccountNumber"),"AccountNumber is not Matching");
		Thread.sleep(1000);
		ast.assertEquals(rem.getselectedBankaccStatus(),retailerdata.get("AccountStatus"),"AccountStatus is not Matching");
		Thread.sleep(1000);
		ast.assertEquals(rem.getBankbranch(),retailerdata.get("BankBrabch"),"BankBrabch is not Matching");
		Thread.sleep(1000);
		rem.ClickReActivatedbtn();
		ast.assertEquals(true,rem.isActivatedSelected(),"Active radiobtn is not selected");
		
		
		ExcelLib retdata = new ExcelLib("./Testdata/Inputdata.xlsx");
		String data[] = {retailerdata.get("BusinessCode"),retailerdata.get("BusinessName"),retailerdata.get("RetailerName"),retailerdata.get("DsaName"),
				retailerdata.get("Route"),retailerdata.get("ShopName"),retailerdata.get("StreetName")};
		retdata.Excelwrite("./Testdata/Inputdata.xlsx", "RetailerMasterCheck", data);
		
		home.ClickOnTabClose("Retailer details");
		ast.assertAll();
		
	}
}
		
		

		
		


