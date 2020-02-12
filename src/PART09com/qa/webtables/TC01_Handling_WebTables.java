package PART09com.qa.webtables;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01_Handling_WebTables {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        driver.get("F:\\My Web Page\\webtabledata.html");
        
        //ROW SIZE
         int rowcount=driver.findElements(By.xpath("/html/body/table/tbody/tr")).size();
         System.out.println("TOTAL NO OF ROWS->"+rowcount);
         
         //COLUMN SIZE
         int colcount=driver.findElements(By.xpath("/html/body/table/tbody/tr[1]/td")).size();
         System.out.println("TOTAL NO OF COLS->"+colcount);
         for(int i=1;i<rowcount;i++)      //READS ROW DATA
         {
        	for(int j=1;j<colcount;j++) //READS COLUMNS DATA
        	{
        	System.out.print(driver.findElement(By.xpath("/html/body/table/tbody/tr["+i+"]/td["+j+"]")).getText()+" ");
        	}
        	System.out.println();
         }
         
         driver.close();
        
        
}
}
