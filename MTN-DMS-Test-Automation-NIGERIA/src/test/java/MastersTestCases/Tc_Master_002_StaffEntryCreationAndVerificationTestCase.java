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
public class Tc_Master_002_StaffEntryCreationAndVerificationTestCase extends BaseClassLoader {
	HashMap<String, String> staffdata = new HashMap<String, String>();

	@Test
	public void StaffEntryCreationAndVerificationtestCase() throws Exception {

		staffdata.put("staffFirstName", Autoalphavalue(10));
		staffdata.put("staffLastName", Autoalphavalue(10));
		staffdata.put("staffCategory", "Channel Field Agent");

		staffdata.put("MOMOAccountId", AutoNumericvalue(10));
		staffdata.put("MOMOMSSISDN", +225+AutoNumericvalue(8));
		staffdata.put("EVDAccountId", AutoNumericvalue(10));
		staffdata.put("EVDMSSISDN", +225+AutoNumericvalue(8));
		staffdata.put("IMEINumber", AutoNumericvalue(15));
		staffdata.put("ShopName", Autoalphavalue(5));
		staffdata.put("StreetName", Autoalphavalue(5));
		staffdata.put("Landmark", Autoalphavalue(8));
		staffdata.put("City", "Not applicable");
		staffdata.put("State", "Not applicable");
		staffdata.put("PinCode", AutoNumericvalue(5));
		staffdata.put("PhoneNumber", +225+AutoNumericvalue(8));
		staffdata.put("FaxNumber", AutoNumericvalue(10));
		staffdata.put("AltPhoneNumber", +225+AutoNumericvalue(8));
		staffdata.put("Email", Autoalphavalue(5) + "@gmail.com");
		staffdata.put("DateOfBirth", Today());
		staffdata.put("DateOfJoining", Today());
		staffdata.put("EffectiveDateOgJoin", Today());
		Thread.sleep(1500);
		//home.ClickonMenutype();
		Thread.sleep(1500);
		home.ClickOnMenu();
		Thread.sleep(500);
		home.ClickOnSubMenuItem("Staff Entry");
		logger.info("Clicked on sub menu item Product Master");
		Thread.sleep(1000);
		se.ClickSavebtn();
		if (wcl.getAlertmsg().equalsIgnoreCase("Select Category")) {
			Thread.sleep(500);
			wcl.acceptAlert();
			se.selectcategory(staffdata.get("staffCategory"));
		}else {
			ast.assertTrue(false, "");
		}

		se.ClickSavebtn();
		if (wcl.getAlertmsg().equalsIgnoreCase("Select title")) {
			Thread.sleep(500);
			wcl.acceptAlert();
			se.selectTitle();
			staffdata.put("staffTitle", se.getselectTitle());
		}
		se.ClickSavebtn();
		if (wcl.getAlertmsg().equalsIgnoreCase("Enter Name")) {
			Thread.sleep(500);
			wcl.acceptAlert();
			se.enterStaffName(staffdata.get("staffFirstName"));

		}

		se.enterStaffLastName(staffdata.get("staffLastName"));
		se.getStaffLastName();
		se.entermomoAccountId(staffdata.get("MOMOAccountId"));
		se.getmomoAccountId();
		se.entermomoMSSISDN(staffdata.get("MOMOMSSISDN"));
		se.getmomoMSSISDN();
		se.enterevdAccountId(staffdata.get("EVDAccountId"));
		se.getevdAccountId();
		se.enterevdMSSISDN(staffdata.get("EVDMSSISDN"));
		se.getevdMSSISDN();
		Thread.sleep(1000);
		se.enterDobDatetoSelect(staffdata.get("DateOfBirth"));
		Thread.sleep(1000);
		se.enterDojDatetoSelect(staffdata.get("DateOfJoining"));
		Thread.sleep(1000);
		se.enteredaDatetoSelect(staffdata.get("EffectiveDateOgJoin"));
		Thread.sleep(1000);

		se.enterIMEInumber(staffdata.get("IMEINumber"));

		se.ClickSavebtn();
		if (wcl.getAlertmsg().equalsIgnoreCase("Enter Address")) {
			Thread.sleep(500);
			wcl.acceptAlert();
			se.ClickAddressBtn();
		}

		se.Clickokbtn();
		if (wcl.getAlertmsg().equalsIgnoreCase("Enter Shop Building Name")) {
			Thread.sleep(500);
			wcl.acceptAlert();
			se.entereshopName(staffdata.get("ShopName"));

		}

		se.Clickokbtn();
		if (wcl.getAlertmsg().equalsIgnoreCase("Enter Street")) {
			Thread.sleep(500);
			wcl.acceptAlert();
			se.enterstreetAdds(staffdata.get("StreetName"));

		}

		se.Clickokbtn();
		if (wcl.getAlertmsg().equalsIgnoreCase("Enter Landmark")) {
			Thread.sleep(500);
			wcl.acceptAlert();
			se.enterlandmark(staffdata.get("Landmark"));

		}
		se.Clickokbtn();
		if (wcl.getAlertmsg().equalsIgnoreCase("Select city")) {
			Thread.sleep(500);
			wcl.acceptAlert();
			se.selectCity(staffdata.get("City"));

		}

		se.Clickokbtn();
		if (wcl.getAlertmsg().equalsIgnoreCase("Select State")) {
			Thread.sleep(500);
			wcl.acceptAlert();
			se.selectstate(staffdata.get("State"));

		}
		se.enterpinCode(staffdata.get("PinCode"));

		se.Clickokbtn();
		if (wcl.getAlertmsg().equalsIgnoreCase("Please Enter Phone Number")) {
			Thread.sleep(500);
			wcl.acceptAlert();
			se.enterphNo(staffdata.get("PhoneNumber"));

		}
		se.enterAltPhNo(staffdata.get("AltPhoneNumber"));
		se.enterFaxNo(staffdata.get("FaxNumber"));
		se.enteremailId(staffdata.get("Email"));
		se.getemailId();
		se.Clickokbtn();
		se.ClickArrowBtn();
		Thread.sleep(500);
		se.ClickActivatedbtn();
		se.ClickSavebtn();
		if (wcl.getAlertmsg().contains("Saved Successfully")) {
			Thread.sleep(500);
			wcl.acceptAlert();
			Thread.sleep(500);
		}

		home.ClickOnTabClose("Staff Entry");
		logger.info("Successfully created Staff");

		
		home.SelectAttribute("Staff Profile");
		home.enterMainSearchtext(staffdata.get("staffFirstName"));
		home.ClickOnMainSearchBtn();

		staffdata.put("Staffcode", home.getPopupStaffCode());
		ast.assertEquals(home.getPopupStaffName(), staffdata.get("staffFirstName"), "Staff firstname not matching");
		ast.assertEquals(home.getPopupStaffCode(), staffdata.get("Staffcode"), "Staffcade not matching");
		ast.assertEquals(home.getPopupStaffType(), staffdata.get("staffCategory"), "staffCategory not matching");
		ast.assertEquals(home.getPopupStaffMobile(), staffdata.get("AltPhoneNumber"), "AltPhoneNumber not matching");
		ast.assertEquals(home.getPopupStaffEmail(), staffdata.get("Email"), "Email not matching");
		home.ClickOnveiwinNewTabForStaff();

		ast.assertEquals(se.getstaffcode(), staffdata.get("Staffcode"), "Staffcode is not matching");
		ast.assertEquals(se.getselectcategory(), staffdata.get("staffCategory"), "Category is not matching");
		ast.assertEquals(se.getselectTitle(), staffdata.get("staffTitle"), "Title is not matching");
		ast.assertEquals(se.getstaffName(), staffdata.get("staffFirstName"), "FirstName is not matching");
		ast.assertEquals(se.getStaffLastName(), staffdata.get("staffLastName"), "LastName is not matching");
		ast.assertEquals(se.getmomoAccountId(), staffdata.get("MOMOAccountId"), "MOMOAccountId is not matching");
		ast.assertEquals(se.getmomoMSSISDN(), staffdata.get("MOMOMSSISDN"), "MOMOMSSISDN is not matching");
		ast.assertEquals(se.getevdAccountId(), staffdata.get("EVDAccountId"), "EVDAccountId is not matching");
		ast.assertEquals(se.getevdMSSISDN(), staffdata.get("EVDMSSISDN"), "EVDMSSISDN is not matching");
		ast.assertEquals(se.getentereddobfield(), staffdata.get("DateOfBirth"), "DOB Date not Matching");
		ast.assertEquals(se.getentereddojfield(), staffdata.get("DateOfJoining"), "DOJ Date not Matching");
		ast.assertEquals(se.getenterededafield(), staffdata.get("EffectiveDateOgJoin"), "EVD Date not Matching");
		ast.assertEquals(staffdata.get("IMEINumber"), se.getIMEInumber());
		se.ClickAddressBtn();
		ast.assertEquals(se.getshopName(), staffdata.get("ShopName"), "ShopName not Matching");
		ast.assertEquals(se.getstreetAdds(), staffdata.get("StreetName"), "StreetName not Matching");
		ast.assertEquals(se.getlandmark(), staffdata.get("Landmark"), "Landmark is not Matching");
		ast.assertEquals(se.getselectcity(), staffdata.get("City"), "City is not Matching");
		ast.assertEquals(se.getselectstate(), staffdata.get("State"), "State is not Matching");
		ast.assertEquals(se.getpinCode(), staffdata.get("PinCode"), "Pincode is not Matching");
		ast.assertEquals(se.getphNo(), staffdata.get("PhoneNumber"), "PhoneNo is not Matching");
		ast.assertEquals(se.getemailId(), staffdata.get("Email"), "Email is not Matching");
		ast.assertEquals(se.getAltPhNo(), staffdata.get("AltPhoneNumber"), "AltPhoneNumber is not Matching");
		ast.assertEquals(se.getFaxNo(), staffdata.get("FaxNumber"), "FaxNumber is not Matching");
		se.clickXbtn();
		se.ClickArrowBtn();
		home.ClickOnTabClose("Staff profile");
		logger.info("sucessfully verified");

		ExcelLib productdata = new ExcelLib("./Testdata/Inputdata.xlsx");
		String data[] = { staffdata.get("Staffcode"), staffdata.get("staffFirstName"), staffdata.get("staffLastName"),
				staffdata.get("IMEINumber") };
		productdata.Excelwrite("./Testdata/Inputdata.xlsx", "StaffMasterCheck", data);
		
		home.ClickOnTabClose("Store Master");
		ast.assertAll();
	}

}
