package com.ad.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.ad.utilities.CaptureScreenShotUtil;

import com.ad.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

/*
 * 
 
•	onStart is invoked first.
•	onTestStart is called once for each test before it is invoked.
•	onTestSuccess is invoked whenever a test passes. In our example, t1 always passes whereas, t4 passes three times.
•	onTestFailure is called for t2 as t2 will always fail. It is also called for t4 as it fails twice out of five times that it is invoked.
•	onTestSkipped is called once for t3 as it is bound to skip.
•	onTestFailedButWithinSuccessPercentage is called once for t4, the first time it fails. It is not called again as it doesn’t match the requested successPercentage of 80
•	Finally onFinish is called once when the tests are all run.

 * 
 * */

public class TestListenerForExtentReport extends TestBase implements ITestListener {

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailure(ITestResult Result) {
		// TODO Auto-generated method stub
		System.setProperty("org.uncommons.reportng.escape-output","false");
		String screenShotPath = CaptureScreenShotUtil.captureScreenShot();
		Reporter.log("<a href="+screenShotPath+">Screenshot</a>");
		test.log(LogStatus.FAIL, Result.getThrowable());
		test.log(LogStatus.FAIL, Result.getName().toUpperCase()+" Failed. Snapshow below: "+test.addScreenCapture(screenShotPath));
		exRepo.endTest(test);
		exRepo.flush();
	}

	@Override
	public void onTestSkipped(ITestResult Result) {
		// TODO Auto-generated method stub
		test.log(LogStatus.SKIP, Result.getName().toUpperCase()+" Skipped.");
		exRepo.endTest(test);
		exRepo.flush();
	}

	@Override
	public void onTestStart(ITestResult Result) {
		// TODO Auto-generated method stub
		test = exRepo.startTest(Result.getName().toUpperCase());
	}

	@Override
	public void onTestSuccess(ITestResult Result) {
		// TODO Auto-generated method stub
		test.log(LogStatus.PASS, Result.getName().toUpperCase()+" Passed.");
		exRepo.endTest(test);
		exRepo.flush();
	}
	
	

}
