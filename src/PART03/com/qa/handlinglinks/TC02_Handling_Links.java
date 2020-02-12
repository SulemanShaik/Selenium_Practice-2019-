package PART03.com.qa.handlinglinks;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC02_Handling_Links {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		
        WebDriver driver = new ChromeDriver ();
        driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.get("http://www.orangeone.in/");
		  System.out.println(driver.getTitle());
		
		  List<WebElement>linkcount=driver.findElements(By.tagName("a"));
		 
		  System.out.println(linkcount.size());
		  for (int i = 0; i < linkcount.size(); i++) {
			  System.out.println(linkcount.get(i).getText());
			
		}
		  
		  driver.close();
		  
        
	}

}
