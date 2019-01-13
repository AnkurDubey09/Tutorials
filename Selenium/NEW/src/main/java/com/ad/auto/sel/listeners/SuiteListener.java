package com.ad.auto.sel.listeners;

import java.util.HashMap;
import java.util.Map;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.xml.XmlSuite;

/**
 * 
 * We also have a listener for the suite called ISuiteListener. It has two methods, onStart and onFinish. 
 * Method onStart is invoked before TestNG starts running the suite and onFinish is invoked after TestNG has run the suite.
 * The listener is called for each suite, if the parent suite contains child suites then the child suites are first run before running the parent suite. 
 * This is done so that the results for parent suite can reflect the combined results of the child suites.
 * 
 **/

public class SuiteListener implements ISuiteListener{

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Finish suite " + suite.getName());
	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Start suite " + suite.getName());
		XmlSuite xmlSuite = suite.getXmlSuite();
		if (!xmlSuite.getTests().isEmpty()) {
			Map parms = new HashMap();
			parms.put("ui", "web");
			System.out.println("Set ui param value");
			xmlSuite.setParameters(parms);
		}
	}

}
