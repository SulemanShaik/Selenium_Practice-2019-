package com.qa.ExplicitWaitCondition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {
         
		/*Selenium provided web driver wait class to implement Explicit Conditions, 
		using WebDriverWait we can instruct selenium wait until the specified condition
		is satisfy before execution the next step.*/	
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://gmail.com");
        driver.findElement(By.id("identifierId")).sendKeys("demo.qedge");
        driver.findElement(By.id("identifierNext")).click();
        WebDriverWait wait = new WebDriverWait(driver,20);
        
        WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("password"))));
		
		ele.sendKeys("qedge");
	}
 
}
