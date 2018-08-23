package testscenarios;

import java.io.IOException;
import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import spectrumspatial.SpectrumHomePage;
import spectrumspatial.SpectrumPlatformClientToolPage;
import managementconsole.AccessControlPage;
import managementconsole.AddRolePage;
import managementconsole.AddUserPage;
import managementconsole.EditAccessControlPage;
import managementconsole.ManagementConsoleHomePage;
import managementconsole.ManagementConsoleSecurityPage;
import managementconsole.ManagementConsoleSignInPage;
import browseroperations.*;

public class Test1 {
	
	SpectrumHomePage shome;
	SpectrumPlatformClientToolPage spct;
	ManagementConsoleSignInPage mc;
	ManagementConsoleHomePage mchp;
	ManagementConsoleSecurityPage mcsp;
	AddRolePage ar;
	AddUserPage au;
	AccessControlPage ac;
	EditAccessControlPage eac;
	WebDriver dri;
	ExcelOperations eo;
	
	@BeforeClass
	public void setup(){
		
		dri = BrowserOperationsClass.getBrowser("firefox");
		BrowserOperationsClass.maximizeBrowser();
		BrowserOperationsClass.setImplicitTimeOut();
		dri.get("http://152.144.219.103:8080/dcg/"); //http://192.168.254.144:8080/dcg/
		
	}
	
	@Test(priority=0)//(dataProvider="addRoleUser")  String Role_Name, String User_Name, String Password, String Confirm_Password
	public void openPlatformClient() throws IOException{
		
		//shome = PageFactory.initElements(dri, SpectrumHomePage.class);
		shome = new SpectrumHomePage(dri);
		shome.PlatformClientToolTab.click();
		spct = new SpectrumPlatformClientToolPage(dri);
		spct.PlatformCTWebLink.click();
		spct.OpenManagementConsoleLink.click();
		
		//String winHandleBefore = dri.getWindowHandle();
		for(String winHandle : dri.getWindowHandles()){
			dri.switchTo().window(winHandle);
		}
		
	}

	@Test(dependsOnMethods={"openPlatformClient"})
	public void loginMGMTConsole(){
		
		mc = new ManagementConsoleSignInPage(dri);
		mc = PageFactory.initElements(dri,ManagementConsoleSignInPage.class);
		mc.UserNameInputField.clear();
		mc.UserNameInputField.sendKeys("admin");
		mc.PasswordInputField.clear();
		mc.PasswordInputField.sendKeys("admin");
		mc.SubmitButton.click();
		
	}
	
	@Test(dependsOnMethods="loginMGMTConsole")
	public void navigateToSecurityConsole(){
		
		mchp = new ManagementConsoleHomePage(dri);
		//	mchp = mc.signInToManagementConsole("admin","admin");
			
			mchp.SystemLink.click();
			mchp.SecurityLink.click();
			
		
	}
	
	@Test(dependsOnMethods="navigateToSecurityConsole",dataProvider="createRole")
	public void addRole(String role) throws IOException{
		
		
			mcsp = new ManagementConsoleSecurityPage(dri);
			mcsp.RolesTab.click();	
			mcsp.AddRoleButton.click();
			ar = new AddRolePage(dri);
			ar.setRole(role);
			ar.SaveButton.click();
		
	}
	
	@Test(dependsOnMethods="navigateToSecurityConsole",dataProvider="createUser")
	public void addUser(String unm, String pwd, String cpwd, String roles) throws IOException{
		
		String[] Roles = roles.split("\n");
		mcsp.UsersTab.click();
		mcsp.AddUserButton.click();
		
		au = new AddUserPage(dri);
		au.setName(unm);//ExcelOperations.getStringValueFromExcel("./Spectrum.xlsx", "AddUser", "User_Name")
		au.setPassword(pwd);//ExcelOperations.getStringValueFromExcel("./Spectrum.xlsx", "AddUser", "Password")
		au.setConfirmPassword(cpwd);//ExcelOperations.getStringValueFromExcel("./Spectrum.xlsx", "AddUser", "Confirm_Password")
		for(int i=0; i<Roles.length; i++){
			
			au.selectRole(Roles[i]);
			
		}
		
		au.SaveButton.click();
		
	}
	@DataProvider
	public Object[][] createRole() {
		Object[][] arrayObject = ExcelOperations.getExcelData("./Spectrum.xlsx", "AddRole");
		return arrayObject;
	}
	
	@DataProvider
	public Object[][] createUser() {
		Object[][] arrayObject = ExcelOperations.getExcelData("./Spectrum.xlsx", "AddUser");
		return arrayObject;
	}
	
	@Test(dependsOnMethods="navigateToSecurityConsole")
	public void editAccessControlPermissions() throws InterruptedException{
		
		mcsp.AccessControlTab.click();
		ac = new AccessControlPage(dri);
		ac.selectGivenRoleCheckBox("AnalystGuestRole");
		ac.EditAccessControl.click();
		eac = new EditAccessControlPage(dri);
		eac.selectViewAccessControlFor("/SSA8/NamedMaps/DataTypesMap");
		eac.selectModifyAccessControlFor("/SSA8/NamedMaps/CamdenNLPG");
		eac.selectDeleteAccessControlFor("/SSA8/NamedTables/DataTypes");
		eac.SaveButton.click();
		
	}
	
	 
	
	
	
	

}
