package SalesTestCases;

import java.util.HashMap;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.UBQGenericLib.BaseClassLoader;

@Listeners(com.UBQGenericLib.SampleListner.class)
public class Tc_Sales_004_BillBrowserVerification extends BaseClassLoader {
	HashMap<String, String> BillBrowser = new HashMap<String, String>();
	
	@Test
	public void BillBrowserVerificationtestCase() throws Exception 
	{
		home.ClickOnMenu();
		Thread.sleep(500);
		home.ClickOnSubMenuItem("Bill Browser");
		logger.info("Clicked on sub menu item Order Browser");
		Thread.sleep(1000);
		
		for (int n = 1; n <= 2; n++) {
		
			
		}
		}
		
	}

