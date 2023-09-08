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
public class StoreMaster extends WebDriverCommonLib {

	WebDriver driver;

	// ----------------------Constructor----------------------//
	public StoreMaster(WebDriver driver) throws Exception {
		this.driver = driver;
	}
	// ----------------------UI Elements----------------------//

	// ---For Store RefNo---//
	@FindBy(how = How.XPATH, using = "//input[@id='st_ref_no']")
	private WebElement StoreRefNo;

	// ---For Store name---//
	@FindBy(how = How.XPATH, using = "//input[@id='store_name']")
	private WebElement StoreName;
	
	// ---For Normal Store Radio button---//
	@FindBy(how = How.XPATH, using = "//input[@id='nm_store']")
	private WebElement NormalStoreRadiobtn;

	// ---For Address1---//
	@FindBy(how = How.XPATH, using = "//input[@id='address1']")
	private WebElement Address1;

	// ---For Address2---//
	@FindBy(how = How.XPATH, using = "//input[@id='address2']")
	private WebElement Address2;

	// ---For State---//
	@FindBy(how = How.XPATH, using = "//input[@id='state']")
	private WebElement State;

	// ---For City---//
	@FindBy(how = How.XPATH, using = "//input[@id='city']")
	private WebElement City;

	// ---For Warehouse space---//
	@FindBy(how = How.XPATH, using = "//input[@id='godown_space']")
	private WebElement WarehouseSpace;

	// ---For Normal store IsActive Check-box---//
	@FindBy(how = How.XPATH, using = "//input[@id='nor_is_active']")
	private WebElement NormalStoreIsActiveCheckbox;

	// ---For Normal store IsDefault Check-box---//
	@FindBy(how = How.XPATH, using = "//input[@id='nor_is_default']")
	private WebElement NormalStoreIsDefaultCheckbox;

	// ---For SearchTxt---//
	@FindBy(how = How.XPATH, using = "//input[@id='searchTxt']")
	private WebElement SearchTxt;

	// ---For Search Button---//
	@FindBy(how = How.XPATH, using = "//input[@id='searchbtn']")
	private WebElement Searchbtn;

	// ---For Mobile Store Radio button---//
	@FindBy(how = How.XPATH, using = "//input[@id='mb_store']")
	private WebElement MobileStoreRadiobtn;

	// ---For Vehicle Number---//
	@FindBy(how = How.XPATH, using = "//input[@id='vehicle_no']")
	private WebElement VehicleNumber;

	// ---For Vehicle Description---//
	@FindBy(how = How.XPATH, using = "//input[@id='vehicle_desc']")
	private WebElement VehicleDescription;

	// ---For Vehicle Volume---//
	@FindBy(how = How.XPATH, using = "//input[@id='vehicle_volume']")
	private WebElement VehicleVolume;

	// ---For Vehicle Capacity---//
	@FindBy(how = How.XPATH, using = "//input[@id='vehicle_capacity']")
	private WebElement VehicleCapacity;

	// ---For DeviceId---//
	@FindBy(how = How.XPATH, using = "//input[@id='mob_device_id']")
	private WebElement DeviceId;

	// ---For Mobile store IsActive Check-box---//
	@FindBy(how = How.XPATH, using = "//input[@id='vehicle_is_active']")
	private WebElement MobileStoreIsActiveCheckbox;

	// ---For Mobile store IsDefault Check-box---//
	@FindBy(how = How.XPATH, using = "//input[@id='vehicle_is_default']")
	private WebElement MobileStoreIsDefaultCheckbox;

	// ---For Save Button---//
	@FindBy(how = How.XPATH, using = "//input[@id='saveBtn']")
	private WebElement SaveBtn;

	// ---For Cancel Button---//
	@FindBy(how = How.XPATH, using = "//input[@id='cancel']")
	private WebElement cancelBtn;

	// ---For Search box ---//
	@FindBy(how = How.XPATH, using = "//input[@id='searchTxt']")
	private WebElement SearchBox;

	// ---For Search box ---//
	@FindBy(how = How.XPATH, using = "//input[@id='searchbtn']")
	private WebElement SearchBtn;
	
	//---For Popupselectstaffcode---//
	@FindBy(how = How.XPATH, using = "//select[@id='results_list']/option")
	private WebElement Popupselectstaffcode;
	
	//---For PopupOkBtn---//
	@FindBy(how = How.XPATH, using = "//input[@id='okBtn']")
	private WebElement PopupOkBtn;
	
	

	// ----------------------Basic Functions----------------------//

	// ---For Select Normal store Radio Button function---//
	public void SelectNormalstoreRadioButton() {
		selectRadioButton(NormalStoreRadiobtn);
	}

	// ---For Select Mobile store Radio Button function---//
	public void SelectMobilestoreRadioButton() {
		selectRadioButton(MobileStoreRadiobtn);
	}
	
	// ---select SimRetailer checkbox---//
	public boolean isNormalstoreRadioButtonselected() {
		return radiobtnIsselected(NormalStoreRadiobtn);
	}

	// ---For Enter Store name function---//
	public void enterMobileStoreName(String storename) {
		entervalue(storename, StoreName);

	}

