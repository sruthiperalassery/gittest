package com.UBQPageObjectLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.UBQGenericLib.WebDriverCommonLib;

/**
 * @author Basanagouda
 *
 */
public class SyncWithServer extends WebDriverCommonLib {

	WebDriver driver;

	// ----------------------Constructor----------------------//
	public SyncWithServer(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

	// ---For Entity Code---//
	@FindBy(how = How.XPATH, using = "//input[@name='chkSynchItem']")
	private WebElement AllCheckBoxs;

	// ---For Entity Code---//
	@FindBy(how = How.XPATH, using = "//input[@id='synchButton']")
	private WebElement SyncronizeBtn;

	// ---For Status Msg---//
	@FindBy(how = How.XPATH, using = "//input[@id='status']")
	private WebElement StatusMsg;

	// ----------------------Basic functions----------------------//

	// ---For Making all check Box Active---//
	public void MakeAllCheckBoxsChecked() {
		if (AllCheckBoxs.isEnabled()) {
			checkboxselect(AllCheckBoxs);
		}
	}

	// ---For Making all check Box Active---//
	public void ClickonSyncronizeBtn() {
		buttonClick(SyncronizeBtn);
	}

	/*public String waitforstatusMsg() {
		return waitForTextToAppear("Sync process completed", StatusMsg);

	}*/

}
