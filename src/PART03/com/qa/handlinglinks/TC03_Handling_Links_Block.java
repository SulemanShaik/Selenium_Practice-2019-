package PART03.com.qa.handlinglinks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC03_Handling_Links_Block {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		
        WebDriver driver = new ChromeDriver ();
        driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.get("http://www.orangeone.in/");
		  System.out.println("TITLE OF THE PAGE  "+driver.getTitle());
		
		  WebElement block=driver.findElement(By.xpath("/html/body/footer/div/div[1]/div/div[2]"));
		 
		  List<WebElement>links=block.findElements(By.tagName("a"));
		  System.out.println(links.size());
		  for (int i = 0; i < links.size(); i++) {
			  System.out.println(links.get(i).getText());
			
		}
		  driver.close();
		  
        
	}

}
