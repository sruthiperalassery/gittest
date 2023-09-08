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
public class Tc_Stock_011_OpeningStockForNonDescriteProductTestCase extends BaseClassLoader {
	HashMap<String, String> input = new HashMap<String, String>();

	@Test
	public void openingStockNonForDescriteProduct() throws Exception {
		ExcelLib stockdata = new ExcelLib("./Testdata/Inputdata.xlsx");

	
		Thread.sleep(1500);
		home.ClickOnMenu();
		Thread.sleep(500);
		home.ClickOnSubMenuItem("Stock Browser");
		logger.info("Clicked on sub menu item View Stock");
		Thread.sleep(1000);

		int rows = stockdata.getlastrownum("OpeningData");
		for (int n = 1; n <= rows; n++) {

			if (stockdata.Excelread("OpeningData", n, 8).equalsIgnoreCase("yes")) {
				Long descbookstock = (long) 0;
				Long descholdstock = (long) 0;
				Long descdamagestock = (long) 0;
				Long descmissingstock = (long) 0;
				Long descstolenstock = (long) 0;
				Long descburntstock = (long) 0;
				Long descreconstock = (long) 0;
				Long descintralossstock = (long) 0;
				Long desccombistock = (long) 0;
				input.put("category", stockdata.Excelread("OpeningData", n, 0));
				input.put("descProductCode", stockdata.Excelread("OpeningData", n, 1));
				input.put("descProductName", stockdata.Excelread("OpeningData", n, 2));
				input.put("descBatchNo", stockdata.Excelread("OpeningData", n, 3));
				input.put("descMRP", stockdata.Excelread("OpeningData", n, 4));
				input.put("descProductFromSerialNo", stockdata.Excelread("OpeningData", n, 5));
				input.put("descProductToSerialNo", stockdata.Excelread("OpeningData", n, 6));
				input.put("descProductQty", stockdata.Excelread("OpeningData", n, 8));
				input.put("descSalableStock", "0");
				input.put("descHoldStock", "0");
				input.put("descDamageStock", "0");
				input.put("descReconsStock", "0");
				input.put("descInTransitLoss", "0");
				input.put("descMissingStock", "0");
				input.put("descStolenStock", "0");
				input.put("descBurntStock", "0");
				input.put("descCombiStock", "0");

				ast.assertEquals(stb.getSBU(), "MTN");
				ast.assertEquals(stb.getStore(), "MAIN");

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
							ast.assertEquals(stb.getSerialNoPopuptitle(), "Serial number list for "
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
								ast.assertEquals(input.get("descSalableStock"), String.valueOf(descbookstock),
										"Book stock not matching");
								ast.assertEquals(input.get("descHoldStock"), String.valueOf(descholdstock),
										"Hold stock not matching");
								ast.assertEquals(input.get("descDamageStock"), String.valueOf(descdamagestock),
										"Damage stock not matching");
								ast.assertEquals(input.get("descReconsStock"), String.valueOf(descreconstock),
										"Recon stock not matching");
								ast.assertEquals(input.get("descInTransitLoss"), String.valueOf(descintralossstock),
										"In-Transit Loss not matching");
								ast.assertEquals(input.get("descMissingStock"), String.valueOf(descmissingstock),
										"Missing stock not matching");
								ast.assertEquals(input.get("descStolenStock"), String.valueOf(descstolenstock),
										"Stolen Stock not matching");
								ast.assertEquals(input.get("descBurntStock"), String.valueOf(descburntstock),
										"Burnt stock not matching");
								ast.assertEquals(input.get("descCombiStock"), String.valueOf(desccombistock),
										"Combi stock not matching");
								Thread.sleep(500);
								stb.ClickonPrintStockBook();
								Thread.sleep(500);
								stb.ClickonPrintStockPosition();
							} else {
								ast.assertEquals(false, "Serial Number Details not found for given Inputs");
							}
							break;
						} else {
							if (i <= stb.getNumOfMainProductRows()) {
								i++;
							}

						}

						Thread.sleep(500);
						stb.ClickonPrintStockBook();
						Thread.sleep(500);
						stb.ClickonPrintStockPosition();
					}
				}
				Thread.sleep(500);
				stb.ClickonPrintStockBook();
				Thread.sleep(500);
				stb.ClickonPrintStockPosition();

			} else if (stockdata.Excelread("OpeningData", n, 7).equalsIgnoreCase("no")) {
				input.put("nondecCategory", stockdata.Excelread("OpeningData", n, 0));
				input.put("nondescProductCode", stockdata.Excelread("OpeningData", n, 1));
				input.put("nondescProductName", stockdata.Excelread("OpeningData", n, 2));
				input.put("nondescBatchNo", stockdata.Excelread("OpeningData", n, 3));
				input.put("nondescMRP", stockdata.Excelread("OpeningData", n, 4));
				input.put("nondescProductQty", stockdata.Excelread("OpeningData", n, 8));
				input.put("nondescSalableStock", "0");
				input.put("nondescHoldStock", "0");
				input.put("nondescDamageStock", "0");
				input.put("nondescReconsStock", "0");
				input.put("nondescInTransitLoss", "0");
				input.put("nondescMissingStock", "0");
				input.put("nondescStolenStock", "0");
				input.put("nondescBurntStock", "0");
				input.put("nondescCombiStock", "0");

				ast.assertEquals(stb.getSBU(), "MTN");
				ast.assertEquals(stb.getStore(), "MAIN");

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
							if (i <= stb.getNumOfMainProductRows()) {
								i++;
							}

						}
						Thread.sleep(500);
						stb.ClickonPrintStockBook();
						Thread.sleep(500);
						stb.ClickonPrintStockPosition();

					}
				}

			} else {

			}

		}
		home.ClickOnTabClose("Stock Browser");

		logger.info("Completed getting Product Details based on given inputs");
		Thread.sleep(500);

		home.ClickOnMenu();
		Thread.sleep(1000);
		home.ClickOnSubMenuItem("Opening Stock");

		Thread.sleep(5000);
		ostk.selectCategory(input.get("nondecCategory"));
		ostk.enterSKU(input.get("nondescProductCode"));
		ostk.clickOnViewBtn();

		for (int i = 1; i <= ostk.getNumOfProductRows(); i++) {
			String getprodcode = ostk.getProductCodeAtRow(i);
			String getprodName = ostk.getProductNameAtRow(i);
			String getdescmrp = ostk.getProductMRPAtRow(i);

			if (getprodcode.contains(input.get("nondescProductCode"))
					&& getprodName.contains(input.get("nondescProductName"))
					&& getdescmrp.contains(input.get("nondescMRP"))) {
				ostk.enterProductMRPAtRow(1, input.get("nondescMRP"));
				input.put("PackDate", Today());
				ostk.enterPackDateAtRow(1, input.get("PackDate"));
				ostk.enterQtyAtRow(1, input.get("nondescProductQty"));

			} else {
				ostk.enterProductMRPAtRow(i, input.get("nondescMRP"));
				input.put("PackDate", Today());
				ostk.enterPackDateAtRow(1, input.get("PackDate"));
				ostk.enterQtyAtRow(1, input.get("nondescProductQty"));

			}

		}
		ostk.clickOnSaveBtn();
		if (wcl.getAlertmsg().contains("Data saved successfully.")) {
			Thread.sleep(200);
			wcl.acceptAlert();
			Thread.sleep(500);
		}

		home.ClickOnTabClose("Opening Stock");

		home.ClickOnMenu();
		Thread.sleep(500);                       
		home.ClickOnSubMenuItem("Stock Browser");
		logger.info("Clicked on sub menu item View Stock");
		Thread.sleep(1000);

		ast.assertEquals(stb.getSBU(), "MTN");
		ast.assertEquals(stb.getStore(), "MAIN");
		stb.enterProductCode(input.get("nondescProductCode"));
		Thread.sleep(500);
		stb.PopupProductSelect();
		Thread.sleep(300);
		stb.clickOnViewBtn();

		if (stb.getNumOfMainProductRows() >= 1) {

			for (int i = 1; i <= stb.getNumOfMainProductRows();) {

				String getprodcode = ostk.getProductCodeAtRow(i);
				String getprodName = ostk.getProductNameAtRow(i);
				String getdescmrp = ostk.getProductMRPAtRow(i);

				if (getprodcode.contains(input.get("nondescProductCode"))
						&& getprodName.contains(input.get("nondescProductName"))
						&& getdescmrp.contains(input.get("nondescMRP"))) {

					ast.assertEquals(stb.getProductCodeAtRow(i), input.get("nondescProductCode"),
							"nonDescrite Product Name verification failed");
					ast.assertEquals(stb.getProductNameAtRow(i), input.get("nondescProductName"),
							"nonDescrite Product Name verification failed");
					ast.assertEquals(stb.getBatchNoAtRow(i), input.get("nondescBatchNo"),
							"nonDescrite Product Batch Number verification failed");
					ast.assertEquals(stb.getMRPAtRow(i), input.get("nondescMRP"),
							"nonDescrite Product MRP verification failed");
					String salablestock = input.get("nondescSalableStock");
					String qtystock = input.get("nondescProductQty");
					String s3 = salablestock + qtystock;

					ast.assertEquals(stb.getSalableStockAtRow(i),
							input.get("nondescSalableStock") + input.get("nondescProductQty"),
							"nonDescrite Product Salable Stock verification failed");

					ast.assertEquals(stb.getHoldStockAtRow(i), input.get("nondescHoldStock"),
							"nonDescrite Product Hold Stock verification failed");
					ast.assertEquals(stb.getDamageStockAtRow(i), input.get("nondescDamageStock"),
							"nonDescrite Product Damage Stock verification failed");
					ast.assertEquals(stb.getReconsStockAtRow(i), input.get("nondescReconsStock"),
							"nonDescrite Product Recn. Stock verification failed");
					ast.assertEquals(stb.getInTransitLossAtRow(i), input.get("nondescInTransitLoss"),
							"nonDescrite Product Recn. Stock verification failed");
					ast.assertEquals(stb.getMissingStockAtRow(i), input.get("nondescMissingStock"),
							"nonDescrite Product Missing Stock verification failed");
					ast.assertEquals(stb.getStolenStockAtRow(i), input.get("nondescStolenStock"),
							"nonDescrite Product Stolen. Stock verification failed");
					ast.assertEquals(stb.getBurntStockAtRow(i), input.get("nondescBurntStock"),
							"nonDescrite Product Burnt Stock verification failed");

					ast.assertEquals(stb.getCombiStockAtRow(i), input.get("nondescCombiStock"),
							"nonDescrite Product Combi Stock verification failed");
					Thread.sleep(500);
					stb.ClickonPrintStockBook();
					Thread.sleep(500);
					stb.ClickonPrintStockPosition();
					break;

				} else {
					logger.info("Product details not matching");
				}
			}
		}

		home.ClickOnTabClose("Opening Stock");
		ast.assertAll();

	}
}
