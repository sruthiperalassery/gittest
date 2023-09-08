package StockTestCases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.UBQGenericLib.BaseClassLoader;
import com.UBQGenericLib.ExcelLib;

/**
 * @author Basanagouda
 *
 */

@Listeners(com.UBQGenericLib.SampleListner.class)
public class Tc_Stock_006_StockEntryForArticleProductsAndVerificationTestCase extends BaseClassLoader {
	HashMap<String, String> input = new HashMap<String, String>();

	@Test
	public void stockEntryForArticleProductsAndVerification() throws Exception {

		ExcelLib exl = new ExcelLib("./TestData/MasterTestData.xlsx");

		input.put("ArticleCode", exl.Excelread("ArticleData", 1));
		input.put("ArticleName", exl.Excelread("ArticleData", 2));
		input.put("Status", "Passed");
		input.put("Pkd", Today());
		input.put("Qty", "10");
		input.put("SBU", "MTN");
		input.put("Company", "All");
		input.put("Store", "MAIN");

		Thread.sleep(1500);
		home.ClickonMenutype();
		Thread.sleep(1500);
		home.ClickOnMenu();

		home.ClickOnSubMenuItem("Stock Entry");
		logger.info("Started creation and Verification of Stock Entry for Article");
		Thread.sleep(1000);

		ste.enterSku(input.get("ArticleCode"));
		ste.clickOnView();

		if (ste.getNumOfRows() == 1) {
			Assert.assertEquals(ste.getRowWiseProductCode(ste.getNumOfRows()), input.get("ArticleCode"));
			Assert.assertEquals(ste.getRowWiseProductName(ste.getNumOfRows()), input.get("ArticleName"));

			ste.enterRowWisePackDate(1, input.get("Pkd"));
			Thread.sleep(1000);
			if (ste.serialNoIsDisabledOrNot(1)) {
				if (ste.QtyFieldISEnabledOrNot(1)) {
					ste.enterRowWiseQty(1, input.get("Qty"));
					ste.clickOnSave();
				} else {
					Assert.assertTrue(false, "Qty field is disabled");
				}
			} else {
				Assert.assertTrue(false, "Serialnos link is enabled");
			}

		} else {
			Assert.assertTrue(false, "Number of articles not Matching");
		}

		if (wcl.getAlertmsg().contains("Saved Successfully")) {
			Thread.sleep(500);
			wcl.acceptAlert();
		} else {
			logger.error(wcl.getAlertmsg());
			Assert.assertEquals(wcl.getAlertmsg(), "Saved Successfully");
		}
  
		home.ClickOnTabClose("Stock Entry");

		logger.info("Completed creation and Verification of Stock Entry for Article");

		String indata[] = { input.get("Status").toString(), input.get("ArticleCode").toString(),
				input.get("ArticleName").toString(), input.get("Pkd").toString() , input.get("Qty").toString() };

		ExcelLib stk = new ExcelLib("./TestData/StockTestData.xlsx");
		 stk.Excelwrite("./TestData/StockTestData.xlsx", "ArticlestockData", indata);

		
		Thread.sleep(1500);
		home.ClickOnMenu();

		home.ClickOnSubMenuItem("Stock Browser");
		logger.info("Started to get Product Details based on given inputs");
		Thread.sleep(1000);

		Assert.assertEquals(stb.getSBU(), input.get("SBU"));
		Assert.assertEquals(stb.getCompany(),input.get("Company"));
		Assert.assertEquals(stb.getStore(), input.get("Store"));

		stb.enterProductCode(input.get("ArticleCode"));
		Thread.sleep(1000);
		stb.PopupProductSelect();
		stb.clickOnViewBtn();

		System.out.println(stb.getNumOfMainProductRows());
		if (stb.getNumOfMainProductRows() >= 1) {

			for (int i = 1; i <= stb.getNumOfMainProductRows();) {
				if (stb.getProductCodeAtRow(i).contains(input.get("ArticleCode"))
						&& stb.getBatchNoAtRow(i).contains("0")
						&& stb.getMRPAtRow(i).contains("0")) {
					Assert.assertEquals(stb.getProductNameAtRow(i), input.get("ArticleName"));
					Assert.assertEquals(stb.getPcsinCaseBoxAtRow(i),"1");
					Assert.assertEquals(stb.getSalableStockAtRow(i),input.get("Qty"));
					Assert.assertEquals(stb.getHoldStockAtRow(i), "0");
					Assert.assertEquals(stb.getDamageStockAtRow(i),"0");
					Assert.assertEquals(stb.getReconsStockAtRow(i), "0");
					Assert.assertEquals(stb.getInTransitLossAtRow(i), "0");
					Assert.assertEquals(stb.getMissingStockAtRow(i), "0");
					Assert.assertEquals(stb.getStolenStockAtRow(i), "0");
					Assert.assertEquals(stb.getBurntStockAtRow(i), "0");
					Assert.assertEquals(stb.getCombiStockAtRow(i), "0");
					
					break;
				} else {
					if (i <= stb.getNumOfMainProductRows()) {
						i++;
					} else {
						Assert.assertEquals(false, "Product Details not found for given Inputs");
					}

				}
			}
		} else {
			Assert.assertEquals(false, "Product Details not found for given Inputs");
		}
		
		home.ClickOnTabClose("Stock Browser");
		wcl.acceptAlert();
		logger.info("Completed getting Product Details based on given inputs");


	}

}
