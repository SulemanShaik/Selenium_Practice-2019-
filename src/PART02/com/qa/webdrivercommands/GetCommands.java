package PART02.com.qa.webdrivercommands;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetCommands {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "F:\\Selenium Softwares\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver", "F:\\Selenium Softwares\\BOWSER_DRIVERS\\geckodriver.exe");
		 WebDriver driver=new FirefoxDriver();
         driver.manage().window().maximize();
         driver.manage().deleteAllCookies();
         driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
         driver.get("https://www.qaautomation.co.in/");
         System.out.println(driver.getCurrentUrl());
         System.out.println(driver.getTitle());
         String text=driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/div/div[1]/div/ul/li[3]/span")).getText();
          System.out.println(text);
          driver.close();    //close  current/one  window
          //driver.quit();    //closes multiple windows
            
            
	}

}
