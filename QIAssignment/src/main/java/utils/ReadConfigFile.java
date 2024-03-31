package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigFile {
	
	/** Can be accessed outside package by subclass only */
	protected InputStream input = null;
	protected Properties prop = null;
	
	public ReadConfigFile() {
				
		String configFileFulPath = Constants.CONFIG_PROPERTY_DIR + "";
		
		if(System.getProperty("os.name").contains("Linux")) {
			configFileFulPath = Constants.CONFIG_PROPERTY_DIR + "//" + Constants.CONFIG_PROPERTY_FILE_NAME;
		}else if(System.getProperty("os.name").contains("Windows")) {
			configFileFulPath = Constants.CONFIG_PROPERTY_DIR + "\\" + Constants.CONFIG_PROPERTY_FILE_NAME;
		}else if(System.getProperty("os.name").contains("Mac")) {
			/**Need to check*/
		}

		try {
			input = ReadConfigFile.class.getClassLoader().getResourceAsStream(configFileFulPath);
			prop = new Properties();
			prop.load(input);
		} catch (IOException e) {
			System.out.println("Unable to load config file.");
		}
	}
	
	public String getBrowser() {
		/** Making Chrome as default browser if not specified in properties file */
		if(prop.getProperty("browser") == null) {
			return "chrome";
		}else
			return prop.getProperty("browser");
	}
	
	public String isHeadless() {
		return prop.getProperty("headless");
	}
	
	public String appURL() {
		return prop.getProperty("appURL");
	}
}
