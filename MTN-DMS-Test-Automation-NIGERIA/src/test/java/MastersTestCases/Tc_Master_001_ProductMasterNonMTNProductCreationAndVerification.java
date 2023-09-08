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
public class Tc_Master_001_ProductMasterNonMTNProductCreationAndVerification extends BaseClassLoader {
	HashMap<String, String> input = new HashMap<String, String>();

	@Test
	public void nonMTNProductCreationAndVerificationtestCase() throws Exception {

		

		Thread.sleep(1500);
		home.ClickOnMenu();
		Thread.sleep(500);
		home.ClickOnSubMenuItem("Product Master");
		logger.info("Clicked on sub menu item Product Master");
		Thread.sleep(1000);
            
		for (int n = 1; n <= 2; n++) {
			if (n ==1) {
				input.put("prodType", "yes");
			}else {
				input.put("prodType", "no");
			}
            prm.selectSBU("MTN");
			prm.selectCompany("Non MTN");
			input.put("descProductCode", AutoNumericvalue(5));
			input.put("descProductName", Autoalphavalue(10));
			input.put("peicesInBox", "1");
			
            prm.enterSkuCode(input.get("descProductCode"));
			prm.enterCustomCode(input.get("descProductCode"));
			prm.enterSkuName(input.get("descProductName"));
		    prm.enterShortName(input.get("descProductName"));
	
			if (input.get("prodType").equalsIgnoreCase("yes")) {
				prm.serializedcheckboxselected(input.get("prodType"));
			}
			prm.enterPiecesinbox(input.get("peicesInBox"));
			prm.selectStatus("Active");
			Thread.sleep(1000);
			prm.savebtn();
			if (wcl.getAlertmsg().contains("Are you sure you want to save?")) {
				Thread.sleep(500);
				wcl.acceptAlert();
			}
			if (wcl.getAlertmsg().contains("Data saved successfully")) {
				wcl.acceptAlert();
				Thread.sleep(500);
				
			}
			prm.entersearchTxt(input.get("descProductCode"));
			prm.getsearchTxt();
			prm.SearchBtn();
			prm.SelectPopupProductCode();
			prm.Clickokbtn();
            ast.assertEquals(prm.getSkucode(), input.get("descProductCode"));
			ast.assertEquals(prm.getCustomCode(), input.get("descProductCode"));
			ast.assertEquals(prm.getSkuName(), input.get("descProductName"));
			ast.assertEquals(prm.getShortName(), input.get("descProductName"));
			ast.assertEquals(prm.getPiecesinbox(), input.get("peicesInBox"));
			
			
			prm.Clearbtn();
			if (wcl.getAlertmsg().contains("You will lose all unsaved data. Continue?")) {
				Thread.sleep(500);
				wcl.acceptAlert();
			}
			
			if (wcl.getAlertmsg().contains("Selected action will discard any entered data. Continue?")) {
				Thread.sleep(500);
				wcl.acceptAlert();
			}
			
			
			
			if (n ==1) {
				ExcelLib productdata = new ExcelLib("./Testdata/Inputdata.xlsx");
				String data[] = {input.get("descProductCode"),input.get("descProductCode"),input.get("descProductName"),input.get("descProductName"),
						 input.get("peicesInBox"),input.get("prodType")};
				productdata.Excelwrite("./Testdata/Inputdata.xlsx", "ProductMasterCheck", data);
			}else {
				input.put("prodType", "no");
				ExcelLib productdata = new ExcelLib("./Testdata/Inputdata.xlsx");
				String data1[] = {input.get("descProductCode"),input.get("descProductCode"),input.get("descProductName"),input.get("descProductName"),
						 input.get("peicesInBox"),input.get("prodType")};
				productdata.Excelwrite("./Testdata/Inputdata.xlsx", "ProductMasterCheck", data1);
			}
			
			
		}
		
		home.ClickOnTabClose("Product Master");
		logger.info("Successfully created nonMTN products");
		ast.assertAll();

		
		
	}

}
