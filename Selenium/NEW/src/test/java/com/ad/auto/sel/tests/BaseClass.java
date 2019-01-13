package com.ad.auto.sel.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.ad.auto.sel.utils.DriverInit;
import com.ad.auto.sel.utils.ExtentManager;
import com.ad.auto.sel.utils.LoggerUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {
	
	protected static WebDriver driver = null;
	protected static WebDriverWait wait = null;
	protected static Logger logger;
	protected static ExtentReports exRepo;
	protected static ExtentTest test;
	protected static DriverInit driverInitInstance = DriverInit.getInstance();
	
	protected static Properties config = new Properties();
	protected static FileInputStream fis;
	protected String browserType;
	protected int timeout;
	protected int pageLoadTimeout;
	protected String url;
	protected static String dataFileName;
	protected static String sheetName;
	protected static String dataColumnName;
	
	
	@BeforeSuite
	public void suiteSetup(){
		
		System.out.println("In Before suite");
		//exRepo = ExtentManager.getInstance();
		logger = LoggerUtils.getInfoLogger();
		
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\configs\\properties\\Config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			config.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		browserType = config.getProperty("browser");
		timeout = Integer.parseInt(config.getProperty("timeout"));
		pageLoadTimeout = Integer.parseInt(config.getProperty("pageloadtimeout"));
		url = config.getProperty("testingurl");
				
		exRepo = ExtentManager.getInstance();
	}
	
	@Parameters({"browser"})
	@BeforeMethod
	public void methodSetup(ITestResult Result,String bType){
		
		System.out.println("In Before method "+Result.getName());
		
		//exRepo = ExtentManager.getInstance();
				
		driver = driverInitInstance.openBrowser(browserType);
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		wait = DriverInit.getExplicitWait(driver);
		
	}
	
	@AfterMethod
	public void methodCleanup(){
		
		System.out.println("In After method");
		driver.close();
		
		
	}
	
	@AfterSuite
	public void suiteCleanup(){
		
		System.out.println("In After suite");
		exRepo = null;
		logger = null;
		//driver.quit();
				
	}
	
	@BeforeTest
	public void beforeTestSetup(){
		
		System.out.println("In Before tests");
		
	}
	
	@AfterTest
	public void afterTestCleanup(){
		
		System.out.println("In After tests");
		
	}
	
	@BeforeClass
	public void beforeClassSetup(){
		
		System.out.println("In Before class ");
		
		dataFileName = config.getProperty("filename");
		sheetName = config.getProperty("sheetname");
		dataColumnName = config.getProperty("datacolname");
		
	}
	
	@AfterClass
	public void afterClassCleanup(){
		
		System.out.println("In After class");
		
	}

}
