package PART05.com.qa.autosuggestion;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TC01_Handling_AutoSuggestions {
	public static void main(String[] args)
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.cleartrip.com/");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("FromTag")).clear();
		driver.findElement(By.id("FromTag")).sendKeys("che");
		
	
		List<WebElement> totalCities=driver.findElements(By.xpath("/html[1]/body[1]/ul[1]/li/a[1]"));
		System.out.println("TOTAL NUMBER OF CITIES PRESENT "+totalCities.size());
		
		for (int i = 0; i < totalCities.size(); i++) {
			System.out.println(totalCities.get(i).getText());
			
		}
		
	   driver.close();
	}

}
