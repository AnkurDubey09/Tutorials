package testscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import analystadminconsole.AdminHomePage;
import analystadminconsole.AdminMapConfigPage;
import analystadminconsole.AdminMapConfigPermissionsPage;
import analystadminconsole.AdminPermissionPage;
import analystadminconsole.AdminSignInPage;
import browseroperations.BrowserOperationsClass;
import browseroperations.ExcelOperations;

public class Test2 {
	
	WebDriver dri;
	AdminSignInPage asp;
	AdminHomePage ahp;
	AdminMapConfigPage amcp;
	AdminPermissionPage app;
	AdminMapConfigPermissionsPage amcpp;

	
	@BeforeClass
	public void setup(){
		
		dri = BrowserOperationsClass.getBrowser("firefox");
		BrowserOperationsClass.maximizeBrowser();
		BrowserOperationsClass.setImplicitTimeOut();
		dri.get("http://stratusdevpr2:8020/adminconsole/analyst"); //http://192.168.254.144:8080/dcg/
		
	}
	
	@Test
	public void loginAdminConsole(){
		asp = new AdminSignInPage(dri);
		asp.login("admin", "admin");
		ahp = new AdminHomePage(dri);
		
	}
	
	@Test(dependsOnMethods={"loginAdminConsole"})
	public void navigateToMapConfigTab() throws InterruptedException{
		
		BrowserOperationsClass.waitForElementToBeVisible(20, ahp.mapConfigTab);
		ahp.mapConfigTab.click();
		
	}
	
	@Test(dependsOnMethods={"navigateToMapConfigTab"},dataProvider="createConfig")
	public void createNewMapConfig(String configName) throws InterruptedException{
		
		amcp = new AdminMapConfigPage(dri);
		amcp.CreateNewConfig.click();
		amcp.enterConfigName(configName);
		amcp.CreateButton.click();
		amcp.SaveConfigButton.click();
		amcp.CloseButton.click();
		BrowserOperationsClass.waitForElementToBeVisible(30, amcp.ConfigSuccessMessage);
		Assert.assertEquals(amcp.ConfigSuccessMessage.getText(), "Configuration changes saved successfully.");
		
	}
	
	@Test(dependsOnMethods={"createNewMapConfig"},dataProvider="addBusinessMaps")//,enabled=false
	public void assignBusinessMaps(String configName, String bmap) throws InterruptedException//, String bmap2, String bmap3, String bmap4, String bmap5, String bmap6, String bmap7
	{
		
		String[] namedTables = bmap.split("\n");
		amcp.selectMapConfig(configName);
		amcp = new AdminMapConfigPage(dri);
		BrowserOperationsClass.waitForElementToBeClickable(30, amcp.AddMapsButton);
		amcp.AddMapsButton.click();
		BrowserOperationsClass.waitForElementToBeVisible(30, amcp.AddMaps);
		for(int i=0; i<namedTables.length; i++){System.out.println(namedTables[i]);
			
			dri.findElement(By.cssSelector("[id=\"fullmapsdialog\"] a[title=\""+namedTables[i]+"\"]")).click();
						
		}
		
		amcp.AddMaps.click();
		amcp.SaveConfigButton.click();
		BrowserOperationsClass.waitForElementToBeClickable(30, amcp.SaveConfigButton);
		
	}
	
	
	@Test(dependsOnMethods={"assignBusinessMaps"},dataProvider="addPermission")
	public void assignPermissionToConfig(String cnf, String permmisions) throws InterruptedException{
		
		String[] Permissions = permmisions.split("\n");
		
		ahp.permissionsTab.click();
		amcpp = new AdminMapConfigPermissionsPage(dri);
		Select Dropdown = new Select(amcpp.MapConfigNamesDropdown);
		Dropdown.selectByVisibleText(cnf);Thread.sleep(5000);
		amcpp.OtherRoleRadio.click();
		Select Dropdown1 = new Select(amcpp.AvailableRolesDropdown);
		
		for(int i=0; i<Permissions.length; i++){
			
			Dropdown1.selectByVisibleText(Permissions[i]);
						
		}
		
		amcpp.L2RButton.click();
		amcpp.SaveButton.click();
		BrowserOperationsClass.waitForElementToBeClickable(30, amcpp.SaveButton);
		
	}
	
	
	@DataProvider
	public Object[][] addBusinessMaps() {
		Object[][] arrayObject = ExcelOperations.getExcelData("./Spectrum.xlsx", "AddBusinessMaps");
		return arrayObject;
	}
	
	@DataProvider
	public Object[][] createConfig() {
		Object[][] arrayObject = ExcelOperations.getExcelData("./Spectrum.xlsx", "CreateConfig");
		return arrayObject;
	}
	
	@DataProvider
	public Object[][] addPermission() {
		Object[][] arrayObject = ExcelOperations.getExcelData("./Spectrum.xlsx", "AddPermissions");
		return arrayObject;
	}
	
	
}
