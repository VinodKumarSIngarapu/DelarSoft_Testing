package com.dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class ConfigFileReader {
	
	private Properties prop;
	private final String propPath = "configs//Configuration.properties";
	
	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propPath));
			prop = new Properties();
			try {
				prop.load(reader);
				reader.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}catch(FileNotFoundException fe) {
			fe.printStackTrace();
			 throw new RuntimeException("Configuration.properties not found at " + propPath);
		}
		
	}
	
	public String getDriverPath(String browser){
		String driverPath = "";
		if(browser!=null) {
			if(browser.equalsIgnoreCase("chrome")) {
				driverPath = prop.getProperty("chromDriverPath");
			}else if(browser.equalsIgnoreCase("firefox")) {
				driverPath = prop.getProperty("geckoDriverPath");
			}
		}
		
	 	if(driverPath!= null) return driverPath;
	 	else throw new RuntimeException("driverPath not specified in the Configuration.properties file."); 
	}
		 
	public long getImplicitlyWait() { 
		String implicitlyWait = prop.getProperty("implicitlyWait");
		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file."); 
	}
		 
	public String getApplicationUrl() {
		String url = prop.getProperty("baseUrl");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getBrowser() {
		String browserName = prop.getProperty("browserName");
		if(browserName != null) return browserName;
		else throw new RuntimeException("browser not specified in the Configuration.properties file.");
	}
}
