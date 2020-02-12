 package com.qa.fileuploadpopupbysendkeys;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01_Fileupload {

	public static void main(String[] args) throws InterruptedException {
		

		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.monsterindia.com/seeker/registration");
        driver.findElement(By.xpath("html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]")).click();
		driver.findElement(By.id("file-upload")).sendKeys("F:\\RESUME\\DYNR Testing fresher resume.docx");
		System.out.println("File UPloaded Successfully");
        /*String expectedvalue=driver.findElement(By.id("file-upload")).getText();
        if(expectedvalue.contains("DYNR Testing fresher resume.docx")) {
               System.out.println("File UPloaded Successfully");
        }*/
        
        
	}

}
