package PART16.com.qa.bootstrapdropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01_HandlingBootStrap {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  
		driver.get("http://www.orangeone.in/");
		driver.findElement(By.id("dropdown07")).click();
		
		List<WebElement>ddlist=driver.findElements(By.xpath("//*[@class='dropdown-menu show']/li/a"));
	         System.out.println(ddlist.size());
		     for(int i=0;i<ddlist.size();i++) {
			System.out.println(ddlist.get(i).getText());
			
			//ddlist.get(i)click(); //For selecting all check boxes or links in the dropdown
			if(ddlist.get(i).getText().contains("Software Testing"))
			{
				ddlist.get(i).click();
				break;
			}
			
			
		}
		  
		     System.out.println(driver.getCurrentUrl());
	}

}
