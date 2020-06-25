package com.qa.isdisplayedisselectedisenabled;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC02_Handling_isdisplayed_isselected_isenabled {

	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		/*driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		//1.isDisplayed
		Boolean b1=driver.findElement(By.id("btnLogin")).isDisplayed();
		System.out.println(b1);
		
		//2.isEnabled()
		Boolean b2=driver.findElement(By.id("btnLogin")).isEnabled();
		System.out.println(b2);		
		*/
		/*//select i agree checkbox
		driver.findElement(By.name("")).click();// --submit button is enables now
		Boolean b3=driver.findElement(By.id("")).isEnabled();
		System.out.println(b3); //true
*/
	  //3.isSelected() is applicable for checkbox, radiobutton, dropdown
		
		
		
		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		

		 driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]/input[3]")).click();
		
		Boolean b5=driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]/input[3]")).isSelected();
		
		     System.out.println(b5);  // True
		     
		     System.out.println(driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]/input[1]")).isSelected());//false
	}
	

	
	
	
	
}
