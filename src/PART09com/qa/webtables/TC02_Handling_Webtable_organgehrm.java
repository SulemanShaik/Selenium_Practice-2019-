package PART09com.qa.webtables;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC02_Handling_Webtable_organgehrm {
	public static void main(String []args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		 driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		 driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		 driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		 driver.findElement(By.id("btnLogin")).click();
		 System.out.println("CURRENT URL OF THE PAGE  "+driver.getCurrentUrl());
		 
		 driver.findElement(By.id("menu_pim_viewPimModule")).click();
		 driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
		 
		 int rowcount=driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr")).size();
		 System.out.println("THE NUMBER ROWS ARE PRESENT  "+rowcount);
		 
		 int colcount=driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr[1]/td")).size();
		 System.out.println("THE NUMBER COLUMNs ARE PRESENT  "+colcount);
		 
		 for(int i=1;i<=rowcount;i++) { //Reads values for row
		 
			for(int j=1;j<=colcount;j++) {  //Reads values for columns
				
				
				System.out.print(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr["+i+"]/td["+j+"]")).getText());
			}
			System.out.println();
		 }
		 driver.close();
	}
}


