package com.UBQPageObjectLib;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.UBQGenericLib.WebDriverCommonLib;

public class Bugzilla extends WebDriverCommonLib {

	WebDriver driver;

	// ----------------------Constructor----------------------//
	public Bugzilla(WebDriver driver) {
		this.driver = driver;

	}
	// ------UI Elements------//

	// ----For Search Txt----//
	@FindBy(how = How.XPATH, using = "//input[@id='quicksearch_top']")
	private WebElement SearchTxt;

	// ----For Search Btn ----//
	@FindBy(how = How.XPATH, using = "//input[@id='find_top']")
	private WebElement SearchBtn;

	// ----For Edit Link ----//
	@FindBy(how = How.XPATH, using = "//a[@id='summary_edit_action']")
	private WebElement EditLnk;

	// ----For priority ----//
	@FindBy(how = How.XPATH, using = "//select[@id='priority']")
	private WebElement priority;

	// ----For bug_severity ----//
	@FindBy(how = How.XPATH, using = "//select[@id='bug_severity']")
	private WebElement bugSeverity;

	// --------Functions-------//
	// For Select SearchTxt
	public void EnterSearchTxxt(String st) {
		entervalue(st, SearchTxt);
	}

	// ---- For Search Text-----//
	public String getEnteredSearchTxxt() {
		return getvalue(SearchTxt);
	}

	// ----For click Search Btn----//
	public void clickSearchBtn() {
		buttonClick(SearchBtn);
	}

	// ----For click EditLnk----//
	public void clickEditLnk() {
		buttonClick(EditLnk);
	}

	//---- For select priority----//
	public void selectPriority(String prio) {
		selectvalue(prio, priority);
	}

	//---- For get priority----//
	public String getPriority() {
		return getselectDrpdwnValue(priority);
	}

	//---- For select priority----//
	public void selectBugSeverity(String sev) {
		selectvalue(sev, bugSeverity);
	}

	//---- For get priority ----//
	public String getBugSeverity() {
		return getselectDrpdwnValue(bugSeverity);
	}

	

	
	
	
}
