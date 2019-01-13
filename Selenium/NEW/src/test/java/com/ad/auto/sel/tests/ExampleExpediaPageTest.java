package com.ad.auto.sel.tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.ad.auto.sel.po.ExpediaHomePage;
import com.ad.auto.sel.utils.ExcelReaderUtil;


public class ExampleExpediaPageTest extends BaseClass {
	
	

	@Test(enabled=false)
	public void exampleTest(){
		//logger.info("Example scenario - logged");
		//test = exRepo.startTest("Example");
		System.out.println("Example Running !!! "+System.getProperty("user.dir"));
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		System.out.println("Title is "+driver.getTitle());
		//String d[] = ExcelReaderUtil.getColumnData(dataFileName, sheetName, dataColumnName);
		//System.out.println(d[0]+" "+d[1]);
		//test.log(LogStatus.PASS,"Example ... ");
		//exRepo.endTest(test);
		//exRepo.flush();
		
	}
	
	@Test(enabled=false)
	public void testTitle(){
		//logger.info("Get title scenario - logged");
		//test = exRepo.startTest("Get Title");
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		System.out.println("Title is "+driver.getTitle());
		//test.log(LogStatus.PASS,"Get title ... ");
		//exRepo.endTest(test);
		//exRepo.flush();
	}
	
	@Test(enabled=false, priority=1)
	public void testExpediaHome() throws InterruptedException{
		
		driver.get(url);
		ExpediaHomePage exHomePage = new ExpediaHomePage(driver);
		exHomePage.originInputBox.sendKeys("India");
		exHomePage.destinationInputBox.sendKeys("California");
		
		/*Iterator<WebElement> links = exHomePage.navLinks.iterator();
		
		while(links.hasNext()){
			
			WebElement elm = links.next();
			try{
				
				if(elm.getText().contains("ThingsToDo"))
					break;
				elm.click();
				
				
			}catch(StaleElementReferenceException  e){
				driver.findElement(By.xpath("//ul[@class='utility-nav nav-group cf']/li[5]")).click();
			}
			
			
		}*/
		
		// Below code is a solution to StaleElementReference problem.
		for(int i=2; i<=exHomePage.navLinks.size(); i++){
			
			
			if(driver.findElement(By.xpath("//ul[@class='utility-nav nav-group cf']/li["+i+"]")).getText().contains("Things to Do"))
				break;
				
			driver.findElement(By.xpath("//ul[@class='utility-nav nav-group cf']/li["+i+"]")).click();			
			
		}
		
	}
	
	@Test(enabled=false)
	public void testToFail(){
		
		Assert.assertEquals(true, false);
		
	}
	
	@Test(enabled=true,dataProvider = "ExData")
	public void testExpediaHomeData(String org, String dest){
		
		driver.get(url);
		ExpediaHomePage exHomePage = new ExpediaHomePage(driver);
		exHomePage.originInputBox.clear();
		exHomePage.originInputBox.sendKeys(org);
		exHomePage.destinationInputBox.clear();
		exHomePage.destinationInputBox.sendKeys(dest);
		
				
	}
		
	@DataProvider(name = "ExData")
	public static Object[][] credentials() {
	 
		//dataFileName = config.getProperty("filename");
		//sheetName = config.getProperty("sheetname");
	    return ExcelReaderUtil.getExcelData(dataFileName, sheetName);
	 
	}
	
}
