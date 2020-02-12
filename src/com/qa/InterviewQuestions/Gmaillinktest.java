package com.qa.InterviewQuestions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Gmaillinktest {

	public static void main(String[] args) {
		
     System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		
		WebDriver  driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		
		/*String expvalue="Gmail123";
		String actvalue;*/
		
		String name= driver.findElement(By.linkText("Gmail")).getText();
          System.out.println(name);
          
          
           if(name.contains("Gma")) {
        	   System.out.println("TEST PASS");
        	   
           }
           else {
        	   System.out.println("TEST FAIL");
           }
          
		
		/*if(driver.getPageSource().contains("Gmail1236")) {
			
		System.out.println("Test Pass");
	}
		else {
			System.out.println("Test Fail");
		}
*/
   
  

		 

	}
}

