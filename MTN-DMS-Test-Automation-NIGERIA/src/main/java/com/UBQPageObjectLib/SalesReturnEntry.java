/**
 * 
 */
package com.UBQPageObjectLib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.UBQGenericLib.WebDriverCommonLib;

/**
 * @author Praneeth
 *
 */
public class SalesReturnEntry extends WebDriverCommonLib {
	WebDriver driver;

	// ----------------------Constructor----------------------//
	public SalesReturnEntry(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

		// ---For SBU---//
		@FindBy(how = How.XPATH, using = "//select[@id='SBU']")
		private WebElement SBU;
		
		// ---For Salesman---//
		@FindBy(how = How.XPATH, using = "//select[@id='salesman1']")
		private WebElement Salesman;
		
		// ---For Route---//
		@FindBy(how = How.XPATH, using = "//select[@id='beat1']")
		private WebElement Route;
		
		// ---For Route---//
		@FindBy(how = How.XPATH, using = "//input[@id='shopSelect']")
		private WebElement CustomerName;
		
		// ---For damagedRadioBtn ---//
		@FindBy(how = How.XPATH, using = "//input[@id='conditionDamaged']")
		private WebElement DamageRadioBtn;
		
		// ---For damagedRadioBtn ---//
		@FindBy(how = How.XPATH, using = "//select[@id='reason']")
		private WebElement Reason;
		
		// ---For damagedRadioBtn ---//
		@FindBy(how = How.XPATH, using = "//select[@id='creditMode']")
		private WebElement creditMode;
		
		// ---For ConformBtn ---//
		@FindBy(how = How.ID, using = "confirm")
		private WebElement ConformBtn;
	
		
		// ---For damagedRadioBtn ---//
		@FindBy(how = How.XPATH, using = "//input[@name='cancel']")
		private WebElement ClearBtn;
		
		// ----------------------Basic functions----------------------//

		// ---For selectSBU---//
		public void selectSBU(String sbu) {
			selectvalue(sbu, SBU);
		}

		// ---For getSBU---//
		public String getSBU() {
			return getselectDrpdwnValue(SBU);
		}
		
		// ---For selectSalesman---//
		public void selectSalesman(String DSA) {
			selectvalue(DSA, Salesman);
		}
		
		// ---For getSBU---//
		public String getSalesman() {
			return getselectDrpdwnValue(Salesman);
		}
		
		// ---For selectSalesman---//
		public void selectRoute(String route) {
			selectvalue(route, Route);
		}
		
		// ---For getSBU---//
		public String getRoute() {
			return getselectDrpdwnValue(Route);
		}
		
		// ---For EnterCustomerName---//
		public void enterCustomerName(String name){
			entervalue(name, CustomerName);
		}
		
		// ---For getCustomerName ---//
		public String getCustomerName(){
			return getvalue(CustomerName);
		}
		
		// ---For DamageRadioBtn ---//
		public void ClickOnDamageBtn(){
			buttonClick(DamageRadioBtn);
		}
		
		// ---For select Reason---//
		public void selectReason(String reason) {
			selectvalue(reason,Reason );
		}

		// ---For get Reason ---//
		public String getselectedReason() {
			return getselectDrpdwnValue(Reason);
		}
		
		// ---For select creditMode---//
		public void selectCreditMode(String reason) {
			selectvalue(reason,creditMode );
		}

		// ---For get creditMode---//
		public String getselectedCreditMode() {
			return getselectDrpdwnValue(creditMode);
		}
		
		// For Click Confirmbtn
		public void clickOnConfirmbtn() {
			buttonClick(ConformBtn);
		}

		// For Click Clear
		public void clickclearBtn() {
			buttonClick(ClearBtn);
		}
		
		
		// ---For getNumOfProductRows ---//
		public int getNumOfProductRows() {
			List<WebElement> size = driver.findElements(By.xpath("//table[@id='SalesReturnDetailsTable']/tbody[2]/tr"));
			return size.size();
		}
		
		// ---- for getProductCodeAtRow ---- //
		public String getProductCodeAtRow(int rnum) {
			WebElement element = driver
					.findElement(By.xpath("//table[@id='SalesReturnDetailsTable']/tbody[2]/tr[" + rnum + "]/td[2]/input"));
			return getvalue(element);
		}
		
		// ---- for getProductCodeAtRow ---- //
		public String getProductNameAtRow(int rnum) {
			WebElement element = driver
							.findElement(By.xpath("//table[@id='SalesReturnDetailsTable']/tbody[2]/tr[" + rnum + "]/td[3]/input[1]"));
			return getvalue(element);
		}
		
		//----------------------Click on serial number link---------------//
		public void ClickonSerialNoLinkAtRow(int rnum){
			WebElement element = driver
							.findElement(By.xpath("//table[@id='SalesReturnDetailsTable']/tbody[2]/tr[" + rnum + "]/td[4]/a/img"));
			buttonClick(element);
		}
		
		// ---- for getProductMRPAtRow ---- //
		public String getProductMRPAtRow(int rnum) {
			WebElement element = driver
					.findElement(By.xpath("//table[@id='SalesReturnDetailsTable']/tbody[2]/tr[" + rnum + "]/td[6]/select[1]"));
			return getvalue(element);
		} 
		

		// ---For EnterQtyAtRow ---//
		public void enterQtyatRow(int rnum,Long value) {
			WebElement element = driver
					.findElement(By.xpath("//table[@id='SalesReturnDetailsTable']/tbody[2]/tr[" + rnum + "]/td[10]/input"));
			entervalue(String.valueOf(value), element);
		}
		

		
}
