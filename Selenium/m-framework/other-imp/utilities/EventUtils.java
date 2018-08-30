package com.ad.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import com.ad.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;
import com.ad.utilities.CaptureScreenShotUtil;

public class EventUtils extends TestBase {

	static WebElement elem;

	public static void selectValueInToElement(String locator, String value) {

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

}
