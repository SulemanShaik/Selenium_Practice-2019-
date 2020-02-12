package PART06.com.qa.checkboxes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC02_Handling_Checkboxes {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
	
	
	 System.out.println(driver.findElement(By.xpath("//*[@id=\'ctl00_mainContent_chk_friendsandfamily\']")).isSelected());
	 System.out.println(driver.findElement(By.xpath("//*[@id=\'ctl00_mainContent_chk_friendsandfamily\']")).isEnabled());
	 System.out.println(driver.findElement(By.xpath("//*[@id=\'ctl00_mainContent_chk_friendsandfamily\']")).isDisplayed());
		
		driver.close();
		

	}

}
