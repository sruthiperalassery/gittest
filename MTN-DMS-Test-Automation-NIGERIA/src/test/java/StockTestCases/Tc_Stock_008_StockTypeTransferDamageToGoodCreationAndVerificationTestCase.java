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
public class Tc_Stock_008_StockTypeTransferDamageToGoodCreationAndVerificationTestCase extends BaseClassLoader {
	HashMap<String, String> input = new HashMap<String, String>();

	@Test
	public void stockTypeTransferDamageToGoodCreationAndVerification() throws Exception {
		input.put("SBU", "MTN");
		input.put("Company", "All");
		input.put("Status", "Passed");
		input.put("Store", "MAIN");
		input.put("Date", Today());
		input.put("ProductCode", "VOUC01000");
		input.put("ProductBatchNo", "1000");
		input.put("ProductMRP", "1000");
		input.put("OptionType", "Damage to Good");

		Thread.sleep(1500);
		home.ClickOnMenu();

		home.ClickOnSubMenuItem("Stock Browser");
		logger.info("Started to get Product Details based on given inputs");
		Thread.sleep(1000);

		Assert.assertEquals(stb.getSBU(), input.get("SBU"));
		Assert.assertEquals(stb.getCompany(), input.get("Company"));
		Assert.assertEquals(stb.getStore(), input.get("Store"));

		stb.enterProductCode(input.get("ProductCode"));
		Thread.sleep(1000);
		stb.PopupProductSelect();
		stb.clickOnViewBtn();

		System.out.println(stb.getNumOfMainProductRows());
		if (stb.getNumOfMainProductRows() >= 1) {

			for (int i = 1; i <= stb.getNumOfMainProductRows();) {
				if (stb.getProductCodeAtRow(i).contains(input.get("ProductCode"))
						&& stb.getBatchNoAtRow(i).contains(input.get("ProductBatchNo"))
						&& stb.getMRPAtRow(i).contains(input.get("ProductMRP"))) {
					input.put("ProductName", stb.getProductNameAtRow(i));
					input.put("PcsinCaseBox", stb.getPcsinCaseBoxAtRow(i));
					input.put("ProductSalableStock", stb.getSalableStockAtRow(i));
					input.put("HoldStock", stb.getHoldStockAtRow(i));
					input.put("DamageStock", stb.getDamageStockAtRow(i));
					input.put("ReconsStock", stb.getReconsStockAtRow(i));
					input.put("InTransitLoss", stb.getInTransitLossAtRow(i));
					input.put("MissingStock", stb.getMissingStockAtRow(i));
					input.put("StolenStock", stb.getStolenStockAtRow(i));
					input.put("BurntStock", stb.getBurntStockAtRow(i));
					input.put("CombiStock", stb.getCombiStockAtRow(i));

					stb.clickOnProductCodeAtRow(i);
					Thread.sleep(1000);
					Assert.assertEquals(stb.getSerialNoPopuptitle(), "Serial Number List for "
							+ input.get("ProductName") + " (" + input.get("ProductCode") + ")");

					if (stb.getNumOfSerialPopupProductRows() >= 1) {
						for (int j = 3; j <= stb.getNumOfSerialPopupProductRows();) {
							if (stb.getSerialPopupCurrentStateAtRow(j).contains("Damaged Stock")) {
								input.put("ProductFromSerialNo", stb.getSerialPopupFromSerialNoAtRow(j));
								input.put("ProductToSerialNo", stb.getSerialPopupFromSerialNoAtRow(j));
								break;
							} else {
								if (j <= stb.getNumOfSerialPopupProductRows()) {
									j++;
								} else {
									Assert.assertEquals(false, "Serial Number Details not found for given Inputs");
								}
							}
						}
					} else {
						Assert.assertEquals(false, "Serial Number Details not found for given Inputs");
					}

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

		stb.ClickOnSerialPopupCloseBtn();

		home.ClickOnTabClose("Stock Browser");
		wcl.acceptAlert();
		logger.info("Completed getting Product Details based on given inputs");
		
		Thread.sleep(1500);
		home.ClickOnMenu();

		home.ClickOnSubMenuItem("Stock Type Transfer");
		logger.info("Started creating and verifying stock type transfer as Good to Damage");
		Thread.sleep(1000);
		
		
		stt.clickOnSaveBtn();
		if (wcl.getAlertmsg().contains("Select SBU")) {
			Thread.sleep(500);
			wcl.acceptAlert();
			stt.selectSBU(input.get("SBU"));
		} else {
			logger.error(wcl.getAlertmsg());
			Assert.assertEquals(wcl.getAlertmsg(), "Select SBU");
		}
		stt.clickOnSaveBtn();
		if (wcl.getAlertmsg().contains("Select Store/Godown")) {
			Thread.sleep(500);
			wcl.acceptAlert();
			stt.selectStore(input.get("Store"));
		} else {
			logger.error(wcl.getAlertmsg());
			Assert.assertEquals(wcl.getAlertmsg(), "Select Store/Godown");
		}
		stt.clickOnSaveBtn();
		if (wcl.getAlertmsg().contains("Select stock transfer type")) {
			Thread.sleep(500);
			wcl.acceptAlert();
			stt.selecttransfertype(input.get("OptionType"));
		} else {
			logger.error(wcl.getAlertmsg());
			Assert.assertEquals(wcl.getAlertmsg(), "Select stock transfer type");
		}
		
		stt.clickOnSaveBtn();
		if (wcl.getAlertmsg().contains("Enter products.")) {
			Thread.sleep(500);
			wcl.acceptAlert();
			if (stt.getNumOfProductRows() == 1) {
					stt.searchProductFormPopupForRow(stt.getNumOfProductRows());
					if (stb.getNumOfPopupProductRows() >= 1) {
						for (int i1 = 1; i1 <= stb.getNumOfPopupProductRows();) {
							if (stb.getPopupProductNameAtRow(i1).contains(input.get("ProductName"))
									&& stb.getPopupProductBatchNoAtRow(i1).contains(input.get("ProductBatchNo"))
									&& stb.getPopupProductStockQtyAtRow(i1)
											.contains(input.get("DamageStock") + "/0")) {
								input.put("PopupProductCode", stb.getPopupProductCodeAtRow(i1));
								input.put("PopupProductName", stb.getPopupProductNameAtRow(i1));
								input.put("PopupProductMRP", stb.getPopupProductMRPAtRow(i1));
								input.put("PopupProductSalableStock", stb.getPopupProductStockQtyAtRow(i1));
								input.put("PopupProductBatchNo", stb.getPopupProductBatchNoAtRow(i1));

								stb.ClickOnPopupProductCodeAtRow(i1);
								stb.clickOnPopupokBtn();
								break;
							} else {
								i1++;
							}
						}

					} else {
						Assert.assertEquals(stb.getNumOfPopupProductRows(), "Popup Products Number Of rows Not Matching");
					}
					
					stt.clickOnSaveBtn();
					if (wcl.getAlertmsg().contains("Please enter the quantity")) {
						Thread.sleep(500);
						wcl.acceptAlert();
						stt.ClickonSerialNoLinkAtRow(1);

						if (home.getNumOfRowsInCosecutiveSerialNoTable() == 2) {
							home.enterFromSerialNumbersAtRow(2, input.get("ProductFromSerialNo"));
							home.enterToSerialNumbersAtRow(2, input.get("ProductToSerialNo"));

							Assert.assertEquals(home.checkProductNameIsReadOnlyAtRow(2), true);
							Assert.assertEquals(home.getProductNameAtRow(2), input.get("PopupProductName"));

							long qty = Long.parseLong(input.get("ProductToSerialNo"))
									- Long.parseLong(input.get("ProductFromSerialNo")) + 1;
							input.put("PopupProductQty", String.valueOf(qty));
							Assert.assertEquals(Long.parseLong(home.getProductQtyAtRow(2)), qty);

							Assert.assertEquals(home.checkQtyIsReadOnlyAtRow(2), true);
							input.put("ProducttransferQty", home.getProductQtyAtRow(2));

							home.clickSerialNoPopUpOkButton();
						}

					} else {
						logger.error(wcl.getAlertmsg());
						Assert.assertEquals(wcl.getAlertmsg(), "Please enter the quantity");
					}
					
					stt.clickOnSaveBtn();
					if (wcl.getAlertmsg().contains("Data saved successfully")) {
						Thread.sleep(500);
						wcl.acceptAlert();
					} else {
						logger.error(wcl.getAlertmsg());
						Assert.assertEquals(wcl.getAlertmsg(), "Data saved successfully");
					}

				} else {
					Assert.assertEquals(stt.getNumOfProductRows(), "Main Select Products Number Of rows Not Matching");
				}
				
			} else {
			logger.error(wcl.getAlertmsg());
			Assert.assertEquals(wcl.getAlertmsg(), "Enter products.");
		}
		
		String indata[] = { input.get("Status").toString(), input.get("Store").toString(),
				input.get("ProductCode").toString(), input.get("ProductName").toString(),
				input.get("ProductFromSerialNo").toString(), input.get("ProductToSerialNo").toString(),
				input.get("ProducttransferQty").toString(),input.get("OptionType").toString()};

		ExcelLib stk = new ExcelLib("./TestData/StockTestData.xlsx");
		stk.Excelwrite("./TestData/StockTestData.xlsx", "StockTypeTransferData", indata);
		logger.info("Completed creating and verifying stock type transfer as Good to Damage");
		home.ClickOnTabClose("Stock Type Transfer");
		
		
		Thread.sleep(1500);
		home.ClickOnMenu();

		home.ClickOnSubMenuItem("Stock Browser");
		logger.info("Started verification of Product Details based on given inputs");
		Thread.sleep(1000);

		Assert.assertEquals(stb.getSBU(), input.get("SBU"));
		Assert.assertEquals(stb.getCompany(),input.get("Company"));
		Assert.assertEquals(stb.getStore(), input.get("Store"));

		stb.enterProductCode(input.get("ProductCode"));
		Thread.sleep(1000);
		stb.PopupProductSelect();
		stb.clickOnViewBtn();

		System.out.println(stb.getNumOfMainProductRows());
		if (stb.getNumOfMainProductRows() >= 1) {

			for (int i = 1; i <= stb.getNumOfMainProductRows();) {
				if (stb.getProductCodeAtRow(i).contains(input.get("ProductCode"))
						&& stb.getBatchNoAtRow(i).contains(input.get("ProductBatchNo"))
						&& stb.getMRPAtRow(i).contains(input.get("ProductMRP"))) {
					Assert.assertEquals(stb.getProductNameAtRow(i), input.get("ProductName"));
					Assert.assertEquals(stb.getPcsinCaseBoxAtRow(i), input.get("PcsinCaseBox"));
					Assert.assertEquals(Integer.parseInt(stb.getSalableStockAtRow(i)), Integer.parseInt(input.get("ProductSalableStock"))+ 1);
					Assert.assertEquals(stb.getHoldStockAtRow(i), input.get("HoldStock"));
					Assert.assertEquals(Integer.parseInt(stb.getDamageStockAtRow(i)), Integer.parseInt(input.get("DamageStock"))- 1);
					Assert.assertEquals(stb.getReconsStockAtRow(i), input.get("ReconsStock"));
					Assert.assertEquals(stb.getInTransitLossAtRow(i), input.get("InTransitLoss"));
					Assert.assertEquals(stb.getMissingStockAtRow(i), input.get("MissingStock"));
					Assert.assertEquals(stb.getStolenStockAtRow(i), input.get("StolenStock"));
					Assert.assertEquals(stb.getBurntStockAtRow(i), input.get("BurntStock"));
					Assert.assertEquals(stb.getCombiStockAtRow(i), input.get("CombiStock"));
					
					
					stb.clickOnProductCodeAtRow(i);
					Thread.sleep(1000);
					Assert.assertEquals(stb.getSerialNoPopuptitle(), "Serial Number List for "
							+ input.get("ProductName") + " (" + input.get("ProductCode") + ")");
					
					if (stb.getNumOfSerialPopupProductRows() >= 1) {
						for (int j = 3; j <= stb.getNumOfSerialPopupProductRows();) {
							if (Long.parseLong(stb.getSerialPopupFromSerialNoAtRow(j)) <= Long.parseLong(input.get("ProductFromSerialNo")) && Long.parseLong(input.get("ProductFromSerialNo"))<= Long.parseLong(stb.getSerialPopupToSerialNoAtRow(j)) ) {
								Assert.assertEquals(stb.getSerialPopupCurrentStateAtRow(j), input.get("Book Stock"));
								break;
							} else {
								if (j <= stb.getNumOfSerialPopupProductRows()) {
									j++;
								} else {
									Assert.assertEquals(false, "Serial Number Details not found for given Inputs");
								}
							}
						}
					} else {
						Assert.assertEquals(false, "Serial Number Details not found for given Inputs");
					}

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
		
		stb.ClickOnSerialPopupCloseBtn();
		
		
		home.ClickOnTabClose("Stock Browser");
		wcl.acceptAlert();
		logger.info("Completed verification of Product Details based on given inputs");


	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
