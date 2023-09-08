package StockTestCases;

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
public class Tc_Stock_016_stockEntryForNonMTNProductsAndVerification extends BaseClassLoader {
	HashMap<String, String> input = new HashMap<String, String>();

	@Test
	public void stockEntryForArticleProductsAndVerification() throws Exception {

		ExcelLib stockentry = new ExcelLib("./TestData/Inputdata.xlsx");

		if (country.equalsIgnoreCase("Nigeria")) {
			Thread.sleep(1500);
			home.ClickonMenutype();
			Thread.sleep(1500);	
		}
		home.ClickOnMenu();
		Thread.sleep(5000);
		home.ClickOnSubMenuItem("Stock Entry");
		logger.info("Started creation and Verification of Stock Entry forNon Mtn");
		Thread.sleep(1000);

		for (int n = 1; n <= 2; n++) {
			input.put("ProductType", stockentry.Excelread("ProductMasterCheck", n, 5));
			input.put("ProductCode", stockentry.Excelread("ProductMasterCheck", n, 0));
			input.put("ProductName", stockentry.Excelread("ProductMasterCheck", n, 2));
			input.put("AMT", stockentry.Excelread("ProductMasterCheck", n, 6));
			input.put("nonDescQty", AutoNumericvalue(1));
			input.put("Category","Non Mtn");
			input.put("descFromSerial", AutoNumericvalue(10));
			input.put("descToSerial", input.get("descFromSerial"));
			ste.selectCategory(input.get("Category"));
			ste.enterSku(input.get("ProductCode"));
			ste.clickOnView();

			ast.assertEquals(ste.getRowWiseProductCode(ste.getNumOfRows()), input.get("ProductCode"));
			ast.assertEquals(ste.getRowWiseProductName(ste.getNumOfRows()), input.get("ProductName"));
			ste.enterRowWiseMRP(ste.getNumOfRows(),input.get("AMT"));
			ste.enterRowWiseDTRRate(ste.getNumOfRows(),input.get("AMT"));
			ste.enterRowWiseDLRRate(ste.getNumOfRows(),input.get("AMT"));
			ste.enterRowWisePackDate(ste.getNumOfRows(), Today());
			
			if (input.get("ProductType").equalsIgnoreCase("no")) {
				ste.enterRowWiseQty(1, input.get("nonDescQty"));
			}else {
				ste.ClickonSerialNoLinkAtRow(1);

				if (home.getNumOfRowsInCosecutiveSerialNoTable() == 2) {
					home.enterFromSerialNumbersAtRow(2, input.get("descFromSerial"));
					home.enterToSerialNumbersAtRow(2, input.get("descToSerial"));

					ast.assertEquals(home.checkProductNameIsReadOnlyAtRow(2), true);

					long qty = Long.parseLong(input.get("descToSerial"))
								- Long.parseLong(input.get("descFromSerial")) + 1;
						input.put("PopupProductQty", String.valueOf(qty));
						ast.assertEquals(Long.parseLong(home.getProductQtyAtRow(2)), qty);

					ast.assertEquals(home.checkQtyIsReadOnlyAtRow(2), true);
					input.put("StockEntryQty", home.getProductQtyAtRow(2));

					home.clickSerialNoPopUpOkButton();
				}
			}
			
			
			ste.clickOnSave();
			if (wcl.getAlertmsg().contains("Saved Successfully")) {
				Thread.sleep(500);
				wcl.acceptAlert();
			} else {
				logger.error(wcl.getAlertmsg());
				ast.assertEquals(wcl.getAlertmsg(), "Saved Successfully");
			}

		}
		
		home.ClickOnTabClose("Stock Entry");
	}
}
