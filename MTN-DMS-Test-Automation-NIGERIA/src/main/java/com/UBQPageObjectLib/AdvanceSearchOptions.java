package com.UBQPageObjectLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.UBQGenericLib.WebDriverCommonLib;

public class AdvanceSearchOptions extends WebDriverCommonLib{
	WebDriver driver;

	// ----------------------Constructor----------------------//
	public AdvanceSearchOptions(WebDriver driver) {
		this.driver = driver;
	}
	
	// ----------------------UI Elements----------------------//
	
	
	//----------- For select attribute menu------------------//
	@FindBy(how = How.XPATH, using = "//select[@id='searchAttribute']")
	private WebElement Selectattribute;
	
	//---------------For code/name search box----------//
	@FindBy(how = How.XPATH, using = "//input[@id='searchTextBox']")
	private WebElement Codeornamesearch;
	
	//-----------------For search button------------------//
	@FindBy(how = How.XPATH, using = "/html/body/div[15]/div/table/tbody/tr/td[2]/div/button")
	private WebElement Searchbutton;

	//--------------------For Advanced search button----------------------//
	@FindBy(how = How.XPATH, using = "//*[@id='genericSearchDiv']/table/tbody/tr/td[3]/input")
	private WebElement Advancesearchbtn;
	
	
	//--------------basic functions--------------------//
	
	//---------------For selecting an attribute----------//
	public void SelectAttribute(String attributename){
		selectByTxt(Selectattribute,attributename);
	}
	
	//-----------For entering value to code/name field--------//
	public void entercodeorname(String code){
		entervalue(code,Codeornamesearch);
	}
	
	//---------For clicking search button---------//
	public void Clickonsearch(){
		buttonClick(Searchbutton);
	}
	
	//---------For click on advance search button----------//
	public void Clickadvancesearch(){
		buttonClick(Advancesearchbtn);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
