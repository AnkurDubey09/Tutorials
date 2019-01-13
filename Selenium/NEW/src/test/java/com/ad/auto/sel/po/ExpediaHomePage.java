package com.ad.auto.sel.po;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ExpediaHomePage {
	
	WebDriver driver;
	
	public ExpediaHomePage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//input[@id='package-origin-hp-package']")
	public WebElement originInputBox;
	
	@FindBy(xpath = "//input[@id='package-destination-hp-package']")
	public WebElement destinationInputBox;
	
	@FindBy(xpath = "//ul[@id='typeaheadDataPlain']//li")
	protected List<WebElement> suggestedOriginValues;
	
	@FindBy(xpath = "//ul[@id='typeaheadDataPlain']//li")
	protected List<WebElement> suggestedDestinationValues;
	
	@FindBy(xpath = "//ul[@class='utility-nav nav-group cf']/li")
	public List<WebElement> navLinks;
	

}
