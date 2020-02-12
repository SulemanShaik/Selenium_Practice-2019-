package PART08.com.qa.dropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01_Handling_DropDown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		 driver.get("https://www.wikipedia.org/");
		 System.out.println("TITLE OF THE PAGE  "+driver.getTitle());
		 
		 //SELECTING A VALUE
		 /*WebElement value=driver.findElement(By.id("searchLanguage"));
		 Select dropdown = new Select(value);	
		 dropdown.selectByVisibleText("Dansk");
		 dropdown.selectByValue("hi");*/
		 
		 //0-size-1(62-1)=61 
		 
		List<WebElement> values=driver.findElements(By.tagName("option"));
		System.out.println("TOTAL VALUES ARE " +values.size());
		System.out.println(values.get(12).getText());
		for(int i=0;i<values.size();i++)
		{
			System.out.println(values.get(i).getText());
		}
		
		
		driver.close();
		 
		 

	}

}
