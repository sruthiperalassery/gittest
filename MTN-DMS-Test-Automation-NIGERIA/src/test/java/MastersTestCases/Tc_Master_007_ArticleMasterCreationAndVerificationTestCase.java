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
public class Tc_Master_007_ArticleMasterCreationAndVerificationTestCase extends BaseClassLoader {
	HashMap<String, String> articledata = new HashMap<String, String>();
	ExcelLib article = new ExcelLib("./Testdata/Inputdata.xlsx");

	@Test
	public void ArticleCreationAndVerificationTestCase() throws Exception {

		articledata.put("ArticleCode", "Article" + " " + AutoNumericvalue(3));
		articledata.put("ArticleName", Autoalphavalue(8));
		articledata.put("Qty", AutoNumericvalue(2));

		if (country.equalsIgnoreCase("Nigeria")) {
			Thread.sleep(1500);
			home.ClickonMenutype();
			Thread.sleep(1500);
		}
		Thread.sleep(500);
		home.ClickOnMenu();
		Thread.sleep(500);
		home.ClickOnSubMenuItem("Article Master");
		Thread.sleep(500);

		art.enterArticleCode(articledata.get("ArticleCode"));
		Thread.sleep(200);
		art.enterArticleName(articledata.get("ArticleName"));
		Thread.sleep(200);
		art.clickOnSaveBtn();
		if (wcl.getAlertmsg().contains("Are you sure you want to save?")) {
			wcl.acceptAlert();
			Thread.sleep(500);
		}
		if (wcl.getAlertmsg().contains("Data saved successfully")) {
			wcl.acceptAlert();
			Thread.sleep(500);
		}
		Thread.sleep(200);
		art.enterTextToSearch(articledata.get("ArticleCode"));
		Thread.sleep(200);
		art.clickOnSearchBtn();
		Thread.sleep(200);
		art.clickOnArticleNameAtRow(1);
		Thread.sleep(200);
		art.clickOnArticlePopupOkBtn();
		Thread.sleep(200);
		ast.assertEquals(art.getArticleCode(), articledata.get("ArticleCode"), "Article code not matching");
		ast.assertEquals(art.getArticleName(), articledata.get("ArticleName"), "Article Nmae not matching");
		art.clickOnClearBtn();

		String data[] = { articledata.get("ArticleCode"), articledata.get("ArticleName"), articledata.get("Qty")  };
		article.Excelwrite("./Testdata/Inputdata.xlsx", "ArticleMasterCheck", data);

		home.ClickOnTabClose("Article Master");
		ast.assertAll();

	}

