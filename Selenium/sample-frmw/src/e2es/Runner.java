package e2es;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import pageobject.LoginPageClass;
import commonutils.BrowserOperationsClass;

public class Runner {
	@Test
	public void Executor(){
		WebDriver driver = null;
		//driver.get("");
		driver = BrowserOperationsClass.getBrowser("");
		BrowserOperationsClass.maximize();
		BrowserOperationsClass.openURL("http://stratusdevpr1:8020/adminconsole/analyst");
		LoginPageClass.setLoginUserName("admin");
		LoginPageClass.setLoginUserPassword("admin");
		LoginPageClass.clickSubmitButton();
	}

}
