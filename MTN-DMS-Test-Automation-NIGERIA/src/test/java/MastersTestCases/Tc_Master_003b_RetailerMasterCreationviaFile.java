package MastersTestCases;

import java.util.HashMap;
/**
 * @author Praneeth
 *
 */

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.UBQGenericLib.BaseClassLoader;
import com.UBQGenericLib.ExcelLib;

@Listeners(com.UBQGenericLib.SampleListner.class)
public class Tc_Master_003b_RetailerMasterCreationviaFile extends BaseClassLoader {
	HashMap<String, String> retailerdata1 = new HashMap<String, String>();

	@Test
	public void RetailerEntryCreationAndVerificationtestCase() throws Exception {
		ExcelLib Retdata1 = new ExcelLib("./TestData/Inputdata.xlsx");

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

		int rows = Retdata1.getlastrownum("RetailerBulkData");
		System.out.println(rows);
		for (int n = 1; n <= 2; n++) {
			retailerdata1.put("SBU", Retdata1.Excelread("RetailerBulkData", n, 0));
			retailerdata1.put("EVD MSISDN", Retdata1.Excelread("RetailerBulkData", n, 1));
			retailerdata1.put("EVD ACCOUNT ID", Retdata1.Excelread("RetailerBulkData", n, 2));
			retailerdata1.put("BUSINESS NAME", Retdata1.Excelread("RetailerBulkData", n, 3));
			retailerdata1.put("RETAILER NAME", Retdata1.Excelread("RetailerBulkData", n, 4));
			retailerdata1.put("DSANAME", Retdata1.Excelread("RetailerBulkData", n, 5));
			retailerdata1.put("ROUTE", Retdata1.Excelread("RetailerBulkData", n, 6));
			retailerdata1.put("MOMO MSISDN", Retdata1.Excelread("RetailerBulkData", n, 7));
			retailerdata1.put("MOMO ACCOUNT ID", Retdata1.Excelread("RetailerBulkData", n, 8));
			retailerdata1.put("SIMSWAP MSISDN", Retdata1.Excelread("RetailerBulkData", n, 9));
			retailerdata1.put("ACTIVATION MSISDN", Retdata1.Excelread("RetailerBulkData", n, 10));
			retailerdata1.put("ShopBuildingName", Retdata1.Excelread("RetailerBulkData", n, 11));
			retailerdata1.put("Street", Retdata1.Excelread("RetailerBulkData", n, 12));
			retailerdata1.put("Land Mark", Retdata1.Excelread("RetailerBulkData", n, 13));
			retailerdata1.put("Village", Retdata1.Excelread("RetailerBulkData", n, 14));
			retailerdata1.put("City", Retdata1.Excelread("RetailerBulkData", n, 15));
			retailerdata1.put("State", Retdata1.Excelread("RetailerBulkData", n, 16));
			retailerdata1.put("Postal code", Retdata1.Excelread("RetailerBulkData", n, 17));
			retailerdata1.put("Phone No", Retdata1.Excelread("RetailerBulkData", n, 18));
			retailerdata1.put("AlternatePhoneNo", Retdata1.Excelread("RetailerBulkData", n, 19));
			retailerdata1.put("FaxNumber", Retdata1.Excelread("RetailerBulkData", n, 20));
			retailerdata1.put("Email", Retdata1.Excelread("RetailerBulkData", n, 21));
			retailerdata1.put("Channel", Retdata1.Excelread("RetailerBulkData", n, 22));
			retailerdata1.put("Classification", Retdata1.Excelread("RetailerBulkData", n, 23));
			retailerdata1.put("BusinessType", Retdata1.Excelread("RetailerBulkData", n, 24));
			retailerdata1.put("appointmentDate", Retdata1.Excelread("RetailerBulkData", n, 25));
			retailerdata1.put("edaDate", Retdata1.Excelread("RetailerBulkData", n, 26));
			retailerdata1.put("ContaocPersonTitle", Retdata1.Excelread("RetailerBulkData", n, 27));
			retailerdata1.put("ContaocPersonName", Retdata1.Excelread("RetailerBulkData", n, 28));
			retailerdata1.put("ContaocPersonLastName", Retdata1.Excelread("RetailerBulkData", n, 29));
			retailerdata1.put("TinNo", Retdata1.Excelread("RetailerBulkData", n, 30));
			// retailerdata1.put("TaxType", Retdata1.Excelread("RetailerBulkData", n, 31));
			// retailerdata1.put("BillSeries",Retdata1.Excelread("RetailerBulkData", n, 32));
			retailerdata1.put("CreditLimit", Retdata1.Excelread("RetailerBulkData", n, 33));
			retailerdata1.put("BankName", Retdata1.Excelread("RetailerBulkData", n, 34));
			retailerdata1.put("AccountName", Retdata1.Excelread("RetailerBulkData", n, 35));
			retailerdata1.put("AccountNumber", Retdata1.Excelread("RetailerBulkData", n, 36));
			retailerdata1.put("AccountStatus", Retdata1.Excelread("RetailerBulkData", n, 37));
			// retailerdata1.put("BankBranch",
			// Retdata1.Excelread("RetailerBulkData", n, 38));

			rem.ClickSavebtn();
			Thread.sleep(500);
			if (wcl.getAlertmsg().equalsIgnoreCase("Please select SBU")) {
				wcl.acceptAlert();
				rem.selectSbu(retailerdata1.get("SBU"));
			}

			Thread.sleep(500);
			rem.enterMSSISDN(retailerdata1.get("EVD MSISDN"));

			Thread.sleep(500);
			rem.enterEVDAccountId(retailerdata1.get("EVD ACCOUNT ID"));

			rem.ClickSavebtn();
			Thread.sleep(500);
			if (wcl.getAlertmsg().equalsIgnoreCase("Please enter the Business Name")) {
				wcl.acceptAlert();
				rem.entercustName(retailerdata1.get("BUSINESS NAME"));
			}

			Thread.sleep(500);
			rem.enterRetailerName(retailerdata1.get("RETAILER NAME"));

			rem.ClickSavebtn();
			Thread.sleep(500);
			if (wcl.getAlertmsg().equalsIgnoreCase("Please select  DSA")) {
				wcl.acceptAlert();
				
				rem.selectDsaName(retailerdata1.get("DSANAME"));
			}

			rem.ClickSavebtn();
			Thread.sleep(500);
			if (wcl.getAlertmsg().equalsIgnoreCase("Please Select Route")) {
				wcl.acceptAlert();
				rem.selectcustbeat(retailerdata1.get("ROUTE"));
			}

			Thread.sleep(500);
			rem.entermomoMSSISDN(retailerdata1.get("MOMO MSISDN"));
			Thread.sleep(500);
			rem.enterMomoAccId(retailerdata1.get("MOMO ACCOUNT ID"));
			Thread.sleep(500);
			rem.enterSimswapMsisdn(retailerdata1.get("SIMSWAP MSISDN"));
			Thread.sleep(500);
			rem.enterActivationMsisdn(retailerdata1.get("ACTIVATION MSISDN"));
			Thread.sleep(500);
			rem.selectcheckboxSimRetailer();

			// rem.ClickSavebtn();
			// Thread.sleep(500);
			// if (wcl.getAlertmsg().equalsIgnoreCase("Please set Address")) {
			// wcl.acceptAlert();
			// rem.ClickAddressLink();
			//
			// }

			rem.ClickAddressLink();
			rem.Clickokbtn();
			Thread.sleep(500);
			if (wcl.getAlertmsg().equalsIgnoreCase("Enter Shop Building Name")) {
				wcl.acceptAlert();
				rem.entereshopName(retailerdata1.get("ShopBuildingName"));

			}

			rem.Clickokbtn();
			Thread.sleep(500);
			if (wcl.getAlertmsg().equalsIgnoreCase("Enter Street")) {
				wcl.acceptAlert();
				rem.enterstreetAdds(retailerdata1.get("Street"));

			}

			rem.Clickokbtn();
			Thread.sleep(500);
			if (wcl.getAlertmsg().equalsIgnoreCase("Enter Landmark")) {
				wcl.acceptAlert();
				rem.enterlandmark(retailerdata1.get("Land Mark"));

			}
			rem.Clickokbtn();
			Thread.sleep(500);
			if (wcl.getAlertmsg().equalsIgnoreCase("Select city")) {
				wcl.acceptAlert();
				rem.selectCity(retailerdata1.get("City"));

			}

			rem.Clickokbtn();
			Thread.sleep(500);
			if (wcl.getAlertmsg().equalsIgnoreCase("Select State")) {
				wcl.acceptAlert();
				rem.selectstate(retailerdata1.get("State"));

			}
			rem.enterpinCode(retailerdata1.get("Postal code"));

			rem.Clickokbtn();
			Thread.sleep(500);
			if (wcl.getAlertmsg().equalsIgnoreCase("Please Enter Phone Number")) {
				wcl.acceptAlert();
				rem.enterphNo(retailerdata1.get("Phone No"));

			}
			rem.enterAltPhNo(retailerdata1.get("AlternatePhoneNo"));
			rem.enterFaxNo(retailerdata1.get("FaxNumber"));
			rem.enteremailId(retailerdata1.get("Email"));

			rem.Clickokbtn();

			rem.clickcontactpersonLink();
			rem.selectcontactpersonTitle(retailerdata1.get("ContaocPersonTitle"));
			rem.entercontactpersonName(retailerdata1.get("ContaocPersonName"));
			rem.entercontactpersonLastName(retailerdata1.get("ContaocPersonLastName"));
			rem.clickcontpersonpopupaddressLink();
			rem.Clickokbtn();
			Thread.sleep(500);
			if (wcl.getAlertmsg().equalsIgnoreCase("Enter Shop Building Name")) {
				wcl.acceptAlert();
				rem.entereshopName(retailerdata1.get("ShopBuildingName"));

			}

			rem.Clickokbtn();
			Thread.sleep(500);
			if (wcl.getAlertmsg().equalsIgnoreCase("Enter Street")) {
				wcl.acceptAlert();
				rem.enterstreetAdds(retailerdata1.get("Street"));

			}

			rem.Clickokbtn();
			Thread.sleep(500);
			if (wcl.getAlertmsg().equalsIgnoreCase("Enter Landmark")) {
				wcl.acceptAlert();
				rem.enterlandmark(retailerdata1.get("Land Mark"));

			}
			rem.Clickokbtn();
			Thread.sleep(500);
			if (wcl.getAlertmsg().equalsIgnoreCase("Select city")) {
				wcl.acceptAlert();
				rem.selectCity(retailerdata1.get("City"));

			}

			rem.Clickokbtn();
			Thread.sleep(500);
			if (wcl.getAlertmsg().equalsIgnoreCase("Select State")) {
				wcl.acceptAlert();
				rem.selectstate(retailerdata1.get("State"));

			}
			rem.enterpinCode(retailerdata1.get("Postal code"));

			rem.Clickokbtn();
			Thread.sleep(500);
			if (wcl.getAlertmsg().equalsIgnoreCase("Please Enter Phone Number")) {
				wcl.acceptAlert();
				rem.enterphNo(retailerdata1.get("Phone No"));

			}
			rem.enterAltPhNo(retailerdata1.get("AlternatePhoneNo"));
			rem.enterFaxNo(retailerdata1.get("FaxNumber"));
			rem.enteremailId(retailerdata1.get("Email"));

			rem.Clickokbtn();
			Thread.sleep(200);
			rem.clickcontpersonpopupsubmitbtn();
			Thread.sleep(500);
			if (wcl.getAlertmsg().contains("Saved successfully")) {
				wcl.acceptAlert();
				Thread.sleep(500);
			}

			rem.entercustTinno(retailerdata1.get("TinNo"));
			rem.selectcustTaxType(retailerdata1.get("TaxType"));
			rem.selectCustBillseries(retailerdata1.get("BillSeries"));
			rem.enterCustcreditLimit(retailerdata1.get("CreditLimit"));

			rem.ClickchannehierarchyarrowBtn();
			rem.ClickSavebtn();
			Thread.sleep(500);
			if (wcl.getAlertmsg().equalsIgnoreCase("Click here to set channel hierarchy")) {
				wcl.acceptAlert();

				System.err.println();
				rem.selectRetChannel(retailerdata1.get("Channel"));
			}

			rem.ClickSavebtn();
			Thread.sleep(500);
			if (wcl.getAlertmsg().equalsIgnoreCase("Please select customer classification.")) {
				wcl.acceptAlert();
				rem.selectRetClassification(retailerdata1.get("Classification"));
			}
			Thread.sleep(200);
			rem.selectRetailerBusinessType(retailerdata1.get("BusinessType"));

			rem.clickonBankdetailsarrowbtn();
			Thread.sleep(500);
			rem.enterbankName(retailerdata1.get("BankName"));
			rem.enterBankaccName(retailerdata1.get("AccountName"));
			rem.enterBankaccNum(retailerdata1.get("AccountNumber"));
			rem.selectBankaccStatus(retailerdata1.get("AccountStatus"));
			rem.enterBankbranch(retailerdata1.get("BankBrabch"));  

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
			home.enterMainSearchtext(retailerdata1.get("BUSINESS NAME"));
			home.ClickOnMainSearchBtn();
			home.getPopupDealerName(1);
			home.getPopupDealerCode(1);
			retailerdata1.put("BusinessCode", home.getPopupDealerCode(1));
			home.getPopupDealerSalesPerson(1);
			home.getPopupDealerBeat(1);
			home.getPopupDealerPhoneNo(1);
			home.ClickOnveiwinNewTabForDealer(1);

			ast.assertEquals(rem.getenteredappointmentDate(), retailerdata1.get("appointmentDate"),
					"Appointment Date not Matching");
			ast.assertEquals(rem.getselectSbu(), retailerdata1.get("SBU"), "SBU Not Matching");
			ast.assertEquals(rem.getMSSISDN(), retailerdata1.get("EVD MSISDN"), "MSSISDN not Matching");
			ast.assertEquals(rem.getEVDAccountId(), retailerdata1.get("EVD ACCOUNT ID"), "EVDAccountId not Matching");
			// ast.assertEquals(rem.getentereddedaDate(),retailerdata1.get("edaDate"),"Evd
			// Date not Matching");
			ast.assertEquals(rem.getcustName(), retailerdata1.get("BUSINESS NAME"), "Business Name not Matching");
			ast.assertEquals(rem.getmomoMSSISDN(), retailerdata1.get("MOMOMSSISDN"), "MOMOMSSISDN not Matching");
			ast.assertEquals(rem.getMomoAccId(), retailerdata1.get("MOMO ACCOUNT ID"), "MOMOMSSISDN not Matching");
			ast.assertEquals(rem.getSimswapMsisdn(), retailerdata1.get("SIMSWAP MSISDN"), "MOMOMSSISDN not Matching");
			ast.assertEquals(rem.getActivationMsisdn(), retailerdata1.get("ACTIVATION MSISDN"),
					"MOMOMSSISDN not Matching");
			ast.assertEquals(rem.getselectDsaName(), retailerdata1.get("DSANAME"), "DSA Name not Matching");
			ast.assertEquals(rem.getselectcustbeat(), retailerdata1.get("Route"), "Route Name not Matching");
			ast.assertEquals(rem.getRetailerName(), retailerdata1.get("RETAILER NAME"), "Retailer Name not Matching");
			ast.assertEquals(true, rem.isSimRetailerSelected(), "Is sim Retailer Checkbox is not selected");
			rem.ClickAddressLink();
			ast.assertEquals(rem.getshopName(), retailerdata1.get("ShopBuildingName"), "ShopName not Matching");
			ast.assertEquals(rem.getstreetAdds(), retailerdata1.get("StreetName"), "StreetName not Matching");
			ast.assertEquals(rem.getlandmark(), retailerdata1.get("Land Mark"), "Landmark is not Matching");
			ast.assertEquals(rem.getselectcity(), retailerdata1.get("City"), "City is not Matching");
			ast.assertEquals(rem.getselectstate(), retailerdata1.get("State"), "State is not Matching");
			ast.assertEquals(rem.getpinCode(), retailerdata1.get("Postal code"), "Pincode is not Matching");
			ast.assertEquals(rem.getphNo(), retailerdata1.get("Phone No"), "PhoneNo is not Matching");
			ast.assertEquals(rem.getemailId(), retailerdata1.get("Email"), "Email is not Matching");
			ast.assertEquals(rem.getAltPhNo(), retailerdata1.get("AltPhoneNumber"), "AltPhoneNumber is not Matching");
			ast.assertEquals(rem.getFaxNo(), retailerdata1.get("FaxNumber"), "FaxNumber is not Matching");
			rem.clickXbtn();
			Thread.sleep(500);

			ast.assertEquals(rem.getconPersonTitleOnMainScreen(), retailerdata1.get("ContaocPersonTitle"),
					"Title is not Matching");
			ast.assertEquals(rem.getconPersonNameOnMainScreen(),
					retailerdata1.get("ContaocPersonName") + "" + retailerdata1.get("ContaocPersonLastName"),
					"Title is not Matching");
			rem.clickoncontperName();
			// rem.clickcontactpersonLink();
			ast.assertEquals(rem.getselectedcontactpersonTitle(), retailerdata1.get("ContaocPersonTitle"),
					"Title is not Matching");
			ast.assertEquals(rem.getcontactpersonName(), retailerdata1.get("ContaocPersonName"),
					"Name is not Matching");
			ast.assertEquals(rem.getcontactpersonLastName(), retailerdata1.get("ContaocPersonLastName"),
					"LastName is not Matching");
			rem.clickcontpersonpopupaddressLink();
			ast.assertEquals(rem.getshopName(), retailerdata1.get("ShopBuildingName"), "ShopName not Matching");
			ast.assertEquals(rem.getstreetAdds(), retailerdata1.get("StreetName"), "StreetName not Matching");
			ast.assertEquals(rem.getlandmark(), retailerdata1.get("Land Mark"), "Landmark is not Matching");
			ast.assertEquals(rem.getselectcity(), retailerdata1.get("City"), "City is not Matching");
			ast.assertEquals(rem.getselectstate(), retailerdata1.get("State"), "State is not Matching");
			ast.assertEquals(rem.getpinCode(), retailerdata1.get("Postal code"), "Pincode is not Matching");
			ast.assertEquals(rem.getphNo(), retailerdata1.get("Phone No"), "PhoneNo is not Matching");
			ast.assertEquals(rem.getAltPhNo(), retailerdata1.get("AltPhoneNumber"), "AltPhoneNumber is not Matching");
			ast.assertEquals(rem.getFaxNo(), retailerdata1.get("FaxNumber"), "FaxNumber is not Matching");
			ast.assertEquals(rem.getemailId(), retailerdata1.get("Email"), "Email is not Matching");
			rem.Clickokbtn();
			rem.clickXbtn();
			Thread.sleep(500);
			ast.assertEquals(rem.getcustTinno(), retailerdata1.get("TinNo"), "Tinno is not Matching");
			ast.assertEquals(rem.getselectedcustTaxType(), retailerdata1.get("TaxType"), "Taxtype is not Matching");
			ast.assertEquals(rem.getselectedCustBillseries(), retailerdata1.get("BillSeries"),
					"Billseries is not Matching");
			ast.assertEquals(rem.getCustcreditLimit(), retailerdata1.get("CreditLimit"), "CreditLimit is not Matching");
			rem.ClickchannehierarchyarrowBtn();
			Thread.sleep(200);
			ast.assertEquals(rem.getselectedRetChannel(), retailerdata1.get("Channel"),
					"Retailer channel is not Matching");
			ast.assertEquals(rem.getselectedRetClassification(), retailerdata1.get("Classification"),
					"Retailer classification is not Matching");
			ast.assertEquals(rem.getselectedRetailerBusinessType(), retailerdata1.get("BusinessType"),
					"BusinessType is not matching");
			Thread.sleep(200);

			rem.clickonBankdetailsarrowbtn();
			Thread.sleep(1000);
			ast.assertEquals(rem.getbankName(), retailerdata1.get("BankName"), "BankName is not Matching");
			Thread.sleep(1000);
			ast.assertEquals(rem.getBankaccName(), retailerdata1.get("AccountName"), "AccountName is not Matching");
			Thread.sleep(1000);
			ast.assertEquals(rem.getBankaccNum(), retailerdata1.get("AccountNumber"), "AccountNumber is not Matching");
			Thread.sleep(1000);
			ast.assertEquals(rem.getselectedBankaccStatus(), retailerdata1.get("AccountStatus"),
					"AccountStatus is not Matching");
			Thread.sleep(1000);
			ast.assertEquals(rem.getBankbranch(), retailerdata1.get("BankBrabch"), "BankBrabch is not Matching");
			Thread.sleep(1000);
			rem.ClickReActivatedbtn();
			ast.assertEquals(true, rem.isActivatedSelected(), "Active radiobtn is not selected");

			
			
			home.ClickOnTabClose("Retailer details");
			ast.assertAll();

		}
	}
}