package com.qa.InterviewQuestions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TajHotelsTest_CityPresentorNot 
{
	
	public static void main(String[] args)
	{
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		
		 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			
			WebDriver  driver = new ChromeDriver(option);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			driver.get("https://www.tajhotels.com/");
			
			
			 List<WebElement> totalcities=driver.findElements(By.xpath("//div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div/div[2]/div[1]"));
			 System.out.println(totalcities.size());
			 
			 
			 WebElement ele=driver.findElement(By.xpath("//div[1]/div[2]/main/div[3]/div/div/div[2]/div/div[2]/div[3]/span"));
			 clickElement(ele, driver);
			 
			 String actcity,expcity;
			 boolean brcity=false;
			 expcity="Hyderabad";
			 for(int i=0;i<totalcities.size();i++)
			 {
		        actcity=totalcities.get(i).getText();
		         if(actcity.contains(expcity))
		         {
		    	 brcity=true;
		    	 break;
		          }
		     
		     }
			 
			 if(brcity)
			 {
		    	 System.out.println(expcity+"is present in the list");
		     }
		     else 
		        {
		    	 System.out.println(expcity+"is not present in the list");
		        }
		    	 
	}

	
	public static void clickElement(WebElement ele, WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ele);
		
	}
}
