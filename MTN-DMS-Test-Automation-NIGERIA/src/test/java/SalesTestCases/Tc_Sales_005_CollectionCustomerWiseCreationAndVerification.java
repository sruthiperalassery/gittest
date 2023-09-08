package SalesTestCases;
/**
 * @author Praneeth
 *
 */
import java.util.HashMap;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.UBQGenericLib.BaseClassLoader;

@Listeners(com.UBQGenericLib.SampleListner.class)
public class Tc_Sales_005_CollectionCustomerWiseCreationAndVerification extends BaseClassLoader {
	HashMap<String, String> collection = new HashMap<String, String>();

	@Test
	public void CollectionCustomerWiseCreationAndVerificationtestCase() throws Exception 
	{
		collection.put("SBU", "OA");
		collection.put("DSA", "kouadio");
		collection.put("Route", "BOUNIFLA");
		collection.put("CustomerName", "Ardine");
		collection.put("CollectorName", Autoalphavalue(8));
		collection.put("CollectionDate", Today());
		//float balance=	collc.getCustomerACBalance();
		//float bal=balance-balance+100;
		//String s=String.valueOf(bal);
		//collection.put("RecepitAmount",s);
		collection.put("RecepitAmount","100");
		
		Thread.sleep(1500);
		home.ClickOnMenu();
		home.ClickOnSubMenuItem("Collection - Customer wise");
		Thread.sleep(500);
		collc.clickViewBtn();
		if (wcl.getAlertmsg().equalsIgnoreCase("Select SBU")) {
			wcl.acceptAlert();
			collc.selectSBU(collection.get("SBU"));
		} else {
			System.out.println("SBU name not matching");
		}
		collc.clickViewBtn();
		if (wcl.getAlertmsg().equalsIgnoreCase("Select DSA")) {
			wcl.acceptAlert();
			collc.selectSalesman(collection.get("DSA"));

		} else {
			System.out.println("DSA name not matching");
		}
		collc.clickViewBtn();
		if (wcl.getAlertmsg().equalsIgnoreCase("Select Route")) {
			wcl.acceptAlert();
			collc.selectRoute("Route");
		} else {
			System.out.println("Route name not matching");
		}
		collc.clickViewBtn();
		if (wcl.getAlertmsg().equalsIgnoreCase("Select customer")) {
			wcl.acceptAlert();
			collc.selectCustomer("CustomerName");
		} else {
			System.out.println("Customer Name not matching");
		}
		collc.clickViewBtn();
		collc.enterCollectionDate("CollectionDate");
		collc.clickSavebtn();
		if (wcl.getAlertmsg().equalsIgnoreCase("Enter receipt amount")) {
			wcl.acceptAlert();
			collc.selectCustomer("RecepitAmount");
		} else {
			System.out.println("RecepitAmount not matching");
		}
		collc.selectPayModeOption("Cash");
		collc.clickSavebtn();
		if (wcl.getAlertmsg().equalsIgnoreCase("Enter collector name")) {
			wcl.acceptAlert();
			collc.enterCollectorName("CollectorName");
		} else {
			System.out.println("CollectorName is not matching");
		}
	}
	}

		
