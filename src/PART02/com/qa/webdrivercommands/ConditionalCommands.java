package PART02.com.qa.webdrivercommands;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConditionalCommands {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "F:\\Selenium Softwares\\BOWSER_DRIVERS\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com/");
        
        /*WebElement email=driver.findElement(By.id("email"));
        WebElement pass=driver.findElement(By.id("pass"));
        if(email.isDisplayed() && email.isEnabled())
        {
        	email.sendKeys("abc@gmail.com");
        }
        if(pass.isDisplayed() && pass.isEnabled())
        {
        	pass.sendKeys("abcxyz");
        }*/
        System.out.println(driver.findElement(By.id("u_0_5")).isSelected());//false-female
        System.out.println(driver.findElement(By.id("u_0_6")).isSelected());//false-male
        //select male radio button
        if(driver.findElement(By.id("u_0_6")).isSelected()==false)
        {
        	driver.findElement(By.id("u_0_6")).click();
        }
	}

}
