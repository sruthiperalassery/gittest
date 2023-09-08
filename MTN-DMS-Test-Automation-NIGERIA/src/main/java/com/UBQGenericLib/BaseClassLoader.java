package com.UBQGenericLib;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.UBQPageObjectLib.DealerMaster;
import com.UBQPageObjectLib.AdvanceSearchOptions;
import com.UBQPageObjectLib.ArticleMaster;
import com.UBQPageObjectLib.BankAccounts;
import com.UBQPageObjectLib.CollectionBulk;
import com.UBQPageObjectLib.CollectionBrowser;
import com.UBQPageObjectLib.CollectionCustomerwise;
import com.UBQPageObjectLib.HoldOrReleaseStock;
import com.UBQPageObjectLib.HomePage;
import com.UBQPageObjectLib.LoginPage;
import com.UBQPageObjectLib.ManualCrNoteEntry;
import com.UBQPageObjectLib.ManualCrNoteUpdate;
import com.UBQPageObjectLib.OpeningStock;
import com.UBQPageObjectLib.OrderBrowser;
import com.UBQPageObjectLib.OrderEntry;
import com.UBQPageObjectLib.PaymentToSupplier;
import com.UBQPageObjectLib.PaymentTracking;
import com.UBQPageObjectLib.PriceMaster;
import com.UBQPageObjectLib.ProductMaster;
import com.UBQPageObjectLib.PurchaseInvoiceBrowser;
import com.UBQPageObjectLib.PurchaseOrder;
import com.UBQPageObjectLib.PurchaseOrderBrowser;
import com.UBQPageObjectLib.RetailerMaster;
import com.UBQPageObjectLib.BeatMaster;
import com.UBQPageObjectLib.Bugzilla;
import com.UBQPageObjectLib.SalesInvice;
import com.UBQPageObjectLib.SalesInviceBrowser;
import com.UBQPageObjectLib.SalesReturnEntry;
import com.UBQPageObjectLib.StaffEntry;
import com.UBQPageObjectLib.StaffMaster;
import com.UBQPageObjectLib.StaffVehicleMapping;
import com.UBQPageObjectLib.StockAdjustment;
import com.UBQPageObjectLib.StockBrowser;
import com.UBQPageObjectLib.StockEntry;
import com.UBQPageObjectLib.StockMovement;
import com.UBQPageObjectLib.StockTransfer;
import com.UBQPageObjectLib.StockTransferBrowser;
import com.UBQPageObjectLib.StockTypeTransfer;
import com.UBQPageObjectLib.StoreMaster;
import com.UBQPageObjectLib.SupplierMaster;
import com.UBQPageObjectLib.SyncWithServer;
import com.UBQPageObjectLib.UserPage;
import com.UBQPageObjectLib.UserRolesPage;
import com.UBQPageObjectLib.VehicleMaster;
import com.UBQPageObjectLib.ePurchaseInvoice;

/**
 * @author Basanagouda
 *
 */
public class BaseClassLoader extends WebDriverCommonLib {

