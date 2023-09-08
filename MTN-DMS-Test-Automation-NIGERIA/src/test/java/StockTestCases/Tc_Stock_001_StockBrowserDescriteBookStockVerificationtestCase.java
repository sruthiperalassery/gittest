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
public class Tc_Stock_001_StockBrowserDescriteBookStockVerificationtestCase extends BaseClassLoader {
	HashMap<String, String> input = new HashMap<String, String>();

	@Test
	public void StockBrowserDescriteBookStockVerificationtestCase() throws Exception {
		
		ExcelLib stockdata = new ExcelLib("./Testdata/Inputdata.xlsx");
		Thread.sleep(1500);
		/*home.ClickonMenutype();
		Thread.sleep(1500);*/
		home.ClickOnMenu();
		Thread.sleep(500);
		home.ClickOnSubMenuItem("Stock Browser");
		logger.info("Clicked on sub menu item View Stock");
		Thread.sleep(1000);

		int rows = stockdata.getlastrownum("Stockandserialcheck");
		for (int n = 1; n <= rows; n++) {
			Long bookstock = (long) 0;
			Long holdstock = (long) 0;
			Long damagestock = (long) 0;
			Long missingstock = (long) 0;
			Long stolenstock = (long) 0;
			Long burntstock = (long) 0;
			Long reconstock = (long) 0;
			Long intralossstock = (long) 0;
			Long combistock = (long) 0;
			
			String prodcode = stockdata.Excelread("Stockandserialcheck",n,0);
			String batchno =  stockdata.Excelread("Stockandserialcheck",n,1);
			String mrp =  stockdata.Excelread("Stockandserialcheck",n,2);
			input.put("ProductCode", prodcode );
			input.put("BatchNo",batchno);
			input.put("MRP",mrp);
			input.put("ProductName", "");
			input.put("SalableStock", "0");
			input.put("HoldStock", "0");
			input.put("DamageStock", "0");
			input.put("ReconsStock", "0");
			input.put("InTransitLoss","0");
			input.put("MissingStock","0");
			input.put("StolenStock", "0");
			input.put("BurntStock","0");
			input.put("CombiStock", "0");
			
			ast.assertEquals(stb.getSBU(), "MTN");
			ast.assertEquals(stb.getStore(), "MAIN");

			stb.enterProductCode(input.get("ProductCode"));
			Thread.sleep(1000);
			stb.PopupProductSelect();
			stb.clickOnViewBtn();
			
			if (stb.getNumOfMainProductRows() >= 1) {
				
				for (int i = 1; i <= stb.getNumOfMainProductRows();) {
					Thread.sleep(500);
					if (stb.getProductCodeAtRow(i).contains(input.get("ProductCode"))
							&& stb.getBatchNoAtRow(i).contains(input.get("BatchNo"))
							&& stb.getMRPAtRow(i).contains(input.get("MRP"))){
						input.put("ProductName", stb.getProductNameAtRow(i));
						input.put("BatchNo", stb.getBatchNoAtRow(i));
						input.put("MRP", stb.getMRPAtRow(i));
						input.put("SalableStock", stb.getSalableStockAtRow(i));
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
						ast.assertEquals(stb.getSerialNoPopuptitle(), "Serial number list for "
								+ input.get("ProductName") + " (" + input.get("ProductCode") + ")");
						
						if (stb.getNumOfSerialPopupProductRows() >= 1) {
							for (int j = 3; j <= stb.getNumOfSerialPopupProductRows();) {
								String prodstate = stb.getSerialPopupCurrentStateAtRow(j);
								if (prodstate.contains("Book Stock")) {
									if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[0-9]+")) {
										
										input.put("ProductFromSerialNo", stb.getSerialPopupFromSerialNoAtRow(j));
										input.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
										bookstock = bookstock + Long.parseLong(input.get("ProductToSerialNo"))- Long.parseLong(input.get("ProductFromSerialNo"))+1; 
										j++;
									}else if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[A-Za-z0-9]+")){
										bookstock = bookstock + 1;
										j++;	
									}else {
										j++;
										System.out.println("Error");
									}
									
									
									
								} else if (prodstate.contains("Hold Stock")) {
									if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[0-9]+")) {
										
										input.put("ProductFromSerialNo", stb.getSerialPopupFromSerialNoAtRow(j));
										input.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
										holdstock = holdstock + Long.parseLong(input.get("ProductToSerialNo"))- Long.parseLong(input.get("ProductFromSerialNo"))+1; 
										j++;
									} else if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[A-Za-z0-9]+")){
										holdstock = holdstock + 1;
										j++;
									}else{
										j++;
										System.out.println("error");
									}
									
									
								} else if (prodstate.contains("Damaged Stock")) {
									if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[0-9]+")) {
										input.put("ProductFromSerialNo", stb.getSerialPopupFromSerialNoAtRow(j));
										input.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
										damagestock = damagestock + Long.parseLong(input.get("ProductToSerialNo"))- Long.parseLong(input.get("ProductFromSerialNo"))+1; 
										j++;
									}else if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[A-Za-z0-9]+")){
										damagestock = damagestock + 1;
										j++;
									}else{
										j++;
										System.out.println("error");
									}
									
								} else if (prodstate.contains("Missing stock")) {
									if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[0-9]+")) {
										input.put("ProductFromSerialNo", stb.getSerialPopupFromSerialNoAtRow(j));
										input.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
										missingstock = missingstock + Long.parseLong(input.get("ProductToSerialNo"))- Long.parseLong(input.get("ProductFromSerialNo"))+1; 
										j++;
									}else if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[A-Za-z0-9]+")){
										missingstock = missingstock + 1;
										j++;
									}else{
										j++;
										System.out.println("error");
									}
									
								}else if (prodstate.contains("Stolen stock")) {
									if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[0-9]+")) {
										
										input.put("ProductFromSerialNo", stb.getSerialPopupFromSerialNoAtRow(j));
										input.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
										stolenstock = stolenstock + Long.parseLong(input.get("ProductToSerialNo"))- Long.parseLong(input.get("ProductFromSerialNo"))+1; 
										j++;
									}else if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[A-Za-z]+")){
										stolenstock = stolenstock + 1;
										j++;
									}else{
										j++;
										System.out.println("error");
									}
									
								} else if (prodstate.contains("Burnt")) {
									if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[0-9]+")) {
										input.put("ProductFromSerialNo", stb.getSerialPopupFromSerialNoAtRow(j));
										input.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
										burntstock = burntstock + Long.parseLong(input.get("ProductToSerialNo"))- Long.parseLong(input.get("ProductFromSerialNo"))+1; 
										j++;
									}else if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[A-Za-z0-9]+")){
										burntstock = burntstock + 1;
										j++;	
									}else{
										j++;
										System.out.println("error");
									}
									
								} else if (prodstate.contains("Recons Stock")) {
									if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[0-9]+")) {
										input.put("ProductFromSerialNo", stb.getSerialPopupFromSerialNoAtRow(j));
										input.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
										reconstock = reconstock + Long.parseLong(input.get("ProductToSerialNo"))- Long.parseLong(input.get("ProductFromSerialNo"))+1; 
										j++;
									}else if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[A-Za-z]+")){
										reconstock = reconstock + 1;
										j++;	
									}else{
										j++;
										System.out.println("error");
									}
									
								} else if (prodstate.contains("In-Transit Loss")) {
									if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[0-9]+")) {
										input.put("ProductFromSerialNo", stb.getSerialPopupFromSerialNoAtRow(j));
										input.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
										intralossstock = intralossstock + Long.parseLong(input.get("ProductToSerialNo"))- Long.parseLong(input.get("ProductFromSerialNo"))+1; 
										j++;
									}else if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[A-Za-z0-9]+")){
										intralossstock = intralossstock + 1;
										j++;	
									}else{
										j++;
										System.out.println("error");
									}
									
								} else if (prodstate.contains("Combi Stock")) {
									if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[0-9]+")) {
										input.put("ProductFromSerialNo", stb.getSerialPopupFromSerialNoAtRow(j));
										input.put("ProductToSerialNo", stb.getSerialPopupToSerialNoAtRow(j));
										combistock = combistock + Long.parseLong(input.get("ProductToSerialNo"))- Long.parseLong(input.get("ProductFromSerialNo"))+1; 
										j++;
									}else if (stb.getSerialPopupFromSerialNoAtRow(j).matches("[A-Za-z0-9]+")){
										combistock = combistock + 1;
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
							ast.assertEquals(input.get("SalableStock"),String.valueOf(bookstock), "Book stock not matching");
							ast.assertEquals(input.get("HoldStock"),String.valueOf(holdstock), "Hold stock not matching");
							ast.assertEquals(input.get("DamageStock"),String.valueOf(damagestock), "Damage stock not matching");
							ast.assertEquals(input.get("ReconsStock"),String.valueOf(reconstock), "Recon stock not matching");
							ast.assertEquals(input.get("InTransitLoss"),String.valueOf(intralossstock), "In-Transit Loss not matching");
							ast.assertEquals(input.get("MissingStock"),String.valueOf(missingstock), "Missing stock not matching");
							ast.assertEquals(input.get("StolenStock"),String.valueOf(stolenstock), "Stolen Stock not matching");
							ast.assertEquals(input.get("BurntStock"),String.valueOf(burntstock), "Burnt stock not matching");
							ast.assertEquals(input.get("CombiStock"),String.valueOf(combistock), "Combi stock not matching");
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
			
		}
		
		home.ClickOnTabClose("Stock Browser");
		

	}

}
