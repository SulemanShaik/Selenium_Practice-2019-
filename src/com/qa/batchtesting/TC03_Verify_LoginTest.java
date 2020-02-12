package com.qa.batchtesting;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03_Verify_LoginTest {
	
	@Test	
	public void loginTest(){
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
           driver.manage().window().maximize();
           driver.manage().deleteAllCookies();
           driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
           driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
           
           driver.get("http://primusbank.qedgetech.com/");
           
           Assert.assertEquals(driver.getTitle(), "Primus BANK");
           
           driver.findElement(By.id("txtuId")).sendKeys("Admin");
           driver.findElement(By.id("txtPword")).sendKeys("Admin");
           driver.findElement(By.id("login")).click();
           
           String url=driver.getCurrentUrl();
   		
   		   if (url.contains("com"))
   		   {
   		   Assert.assertTrue(true);	
   		   } else 
   		   {
              Assert.assertTrue(false);
   		    }
             driver.close();

}
}
