package StockTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.UBQGenericLib.BaseClassLoader;
import com.UBQGenericLib.ExcelLib;

/**
 * @author Basanagouda
 *
 */
@Listeners(com.UBQGenericLib.SampleListner.class)
public class Tc_Stock_018_StockBrowserprintStockPositiontestCase extends BaseClassLoader {
	@Test
	public void printStockPositionview() throws Exception {
		String[] idata = { "Pass", "SOCKS", "MAIN", "FCA002130033039/42" };
		logger.info("Started Stock Browser print Stock Position view");
		Thread.sleep(1500);
		home.ClickOnMenu();
		Thread.sleep(700);
		home.ClickOnStockMenu();
		Thread.sleep(700);
		home.ClickOnSubMenuItem("Stock Browser");
		stb.ClickonPrintStockPosition();
		stb.selectSBU(idata[1]);
		stb.selectStore(idata[2]);
		stb.enterProductCode(idata[3]);
		stb.PopupProductSelect();
		stb.clickOnPopupokBtn();
		stb.clickOnViewBtn();
		int salestock = 0, mrp = 0 , hStock = 0, dStock = 0, rstock = 0, istock = 0, mstock = 0, bstock = 0;
		String batchno = null, productcode = null,productname = null; ;
		for (int i = 1; i <= stb.getNumOfRows(); i++) {
			productcode = stb.getStringdatafrommultipleProductrowvalue(i, 1);
			productname = stb.getStringdatafrommultiplerows(i, 2);
			batchno = stb.getStringdatafrommultiplerows(i, 3);
			mrp = stb.getdatafrommultiplerows(i, 4);
			salestock = salestock + stb.getdatafrommultiplerows(i, 5);
			hStock = hStock + stb.getdatafrommultiplerows(i, 6);
			dStock = dStock + stb.getdatafrommultiplerows(i, 7);
			rstock = rstock + stb.getdatafrommultiplerows(i, 8);
			istock = istock + stb.getdatafrommultiplerows(i, 9);
			mstock = mstock + stb.getdatafrommultiplerows(i, 10);
			bstock = bstock + stb.getdatafrommultiplerows(i, 11);
			String odata[] = { "Pass", "PrintStockPosition", "All", "Main", productcode, productname,batchno,
					Integer.toString(mrp),Integer.toString(salestock), Integer.toString(hStock),
					Integer.toString(dStock), Integer.toString(rstock), Integer.toString(istock),
					Integer.toString(mstock),Integer.toString(bstock)};
			ExcelLib stkbrowser = new ExcelLib("./TestData/StockTestData.xlsx");
			stkbrowser.Excelwrite("./TestData/StockTestData.xlsx", "stockBrowsertestData", odata);
		}
		
		logger.info("Completed Stock Browser print Stock Position view");
		Thread.sleep(800);
		logger.info("Started Stock Browser print Stock Position Preview");
		stb.ClickonPreviewBtn();
		Thread.sleep(2000);
		stb.closenewwindow();
		logger.info("Completed Stock Browser print Stock Position Preview");
		logger.info("Stock  Browser Test Case for print Stock Position completed successfully");
		home.ClickOnTabClose("Stock Browser");
		wcl.acceptAlert();


	}

}
