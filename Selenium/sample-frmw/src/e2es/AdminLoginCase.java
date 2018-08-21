package e2es;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonutils.BrowserOperationsClass;
import pageobject.*;
import utilities.ExcelOperationsClass;

public class AdminLoginCase {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*
		WebDriver driver  = BrowserOperationsClass.getBrowser("");
		BrowserOperationsClass.maximize();
		BrowserOperationsClass.openURL("http://stratusdevpr1:8020/adminconsole/analyst");
		LoginPageClass.setLoginUserName("admin");
		LoginPageClass.setLoginUserPassword("admin");
		LoginPageClass.clickSubmitButton();
		
		for(int i=0;i<HomePageClass.allTopTabs.size();i++){
			System.out.println(HomePageClass.allTopTabs.get(i).getText());
			HomePageClass.allTopTabs.get(i).click();
		}
		WebDriverWait wait = BrowserOperationsClass.explicitWaitApply();
		HomePageClass.mapConfigTab.click();
		System.out.println("Inner tabs in map config tab are "+HomePageClass.allInnerTabsInMapConfig.size());
		
		HomePageClass.permissionsTab.click();
		//wait.until(ExpectedConditions.visibilityOfAllElements(HomePageClass.allInnterTabsInPermission));
		//HomePageClass.allInnterTabsInPermission.get(1).click();
		System.out.println("Innter tabs in permissions tab are "+HomePageClass.allInnterTabsInPermission.size());*/
		
		//ExcelOperationsClass.readFile();
		
		//ExcelOperationsClass.getValue("Name");
		//ExcelOperationsClass.getValue("Last Name");
		System.out.println(ExcelOperationsClass.getValue("Last Name"));
		System.out.println(ExcelOperationsClass.getValue("Name"));
		System.out.println(ExcelOperationsClass.getValue("First Name"));

	}
	
	

}
