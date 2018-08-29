package com.ad.listeners;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

import com.ad.utilities.ExcelReaderUtil;
import com.ad.utilities.LoggerUtils;

import org.apache.logging.log4j.Logger;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

/***
 * 
 * Annotations are static in nature by design, so any change in the values require recompilation of source files. 
 * Since TestNG relies heavily on annotations, it would be nice if one can override its behavior at runtime. 
 * This is exactly what TestNG allows you to do using its annotation transformation framework.
 * IAnnotationTransformer is a TestNG listener which allows you to modify TestNG annotation and configure it further.
 * 
 * 
 * In the below example, we configure the @Test annotation. TestAnnotationTransformerExample is our test class. 
 * It contains test methods t1, t2 and t3. Methods t1 and t2 accept a string parameter but we haven’t provided any DataProvider. 
 * The DataProvider will be set on-the-fly in the annotation transformer, based on the method. We also would want to disable method t3.
 *  	
 *  
 *  IAnnotationTransformer only lets you modify a @Test annotation. If you need to modify other TestNG annotations like a configuration annotation, @Factory or 
 *  @DataProvider you may have to use the enhanced interface IAnnotationTransformer2. 
 *   	
 * */

public class TestAnnotationTransformerListener implements IAnnotationTransformer{

	private Logger logger = LoggerUtils.getInfoLogger();
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor,
			Method testMethod) {
		// TODO Auto-generated method stub
		if (testMethod.getName().equals("t1")){
			
			System.out.println("set data provider for " + testMethod.getName());
			
			//annotation.setDataProviderClass(DataProviderFactory.class);
			annotation.setDataProvider("getDp1");
			
		}else if (testMethod.getName().equals("t2")){
			
			System.out.println("set data provider for " + testMethod.getName());
			
			//annotation.setDataProviderClass(DataProviderFactory.class);
			annotation.setDataProvider("getDp1");
			
		}else if (testMethod.getName().equals("t3")){
			
			System.out.println("Disable " + testMethod.getName());
			logger.info("Disable " + testMethod.getName());
			annotation.setEnabled(false);
						
		}
		
		Properties config = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			config.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(config.getProperty("browser"));
		
        String fileName = config.getProperty("testdata");
        String sheet = config.getProperty("sheetname");
        String colName = config.getProperty("colname");
        String run = config.getProperty("status");
        
        String d[] = ExcelReaderUtil.getColumnData(fileName, sheet, colName);
        String d1[] = ExcelReaderUtil.getColumnData(fileName, sheet, run);
        for(int i=1; i<d.length;i++){
        	if(d1[i].equals("N")){
        		if (testMethod.getName().equals(d[i])){
        			
        			System.out.println("Disable " + testMethod.getName());
        			logger.info("Disable " + testMethod.getName());
        			annotation.setEnabled(false);
        			
        						
        		}
        	}
        }
	}

}
