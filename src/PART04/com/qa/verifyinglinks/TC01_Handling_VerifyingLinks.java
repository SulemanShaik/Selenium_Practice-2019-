package PART04.com.qa.verifyinglinks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01_Handling_VerifyingLinks
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		 ChromeDriver driver = new ChromeDriver ();
         driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.get("http://www.orangeone.in/");
		  List<WebElement> totallinks=driver.findElements(By.tagName("a"));
		  System.out.println("the total no. of links present in orangeone information system:  "  + totallinks.size());
		  String actlink,explink;
		  explink="Software Testing";
		  boolean linkexist=false;
		  for (int i = 0; i < totallinks.size(); i++) {
			  actlink=totallinks.get(i).getText();
			  if(explink.equalsIgnoreCase(actlink)) {
				  linkexist=true;
				  break;
			  }
			  
		  }
		  if (linkexist) 
		    {
		    	System.out.println("EXPECTED LINK "+explink+" IS PRESENT");
		    	System.out.println("TEST PASS");
				
			} else
			{
				System.out.println("EXPECTED LINK "+explink+" IS NOT PRESENT");
		    	System.out.println("TEST FAIL");
			}
		  driver.close();
		  
	}
}


