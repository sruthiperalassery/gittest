package SalesTestCases;

import java.util.HashMap;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.UBQGenericLib.BaseClassLoader;

@Listeners(com.UBQGenericLib.SampleListner.class)
public class Tc_Sales_002_OrderBrowserVerification extends BaseClassLoader {
	HashMap<String, String> OrderBrowser = new HashMap<String, String>();
	
	@Test
	public void orderBrowserVerificationtestCase() throws Exception 
	{
		home.ClickOnMenu();
		Thread.sleep(500);
		home.ClickOnSubMenuItem("Order Browser");
		logger.info("Clicked on sub menu item Order Browser");
		Thread.sleep(1000);
		
	}
}
