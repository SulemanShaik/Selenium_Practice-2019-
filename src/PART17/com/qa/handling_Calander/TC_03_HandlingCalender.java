package PART17.com.qa.handling_Calander;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TC_03_HandlingCalender {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
           driver.manage().window().maximize();
           driver.manage().deleteAllCookies();
           driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
           driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
           
           driver.get("https://www.redbus.in/");
           
           driver.findElement(By.xpath("//label[@class='db text-trans-uc']")).click();
		 
           String month="Oct 2020";
           String exp_date="20";
           
           while(true) {
        	   
        	   String text=driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[1]/td[2]")).getText();
        	   
        	   if(text.equals(month)) {
        		   break;
        	   }
        	   else {
        		   driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[1]/td[3]/button")).click();
        		  
        	   }
        	 
           }
           
           
           List<WebElement>montsize=driver.findElements(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr/td"));
           
           System.out.println(montsize.size());
           
           for(WebElement ele:montsize)
           {
        	  String  date_text=ele.getText();
        	  if(date_text.equals(exp_date))
        	  {
        		  System.out.println(exp_date+" "+month);
        		  ele.click();
        		  Thread.sleep(3000);
        	      break;
                 }
        	}
           driver.close();
	
           }
	}

