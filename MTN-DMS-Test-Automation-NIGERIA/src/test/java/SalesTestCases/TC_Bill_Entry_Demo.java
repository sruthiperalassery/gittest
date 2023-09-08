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
public class TC_Bill_Entry_Demo extends BaseClassLoader {
	HashMap<String, String> BillEntry1 = new HashMap<String, String>();

	@Test
	public void BillEntryCreationAndVerificationtestCase() throws Exception {
		ExcelLib BillData = new ExcelLib("./TestData/Inputdata.xlsx");
		Thread.sleep(1500);
		home.SelectAttribute("Retailers");
		home.ClickOnMainSearchBtn();

		int count = home.getNumOfRetailerCount();
		System.out.println(count);
		
		if(count==0)
		{
			ast.assertFalse(true, "No retailers found in Popup");
			
		}
		else
		{
		for (int i=1; i<=count;) {
			
			String status = home.getPopupDealerStatus(i);
			if (i == count) {
				if (status.equalsIgnoreCase("Activated")) {
					BillEntry1.put("RetailerCode", home.getPopupDealerCode(i));
					BillEntry1.put("DealerName", home.getPopupDealerName(i));
					BillEntry1.put("Salesman", home.getPopupDealerSalesPerson(i));
					home.ClickOnveiwinNewTabForDealer(i);
					break;
				}

				else {
					
			boolean val=home.isretailerPopupNextBtnEnabled();
					
					if(val){
					home.ClickNextBtn();
					System.out.println(i);
					i=1;
					count = home.getNumOfRetailerCount();
					System.out.println(count);
					}
					
					else{
						ast.assertFalse(true, "No retailers found in Popup");
						break;
					}

				}
			}

			/*} else if (count < 1) 
				
				ast.assertFalse(home.getNumOfRetailerCount()==0, "No retailers found");
				break;

			}*/ 
			else 
			{
				if (status.equalsIgnoreCase("Activated")) {
					BillEntry1.put("RetailerCode", home.getPopupDealerCode(i));
					BillEntry1.put("DealerName", home.getPopupDealerName(i));
					BillEntry1.put("Salesman", home.getPopupDealerSalesPerson(i));
					home.ClickOnveiwinNewTabForDealer(i);
					break;
					
				} else {
					
					System.out.println("When i is  less than count and Status value is not activated");
					i++;

				}

			}
		}
		

	}
	}
}

