package library;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class JavaManager {
	
	private Properties prop;
	private InputStream input;
	private OutputStream output;
	private String propertyFilePath;
	
	public JavaManager(String propertyFilePath) {
		this.propertyFilePath = propertyFilePath;
		prop = new Properties();
	}
	
	public void setProperty(String key, String value) {
		try {
			output = new FileOutputStream(propertyFilePath);
			prop.setProperty(key, value);
			prop.store(output, null);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String readProperty(String key) {
		String value = null;
		try {
			input = new FileInputStream(propertyFilePath);
			prop.load(input);
			value = prop.getProperty(key);
		}catch(Exception e){
			e.printStackTrace();
		}
		return value;
	}

}
