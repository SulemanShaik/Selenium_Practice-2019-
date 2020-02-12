package PART05.com.qa.autosuggestion;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TC03_Handling_AutoSuggestionVerify {

	public static void main(String[] args) {
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe" );
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.cleartrip.com/");
		driver.findElement(By.id("FromTag")).clear();
		driver.findElement(By.id("FromTag")).sendKeys("ban");
		
		List<WebElement>totalcities=driver.findElements(By.xpath("/html[1]/body[1]/ul[1]/li/a[1]"));
		System.out.println(totalcities.size());
		
		String actvalue,expvalue;
		boolean brexist=false;
		expvalue="Banak, NO - Banak (LKL)";
		for (int i = 0; i < totalcities.size(); i++)
		{
			actvalue=totalcities.get(i).getText();
			if(actvalue.contains(expvalue))
			{
				brexist=true;
				break;
			}
		}
		if(brexist) 
		{
			System.out.println("THE PRESENT CITY IS->  "+expvalue);
			System.out.println("TEST PASS");
		}
		else {
			System.out.println("THE PRESENT CITY IS->  "+expvalue);
			System.out.println("TEST FAIL");
		}
           driver.close();
	}

}
