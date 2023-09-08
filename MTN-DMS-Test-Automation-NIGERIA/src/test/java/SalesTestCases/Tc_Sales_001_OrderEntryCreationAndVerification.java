package SalesTestCases;
/**
 
* @author Praneeth
 *
 */
import java.util.HashMap;

import org.apache.poi.hssf.record.RightMarginRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.UBQGenericLib.BaseClassLoader;
import com.UBQGenericLib.ExcelLib;

@Listeners(com.UBQGenericLib.SampleListner.class)
public class Tc_Sales_001_OrderEntryCreationAndVerification extends BaseClassLoader {
	HashMap<String, String> OrderEntry = new HashMap<String, String>();

	@Test
	public void orderEntryCreationAndVerificationtestCase() throws Exception 
	{
		ExcelLib Order = new ExcelLib("./TestData/Inputdata.xlsx");
		home.ClickOnMenu();
		Thread.sleep(500);
		home.ClickOnSubMenuItem("Order Entry");
		logger.info("Clicked on sub menu item Order Entry");
		Thread.sleep(1000);
		
	/*	oentry.clickConfirmbtn();
		if (wcl.getAlertmsg().equalsIgnoreCase("Press calculate before confirming.")) {
			wcl.acceptAlert();
			oentry.clickCalculatebtn();
			}
		*/
		for (int n = 1; n <= 2; n++) {
		OrderEntry.put("SBU","MTN");
		OrderEntry.put("CustomerType","Customer");
		//OrderEntry.put("Salesman", "Benin");
		OrderEntry.put("Salesman", "kouadio");
		//OrderEntry.put("Route","MOUPEMOU");
		OrderEntry.put("Route","BOUNIFLA");
	//	OrderEntry.put("CustomerName","Retailer UAT");
		//OrderEntry.put("CustomerCode","RLST000000618");
		OrderEntry.put("CustomerCode","RLAb000000008");
		OrderEntry.put("PayMode","Cash");
		OrderEntry.put("ProductCode",Order.Excelread("OrderEntrycheck",n,0));
		OrderEntry.put("ProductName",Order.Excelread("OrderEntrycheck",n,1));
		OrderEntry.put("Qty",Order.Excelread("OrderEntrycheck",n,4));
		
		oentry.clickCalculatebtn();
		Thread.sleep(1000);
		if (wcl.getAlertmsg().equalsIgnoreCase("Please select DSA.")) {
			wcl.acceptAlert();
			oentry.selectSalesman(OrderEntry.get("Salesman"));
			}
		else{
			System.out.println("DSA not Matching");
		}
		
		oentry.clickCalculatebtn();
		Thread.sleep(1000);
		if (wcl.getAlertmsg().equalsIgnoreCase("Please select Route name")) {
			wcl.acceptAlert();
			oentry.selectRoute(OrderEntry.get("Route"));
			}
		else{
			System.out.println("Route not Matching");
		}
		oentry.clickCalculatebtn();
		Thread.sleep(1000);
		if (wcl.getAlertmsg().equalsIgnoreCase("Please select customer name.")) {
			wcl.acceptAlert();
			//oentry.selectCustomer(OrderEntry.get("CustomerName"));
			Thread.sleep(1500);
		
			}
		oentry.selectCustomerCode(OrderEntry.get("CustomerCode"));
		Thread.sleep(500);
		oentry.clickCalculatebtn();
		if (wcl.getAlertmsg().equalsIgnoreCase("Please select mode of payment")) {
			wcl.acceptAlert();
			oentry.SelectPayMode(OrderEntry.get("PayMode"));
			}
		else{
			System.out.println("PayMode not Matching");
		}
		Thread.sleep(500);
		
		oentry.enterProductCode(OrderEntry.get("ProductCode"));
		Thread.sleep(1500);
		oentry.enterOrderQty(OrderEntry.get("Qty"));
		}
		oentry.clickCalculatebtn();
		Thread.sleep(500);
		oentry.clickConfirmbtn();
		acceptAlert();
		acceptAlert();
		
		
		
		
		
	
		

		
	}
	}
	

		