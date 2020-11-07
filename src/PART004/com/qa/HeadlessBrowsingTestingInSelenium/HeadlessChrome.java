package PART004.com.qa.HeadlessBrowsingTestingInSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChrome {

	/*A  headless browser is a browser simulation program that does not have any 
	user interface (UI Less)
	Headless Browser program operate like any other browser, but do not display any UI.
	Selenium executes it's tests in the background.
	
	Popular Headless browser available in Market are:
	chrome
	Firefox
	HTMLUnitBrowser
	PhantomJS
	*/
	
	public static void main(String[] args) {

		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		
		ChromeOptions option = new ChromeOptions();
		option.setHeadless(true);
		//option.addArguments("--headless");
		
		WebDriver driver = new ChromeDriver(option);
		
		driver.get("https://www.facebook.com/");
		System.out.println("Title of the page :"+driver.getTitle());
		
		
	}

}
