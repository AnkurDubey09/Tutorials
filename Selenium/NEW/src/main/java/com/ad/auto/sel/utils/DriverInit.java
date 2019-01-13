package com.ad.auto.sel.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverInit {
	
	private static DriverInit instanceDriver = null;
	private static WebDriver driver = null;
	private static WebDriverWait wait;
	
	private DriverInit(){
		
	}
	
	public WebDriver openBrowser(String bType){
		
		if(bType.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver","D:\\jars\\ad\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(bType.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver","D:\\jars\\ad\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if(bType.equals("IE")){
			System.setProperty("webdriver.ie.driver","D:\\jars\\ad\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		return driver;
	}
	
	public static DriverInit getInstance(){
		
		if(instanceDriver == null)
			instanceDriver = new DriverInit();
		return instanceDriver;
		
	}
	
	public static WebDriver getDriverInstance(){
		
		return driver;
		
	}
	
	public static WebDriverWait getExplicitWait(WebDriver driver){
		
		wait = new WebDriverWait(driver,30);
		return wait;
		
	}

}
