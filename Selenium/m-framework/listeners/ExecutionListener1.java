package com.ad.listeners;

import org.apache.logging.log4j.Logger;
import org.testng.IExecutionListener;

import com.ad.base.TestBase;
import com.ad.utilities.LoggerUtils;


/**
 * 
 * IExecutionListener is a listener that monitors the beginning and end of a TestNG run. It has two methods, 
 * onExecutionStart() and onExecutionFinish(). Method onExecutionStart() is called before the TestNG starts 
 * running the suites and onExecutionFinish() is called after TestNG is done running all the test suites.
 * 
 * 
 * In class ExecutionListener1, in method onExecutionStart(), I record the start time and in method onExecutionFinish(), 
 * I print the time TestNG takes to run all the suites.
 * */

public class ExecutionListener1 extends TestBase implements IExecutionListener {
	
	private long startTime;
	private Logger log = LoggerUtils.getInfoLogger();
	
	@Override
	public void onExecutionFinish() {
		// TODO Auto-generated method stub
		System.out.println("TestNG has finished, took around " + (System.currentTimeMillis() - startTime) + "ms");
		log.info("TestNG has finished, took around " + (System.currentTimeMillis() - startTime) + "ms");
	}

	@Override
	public void onExecutionStart() {
		// TODO Auto-generated method stub
		startTime = System.currentTimeMillis();
		System.out.println("TestNG is going to start");
		log.info("TestNG is going to start");
	}

}
