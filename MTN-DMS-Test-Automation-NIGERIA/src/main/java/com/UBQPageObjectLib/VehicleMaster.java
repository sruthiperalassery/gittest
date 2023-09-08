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
public class VehicleMaster extends WebDriverCommonLib {
	WebDriver driver;

	// ----------------------Constructor----------------------//
	public VehicleMaster(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

	// ---For vehicle no---//
	@FindBy(how = How.XPATH, using = "//input[@id='vehicle_no']")
	private WebElement Vehicleno;

	// ---For Vehicle desc---//
	@FindBy(how = How.XPATH, using = "//input[@id='vehicle_desc']")
	private WebElement Vehicledesc;

	// ---For vehicleTypeId---//
	@FindBy(how = How.XPATH, using = "//select[@id='vehicleTypeId']")
	private WebElement vehicleTypeId;

	// ---For VehicleCapacityCBB---//
	@FindBy(how = How.XPATH, using = "//input[@id='vehicleCapacityCBB']")
	private WebElement VehicleCapacityCBB;

	// ---For VehicleCapacityValue---//
	@FindBy(how = How.XPATH, using = "//input[@id='vehicleCapacityValue']")
	private WebElement VehicleCapacityValue;

	// ---For vehicleCapacityTonnes---//
	@FindBy(how = How.XPATH, using = "//input[@id='vehicleCapacityTonnes']")
	private WebElement VehicleCapacityTonnes;

	// ---For SelectIsActive---//
	@FindBy(how = How.XPATH, using = "//input[@id='vehicle_is_active']")
	private WebElement SelectIsActive;

	// ---For ClcikSaveBtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='saveBtn']")
	private WebElement ClcikSaveBtn;

	// ---For ClcikCancelBtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='cancel']")
	private WebElement ClcikCancelBtn;

	// ---For SearchText---//
	@FindBy(how = How.XPATH, using = "//input[@id='searchTxt']")
	private WebElement SearchText;

	// ---For SearchBtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='searchbtn']")
	private WebElement SearchBtn;

	// ----------------------Functions----------------------//

	public void enterVehicleno(String vehicleno) {
		entervalue(vehicleno, Vehicleno);

	}

	public String getVehicleno() {
		return getvalue(Vehicleno);

	}

	public void enterVehicledesc(String vehicledesc) {
		entervalue(vehicledesc, Vehicledesc);

	}

	public String getVehicledesc() {
		return getvalue(Vehicledesc);

	}

	// ---For Select SBU function---//
	public void SelectVehicleTypeId(String vehicletype) {
		selectvalue(vehicletype, vehicleTypeId);

	}

	public String getVehicleTypeId() {
		return getselectDrpdwnValue(vehicleTypeId);

	}

	public void enterVehicleCapacityCBB(String vehicleCapacityCBB) {
		entervalue(vehicleCapacityCBB, VehicleCapacityCBB);

	}

	public String getVehicleCapacityCBB() {
		return getvalue(VehicleCapacityCBB);

	}

	public void enterVehicleCapacityValue(String vehicleCapacityValue) {
		entervalue(vehicleCapacityValue, VehicleCapacityValue);

	}

	public String getVehicleCapacityValue() {
		return getvalue(VehicleCapacityValue);

	}

	public void enterVehicleCapacityTonnes(String vehicleCapacityTonnes) {
		entervalue(vehicleCapacityTonnes, VehicleCapacityTonnes);

	}

	public String getVehicleCapacityTonnes() {
		return getvalue(VehicleCapacityTonnes);

	}

	// ---For SelectIsActive---//
	public void SelectIsActive() {
		checkboxselect(SelectIsActive);
	}

	// ---For ClcikSaveBtn---//
	public void ClickOnOk() {
		buttonClick(ClcikSaveBtn);
	}

	// ---For ClcikCancelBtn---//
	public void ClickOnCancel() {
		buttonClick(ClcikCancelBtn);

	}

	// ---For SearchText---//
	public void enterSearchText(String searchtext) {
		entervalue(searchtext, SearchText);
	}

	// ---For ClickOnSearchBtn---//
	public void ClickOnSearchBtn() {
		buttonClick(SearchBtn);
	}

}
