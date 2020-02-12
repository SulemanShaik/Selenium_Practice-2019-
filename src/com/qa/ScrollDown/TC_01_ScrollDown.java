package com.qa.ScrollDown;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_01_ScrollDown {

	public static void main(String[] args) {
                
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
           driver.manage().window().maximize();
           driver.manage().deleteAllCookies();
           driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
           driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
           
           driver.get("http://www.orangeone.in/");
           
           JavascriptExecutor js= (JavascriptExecutor) driver;
           //Scroll page By Pixel
          // js.executeScript("window.scrollBy(0,1000)","");
           
           //Scroll page By Element
           WebElement ele=driver.findElement(By.xpath("/html/body/section[3]/div/div[2]/div[6]/div/div[2]/a"));
           js.executeScript("arguments[0].scrollIntoView()",ele);
           //Scroll page by page till bottom
           //js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		    System.out.println(ele.getText());
		
	}

}
