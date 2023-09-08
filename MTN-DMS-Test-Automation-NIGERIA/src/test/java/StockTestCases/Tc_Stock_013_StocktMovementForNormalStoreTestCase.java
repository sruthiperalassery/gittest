package StockTestCases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.UBQGenericLib.BaseClassLoader;
import com.UBQGenericLib.ExcelLib;

/**
 * @author Praneeth
 *
 */
@Listeners(com.UBQGenericLib.SampleListner.class)
public class Tc_Stock_013_StocktMovementForNormalStoreTestCase extends BaseClassLoader {
	HashMap<String, String> input = new HashMap<String, String>();

	@Test
	public void stocktMovementForNormalStore() throws Exception {

		ExcelLib stockdata = new ExcelLib("./Testdata/Inputdata.xlsx");
		/*Thread.sleep(500);
		home.ClickonMenutype();*/
		Thread.sleep(500);
		home.ClickOnMenu();
		Thread.sleep(500);
		home.ClickOnSubMenuItem("Stock Browser");
		logger.info("Clicked on sub menu item View Stock");
		Thread.sleep(1000);
		input.put("fromstore", "MAIN");
		input.put("tostore", "22002758");
		

		for (int n = 1; n <= 2; n++) {

			if (stockdata.Excelread("StockMovementCheck", n, 10).equalsIgnoreCase("yes")) {
				Long descbookstock = (long) 0;
				Long descholdstock = (long) 0;
				Long descdamagestock = (long) 0;
				Long descmissingstock = (long) 0;
				Long descstolenstock = (long) 0;
				Long descburntstock = (long) 0;
				Long descreconstock = (long) 0;
				Long descintralossstock = (long) 0;
				Long desccombistock = (long) 0;
				input.put("descProductCode", stockdata.Excelread("StockMovementCheck", n, 0));
				input.put("descShortProductCode", stockdata.Excelread("StockMovementCheck", n, 1));
				input.put("descProductName", stockdata.Excelread("StockMovementCheck", n, 2));
				input.put("descShortProductName", stockdata.Excelread("StockMovementCheck", n, 3));
				input.put("descBatchNo", stockdata.Excelread("StockMovementCheck", n, 4));
				input.put("descMRP", stockdata.Excelread("StockMovementCheck", n, 5));
				input.put("descProductFromSerialNo", stockdata.Excelread("StockMovementCheck", n, 7));
				input.put("descProductToSerialNo", stockdata.Excelread("StockMovementCheck", n, 8));
				input.put("descProductQty", stockdata.Excelread("StockMovementCheck", n, 9));
				input.put("descSalableStock", "0");
				input.put("descHoldStock", "0");
				input.put("descDamageStock", "0");
				input.put("descReconsStock", "0");
				input.put("descInTransitLoss", "0");
				input.put("descMissingStock", "0");
				input.put("descStolenStock", "0");
				input.put("descBurntStock", "0");
				input.put("descCombiStock", "0");

				Assert.assertEquals(stb.getSBU(), "MTN");
				stb.selectStore(input.get("fromstore"));
				Assert.assertEquals(stb.getStore(), input.get("fromstore"));

				stb.enterProductCode(input.get("descProductCode"));
				Thread.sleep(1000);
				stb.PopupProductSelect();
				stb.clickOnViewBtn();

				if (stb.getNumOfMainProductRows() >= 1) {

					for (int i = 1; i <= stb.getNumOfMainProductRows();) {
						Thread.sleep(500);
						String getdescprodcode = stb.getProductCodeAtRow(i);
						String getdescbatchno = stb.getBatchNoAtRow(i);
						String getdescmrp = stb.getMRPAtRow(i);
						if (getdescprodcode.contains(input.get("descProductCode"))
								&& getdescbatchno.contains(input.get("descBatchNo"))
								&& getdescmrp.contains(input.get("descMRP"))) {
							input.put("descProductName", stb.getProductNameAtRow(i));
							input.put("descBatchNo", stb.getBatchNoAtRow(i));
							input.put("descMRP", stb.getMRPAtRow(i));
							input.put("descSalableStock", stb.getSalableStockAtRow(i));
							input.put("descHoldStock", stb.getHoldStockAtRow(i));
							input.put("descDamageStock", stb.getDamageStockAtRow(i));
							input.put("descReconsStock", stb.getReconsStockAtRow(i));
							input.put("descInTransitLoss", stb.getInTransitLossAtRow(i));
							input.put("descMissingStock", stb.getMissingStockAtRow(i));
							input.put("descStolenStock", stb.getStolenStockAtRow(i));
							input.put("descBurntStock", stb.getBurntStockAtRow(i));
							input.put("descCombiStock", stb.getCombiStockAtRow(i));

							stb.clickOnProductCodeAtRow(i);
							Thread.sleep(1000);
							Assert.assertEquals(stb.getSerialNoPopuptitle(), "Serial number list for "
									+ input.get("descProductName") + " (" + input.get("descProductCode") + ")");

							if (stb.getNumOfSerialPopupProductRows() >= 1) {
								for (int j = 3; j <= stb.getNumOfSerialPopupProductRows();) {
									String prodstate = stb.getSerialPopupCurrentStateAtRow(j);
									if (prodstate.contains("Book Stock")) {
										if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[0-9]+")) {

											input.put("ProductFromSerialNo", stb.getSerialPopupFromSerialNoAtRow(j));
											input.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
											descbookstock = descbookstock
													+ Long.parseLong(input.get("ProductToSerialNo"))
													- Long.parseLong(input.get("ProductFromSerialNo")) + 1;
											j++;
										} else if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[A-Za-z0-9]+")) {
											descbookstock = descbookstock + 1;
											j++;
										} else {
											j++;
											System.out.println("Error");
										}

									} else if (prodstate.contains("Hold Stock")) {
										if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[0-9]+")) {

											input.put("ProductFromSerialNo", stb.getSerialPopupFromSerialNoAtRow(j));
											input.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
											descholdstock = descholdstock
													+ Long.parseLong(input.get("ProductToSerialNo"))
													- Long.parseLong(input.get("ProductFromSerialNo")) + 1;
											j++;
										} else if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[A-Za-z0-9]+")) {
											descholdstock = descholdstock + 1;
											j++;
										} else {
											j++;
											System.out.println("error");
										}

									} else if (prodstate.contains("Damaged Stock")) {
										if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[0-9]+")) {
											input.put("ProductFromSerialNo", stb.getSerialPopupFromSerialNoAtRow(j));
											input.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
											descdamagestock = descdamagestock
													+ Long.parseLong(input.get("ProductToSerialNo"))
													- Long.parseLong(input.get("ProductFromSerialNo")) + 1;
											j++;
										} else if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[A-Za-z0-9]+")) {
											descdamagestock = descdamagestock + 1;
											j++;
										} else {
											j++;
											System.out.println("error");
										}

									} else if (prodstate.contains("Missing stock")) {
										if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[0-9]+")) {
											input.put("ProductFromSerialNo", stb.getSerialPopupFromSerialNoAtRow(j));
											input.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
											descmissingstock = descmissingstock
													+ Long.parseLong(input.get("ProductToSerialNo"))
													- Long.parseLong(input.get("ProductFromSerialNo")) + 1;
											j++;
										} else if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[A-Za-z0-9]+")) {
											descmissingstock = descmissingstock + 1;
											j++;
										} else {
											j++;
											System.out.println("error");
										}

									} else if (prodstate.contains("Stolen stock")) {
										if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[0-9]+")) {

											input.put("ProductFromSerialNo", stb.getSerialPopupFromSerialNoAtRow(j));
											input.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
											descstolenstock = descstolenstock
													+ Long.parseLong(input.get("ProductToSerialNo"))
													- Long.parseLong(input.get("ProductFromSerialNo")) + 1;
											j++;
										} else if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[A-Za-z]+")) {
											descstolenstock = descstolenstock + 1;
											j++;
										} else {
											j++;
											System.out.println("error");
										}

									} else if (prodstate.contains("Burnt")) {
										if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[0-9]+")) {
											input.put("ProductFromSerialNo", stb.getSerialPopupFromSerialNoAtRow(j));
											input.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
											descburntstock = descburntstock
													+ Long.parseLong(input.get("ProductToSerialNo"))
													- Long.parseLong(input.get("ProductFromSerialNo")) + 1;
											j++;
										} else if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[A-Za-z0-9]+")) {
											descburntstock = descburntstock + 1;
											j++;
										} else {
											j++;
											System.out.println("error");
										}

									} else if (prodstate.contains("Recons Stock")) {
										if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[0-9]+")) {
											input.put("ProductFromSerialNo", stb.getSerialPopupFromSerialNoAtRow(j));
											input.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
											descreconstock = descreconstock
													+ Long.parseLong(input.get("ProductToSerialNo"))
													- Long.parseLong(input.get("ProductFromSerialNo")) + 1;
											j++;
										} else if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[A-Za-z]+")) {
											descreconstock = descreconstock + 1;
											j++;
										} else {
											j++;
											System.out.println("error");
										}

									} else if (prodstate.contains("In-Transit Loss")) {
										if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[0-9]+")) {
											input.put("ProductFromSerialNo", stb.getSerialPopupFromSerialNoAtRow(j));
											input.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
											descintralossstock = descintralossstock
													+ Long.parseLong(input.get("ProductToSerialNo"))
													- Long.parseLong(input.get("ProductFromSerialNo")) + 1;
											j++;
										} else if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[A-Za-z0-9]+")) {
											descintralossstock = descintralossstock + 1;
											j++;
										} else {
											j++;
											System.out.println("error");
										}

									} else if (prodstate.contains("Combi Stock")) {
										if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[0-9]+")) {
											input.put("ProductFromSerialNo", stb.getSerialPopupFromSerialNoAtRow(j));
											input.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
											desccombistock = desccombistock
													+ Long.parseLong(input.get("ProductToSerialNo"))
													- Long.parseLong(input.get("ProductFromSerialNo")) + 1;
											j++;
										} else if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[A-Za-z0-9]+")) {
											desccombistock = desccombistock + 1;
											j++;
										} else {
											j++;
											System.out.println("error");
										}

									} else {
										if (j <= stb.getNumOfSerialPopupProductRows()) {
											j++;
										} else {
											break;
										}
									}

								}
								stb.ClickOnSerialPopupCloseBtn();
								Assert.assertEquals(input.get("descSalableStock"), String.valueOf(descbookstock),
										"Book stock not matching");
								Assert.assertEquals(input.get("descHoldStock"), String.valueOf(descholdstock),
										"Hold stock not matching");
								Assert.assertEquals(input.get("descDamageStock"), String.valueOf(descdamagestock),
										"Damage stock not matching");
								Assert.assertEquals(input.get("descReconsStock"), String.valueOf(descreconstock),
										"Recon stock not matching");
								Assert.assertEquals(input.get("descInTransitLoss"), String.valueOf(descintralossstock),
										"In-Transit Loss not matching");
								Assert.assertEquals(input.get("descMissingStock"), String.valueOf(descmissingstock),
										"Missing stock not matching");
								Assert.assertEquals(input.get("descStolenStock"), String.valueOf(descstolenstock),
										"Stolen Stock not matching");
								Assert.assertEquals(input.get("descBurntStock"), String.valueOf(descburntstock),
										"Burnt stock not matching");
								Assert.assertEquals(input.get("descCombiStock"), String.valueOf(desccombistock),
										"Combi stock not matching");
								Thread.sleep(500);
								stb.ClickonPrintStockBook();
								Thread.sleep(500);
								stb.ClickonPrintStockPosition();
							} else {
								Assert.assertEquals(false, "Serial Number Details not found for given Inputs");
							}
							break;
						} else {
							if (i < stb.getNumOfMainProductRows()) {
								i++;
							} else {
								Assert.assertEquals(false, "Product Details not found for given Inputs");
							}

						}
					}
				} else {
					Assert.assertEquals(false, "Product Details not found for given Inputs");
				}

			} else if (stockdata.Excelread("StockMovementCheck", n, 10).equalsIgnoreCase("no")) {

				input.put("nondescProductCode", stockdata.Excelread("StockMovementCheck", n, 0));
				input.put("nondescShortProductCode", stockdata.Excelread("StockMovementCheck", n, 1));
				input.put("nondescProductName", stockdata.Excelread("StockMovementCheck", n, 2));
				input.put("nondescShortProductName", stockdata.Excelread("StockMovementCheck", n, 3));
				input.put("nondescBatchNo", stockdata.Excelread("StockMovementCheck", n, 4));
				input.put("nondescMRP", stockdata.Excelread("StockMovementCheck", n, 5));
				input.put("nondescProductQty", stockdata.Excelread("StockMovementCheck", n, 9));
				input.put("nondescSalableStock", "0");
				input.put("nondescHoldStock", "0");
				input.put("nondescDamageStock", "0");
				input.put("nondescReconsStock", "0");
				input.put("nondescInTransitLoss", "0");
				input.put("nondescMissingStock", "0");
				input.put("nondescStolenStock", "0");
				input.put("nondescBurntStock", "0");
				input.put("nondescCombiStock", "0");

				Assert.assertEquals(stb.getSBU(), "MTN");
				stb.selectStore(input.get("fromstore"));
				Assert.assertEquals(stb.getStore(), input.get("fromstore"));

				stb.enterProductCode(input.get("nondescProductCode")); // it
																		// needs
																		// to be
																		// enabled
																		// after
																		// bug
																		// fix.
				// stb.enterProductCode(input.get("nondescProductName")); // it
				// needs to be disble after bug fix.
				Thread.sleep(1000);
				stb.PopupProductSelect();
				stb.clickOnViewBtn();

				if (stb.getNumOfMainProductRows() >= 1) {

					for (int i = 1; i <= stb.getNumOfMainProductRows();) {
						Thread.sleep(500);
						String getnondescprodcode = stb.getProductCodeAtRow(i);
						String getnondescbatchno = stb.getBatchNoAtRow(i);
						String getnondescmrp = stb.getMRPAtRow(i);

						if (getnondescprodcode.contains(input.get("nondescProductCode"))
								&& getnondescbatchno.contains(input.get("nondescBatchNo"))
								&& getnondescmrp.contains(input.get("nondescMRP"))) {
							input.put("nondescProductName", stb.getProductNameAtRow(i));
							input.put("nondescBatchNo", stb.getBatchNoAtRow(i));
							input.put("nondescMRP", stb.getMRPAtRow(i));
							input.put("nondescSalableStock", stb.getSalableStockAtRow(i));
							input.put("nondescHoldStock", stb.getHoldStockAtRow(i));
							input.put("nondescDamageStock", stb.getDamageStockAtRow(i));
							input.put("nondescReconsStock", stb.getReconsStockAtRow(i));
							input.put("nondescInTransitLoss", stb.getInTransitLossAtRow(i));
							input.put("nondescMissingStock", stb.getMissingStockAtRow(i));
							input.put("nondescStolenStock", stb.getStolenStockAtRow(i));
							input.put("nondescBurntStock", stb.getBurntStockAtRow(i));
							input.put("nondescCombiStock", stb.getCombiStockAtRow(i));
							Thread.sleep(500);
							stb.ClickonPrintStockBook();
							Thread.sleep(500);
							stb.ClickonPrintStockPosition();
							break;
						} else {
							if (i < stb.getNumOfMainProductRows()) {
								i++;
							} else {
								Assert.assertEquals(false, "Product Details not found for given Inputs");
							}

						}
					}
				}

			} else {
				Assert.assertEquals(false, "In Excel Input file Status of Product is not set Properly");

			}

		}
		home.ClickOnTabClose("Stock Browser");

		logger.info("Completed getting Product Details based on given inputs");

		Thread.sleep(500);
		home.ClickOnMenu();
		Thread.sleep(500);
		home.ClickOnSubMenuItem("Stk Movement - Store");
		logger.info("Started stock movement and Verification of Stock in stock browser");
		Thread.sleep(1000);
		input.put("fromstore", "MAIN");
		input.put("tostore", "C0000208002081");
		
		stm.selectSBU("MTN");
		stm.selectFromStore(input.get("fromstore"));
		stm.selectToStore(input.get("tostore"));

		for (int n = 1; n <= 2; n++) {
			if (stockdata.Excelread("StockMovementCheck", n, 10).equalsIgnoreCase("yes")) {
				if (stm.getNumOfRows() >= 1) {
					stm.selectProductNameAtRow(n);
					if (stb.getNumOfPopupProductRows() >= 1) {
						for (int i = 1; i <= stb.getNumOfPopupProductRows();) {
							if (stb.getPopupProductNameAtRow(i).contains(input.get("descProductName"))
									&& stb.getPopupProductBatchNoAtRow(i).contains(input.get("descBatchNo"))
									&& stb.getPopupProductStockQtyAtRow(i)
											.contains(input.get("descSalableStock") + "/0")) {
								input.put("PopupProductCode", stb.getPopupProductCodeAtRow(i));
								input.put("PopupProductName", stb.getPopupProductNameAtRow(i));
								input.put("PopupProductMRP", stb.getPopupProductMRPAtRow(i));
								input.put("PopupProductSalableStock", stb.getPopupProductStockQtyAtRow(i));
								input.put("PopupProductBatchNo", stb.getPopupProductBatchNoAtRow(i));

								stb.ClickOnPopupProductCodeAtRow(i);
								stb.clickOnPopupokBtn();
								break;
							} else {
								i++;
							}
						}

					} else {
						Assert.assertEquals(stb.getNumOfPopupProductRows(),
								"Popup Products Number Of rows Not Matching");
					}

					stm.ClickonSelectedSerialNoLinkAtRow(n);

					if (home.getNumOfRowsInCosecutiveSerialNoTable() == 2) {
						home.enterFromSerialNumbersAtRow(2, input.get("descProductFromSerialNo"));
						home.enterToSerialNumbersAtRow(2, input.get("descProductToSerialNo"));

						Assert.assertEquals(home.checkProductNameIsReadOnlyAtRow(2), true);
						System.out.println(home.getProductNameAtRow(2));
						System.out.println( input.get("descProductName"));
						//Assert.assertEquals(home.getProductNameAtRow(2), input.get("descProductName"));

						long qty = Long.parseLong(input.get("descProductToSerialNo"))
								- Long.parseLong(input.get("descProductFromSerialNo")) + 1;
						input.put("PopupProductQty", String.valueOf(qty));
						Assert.assertEquals(Long.parseLong(home.getProductQtyAtRow(2)), qty);

						Assert.assertEquals(home.checkQtyIsReadOnlyAtRow(2), true);
						input.put("ProductAdjustmentQty", home.getProductQtyAtRow(2));

						home.clickSerialNoPopUpOkButton();
					}

					input.put("ProductTrasferQty", stm.getSelectedTransferQtyAtRow(n));
					Assert.assertEquals(input.get("ProductTrasferQty"), input.get("PopupProductQty"));

					// hrs.clickOnSaveBtn();
					Thread.sleep(1000);
					Assert.assertEquals(input.get("PopupProductSalableStock"), input.get("descSalableStock") + "/0",
							"Popup Product Quantity and Salable stock Quantity is not matching");
					Assert.assertEquals(input.get("descShortProductCode"), stm.getSelectedProductCodeAtRow(n),
							"Popup Product code and Main Product Code is not matching");
					Assert.assertEquals(input.get("descShortProductName"), stm.getSelectProductNameAtRow(n),
							"Popup Product Name and Main Product Name is not matching");
					Assert.assertEquals(input.get("descBatchNo"), stm.getSelectedBatchNoAtRow(n),
							"Popup Product Batch Number  and Main Product Batch Number is not matching");
					Assert.assertEquals(input.get("descMRP") + ".00", stm.getSelectedMRPAtRow(n),
							"Popup Product MRP and Main Product MRP is not matching");
					Assert.assertEquals(input.get("ProductTrasferQty"), input.get("descProductQty"),
							"Popup Product Qty and Main Product Qty is not matching");
					Assert.assertEquals(input.get("descSalableStock"), stm.getSelectedSourceAtRow(n),
							"Descrite Product Source Qty not Matching");
					input.put("ProductDescDestinationQty", stm.getSelectedDestinationAtRow(n));
					
				} else {
					Assert.assertEquals(hrs.getNumOfRows(), "Main Select Products Number Of rows Not Matching");
				}
			} else if (stockdata.Excelread("StockMovementCheck", n, 10).equalsIgnoreCase("no")) {

				if (stm.getNumOfRows() >= 1) {
					stm.selectProductNameAtRow(n);
					if (stb.getNumOfPopupProductRows() >= 1) {
						for (int i = 1; i <= stb.getNumOfPopupProductRows();) {
							if (stb.getPopupProductNameAtRow(i).contains(input.get("nondescProductName"))
									&& stb.getPopupProductBatchNoAtRow(i).contains(input.get("nondescBatchNo"))
									&& stb.getPopupProductStockQtyAtRow(i)
											.contains(input.get("nondescSalableStock") + "/0")) {
								input.put("PopupProductCode", stb.getPopupProductCodeAtRow(i));
								input.put("PopupProductName", stb.getPopupProductNameAtRow(i));
								input.put("PopupProductMRP", stb.getPopupProductMRPAtRow(i));
								input.put("PopupProductSalableStock", stb.getPopupProductStockQtyAtRow(i));
								input.put("PopupProductBatchNo", stb.getPopupProductBatchNoAtRow(i));

								stb.ClickOnPopupProductCodeAtRow(i);
								stb.clickOnPopupokBtn();
								break;
							} else {
								i++;
							}
						}

					} else {
						Assert.assertEquals(stb.getNumOfPopupProductRows(),
								"Popup Products Number Of rows Not Matching");
					}

					Assert.assertEquals(input.get("PopupProductSalableStock"), input.get("nondescSalableStock") + "/0",
							"Popup Product Quantity and Salable stock Quantity is not matching");
					Assert.assertEquals(input.get("nondescShortProductCode"), stm.getSelectedProductCodeAtRow(n),
							"Popup Product code and Main Product Code is not matching");
					Assert.assertEquals(input.get("nondescShortProductName"), stm.getSelectProductNameAtRow(n),
							"Popup Product Name and Main Product Name is not matching");
					Assert.assertEquals(input.get("nondescBatchNo"), stm.getSelectedBatchNoAtRow(n),
							"Popup Product Batch Number  and Main Product Batch Number is not matching");
					Assert.assertEquals(input.get("nondescMRP") + ".00", stm.getSelectedMRPAtRow(n),
							"Popup Product MRP and Main Product MRP is not matching");

					Assert.assertEquals(input.get("nondescSalableStock"), stm.getSelectedSourceAtRow(n),
							"Non Descrite Product Source Qty not Matching");

					stm.enterNonDescTransferQtyAtRow(n, input.get("nondescProductQty"));
					
					input.put("ProductnonDescDestinationQty", stm.getSelectedDestinationAtRow(n));

				} else {
					Assert.assertEquals(sadj.getNumOfRows(), "Main Select Products Number Of rows Not Matching");
				}

			} else {
				Assert.assertEquals(false, "In Excel Input file Status of Product is not set Properly");

			}

		}

		stm.SaveBtn();
		if (wcl.getAlertmsg().contains("Data saved successfully")) {
			wcl.acceptAlert();
			Thread.sleep(500);
			home.ClickOnTabClose("Stock Movement - Store");
		}
		
		if (wcl.getAlertmsg().contains("Selected action will discard any entered data. Continue?")) {
			wcl.acceptAlert();
			logger.info(" Stock movement  Test case completed");
			
		}
		
			Thread.sleep(1500);
			home.ClickOnMenu();
			Thread.sleep(500);
			home.ClickOnSubMenuItem("Stock Browser");
			logger.info("Clicked on sub menu item View Stock");
			Thread.sleep(1000);

			for (int n = 1; n <= 2; n++) {
				
				if (stockdata.Excelread("StockMovementCheck",n,10).equalsIgnoreCase("yes")) {
					Assert.assertEquals(stb.getSBU(), "MTN");
					Assert.assertEquals(stb.getStore(), input.get("fromstore"));
					
					stb.enterProductCode(input.get("descProductCode"));
					Thread.sleep(1000);
					stb.PopupProductSelect();
					stb.clickOnViewBtn();
					
					if (stb.getNumOfMainProductRows() >= 1) {
						
						for (int i = 1; i <= stb.getNumOfMainProductRows();) {
							Thread.sleep(500);
							String getdescprodcode = stb.getProductCodeAtRow(i);
							String getdescbatchno =  stb.getBatchNoAtRow(i);
							String getdescmrp = stb.getMRPAtRow(i);
							if (getdescprodcode.contains(input.get("descProductCode"))
									&& getdescbatchno.contains(input.get("descBatchNo"))
									&& getdescmrp.contains(input.get("descMRP"))){
								input.put("descProductName", stb.getProductNameAtRow(i));
								
								Assert.assertEquals(stb.getProductNameAtRow(i), input.get("descProductName"),"Descrite Product Name verification failed");
								Assert.assertEquals(stb.getBatchNoAtRow(i), input.get("descBatchNo"),"Descrite Product Batch Number verification failed");
								Assert.assertEquals(stb.getMRPAtRow(i), input.get("descMRP"),"Descrite Product MRP verification failed");
								Assert.assertEquals(stb.getSalableStockAtRow(i), String.valueOf(Long.parseLong(input.get("descSalableStock"))-Long.parseLong(input.get("descProductQty"))),"Descrite Product Salable Stock verification failed");
								Assert.assertEquals(stb.getHoldStockAtRow(i), input.get("descHoldStock"),"Descrite Product Hold Stock verification failed");
								Assert.assertEquals(stb.getDamageStockAtRow(i), input.get("descDamageStock"),"Descrite Product Damage Stock verification failed");
								Assert.assertEquals(stb.getReconsStockAtRow(i), input.get("descReconsStock"),"Descrite Product Recn. Stock verification failed");
								Assert.assertEquals(stb.getInTransitLossAtRow(i), input.get("descInTransitLoss"),"Descrite Product Recn. Stock verification failed");
								Assert.assertEquals(stb.getMissingStockAtRow(i), input.get("descMissingStock"),"Descrite Product Missing Stock verification failed");
								Assert.assertEquals(stb.getStolenStockAtRow(i), input.get("descStolenStock"),"Descrite Product Stolen. Stock verification failed");
								Assert.assertEquals(stb.getBurntStockAtRow(i), input.get("descBurntStock"),"Descrite Product Burnt Stock verification failed");
								Assert.assertEquals(stb.getCombiStockAtRow(i), input.get("descCombiStock"),"Descrite Product Combi Stock verification failed");
								
								Thread.sleep(500);
								stb.ClickonPrintStockBook();
								Thread.sleep(500);
								stb.ClickonPrintStockPosition();
								
								break;
							} else{
								if (i < stb.getNumOfMainProductRows()) {
									i++;
								}else{
									Assert.assertEquals(false, "Product Details not found for given Inputs");
								}
								 
							}
						}
					}else{
						Assert.assertEquals(false, "Product Details not found for given Inputs");
					}
					
				}else if (stockdata.Excelread("StockMovementCheck",n,10).equalsIgnoreCase("no"))  {
					
					Assert.assertEquals(stb.getSBU(), "MTN");
					Assert.assertEquals(stb.getStore(), input.get("fromstore"));
					
					stb.enterProductCode(input.get("nondescProductCode")); // it needs to be enabled after bug fix.
					//stb.enterProductCode(input.get("nondescProductName")); // it needs to be disble after bug fix.
					Thread.sleep(1000);
					stb.PopupProductSelect();
					stb.clickOnViewBtn();
					
					if (stb.getNumOfMainProductRows() >= 1) {
						
						for (int i = 1; i <= stb.getNumOfMainProductRows();) {
							Thread.sleep(500);
							String getnondescprodcode = stb.getProductCodeAtRow(i);
							String getnondescbatchno =  stb.getBatchNoAtRow(i);
							String getnondescmrp = stb.getMRPAtRow(i);
							
							if (getnondescprodcode.contains(input.get("nondescProductCode"))
									&& getnondescbatchno.contains(input.get("nondescBatchNo"))
									&& getnondescmrp.contains(input.get("nondescMRP"))){
								Assert.assertEquals(stb.getProductNameAtRow(i), input.get("nondescProductName"),"Descrite Product Name verification failed");
								Assert.assertEquals(stb.getBatchNoAtRow(i), input.get("nondescBatchNo"),"Descrite Product Batch Number verification failed");
								Assert.assertEquals(stb.getMRPAtRow(i), input.get("nondescMRP"),"Descrite Product MRP verification failed");
								Assert.assertEquals(stb.getSalableStockAtRow(i), String.valueOf(Long.parseLong(input.get("nondescSalableStock"))-Long.parseLong(input.get("nondescProductQty"))),"Descrite Product Salable Stock verification failed");
								Assert.assertEquals(stb.getHoldStockAtRow(i), input.get("nondescHoldStock"),"Descrite Product Hold Stock verification failed");
								Assert.assertEquals(stb.getDamageStockAtRow(i), input.get("nondescDamageStock"),"Descrite Product Damage Stock verification failed");
								Assert.assertEquals(stb.getReconsStockAtRow(i), input.get("nondescReconsStock"),"Descrite Product Recn. Stock verification failed");
								Assert.assertEquals(stb.getInTransitLossAtRow(i), input.get("nondescInTransitLoss"),"Descrite Product Recn. Stock verification failed");
								Assert.assertEquals(stb.getMissingStockAtRow(i), input.get("nondescMissingStock"),"Descrite Product Missing Stock verification failed");
								Assert.assertEquals(stb.getStolenStockAtRow(i), input.get("nondescStolenStock"),"Descrite Product Stolen. Stock verification failed");
								Assert.assertEquals(stb.getBurntStockAtRow(i), input.get("nondescBurntStock"),"Descrite Product Burnt Stock verification failed");
								Assert.assertEquals(stb.getCombiStockAtRow(i), input.get("nondescCombiStock"),"Descrite Product Combi Stock verification failed");
								Thread.sleep(500);
								stb.ClickonPrintStockBook();
								Thread.sleep(500);
								stb.ClickonPrintStockPosition();
								break;
					}else{
						if (i < stb.getNumOfMainProductRows()) {
							i++;
						}else{
							Assert.assertEquals(false, "Product Details not found for given Inputs");
						}
						 
					}
					}
					}
				
				}else{
					Assert.assertEquals(false, "In Excel Input file Status of Product is not set Properly");
					
				}
				
				
			}
			
			
			for (int n = 1; n <= 2; n++) {
				stb.selectStore(input.get("tostore"));
				if (stockdata.Excelread("StockMovementCheck",n,10).equalsIgnoreCase("yes")) {
					Assert.assertEquals(stb.getSBU(), "MTN");
					
					stb.enterProductCode(input.get("descProductCode"));
					Thread.sleep(1000);
					stb.PopupProductSelect();
					stb.clickOnViewBtn();
					
					if (stb.getNumOfMainProductRows() >= 1) {
						
						for (int i = 1; i <= stb.getNumOfMainProductRows();) {
							Thread.sleep(500);
							String getdescprodcode = stb.getProductCodeAtRow(i);
							String getdescbatchno =  stb.getBatchNoAtRow(i);
							String getdescmrp = stb.getMRPAtRow(i);
							if (getdescprodcode.contains(input.get("descProductCode"))
									&& getdescbatchno.contains(input.get("descBatchNo"))
									&& getdescmrp.contains(input.get("descMRP"))){
								input.put("descProductName", stb.getProductNameAtRow(i));
								
								Assert.assertEquals(stb.getProductNameAtRow(i), input.get("descProductName"),"Descrite Product Name verification failed");
								Assert.assertEquals(stb.getBatchNoAtRow(i), input.get("descBatchNo"),"Descrite Product Batch Number verification failed");
								Assert.assertEquals(stb.getMRPAtRow(i), input.get("descMRP"),"Descrite Product MRP verification failed");
								Assert.assertEquals(stb.getSalableStockAtRow(i), String.valueOf(Long.parseLong(input.get("ProductDescDestinationQty"))+ Long.parseLong(input.get("descProductQty"))),"Descrite Product Salable Stock verification failed");
								Assert.assertEquals(stb.getHoldStockAtRow(i), input.get("descHoldStock"),"Descrite Product Hold Stock verification failed");
								Assert.assertEquals(stb.getDamageStockAtRow(i), input.get("descDamageStock"),"Descrite Product Damage Stock verification failed");
								Assert.assertEquals(stb.getReconsStockAtRow(i), input.get("descReconsStock"),"Descrite Product Recn. Stock verification failed");
								Assert.assertEquals(stb.getInTransitLossAtRow(i), input.get("descInTransitLoss"),"Descrite Product Recn. Stock verification failed");
								Assert.assertEquals(stb.getMissingStockAtRow(i), input.get("descMissingStock"),"Descrite Product Missing Stock verification failed");
								Assert.assertEquals(stb.getStolenStockAtRow(i), input.get("descStolenStock"),"Descrite Product Stolen. Stock verification failed");
								Assert.assertEquals(stb.getBurntStockAtRow(i), input.get("descBurntStock"),"Descrite Product Burnt Stock verification failed");
								Assert.assertEquals(stb.getCombiStockAtRow(i), input.get("descCombiStock"),"Descrite Product Combi Stock verification failed");
								
								
								stb.clickOnProductCodeAtRow(i);
								Thread.sleep(1000);
								Assert.assertEquals(stb.getSerialNoPopuptitle(), "Serial number list for "
										+ input.get("descProductName") + " (" + input.get("descProductCode") + ")");
								
								if (stb.getNumOfSerialPopupProductRows() >= 1) {
									for (int j = 3; j <= stb.getNumOfSerialPopupProductRows();) {
										String prodstate = stb.getSerialPopupCurrentStateAtRow(j);
										 if (prodstate.contains("Book Stock")) {
											if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[0-9]+")) {
												if(Long.parseLong(stb.getSerialPopupFromSerialNoAtRow(j)) >= Long.parseLong(input.get("descProductFromSerialNo")) && Long.parseLong(stb.getSerialPopupToSerialNoAtRow(j)) <= Long.parseLong(input.get("descProductToSerialNo"))){
													Assert.assertTrue(true,"Hold Stock From and To serial number are matching");
												}
												
												j++;
											} else if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[A-Za-z0-9]+")){
												Assert.assertEquals(stb.getSerialPopupFromSerialNoAtRow(j), input.get("descProductFromSerialNo"),"Hold Stock From serial number not matching");
												Assert.assertEquals(stb.getSerialPopupToSerialNoAtRow(j), input.get("descProductToSerialNo"),"Hold Stock To serial number not matching");
												j++;
											}else{
												j++;
												System.out.println("error");
											}
											
										} 
										else {
											if (j <= stb.getNumOfSerialPopupProductRows()) {
												j++;
											} else {
												break;
											}
										}
										
									}
									stb.ClickOnSerialPopupCloseBtn();
									Thread.sleep(500);
									stb.ClickonPrintStockBook();
									Thread.sleep(500);
									stb.ClickonPrintStockPosition();
								} else {
									Assert.assertEquals(false, "Serial Number Details not found for given Inputs");
								}
								break;
							} else{
								if (i < stb.getNumOfMainProductRows()) {
									i++;
								}else{
									Assert.assertEquals(false, "Product Details not found for given Inputs");
								}
								 
							}
						}
					}else{
						Assert.assertEquals(false, "Product Details not found for given Inputs");
					}
					
				}else if (stockdata.Excelread("StockMovementCheck",n,10).equalsIgnoreCase("no"))  {
					stb.selectStore(input.get("fromstore"));
					Assert.assertEquals(stb.getSBU(), "MTN");
					stb.enterProductCode(input.get("nondescProductCode")); // it needs to be enabled after bug fix.
					//stb.enterProductCode(input.get("nondescProductName")); // it needs to be disble after bug fix.
					Thread.sleep(1000);
					stb.PopupProductSelect();
					stb.clickOnViewBtn();
					
					if (stb.getNumOfMainProductRows() >= 1) {
						
						for (int i = 1; i <= stb.getNumOfMainProductRows();) {
							Thread.sleep(500);
							String getnondescprodcode = stb.getProductCodeAtRow(i);
							String getnondescbatchno =  stb.getBatchNoAtRow(i);
							String getnondescmrp = stb.getMRPAtRow(i);
							
							if (getnondescprodcode.contains(input.get("nondescProductCode"))
									&& getnondescbatchno.contains(input.get("nondescBatchNo"))
									&& getnondescmrp.contains(input.get("nondescMRP"))){
								Assert.assertEquals(stb.getProductNameAtRow(i), input.get("nondescProductName"),"Descrite Product Name verification failed");
								Assert.assertEquals(stb.getBatchNoAtRow(i), input.get("nondescBatchNo"),"Descrite Product Batch Number verification failed");
								Assert.assertEquals(stb.getMRPAtRow(i), input.get("nondescMRP"),"Descrite Product MRP verification failed");
								Assert.assertEquals(stb.getSalableStockAtRow(i), String.valueOf(Long.parseLong(input.get("ProductnonDescDestinationQty"))+ Long.parseLong(input.get("nondescProductQty"))),"Descrite Product Salable Stock verification failed");
								Assert.assertEquals(stb.getHoldStockAtRow(i), input.get("nondescHoldStock"),"Descrite Product Hold Stock verification failed");
								Assert.assertEquals(stb.getDamageStockAtRow(i), input.get("nondescDamageStock"),"Descrite Product Damage Stock verification failed");
								Assert.assertEquals(stb.getReconsStockAtRow(i), input.get("nondescReconsStock"),"Descrite Product Recn. Stock verification failed");
								Assert.assertEquals(stb.getInTransitLossAtRow(i), input.get("nondescInTransitLoss"),"Descrite Product Recn. Stock verification failed");
								Assert.assertEquals(stb.getMissingStockAtRow(i), input.get("nondescMissingStock"),"Descrite Product Missing Stock verification failed");
								Assert.assertEquals(stb.getStolenStockAtRow(i), input.get("nondescStolenStock"),"Descrite Product Stolen. Stock verification failed");
								Assert.assertEquals(stb.getBurntStockAtRow(i), input.get("nondescBurntStock"),"Descrite Product Burnt Stock verification failed");
								Assert.assertEquals(stb.getCombiStockAtRow(i), input.get("nondescCombiStock"),"Descrite Product Combi Stock verification failed");
								Thread.sleep(500);
								stb.ClickonPrintStockBook();
								Thread.sleep(500);
								stb.ClickonPrintStockPosition();
								break;
					}else{
						if (i < stb.getNumOfMainProductRows()) {
							i++;
						}else{
							Assert.assertEquals(false, "Product Details not found for given Inputs");
						}
						 
					}
					}
					}
				
				}else{
					Assert.assertEquals(false, "In Excel Input file Status of Product is not set Properly");
					
				}
				
				
			}
			
		home.ClickOnTabClose("Stock Browser");

		}
	

}
