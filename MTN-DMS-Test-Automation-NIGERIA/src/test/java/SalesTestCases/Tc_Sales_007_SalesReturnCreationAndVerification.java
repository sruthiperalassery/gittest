package SalesTestCases;
/**
 * @author Praneeth
 *
 */
import java.util.HashMap;

import org.testng.annotations.Test;

import com.UBQGenericLib.BaseClassLoader;
import com.UBQGenericLib.ExcelLib;

public class Tc_Sales_007_SalesReturnCreationAndVerification extends BaseClassLoader {
	HashMap<String, String> SREntry=new HashMap<String, String>();
	
	@Test
	public void SalesReturnCreationTestCase() throws Exception 
	{
		ExcelLib BillData = new ExcelLib("./TestData/Inputdata.xlsx");
		SREntry.put("SBU","OA");
		SREntry.put("DSA","kouadio");
		SREntry.put("Route","BOUNIFLA");
		SREntry.put("CustomerName","Ardine");
		Thread.sleep(1000);
		home.ClickOnMenu();
		Thread.sleep(500);
		home.ClickOnSubMenuItem("Sales Return Entry");
		Thread.sleep(1000);
		sre.clickOnConfirmbtn();
		if (wcl.getAlertmsg().equalsIgnoreCase("Select SBU")) {
			wcl.acceptAlert();
		sre.selectSBU(SREntry.get("SBU"));	
		} else {
			System.out.println("SBU name not matching");
		}
		sre.clickOnConfirmbtn();
		if (wcl.getAlertmsg().equalsIgnoreCase("Please select customer name.")) {
			wcl.acceptAlert();
		sre.selectSalesman("kouadio");	
		} else {
			System.out.println("SBU name not matching");
		}
		
	}
	}

