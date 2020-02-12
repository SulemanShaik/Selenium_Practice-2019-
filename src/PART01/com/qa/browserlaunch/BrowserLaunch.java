package PART01.com.qa.browserlaunch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLaunch {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();	
	//System.setProperty("webdriver.gecko.driver", "F:\\Selenium Softwares\\BOWSER_DRIVERS\\geckodriver.exe");
   // WebDriver driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.qaautomation.co.in/");
	driver.close();
	}

}
