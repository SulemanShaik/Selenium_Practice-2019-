package PART07.com.qa.radiobutton;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TC03_Handlings_RadioButtons {

	public static void main(String[] args) {
                  
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		ChromeOptions opt= new ChromeOptions();
		opt.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.cleartrip.com/");
		//driver.findElement(By.id("RoundTrip")).click();
		/*if(driver.findElement(By.id("OneWay")).isSelected()) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fail");
		}*/
		
		/*if(driver.findElement(By.id("OneWay")).isSelected()) {
			Assert.assertTrue(true);
		}*/
		
		List<WebElement>listcount=driver.findElements(By.xpath("/html[1]/body[1]/section[2]/div[1]/div[1]/div[1]/form[1]/nav[1]/ul[1]/li/label[1]/input[1]"));
		    System.out.println(listcount.size());
		    /*for(int i=0;i<listcount.size();i++)
		    {
		    	System.out.println(listcount.get(i).getAttribute("value"));
		    }
		    
		    driver.close();*/
		
		//Checking name is there or not
		    
		    String actvalue,expvalue;
		    
		    expvalue="OneWay";
		    boolean flag=false;
		    
		    for(int i=0; i<listcount.size(); i++)
		    {
		    	actvalue=listcount.get(i).getAttribute("value");
		    	if(actvalue.contains(expvalue))
		    	flag=true;
		    	break;
		    }
		    
		    if(flag) {
		    	System.out.println(expvalue+" is Present");
		    }else {
		    	
		    	System.out.println(expvalue+" is Not Present");
		    	
		    }
		
	
		
	}

}
