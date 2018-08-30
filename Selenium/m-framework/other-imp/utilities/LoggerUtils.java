package com.ad.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;


public class LoggerUtils {

	public static Logger logger = LogManager.getLogger(LoggerUtils.class.getName());
	
	public static Logger getInfoLogger(){
		
		String fileName = System.getProperty("user.dir")+"\\src/test/java/log4j2.xml";
		Configurator.initialize(null, fileName);
		
		return logger;
	}
	
}
