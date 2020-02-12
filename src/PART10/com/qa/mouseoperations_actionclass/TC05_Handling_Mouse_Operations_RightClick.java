package PART10.com.qa.mouseoperations_actionclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.GetCurrentUrl;


public class TC05_Handling_Mouse_Operations_RightClick {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://deluxe-menu.com/popup-mode-sample.html");
		WebElement img=driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/div[2]/table[1]/tbody/tr/td[3]/p[2]/img"));
		Actions action= new Actions(driver);
		action.contextClick(img).perform();
		driver.findElement(By.xpath("//*[@id='dm2m1i1tdT']")).click();
		driver.findElement(By.xpath("//*[@id='dm2m2i1tdT']")).click();
		driver.findElement(By.xpath("//*[@id='dm2m3i1tdT']")).click();
		
	       if (driver.getCurrentUrl().contains("popup-mode-sample.html")) {
	    	   System.out.println("TEST PASS");
		} else {
			 System.out.println("TEST FAIL");
		}
		
	}

}
