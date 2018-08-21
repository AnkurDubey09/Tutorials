package analystadminconsole;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminPermissionPage {
	
WebDriver driver;
	
	public AdminPermissionPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="//div[contains(@id,'permissionsInnerTabs_tablist_permissionsInnerTab')]")
	public List<WebElement> allInnterTabsInPermission;
	
	
	
	
	
}
