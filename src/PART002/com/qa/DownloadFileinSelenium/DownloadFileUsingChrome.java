package PART002.com.qa.DownloadFileinSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DownloadFileUsingChrome {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
           driver.manage().window().maximize();
           driver.manage().deleteAllCookies();
           driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
           driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
           
           driver.get("http://demo.automationtesting.in/FileDownload.html");
           //Download a TextFile
           
           driver.findElement(By.id("textbox")).sendKeys("Testing Text File");
           driver.findElement(By.id("createTxt")).click(); //Generate Button
           driver.findElement(By.id("link-to-download")).click();  //click on Download link
           
           //Download Pdf File
           
           driver.findElement(By.id("pdfbox")).sendKeys("Testing PDF File");
           driver.findElement(By.id("createPdf")).click();  //Generate Button
           driver.findElement(By.id("pdf-link-to-download")).click();   //click on Download link
            
           
		
	}

}
