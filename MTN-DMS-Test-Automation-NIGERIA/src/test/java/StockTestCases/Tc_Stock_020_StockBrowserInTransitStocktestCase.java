package StockTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.UBQGenericLib.BaseClassLoader;

/**
 * @author Basanagouda
 *
 */
@Listeners(com.UBQGenericLib.SampleListner.class)
public class Tc_Stock_020_StockBrowserInTransitStocktestCase extends BaseClassLoader {
	@Test
	public void printInTransitStockPreviewandExcelExport() throws Exception {
		String[] idata = { "Pass", "SOCKS", "MAIN", "FCA002130033039/42",Today(),Today() };
		logger.info("Entered into Stock Browser Print InTansit Stock Preview");
		Thread.sleep(1500);
		home.ClickOnMenu();
		Thread.sleep(700);
		home.ClickOnStockMenu();
		Thread.sleep(700);
		home.ClickOnSubMenuItem("Stock Browser");
		stb.selectSBU(idata[1]);
		stb.selectStore(idata[2]);
		stb.ClickonPrintInTransitStock();
		stb.enterProductCode(idata[3]);
		stb.PopupProductSelect();
		stb.clickOnPopupokBtn();
		Thread.sleep(700);
		stb.enterFromdate(idata[4]);
		stb.enterTodate(idata[5]);
		Thread.sleep(700);
		stb.ClickonPreviewBtn();
		Thread.sleep(2000);
		stb.closenewwindow();
		logger.info("Exit From Stock Browser Print InTansit Stock Preview");
		logger.info("Stock  Browser Test Case for print InTansit Stock completed successfully");
		home.ClickOnTabClose("Stock Browser");
		wcl.acceptAlert();

	}

}
