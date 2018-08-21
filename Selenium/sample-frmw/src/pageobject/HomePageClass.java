package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import commonutils.BrowserOperationsClass;

public class HomePageClass extends BrowserOperationsClass {
	
	public static List<WebElement> allTopTabs = driver.findElements(By.xpath("//div[@class=\"nowrapTabStrip dijitTabContainerTop-tabs\"]//div[contains(@widgetid,'mainTabContainer_tablist_')]"));
	public static List<WebElement> allInnerTabsInMapConfig = driver.findElements(By.xpath("//div[contains(@id,'mapconfiginnertabs_tablist_connectmapconfig')]"));
	public static List<WebElement> allInnterTabsInPermission = driver.findElements(By.xpath("//div[contains(@id,'permissionsInnerTabs_tablist_permissionsInnerTab')]"));
	public static WebElement mapConfigTab = allTopTabs.get(1);
	public static WebElement permissionsTab = allTopTabs.get(5);
	
	
}
