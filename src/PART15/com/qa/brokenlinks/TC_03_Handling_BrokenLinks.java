package PART15.com.qa.brokenlinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_03_Handling_BrokenLinks {
	public static void main(String[] args) throws IOException {
		
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://delaplex.com/");
		
		List<WebElement>alllinks=driver.findElements(By.tagName("a"));
		System.out.println(alllinks.size());
		
		for(int i=0;i<alllinks.size();i++)
		{
			String url=alllinks.get(i).getAttribute("href");
			
			URL link = new URL(url);
			
			HttpURLConnection http=(HttpURLConnection) link.openConnection();
			http.connect();
			
			int rescode=http.getResponseCode();
			
			if(rescode>=400)
			{
				System.out.println(url+"-> "+"IS BROKEN LINK");
			}else {
				System.out.println(url+"->"+"VALID LINK");
			}
		}
		
		
		
	}

}
