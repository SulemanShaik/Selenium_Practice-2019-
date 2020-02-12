package PART18.com.qa.Takescreenshot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01_Handling_Takescreenshot
{
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.goibibo.com/");
		Assert.assertEquals(driver.getTitle(), "Online flight booking, Hotels, Bus &amp; Holiday Packages at Goibibo");
		
	 File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	// FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\Screenshots\\goibibo.png"));
	 FileUtils.copyFile(src, new File("F:\\Selenium_Programs\\Screenshots\\sample.png"));
	 System.out.println("SCREEN SHOT TAKEN");
	 driver.close();
	 
	}

}
