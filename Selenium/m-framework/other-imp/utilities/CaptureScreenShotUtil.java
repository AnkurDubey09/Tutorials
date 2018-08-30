package com.ad.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ad.base.TestBase;

public class CaptureScreenShotUtil extends TestBase{
	
	public static String screenShotName;

	public static String captureScreenShot(){
		
		Date d = new Date();
		screenShotName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screenShotName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screenShotName;
	}
	
	public static String getPathOfScreenShot() {

		return System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screenShotName;
	}
}
