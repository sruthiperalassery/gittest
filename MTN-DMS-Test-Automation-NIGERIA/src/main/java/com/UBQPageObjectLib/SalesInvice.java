package com.UBQPageObjectLib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.UBQGenericLib.WebDriverCommonLib;

public class SalesInvice extends WebDriverCommonLib {
	WebDriver driver;

	// ----------------------Constructor----------------------//
	public SalesInvice(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

	// ---For SBU---//
	@FindBy(how = How.XPATH, using = "//select[@id='SBU']")
	private WebElement SBU;

	// ---For CustomerType---//
	@FindBy(how = How.XPATH, using = "//select[@id='entityType']")
	private WebElement Customertype;

	// ---For Salesman---//
	@FindBy(how = How.XPATH, using = "//select[@id='hidsalesman']")
	private WebElement Salesman;

	// ---For Route---//
	@FindBy(how = How.XPATH, using = "//select[@id='setBeat']")
	private WebElement Route;

	// ---For CustomerName---//
	@FindBy(how = How.XPATH, using = "//input[@id='customer']")
	private WebElement Customername;

	// ---For Address1---//
	@FindBy(how = How.XPATH, using = "//input[@id='address1']")
	private WebElement Address1;

	// ---For CustomerUID---//
	@FindBy(how = How.XPATH, using = "//input[@id='custUid']")
	private WebElement CustomerUID;

	// ---For CustomerCode---//
	@FindBy(how = How.XPATH, using = "//input[@id='shopcode']")
	private WebElement CustomerCode;

	// ------------------------------------------------------------------------//

	// ---For ShippingAdddress---//
	@FindBy(how = How.XPATH, using = "//select[@id='custShippingAddr']")
	private WebElement ShippingAdddressSelect;

	// ---For ShippingAddressDetailsLink---//
	@FindBy(how = How.XPATH, using = "//tr[@id='addressFTr']/td/span[2]/span")
	private WebElement ShippingAddressDetailsLink;

	// ---For ShippingAddress---//
	@FindBy(how = How.XPATH, using = "//input[@id='addShopName']")
	private WebElement ShippingAddress;

	// ---For ShippingAddressStreet---//
	@FindBy(how = How.XPATH, using = "//input[@id='addStreet']")
	private WebElement ShippingAddressStreet;

	// ---For ShippingAddressState---//
	@FindBy(how = How.XPATH, using = "//input[@id='addState']")
	private WebElement ShippingAddressState;

	// ---For ShippingAddressCity---//
	@FindBy(how = How.XPATH, using = "//input[@id='addCity']")
	private WebElement ShippingAddressCity;

	// ---For ShippingAddressPinCode---//
	@FindBy(how = How.XPATH, using = "//input[@id='addPinCode']")
	private WebElement ShippingAddressPinCode;

	// ---For ShippingAddressGSTTinNo---//
	@FindBy(how = How.XPATH, using = "//input[@id='addGSTTinNo']")
	private WebElement ShippingAddressGSTTinNo;

	// ------------------------------------------------------------------------//

	// ---For BillType---//
	@FindBy(how = How.XPATH, using = "//select[@id='billType']")
	private WebElement BillType;

	// ---For Sales Invoice Series---//
	@FindBy(how = How.XPATH, using = "//select[@id='billseries']")
	private WebElement Series;

	// ---For Store---//
	@FindBy(how = How.XPATH, using = "//select[@id='store']")
	private WebElement Store;

	// ---For OrderDate---//
	@FindBy(how = How.XPATH, using = "//input[@id='hidinvoiceDate']")
	private WebElement OrderDate;

	// ---For DeliveryDate---//
	@FindBy(how = How.XPATH, using = "//input[@id='deliveryDate']")
	private WebElement DeliveryDate;

	// ---For CashDiscount---//
	@FindBy(how = How.XPATH, using = "//input[@id='spDiscount']")
	private WebElement CashDiscount;

	// ---For PercentageOrAmtCheckBox---//
	@FindBy(how = How.XPATH, using = "//input[@id='percentageoramt']")
	private WebElement PercentageOrAmtCheckBox;

	// ---For CashDiscountReason---//
	@FindBy(how = How.XPATH, using = "//select[@id='reason']")
	private WebElement CashDiscountReason;

	// ---For PaymentMode---//
	@FindBy(how = How.XPATH, using = "//select[@id='paymentMode']")
	private WebElement PaymentMode;

	// ---For AccountBalance---//
	@FindBy(how = How.XPATH, using = "//input[@id='debtorblce']")
	private WebElement AccountBalance;

	// ---For AccountBalance---//
	@FindBy(how = How.XPATH, using = "//input[@id='creditamt']")
	private WebElement CreditLimit;

	// ---For Remarks---//
	@FindBy(how = How.XPATH, using = "//input[@id='remarks']")
	private WebElement Remarks;

	// ---For PrintOnConfirmationCheckBox---//
	@FindBy(how = How.XPATH, using = "//input[@id='immediatePrint']")
	private WebElement PrintOnConfirmationCheckBox;

	// ---For Numberoflinesordered---//
	@FindBy(how = How.XPATH, using = "//input[@id='noofitems']")
	private WebElement Numberoflinesordered;

	// ---For TotalgrossAmount---//
	@FindBy(how = How.XPATH, using = "//input[@id='totalgrossvalue']")
	private WebElement TotalgrossAmount;

	// ---For TotalTradeDisc---//
	@FindBy(how = How.XPATH, using = "//input[@id='tradeDiscount']")
	private WebElement TotalTradeDisc;

	// ---For TotalCashDisc---//
	@FindBy(how = How.XPATH, using = "//input[@id='specialDiscount']")
	private WebElement TotalCashDisc;

	// ---For TotExciseDuty---//
	@FindBy(how = How.XPATH, using = "//input[@id='totExciseDuty']")
	private WebElement TotExciseDuty;

	// ---For TotEduCess---//
	@FindBy(how = How.XPATH, using = "//input[@id='totEduCess']")
	private WebElement TotEduCess;

	// ---For TotSecEduCess---//
	@FindBy(how = How.XPATH, using = "//input[@id='totSecEduCess']")
	private WebElement TotSecEduCess;

	// ---For TotalTaxableAmount---//
	@FindBy(how = How.XPATH, using = "//input[@id='totaltaxableamount']")
	private WebElement Totaltaxableamount;

	// ---For CgstTaxTotal---//
	@FindBy(how = How.XPATH, using = "//input[@id='cgsttaxTotal']")
	private WebElement CgstTaxTotal;

	// ---For CgstTaxTotal---//
	@FindBy(how = How.XPATH, using = "//input[@id='sgsttaxTotal']")
	private WebElement SgstTaxTotal;

	// ---For IgstTaxTotal---//
	@FindBy(how = How.XPATH, using = "//input[@id='igsttaxTotal']")
	private WebElement IgstTaxTotal;

	// ---For TotalOrderamount---//
	@FindBy(how = How.XPATH, using = "//input[@id='invoiceamount']")
	private WebElement TotalOrderamount;

	// ---For TotalInvoiceDisc---//
	@FindBy(how = How.XPATH, using = "//input[@id='cashDisc']")
	private WebElement TotalInvoiceDisc;

	// ---For TotalInvoiceDiscPerCheckBox---//
	@FindBy(how = How.XPATH, using = "//input[@id='cashPerOrAmt']")
	private WebElement TotalInvoiceDiscPerCheckBox;

	// ---For TotInvoiceDiscount---//
	@FindBy(how = How.XPATH, using = "//input[@id='totCashDiscount']")
	private WebElement TotInvoiceDiscount;

	// ---For TotalCreditNote---//
	@FindBy(how = How.XPATH, using = "//input[@id='creditnote']")
	private WebElement TotalCreditNote;

	// ---For TotalDebitNote---//
	@FindBy(how = How.XPATH, using = "//input[@id='debitnote']")
	private WebElement TotalDebitNote;

	// ---For FreightCharge---//
	@FindBy(how = How.XPATH, using = "//input[@id='freightCharge']")
	private WebElement FreightCharge;

	// ---For RoundOff---//
	@FindBy(how = How.XPATH, using = "//input[@id='roundOff']")
	private WebElement RoundOff;

	// ---For TotalnetAmount---//
	@FindBy(how = How.XPATH, using = "//input[@id='netamount']")
	private WebElement TotalnetAmount;

	// ---For Calculate---//
	@FindBy(how = How.ID, using = "finalize")
	private WebElement Calculatebtn;

	// ---For Confirm---//
	@FindBy(how = How.ID, using = "confirm")
	private WebElement Confirmbtn;

	// ---For Clear Btn ---//
	@FindBy(how = How.XPATH, using = "//input[@id='cancel']")
	private WebElement clearbtn;

	// ---For Cancel Btn ---//
	@FindBy(how = How.XPATH, using = "//input[@id='reverse']")
	private WebElement cancelbtn;

	// ---For enter product code---//
	@FindBy(how = How.XPATH, using = "//input[@id='productcode']")
	private WebElement ProductCode;
	
	//---For enter SaleQty---//	
	@FindBy(how = How.XPATH, using = "//input[@id='qty']")
	private WebElement SaleQty;

	//---For enter SaleQty---//	
	@FindBy(how = How.XPATH, using = "//input[@type='image']")
	private WebElement PopupSRCancelBtn;

	// ----------------------Basic functions----------------------//

	// For selectSBU
	public void selectSBU(String sbu) {
		selectvalue(sbu, SBU);
	}

	// For getSBU
	public String getSBU() {
		return getselectDrpdwnValue(SBU);
	}

	// For selectCustomertype
	public void selectCustomertype(String customertype) {
		selectvalue(customertype, Customertype);
	}

	// For getCustomertype
	public String getCustomertype() {
		return getselectDrpdwnValue(Customertype);
	}

	// For Salesman
	public void selectSalesman(String salesman) {
		selectvalue(salesman, Salesman);
	}

	// For getSalesman
	public String getSalesman() {
		return getselectDrpdwnValue(Salesman);
	}

	// For Select Route
	public void selectRoute(String route) {
		selectvalue(route, Route);
	}

	// For getRoute
	public String getRoute() {
		return getselectDrpdwnValue(Route);
	}

	// For Select customername
	public void selectCustomer(String customername) {
		entervalue(customername, Customername);
	}

	// For getCustomer
	public String getCustomer() {
		return getvalue(Customername);
	}

	// ---For Select customercode---//
	public void selectCustomerCode(String custcode) {
		entervalue(custcode, CustomerCode);
	}

	// For getMainAddress
	public String getMainAddress() {
		return getvalue(Address1);
	}

	// For getCustomerUID
	public String getCustomerUID() {
		return getvalue(CustomerUID);
	}

	// For getCustomerCode
	public String getCustomerCode() {
		return getvalue(CustomerCode);
	}

	// For getShippingAddressSelected
	public String getShippingAddressSelected() {
		return getselectDrpdwnValue(ShippingAdddressSelect);
	}

	// For getShippingAddress
	public String getShippingAddress() {
		return getvalue(ShippingAddress);
	}

	// For getShippingAddressStreet
	public String getShippingAddressStreet() {
		return getvalue(ShippingAddressStreet);
	}

	// For getShippingAddressState
	public String getShippingAddressState() {
		return getvalue(ShippingAddressState);
	}

	// For getShippingAddressCity
	public String getShippingAddressCity() {
		return getvalue(ShippingAddressCity);
	}

	// For getShippingAddressPinCode
	public String getShippingAddressPinCode() {
		return getvalue(ShippingAddressPinCode);
	}

	// For getShippingAddressGSTTinNo
	public String getShippingAddressGSTTinNo() {
		return getvalue(ShippingAddressGSTTinNo);
	}

	// For SelectType
	public void BillType(String type) {
		selectvalue(type, BillType);
	}

	// For getSelectType
	public String getBillType() {
		return getselectDrpdwnValue(BillType);
	}

	// For SelectSeries
	public void SelectSeries(String series) {
		selectvalue(series, Series);
	}

	// For getSelectSeries
	public String getSelectSeries() {
		return getselectDrpdwnValue(Series);
	}

	// For orderSeries
	public void SelectStore(String store) {
		selectvalue(store, Store);
	}

	// For getSelectType
	public String getStore() {
		return getselectDrpdwnValue(Store);
	}

	// For getOrderDate
	public String getOrderDate() {
		return getvalue(OrderDate);
	}

	// For EnterDeliveryDate
	public void EnterDeliveryDate(String DelDate) {
		entervalue(DelDate, DeliveryDate);
	}

	// For getDeliveryDate
	public String getDeliveryDate() {
		return getvalue(DeliveryDate);
	}

	// For EnterCashDisc
	public void EnterCashDisc(String cashdisc) {
		entervalue(cashdisc, CashDiscount);
	}

	// For getCashDisc
	public String getCashDisc() {
		return getvalue(CashDiscount);
	}

	// For EnterCashDisc
	public void SelectCashDiscountCheckbox() {
		checkboxselect(PercentageOrAmtCheckBox);
	}

	// For SelectCashDiscountReason
	public void SelectCashDiscountReason(String reason) {
		selectvalue(reason, CashDiscountReason);
	}

	// For SelectCashDiscountReason
	public String getCashDiscountReason() {
		return getselectDrpdwnValue(CashDiscountReason);
	}

	// For SelectPayMode
	public void SelectPayMode(String paymode) {
		selectvalue(paymode, PaymentMode);
	}

	// For getPayMode
	public String getPayMode() {
		return getselectDrpdwnValue(PaymentMode);
	}

	// For getAccountBalence
	public String getAccountBalence() {
		return getvalue(AccountBalance);
	}

	// For getCreditLimit
	public String getCreditLimit() {
		return getvalue(CreditLimit);
	}

	// For EnterRemarks
	public void EnterRemarks(String remark) {
		entervalue(remark, Remarks);
	}

	// For getRemarks
	public String getRemarks() {
		return getvalue(Remarks);
	}

	// For PrintOnConfirmationCheckbox
	public void PrintOnConfirmationCheckbox() {
		checkboxdeselect(PrintOnConfirmationCheckBox);
	}

	// For getNoOfLinesOrdered
	public String getNoOfLinesOrdered() {
		return getvalue(Numberoflinesordered);
	}

	// ---For TotalgrossAmount---//
	public String getTotalgrossAmt() {
		return getvalue(TotalgrossAmount);
	}

	// ---For getTotalTradeDiscAmt---//
	public String getTotalTradeDiscAmt() {
		return getvalue(TotalTradeDisc);
	}

	// ---For getTotalTotalCashDiscAmt---//
	public String getTotalCashDiscAmt() {
		return getvalue(TotalCashDisc);
	}

	// ---For getTotalExciseDutyAmt---//
	public String getTotalExciseDutyAmt() {
		return getvalue(TotExciseDuty);
	}

	// ---For getTotalEduCessAmt---//
	public String getTotalEduCessAmt() {
		return getvalue(TotEduCess);
	}

	// ---For getTotalSecEduCessAmt---//
	public String getTotalSecEduCessAmt() {
		return getvalue(TotSecEduCess);
	}

	// ---For getTotalTaxableAmt---//
	public String getTotalTaxableAmt() {
		return getvalue(Totaltaxableamount);
	}

	// ---For getTotalCGSTAmt---//
	public String getTotalCGSTAmt() {
		return getvalue(CgstTaxTotal);
	}

	// ---For getTotalSGSTAmt---//
	public String getTotalSGSTAmt() {
		return getvalue(SgstTaxTotal);
	}

	// ---For getTotalIGSTAmt---//
	public String getTotalIGSTAmt() {
		return getvalue(IgstTaxTotal);
	}

	// ---For getTotalOrderamount---//
	public String getTotalOrderamount() {
		return getvalue(TotalOrderamount);
	}

	// ---For EnterInvoiceDisc---//
	public void selectInvoiceDiscCheckbox() {
		checkboxselect(TotalInvoiceDiscPerCheckBox);
	}

	// ---For EnterInvoiceDisc---//
	public void EnterInvoiceDisc(String invdisc) {
		entervalue(invdisc, TotalInvoiceDisc);
	}

	// ---For getInvoiceDisc---//
	public String getInvoiceDisc() {
		return getvalue(TotalInvoiceDisc);
	}

	// ---For getInvoiceDiscAmt---//
	public String getInvoiceDiscAmt() {
		return getvalue(TotInvoiceDiscount);
	}

	// ---For getCreditNoteAmt---//
	public String getCreditNoteAmt() {
		return getvalue(TotalCreditNote);
	}

	// ---For getDebitNoteAmt---//
	public String getDebitNoteAmt() {
		return getvalue(TotalDebitNote);
	}

	// ---For getFreightChargeAmt---//
	public String getFreightChargeAmt() {
		return getvalue(FreightCharge);
	}

	// ---For getRoundOffAmt---//
	public String getRoundOffAmt() {
		return getvalue(RoundOff);
	}

	// ---For TotalinvoiceAmount---//
	public String getTotalnetAmount() {
		return getvalue(TotalnetAmount);
	}

	// For Click Calculatebtn
	public void clickCalculatebtn() {
		buttonClick(Calculatebtn);
	}

	// For Click Confirmbtn
	public void clickConfirmbtn() {
		buttonClick(Confirmbtn);
	}

	// For Click Clear
	public void clickclearBtn() {
		buttonClick(clearbtn);
	}

	// For click cancelBtn
	public void clickcancelBtn() {
		buttonClick(cancelbtn);
	}

	// For Click Shippingaddresslink
	public void clickOnShippingAddressLink() {
		buttonClick(ShippingAddressDetailsLink);
	}
	
	//---For enter product code---//
	public void enterProductCode(String prodcode) {
		entervalue(prodcode, ProductCode);
		ProductCode.sendKeys(Keys.TAB);
	}
	
	// For click PopupSRCancelBtn
	public void clickOnPopupSRcancelBtn() {
		buttonClick(PopupSRCancelBtn);
	}
	//---For enter sale qty---//
	public void enterSaleQty(String Qty) {
		SaleQty.clear();
		acceptAlert();
		entervalue(Qty,SaleQty);
		SaleQty.sendKeys(Keys.TAB);
		
	}

	// For getNumOfProductRows
	public int getNumOfProductRows() {
		List<WebElement> size = driver.findElements(By.xpath("//table[@id='billDetailsTable']/tbody/tr[@class='sectionDetail']"));
		return size.size();
	}
	
	// -----------------For enterQtyatRow------//
	public void enterQtyatRow(int rnum,Long value) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='billDetailsTable']/tbody[2]/tr[" + rnum + "]/td[5]/input"));
		element.clear();
		acceptAlert();
		entervalue(String.valueOf(value), element);

	}
	
	//----------------------Click on serial number link---------------//
		public void ClickonSerialNoLinkAtRow(int rnum){
			WebElement element = driver
					.findElement(By.xpath("//table[@id='billDetailsTable']/tbody[2]/tr[" + rnum + "]/td[11]/img"));
			buttonClick(element);
		}
		
	// ---- for getProductCodeAtRow ---- //
	public String getProductCodeAtRow(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='billDetailsTable']/tbody[2]/tr[" + rnum + "]/td[2]/input"));
		return getvalue(element);
	}

	// ---- for getProductNameAtRow ---- //
	public String getProductNameAtRow(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='billDetailsTable']/tbody[2]/tr[" + rnum + "]/td[3]/input"));
		return getvalue(element);
	}

	// ---- for getProductMRPAtRow ---- //
	public String getProductMRPAtRow(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='billDetailsTable']/tbody[2]/tr[" + rnum + "]/td[7]/select[1]"));
		return getvalue(element);
	}
	// ---- for getProductMRPAtRow ---- //
	public String getProductBatchAtRow(int rnum) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='billDetailsTable']/tbody[2]/tr[" + rnum + "]/td[7]/select[1]"));
		return getvalue(element);
	}


	// For SelectProductCodeForMultipleRows
	public void SelectProductNameForMultipleRows(int row) {
		WebElement element = driver
				.findElement(By.xpath("//table[@id='billDetailsTable']/tbody[2]/tr[" + row + "]/td[3]/input"));
		highLightElement(driver, element);
		element.sendKeys(Keys.SPACE, Keys.TAB);
	}

	// For SelectdiscountcheckboxForMultipleRows
	public void SelectdiscountcheckboxForMultipleRows(int row, int col) {
		WebElement element = driver.findElement(
				By.xpath("//table[@id='billDetailsTable']/tbody[2]/tr[" + row + "]/td[" + col + "]/input"));
		highLightElement(driver, element);
		element.click();
	}

	// For EnterInputValuesForMultipleRows
	public void EnterInputValuesForMultipleRows(int row, int col, String value) {
		WebElement element = driver.findElement(
				By.xpath("//table[@id='billDetailsTable']/tbody[2]/tr[" + row + "]/td[" + col + "]/input"));
		element.clear();
		acceptAlert();
		element.sendKeys(value, Keys.TAB);
	}

	// For EnterSelectValuesForMultipleRows
	public void EnterSelectValuesForMultipleRows(int row, int col, String value) {
		WebElement element = driver.findElement(
				By.xpath("//table[@id='billDetailsTable']/tbody[2]/tr[" + row + "]/td[" + col + "]/select"));
		selectvalue(value, element);
	}

	// For getInputValuesForMultipleRows
	public String getInputValuesForMultipleRows(int row, int col) {
		WebElement element = driver.findElement(
				By.xpath("//table[@id='billDetailsTable']/tbody[2]/tr[" + row + "]/td[" + col + "]/input"));
		return getvalue(element);
	}

	// For getSelectValuesForMultipleRows
	public String getSelectValuesForMultipleRows(int row, int col) {
		WebElement element = driver.findElement(
				By.xpath("//table[@id='billDetailsTable']/tbody[2]/tr[" + row + "]/td[" + col + "]/select"));
		return getselectDrpdwnValue(element);
	}

	public void scrollleft() {
		WebElement slider = driver.findElement(By.xpath("//div[@id='billDetailDiv']"));
		sliderleft(slider);
	}

	public void scrollright() {
		WebElement slider = driver.findElement(By.xpath("//div[@id='billDetailDiv']"));
		sliderleft(slider);
	}

}
