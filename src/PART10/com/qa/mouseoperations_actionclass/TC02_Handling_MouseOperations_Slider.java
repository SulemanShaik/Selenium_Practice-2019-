package PART10.com.qa.mouseoperations_actionclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC02_Handling_MouseOperations_Slider {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	   driver.get("https://jqueryui.com/slider/");
	   
	   /*WebElement slider=driver.findElement(By.xpath("//*[@id='slider']/span"));
	   Actions action = new Actions(driver);
	   action.dragAndDropBy(slider, 400, 0).perform();*/
	   //Handling DYNAMICally
	  
	   WebElement mainslider= driver.findElement(By.id("slider"));
	   int width=mainslider.getSize().width/2;
	   WebElement slider=driver.findElement(By.xpath("//*[@id='slider']/span"));
	   
	   Actions action = new Actions(driver);
	   action.dragAndDropBy(mainslider, width, 0).perform(); 
		
	}

}
