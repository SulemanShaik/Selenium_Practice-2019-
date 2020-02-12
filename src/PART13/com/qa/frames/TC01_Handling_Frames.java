package PART13.com.qa.frames;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01_Handling_Frames {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_submit");
		driver.switchTo().frame(driver.findElement(By.id("iframeResult")));//ByElement-Recommended
		//driver.switchTo().frame(1);//By Index
		//driver.switchTo().frame("iframeResult");//By String
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		/*//Moving to main frame
		driver.switchTo().defaultContent(); //Not Recommend
		driver.findElement(By.xpath("//button[contains(text(),'Run')]")).click();*/
		

	}

}
