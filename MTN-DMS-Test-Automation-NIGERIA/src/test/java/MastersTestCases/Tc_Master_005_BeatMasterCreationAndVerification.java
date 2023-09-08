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
public class Tc_Master_005_BeatMasterCreationAndVerification extends BaseClassLoader {
	HashMap<String, String> input = new HashMap<String, String>();

	@Test
	public void BeatMasterAndVerification() throws Exception {

		ExcelLib Beatdata = new ExcelLib("./TestData/Inputdata.xlsx");

	/*	home.ClickonMenutype();
		Thread.sleep(1500);
		*/
		home.ClickOnMenu();
		Thread.sleep(500);
		home.ClickOnSubMenuItem("Cluster Master");
		logger.info("Clicked on sub menu item Cluster Master");
		Thread.sleep(1000);
		beat.ClickOnSearchbtn();
		beat.PopupSelectStore();
		beat.ClickOnOkBtn();

		for (int n = 1; n <= 2; n++) {
			Beatdata.Excelread("StaffMasterCheck", n, 2);
			input.put("StaffName", Beatdata.Excelread("StaffMasterCheck", n, 1));
			Thread.sleep(300);
			beat.selectSalesman(input.get("StaffName"));

			input.put("Description", beat.getBeatDiscription());
			input.put("Dsa", beat.getSalesman());
			input.put("RouteCode", beat.getBeatcode());
			input.put("Sbu", beat.getBeatSBU());
			input.put("RouteType", beat.getBeatType());
			beat.clickonSavebtn();
			if (wcl.getAlertmsg().contains("Data saved successfully")) {
				Thread.sleep(200);
				wcl.acceptAlert();

			}
			beat.EnterTextToSearch(input.get("Description"));
			beat.ClickOnSearchbtn();
			beat.PopupSelectStore();
			beat.ClickOnOkBtn();
			ast.assertEquals(beat.getBeatDiscription(), input.get("Description"), "Description is not Matching");
			ast.assertEquals(beat.getSalesman(), input.get("Dsa"), "Dsa is not Matching");
			ast.assertEquals(beat.getBeatcode(), input.get("RouteCode"), "RouteCode is not Matching");
			ast.assertEquals(beat.getBeatSBU(), input.get("Sbu"), "Sbu is not Matching");
			ast.assertEquals(beat.getBeatType(), input.get("RouteType"), "RouteType is not Matching");

		}
		home.ClickOnTabClose("Route Master");
		ast.assertAll();

	}

}
