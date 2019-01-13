package com.ad.auto.sel.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ad.auto.sel.tests.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

public class EventUtils extends BaseClass {

	public static WebElement elem;
	public static FileInputStream orFis;
	public static Properties OR = new Properties();

	public static void selectValueInToElement(String locator, String value) {
		
		try {
			orFis = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\test\\resources\\properties\\OR.properties");

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		try {
			OR.load(orFis);
		} catch (IOException e) {

			e.printStackTrace();
		}

		if (locator.endsWith("_CSS")) {

			try {

				elem = driver.findElement(By.cssSelector(OR
						.getProperty(locator)));

			} catch (Exception e) {

				logger.error("Element " + locator + " not found.");
				test.log(LogStatus.ERROR, "Element " + locator + " not found.");
				test.log(LogStatus.ERROR, test.addScreenCapture(CaptureScreenShotUtil.captureScreenShot()));
				throw (e);

			}

		} else if (locator.endsWith("_XPATH")) {

			try {

				elem = driver.findElement(By.xpath(OR.getProperty(locator)));

			} catch (Exception e) {

				logger.error("Element " + locator + " not found.");
				test.log(LogStatus.ERROR, "Element " + locator + " not found.");
				test.log(LogStatus.ERROR, test.addScreenCapture(CaptureScreenShotUtil.captureScreenShot()));
				throw (e);

			}

		} else if (locator.endsWith("_ID")) {

			try {

				elem = driver.findElement(By.id(OR.getProperty(locator)));

			} catch (Exception e) {

				logger.error("Element " + locator + " not found.");
				test.log(LogStatus.ERROR, "Element " + locator + " not found.");
				test.log(LogStatus.ERROR, test.addScreenCapture(CaptureScreenShotUtil.captureScreenShot()));
				throw (e);

			}

		}
		wait.until(ExpectedConditions.elementToBeSelected(elem));
		Select sel = new Select(elem);
		sel.selectByVisibleText(value);

		logger.info("Selected value " + value + " for element " + locator);
		test.log(LogStatus.INFO, "Selected value " + value + " for element "
				+ locator);

	}

	public static void clickOnElement(String locator) {

		try {
			orFis = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\test\\resources\\properties\\OR.properties");

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		try {
			OR.load(orFis);
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		if (locator.endsWith("_CSS")) {

			try {

				elem = driver.findElement(By.cssSelector(OR
						.getProperty(locator)));

			} catch (Exception e) {

				logger.error("Element " + locator + " not found.");
				test.log(LogStatus.ERROR, "Element " + locator + " not found.");
				test.log(LogStatus.ERROR, test.addScreenCapture(CaptureScreenShotUtil.captureScreenShot()));
				throw (e);

			}

		} else if (locator.endsWith("_XPATH")) {

			try {

				elem = driver.findElement(By.xpath(OR.getProperty(locator)));

			} catch (Exception e) {

				logger.error("Element " + locator + " not found.");
				test.log(LogStatus.ERROR, "Element " + locator + " not found.");
				test.log(LogStatus.ERROR, test.addScreenCapture(CaptureScreenShotUtil.captureScreenShot()));
				throw (e);

			}

		} else if (locator.endsWith("_ID")) {

			try {

				elem = driver.findElement(By.id(OR.getProperty(locator)));

			} catch (Exception e) {

				logger.error("Element " + locator + " not found.");
				test.log(LogStatus.ERROR, "Element " + locator + " not found.");
				test.log(LogStatus.ERROR, test.addScreenCapture(CaptureScreenShotUtil.captureScreenShot()));
				throw (e);

			}

		}
		wait.until(ExpectedConditions.elementToBeClickable(elem));
		elem.click();

		logger.info("Clicked on element " + locator);
		test.log(LogStatus.INFO, "Clicked on element " + locator);

	}

	public static void inputInToElement(String locator, String value) {

		try {
			orFis = new FileInputStream(System.getProperty("user.dir")
					+ "\\configs\\properties\\OR.properties");

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		try {
			OR.load(orFis);
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		if (locator.endsWith("_CSS")) {

			try {

				elem = driver.findElement(By.cssSelector(OR
						.getProperty(locator)));
				logger.info("Element " + locator + " BY_CSS_FOUND.");

			} catch (Exception e) {

				logger.error("Element " + locator + " not found.");
				test.log(LogStatus.ERROR, "Element " + locator + " not found.");
				test.log(LogStatus.ERROR, test.addScreenCapture(CaptureScreenShotUtil.captureScreenShot()));
				throw (e);

			}

		} else if (locator.endsWith("_XPATH")) {

			try {

				elem = driver.findElement(By.xpath(OR.getProperty(locator)));
				logger.info("Element " + locator + " BY_XPATH_FOUND.");

			} catch (Exception e) {

				logger.error("Element " + locator + " not found.");
				test.log(LogStatus.ERROR, "Element " + locator + " not found.");
				test.log(LogStatus.ERROR, test.addScreenCapture(CaptureScreenShotUtil.captureScreenShot()));
				throw (e);

			}

		} else if (locator.endsWith("_ID")) {

			try {

				elem = driver.findElement(By.id(OR.getProperty(locator)));
				logger.info("Element " + locator + " BY_ID_FOUND.");

			} catch (Exception e) {

				logger.error("Element " + locator + " not found.");
				test.log(LogStatus.ERROR, "Element " + locator + " not found.");
				test.log(LogStatus.ERROR, test.addScreenCapture(CaptureScreenShotUtil.captureScreenShot()));
				throw (e);

			}

		}
		wait.until(ExpectedConditions.visibilityOf(elem));
		elem.clear();
		elem.sendKeys(value);

		logger.info("Entered value " + value + " in to " + locator);
		test.log(LogStatus.INFO, "Entered value " + value + " in to " + locator);

	}

	public static void selectValueInToElement(WebElement elem, String value) {
	
		wait.until(ExpectedConditions.visibilityOf(elem));
		Select sel = new Select(elem);
		sel.selectByVisibleText(value);

		logger.info("Selected value " + value + " for element " + elem);
		test.log(LogStatus.INFO, "Selected value " + value + " for element "
				+ elem);

	}

	public static void clickOnElement(WebElement elem) {
		
		wait.until(ExpectedConditions.elementToBeClickable(elem));
		elem.click();

		logger.info("Clicked on element " + elem);
		test.log(LogStatus.INFO, "Clicked on element " + elem);

	}

	public static void inputInToElement(WebElement elem, String value) {
		
		wait.until(ExpectedConditions.visibilityOf(elem));
		elem.clear();
		elem.sendKeys(value);

		logger.info("Entered value " + value + " in to " + elem);
		test.log(LogStatus.INFO, "Entered value " + value + " in to " + elem);

	}
	
	// Explicit wait custom function
	/***
	 * no explicit keyword or method
	 * available with WebDriverWait with some expected conditions
	 * specific to element
	 * dynamic in nature
	 * we should never use explicity and implicit wait together
	 * selenium webdriver will wait first for implicit wait and then explicit wait if element is not found, since total sync wait will get increased
	 * 
	 * **/
	public static void sendKeys(WebDriver driver, WebElement element, int timeOut, String value){

		new WebDriverWait(driver, timeOut).
		until(ExpectedConditions.visibilityOf(element));
		
		element.clear();
		element.sendKeys(value);
		
	}
	
	public static void clickOn(WebDriver driver, WebElement element, int timeOut){

		new WebDriverWait(driver, timeOut).
		until(ExpectedConditions.elementToBeClickable(element));
		
		element.click();
		
	}

}
