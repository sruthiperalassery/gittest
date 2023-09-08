package MastersTestCases;

import java.util.HashMap;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.UBQGenericLib.BaseClassLoader;

/**
 * @author Praneeth
 *
 */
@Listeners(com.UBQGenericLib.SampleListner.class)
public class Tc_Master_004_StoreMasterForNormalStoreCreationAndVerificationTestCase extends BaseClassLoader {
	HashMap<String, String> Storedata = new HashMap<String, String>();

	@Test
	public void StoreCreationAndVerificationtestCase() throws Exception {

		Storedata.put("StoreName", Autoalphavalue(8));
		Storedata.put("Address1", Autoalphavalue(8)+" "+AutoNumericvalue(2)+""+"stage");
		Storedata.put("Address2", Autoalphavalue(8));
		Storedata.put("City", Autoalphavalue(6));
		Storedata.put("State", Autoalphavalue(8));
		Storedata.put("GodownSpace", AutoNumericvalue(5));
		
		/*home.ClickonMenutype();
		Thread.sleep(1500);*/
		home.ClickOnMenu();
		Thread.sleep(500);
		home.ClickOnSubMenuItem("Store Master");
		logger.info("Clicked on sub menu item Store Master");
		Thread.sleep(1000);
		
		store.SelectNormalstoreRadioButton();
		store.clickOnSaveBtn();
		if (wcl.getAlertmsg().contains("Enter Store Name")) {
			Thread.sleep(200);
			wcl.acceptAlert();
			store.enterNormalStoreName(Storedata.get("StoreName"));
		}
		
		store.clickOnSaveBtn();
		if (wcl.getAlertmsg().contains("Please enter address1")) {
			Thread.sleep(200);
			wcl.acceptAlert();
			store.enterAddress1(Storedata.get("Address1"));
		}
		
	
		store.enterAddress2(Storedata.get("Address2"));
		store.enterCity(Storedata.get("City"));
		store.enterState(Storedata.get("State"));
		store.clickOnSaveBtn();
		if (wcl.getAlertmsg().contains("Please enter a +ve number for Godown space")) {
			Thread.sleep(200);
			wcl.acceptAlert();
			store.enterwarehouseSpace(Storedata.get("GodownSpace"));
		}
		
		store.selectNormalStoreIsActiveCheckbox();
		store.clickOnSaveBtn();
		if (wcl.getAlertmsg().contains("Data saved successfully")) {
			Thread.sleep(200);
			wcl.acceptAlert();
			
		}
		store.enterTextToSearch(Storedata.get("StoreName"));
		store.ClickOnSearchbtn();
		store.clickOnPopupselectstaffcode();
		store.clickOnPopupOkBtn();
		ast.assertEquals(true,store.isNormalstoreRadioButtonselected(),"isNormalStoreRadioButton  is not selected");
		ast.assertEquals(store.getNormalStoreName(),Storedata.get("StoreName"),"StoreName is not Matching");
		ast.assertEquals(store.getAddress1(),Storedata.get("Address1"),"Address1 is not Matching");
		ast.assertEquals(store.getAddress2(),Storedata.get("Address2"),"Address2 is not Matching");
		ast.assertEquals(store.getCity(),Storedata.get("City"),"City is not Matching");
		ast.assertEquals(store.getState(),Storedata.get("State"),"State is not Matching");
		ast.assertEquals(store.getwarehouseSpace(),Storedata.get("GodownSpace"),"GodownSpace is not Matching");
		ast.assertEquals(true,store.isNormalStoreIsActiveSelected(),"isNormalStoreIsActive Checkbox is not selected");
		store.clickOnClearBtn();
		home.ClickOnTabClose("Store Master");
		ast.assertAll();
		
	}
	

}
