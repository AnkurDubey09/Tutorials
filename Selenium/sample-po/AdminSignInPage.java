package analystadminconsole;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminSignInPage {
	
	WebDriver driver;
	
	public AdminSignInPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="j_username")
	public WebElement UserNameInput;
	
	@FindBy(id="j_password")
	public WebElement UserPasswordInput;
	
	@FindBy(css="input[value='Submit']")
	public WebElement SubmitButton;
	
	public void enterUserName(String unm){
		
		UserNameInput.clear();
		UserNameInput.sendKeys(unm);
		
	}
	
	public void enterPassword(String pwd){
		
		UserPasswordInput.clear();
		UserPasswordInput.sendKeys(pwd);
		
	}
	
	public void login(String unm, String pwd){
		
		enterUserName(unm);
		enterPassword(pwd);
		SubmitButton.click();
		
	}

}
