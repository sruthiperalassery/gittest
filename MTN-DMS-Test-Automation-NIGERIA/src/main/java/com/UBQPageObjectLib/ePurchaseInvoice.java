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
 * @author Basanagouda
 *
 */
public class ePurchaseInvoice extends WebDriverCommonLib {

	public WebDriver driver;

	// ----------------------Constructor----------------------//
	public ePurchaseInvoice(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

	// ---For Select FromCentralServerOption---//
	@FindBy(how = How.XPATH, using = "//form[@id='epurchaseForm']/table/tbody/tr[1]/td/table/tbody/tr[1]/td/input[1]")
	private WebElement FromCentralServerOption;
	
	// ---For Select FromCentralServerOption---//
		@FindBy(how = How.XPATH, using = "//form[@id='epurchaseForm']/table/tbody/tr[1]/td/table/tbody/tr[1]/td/input[2]")
		private WebElement FromFileOption;
		
		// ---For  LoadBtn---//
				@FindBy(how = How.XPATH, using = "//input[@id='loadButton']")
				private WebElement LoadBtn;
	

	// ----------------------Functions----------------------//

	

	public void SelctFromCentralServerOption() {
		buttonClick(FromCentralServerOption);
	}
	
	public void SelctFromFileOption() {
		buttonClick(FromFileOption);
	}
	
	public void ClickOnLoadBtn() {
		buttonClick(LoadBtn);
	}
	
	// For getNumOfProductRows
			public int getNumOfProductRows() {
				List<WebElement> size = driver.findElements(By.xpath("//table[@id='updatedProductsTable']/tr"));
				return size.size();
			}
			
			// For getInvoicedate // not Completed
						public String getInvoicedate(int row, int col) {
							WebElement element = driver.findElement(By.xpath("//table[@id='updatedProductsTable']/tr["+row +"]/td[" + col + "]"));
							return element.getText().trim();
						}
						
						// For getInvoicedate // not Completed
						public String getInvoiceNetAmt(int row, int col) {
							WebElement element = driver.findElement(By.xpath("//table[@id='updatedProductsTable']/tr["+row +"]/td[" + col + "]"));
							return element.getText().trim();
						}
						
						// For getInvoicedate // not Completed
						public String getInvoiceStatus(int row, int col) {
							WebElement element = driver.findElement(By.xpath("//table[@id='updatedProductsTable']/tr["+row +"]/td[" + col + "]"));
							return element.getText().trim();
						}
			

}
