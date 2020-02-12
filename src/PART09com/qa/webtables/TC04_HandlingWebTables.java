package PART09com.qa.webtables;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TC04_HandlingWebTables {

	public static void main(String[] args) {
         
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		 
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("F:\\My Web Page\\handlingwebtable.html");
		
		//Row Size
		
		int rcount=driver.findElements(By.xpath("/html/body/table/tbody/tr")).size();
		System.out.println("NO OF ROWS ARE->"+rcount);
		
		//COL Size
		int ccount=driver.findElements(By.xpath("/html/body/table/tbody/tr[4]/td")).size();
		System.out.println("NO OF COLS ARE->"+ccount);
   
		
		for (int i=2;i<=rcount;i++)  //READ ROW i=2 not required th
		{
			for(int j=1;j<=ccount;j++)  //READ COL
			{
				System.out.print(driver.findElement(By.xpath("/html/body/table/tbody/tr["+i+"]/td["+j+"]")).getText());
			}
			System.out.println();
		}
		
		driver.close();
	}

}
