package PART04.com.qa.verifyinglinks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC02_Handling_VerifyingCityPresentorNot 
{
            public static void main(String[] args) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			     WebDriver driver=new ChromeDriver();
			     driver.manage().window().maximize();
			     driver.manage().deleteAllCookies();
			     driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			     driver.get("https://www.redbus.in");
			     System.out.println(driver.getTitle());
			     List<WebElement>totallink=driver.findElements(By.tagName("a"));
			     System.out.println(totallink.size());
			     String explink,actlink;
			     explink="Singapore";
			     Boolean linkexist=false;
			     for (int i = 0; i <totallink.size(); i++)
			     {
					actlink=totallink.get(i).getText();
					if(explink.contains(actlink))
					{
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
