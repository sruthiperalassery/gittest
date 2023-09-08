package StockTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.UBQGenericLib.BaseClassLoader;

/**
 * @author Basanagouda
 *
 */
@Listeners(com.UBQGenericLib.SampleListner.class)
public class Tc_Stock_019_StockBrowserClosingStocktestCase extends BaseClassLoader {
	@Test
	public void printClosingStockPreviewandExcelExport() throws Exception {
		String[] idata = { "Pass", "SOCKS", "MAIN", "FCA002130033039/42",Today() };
		logger.info("Entered into Stock Browser Print Closing Good Stock With Avilable Stock CheckBox preview");
		Thread.sleep(1500);
		home.ClickOnMenu();
		Thread.sleep(700);
		home.ClickOnStockMenu();
		Thread.sleep(700);
		home.ClickOnSubMenuItem("Stock Browser");
		stb.selectSBU(idata[1]);
		stb.selectStore(idata[2]);
		stb.ClickonPrintClosingStock();
		stb.enterProductCode(idata[3]);
		stb.PopupProductSelect();
		stb.clickOnPopupokBtn();
		stb.ClickonPrintClosingStockGood();
		stb.enterStockdate(idata[4]);
		stb.ClosingStockAvailableCheckboxSelect();
		Thread.sleep(700);
		stb.ClickonPreviewBtn();
		Thread.sleep(2000);
		stb.closenewwindow();
		logger.info(" Stock Browser Print Closing Good Stock With Avilable Stock CheckBox preview completed successfully");
		home.ClickOnTabClose("Stock Browser");
		wcl.acceptAlert();

		logger.info("Entered into Stock Browser Print Closing Good Stock Without Avilable Stock CheckBox preview");
		Thread.sleep(1500);
		home.ClickOnMenu();
		Thread.sleep(700);
		home.ClickOnStockMenu();
		Thread.sleep(700);
		home.ClickOnSubMenuItem("Stock Browser");
		stb.selectSBU(idata[1]);
		stb.selectStore(idata[2]);
		stb.ClickonPrintClosingStock();
		stb.enterProductCode(idata[3]);
		stb.PopupProductSelect();
		stb.clickOnPopupokBtn();
		stb.ClickonPrintClosingStockGood();
		stb.enterStockdate(idata[4]);
		Thread.sleep(700);
		stb.ClosingStockAvailableCheckboxDeSelect();
		stb.ClickonPreviewBtn();
		Thread.sleep(2000);
		stb.closenewwindow();
		logger.info("Stock Browser Print Closing Good Stock Without Avilable Stock CheckBox preview completed successfully");
		home.ClickOnTabClose("Stock Browser");
		wcl.acceptAlert();

		logger.info("Entered into Stock Browser Print Closing Damage Stock With Avilable Stock CheckBox preview");
		Thread.sleep(1500);
		home.ClickOnMenu();
		Thread.sleep(700);
		home.ClickOnStockMenu();
		Thread.sleep(700);
		home.ClickOnSubMenuItem("Stock Browser");
		stb.selectSBU(idata[1]);
		stb.selectStore(idata[2]);
		stb.ClickonPrintClosingStock();
		stb.enterProductCode(idata[3]);
		stb.PopupProductSelect();
		stb.clickOnPopupokBtn();
		stb.ClickonPrintClosingStockDamage();
		stb.enterStockdate(idata[4]);
		stb.ClosingStockAvailableCheckboxSelect();
		stb.ClickonPreviewBtn();
		Thread.sleep(2000);
		stb.closenewwindow();
		logger.info("Stock Browser Print Closing Damage Stock With Avilable Stock CheckBox preview completed successfully");
		home.ClickOnTabClose("Stock Browser");
		wcl.acceptAlert();

		logger.info("Entered into Stock Browser Print Closing Damage Stock Without Avilable Stock CheckBox preview");
		Thread.sleep(1500);
		home.ClickOnMenu();
		Thread.sleep(700);
		home.ClickOnStockMenu();
		Thread.sleep(700);
		home.ClickOnSubMenuItem("Stock Browser");
		stb.selectSBU(idata[1]);
		stb.selectStore(idata[2]);
		stb.ClickonPrintClosingStock();
		stb.enterProductCode(idata[3]);
		stb.PopupProductSelect();
		stb.clickOnPopupokBtn();
		stb.ClickonPrintClosingStockDamage();
		stb.enterStockdate(idata[4]);
		stb.ClosingStockAvailableCheckboxDeSelect();
		stb.ClickonPreviewBtn();
		Thread.sleep(2000);
		stb.closenewwindow();
		logger.info("Stock Browser Print Closing Damage Stock Without Avilable Stock CheckBox preview completed successfully");
		logger.info("Stock  Browser Test Case for print Closing Stock completed successfully");
		home.ClickOnTabClose("Stock Browser");
		wcl.acceptAlert();

	}

}
