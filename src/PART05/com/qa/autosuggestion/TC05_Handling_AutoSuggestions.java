package PART05.com.qa.autosuggestion;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC05_Handling_AutoSuggestions {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe" );
		
		         WebDriver driver = new ChromeDriver();
		         
		        driver.manage().window().maximize();
		 		driver.manage().deleteAllCookies();
		 		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		 		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 		
		 		driver.get("https://www.google.co.in/");
		 		Assert.assertEquals(driver.getTitle(), "Google");
		 		driver.findElement(By.name("q")).sendKeys("ind");
		 		
		 		List<WebElement>totalcount=driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[4]/form[1]/div[2]/div[1]/div[2]/div[2]/ul[1]/li/div[1]/div[2]/div[1]"));
		 		System.out.println(totalcount.size());
		 		
		 		/*for(int i=0;i<totalcount.size();i++)
		 		{
		 			System.out.println(totalcount.get(i).getText());
		 		}
		 		driver.close();*/
		 		
		 		//Verifying the value there or not
		 		
		 		String expvalue,actvalue;
		 		expvalue="indeed";
		 		boolean flag=false;
		 		
		 		for(int i=0;i<totalcount.size();i++)
		 		{
		 			actvalue=totalcount.get(i).getText();
		 			if(actvalue.contains(expvalue))
		 			{
		 				flag=true;
		 				break;
		 			}
		 		}
		
		       if(flag) {
		    	   System.out.println(expvalue+" is present");
		       }else {
		    	   System.out.println(expvalue+" is not present");
		       }
	} 

}
