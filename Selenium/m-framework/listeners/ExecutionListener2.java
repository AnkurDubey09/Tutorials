package com.ad.listeners;

import org.testng.IExecutionListener;

/*
 * In my second listener, ExecutionListener2, in onExecutionStart(), I notify the interested parties that the TestNG is going to start. 
 * Likewise, in onExecutionFinish(), I notify them that TestNG has finished running the suites. For simplicity’s sake, I haven’t used any mail 
 * related code and instead you will just see simple messages as the intention is only to show you the possibilities.
 * 
 * */


public class ExecutionListener2 implements IExecutionListener{

	@Override
	public void onExecutionFinish() {
		// TODO Auto-generated method stub
		System.out.println("Notify by mail that TestNG is going to start");
	}

	@Override
	public void onExecutionStart() {
		// TODO Auto-generated method stub
        System.out.println("Notify by mail, TestNG is finished");
	}

}
