package PART21.com.qa.log4j;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01_log4i {
	
	public static void main(String[] args) {
		
		
		
		Logger logger=Logger.getLogger("TC01_log4i");
		PropertyConfigurator.configure("log4j.properties");
		
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		
		WebDriver  driver = new ChromeDriver();
		logger.info("Browser Launch");
		driver.manage().window().maximize();
		logger.info("Window maximize");
		driver.manage().deleteAllCookies();
		logger.info("delete allcookies");
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		logger.info("Pageloadtimeout");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		logger.info("implicitly wait");
		
		driver.get("http://www.orangeone.in/");
		logger.info("applaunched");
		
		driver.findElement(By.linkText("Contact Us")).click();
		logger.info("Contact us page open");
		
		driver.close();
		logger.info("driver close");
		
		
	
		
		
	}

}
