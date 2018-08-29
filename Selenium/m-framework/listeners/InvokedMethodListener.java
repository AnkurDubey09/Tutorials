package com.ad.listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

/*
 * 
 * IInvokedMethodListener is listener that gets invoked before and after a method is invoked by TestNG. 
 * It will be invoked for all methods, both test and the configuration methods.
 * 
 * */

public class InvokedMethodListener implements IInvokedMethodListener{

	@Override
	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
		// TODO Auto-generated method stub
		
	}

}
