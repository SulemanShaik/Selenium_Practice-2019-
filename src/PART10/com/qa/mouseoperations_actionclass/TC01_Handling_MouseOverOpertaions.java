package PART10.com.qa.mouseoperations_actionclass;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class TC01_Handling_MouseOverOpertaions {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
         driver.get("http://www.way2automation.com/");
         //Assert.assertEquals(driver.getTitle(), "Best Selenium Training - Rahul Arora (Raman) | Selenium Training Institute in Noida, Delhi, Gurgaon, Ghaziabad");
         WebElement menu=driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/header[1]/div[3]/div[1]/nav[1]/div[2]/ul[1]/li[4]/a[1]"));
         
         //MOUSE OVER THE ELEMENT
         Actions action = new Actions(driver);
         action.moveToElement(menu).perform();
         driver.findElement(By.linkText("Classroom Training")).click();
         if(driver.findElement(By.xpath("//*[@class='header-logo']")).isDisplayed())
         {
        	 System.out.println("LOGO IS DIPSLYED,TEST PASS");
        	 
         }
         else {
        	 System.out.println("LOGO IS NOT DISPLYED,TEST FAIL");
         }
         
         
         
         driver.close();
         
         
	}

}
