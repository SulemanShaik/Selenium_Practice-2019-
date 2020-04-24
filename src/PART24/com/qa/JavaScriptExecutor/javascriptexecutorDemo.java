package PART24.com.qa.JavaScriptExecutor;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class javascriptexecutorDemo {

	public static void main(String[] args) throws IOException {
		
	
		

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
           driver.manage().window().maximize();
           driver.manage().deleteAllCookies();
           driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
           driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
           driver.get("https://www.flipkart.com/");
           WebElement login =driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[3]/div/div/div/a"));
           
           //Drawing border and Screenshot
           JavaScriptUtil.drawBorder(login, driver);
             File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
             File tar=new File("F://ScreenShots/flipkart.png");
             FileUtils.copyFile(src,tar);
           
             //Capture the title of the page
             //System.out.println(driver.getTitle());
             
             System.out.println(JavaScriptUtil.getTitleJsScript(driver));
		
		    //Clicking on element
            
            // JavaScriptUtil.clickElementByJS( login,driver);
             
             //Generate alert not working properly
             //JavaScriptUtil.generateAlertByJS(driver,"You Clicked on Login button...");
             
             //Refresh page
             //driver.navigate().refresh();
             
             //JavaScriptUtil.refreshPageByJS(driver);
             
             //ScrollDown the page till we found element
             
             WebElement image=driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[4]/div/a/div/div/img[2]"));
             
             JavaScriptUtil.scrollIntoView(image, driver);
             
             
	}

}
