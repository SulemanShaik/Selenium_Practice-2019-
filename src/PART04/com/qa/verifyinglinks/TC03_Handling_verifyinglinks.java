package PART04.com.qa.verifyinglinks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC03_Handling_verifyinglinks {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
	     WebDriver driver=new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.manage().deleteAllCookies();
	     driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	     
	     driver.get("https://colaninfotech.com/");
	     System.out.println(driver.getTitle());
	     
	     List<WebElement>totallinks=driver.findElements(By.tagName("a"));
	     System.out.println(totallinks.size());
	     String explink,actlink;
	     explink="BLOCKCHAIN";
	     boolean linkexist=false;
	     for (int i = 0; i < totallinks.size(); i++)
	     {
			actlink=totallinks.get(i).getText();
			if(actlink.contains(explink))
			{
			linkexist=true;
			break;	
		 }
	     }
	     
	     if(linkexist)
	     {
	    	 System.out.println("EXPECTED LINK IS "+explink+" TEST PASS");
	     }
	     else {
	    	 System.out.println("EXPECTED LINK IS "+ explink+"  TEST FAIL");
	     }
	     
	     driver.close();
	     
	
	}
}
