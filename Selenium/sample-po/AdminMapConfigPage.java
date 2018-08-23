package analystadminconsole;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminMapConfigPage {
	
WebDriver driver;
	
	public AdminMapConfigPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[contains(@id,'mapconfiginnertabs_tablist_connectmapconfig')]")
	public List<WebElement> allInnerTabsInMapConfig;
	
	//public WebElement MapConfigTab = allInnerTabsInMapConfig.get(0);
	
	@FindBy(id="savedconfigsvalue")
	public WebElement SelectMapConfigInputBox;
	
	@FindBy(id="addnewconfigbutton")
	public WebElement CreateNewConfig;
	
	@FindBy(id="newconfignameinput")
	public WebElement MapConfigInput;
	
	@FindBy(id="confirmnewconfig")
	public WebElement CreateButton;
	
	@FindBy(id="addmoremapsbutton")
	public WebElement AddMapsButton;
	
	@FindBy(id="fullmapsdialog")
	public WebElement AddMapDialogue;
	
	@FindBy(css="[id=\"fullmapslist\"] a")
	public List<WebElement> FullMapList;
	
	@FindBy(id="addmapssubmit")
	public WebElement AddMaps;
	
	@FindBy(id="mapconfigurationsave")
	public WebElement SaveConfigButton;
	
	@FindBy(css="[onclick=\"dijit.byId('newConfigCreatedDialog').hide();\"]")
	public WebElement CloseButton;
	
	@FindBy(css="[id=\"mapconfigmessages\"]")
	public WebElement ConfigSuccessMessage;
	
	public void enterConfigName(String cnf){
		
		MapConfigInput.clear();
		MapConfigInput.sendKeys(cnf);
		
	}
	
	public void selectMapConfig(String mcname){
		
		SelectMapConfigInputBox.clear();
		SelectMapConfigInputBox.sendKeys(mcname);
		SelectMapConfigInputBox.sendKeys(Keys.ENTER);
		
	}
	
	

}
