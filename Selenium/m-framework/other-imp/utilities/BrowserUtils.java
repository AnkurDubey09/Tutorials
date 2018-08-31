package com.ad.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.ad.base.*;

public class BrowserUtils extends TestBase {

	//public static WebDriver driver = null;
		
	public static WebDriver getBrowser(String bType){
		
		if(bType.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(bType.equals("firefox")){
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new FirefoxDriver();
		}else if(bType.equals("ie")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new InternetExplorerDriver();
		}
		
		return driver;
		
	}
	
	public static WebDriver getDriver(){
		
		return driver;
	}
	
	public static void loadUrl(String url){
		
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(config.getProperty("pageloadtimeout")), TimeUnit.SECONDS);
		driver.get(url);
	}
	
	public static void maximizeBrowser(){
		
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("Timeout")), TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	public static void closeBrowser(){
		
		if(driver != null){
			driver.close();
			driver.quit();
		}
		
	}
}
