package StockTestCases;


import java.util.HashMap;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.UBQGenericLib.BaseClassLoader;
import com.UBQGenericLib.ExcelLib;

/**
 * @author Basanagouda
 *
 */
@Listeners(com.UBQGenericLib.SampleListner.class)
public class Tc_Stock_002_HoldStockAndVerificationtestCase extends BaseClassLoader {
	HashMap<String, String> input = new HashMap<String, String>();

	@Test
	public void HoldStockAndVerification() throws Exception {

		ExcelLib stockdata = new ExcelLib("./Testdata/Inputdata.xlsx");
		Thread.sleep(1500);
		home.ClickOnMenu();
		Thread.sleep(500);
		home.ClickOnSubMenuItem("Stock Browser");
		logger.info("Clicked on sub menu item View Stock");
		Thread.sleep(1000);

		for (int n = 1; n <= 2; n++) {
			
			if (stockdata.Excelread("HoldStockCheck",n,8).equalsIgnoreCase("yes")) {
				Long descbookstock = (long) 0;
				Long descholdstock = (long) 0;
				Long descdamagestock = (long) 0;
				Long descmissingstock = (long) 0;
				Long descstolenstock = (long) 0;
				Long descburntstock = (long) 0;
				Long descreconstock = (long) 0;
				Long descintralossstock = (long) 0;
				Long desccombistock = (long) 0;
				input.put("descProductCode", stockdata.Excelread("HoldStockCheck",n,0) );
				input.put("descBatchNo",stockdata.Excelread("HoldStockCheck",n,2));
				input.put("descMRP",stockdata.Excelread("HoldStockCheck",n,3));
				input.put("descProductName",stockdata.Excelread("HoldStockCheck",n,1));
				input.put("descProductFromSerialNo",stockdata.Excelread("HoldStockCheck",n,5));
				input.put("descProductToSerialNo",stockdata.Excelread("HoldStockCheck",n,6));
				input.put("descProductQty",stockdata.Excelread("HoldStockCheck",n,7));
				input.put("descSalableStock", "0");
				input.put("descHoldStock", "0");
				input.put("descDamageStock", "0");
				input.put("descReconsStock", "0");
				input.put("descInTransitLoss","0");
				input.put("descMissingStock","0");
				input.put("descStolenStock", "0");
				input.put("descBurntStock","0");
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
						String getdescbatchno =  stb.getBatchNoAtRow(i);
						String getdescmrp = stb.getMRPAtRow(i);
						if (getdescprodcode.contains(input.get("descProductCode"))
								&& getdescbatchno.contains(input.get("descBatchNo"))
								&& getdescmrp.contains(input.get("descMRP"))){
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
											descbookstock = descbookstock + Long.parseLong(input.get("ProductToSerialNo"))- Long.parseLong(input.get("ProductFromSerialNo"))+1; 
											j++;
										}else if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[A-Za-z0-9]+")){
											descbookstock = descbookstock + 1;
											j++;	
										}else {
											j++;
											System.out.println("Error");
										}
										
										
										
									} else if (prodstate.contains("Hold Stock")) {
										if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[0-9]+")) {
											
											input.put("ProductFromSerialNo", stb.getSerialPopupFromSerialNoAtRow(j));
											input.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
											descholdstock = descholdstock + Long.parseLong(input.get("ProductToSerialNo"))- Long.parseLong(input.get("ProductFromSerialNo"))+1; 
											j++;
										} else if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[A-Za-z0-9]+")){
											descholdstock = descholdstock + 1;
											j++;
										}else{
											j++;
											System.out.println("error");
										}
										
										
									} else if (prodstate.contains("Damaged Stock")) {
										if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[0-9]+")) {
											input.put("ProductFromSerialNo", stb.getSerialPopupFromSerialNoAtRow(j));
											input.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
											descdamagestock = descdamagestock + Long.parseLong(input.get("ProductToSerialNo"))- Long.parseLong(input.get("ProductFromSerialNo"))+1; 
											j++;
										}else if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[A-Za-z0-9]+")){
											descdamagestock = descdamagestock + 1;
											j++;
										}else{
											j++;
											System.out.println("error");
										}
										
									} else if (prodstate.contains("Missing stock")) {
										if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[0-9]+")) {
											input.put("ProductFromSerialNo", stb.getSerialPopupFromSerialNoAtRow(j));
											input.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
											descmissingstock = descmissingstock + Long.parseLong(input.get("ProductToSerialNo"))- Long.parseLong(input.get("ProductFromSerialNo"))+1; 
											j++;
										}else if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[A-Za-z0-9]+")){
											descmissingstock = descmissingstock + 1;
											j++;
										}else{
											j++;
											System.out.println("error");
										}
										
									}else if (prodstate.contains("Stolen stock")) {
										if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[0-9]+")) {
											
											input.put("ProductFromSerialNo", stb.getSerialPopupFromSerialNoAtRow(j));
											input.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
											descstolenstock = descstolenstock + Long.parseLong(input.get("ProductToSerialNo"))- Long.parseLong(input.get("ProductFromSerialNo"))+1; 
											j++;
										}else if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[A-Za-z]+")){
											descstolenstock = descstolenstock + 1;
											j++;
										}else{
											j++;
											System.out.println("error");
										}
										
									} else if (prodstate.contains("Burnt")) {
										if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[0-9]+")) {
											input.put("ProductFromSerialNo", stb.getSerialPopupFromSerialNoAtRow(j));
											input.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
											descburntstock = descburntstock + Long.parseLong(input.get("ProductToSerialNo"))- Long.parseLong(input.get("ProductFromSerialNo"))+1; 
											j++;
										}else if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[A-Za-z0-9]+")){
											descburntstock = descburntstock + 1;
											j++;	
										}else{
											j++;
											System.out.println("error");
										}
										
									} else if (prodstate.contains("Recons Stock")) {
										if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[0-9]+")) {
											input.put("ProductFromSerialNo", stb.getSerialPopupFromSerialNoAtRow(j));
											input.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
											descreconstock = descreconstock + Long.parseLong(input.get("ProductToSerialNo"))- Long.parseLong(input.get("ProductFromSerialNo"))+1; 
											j++;
										}else if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[A-Za-z]+")){
											descreconstock = descreconstock + 1;
											j++;	
										}else{
											j++;
											System.out.println("error");
										}
										
									} else if (prodstate.contains("In-Transit Loss")) {
										if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[0-9]+")) {
											input.put("ProductFromSerialNo", stb.getSerialPopupFromSerialNoAtRow(j));
											input.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
											descintralossstock = descintralossstock + Long.parseLong(input.get("ProductToSerialNo"))- Long.parseLong(input.get("ProductFromSerialNo"))+1; 
											j++;
										}else if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[A-Za-z0-9]+")){
											descintralossstock = descintralossstock + 1;
											j++;	
										}else{
											j++;
											System.out.println("error");
										}
										
									} else if (prodstate.contains("Combi Stock")) {
										if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[0-9]+")) {
											input.put("ProductFromSerialNo", stb.getSerialPopupFromSerialNoAtRow(j));
											input.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
											desccombistock = desccombistock + Long.parseLong(input.get("ProductToSerialNo"))- Long.parseLong(input.get("ProductFromSerialNo"))+1; 
											j++;
										}else if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[A-Za-z0-9]+")){
											desccombistock = desccombistock + 1;
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
								ast.assertEquals(input.get("descSalableStock"),String.valueOf(descbookstock), "Book stock not matching");
								ast.assertEquals(input.get("descHoldStock"),String.valueOf(descholdstock), "Hold stock not matching");
								ast.assertEquals(input.get("descDamageStock"),String.valueOf(descdamagestock), "Damage stock not matching");
								ast.assertEquals(input.get("descReconsStock"),String.valueOf(descreconstock), "Recon stock not matching");
								ast.assertEquals(input.get("descInTransitLoss"),String.valueOf(descintralossstock), "In-Transit Loss not matching");
								ast.assertEquals(input.get("descMissingStock"),String.valueOf(descmissingstock), "Missing stock not matching");
								ast.assertEquals(input.get("descStolenStock"),String.valueOf(descstolenstock), "Stolen Stock not matching");
								ast.assertEquals(input.get("descBurntStock"),String.valueOf(descburntstock), "Burnt stock not matching");
								ast.assertEquals(input.get("descCombiStock"),String.valueOf(desccombistock), "Combi stock not matching");
								Thread.sleep(500);
								stb.ClickonPrintStockBook();
								Thread.sleep(500);
								stb.ClickonPrintStockPosition();
							} else {
								ast.assertEquals(false, "Serial Number Details not found for given Inputs");
							}
							break;
						} else{
							if (i < stb.getNumOfMainProductRows()) {
								i++;
							}else{
								ast.assertEquals(false, "Product Details not found for given Inputs");
							}
							 
						}
					}
				}else{
					ast.assertEquals(false, "Product Details not found for given Inputs");
				}
				
			}else if (stockdata.Excelread("HoldStockCheck",n,8).equalsIgnoreCase("no"))  {
				
				input.put("nondescProductCode",stockdata.Excelread("HoldStockCheck",n,0));
				input.put("nondescBatchNo", stockdata.Excelread("HoldStockCheck",n,2));
				input.put("nondescMRP", stockdata.Excelread("HoldStockCheck",n,3));
				input.put("nondescProductName", stockdata.Excelread("HoldStockCheck",n,1));
				input.put("nondescProductQty",stockdata.Excelread("HoldStockCheck",n,7));
				input.put("nondescSalableStock", "0");
				input.put("nondescHoldStock", "0");
				input.put("nondescDamageStock", "0");
				input.put("nondescReconsStock", "0");
				input.put("nondescInTransitLoss","0");
				input.put("nondescMissingStock","0");
				input.put("nondescStolenStock", "0");
				input.put("nondescBurntStock","0");
				input.put("nondescCombiStock", "0");
				
				ast.assertEquals(stb.getSBU(), "MTN");
				ast.assertEquals(stb.getStore(), "MAIN");
				
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
				}else{
					if (i < stb.getNumOfMainProductRows()) {
						i++;
					}else{
						ast.assertEquals(false, "Product Details not found for given Inputs");
					}
					 
				}
					}
				}
			
			}else{
				ast.assertEquals(false, "In Excel Input file Status of Product is not set Properly");
				
			}
			
			
		}
		home.ClickOnTabClose("Stock Browser");
		
		logger.info("Completed getting Product Details based on given inputs");

		Thread.sleep(1500);
		home.ClickOnMenu();

		home.ClickOnSubMenuItem("Hold / Release Stock");
		logger.info("Started Holding of stock and Verification of Stock in stock browser");
		Thread.sleep(1000);

		hrs.selectSBU("MTN");
		hrs.selectStore("MAIN");
		
		ast.assertEquals(hrs.getDate(), Today());
		hrs.selectOption("Hold Stock");
		
		for (int n = 1; n <= 2; n++) {
		if (stockdata.Excelread("HoldStockCheck",n,8).equalsIgnoreCase("yes")) {
			if (hrs.getNumOfRows() >= 1) {
				hrs.SelectProductCodeAtRow(n);
				if (stb.getNumOfPopupProductRows() >= 1) {
					for (int i = 1; i <= stb.getNumOfPopupProductRows();) {
						if (stb.getPopupProductNameAtRow(i).contains(input.get("descProductName"))
								&& stb.getPopupProductBatchNoAtRow(i).contains(input.get("descBatchNo"))
								&& stb.getPopupProductStockQtyAtRow(i).contains(input.get("descSalableStock") + "/0")) {
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
					ast.assertEquals(stb.getNumOfPopupProductRows(), "Popup Products Number Of rows Not Matching");
				}

				hrs.ClickonSerialNoLinkAtRow(n);

				if (home.getNumOfRowsInCosecutiveSerialNoTable() == 2) {
					home.enterFromSerialNumbersAtRow(2, input.get("descProductFromSerialNo"));
					home.enterToSerialNumbersAtRow(2, input.get("descProductToSerialNo"));

					ast.assertEquals(home.checkProductNameIsReadOnlyAtRow(2), true);
					ast.assertEquals(home.getProductNameAtRow(2), input.get("PopupProductName"));

					long qty = Long.parseLong(input.get("descProductToSerialNo"))
								- Long.parseLong(input.get("descProductFromSerialNo")) + 1;
						input.put("PopupProductQty", String.valueOf(qty));
						ast.assertEquals(Long.parseLong(home.getProductQtyAtRow(2)), qty);

					ast.assertEquals(home.checkQtyIsReadOnlyAtRow(2), true);
					input.put("ProductAdjustmentQty", home.getProductQtyAtRow(2));

					home.clickSerialNoPopUpOkButton();
				}

				
				input.put("ProductReleaseQty", hrs.getQty(n));
				ast.assertEquals(input.get("ProductReleaseQty"), input.get("PopupProductQty"));

				//hrs.clickOnSaveBtn();
				Thread.sleep(1000);
				ast.assertEquals(input.get("PopupProductSalableStock"), input.get("descSalableStock")+"/0", "Popup Product Quantity and Salable stock Quantity is not matching");
				ast.assertEquals(input.get("descProductCode"), hrs.getRowWiseProductCode(n), "Popup Product code and Main Product Code is not matching");
				ast.assertEquals(input.get("descProductName"), hrs.getRowWiseProductName(n), "Popup Product Name and Main Product Name is not matching");
				ast.assertEquals(input.get("descBatchNo"), hrs.getRowWiseBatchNo(n), "Popup Product Batch Number  and Main Product Batch Number is not matching");
				ast.assertEquals(input.get("descMRP")+"0", hrs.getRowWiseMRP(n), "Popup Product MRP and Main Product MRP is not matching");
				ast.assertEquals(input.get("ProductReleaseQty"), input.get("descProductQty"), "Popup Product Qty and Main Product Qty is not matching");

			} else {
				ast.assertEquals(hrs.getNumOfRows(), "Main Select Products Number Of rows Not Matching");
			}	
			
			
		}else if(stockdata.Excelread("HoldStockCheck",n,8).equalsIgnoreCase("no")){
			
			if (hrs.getNumOfRows() >= 1) {
				hrs.SelectProductCodeAtRow(n);
				if (stb.getNumOfPopupProductRows() >= 1) {
					for (int i = 1; i <= stb.getNumOfPopupProductRows();) {
						if (stb.getPopupProductNameAtRow(i).contains(input.get("nondescProductName"))
								&& stb.getPopupProductBatchNoAtRow(i).contains(input.get("nondescBatchNo"))
								&& stb.getPopupProductStockQtyAtRow(i).contains(input.get("nondescSalableStock") + "/0")) {
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
					ast.assertEquals(stb.getNumOfPopupProductRows(), "Popup Products Number Of rows Not Matching");
				}

				
				ast.assertEquals(input.get("PopupProductSalableStock"), input.get("nondescSalableStock")+"/0", "Popup Product Quantity and Salable stock Quantity is not matching");
				ast.assertEquals(input.get("nondescProductCode"), hrs.getRowWiseProductCode(n), "Popup Product code and Main Product Code is not matching");
				ast.assertEquals(input.get("nondescProductName"), hrs.getRowWiseProductName(n), "Popup Product Name and Main Product Name is not matching");
				ast.assertEquals(input.get("nondescBatchNo"), hrs.getRowWiseBatchNo(n), "Popup Product Batch Number  and Main Product Batch Number is not matching");
				ast.assertEquals(input.get("nondescMRP")+".00", hrs.getRowWiseMRP(n), "Popup Product MRP and Main Product MRP is not matching");
				
				hrs.enterQtyatRow(n,Long.parseLong(input.get("nondescProductQty")));
				
				
				
				
			} else {
				ast.assertEquals(sadj.getNumOfRows(), "Main Select Products Number Of rows Not Matching");
			}	
			
			
		}else{
			ast.assertEquals(false, "In Excel Input file Status of Product is not set Properly");
			
		}
		
		}
		
		hrs.clickOnSaveBtn();
		if (wcl.getAlertmsg().contains("Data saved successfully")) {
			wcl.acceptAlert();
			logger.info("Hold Stock Test case completed");
			home.ClickOnTabClose("Hold/Release Stock");
			
			
			Thread.sleep(1500);
			home.ClickOnMenu();
			Thread.sleep(500);
			home.ClickOnSubMenuItem("Stock Browser");
			logger.info("Clicked on sub menu item View Stock");
			Thread.sleep(1000);

			for (int n = 1; n <= 2; n++) {
				
				if (stockdata.Excelread("HoldStockCheck",n,8).equalsIgnoreCase("yes")) {
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
							String getdescbatchno =  stb.getBatchNoAtRow(i);
							String getdescmrp = stb.getMRPAtRow(i);
							if (getdescprodcode.contains(input.get("descProductCode"))
									&& getdescbatchno.contains(input.get("descBatchNo"))
									&& getdescmrp.contains(input.get("descMRP"))){
								input.put("descProductName", stb.getProductNameAtRow(i));
								
								ast.assertEquals(stb.getProductNameAtRow(i), input.get("descProductName"),"Descrite Product Name verification failed");
								ast.assertEquals(stb.getBatchNoAtRow(i), input.get("descBatchNo"),"Descrite Product Batch Number verification failed");
								ast.assertEquals(stb.getMRPAtRow(i), input.get("descMRP"),"Descrite Product MRP verification failed");
								ast.assertEquals(stb.getSalableStockAtRow(i), String.valueOf(Long.parseLong(input.get("descSalableStock"))-1),"Descrite Product Salable Stock verification failed");
								ast.assertEquals(stb.getHoldStockAtRow(i), String.valueOf(Long.parseLong(input.get("descHoldStock"))+1),"Descrite Product Hold Stock verification failed");
								ast.assertEquals(stb.getDamageStockAtRow(i), input.get("descDamageStock"),"Descrite Product Damage Stock verification failed");
								ast.assertEquals(stb.getReconsStockAtRow(i), input.get("descReconsStock"),"Descrite Product Recn. Stock verification failed");
								ast.assertEquals(stb.getInTransitLossAtRow(i), input.get("descInTransitLoss"),"Descrite Product Recn. Stock verification failed");
								ast.assertEquals(stb.getMissingStockAtRow(i), input.get("descMissingStock"),"Descrite Product Missing Stock verification failed");
								ast.assertEquals(stb.getStolenStockAtRow(i), input.get("descStolenStock"),"Descrite Product Stolen. Stock verification failed");
								ast.assertEquals(stb.getBurntStockAtRow(i), input.get("descBurntStock"),"Descrite Product Burnt Stock verification failed");
								ast.assertEquals(stb.getCombiStockAtRow(i), input.get("descCombiStock"),"Descrite Product Combi Stock verification failed");
								
								
								stb.clickOnProductCodeAtRow(i);
								Thread.sleep(1000);
								ast.assertEquals(stb.getSerialNoPopuptitle(), "Serial number list for "
										+ input.get("descProductName") + " (" + input.get("descProductCode") + ")");
								
								if (stb.getNumOfSerialPopupProductRows() >= 1) {
									for (int j = 3; j <= stb.getNumOfSerialPopupProductRows();) {
										String prodstate = stb.getSerialPopupCurrentStateAtRow(j);
										 if (prodstate.contains("Hold Stock")) {
											if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[0-9]+")) {
												if(Long.parseLong(stb.getSerialPopupFromSerialNoAtRow(j)) >= Long.parseLong(input.get("descProductFromSerialNo")) && Long.parseLong(stb.getSerialPopupToSerialNoAtRow(j)) <= Long.parseLong(input.get("descProductToSerialNo"))){
													ast.assertTrue(true,"Hold Stock From and To serial number are matching");
												}
												
												j++;
											} else if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[A-Za-z0-9]+")){
												ast.assertEquals(stb.getSerialPopupFromSerialNoAtRow(j), input.get("descProductFromSerialNo"),"Hold Stock From serial number not matching");
												ast.assertEquals(stb.getSerialPopupToSerialNoAtRow(j), input.get("descProductToSerialNo"),"Hold Stock To serial number not matching");
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
									ast.assertEquals(false, "Serial Number Details not found for given Inputs");
								}
								break;
							} else{
								if (i < stb.getNumOfMainProductRows()) {
									i++;
								}else{
									ast.assertEquals(false, "Product Details not found for given Inputs");
								}
								 
							}
						}
					}else{
						ast.assertEquals(false, "Product Details not found for given Inputs");
					}
					
				}else if (stockdata.Excelread("HoldStockCheck",n,8).equalsIgnoreCase("no"))  {
					
					ast.assertEquals(stb.getSBU(), "MTN");
					ast.assertEquals(stb.getStore(), "MAIN");
					
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
								ast.assertEquals(stb.getProductNameAtRow(i), input.get("nondescProductName"),"Descrite Product Name verification failed");
								ast.assertEquals(stb.getBatchNoAtRow(i), input.get("nondescBatchNo"),"Descrite Product Batch Number verification failed");
								ast.assertEquals(stb.getMRPAtRow(i), input.get("nondescMRP"),"Descrite Product MRP verification failed");
								ast.assertEquals(stb.getSalableStockAtRow(i), String.valueOf(Long.parseLong(input.get("nondescSalableStock"))-1),"Descrite Product Salable Stock verification failed");
								ast.assertEquals(stb.getHoldStockAtRow(i), String.valueOf(Long.parseLong(input.get("nondescHoldStock"))+1),"Descrite Product Hold Stock verification failed");
								ast.assertEquals(stb.getDamageStockAtRow(i), input.get("nondescDamageStock"),"Descrite Product Damage Stock verification failed");
								ast.assertEquals(stb.getReconsStockAtRow(i), input.get("nondescReconsStock"),"Descrite Product Recn. Stock verification failed");
								ast.assertEquals(stb.getInTransitLossAtRow(i), input.get("nondescInTransitLoss"),"Descrite Product Recn. Stock verification failed");
								ast.assertEquals(stb.getMissingStockAtRow(i), input.get("nondescMissingStock"),"Descrite Product Missing Stock verification failed");
								ast.assertEquals(stb.getStolenStockAtRow(i), input.get("nondescStolenStock"),"Descrite Product Stolen. Stock verification failed");
								ast.assertEquals(stb.getBurntStockAtRow(i), input.get("nondescBurntStock"),"Descrite Product Burnt Stock verification failed");
								ast.assertEquals(stb.getCombiStockAtRow(i), input.get("nondescCombiStock"),"Descrite Product Combi Stock verification failed");
								Thread.sleep(500);
								stb.ClickonPrintStockBook();
								Thread.sleep(500);
								stb.ClickonPrintStockPosition();
								break;
					}else{
						if (i < stb.getNumOfMainProductRows()) {
							i++;
						}else{
							ast.assertEquals(false, "Product Details not found for given Inputs");
						}
						 
					}
						}
					}
				
				}else{
					ast.assertEquals(false, "In Excel Input file Status of Product is not set Properly");
					
				}
				
				
			}
			home.ClickOnTabClose("Stock Browser");
			
			
			
	}
		
	}
}

