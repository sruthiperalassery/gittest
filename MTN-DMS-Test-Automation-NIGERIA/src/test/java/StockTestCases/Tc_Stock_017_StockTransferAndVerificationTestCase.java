package StockTestCases;

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
public class Tc_Stock_017_StockTransferAndVerificationTestCase extends BaseClassLoader {
	private String[][] productdetails = { { "ADIDAS", "ADIDAS" + "(" + "ADIDAS" + ")", "AD2651",
			"AD2651" + "(" + "AD2651" + ")", "FCA002130033039/42", "459-09112017-449", "1" } };

	String getproddetails, getproductdetails1, getproductdetails;

	String[] indata = { "Pass", "SOCKS", "MAIN", Today(), "More stock" };

	public String[][] getStockdetails() throws Exception {
		Thread.sleep(1500);
		home.ClickOnMenu();
		Thread.sleep(700);
		home.ClickOnStockMenu();
		Thread.sleep(700);
		home.ClickOnSubMenuItem("Stock Browser");
		logger.info("Getting Product Details from Stock Browser");
		stb.ClickonPrintStockPosition();
		stb.selectSBU(indata[1]);
		stb.selectStore(indata[2]);

		for (int i = 0; i < productdetails.length; i++) {
			for (int j = 0; j < productdetails[i].length; j++) {
				if (j == 4) {
					stb.enterProductCode(productdetails[i][j]);
					stb.PopupProductSelect();
					stb.clickOnPopupokBtn();
					stb.clickOnViewBtn();
					Thread.sleep(2000);

					int rows = stb.getNumOfRows();
					for (int k = 1; k <= rows;) {
						if (stb.getStringdatafrommultiplerows(k, 3).contains(productdetails[i][5])) {

							getproddetails = "," + stb.getStringdatafrommultipleProductrowvalue(k, 1) + ","
									+ stb.getStringdatafrommultiplerows(k, 2) + ","
									+ stb.getStringdatafrommultiplerows(k, 3) + ","
									+ stb.getStringdatafrommultiplerows(k, 4) + ","
									+ stb.getStringdatafrommultiplerows(k, 5) + ","
									+ stb.getStringdatafrommultiplerows(k, 6) + ","
									+ stb.getStringdatafrommultiplerows(k, 7) + ","
									+ stb.getStringdatafrommultiplerows(k, 8) + ","
									+ stb.getStringdatafrommultiplerows(k, 9) + ","
									+ stb.getStringdatafrommultiplerows(k, 10) + ","
									+ stb.getStringdatafrommultiplerows(k, 11) + "#";
							getproductdetails += getproddetails;
							Thread.sleep(1000);
							stb.ClickonClearBtn();
							break;
						} else {
							k++;
						}
					}
				} else {
					j++;
				}
			}
		}

		String details[] = getproductdetails.split("#");
		int row = details.length;
		int col = details[row - 1].split(",").length;

		String getDetails[][] = new String[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 1; j < col; j++) {
				getDetails[i][j] = details[i].split(",")[j];
			}
		}

