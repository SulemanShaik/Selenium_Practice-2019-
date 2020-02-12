package PART20.com.qa.propertyfile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProp {
	
	public static void main(String[] args) throws IOException {
		
		//how to read properties file
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("F:\\Selenium Practice - SEPTEMBER\\Selenium Practice-SEP\\src\\config.properties");
		prop.load(fis);
		
		System.out.println(prop.getProperty("name"));
		//To commenting # is used
		System.out.println(prop.getProperty("role"));
		System.out.println(prop.getProperty("department"));
		
	}
	

	
	
}
