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
public class BeatMaster extends WebDriverCommonLib {
	WebDriver driver;

	// ----------------------Constructor----------------------//
	public BeatMaster(WebDriver driver) {
		this.driver = driver;
	}
	// ----------------------UI Elements----------------------//
	
	//------For beat code-----------//
	@FindBy(how = How.XPATH, using = "//input[@id='bt_code']")
	private WebElement Beatcode;

	// ---For Route Description---//
	@FindBy(how = How.XPATH, using = "//input[@id='bt_desc']")
	private WebElement routedescription;

	// ---For Select SBU--//
	@FindBy(how = How.XPATH, using = "//select[@id='bt_sbu_rid']")
	private WebElement selSBU;

	// ---For Select salesman1--//
	@FindBy(how = How.XPATH, using = "//select[@id = 'bt_salesman']")
	private WebElement Salesman;

	// ---For Select salesman2--//
	@FindBy(how = How.XPATH, using = "//table[@id = 'dynamicSalesman']/tbody/tr[2]/td[1]/select")
	private WebElement salesman2;

	// ---For Add Btn--//
	@FindBy(how = How.XPATH, using = "//table[@id = 'dynamicSalesman']/tbody/tr[1]/td[1]/input[1]")
	private WebElement addbtn;

	// ---For Remove btn--//
	@FindBy(how = How.XPATH, using = "//table[@id = 'dynamicSalesman']/tbody/tr[2]/td[1]/input[2]")
	private WebElement removebtn;

	// ---For RouteType--//
	@FindBy(how = How.XPATH, using = "//select[@id='beatType']")
	private WebElement BeatType;

	// ---For Van Name--//
	@FindBy(how = How.XPATH, using = "//select[@id='vanName']")
	private WebElement vanName;

	// ---For Van Name--//
	@FindBy(how = How.XPATH, using = "//input[@id='distanceCovered']")
	private WebElement distanceCovered;

	// ---For BeatStatus--//
	@FindBy(how = How.XPATH, using = "//input[@id='beatStatus']")
	private WebElement BeatStatus;

	// ---For savebtn-//
	@FindBy(how = How.XPATH, using = "//input[@id='saveBtn']")
	private WebElement Savebtn;

	// ---For Is Active Check Box--//
	@FindBy(how = How.XPATH, using = "//input[@id='clearBtn2']")
	private WebElement Clearbtn;

	// ---For Search box ---//
	@FindBy(how = How.XPATH, using = "//input[@id='searchTxt']")
	private WebElement SearchBox;

	// ---For Search btn ---//
	@FindBy(how = How.XPATH, using = "//input[@id='searchbtn']")
	private WebElement SearchBtn;

	// ---For popupselectoption---//
	@FindBy(how = How.XPATH, using = "//select[@id='results_list']/option[1]")
	private WebElement popupselectoption;

	// ---For PopupOkbtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='okBtn']")
	private WebElement PopupOkbtn;

	// ---For PopupCancelbtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='cancelBtn']")
	private WebElement PopupCancelbtn;

	// ----------------------Basic functions----------------------//
	
	//--------For enterbeatcode-----------//
	public void Enterbeatcode(String beatcode){
		entervalue(beatcode,Beatcode);
	}
    
	//--------For getbeatcode-----------//
	public String getBeatcode() {
		return getvalue(Beatcode);
		}
		
	// ---For EnterBeatDiscription---//
	public void EnterBeatDiscription(String description) {
		entervalue(description, routedescription);

	}

	// ---For getBeatDiscription---//
	public String getBeatDiscription() {
		return getvalue(routedescription);

	}

	// ---For Select SBU---//
	public void selectSBU(String sbu) {
		selectvalue(sbu, selSBU);
		//selectDrpdwnRamdomly(selSBU);
	}

	// ---For getBeatSBU---//
	public String getBeatSBU() {
		return getselectDrpdwnValue(selSBU);

	}

	// ---For Select Salesman1---//
	public void selectSalesman(String salesman) {
		selectvalue(salesman, Salesman);

	}

	// ---For getSalesman---//
	public String getSalesman() {
		return getselectDrpdwnValue(Salesman);

	}

	// ---For Select Salesman2---//
	public void selectSalesman2(String salesman) {
		selectvalue(salesman, salesman2);

	}

	// ---For addbtn---//
	public void clickonaddbtn() {
		buttonClick(addbtn);

	}

	// ---For removebtn---//
	public void clickonremovebtn() {
		buttonClick(removebtn);

	}

	// ---For Select Route Type---//
	public void selectBeatType(String beattype) {
		selectvalue(beattype, BeatType);
		//selectDrpdwnRamdomly(BeatType);
	}

	// ---For getBeatType---//
	public String getBeatType() {
		return getselectDrpdwnValue(BeatType);

	}

	// ---For Select Select Van---//
	public void selectVan(String vanname) {
		selectvalue(vanname, vanName);

	}

	// ---For Distance Covered---//
	public void enterDistanceCovered(String distance) {
		if (distanceCovered.isEnabled()) {
			entervalue(distance, distanceCovered);
		} else {
			// Do nothing}
		}
	}

	// ---For Is Active Check box---//
	public void IsActivecheckbox() {
		checkboxselect(BeatStatus);

	}

	// ---For click on savebtn---//
	public void clickonSavebtn() {
		buttonClick(Savebtn);

	}

	// ---For click on savebtn---//
	public void clickonClearbtn() {
		buttonClick(Clearbtn);

	}

	public void EnterTextToSearch(String text) {
		entervalue(text, SearchBox);

	}

	public void ClickOnSearchbtn() {
		buttonClick(SearchBtn);

	}

	//---popupokbtn---//
	public void ClickOnOkBtn() {
		buttonClick(PopupOkbtn);

	}
	//---PopupCancelbtn---//
	public void ClickOnCancelBtn() {
		buttonClick(PopupCancelbtn);

	}
	//---popupselectoption---//
	public void PopupSelectStore() {
		buttonClick(popupselectoption);
	}

}
