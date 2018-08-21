package commonutils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserOperationsClass {
	
	public static WebDriver driver = null;
	
	public static WebDriver getBrowser(String browserName){
		
		if(browserName.compareToIgnoreCase("Chrome") == 1){
			driver = new ChromeDriver();
		}
		
       if(browserName.compareToIgnoreCase("InternetExplorer") == 1){
    	   driver = new InternetExplorerDriver();
		}
       
       else
    	   driver = new FirefoxDriver();
       
       return driver;
	}
	
	public static void openURL(String url){
		driver.get(url);
	}
	
	public static void maximize(){
		driver.manage().window().maximize();
	}
	
	public static String getTitle(){
		return driver.getTitle();
	}
	
	public static void implicitWaitApply(){
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	public static WebDriverWait explicitWaitApply(){
		WebDriverWait wait = new WebDriverWait(driver,50);
		
		return wait;
	}

}
