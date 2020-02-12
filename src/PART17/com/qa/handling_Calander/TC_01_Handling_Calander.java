package PART17.com.qa.handling_Calander;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
	

public class TC_01_Handling_Calander {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
           driver.manage().window().maximize();
           driver.manage().deleteAllCookies();
           driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
           driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
           
           driver.get("https://www.spicejet.com/");
           
           driver.findElement(By.xpath("//*[@id=\"flightSearchContainer\"]/div[4]/button")).click();
           
           String month="December 2019";
           String exp_date="31";
           
           while(true)
           {
        	   String text=(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/div")).getText());
        	   if(text.equals(month)) {
        		   break;
        	   }
        	   else
        	   {
        		   driver.findElement(By.xpath("//*[@class='ui-datepicker-next ui-corner-all']")).click();
        	   }
        	   
        	   
           }
           List<WebElement>alldates=driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr/td/a"));
           System.out.println("SIZE OF THE MONTH"  +alldates.size());
           
           for(WebElement ele:alldates) {
    	   
    	   String date_text= ele.getText();
    	   
    	  //String date[]= date_text.split("/n");
    	  if(date_text.equals(exp_date)) 
    	  {
    		  ele.click();
    		  System.out.println(exp_date+" "+month);
    		  break;
    	  }
            
	}
	}
}

