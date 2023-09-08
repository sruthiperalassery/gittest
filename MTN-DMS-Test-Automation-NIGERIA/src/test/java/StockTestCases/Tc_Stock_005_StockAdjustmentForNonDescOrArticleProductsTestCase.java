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
public class Tc_Stock_005_StockAdjustmentForNonDescOrArticleProductsTestCase extends BaseClassLoader {
	HashMap<String, String> articledata = new HashMap<String, String>();

	@Test
	public void stockAdjustmentForNonDescriteOrArticleProductsTestCase() throws Exception {
		ExcelLib article = new ExcelLib("./Testdata/Inputdata.xlsx");

		if (country.equalsIgnoreCase("Nigeria")) {
			Thread.sleep(1500);
			home.ClickonMenutype();
			Thread.sleep(1500);
		}

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
			articledata.put("ArticleSalableStock", article.Excelread("ArticleMasterCheck", n, 2));

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
					ast.assertEquals(stb.getSalableStockAtRow(i), articledata.get("ArticleSalableStock"),
							"Descrite Product Salable Stock verification failed");

					articledata.put("ArticleHoldStock", stb.getHoldStockAtRow(i));
					articledata.put("ArticleDamageStock", stb.getDamageStockAtRow(i));
					articledata.put("ArticleReconsStock", stb.getReconsStockAtRow(i));
					articledata.put("ArticleInTransitLoss", stb.getInTransitLossAtRow(i));
					articledata.put("ArticleMissingStock", stb.getMissingStockAtRow(i));
					articledata.put("ArticleStolenStock", stb.getStolenStockAtRow(i));
					articledata.put("ArticleBurntStock", stb.getBurntStockAtRow(i));
					articledata.put("ArticleCombiStock", stb.getCombiStockAtRow(i));

					Thread.sleep(500);
					stb.ClickonPrintStockBook();
					Thread.sleep(500);
					stb.ClickonPrintStockPosition();
					break;

				}
			}

		}
		home.ClickOnTabClose("Stock Browser");

		Thread.sleep(1500);
		home.ClickOnMenu();

		home.ClickOnSubMenuItem("Stock Adjustment");
		logger.info("Started Stock adjustment and Verification of Stock in stock browser");
		Thread.sleep(1000);

		sadj.selectSBU("MTN");
		sadj.selectStore("MAIN");

		ast.assertEquals(sadj.getDate(), Today());
		articledata.put("Remarks", Autoalphavalue(5));
		articledata.put("Reason", "Missing");
		sadj.enterRemarks(articledata.get("Remarks"));

		int rows = article.getlastrownum("ArticleMasterCheck");
		for (int n = 1; n <= rows; n++) {
			articledata.put("ArticleCode", article.Excelread("ArticleMasterCheck", n, 0));
			articledata.put("ArticleName", article.Excelread("ArticleMasterCheck", n, 1));
			articledata.put("ArticleSalableStock", article.Excelread("ArticleMasterCheck", n, 2));
			articledata.put("ArticleBatchNo", "0");
			articledata.put("ArticleProductMRP", "0");
			articledata.put("ArticleQty", "2");
			if (sadj.getNumOfRows() >= 1) {
				sadj.SelectProductNameAtRow(n);
				if (stb.getNumOfPopupProductRows() >= 1) {
					for (int i = 1; i <= stb.getNumOfPopupProductRows();) {
						if (stb.getPopupProductNameAtRow(i).contains(articledata.get("ArticleName"))
								&& stb.getPopupProductBatchNoAtRow(i).contains(articledata.get("ArticleBatchNo"))
								&& stb.getPopupProductStockQtyAtRow(i)
										.contains(articledata.get("ArticleSalableStock"))) {
							stb.ClickOnPopupProductCodeAtRow(i);
							stb.clickOnPopupokBtn();
							break;
						} else {
							i++;
						}
					}

				} else {
					ast.assertEquals(stb.getNumOfPopupProductRows(), "Popup Products Number Of rows Not Matching");
				}

				ast.assertEquals(articledata.get("ArticleCode"), sadj.getRowWiseProductCode(n),
						"Popup Product code and Main Product Code is not matching");
				ast.assertEquals(articledata.get("ArticleName"), sadj.getRowWiseProductName(n),
						"Popup Product Name and Main Product Name is not matching");
				ast.assertEquals(articledata.get("ArticleBatchNo"), sadj.getRowWiseBatchNo(n),
						"Popup Product Batch Number  and Main Product Batch Number is not matching");
				ast.assertEquals(articledata.get("PopupProductMRP"), sadj.getRowWiseMRP(n),
						"Popup Product MRP and Main Product MRP is not matching");
				
				sadj.enterQtyatRow(n, articledata.get("ArticleQty"));
				Thread.sleep(500);
				sadj.selectReasonatRow(n, articledata.get("Reason"));

			}

		}
		sadj.clickOnSaveBtn();
		if (wcl.getAlertmsg().contains("Data Saved Successfully")) {
			Thread.sleep(200);
			wcl.acceptAlert();
			logger.info("Stock adjustment case completed");

		} else {
			System.err.println(wcl.getAlertmsg());
		}
		home.ClickOnTabClose("Stock Adjustment");
		Thread.sleep(1500);
		home.ClickOnMenu();
		Thread.sleep(500);
		home.ClickOnSubMenuItem("Stock Browser");
		logger.info("Clicked on sub menu item View Stock");
		Thread.sleep(1000);

		for (int n = 1; n < 2; n++) {
			ast.assertEquals(stb.getSBU(), "MTN");
			ast.assertEquals(stb.getStore(), "MAIN");
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
					ast.assertEquals(stb.getSalableStockAtRow(i),
							String.valueOf(Integer.parseInt(articledata.get("ArticleSalableStock"))
									- Integer.parseInt(articledata.get("ArticleQty"))),
							"Descrite Product Salable Stock verification failed");

					ast.assertEquals(stb.getHoldStockAtRow(i), articledata.get("ArticleHoldStock"),
							"Descrite Product Hold Stock verification failed");
					ast.assertEquals(stb.getDamageStockAtRow(i), articledata.get("ArticleDamageStock"),
							"Descrite Product Damage Stock verification failed");
					ast.assertEquals(stb.getReconsStockAtRow(i), articledata.get("ArticleReconsStock"),
							"Descrite Product Recn. Stock verification failed");
					ast.assertEquals(stb.getInTransitLossAtRow(i), articledata.get("ArticleInTransitLoss"),
							"Descrite Product Recn. Stock verification failed");
					if (articledata.get("Reason").equalsIgnoreCase("Missing")) {
						ast.assertEquals(stb.getMissingStockAtRow(i),
								String.valueOf(Integer.parseInt(articledata.get("ArticleMissingStock"))
										+ Integer.parseInt(articledata.get("ArticleQty"))),
								"Descrite Product Missing Stock verification failed");
						ast.assertEquals(stb.getStolenStockAtRow(i), articledata.get("ArticleStolenStock"),
								"Descrite Product Stolen. Stock verification failed");
						ast.assertEquals(stb.getBurntStockAtRow(i), articledata.get("ArticleBurntStock"),
								"Descrite Product Burnt Stock verification failed");
					} else if (articledata.get("Reason").equalsIgnoreCase("Stolen")) {
						ast.assertEquals(stb.getMissingStockAtRow(i), articledata.get("ArticleMissingStock"),
								"Descrite Product Missing Stock verification failed");
						ast.assertEquals(stb.getStolenStockAtRow(i),
								String.valueOf(Integer.parseInt(articledata.get("ArticleStolenStock"))
										+ Integer.parseInt(articledata.get("ArticleQty"))),
								"Descrite Product Stolen. Stock verification failed");
						ast.assertEquals(stb.getBurntStockAtRow(i), articledata.get("ArticleBurntStock"),
								"Descrite Product Burnt Stock verification failed");
					} else {
						ast.assertEquals(stb.getMissingStockAtRow(i), articledata.get("ArticleMissingStock"),
								"Descrite Product Missing Stock verification failed");
						ast.assertEquals(stb.getStolenStockAtRow(i), articledata.get("ArticleStolenStock"),
								"Descrite Product Stolen. Stock verification failed");
						ast.assertEquals(stb.getBurntStockAtRow(i),
								String.valueOf(Integer.parseInt(articledata.get("ArticleBurntStock"))
										+ Integer.parseInt(articledata.get("ArticleQty"))),
								"Descrite Product Burnt Stock verification failed");
					}
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
