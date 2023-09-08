package SalesTestCases;

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
public class Tc_Sales_003_BillEntryCreationAndVerification extends BaseClassLoader {
	HashMap<String, String> BillEntry = new HashMap<String, String>();

	@Test
	public void BillEntryCreationAndVerificationtestCase() throws Exception {
		ExcelLib BillData = new ExcelLib("./TestData/Inputdata.xlsx");
		Thread.sleep(1500);
		if (country.equalsIgnoreCase("Nigeria")) {
			Thread.sleep(1500);
			home.ClickonMenutype();
			Thread.sleep(1500);	
		}
		home.ClickOnMenu();
		Thread.sleep(500);
		home.ClickOnSubMenuItem("Stock Browser");
		logger.info("Clicked on sub menu item View Stock");
		Thread.sleep(1000);

		int rows = BillData.getlastrownum("BillEntryCheck");
		for (int n = 1; n <= 2; n++) {
			if (BillData.Excelread("BillEntryCheck", n, 8).equalsIgnoreCase("yes")) {
				Long descbookstock = (long) 0;
				Long descholdstock = (long) 0;
				Long descdamagestock = (long) 0;
				Long descmissingstock = (long) 0;
				Long descstolenstock = (long) 0;
				Long descburntstock = (long) 0;
				Long descreconstock = (long) 0;
				Long descintralossstock = (long) 0;
				Long desccombistock = (long) 0;
				BillEntry.put("descProductCode", BillData.Excelread("BillEntryCheck", n, 0));
				BillEntry.put("descBatchNo", BillData.Excelread("BillEntryCheck", n, 2));
				BillEntry.put("descMRP", BillData.Excelread("BillEntryCheck", n, 3));
				BillEntry.put("descProductName", BillData.Excelread("BillEntryCheck", n, 1));
				BillEntry.put("descProductFromSerialNo", BillData.Excelread("BillEntryCheck", n, 5));
				BillEntry.put("descProductToSerialNo", BillData.Excelread("BillEntryCheck", n, 6));
				BillEntry.put("descProductQty", BillData.Excelread("BillEntryCheck", n, 7));
				// BillEntry.put("descProductStatus",
				// BillData.Excelread("BillEntryCheck", n, 8));
				BillEntry.put("descSalableStock", "0");
				BillEntry.put("descHoldStock", "0");
				BillEntry.put("descDamageStock", "0");
				BillEntry.put("descReconsStock", "0");
				BillEntry.put("descInTransitLoss", "0");
				BillEntry.put("descMissingStock", "0");
				BillEntry.put("descStolenStock", "0");
				BillEntry.put("descBurntStock", "0");
				BillEntry.put("descCombiStock", "0");

				ast.assertEquals(stb.getSBU(), "MTN");
				ast.assertEquals(stb.getStore(), "MAIN");

				stb.enterProductCode(BillEntry.get("descProductCode"));
				Thread.sleep(1000);
				stb.PopupProductSelect();
				stb.clickOnViewBtn();

				if (stb.getNumOfMainProductRows() >= 1) {

					for (int i = 1; i <= stb.getNumOfMainProductRows();) {
						Thread.sleep(500);
						String getdescprodcode = stb.getProductCodeAtRow(i);
						String getdescbatchno = stb.getBatchNoAtRow(i);
						String getdescmrp = stb.getMRPAtRow(i);
						if (getdescprodcode.contains(BillEntry.get("descProductCode"))
								&& getdescbatchno.contains(BillEntry.get("descBatchNo"))
								&& getdescmrp.contains(BillEntry.get("descMRP"))) {
							BillEntry.put("descProductName", stb.getProductNameAtRow(i));
							BillEntry.put("descBatchNo", stb.getBatchNoAtRow(i));
							BillEntry.put("descMRP", stb.getMRPAtRow(i));
							BillEntry.put("descSalableStock", stb.getSalableStockAtRow(i));
							BillEntry.put("descHoldStock", stb.getHoldStockAtRow(i));
							BillEntry.put("descDamageStock", stb.getDamageStockAtRow(i));
							BillEntry.put("descReconsStock", stb.getReconsStockAtRow(i));
							BillEntry.put("descInTransitLoss", stb.getInTransitLossAtRow(i));
							BillEntry.put("descMissingStock", stb.getMissingStockAtRow(i));
							BillEntry.put("descStolenStock", stb.getStolenStockAtRow(i));
							BillEntry.put("descBurntStock", stb.getBurntStockAtRow(i));
							BillEntry.put("descCombiStock", stb.getCombiStockAtRow(i));

							stb.clickOnProductCodeAtRow(i);
							Thread.sleep(1000);
							ast.assertEquals(stb.getSerialNoPopuptitle(), "Serial number list for "
									+ BillEntry.get("descProductName") + " (" + BillEntry.get("descProductCode") + ")");

							if (stb.getNumOfSerialPopupProductRows() >= 1) {
								for (int j = 3; j <= stb.getNumOfSerialPopupProductRows();) {
									String prodstate = stb.getSerialPopupCurrentStateAtRow(j);
									if (prodstate.contains("Book Stock")) {
										if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[0-9]+")) {

											BillEntry.put("ProductFromSerialNo",
													stb.getSerialPopupFromSerialNoAtRow(j));
											BillEntry.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
											descbookstock = descbookstock
													+ Long.parseLong(BillEntry.get("ProductToSerialNo"))
													- Long.parseLong(BillEntry.get("ProductFromSerialNo")) + 1;
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

											BillEntry.put("ProductFromSerialNo",
													stb.getSerialPopupFromSerialNoAtRow(j));
											BillEntry.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
											descholdstock = descholdstock
													+ Long.parseLong(BillEntry.get("ProductToSerialNo"))
													- Long.parseLong(BillEntry.get("ProductFromSerialNo")) + 1;
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
											BillEntry.put("ProductFromSerialNo",
													stb.getSerialPopupFromSerialNoAtRow(j));
											BillEntry.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
											descdamagestock = descdamagestock
													+ Long.parseLong(BillEntry.get("ProductToSerialNo"))
													- Long.parseLong(BillEntry.get("ProductFromSerialNo")) + 1;
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
											BillEntry.put("ProductFromSerialNo",
													stb.getSerialPopupFromSerialNoAtRow(j));
											BillEntry.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
											descmissingstock = descmissingstock
													+ Long.parseLong(BillEntry.get("ProductToSerialNo"))
													- Long.parseLong(BillEntry.get("ProductFromSerialNo")) + 1;
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

											BillEntry.put("ProductFromSerialNo",
													stb.getSerialPopupFromSerialNoAtRow(j));
											BillEntry.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
											descstolenstock = descstolenstock
													+ Long.parseLong(BillEntry.get("ProductToSerialNo"))
													- Long.parseLong(BillEntry.get("ProductFromSerialNo")) + 1;
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
											BillEntry.put("ProductFromSerialNo",
													stb.getSerialPopupFromSerialNoAtRow(j));
											BillEntry.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
											descburntstock = descburntstock
													+ Long.parseLong(BillEntry.get("ProductToSerialNo"))
													- Long.parseLong(BillEntry.get("ProductFromSerialNo")) + 1;
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
											BillEntry.put("ProductFromSerialNo",
													stb.getSerialPopupFromSerialNoAtRow(j));
											BillEntry.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
											descreconstock = descreconstock
													+ Long.parseLong(BillEntry.get("ProductToSerialNo"))
													- Long.parseLong(BillEntry.get("ProductFromSerialNo")) + 1;
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
											BillEntry.put("ProductFromSerialNo",
													stb.getSerialPopupFromSerialNoAtRow(j));
											BillEntry.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
											descintralossstock = descintralossstock
													+ Long.parseLong(BillEntry.get("ProductToSerialNo"))
													- Long.parseLong(BillEntry.get("ProductFromSerialNo")) + 1;
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
											BillEntry.put("ProductFromSerialNo",
													stb.getSerialPopupFromSerialNoAtRow(j));
											BillEntry.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
											desccombistock = desccombistock
													+ Long.parseLong(BillEntry.get("ProductToSerialNo"))
													- Long.parseLong(BillEntry.get("ProductFromSerialNo")) + 1;
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
								ast.assertEquals(BillEntry.get("descSalableStock"), String.valueOf(descbookstock),
										"Book stock not matching");
								ast.assertEquals(BillEntry.get("descHoldStock"), String.valueOf(descholdstock),
										"Hold stock not matching");
								ast.assertEquals(BillEntry.get("descDamageStock"), String.valueOf(descdamagestock),
										"Damage stock not matching");
								ast.assertEquals(BillEntry.get("descReconsStock"), String.valueOf(descreconstock),
										"Recon stock not matching");
								ast.assertEquals(BillEntry.get("descInTransitLoss"), String.valueOf(descintralossstock),
										"In-Transit Loss not matching");
								ast.assertEquals(BillEntry.get("descMissingStock"), String.valueOf(descmissingstock),
										"Missing stock not matching");
								ast.assertEquals(BillEntry.get("descStolenStock"), String.valueOf(descstolenstock),
										"Stolen Stock not matching");
								ast.assertEquals(BillEntry.get("descBurntStock"), String.valueOf(descburntstock),
										"Burnt stock not matching");
								ast.assertEquals(BillEntry.get("descCombiStock"), String.valueOf(desccombistock),
										"Combi stock not matching");
								Thread.sleep(500);
								stb.ClickonPrintStockBook();
								Thread.sleep(500);
								stb.ClickonPrintStockPosition();
							} else {
								ast.assertEquals(false, "Serial Number Details not found for given BillEntrys");
							}
							break;
						} else {
							if (i < stb.getNumOfMainProductRows()) {
								i++;
							} else {
								ast.assertEquals(false, "Product Details not found for given BillEntrys");
							}

						}
					}
				} else {
					ast.assertEquals(false, "Product Details not found for given BillEntrys");
				}

			} else if (BillData.Excelread("BillEntryCheck", n, 8).equalsIgnoreCase("no")) {

				BillEntry.put("nondescProductCode", BillData.Excelread("BillEntryCheck", n, 0));
				BillEntry.put("nondescBatchNo", BillData.Excelread("BillEntryCheck", n, 2));
				BillEntry.put("nondescMRP", BillData.Excelread("BillEntryCheck", n, 3));
				BillEntry.put("nondescProductName", BillData.Excelread("BillEntryCheck", n, 1));
				BillEntry.put("nondescProductQty", BillData.Excelread("BillEntryCheck", n, 7));
				// BillEntry.put("nondescProductStatus",
				// BillData.Excelread("BillEntryCheck", n, 8));
				BillEntry.put("nondescSalableStock", "0");
				BillEntry.put("nondescHoldStock", "0");
				BillEntry.put("nondescDamageStock", "0");
				BillEntry.put("nondescReconsStock", "0");
				BillEntry.put("nondescInTransitLoss", "0");
				BillEntry.put("nondescMissingStock", "0");
				BillEntry.put("nondescStolenStock", "0");
				BillEntry.put("nondescBurntStock", "0");
				BillEntry.put("nondescCombiStock", "0");

				ast.assertEquals(stb.getSBU(), "MTN");
				ast.assertEquals(stb.getStore(), "MAIN");

				stb.enterProductCode(BillEntry.get("nondescProductCode"));
				Thread.sleep(1000);
				stb.PopupProductSelect();
			//	stb.clickOnViewBtn();

				if (stb.getNumOfMainProductRows() >= 1) {

					for (int i = 1; i <= stb.getNumOfMainProductRows();) {
						Thread.sleep(500);
						String getnondescprodcode = stb.getProductCodeAtRow(i);
						String getnondescbatchno = stb.getBatchNoAtRow(i);
						String getnondescmrp = stb.getMRPAtRow(i);

						if (getnondescprodcode.contains(BillEntry.get("nondescProductCode"))
								&& getnondescbatchno.contains(BillEntry.get("nondescBatchNo"))
								&& getnondescmrp.contains(BillEntry.get("nondescMRP"))) {
							BillEntry.put("nondescProductName", stb.getProductNameAtRow(i));
							BillEntry.put("nondescBatchNo", stb.getBatchNoAtRow(i));
							BillEntry.put("nondescMRP", stb.getMRPAtRow(i));
							BillEntry.put("nondescSalableStock", stb.getSalableStockAtRow(i));
							BillEntry.put("nondescHoldStock", stb.getHoldStockAtRow(i));
							BillEntry.put("nondescDamageStock", stb.getDamageStockAtRow(i));
							BillEntry.put("nondescReconsStock", stb.getReconsStockAtRow(i));
							BillEntry.put("nondescInTransitLoss", stb.getInTransitLossAtRow(i));
							BillEntry.put("nondescMissingStock", stb.getMissingStockAtRow(i));
							BillEntry.put("nondescStolenStock", stb.getStolenStockAtRow(i));
							BillEntry.put("nondescBurntStock", stb.getBurntStockAtRow(i));
							BillEntry.put("nondescCombiStock", stb.getCombiStockAtRow(i));
							Thread.sleep(500);
							stb.ClickonPrintStockBook();
							Thread.sleep(500);
							stb.ClickonPrintStockPosition();
							break;
						} else {
							if (i < stb.getNumOfMainProductRows()) {
								i++;
							} else {
								ast.assertEquals(false, "Product Details not found for given BillEntrys");
							}

						}
					}
				}

			} else {
				ast.assertEquals(false, "In Excel BillEntry file Status of Product is not set Properly");

			}

		}
		home.ClickOnTabClose("Stock Browser");

		logger.info("Completed getting Product Details based on given BillEntrys");

		Thread.sleep(1500);
		home.ClickOnMenu();
		home.ClickOnSubMenuItem("Bill Entry");
		BillEntry.put("DSA", "Gautam");
		BillEntry.put("Route", "ABOISSO");
		BillEntry.put("CustomerCode", "RLNO000000112");
		BillEntry.put("PayMode", "Cash");

		Thread.sleep(1000);

		bentry.clickCalculatebtn();
		Thread.sleep(1000);
		if (wcl.getAlertmsg().equalsIgnoreCase("Please select DSA.")) {
			wcl.acceptAlert();
			bentry.selectSalesman(BillEntry.get("DSA"));
		} else {
			System.out.println("DSA name not matching");
		}

		bentry.clickCalculatebtn();
		Thread.sleep(1000);
		if (wcl.getAlertmsg().equalsIgnoreCase("Please select Route name")) {
			wcl.acceptAlert();
			bentry.selectRoute(BillEntry.get("Route"));
		} else {
			System.out.println("Route name not Matching");
		}
		bentry.clickCalculatebtn();
		Thread.sleep(1000);
		if (wcl.getAlertmsg().equalsIgnoreCase("Please select customer name.")) {
			wcl.acceptAlert();
			Thread.sleep(1500);

		}
		bentry.selectCustomerCode(BillEntry.get("CustomerCode"));
		Thread.sleep(500);
		bentry.clickCalculatebtn();
		if (wcl.getAlertmsg().equalsIgnoreCase("Please select mode of payment")) {
			wcl.acceptAlert();
			bentry.SelectPayMode(BillEntry.get("PayMode"));
		} else {
			System.out.println("PayMode not Matching");
		}
		Thread.sleep(500);

		for (int n = 1; n <= 2; n++) {
			if (BillData.Excelread("BillEntryCheck", n, 8).equalsIgnoreCase("yes")) {
				if (bentry.getNumOfProductRows() >= 1) {
					bentry.SelectProductNameForMultipleRows(n);
					if (stb.getNumOfPopupProductRows() >= 1) {
						for (int i = 1; i <= stb.getNumOfPopupProductRows();) {
							if (stb.getPopupProductNameAtRow(i).contains(BillEntry.get("descProductName"))
									&& stb.getPopupProductBatchNoAtRow(i).contains(BillEntry.get("descBatchNo"))
									&& stb.getPopupProductStockQtyAtRow(i)
											.contains(BillEntry.get("descSalableStock") + "/0")) {
								BillEntry.put("PopupProductCode", stb.getPopupProductCodeAtRow(i));
								BillEntry.put("PopupProductName", stb.getPopupProductNameAtRow(i));
								BillEntry.put("PopupProductMRP", stb.getPopupProductMRPAtRow(i));
								BillEntry.put("PopupProductSalableStock", stb.getPopupProductStockQtyAtRow(i));
								BillEntry.put("PopupProductBatchNo", stb.getPopupProductBatchNoAtRow(i));

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

					bentry.ClickonSerialNoLinkAtRow(n);

					if (home.getNumOfRowsInCosecutiveSerialNoTable() == 2) {
						home.enterFromSerialNumbersAtRow(2, BillEntry.get("descProductFromSerialNo"));
						home.enterToSerialNumbersAtRow(2, BillEntry.get("descProductToSerialNo"));

						ast.assertEquals(home.checkProductNameIsReadOnlyAtRow(2), true);
						ast.assertEquals(home.getProductNameAtRow(2), BillEntry.get("PopupProductName"));

						long qty = Long.parseLong(BillEntry.get("descProductToSerialNo"))
								- Long.parseLong(BillEntry.get("descProductFromSerialNo")) + 1;
						BillEntry.put("PopupProductQty", String.valueOf(qty));
						ast.assertEquals(Long.parseLong(home.getProductQtyAtRow(2)), qty);

						ast.assertEquals(home.checkQtyIsReadOnlyAtRow(2), true);
						BillEntry.put("ProductAdjustmentQty", home.getProductQtyAtRow(2));

						home.clickSerialNoPopUpOkButton();
					}
					Thread.sleep(1000);
					ast.assertEquals(BillEntry.get("PopupProductSalableStock"),
							BillEntry.get("descSalableStock") + "/0",
							"Popup Product Quantity and Salable stock Quantity is not matching");
					ast.assertEquals(BillEntry.get("descProductCode"), bentry.getProductCodeAtRow(n),
							"Popup Product code and Main Product Code is not matching");
					ast.assertEquals(BillEntry.get("descProductName"), bentry.getProductNameAtRow(n),
							"Popup Product Name and Main Product Name is not matching");
					ast.assertEquals(BillEntry.get("descMRP") + "0", bentry.getProductMRPAtRow(n),
							"Popup Product MRP and Main Product MRP is not matching");

				} else {
					ast.assertEquals(bentry.getNumOfProductRows(), "Main Select Products Number Of rows Not Matching");
				}

			} else if (BillData.Excelread("BillEntryCheck", n, 8).equalsIgnoreCase("no")) {

				if (bentry.getNumOfProductRows() >= 1) {
					bentry.SelectProductNameForMultipleRows(n);
					if (stb.getNumOfPopupProductRows() >= 1) {
						for (int i = 1; i <= stb.getNumOfPopupProductRows();) {
							if (stb.getPopupProductNameAtRow(i).contains(BillEntry.get("nondescProductName"))
									&& stb.getPopupProductBatchNoAtRow(i).contains(BillEntry.get("nondescBatchNo"))
									&& stb.getPopupProductStockQtyAtRow(i)
											.contains(BillEntry.get("nondescSalableStock") + "/0")) {
								BillEntry.put("PopupProductCode", stb.getPopupProductCodeAtRow(i));
								BillEntry.put("PopupProductName", stb.getPopupProductNameAtRow(i));
								BillEntry.put("PopupProductMRP", stb.getPopupProductMRPAtRow(i));
								BillEntry.put("PopupProductSalableStock", stb.getPopupProductStockQtyAtRow(i));
								BillEntry.put("PopupProductBatchNo", stb.getPopupProductBatchNoAtRow(i));

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

					ast.assertEquals(BillEntry.get("PopupProductSalableStock"),
							BillEntry.get("nondescSalableStock") + "/0",
							"Popup Product Quantity and Salable stock Quantity is not matching");
					ast.assertEquals(BillEntry.get("nondescProductCode"), bentry.getProductCodeAtRow(n),
							"Popup Product code and Main Product Code is not matching");
					ast.assertEquals(BillEntry.get("nondescProductName"), bentry.getProductNameAtRow(n),
							"Popup Product Name and Main Product Name is not matching");
					ast.assertEquals(BillEntry.get("nondescMRP") + ".00", bentry.getProductMRPAtRow(n),
							"Popup Product MRP and Main Product MRP is not matching");

					bentry.enterQtyatRow(n, Long.parseLong(BillEntry.get("nondescProductQty")));

				} else {
					ast.assertEquals(bentry.getNumOfProductRows(), "Main Select Products Number Of rows Not Matching");
				}

			} else {
				ast.assertEquals(false, "In Excel Input file Status of Product is not set Properly");

			}

		}
		bentry.clickCalculatebtn();
		bentry.clickOnPopupSRcancelBtn();
		bentry.clickConfirmbtn();
		if (wcl.getAlertmsg().contains("Do you want to confirm?")) {
			wcl.acceptAlert();
			logger.info("Bill Entry Test case completed");
		} else {
			logger.info("Unable to find the alert Do you want to confirm? ");
		}
		if (wcl.getAlertmsg().contains("Data saved successfully")) {
			wcl.acceptAlert();
			logger.info("Bill Entry Test case completed");
			home.ClickOnTabClose("Bill Entry");
		} else {
			logger.info("Unable to file the alert Data saved successfully");
		}

		Thread.sleep(1500);
		home.ClickOnMenu();
		Thread.sleep(500);
		home.ClickOnSubMenuItem("Stock Browser");
		logger.info("Clicked on sub menu item View Stock");
		Thread.sleep(1000);

		for (int n = 1; n <= 2; n++) {

			if (BillData.Excelread("BillEntryCheck", n, 8).equalsIgnoreCase("yes")) {
				ast.assertEquals(stb.getSBU(), "MTN");
				ast.assertEquals(stb.getStore(), "MAIN");

				stb.enterProductCode(BillEntry.get("descProductCode"));
				Thread.sleep(1000);
				stb.PopupProductSelect();
				stb.clickOnViewBtn();

				if (stb.getNumOfMainProductRows() >= 1) {

					for (int i = 1; i <= stb.getNumOfMainProductRows();) {
						Thread.sleep(500);
						String getdescprodcode = stb.getProductCodeAtRow(i);
						String getdescbatchno = stb.getBatchNoAtRow(i);
						String getdescmrp = stb.getMRPAtRow(i);
						if (getdescprodcode.contains(BillEntry.get("descProductCode"))
								&& getdescbatchno.contains(BillEntry.get("descBatchNo"))
								&& getdescmrp.contains(BillEntry.get("descMRP"))) {
							BillEntry.put("descProductName", stb.getProductNameAtRow(i));

							ast.assertEquals(stb.getProductNameAtRow(i), BillEntry.get("descProductName"),
									"Descrite Product Name verification failed");
							ast.assertEquals(stb.getBatchNoAtRow(i), BillEntry.get("descBatchNo"),
									"Descrite Product Batch Number verification failed");
							ast.assertEquals(stb.getMRPAtRow(i), BillEntry.get("descMRP"),
									"Descrite Product MRP verification failed");
							ast.assertEquals(stb.getSalableStockAtRow(i),
									String.valueOf(Long.parseLong(BillEntry.get("descSalableStock")) - 1),
									"Descrite Product Salable Stock verification failed");
							ast.assertEquals(stb.getHoldStockAtRow(i),
									String.valueOf(Long.parseLong(BillEntry.get("descHoldStock")) + 1),
									"Descrite Product Hold Stock verification failed");
							ast.assertEquals(stb.getDamageStockAtRow(i), BillEntry.get("descDamageStock"),
									"Descrite Product Damage Stock verification failed");
							ast.assertEquals(stb.getReconsStockAtRow(i), BillEntry.get("descReconsStock"),
									"Descrite Product Recn. Stock verification failed");
							ast.assertEquals(stb.getInTransitLossAtRow(i), BillEntry.get("descInTransitLoss"),
									"Descrite Product Recn. Stock verification failed");
							ast.assertEquals(stb.getMissingStockAtRow(i), BillEntry.get("descMissingStock"),
									"Descrite Product Missing Stock verification failed");
							ast.assertEquals(stb.getStolenStockAtRow(i), BillEntry.get("descStolenStock"),
									"Descrite Product Stolen. Stock verification failed");
							ast.assertEquals(stb.getBurntStockAtRow(i), BillEntry.get("descBurntStock"),
									"Descrite Product Burnt Stock verification failed");
							ast.assertEquals(stb.getCombiStockAtRow(i), BillEntry.get("descCombiStock"),
									"Descrite Product Combi Stock verification failed");

							stb.clickOnProductCodeAtRow(i);
							Thread.sleep(1000);
							ast.assertEquals(stb.getSerialNoPopuptitle(), "Serial number list for "
									+ BillEntry.get("descProductName") + " (" + BillEntry.get("descProductCode") + ")");

							if (stb.getNumOfSerialPopupProductRows() >= 1) {
								for (int j = 3; j <= stb.getNumOfSerialPopupProductRows();) {
									String prodstate = stb.getSerialPopupCurrentStateAtRow(j);
									if (prodstate.contains("Hold Stock")) {
										if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[0-9]+")) {
											if (Long.parseLong(stb.getSerialPopupFromSerialNoAtRow(j)) >= Long
													.parseLong(BillEntry.get("descProductFromSerialNo"))
													&& Long.parseLong(stb.getSerialPopupToSerialNoAtRow(j)) <= Long
															.parseLong(BillEntry.get("descProductToSerialNo"))) {
												ast.assertTrue(true,
														"Hold Stock From and To serial number are matching");
											}

											j++;
										} else if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[A-Za-z0-9]+")) {
											ast.assertEquals(stb.getSerialPopupFromSerialNoAtRow(j),
													BillEntry.get("descProductFromSerialNo"),
													"Hold Stock From serial number not matching");
											ast.assertEquals(stb.getSerialPopupToSerialNoAtRow(j),
													BillEntry.get("descProductToSerialNo"),
													"Hold Stock To serial number not matching");
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
								Thread.sleep(500);
								stb.ClickonPrintStockBook();
								Thread.sleep(500);
								stb.ClickonPrintStockPosition();
							} else {
								ast.assertEquals(false, "Serial Number Details not found for given Inputs");
							}
							break;
						} else {
							if (i < stb.getNumOfMainProductRows()) {
								i++;
							} else {
								ast.assertEquals(false, "Product Details not found for given Inputs");
							}

						}
					}
				} else {
					ast.assertEquals(false, "Product Details not found for given Inputs");
				}

			} else if (BillData.Excelread("BillEntryCheck", n, 8).equalsIgnoreCase("no")) {

				ast.assertEquals(stb.getSBU(), "MTN");
				ast.assertEquals(stb.getStore(), "MAIN");

				stb.enterProductCode(BillEntry.get("nondescProductCode"));
				Thread.sleep(1000);
				stb.PopupProductSelect();
				stb.clickOnViewBtn();

				if (stb.getNumOfMainProductRows() >= 1) {

					for (int i = 1; i <= stb.getNumOfMainProductRows();) {
						Thread.sleep(500);
						String getnondescprodcode = stb.getProductCodeAtRow(i);
						String getnondescbatchno = stb.getBatchNoAtRow(i);
						String getnondescmrp = stb.getMRPAtRow(i);

						if (getnondescprodcode.contains(BillEntry.get("nondescProductCode"))
								&& getnondescbatchno.contains(BillEntry.get("nondescBatchNo"))
								&& getnondescmrp.contains(BillEntry.get("nondescMRP"))) {
							ast.assertEquals(stb.getProductNameAtRow(i), BillEntry.get("nondescProductName"),
									"Descrite Product Name verification failed");
							ast.assertEquals(stb.getBatchNoAtRow(i), BillEntry.get("nondescBatchNo"),
									"Descrite Product Batch Number verification failed");
							ast.assertEquals(stb.getMRPAtRow(i), BillEntry.get("nondescMRP"),
									"Descrite Product MRP verification failed");
							ast.assertEquals(stb.getSalableStockAtRow(i),
									String.valueOf(Long.parseLong(BillEntry.get("nondescSalableStock")) - 1),
									"Descrite Product Salable Stock verification failed");
							ast.assertEquals(stb.getHoldStockAtRow(i),
									String.valueOf(Long.parseLong(BillEntry.get("nondescHoldStock")) + 1),
									"Descrite Product Hold Stock verification failed");
							ast.assertEquals(stb.getDamageStockAtRow(i), BillEntry.get("nondescDamageStock"),
									"Descrite Product Damage Stock verification failed");
							ast.assertEquals(stb.getReconsStockAtRow(i), BillEntry.get("nondescReconsStock"),
									"Descrite Product Recn. Stock verification failed");
							ast.assertEquals(stb.getInTransitLossAtRow(i), BillEntry.get("nondescInTransitLoss"),
									"Descrite Product Recn. Stock verification failed");
							ast.assertEquals(stb.getMissingStockAtRow(i), BillEntry.get("nondescMissingStock"),
									"Descrite Product Missing Stock verification failed");
							ast.assertEquals(stb.getStolenStockAtRow(i), BillEntry.get("nondescStolenStock"),
									"Descrite Product Stolen. Stock verification failed");
							ast.assertEquals(stb.getBurntStockAtRow(i), BillEntry.get("nondescBurntStock"),
									"Descrite Product Burnt Stock verification failed");
							ast.assertEquals(stb.getCombiStockAtRow(i), BillEntry.get("nondescCombiStock"),
									"Descrite Product Combi Stock verification failed");
							Thread.sleep(500);
							stb.ClickonPrintStockBook();
							Thread.sleep(500);
							stb.ClickonPrintStockPosition();
							break;
						} else {
							if (i < stb.getNumOfMainProductRows()) {
								i++;
							} else {
								ast.assertEquals(false, "Product Details not found for given Inputs");
							}

						}
					}
				}

			} else {
				ast.assertEquals(false, "In Excel Input file Status of Product is not set Properly");

			}

		}
		home.ClickOnTabClose("Stock Browser");
		ExcelLib BillsaveData = new ExcelLib("./Testdata/Inputdata.xlsx");
		String producstatus = BillEntry.get("nondescProductStatus");
		if (producstatus == "no") {
			String data[] = { BillEntry.get("nondescProductCode"), BillEntry.get("nondescProductName"),
					BillEntry.get("nondescMRP"), BillEntry.get("nondescProductQty"),
					BillEntry.get("nondescProductStatus") };
			BillsaveData.Excelwrite("./Testdata/Inputdata.xlsx", "BillBrowserverification", data);
		} else {
			String data[] = { BillEntry.get("descProductCode"), BillEntry.get("descProductName"),
					BillEntry.get("descMRP"), BillEntry.get("descProductFromSerialNo"),
					BillEntry.get("descProductToSerialNo"), BillEntry.get("PopupProductQty") };
			BillsaveData.Excelwrite("./Testdata/Inputdata.xlsx", "BillBrowserverification", data);
		}
	}

}