	public LoginPage lgn;
	public HomePage home;
	public WebDriverCommonLib wcl;
	public StoreMaster store;
	public String expectedvalue;
	public String actualvalue;
	public UserPage user;
	public StaffMaster staff;
	public UserRolesPage roles;
	public DealerMaster cust;
	public SyncWithServer sws;
	public BeatMaster beat;
	public StaffVehicleMapping svm;
	public SupplierMaster slr;
	public SalesInvice bentry;
	public OrderEntry oentry;
	public OrderBrowser obrowser;
	public CollectionBulk coll;
	public BankAccounts bnk;
	public StockTypeTransfer stt;
	public StockMovement stm;
	public PurchaseOrder plo;
	public PurchaseOrderBrowser pob;
	public HoldOrReleaseStock hrs;
	public StockAdjustment sadj;
	public PaymentToSupplier pts;
	public ManualCrNoteEntry mentry;
	public ManualCrNoteUpdate mupdate;
	public PaymentTracking pt;
	public VehicleMaster vehicleM;
	public StockBrowser stb;
	public ProductMaster prm;
	public PriceMaster pm;
	public CollectionCustomerwise collc;
	public CollectionBrowser collB;
	public StockTransfer stktra;
	public StockTransferBrowser stkb;
	public OpeningStock ostk;
	public SalesInviceBrowser sib;
	public ePurchaseInvoice ep;
	public PurchaseInvoiceBrowser pib;
	public CollectionBulk cbk; 
	public AdvanceSearchOptions adv;
	public ArticleMaster art;
	public StockEntry ste;
	public StaffEntry se;
	public RetailerMaster rem;
	public Bugzilla Bug;
	public SalesReturnEntry sre;
	
	
	
	
	@BeforeClass
	public void LoadMethods() throws Exception {
		try {

			logger.info("Started Loading Methods");
			home = PageFactory.initElements(driver, HomePage.class);
			wcl = PageFactory.initElements(driver, WebDriverCommonLib.class);
			store = PageFactory.initElements(driver, StoreMaster.class);
			user = PageFactory.initElements(driver, UserPage.class);
			staff = PageFactory.initElements(driver, StaffMaster.class);
			roles = PageFactory.initElements(driver, UserRolesPage.class);
			cust = PageFactory.initElements(driver, DealerMaster.class);
			sws = PageFactory.initElements(driver, SyncWithServer.class);
			beat = PageFactory.initElements(driver, BeatMaster.class);
			svm = PageFactory.initElements(driver, StaffVehicleMapping.class);
			slr = PageFactory.initElements(driver, SupplierMaster.class);
			bentry = PageFactory.initElements(driver, SalesInvice.class);
			oentry = PageFactory.initElements(driver, OrderEntry.class);
			coll = PageFactory.initElements(driver, CollectionBulk.class);
			bnk = PageFactory.initElements(driver, BankAccounts.class);
			stt = PageFactory.initElements(driver, StockTypeTransfer.class);
			stm = PageFactory.initElements(driver, StockMovement.class);
			prm=  PageFactory.initElements(driver,ProductMaster.class);
			plo = PageFactory.initElements(driver, PurchaseOrder.class);
			pob = PageFactory.initElements(driver, PurchaseOrderBrowser.class);
			ep = PageFactory.initElements(driver, ePurchaseInvoice.class);
			pib = PageFactory.initElements(driver, PurchaseInvoiceBrowser.class);
			hrs = PageFactory.initElements(driver, HoldOrReleaseStock.class);
			sadj = PageFactory.initElements(driver, StockAdjustment.class);
			pts = PageFactory.initElements(driver, PaymentToSupplier.class);
			mentry = PageFactory.initElements(driver, ManualCrNoteEntry.class);
			mupdate = PageFactory.initElements(driver, ManualCrNoteUpdate.class);
			pt = PageFactory.initElements(driver, PaymentTracking.class);
			vehicleM = PageFactory.initElements(driver, VehicleMaster.class);
			stb = PageFactory.initElements(driver, StockBrowser.class);
			collc = PageFactory.initElements(driver, CollectionCustomerwise.class);
			stktra = PageFactory.initElements(driver, StockTransfer.class);
			stkb = PageFactory.initElements(driver, StockTransferBrowser.class);
			ostk = PageFactory.initElements(driver, OpeningStock.class);
			obrowser = PageFactory.initElements(driver, OrderBrowser.class);
			sib = PageFactory.initElements(driver, SalesInviceBrowser.class);
			collB = PageFactory.initElements(driver, CollectionBrowser.class);
			cbk = PageFactory.initElements(driver, CollectionBulk.class);
			art = PageFactory.initElements(driver, ArticleMaster.class);
			adv = PageFactory.initElements(driver, AdvanceSearchOptions.class);
			ste = PageFactory.initElements(driver,StockEntry.class);
			se = PageFactory.initElements(driver,StaffEntry.class);
			rem = PageFactory.initElements(driver,RetailerMaster.class);
			pm = PageFactory.initElements(driver,PriceMaster.class);
			Bug = PageFactory.initElements(driver,Bugzilla.class);
			ast = new SoftAssert();
			logger.info("Completed Loading Methods");
			wcl.waitforpageload();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
