package com.ad.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import config.Configurations;

public class Driver {
	
	public static WebDriver driverInstance = null;
	
	public static void initializeDriver(){
		
		if(driverInstance == null){
			
			System.out.println("Initializing Driver");
			
			if(Configurations.Browser.browser.equals("chrome")){
				
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
				driverInstance = new ChromeDriver();
				
			}else if(Configurations.Browser.browser.equals("firefox")){
				
				//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver.exe");
				driverInstance = new FirefoxDriver();
				
			}else if(Configurations.Browser.browser.equals("ie")){
				
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\IEDriverServer.exe");
				driverInstance = new InternetExplorerDriver();
				
			}
			
			driverInstance.manage().timeouts().implicitlyWait(Configurations.Timeout.implicitlyTimeout, TimeUnit.SECONDS);
			driverInstance.manage().window().maximize();
			
		}
		
	}
	
	public static WebDriver getInstanceOfDriver(){
		
		return driverInstance;
		
	}
	
	public static void close(){
		
		System.out.println("Closing Browser");
		driverInstance.close();
		driverInstance = null;
		
	}
	
	public static void quit() {

		System.out.println("Quiting Browser");
		driverInstance.quit();
		driverInstance = null;

	}

}
