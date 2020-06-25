
package PART14.com.qa.multiplebrowserwindows;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC02_handlng_multiplebrowserwindows {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://gmail.com");
		
		driver.findElement(By.xpath("//a[contains(text(),'Help')]")).click();
		
		Set<String>handler=driver.getWindowHandles();
		Iterator<String>it=handler.iterator();
		
		String parentwindow=it.next();
		System.out.println("parent window id"+parentwindow);
		
		String childwindow=it.next();
		System.out.println("parent window id"+childwindow);
		
		
		driver.switchTo().window(childwindow);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys("abcd");
		Thread.sleep(3000);
		System.out.println("CHILD POP UP WINDOW TITLE->"+driver.getTitle());
		driver.close();
		
		driver.switchTo().window(parentwindow);
		Thread.sleep(3000);
		System.out.println("PARENT POP UP WINDOW TITLE->"+driver.getTitle());
		
	}

}