	// ---For getMobileStoreName---//
		public String getMobileStoreName() {
			return getvalue(StoreName);

		}
		
	// ---For Enter Normal Store name function---//
	public void enterNormalStoreName(String storename) {
		entervalue(storename, StoreName);
	}

	// ---For getNormalStoreName---//
	public String getNormalStoreName() {
		return getvalue(StoreName);
	}

	// ---For getNormalStoreRefNo---//
	public String getNormalStoreRefNo() {
		return getvalue(StoreRefNo);
	}

	// ---For Enter address1 function---//
	public void enterAddress1(String address1) {
		entervalue(address1, Address1);
	}

	// ---For getAddress1---//
	public String getAddress1() {
		return getvalue(Address1);
	}

	// ---For Enter address2 function---//
	public void enterAddress2(String address2) {
		entervalue(address2, Address2);
	}

	// ---For getAddress2---//
	public String getAddress2() {
		return getvalue(Address2);
	}

	// ---For Select State function---//
	public void enterState(String statename) {
		entervalue(statename, State);
	}

	// ---For getState---//
	public String getState() {
		return getvalue(State);
	}

	// ---For Select City function---//
	public void enterCity(String cityname) {
		entervalue(cityname, City);
	}

	// ---For getCity---//
	public String getCity() {
		return getvalue(City);
	}

	// ---For Enter Vehicle Number function---//
	public void enterVehicleNumber(String vehicleNo) {
		entervalue(vehicleNo, VehicleNumber);
		// el.Excelwrite(fileLocation, vehicle_No);
	}
	// ---For getVehicleNumber---//
		public String getVehicleNumber() {
			return getvalue(VehicleNumber);
		}
		
	// ---For Enter Warehouse Space function---//
	public void enterwarehouseSpace(String warehousespace) {
		entervalue(warehousespace, WarehouseSpace);
	}

	// ---For getwarehouseSpace---//
	public String getwarehouseSpace() {
		return getvalue(WarehouseSpace);
	}

	// ---For Enter Vehicle description function---//
	public void enterVehicleDescription(String vehicleDesc) {
		entervalue(vehicleDesc, VehicleDescription);
	}

	// ---For getVehicleDescription---//
	public String getVehicleDescription() {
		return getvalue(VehicleDescription);
	}

	// ---For Enter Vehicle Volume function---//
	public void enterVehicleVolume(String vehiclevol) {
		entervalue(vehiclevol, VehicleVolume);

	}

	// ---For getVehicleVolume---//
	public String getVehicleVolume() {
		return getvalue(VehicleVolume);
	}

	// ---For Enter Vehicle Capacity function---//
	public void enterVehicleCapacity(String vehicleCap) {
		entervalue(vehicleCap, VehicleCapacity);
	}

	// ---For getVehicleCapacity---//
	public String getVehicleCapacity() {
		return getvalue(VehicleCapacity);
	}

	// ---For enterVehicleDeviceId---//
	public void enterVehicleDeviceId(String deviceId) {
		entervalue(deviceId, DeviceId);
	}

	// ---For getVehicleDeviceId---//
	public String getVehicleDeviceId() {
		return getvalue(DeviceId);
	}

	// ---For select Mobile Store IsActive function---//
	public void selectMobileStoreIsActiveCheckbox() {
		checkboxselect(MobileStoreIsActiveCheckbox);
	}
	
	// ---select SimRetailer checkbox---//
	public boolean isMobileStoreIsActiveSelected() {
		return checkboxIsselected(MobileStoreIsActiveCheckbox);
	}

	// ---For select Mobile Store IsDefault function---//
	public void selectMobileStoreIsDefaultCheckbox() {
		checkboxselect(MobileStoreIsDefaultCheckbox);
	}
	
	// ---For select MNormalStoreIsActiveCheckbox function---//
	public void selectNormalStoreIsActiveCheckbox() {
		checkboxselect(NormalStoreIsActiveCheckbox);
	}
	
	// ---select SimRetailer checkbox---//
	public boolean isNormalStoreIsActiveSelected() {
		return checkboxIsselected(NormalStoreIsActiveCheckbox);
	}

	// ---For select Normal Store IsDefault function---//
	public void selectNormalStoreIsdefaultCheckbox() {
		checkboxselect(NormalStoreIsDefaultCheckbox);
	}

	// ---For Click On Save Button function---//
	public void clickOnSaveBtn() {
		buttonClick(SaveBtn);
	}

	// ---For Click On Clear Button function---//
	public void clickOnClearBtn() {
		buttonClick(cancelBtn);
	}

	// ---For Enter Seach Value function---//
	public void entervaluetosearch(String searchvalue) {
		entervalue(searchvalue, SearchTxt);
	}

	// ---For Click On Search Button function---//
	public void clickOnSearchBtn() {
		buttonClick(Searchbtn);
	}

	public void enterTextToSearch(String text) {
		entervalue(text, SearchBox);

	}

	public void ClickOnSearchbtn() {
		buttonClick(SearchBtn);

	}
	
	
	public void clickOnPopupselectstaffcode() {
		buttonClick(Popupselectstaffcode);
	}
	
	public void clickOnPopupOkBtn() {
		buttonClick(PopupOkBtn);
	}

}
