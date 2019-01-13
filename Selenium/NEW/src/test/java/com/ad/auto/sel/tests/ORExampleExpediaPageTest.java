package com.ad.auto.sel.tests;


import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.ad.auto.sel.po.ExpediaHomePage;
import com.ad.auto.sel.utils.EventUtils;


public class ORExampleExpediaPageTest extends EventUtils {
	
	

	@Test(enabled=true)
	public void exampleTest(){
		
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		System.out.println("Title is "+driver.getTitle());
		ExpediaHomePage exHomePage = new ExpediaHomePage(driver);
		//inputInToElement("origin_XPATH", "India");
		//inputInToElement("desti_XPATH", "Germany");
		
		inputInToElement(exHomePage.originInputBox, "Australlia");
		inputInToElement(exHomePage.destinationInputBox, "India");
				
	}
	
	
	
}
