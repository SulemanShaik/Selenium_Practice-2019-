package com.qa.isdisplayedisselectedisenabled;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01_Handling_IsDisplayed_IsSelected_Is_Enbled {

	public static void main(String[] args) {

			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
    driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
    
  /*RETURN TRUE OR FALSE IF IS SELECTED RETURN TYPE IS BOOLEAN
   RETURN TRUE OR FALSE IF IS DISPLAYED RETURN TYPE IS BOOLEAN
   RETURN TRUE OR  FALSE IF IS ENABLED RETURN TYPE IS BOOLEAN*/    
   
    
    System.out.println(driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[2]/a")).isDisplayed());
    System.out.println(driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]/input[1]")).isSelected());
    System.out.println(driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]/input[3]")).isEnabled());
      driver.close();
	}
	

}
