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
public class Tc_Master_006_PriceMasterViewsAndVerification extends BaseClassLoader {
	HashMap<String, String> input = new HashMap<String, String>();

	@Test
	public void priceMasterViewsAndVerificationTestCase() throws Exception {
		
		ExcelLib stockentry = new ExcelLib("./TestData/Inputdata.xlsx");
		if (country.equalsIgnoreCase("Nigeria")) {
			Thread.sleep(1500);
			home.ClickonMenutype();
			Thread.sleep(1500);	
		}
		Thread.sleep(500);
		home.ClickOnMenu();
		Thread.sleep(500);
		home.ClickOnSubMenuItem("Price Master");
		Thread.sleep(500);
		
		for (int n = 1; n <= 2; n++) {
			input.put("ProductCode", stockentry.Excelread("ProductMasterCheck", n, 0));
			input.put("ProductName", stockentry.Excelread("ProductMasterCheck", n, 2));
			input.put("AMT", stockentry.Excelread("ProductMasterCheck", n, 6));
			input.put("PcsInBox", stockentry.Excelread("ProductMasterCheck", n, 4));
			
			pm.EnterTexttoSearch(input.get("ProductCode"));
			pm.clickSearchBtn();
			pm.clickonPopupProductSelect();
			pm.clickonPopupOktn();
			ast.assertEquals(pm.getEnteredprodcustomcode(), input.get("ProductCode"));
			ast.assertEquals(pm.getEnteredcustomcode(), input.get("ProductCode"));
			ast.assertEquals(pm.getEnteredproductName(), input.get("ProductName"));
			ast.assertEquals(pm.getEnteredPcs(), input.get("PcsInBox"));
			
			
			ast.assertEquals(pm.getMRP(), stockentry.Excelread("ProductMasterCheck", n, 6));
			ast.assertEquals(pm.getDTRRate(), stockentry.Excelread("ProductMasterCheck", n, 6));
			ast.assertEquals(pm.getDTRRateTax(), stockentry.Excelread("ProductMasterCheck", n, 6));
			ast.assertEquals(pm.getDLRRate(), stockentry.Excelread("ProductMasterCheck", n, 6));
			ast.assertEquals(pm.getDLRRateTax(), stockentry.Excelread("ProductMasterCheck", n, 6));
			
		}
		home.ClickOnTabClose("Price Master");
		ast.assertAll();

	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		


