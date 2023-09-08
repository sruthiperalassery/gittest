/**
 * 
 */
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
public class UserRolesPage extends WebDriverCommonLib {

	WebDriver driver;

	// ----------------------Constructor----------------------//
	public UserRolesPage(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

	// ---For State---//
	@FindBy(how = How.XPATH, using = "//select[@id='roleSelection']")
	private WebElement RoleSelection;

	// ---For Role name---//
	@FindBy(how = How.XPATH, using = "//input[@id='roleName']")
	private WebElement Role_name;

	// ---For Check box Activation and Recharge Record---//
	@FindBy(how = How.XPATH, using = "//table[@id='productFeatureTbl']/tbody/tr[1]/td/input[1]")
	private WebElement Activation_and_Recharge_Record;

	// ---For Role name---//
	@FindBy(how = How.XPATH, using = "//input[@id='addFeatureBtn']")
	private WebElement Add_featureBtn;

	// ---For Save Btn---//
	@FindBy(how = How.XPATH, using = "//input[@id='save']")
	private WebElement save;

	// ----------------------Functions----------------------//

	public void SelectRole(String role) {
		selectvalue(role, RoleSelection);
	}

	public String RoleName() {

		return getvalue(Role_name);

	}

	public void selectFeatures() {
		{
			boolean enabled = Activation_and_Recharge_Record.isEnabled();
			if (enabled) {
				Activation_and_Recharge_Record.click();

			} else {
				// Do nothing
				System.out.println("Feature not present");
			}
		}
	}

	public void ClickonAddFeatures() {
		buttonClick(Add_featureBtn);

	}

	public void ClickonSaveBtn() {
		buttonClick(save);

	}

}
