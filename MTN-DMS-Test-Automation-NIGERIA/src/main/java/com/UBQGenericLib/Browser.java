package com.UBQGenericLib;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.UBQPageObjectLib.HomePage;
import com.UBQPageObjectLib.LoginPage;


/**
 * @author Basanagouda
 *
 */
public class Browser implements Constants {
	public static WebDriver driver;
	LoginPage login;
	public static SoftAssert ast ;
	//ExtentTest test;
	
	//public static ExtentReports reports = new ExtentReports(".\\Resources\\Logfile.html");
	public static Logger logger = Logger.getLogger("LoggerCreation");

	@BeforeSuite
	public void Loadlogfile() throws Exception {
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/Resources/log4j.properties");
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
	}
		@BeforeTest
		public void getBrowser() throws Exception {
		if (browser.equalsIgnoreCase("Firefox")) {
			try {
				System.setProperty("webdriver.gecko.driver", "Resources/version_21/geckodriver.exe");
				logger.info("Connecting to Firefox browser");
				logger.info("Please close the Excel File if it is Opened");
				driver = new FirefoxDriver();
				logger.info("Opened Firefox Browser");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.error("Unable to Open Firefox Browser " + e.getMessage());
				ast.assertTrue(false, "Unable to Open Firefox Browser " + e.getMessage());
			}

		} else if (browser.equalsIgnoreCase("Chrome")) {
			try {
				
				System.setProperty("webdriver.chrome.driver", "Resources/version_21/chromedriver.exe");
				logger.info("Connecting to Chrome browser");
				driver = new ChromeDriver();
				logger.info("Opened  Chrome browser");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.error("Unable to Open Chrome Browser " + e.getMessage());
				ast.assertTrue(false, "Unable to Open Chrome Browser " + e.getMessage());
			}
		} else if (browser.equalsIgnoreCase("Ie")) {
			try {
				System.setProperty("webdriver.ie.driver", "Resources/ie/IEDriverServer.exe");
				logger.info("Connecting to InternetExplorer browser");
				driver = new InternetExplorerDriver();
				logger.info("Opened InternetExplorer browser");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.error("Unable to Open InternetExplorer Browser " + e.getMessage());

				ast.assertTrue(false, "Unable to Open InternetExplorer Browser " + e.getMessage());
			}
		}else {
			System.out.println(" Browser Details not found");
			logger.error("Failed to open browser,Please check Details");

			ast.assertTrue(false,"Failed to open browser,Please check Details");
		}
		
		try {

			logger.info("Maximizing Browser");
			driver.manage().window().maximize();
			logger.info("Completed Maximizing Browser");
			logger.info("Connecting to Url");
			driver.navigate().to(Constants.url);
			logger.info("Connected to Url " + Constants.url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Unable to Connect to URl " + e.getMessage());
			ast.assertTrue(false, "Unable to Connect to URl " + e.getMessage());
		}
		login = PageFactory.initElements(driver, LoginPage.class);

		login.login();
	}

	@AfterTest
	public void Logout() {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		try {
			logger.info("Trying to Logout");
			//home.ClickOnNavBox();
			Thread.sleep(1000);
			home.ClickOnSignOut();
			logger.info("Logged out from application Successfully");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Unable to Logout " + e.getMessage());
		}
		try {
			logger.info("Trying to close Browser");
			driver.quit();
			logger.info("Browser Closed Successfully");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Unable to close the browser " + e.getMessage());
		}
		
		
		
	}

}
