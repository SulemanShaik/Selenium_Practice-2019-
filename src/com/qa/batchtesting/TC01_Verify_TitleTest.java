package com.qa.batchtesting;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_Verify_TitleTest {
	
	@Test	
	public void titleTest(){
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
           driver.manage().window().maximize();
           driver.manage().deleteAllCookies();
           driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
           driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
           
           driver.get("http://www.orangeone.in/");
           Assert.assertEquals(driver.getTitle(), "Orangeone information system");
           
           
           
           
		
	}

}
