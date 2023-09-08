package com.UBQPageObjectLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.UBQGenericLib.Constants;
import com.UBQGenericLib.WebDriverCommonLib;

/**
 * @author Basanagouda
 *
 */
public class LoginPage extends WebDriverCommonLib {

	WebDriver driver;
	WebDriverCommonLib wcl = new WebDriverCommonLib();

	// ----------------------Constructor----------------------//
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

	// ---For Entity Code---//
	@FindBy(how = How.ID, using = "entityCode")
	@CacheLookup
	private WebElement entityCode;

	// ---For Entity Name---//
	@FindBy(how = How.ID, using = "entityName")
	@CacheLookup
	private WebElement entityname;

	// ---For User Name---//
	@FindBy(how = How.ID, using = "userName")
	@CacheLookup
	private WebElement username;

	// ---For Password---//
	@FindBy(how = How.ID, using = "password")
	@CacheLookup
	private WebElement password;

	// ---For Login Button---//
	@FindBy(how = How.ID, using = "logInBtn")
	private WebElement login;

	// ----------------------Basic functions----------------------//

	// ---For EnterEntityCode---//
	public void enterEntityCode(String entitycode) {
		entervalue(entitycode, entityCode);
	}

	// ---For getEntityName---//
	public String getEntityName() {
		return getText(entityname);
	}

	// ---For EnterUserName---//
	public void enterUserName(String uname) {
		entervalue(uname, username);

	}

	// ---For EnterPassword---//
	public void enterPassword(String pass) {
		entervalue(pass, password);
	}

	// ---For ClickLoginBtn---//
	public void clickLoginBtn() {
		buttonClick(login);

	}

	// Login Function
	public void login(String entitycode, String uname, String EntityName,String pass) {
		try {
			wcl.waitforpageload();
			Thread.sleep(500);
			buttonClick(login);
			if (wcl.getAlertmsg().contains("Please enter entity code.")) {
				Thread.sleep(1000);
				wcl.acceptAlert();
			} else {
				ast.assertEquals(wcl.getAlertmsg(), "Please enter entity code.");
			}
			logger.info("Login Started");
			entervalue(entitycode, entityCode);
			//buttonClick(login);
			/*if (wcl.getAlertmsg().contains("User name must have a value")) {
				Thread.sleep(1000);
				wcl.acceptAlert();
			} else {
				Assert.assertEquals(wcl.getAlertmsg(), "User name must have a value");
			}*/
			entervalue(uname, username);
			entervalue(pass, password);
			buttonClick(login);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ast.assertTrue(false, "Unable to Login");
			logger.error("Login Failed " + e.getMessage());
		}
	}

	// Login Function
	public void login() {
		try {
			wcl.waitforpageload();
			Thread.sleep(2500);
			buttonClick(login);
			if (wcl.getAlertmsg().contains("Please enter entity code.")) {
				Thread.sleep(1000);
				wcl.acceptAlert();
			} else {
				ast.assertEquals(wcl.getAlertmsg(), "Please enter entity code.");
			}
			logger.info("Login Started");
			entervalue(Constants.EntityId, entityCode);
			entervalue(Constants.username, username);
			Thread.sleep(1000);
			if (getEntityName().contains(Constants.EntityName)) {
				entervalue(Constants.Password, password);
				buttonClick(login);
				logger.info("Logged in Successfully");
			} else {
				ast.assertEquals(getEntityName(), Constants.EntityName);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ast.assertTrue(false, "Unable to Login");
			logger.error("Login Failed " + e.getMessage());
		}

	}

}