	@Test(dependsOnMethods = "ArticleCreationAndVerificationTestCase")
	public void stockEntryForArticleProductsAndVerificationTestCase() throws Exception {

		
		home.ClickOnMenu();
		Thread.sleep(5000);
		home.ClickOnSubMenuItem("Stock Entry");
		logger.info("Started creation and Verification of Stock Entry forNon Mtn");
		Thread.sleep(1000);

		for (int n = 1; n < 2; n++) {
			articledata.put("ArticleCode", article.Excelread("ArticleMasterCheck", n, 0));
			articledata.put("ArticleName", article.Excelread("ArticleMasterCheck", n, 1));
			articledata.put("Category", "Free Article");
			articledata.put("Qty", article.Excelread("ArticleMasterCheck", n, 2));

			ste.selectCategory(articledata.get("Category"));
			ste.enterSku(articledata.get("ArticleCode"));
			ste.clickOnView();
			ast.assertEquals(ste.getRowWiseProductCode(ste.getNumOfRows()), articledata.get("ArticleCode"));
			ast.assertEquals(ste.getRowWiseProductName(ste.getNumOfRows()), articledata.get("ArticleName"));
			ste.enterRowWisePackDate(ste.getNumOfRows(), Today());
			ste.enterRowWiseQty(ste.getNumOfRows(), articledata.get("Qty"));
			
		
			
			
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
		ast.assertAll();
	}

	@Test(dependsOnMethods = "stockEntryForArticleProductsAndVerificationTestCase")
	public void StockBrowserArticleMasterVerificationTestCase() throws Exception {
		

		Thread.sleep(1500);
		home.ClickOnMenu();
		Thread.sleep(500);
		home.ClickOnSubMenuItem("Stock Browser");
		logger.info("Clicked on sub menu item View Stock");
		Thread.sleep(1000);

		for (int n = 1; n < 2; n++) {
			ast.assertEquals(stb.getSBU(), "MTN");
			ast.assertEquals(stb.getStore(), "MAIN");
			articledata.put("ArticleCode", article.Excelread("ArticleMasterCheck", n, 0));
			articledata.put("ArticleName", article.Excelread("ArticleMasterCheck", n, 1));
			articledata.put("ArticleBatchNo", "0");
			articledata.put("ArticleMRP", "0");
			articledata.put("ArticleSalableStock",  article.Excelread("ArticleMasterCheck", n, 2));
			articledata.put("ArticleHoldStock", "0");
			articledata.put("ArticleDamageStock", "0");
			articledata.put("ArticleReconsStock", "0");
			articledata.put("ArticleInTransitLoss", "0");
			articledata.put("ArticleMissingStock", "0");
			articledata.put("ArticleStolenStock", "0");
			articledata.put("ArticleBurntStock", "0");
			articledata.put("ArticleCombiStock", "0");
			
			stb.enterProductCode(articledata.get("ArticleCode"));
			Thread.sleep(500);
			stb.PopupProductSelect();
			Thread.sleep(300);
			stb.clickOnViewBtn();

			if (stb.getNumOfMainProductRows() >= 1) {

				for (int i = 1; i <= stb.getNumOfMainProductRows();) {
					ast.assertEquals(stb.getProductCodeAtRow(i), articledata.get("ArticleCode"),
							"Descrite Product Name verification failed");
					ast.assertEquals(stb.getProductNameAtRow(i), articledata.get("ArticleName"),
							"Descrite Product Name verification failed");
					ast.assertEquals(stb.getBatchNoAtRow(i), articledata.get("ArticleBatchNo"),
							"Descrite Product Batch Number verification failed");
					ast.assertEquals(stb.getMRPAtRow(i), articledata.get("ArticleMRP"),
							"Descrite Product MRP verification failed");
					ast.assertEquals(stb.getSalableStockAtRow(i),articledata.get("ArticleSalableStock"),
							"Descrite Product Salable Stock verification failed");
					
					ast.assertEquals(stb.getHoldStockAtRow(i),articledata.get("ArticleHoldStock"),
							"Descrite Product Hold Stock verification failed");
					ast.assertEquals(stb.getDamageStockAtRow(i), articledata.get("ArticleDamageStock"),
							"Descrite Product Damage Stock verification failed");
					ast.assertEquals(stb.getReconsStockAtRow(i), articledata.get("ArticleReconsStock"),
							"Descrite Product Recn. Stock verification failed");
					ast.assertEquals(stb.getInTransitLossAtRow(i), articledata.get("ArticleInTransitLoss"),
							"Descrite Product Recn. Stock verification failed");
					ast.assertEquals(stb.getMissingStockAtRow(i), articledata.get("ArticleMissingStock"),
							"Descrite Product Missing Stock verification failed");
					ast.assertEquals(stb.getStolenStockAtRow(i), articledata.get("ArticleStolenStock"),
							"Descrite Product Stolen. Stock verification failed");
					ast.assertEquals(stb.getBurntStockAtRow(i), articledata.get("ArticleBurntStock"),
							"Descrite Product Burnt Stock verification failed");
					
					ast.assertEquals(stb.getCombiStockAtRow(i), articledata.get("ArticleCombiStock"),
							"Descrite Product Combi Stock verification failed");
					Thread.sleep(500);
					stb.ClickonPrintStockBook();
					Thread.sleep(500);
					stb.ClickonPrintStockPosition();
					break;

				}
			}

		}
		home.ClickOnTabClose("Stock Browser");
		ast.assertAll();

	}
}
