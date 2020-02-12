package com.qa.InterviewQuestions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangehrmTest {

	public static void main(String[] args) {
       System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		
		WebDriver  driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://orangehrm.qedgetech.com/");
		
		String titname=driver.getTitle();
		System.out.println(titname);
		if(titname.equals("OrangeHRM")) {
			System.out.println(titname +"->TITLE VERIFED-TEST PASS");
		}
		else {
			System.out.println(titname+"->TITLE VERIFED-TEST FAIL");
		}
	
	
	
	driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	driver.findElement(By.id("txtPassword")).sendKeys("Qedge123!@#");
	driver.findElement(By.id("btnLogin")).click();
	
	String titurl=driver.getCurrentUrl();
	System.out.println(titurl);
	if(titurl.equals("http://orangehrm.qedgetech.com/symfony/web/index.php/dashboard")) {
		System.out.println(titurl +"->URL VERIFED-TEST PASS");
	}
	
	else {
		System.out.println(titname+"->URL VERIFED-TEST FAIL");
	}
	
	driver.findElement(By.linkText("PIM")).click();
	driver.findElement(By.id("menu_pim_addEmployee")).click();
	
	String empname=driver.findElement(By.xpath("//*[@id='employeeId']")).getAttribute("value");
	System.out.println(empname);
	
	if(empname.contains("2461")) {
		System.out.println(empname+"->Employee id--- Test Pass");
	}
	else {
		System.out.println(empname+"Employee id-----Test Fail");
	}
		
	driver.findElement(By.linkText("Welcome Suresh")).click();
	driver.findElement(By.linkText("Logout")).click();
	
	   //isdisplayed(driver);
	   OrangehrmTest.isdisplayed(driver);
			
			/*WebElement ele=driver.findElement(By.xpath("//*[@id='divLogo']/img"));
			Assert.assertTrue(ele.isDisplayed());
			System.out.println("LOGO IS DISPLAYED");
	*/
	       driver.close();
	
	}
	
	
	public static void isdisplayed(WebDriver driver) 
	{
		WebElement ele=driver.findElement(By.xpath("//*[@id='divLogo']/img"));
		System.out.println("IS  LOGO IS DISPLAYED OB THE APPLICATION? " +ele.isDisplayed());
		
	}

}
