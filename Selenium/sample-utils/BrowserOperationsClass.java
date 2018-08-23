package browseroperations;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

public class BrowserOperationsClass {
	public static WebDriver driverObj = null;
	
	
	public static WebDriver getBrowser(String bname){
		if(bname.equalsIgnoreCase("firefox")){
			driverObj = new FirefoxDriver();
		}
		else if (bname.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","D:\\jars\\chromedriver.exe");
			driverObj = new ChromeDriver();
		}
		else if (bname.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver","D:\\jars\\IEDriverServer.exe");
			driverObj = new InternetExplorerDriver();
		}
		return driverObj;
	}
	
	public static void maximizeBrowser(){
		driverObj.manage().window().maximize();
	}
	
	public static void setImplicitTimeOut(){
		driverObj.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	}
	
	public static void setExplicitWaitOnVisibility(long time, WebElement element){
		WebDriverWait waitInstance = new WebDriverWait(driverObj, time);
		waitInstance.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void setExplicitWaitOnVisibility(long time, List<WebElement> elements){
		WebDriverWait waitInstance = new WebDriverWait(driverObj, time);
		waitInstance.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	public static void setExplicitWaitOnExistence(long time, WebElement element){
		WebDriverWait waitInstance = new WebDriverWait(driverObj, time);
		waitInstance.until(ExpectedConditions.presenceOfElementLocated((By) element));
	}
	
	public static void setExplicitWaitOnExistence(long time, By locator){
		WebDriverWait waitInstance = new WebDriverWait(driverObj, time);
		waitInstance.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	public static void setFluentWaitOnVisibility(long timeInterval, long pollingNumber, WebElement element){
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driverObj).withTimeout(timeInterval, TimeUnit.SECONDS)
				.pollingEvery(pollingNumber, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void closeDriver(){
		driverObj.close();
	}
	
	public static void quitDriver(){
		closeDriver();
		driverObj.quit();
	}
	
	public static void waitForElementToBeClickable(long time, WebElement element){
		WebDriverWait waitInstance = new WebDriverWait(driverObj, time);
		waitInstance.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitForElementToBeVisible(long time, WebElement element){
		WebDriverWait waitInstance = new WebDriverWait(driverObj, time);
		waitInstance.until(ExpectedConditions.visibilityOf(element));
	}
	
	

}
