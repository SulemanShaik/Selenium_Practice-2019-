package PART03.com.qa.handlinglinks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC04_Handling_Links {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://www.orangeone.in/");
		Assert.assertEquals(driver.getTitle(), "Orangeone information system");
		
		List<WebElement>ele=driver.findElements(By.tagName("a"));
		System.out.println(ele.size());
		/*for(int i=0;i<ele.size();i++)
		{
			System.out.println(ele.get(i).getText());//print all data
		}
		*/
		
		//Verifying particular link is present or not
		
		   String actvalue,expvalue;
		   expvalue="E-Commerce123";
		   boolean  brexist=false;
		   
		   for(int i=0;i<ele.size();i++) 
		   {
			    actvalue=ele.get(i).getText();
			    if(actvalue.contains(expvalue))
			    {
			    	brexist=true;
			    	break;
			    }
			    
		   }
		 
		 if(brexist)
		 {
			 System.out.println(expvalue+ "The Expected value is present");
		 }else {
			 System.out.println(expvalue+ "The Expected value is not present");
		 }

		driver.close();
		
		
	}

}
