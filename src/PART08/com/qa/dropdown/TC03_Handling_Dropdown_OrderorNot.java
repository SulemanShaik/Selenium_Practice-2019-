package PART08.com.qa.dropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC03_Handling_Dropdown_OrderorNot {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        driver.get("https://www.wikipedia.org/");
        Select sel = new Select(driver.findElement(By.id("searchLanguage")));
        List<WebElement>dropdownvalues=sel.getOptions();
        String str1,str2;
        boolean ordered = true;
        for(int i=0;i<dropdownvalues.size();i++) {
        	str1=dropdownvalues.get(i).getText();
        	str2 = dropdownvalues.get(i).getText();
        	if(str2.compareToIgnoreCase(str1)<0) {
        		ordered=false;
        		break;
        	}
        }
		
		if(ordered) {
			System.out.println("VALUES ARE IN ORDER,TEST PASS");
		}
		else {
			System.out.println("VALUES ARE IN ORDER,TEST FAIL");
		}
		

	}

}
