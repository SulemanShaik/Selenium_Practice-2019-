package PART12.com.qa.alerts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC03_Handling_Alerts {
public static void main(String[] args) throws InterruptedException {
	
	System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//Drivers//geckodriver.exe" );
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("http://primusbank.qedgetech.com/");
	driver.findElement(By.id("login")).click();
	Thread.sleep(2000);
	Alert alt=driver.switchTo().alert();
	System.out.println(alt.getText());
	alt.accept();
	//alt.dismiss();
	
	

	
}
}
