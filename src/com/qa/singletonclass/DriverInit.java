package com.qa.singletonclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*A singleton class is a class that can have only one object(instance of the class) 
 * at a time.
 *                   or
 * define a class that has only one instance and provides a global point of access
 * to it"
How to design singleton class:
       1.make constructor as private
       2.write a public static method (getInstance) that has return type
         of object of this singleton class(lazy Instantiation)
*/

public class DriverInit {
	
	private static  DriverInit instanceDriver=null; 
	private WebDriver driver;
	
	private DriverInit()
	{
		
	}
	
	public WebDriver openBrowser(){
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
    driver = new ChromeDriver();
    return driver;
	}
	
	public static DriverInit  getInstance() {
		if( instanceDriver==null)
			 instanceDriver = new DriverInit();
		return  instanceDriver;
		
		
	}
	
	
	
	
	
	

}
