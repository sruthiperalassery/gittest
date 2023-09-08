package com.UBQPageObjectLib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.UBQGenericLib.WebDriverCommonLib;

public class ArticleMaster extends WebDriverCommonLib{
	WebDriver driver;
	
	    // ----------------------Constructor----------------------//
		public ArticleMaster(WebDriver driver) {
			this.driver = driver;
		}
        // ----------------------UI Elements----------------------//
		
		//-----------For Article code----------------//
		@FindBy(how = How.XPATH, using = "//input[@id='cardCode']")
		private WebElement Articlecode;
		
		//-----------For Article code----------------//
	    @FindBy(how = How.XPATH, using = "//input[@id='cardName']")
		private WebElement Articlename;
	    
	    //-----------For search box----------------//
	    @FindBy(how = How.XPATH, using = "//input[@id='SCardSearch']")
		private WebElement Searchbox;
	    
	    //----------For search Btn-------------//
	    @FindBy(how = How.XPATH, using = "//input[@id='SCardSearchBtn']")
		private WebElement SearchBtn;
	    
	    //----------For Save button-------------//
	    @FindBy(how = How.XPATH, using = "//input[@id='save']")
		private WebElement SaveBtn;
	    
	    //----------For Clear button-------------//
	    @FindBy(how = How.XPATH, using = "//input[@id='cancel']")
		private WebElement ClearBtn;
	    
	    //----------For  Popup Result List-------------//
	    @FindBy(how = How.XPATH, using = "//select[@id='results_list']/option")
		private WebElement ResultList;
	    
	    //----------Basic functions-----------------//
	    
	    //-------------For ArticleCode----------//
	    public void enterArticleCode(String articlecode){
	    	entervalue(articlecode,Articlecode);
	    }
	    
	    //------------For  Article Code---------------//
	    public String getArticleCode(){
	    	return getvalue(Articlecode);
	    }
	
	    //------------For  Article Name------//
	    public void enterArticleName(String articlename){
	    	entervalue(articlename,Articlename);
	    }
	    
	    //-------------For Article Name-------//
	    public String getArticleName(){
	    	return getvalue(Articlename);
	    }
	    
        //-----For save button-----------//
	    public void clickOnSaveBtn(){
	    	buttonClick(SaveBtn);
	    }
	    //-------For clear button---------//
	    public void clickOnClearBtn(){
	    	buttonClick(ClearBtn);
	    }
	    
	    
	    //----------For Search---------------//
	    public void enterTextToSearch(String searchtext){
	    	entervalue(searchtext,Searchbox);
	    }
	    
	    //-----------------For search button-----------------//
	    public void clickOnSearchBtn(){
	    	buttonClick(SearchBtn);
	    }
	   
	    //-----------------For search button-----------------//
	    public int getNumberOfAricles(){
	    	List<WebElement> articles = driver.findElements(By.xpath("//select[@id='results_list']/option"));
	    	return articles.size() ; 
	    }
	    
	    //-----------------For getArticleNameAtRow-----------------//
	    public String getArticleNameAtRow(int row){
	    	return getText(driver.findElement(By.xpath("//select[@id='results_list']/option["+row+"]")));
	    }
	    
	    //-----------------For clickOnArticleNameAtRow-----------------//
	    public void clickOnArticleNameAtRow(int row){
	    	buttonClick(driver.findElement(By.xpath("//select[@id='results_list']/option["+row+"]")));
	    }
	    
	    //-----------------For clickOnArticlePopupOkBtn-----------------//
	    public void clickOnArticlePopupOkBtn(){
	    	buttonClick(driver.findElement(By.xpath("//input[@id='okBtn']")));
		    
	    }
	  //-----------------For clickOnArticlePopupCancelBtn-----------------//
	    public void clickOnArticlePopupCancelBtn(){
	    	buttonClick(driver.findElement(By.xpath("//input[@id='cancelBtn']")));
		    
	    }
	    
}
