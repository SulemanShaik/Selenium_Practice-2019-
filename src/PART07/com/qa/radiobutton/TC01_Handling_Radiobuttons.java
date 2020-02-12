package PART07.com.qa.radiobutton;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TC01_Handling_Radiobuttons {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		ChromeOptions option= new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		WebDriver driver = new ChromeDriver(option);
        driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.cleartrip.com/");
		//driver.findElement(By.id("RoundTrip")).click();//selecting Radio Button
	
		/*if(driver.findElement(By.id("OneWay")).isSelected())//checking Radio Button is selected or not
			
		{
			System.out.println("Test pass");
		}
		else {
			System.out.println("Test Fail");
		}*/
		//driver.findElements(By.xpath("//input[@type='radio']));we can use this xpath also
		
		List<WebElement>totalbuttons=driver.findElements(By.xpath("/html[1]/body[1]/section[2]/div[1]/div[1]/div[1]/form[1]/nav[1]/ul[1]/li/label[1]/input[1]"));
	
		System.out.println(totalbuttons.size());
		String actval,expval;
		expval="RoundTrip";
		boolean brexist=false;
		
		for(int i=0;i<totalbuttons.size();i++) 
		{
		     //String buttonnames=totalbuttons.get(i).getAttribute("value");	
		     //System.out.println(buttonnames);
			actval=totalbuttons.get(i).getAttribute("value");
			if(actval.contains(expval)) 
			{
				brexist=true;
				break;
			}
		}
		
		if(brexist) {
			System.out.println("TEST PASS AND EXPECTED VALUE IS  "+expval);
		}
		else
		{
			System.out.println("TEST FAIL AND EXPECTED VALUE IS  "+expval);
		}
		driver.close();
		
		
	}

}
