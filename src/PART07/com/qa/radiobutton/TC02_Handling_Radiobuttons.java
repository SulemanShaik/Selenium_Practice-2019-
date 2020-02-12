package PART07.com.qa.radiobutton;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC02_Handling_Radiobuttons {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
         WebDriver driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().deleteAllCookies();
         driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
          
         driver.get("http://www.tizag.com/htmlT/htmlradio.php");
         System.out.println(driver.getCurrentUrl());
         //driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]/input[2]")).click();
         //System.out.println((driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]/input[2]")).isSelected()));
        
        		 List<WebElement>totalradiobutt=driver.findElements(By.xpath("//input[@type='radio']"));
         System.out.println(totalradiobutt.size());
         for(int i=0;i<totalradiobutt.size();i++)
         {
             String radiobutnames=totalradiobutt.get(i).getAttribute("name");
             System.out.println(radiobutnames);
         }
        driver.close();
         
	
 }

}