		logger.info("Completed Getting Product Details from Stock Browser");
		home.ClickOnTabClose("Stock Browser");
		Thread.sleep(1000);
		home.acceptAlert();
		return getDetails;
	}

	public String[][] getModifiedStockdetails() throws Exception {
		Thread.sleep(1500);
		home.ClickOnMenu();
		Thread.sleep(700);
		home.ClickOnStockMenu();
		Thread.sleep(700);
		home.ClickOnSubMenuItem("Stock Browser");
		logger.info("Getting Product Details from Stock Browser");
		stb.ClickonPrintStockPosition();
		stb.selectSBU(indata[1]);
		stb.selectStore(indata[2]);

		for (int i = 0; i < productdetails.length; i++) {
			for (int j = 0; j < productdetails[i].length; j++) {
				if (j == 4) {
					stb.enterProductCode(productdetails[i][j]);
					stb.PopupProductSelect();
					stb.clickOnPopupokBtn();
					stb.clickOnViewBtn();
					Thread.sleep(2000);

					int rows = stb.getNumOfRows();
					for (int k = 1; k <= rows;) {
						if (stb.getStringdatafrommultiplerows(k, 3).contains(productdetails[i][5])) {

							getproddetails = "," + stb.getStringdatafrommultipleProductrowvalue(k, 1) + ","
									+ stb.getStringdatafrommultiplerows(k, 2) + ","
									+ stb.getStringdatafrommultiplerows(k, 3) + ","
									+ stb.getStringdatafrommultiplerows(k, 4) + ","
									+ stb.getStringdatafrommultiplerows(k, 5) + ","
									+ stb.getStringdatafrommultiplerows(k, 6) + ","
									+ stb.getStringdatafrommultiplerows(k, 7) + ","
									+ stb.getStringdatafrommultiplerows(k, 8) + ","
									+ stb.getStringdatafrommultiplerows(k, 9) + ","
									+ stb.getStringdatafrommultiplerows(k, 10) + ","
									+ stb.getStringdatafrommultiplerows(k, 11) + "#";
							getproductdetails1 += getproddetails;
							Thread.sleep(1000);
							stb.ClickonClearBtn();
							break;
						} else {
							k++;
						}
					}
				} else {
					j++;
				}
			}
		}

		String details[] = getproductdetails1.split("#");
		int row = details.length;
		int col = details[row - 1].split(",").length;

		String getDetails[][] = new String[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 1; j < col; j++) {
				getDetails[i][j] = details[i].split(",")[j];
			}
		}

		logger.info("Completed Getting Product Details from Stock Browser");
		home.ClickOnTabClose("Stock Browser");
		Thread.sleep(1000);
		home.acceptAlert();
		return getDetails;
	}

	@Test
	public void stockTransfer() throws Exception {

		ExcelLib masterdata = new ExcelLib("./TestData/MasterTestData.xlsx");
		String Stockdetails[][] = getStockdetails();

		Thread.sleep(1000);
		logger.info("Started verifying Stock Transfer");
		Thread.sleep(1500);
		home.ClickOnMenu();
		Thread.sleep(700);
		home.ClickOnStockMenu();
		Thread.sleep(700);
		home.ClickOnSubMenuItem("Stock Transfer");
		
		Thread.sleep(500);
		stktra.clickOnSaveBtn();
		Thread.sleep(500);
		if (wcl.getAlertmsg().contains("Please select SBU")) {
			Thread.sleep(500);
			wcl.acceptAlert();
			stktra.selectSBU(indata[1]);
		} else {
			logger.error(wcl.getAlertmsg());
			Assert.assertEquals(wcl.getAlertmsg(), "Please select SBU");
		}
		Thread.sleep(500);
		stktra.clickOnSaveBtn();
		Thread.sleep(500);
		if (wcl.getAlertmsg().contains("Select Store")) {
			Thread.sleep(500);
			wcl.acceptAlert();
			stktra.selectFromStore(indata[2]);
		} else {
			logger.error(wcl.getAlertmsg());
			Assert.assertEquals(wcl.getAlertmsg(), "Select Store");
		}
		Thread.sleep(500);
		stktra.clickOnSaveBtn();
		Thread.sleep(500);
		if (wcl.getAlertmsg().contains("Select Entity")) {
			Thread.sleep(500);
			wcl.acceptAlert();
			stktra.selectToEntity(masterdata.Excelread("Suppliertestdata", 1));
		} else {
			logger.error(wcl.getAlertmsg());
			Assert.assertEquals(wcl.getAlertmsg(), "Select Entity");
		}
		//Need Modification from Developers
		//Assert.assertEquals(stktra.getOwnerName(), masterdata.Excelread("Suppliertestdata", 1),"Owner Name Not Matching");
		//Assert.assertEquals(stktra.getOwnerAddress(), masterdata.Excelread("Suppliertestdata", 5)+" "+masterdata.Excelread("Suppliertestdata", 6),"Owner Address Not Matching");
		//Assert.assertEquals(stktra.getOwnerCity(), masterdata.Excelread("Suppliertestdata", 8),"Owner City Not Matching");
		//Assert.assertEquals(stktra.getOwnerPhone(), masterdata.Excelread("Suppliertestdata", 10),"Owner PhoneNo Not Matching");
		
		Thread.sleep(500);
		stktra.clickOnSaveBtn();
		Thread.sleep(500);
		if (wcl.getAlertmsg().contains("Enter products")) {
			Thread.sleep(500);
			wcl.acceptAlert();
			stktra.SelectProductCode();
		} else {
			logger.error(wcl.getAlertmsg());
			Assert.assertEquals(wcl.getAlertmsg(), "Enter products");
		}
		
		Thread.sleep(500);
		home.SelectProductsearchokbtn();
		wcl.acceptAlert();
		home.SelectProductsearchCancelbtn();
		//hrs.SelectProductCode();
		home.enterBrandname(productdetails[0][0]);
		Thread.sleep(500);
		home.selectitem(productdetails[0][1]);
		Thread.sleep(500);
		home.enterProductStyle(productdetails[0][2]);
		Thread.sleep(500);
		home.selectitem(productdetails[0][3]);
		Thread.sleep(500);
		// home.SelectproductPackSize(indata);

		home.ClickonproductListBtn();
		for (int i = 1; i <= home.getNumOfProductRows(); i++) {
			if (home.getStringdatafrommultipleProductrows(i, 5).contains(productdetails[0][5])) {
				Assert.assertEquals(home.getStringdatafrommultipleProductrowvalue(i, 1), Stockdetails[0][1],
						"Product Code Not Matching");
				Assert.assertEquals(home.getStringdatafrommultipleProductrows(i, 3), Stockdetails[0][4],
						"Product Code MRP Matching");
				Assert.assertEquals(home.getStringdatafrommultipleProductrows(i, 4), Stockdetails[0][5] + "/0",
						"Product Qty Not Matching");
				home.ClickProductRow(i);
				String proddetails[] = { home.getStringdatafrommultipleProductrowvalue(i, 1),
						home.getStringdatafrommultipleProductrows(i, 2),
						home.getStringdatafrommultipleProductrows(i, 3),
						home.getStringdatafrommultipleProductrows(i, 4),
						home.getStringdatafrommultipleProductrows(i, 5) };
				home.SelectProductsearchokbtn();
				Thread.sleep(500);
				Assert.assertEquals(stktra.getProductCode(), proddetails[0], "Product Code Not Matching");
				Assert.assertEquals(stktra.getProductname(), proddetails[1], "Product Name Not Matching");
				Assert.assertEquals(stktra.getBatchNo(), proddetails[4], "Product Batch No Not Matching");
				Assert.assertEquals(stktra.getProductMRP(), proddetails[2], "Product Code MRP Matching");
				Assert.assertEquals(stktra.getCurrentStockQty() + "/0", proddetails[3], "Product Qty Not Matching");
				Thread.sleep(500);
				break;
			}
		}
		Thread.sleep(500);
		stktra.clickOnSaveBtn();
		if (wcl.getAlertmsg().contains("Please Select the reason")) {
			Thread.sleep(500);
			wcl.acceptAlert();
			Thread.sleep(500);
			stktra.selectReason(indata[4]);
		} else {
			logger.error(wcl.getAlertmsg());
			Assert.assertEquals(wcl.getAlertmsg(), "Please Select the reason");
		}
		Thread.sleep(500);
		stktra.clickOnSaveBtn();
		if (wcl.getAlertmsg().contains("Enter a valid value for  Transfer Qty")) {
			Thread.sleep(500);
			wcl.acceptAlert();
			Thread.sleep(500);
			stktra.enterTransferStockQty(productdetails[0][6]);
		} else {
			logger.error(wcl.getAlertmsg());
			Assert.assertEquals(wcl.getAlertmsg(), "nter a valid value for  Transfer Qty");
		}
		
		stktra.clickOnSaveBtn();
		if (wcl.getAlertmsg().contains("Do you want to save data")) {
			Thread.sleep(500);
			wcl.acceptAlert();
		} else {
			logger.error(wcl.getAlertmsg());
			Assert.assertEquals(wcl.getAlertmsg(), "Do you want to save data");
		}
		String val = wcl.getAlertmsg();
		String reciptno[] = val.split(":");
		Thread.sleep(3000);
		if (wcl.getAlertmsg().contains("Data Saved Successfully")) {
			Thread.sleep(500);
			wcl.acceptAlert();
		} else {
			logger.error(wcl.getAlertmsg());
			Assert.assertEquals(wcl.getAlertmsg(), "Data Saved Successfully");
		}

		String outdata[] = { "Pass", reciptno[1], indata[3], indata[1], indata[2],
				masterdata.Excelread("Suppliertestdata", 1), Stockdetails[0][1], Stockdetails[0][2], Stockdetails[0][3],
				Stockdetails[0][4], Stockdetails[0][5], productdetails[0][6], indata[4] };
		ExcelLib stocktransfer = new ExcelLib("./TestData/StockTestData.xlsx");
		stocktransfer.Excelwrite("./TestData/StockTestData.xlsx", "StockTransferTestData", outdata);
		logger.info("Completed creating  Stock Transfer");
		Thread.sleep(500);
		home.ClickOnTabClose("Stock Transfer");
		String[][] productdetails1 = getModifiedStockdetails();

		for (int j = 0; j < Stockdetails.length; j++) {
			for (int i1 = 0; i1 < Stockdetails[j].length; i1++) {
				if (i1 == 5) {
					Assert.assertEquals(Integer.parseInt(productdetails1[j][i1]),
							Integer.parseInt(Stockdetails[j][i1]) - Integer.parseInt(productdetails[0][6]),
							"Salable stock Qty not Matching");

				} else {
					Assert.assertEquals(productdetails1[j][i1], Stockdetails[j][i1], "Stock Details not Matching");
				}
			}

		}
	}
}
