package PART004.com.qa.HeadlessBrowsingTestingInSelenium;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessFirefox {

	{
		
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
		
		FirefoxOptions option = new FirefoxOptions();
		option.setHeadless(true);
		
		WebDriver driver = new FirefoxDriver(option);
		
		driver.get("https://www.facebook.com/");
		System.out.println("Title of the page :"+driver.getTitle());
		
		
		
		
		
	}

}
