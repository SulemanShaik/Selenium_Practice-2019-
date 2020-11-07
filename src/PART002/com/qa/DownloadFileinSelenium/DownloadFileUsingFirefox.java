package PART002.com.qa.DownloadFileinSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DownloadFileUsingFirefox {

	public static void main(String[] args) {
		
		//Additional Settings for firefox browser

		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain,application/pdf");  //mime type
		profile.setPreference("browser.download.manager.showWhenStarting",false );
		profile.setPreference("pdfjs.disabled",true );  //only for pdf file
		
		FirefoxOptions option = new FirefoxOptions();
		option.setProfile(profile);
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver(option);
           driver.manage().window().maximize();
           driver.manage().deleteAllCookies();
           driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
           driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
           
           driver.get("http://demo.automationtesting.in/FileDownload.html");
           //Download  TextFile
           
           driver.findElement(By.id("textbox")).sendKeys("Testing Text File");
           driver.findElement(By.id("createTxt")).click(); //Generate Button
           driver.findElement(By.id("link-to-download")).click();  //click on Download link
           
           //Download Pdf File
           
           driver.findElement(By.id("pdfbox")).sendKeys("Testing PDF File");
           driver.findElement(By.id("createPdf")).click();  //Generate Button
           driver.findElement(By.id("pdf-link-to-download")).click();   //click on Download link
            
           
		
		
	}

}
