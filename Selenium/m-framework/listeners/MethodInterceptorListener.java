package com.ad.listeners;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.annotations.Test;

/**
 * 
 * IMethodInterceptor interface is used to modify the list of test methods that we want TestNG to run. 
 * It will be invoked right before TestNG starts invoking test methods.
 * It has just one method to implement intercept which returns the altered list of methods.
 *
 * **/

public class MethodInterceptorListener implements IMethodInterceptor {

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods,
			ITestContext context) {
		// TODO Auto-generated method stub
		List result = new ArrayList();
		for (IMethodInstance m : methods) {
			Test test = m.getMethod().getMethod().getAnnotation(Test.class);
			Set groups = new HashSet();
			for (String group : test.groups()) {
				groups.add(group);
				
			}
            if (groups.contains("perf")) {
            	result.add(m);
            }else{
            	String testMethod = m.getMethod().getMethod().getName();
                System.out.println(testMethod+ " not a performance test so remove it");

            }
		}
		return result;
	}

}
