package PART09com.qa.webtables;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC03_Handling_WebTables_W3Schools {

	public static void main(String[] args)
	{ 
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	    driver.get("https://www.w3schools.com/html/html_tables.asp");
	    List<WebElement>rows=driver.findElements(By.xpath("//*[@id='customers']/tbody/tr"));
	    int rowcount=rows.size();
	    System.out.println("TOTAL NO OF ROWS: "+rowcount);
	    
	    System.out.println("COLUMN VALUES VALUES ARE:");
	    for(int i=2;i<=rowcount;i++) //Read values for ROW
	    {
	         WebElement element =driver.findElement(By.xpath("//*[@id='customers']/tbody/tr["+i+"]"));	
	         String rowtext=element.getText();
	         System.out.println(rowtext);
	         
	    }
	    List<WebElement>cols=driver.findElements(By.xpath("//*[@id='customers']/tbody/tr[1]/th"));
	    int colcount= cols.size();
	    
	    System.out.println("TOTAL NO OF ROWS:"+colcount);
	    System.out.println("ROWS VALUES ARE:");
	    
	    for(int j=1;j<=colcount;j++) {  //READ Values for Column
	    	WebElement element1=driver.findElement(By.xpath("//*[@id='customers']/tbody/tr[1]/th["+j+"]"));
	    	String coltext=element1.getText();
	    	System.out.println(coltext);
	    }
	    		
	   
	    
	   driver.close();
	
	}

}
