package PART23.com.qa.testng;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC02_Assertions {

	WebDriver driver;
	
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com");
	}
		
		
		@Test
		public void googleTitleTest() {
			String title=driver.getTitle();
			System.out.println(title);
			Assert.assertEquals(title, "Google123");
			
		}
		
		@Test
		public void logoTest() {
			boolean b=driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed();
			Assert.assertTrue(b);
			//Assert.assertEquals(b,true);
		}
		
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
			
		}
		
		
		
		
	}

