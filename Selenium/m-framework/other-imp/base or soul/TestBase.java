package com.ad.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.ad.utilities.LoggerUtils;
import com.ad.utilities.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.ad.utilities.*;


public class TestBase extends TestSetup {
	
	/*
	 * WebDriver
	 * Properties
	 * Logs
	 * Listeners
	 * ExtentReports
	 * DB
	 * Excel
	 * Mail
	 * 
	 * */
	public static WebDriver driver=null;
	public static WebDriverWait wait=null;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger logger ;//= LogManager.getLogger(TestBase.class.getName());
	public ExtentReports exRepo = ExtentManager.getInstance();
	public static ExtentTest test;
	
	@BeforeSuite
	public void setUp(){
		//String fileName = System.getProperty("user.dir")+"\\src/test/java/log4j2.xml";
		//Configurator.initialize(null, fileName);
		 logger = LoggerUtils.getInfoLogger();
		
		if(driver == null){
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			
			try {
				config.load(fis);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			driver = BrowserUtils.getBrowser(config.getProperty("browser"));
			BrowserUtils.loadUrl(config.getProperty("testurl"));
			BrowserUtils.maximizeBrowser();
			wait = new WebDriverWait(driver,Integer.parseInt(config.getProperty("explicitlywaittime")));
			
			/*driver.get(config.getProperty("testurl"));
			driver.manage().window().maximize();
			logger.debug("browser maximized");
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("Timeout")), TimeUnit.SECONDS);*/
		}
		
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			OR.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@AfterSuite
	public void tearDown(){
		
	}

}
