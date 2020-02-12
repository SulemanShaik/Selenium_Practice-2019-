package PART14.com.qa.multiplebrowserwindows;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01_Handling_MultipleBrowserWindows {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://gmail.com");
		driver.findElement(By.xpath("//a[contains(text(),'Help')]")).click();
		Thread.sleep(3000);
		Set <String> handler=driver.getWindowHandles();
		Iterator<String>it=handler.iterator();//To Move The Elements Iterator method used
		String parentwindow=it.next();
		System.out.println("PARENT WINDOW ID->"+parentwindow);
		
		String childwindow=it.next();
		System.out.println("CHILD WINDOW ID->"+childwindow);
		
		driver.switchTo().window(childwindow);
		Thread.sleep(3000);
		System.out.println("CHILD WINDOW POP UP TITLE->"+driver.getTitle());
		driver.close();
		
		driver.switchTo().window(parentwindow);
		Thread.sleep(3000);
		System.out.println("PARENT POP UP WINDOW TITLE->"+driver.getTitle());
		
		
		
	}

}
