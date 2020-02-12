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

public class TC02_Handling_BrokenLinksAndImages {

	public static void main(String[] args) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.thesocialtie.in/");
		
		List<WebElement>alllinks=driver.findElements(By.tagName("img"));
		System.out.println(alllinks.size());
		
	for(int i=0;i<alllinks.size();i++)
	{
		String url=alllinks.get(i).getAttribute("src");
		
		URL link=new URL(url);
		
		//Create a connection using url object
		
		HttpURLConnection httpconn= (HttpURLConnection) link.openConnection();
		
		Thread.sleep(3000);
		
		//Establish the connection
		httpconn.connect();
		
		int rescode=httpconn.getResponseCode();
		if(rescode!=200) 
		{
			
				System.out.println(url +"->"+"IS BROKEN IMAGE");
		     }
			else {
				System.out.println(url +"->"+"IS VALID IMAGE");
			}
			
			
			
		}
		
		
		
	}

		
	}


