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
public class StaffMaster extends WebDriverCommonLib {
	WebDriver driver;

	// ----------------------Constructor----------------------//
	public StaffMaster(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//
	// ---For Select Category---//
		@FindBy(how = How.ID, using = "sCategory")
		private WebElement Select_Catogory;
		
		//---For Title---//
		@FindBy(how= How.XPATH,using= "//select[@id='custTitle']")
		private WebElement Staff_title;
		
		// ---For Staff name---//
		@FindBy(how = How.XPATH, using = "//input[@id='staff_name']")
		private WebElement Staff_name;
		
		//---For Staff LastName---//
		@FindBy(how= How.XPATH, using = "//input[@id='profileLastName']")
		private WebElement Staff_LastName;
		
		//---momoAccountId---//
		@FindBy(how= How.XPATH, using = "//input[@id='momoAccountId']")
		private WebElement Staff_MomoAccId;
		
		//---momoMSSISDN---//
		@FindBy(how= How.XPATH, using = "//input[@id='momoMSSISDN']")
		private WebElement Staff_MomoMssisId;
		
		 //---evdAccountId---//
		@FindBy(how= How.XPATH, using = "//input[@id='evdAccountId']")
		private WebElement Staff_EvdAccId;
		
		//---evdMSSISDN ---//
		@FindBy(how = How.XPATH, using ="//input[@id='evdMSSISDN']")
		private WebElement Staff_EvdMssisId;
		
		//---IMEINI---//
		@FindBy(how = How.XPATH, using ="//input[@id='imeinumber']")
		private WebElement Staff_IMEINUM;
		
		//---Address---//
		@FindBy(how =How.XPATH, using ="//a[@id='saveBtn100000007']")
		private WebElement Staff_Address;
		
		//---Shop building name---//
		@FindBy(how =How.XPATH, using = "//input[@id='shopName']")
		private WebElement Staff_ShopBuildingname;
		
		
		//---Street---//
		@FindBy(how = How.XPATH, using = "//input[@id='streetAdds']")
		private WebElement Staff_Street;
		
		
		//---Landmark---//
		@FindBy(how = How.XPATH, using = "//input[@id='landmark']")	
		private WebElement Staff_Landmark;
		
		//---City---//
		@FindBy(how = How.XPATH, using = "//select[@id='cityCombo']")	
		private WebElement Staff_City;
		
		//---State---//
		@FindBy(how = How.XPATH, using = "//select[@id='stateCombo']")
		private WebElement Staff_State;
		
		//---PinCode---//
		@FindBy(how = How.XPATH, using = "//input[@id='pinCode']")
		private WebElement Staff_Pincode;
		
		
		//---PhNo---//
		@FindBy(how = How.XPATH, using = "//input[@id='phNo']")
		private WebElement Staff_PhNo;
		
		//--AlternatePhNo---//
		@FindBy(how = How.XPATH, using = "//input[@id='altPhNo']")
		private WebElement Staff_AltPhNo;
		
		//---Email---//
		@FindBy(how = How.XPATH, using = "//input[@id='emailId']")
		private WebElement Staff_Email;
		
		//---OKbtn---//
		@FindBy(how = How.XPATH, using = "//input[@id='saveBtn']")
		private WebElement Okbtn;
		
		
		//---ArrowButton---//
		@FindBy(how = How.XPATH, using = "//span[@id='expandDeregDiv']")
		private WebElement Staff_Arrowbtn;
		
		//---Activated Radio Button---//
		@FindBy(how = How.XPATH, using = "//input[@value='Activated']")
		private WebElement ACtiveRadiobtn;
		
		
		//---ClearBtn---//
		@FindBy(how = How.XPATH, using = "//input[@id='clearBtn']")
		private WebElement ClearBtn;
		
		//---SaveBtn---//
		@FindBy(how = How.XPATH, using = "//input[@id='actionBtnSUBMIT']")
		private WebElement SaveBtn;
		
		
		//---CloseBtn---//
		@FindBy(how = How.XPATH,using = "(//input[@value='Close'])[1]")
		private WebElement CloseBtn;
			
		
	    // ---For Staff Date Of Joining---//
	    @FindBy(how = How.XPATH, using = "//input[@id='sDOJ']")
	    private WebElement Staff_Dojoin;

       //---For Staff Date Of Birth---//
	   @FindBy(how = How.XPATH, using = "//input[@id='sDOB']")
	   private WebElement Staff_DoBirth;
	   
	   //---DOBpopup--//
	   @FindBy(how =How.XPATH,using = "//input[@id='BDate']")
	   private WebElement Staff_DoBCal;
	   
	   


	// ----------------------Functions----------------------//

	// ---For staffName---//
	public void enterStaffName(String staffName) {
		entervalue(staffName, Staff_name);

	}

	// ---For staffName---//
	public String getStaffName() {
		return getvalue(Staff_name);

	}
	
	// ---For enterStaffLastName---//
		public void enterStaffLastName(String staffLastName) {
			entervalue(staffLastName, Staff_LastName);

		}

		// ---For getStaffLastName---//
		public String getStaffLastName() {
			return getvalue(Staff_LastName);

		}
		// ---For enterStaffMomoAccId---//
		public void enterStaffMomoAccId(String staffMomoAccId) {
			entervalue(staffMomoAccId, Staff_MomoAccId);

		}

		// ---For getStaffMomoAccId---//
		public String getStaffMomoAccId() {
			return getvalue(Staff_MomoAccId);

		}
		
		// ---For enterStaffMomoMssisId---//
		public void enterStaffMomoMssisId(String staffMomoMssisId) {
			entervalue(staffMomoMssisId, Staff_MomoMssisId);

		}

		// ---For getStaffMomoMssisId---//
		public String getStaffMomoMssisId() {
			return getvalue(Staff_MomoMssisId);

		}
		
		// ---For enterStaffEvdMssisId---//
		public void enterStaffEvdMssisId(String staffEvdMssisId) {
			entervalue(staffEvdMssisId, Staff_EvdMssisId);

		}

		// ---For getStaffEvdMssisId---//
		public String getStaffEvdMssisId() {
			return getvalue(Staff_EvdMssisId);

		}
		
		// ---For enterStaffEvdAccId---//
		public void enterStaffEvdAccId(String staffEvdAccId) {
			entervalue(staffEvdAccId, Staff_EvdAccId);

		}

		// ---For getStaffEvdAccId---//
		public String getStaffEvdAccId() {
			return getvalue(Staff_EvdAccId);

		}
		// ---For Select Catogory---//
	    public void SelectCatogory(String catogory) {
		   selectvalue(catogory, Select_Catogory);
	    }

	   // ---For Select_Catogory---//
	    public String getStaffCatogory() {
		   return getselectDrpdwnValue(Select_Catogory);

      	}
	   // ---For Select Title---//
	    public void SelectTitle(String Title) {
		   selectvalue(Title, Staff_title);
	    }

	   // ---For Select_Title---//
	    public String getStaffTitle() {
		   return getselectDrpdwnValue(Staff_title);

      	}
		
		// ---For Enter Date of Birthday---//
	    public void enterDateofBirth(String BirthdayDate) {
		  entervalue(BirthdayDate, Staff_DoBirth);
	    }

	    // ---For Staff_DoBirth---//
	    public String getStaffDateofBirth() {
		  return getvalue(Staff_DoBirth);

	      }
	    //---DOBCal---//
		public void ClickOnStaffDoBCal() {
			buttonClick(Staff_DoBCal);
		}
	    //---AddressBtn---//
		public void ClickOnAddress() {
			buttonClick(Staff_Address);
		}
		
		// ---For enterStaffShopBuildingname---//
		public void enterStaffShopBuildingname(String staffShopBuildingname) {
			entervalue(staffShopBuildingname, Staff_ShopBuildingname);

		}

		// ---For getStaffShopBuildingname---//
		public String getStaffShopBuildingname() {
			return getvalue(Staff_ShopBuildingname);
		}
		
		// ---For enterStaffStreet---//
		public void enterStaffStreet(String staffStreet) {
			entervalue(staffStreet, Staff_Street);

		}

		// ---For getStaffStreet---//
		public String getStaffStreet() {
			return getvalue(Staff_Street);
		}
		
		// ---For enterStaffStreet---//
		public void enterStaffLandmark(String staffLandmark) {
			entervalue(staffLandmark, Staff_Landmark);

		}

		// ---For getStaffStreet---//
		public String getStaffLandmark() {
			return getvalue(Staff_Landmark);
		}
		
		// ---For Select City---//
	    public void SelectCity(String City) {
		   selectvalue(City, Staff_City);
	    }

	   // ---For Select_City---//
	    public String getStaffCity() {
		   return getselectDrpdwnValue(Staff_City);
	    }  
	    
	   // ---For Select State---//
	    public void SelectState(String State) {
		   selectvalue(State, Staff_State);
	    }

	   // ---For Select_State---//
	    public String getStaffState() {
		   return getselectDrpdwnValue(Staff_State);
	    }
	    
		// ---For enterStaffPincode---//
		public void enterStaffPincode(String staffPincode) {
			entervalue(staffPincode, Staff_Pincode);

		}

		// ---For getStaffPincode---//
		public String getStaffPincode() {
			return getvalue(Staff_Pincode);
		}
		
		// ---For enterStaffPhNo---//
		public void enterStaffPhNo(String staffPhNo) {
			entervalue(staffPhNo, Staff_PhNo);

		}

		// ---For getStaffPhNo---//
		public String getStaffPhNo() {
			return getvalue(Staff_PhNo);
		}
		
		// ---For enterStaffAltPhNo---//
		public void enterStaffAltPhNo(String staffAltPhNo) {
			entervalue(staffAltPhNo, Staff_AltPhNo);

		}

		// ---For getStaffAltPhNo---//
		public String getStaffAltPhNo() {
			return getvalue(Staff_AltPhNo);
		}
		
		// ---For enterStaffAltPhNo---//
		public void enterStaffEmail(String staffEmail) {
			entervalue(staffEmail, Staff_Email);

		}

		// ---For getStaffAltPhNo---//
		public String getStaffEmail() {
			return getvalue(Staff_Email);
		}
		
	    //---OKBtn---//
		public void ClickOnOK() {
			buttonClick(Okbtn);
		}
		
	    //---ArrowBtn---//
		public void ClickOnArrowBtn() {
			buttonClick(Staff_Arrowbtn);
		}
		
	    //---ACtiveRadiobtn---//
		public void ClickOnACtiveRadiobtn() {
			buttonClick(ACtiveRadiobtn);
		}
		
	    //---SaveBtn---//
		public void ClickOnSaveBtn() {
			buttonClick(SaveBtn);
		}
		
	    //---ClearBtn---//
		public void ClickOnClearBtn() {
			buttonClick(ClearBtn);
		}
		
	    //---CloseBtn---//
		public void ClickOnCloseBtn() {
			buttonClick(CloseBtn);
		}
		
		
		
	 
		
		
	
		
		
		
		
	
				
		
	    
	    
	    
		
		
		


		
		
		
		
		
		


}

