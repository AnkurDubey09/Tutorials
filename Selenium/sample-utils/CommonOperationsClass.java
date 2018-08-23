package browseroperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class CommonOperationsClass {
	public static final String configFileName = "config/config.properties";
	public final String loggerConfigFileName = "log4j.properties";
	public Logger loggerObject;
	//public Properties p;
	public Properties propObj;
	
	public static String getValueOfProperty(String propName) throws IOException{
		String value;
		Properties propObj = new Properties();
		FileInputStream fisObj = new FileInputStream(configFileName);
		propObj.load(fisObj);
		value = propObj.getProperty(propName);
		return value;
	}
	
	public Integer getNumericValueOfProperty(String propName) throws IOException{
		Integer value;
		propObj = new Properties();
		FileInputStream fisObj = new FileInputStream(configFileName);
		propObj.load(fisObj);
		value = Integer.parseInt(propObj.getProperty(propName));
		return value;
	}
	
	public void initLogger() throws FileNotFoundException, IOException{
		loggerObject = Logger.getLogger(this.getClass());
		propObj = new Properties();
		propObj.load(new FileInputStream(new CommonOperationsClass().loggerConfigFileName));
		PropertyConfigurator.configure(propObj);
	}
	
	

}
