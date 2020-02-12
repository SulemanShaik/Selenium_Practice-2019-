package PART17.com.qa.handling_Calander;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TC02_HandlingCalender {

	public static void main(String[] args) {
		ChromeOptions options= new ChromeOptions();
		options.addArguments("-disable-notifications");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        driver.get("https://www.irctc.co.in/nget/train-search");
        driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-main-page/div[1]/div/div[1]/div/div/div[1]/div/app-jp-input/div[3]/form/div[3]/p-calendar/span/button/span[1]")).click();
       
        String expmonth="December2019";
        String expdate="21";
        
        while(true) {
        String text=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
        
        if(text.equals(expmonth)) 
        {
        	break;
        }
        else
        {
        	driver.findElement(By.xpath("//span[@class='fa fa-angle-right']")).click();
        }
	}
List<WebElement> alldates=driver.findElements(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[2]/div[1]/app-main-page[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-jp-input[1]/div[3]/form[1]/div[3]/p-calendar[1]/span[1]/div[1]/table[1]/tbody[1]/tr/td/a"));
        
        
        for(WebElement ele:alldates) {
        	
        	String date_text=ele.getText();
        	if(date_text.equals(expdate)) {
        		ele.click();
        		System.out.println("SELECTED DATE IS->"+expdate+expmonth);
        		break;
        		
        	}
        }
        driver.close();
	}
}
