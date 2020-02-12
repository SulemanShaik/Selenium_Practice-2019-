package com.qa.batchtesting;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02_Verify_LogoTest {
	
	@Test
	
       public void logoTest() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
           driver.manage().window().maximize();
           driver.manage().deleteAllCookies();
           driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
           driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
           
           driver.get("http://www.orangeone.in/");
           WebElement ele=driver.findElement(By.xpath("//*[@id=\"mainNav\"]/div/a/img[1]"));
           
           Assert.assertTrue(ele.isDisplayed());
    	   
       }
		

}
