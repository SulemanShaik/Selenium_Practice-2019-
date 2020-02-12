package com.qa.InterviewQuestions;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Ebay_addcart {
	public static void main(String[] args) {
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe" );
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://in.ebay.com");
		
		Assert.assertEquals(driver.getTitle(),"Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay");
		
		driver.findElement(By.id("gh-ac")).sendKeys("menswatches");
		driver.findElement(By.id("gh-btn")).click();
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.ebay.com/sch/i.html?_from=R40&_trksid=m570.l1313&_nkw=menswatches&_sacat=0");
		
		driver.findElement(By.xpath("//*[@id=\"srp-river-results-listing7\"]/div/div[1]/div/a/div/img")).click();
		driver.findElement(By.id("isCartBtn_btn")).click();
		
		List<WebElement>totalcart=driver.findElements(By.xpath("//*[@id='gh-cart']/a"));
		 
		        System.out.println("TOTOL NO OF SHOPPING ITEMS IN YOUR CART IS->"+totalcart.size());
		
		        for(int i=0;i<totalcart.size();i++) {
		        	
		        	System.out.println(totalcart.get(i).getText());
		        	//System.out.println(totalcart.get(i).getAttribute("title"));
		        	
		        }
		
		
		
		
		
	}

}
