package com.ad.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.ad.utilities.Driver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.ad.utilities.ExtentManager;
import com.ad.utilities.LoggerUtils;

import config.Configurations;

public class TestBase{
	
	public static WebDriver driver = null;
	public static WebDriverWait wait=null;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream configFis;
	public static FileInputStream orFis;
	public static Logger logger ;//= LogManager.getLogger(TestBase.class.getName());
	public ExtentReports exRepo = ExtentManager.getInstance();
	public static ExtentTest test;
	
	@Parameters({ "browser" })
	@BeforeSuite
	public void setup(String bType) throws MalformedURLException{
		
		Driver.initializeDriver(bType);
		
		driver = Driver.driverInstance;
		
		driver.navigate().to(Configurations.Url.url);
		
		wait = new WebDriverWait(driver, Configurations.Timeout.explicitlyTimeout); 
		
		logger = LoggerUtils.getInfoLogger();
				
		try {
			configFis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
			orFis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		try {
			config.load(configFis);
			OR.load(orFis);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	@AfterSuite
	public void cleanup(){
		
		
		
	}
	
	@BeforeTest
	public void setupBeforeTest(){
		
		
		
	}
	
	@AfterTest
	public void cleanupAfterTest(){
		
		
		
	}
	
	@BeforeClass
	public void setupBeforeClass(){
		
		
		
	}
	
	@AfterClass
	public void cleanupAfterClass(){
		
		
		
	}
	
	
	
}