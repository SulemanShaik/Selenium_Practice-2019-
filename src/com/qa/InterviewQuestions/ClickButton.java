package com.qa.InterviewQuestions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickButton {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.get("http://newtours.demoaut.com");
	    WebElement signOnImage = driver.findElement(By.xpath("//input[@type='image'][@name='login']"));

	// direct method from the API which is recommended always
	    signOnImage.click(); 
	//1 Using Return Key

	  /*  //signOnImage.sendKeys(Keys.RETURN); 
	2 Using JavascriptExecutor

	2.1 
	    JavascriptExecutor js = (JavascriptExecutor)driver; 
	    js.executeScript("arguments[0].click();", signOnImage);

	2.2         
	    JavascriptExecutor js = (JavascriptExecutor) driver; 
	    js.executeScript("document.getElementsByName('login')[0].click()");
	3 Using Actions class

	3.1
	    Actions actions = new Actions(driver);  
	    actions.click(signOnImage).perform();
	3.2
	    Actions actions = new Actions(driver);
	    actions.moveToElement(signOnImage).click().perform();
	3.3 
	    Actions actions = new Actions(driver); 
	    actions.clickAndHold(signOnImage).release().perform();
	3.4 
	    Actions actions = new Actions(driver);
	    actions.sendKeys(signOnImage, Keys.RETURN).perform();*/
	}

}
