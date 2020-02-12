package PART15.com.qa.brokenlinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_01_Handling_Brokenlinks {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://www.orangeone.in/");
		
		
		List<WebElement>alllinks=driver.findElements(By.tagName("a"));
		System.out.println(alllinks.size());
		 
		for(int i=0;i<alllinks.size();i++)
		{
			WebElement element=alllinks.get(i);
			String url=element.getAttribute("href");
			
		      URL link= new URL(url);
			
			//Create a connection using url object
			HttpURLConnection httpconn=(HttpURLConnection) link.openConnection();
			Thread.sleep(3000);
			
			//Establish the connection
			httpconn.connect();
			
			int rescode=httpconn.getResponseCode();
			if(rescode>=400) 
			{
				System.out.println(url +"->"+"IS BROKEN LINK");
			}
			else {
				System.out.println(url +"->"+"IS VALID LINK");
			}
			
			
		}
		driver.close();

	}

}
