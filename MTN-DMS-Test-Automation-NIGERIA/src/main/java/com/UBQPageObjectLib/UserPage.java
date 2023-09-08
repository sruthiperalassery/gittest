/**
 * 
 */
package com.UBQPageObjectLib;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import com.UBQGenericLib.WebDriverCommonLib;

/**
 * @author Basanagouda
 *
 */
public class UserPage extends WebDriverCommonLib {

	public WebDriver driver;

	// ----------------------Constructor----------------------//
	public UserPage(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

	// ---For User name---//
	@FindBy(how = How.XPATH, using = "//input[@id='userName']")
	private WebElement User_name;

	// ---For User Login Id ---//
	@FindBy(how = How.XPATH, using = "//input[@id='userLoginId']")
	private WebElement User_Login_Id;

	// ---For Roles checkbox Kpo ---//
	@FindBy(how = How.XPATH, using = "//table[@id='systemRolesTbl']/tbody/tr[1]/td/input[1]")
	private WebElement Roles_checkbox_Kpo;

	// ---For Roles checkbox salesman ---//
	@FindBy(how = How.XPATH, using = "//table[@id='systemRolesTbl']/tbody/tr[2]/td/input[1]")
	private WebElement Roles_checkbox_salesman;

	// ---For Roles checkbox System Administrator ---//
	@FindBy(how = How.XPATH, using = "//table[@id='systemRolesTbl']/tbody/tr[3]/td/input[1]")
	private WebElement Roles_checkbox_System_Administrator;

	// ---For Roles checkbox System TSM ---//
	@FindBy(how = How.XPATH, using = "//table[@id='systemRolesTbl']/tbody/tr[4]/td/input[1]")
	private WebElement Roles_checkbox_System_Tsm;

	// ---For Addn Selected Button ---//
	@FindBy(how = How.XPATH, using = "//input[@id='addRoleBtn']")
	private WebElement Add_Selected_Btn;

	// ---For Save Button ---//
	@FindBy(how = How.XPATH, using = "//input[@id='save']")
	private WebElement Save_Btn;

	// ---For Search box ---//
	@FindBy(how = How.XPATH, using = "//input[@id='searchUser']")
	private WebElement Search_box;

	// ---For Search box ---//
	@FindBy(how = How.XPATH, using = "//input[@id='search']")
	private WebElement Search_btn;

	// ---For Search box ---//
	@FindBys(@FindBy(how = How.XPATH, using = "//select[@id='results_list']/option"))
	private List<WebElement> result_list;

	// ---For Search box ---//
	@FindBy(how = How.XPATH, using = "//input[@id='okBtn']")
	private WebElement Ok_btn;

	// ---For Search box ---//
	@FindBy(how = How.XPATH, using = "//input[@id='emptyPassword']")
	private WebElement Set_empty_password;

	// ----------------------Functions----------------------//

	public void enterUserName(String Uname) {
		entervalue(Uname, User_name);
	}

	public void enterUserLoginId(String UloginId) {
		entervalue(UloginId, User_Login_Id);

	}

	public void selectSingleRollCheckbox(String EnterRole) {
		try {
			if (EnterRole.equalsIgnoreCase("Kpo")) {
				if (!Roles_checkbox_Kpo.isSelected()) {
					buttonClick(Roles_checkbox_Kpo);
				} else {
					// Do Nothing
				}
			} else if (EnterRole.equalsIgnoreCase("Salesman")) {
				if (!Roles_checkbox_salesman.isSelected()) {
					buttonClick(Roles_checkbox_salesman);
				} else {
					// Do Nothing
				}

			} else if (EnterRole.equalsIgnoreCase("Administrator")) {
				if (!Roles_checkbox_System_Administrator.isSelected()) {
					buttonClick(Roles_checkbox_System_Administrator);
				} else {
					// Do Nothing
				}

			} else if (EnterRole.equalsIgnoreCase("Tsm")) {
				if (!Roles_checkbox_System_Tsm.isSelected()) {
					buttonClick(Roles_checkbox_System_Tsm);

				} else {
					// Do Nothing
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	public void selectAllRoles() {
		try {
			buttonClick(Roles_checkbox_Kpo);
			buttonClick(Roles_checkbox_salesman);
			buttonClick(Roles_checkbox_salesman);
			buttonClick(Roles_checkbox_System_Administrator);
			buttonClick(Roles_checkbox_System_Tsm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	public void ClickAddallselectedBtn() {
		buttonClick(Add_Selected_Btn);

	}

	public void Savebtn() {
		buttonClick(Save_Btn);

	}

	public void EnterTextToSearch(String text) {
		entervalue(text, Search_box);

	}

	public void ClickSearchbtn() {
		buttonClick(Search_btn);

	}

	public void selectsalesmanName(String salesman) {
		try {

			for (int i = 0; i < result_list.size(); i++) {
				String codeTxt = result_list.get(i).getText();
				if (codeTxt.equalsIgnoreCase(codeTxt)) {
					result_list.get(i).click();
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	public void ClickOkBtn() {
		buttonClick(Ok_btn);

	}

	public void selectSetEmptyPassword() {
		try {
			if (!Set_empty_password.isSelected()) {
				checkboxselect(Set_empty_password);
			} else {
				// Do nothing
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
