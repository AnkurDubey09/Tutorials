package pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import commonutils.BrowserOperationsClass;;

public class LoginPageClass extends BrowserOperationsClass {
	
	public static WebElement loginUserName = driver.findElement(By.id("j_username"));
	public static WebElement loginUserPassword = driver.findElement(By.id("j_password"));
	public static WebElement submitButton = driver.findElement(By.cssSelector("input[value='Submit']"));
	
	
	public static void setLoginUserName(String uname){
		loginUserName.click();
		loginUserName.clear();
		loginUserName.sendKeys(uname);
	}
	
	public static void setLoginUserPassword(String upwd){
		loginUserPassword.click();
		loginUserPassword.clear();
		loginUserPassword.sendKeys(upwd);
	}
	
	public static void clickSubmitButton(){
		submitButton.click();
	}

}
