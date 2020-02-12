package PART08.com.qa.dropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC02_Handling_DropDown_Verifying {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
         WebDriver driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().deleteAllCookies();
         driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         
         driver.get("https://www.wikipedia.org/");
         
         Select dropdown = new Select(driver.findElement(By.id("searchLanguage")));
         List <WebElement>dropdownvalues=dropdown.getOptions();
         System.out.println(dropdownvalues.size());
         
         //Printing all values 
         /*for(int i=0;i<dropdownvalues.size();i++) {
        	 System.out.println(dropdownvalues.get(i).getText());
         }*/
         
         String expvalue,actvalue;
         expvalue="Dansk";
         boolean brexist=false;
        for (int i = 0; i < dropdownvalues.size(); i++)
        {
        	actvalue=dropdownvalues.get(i).getText();
        	if(expvalue.contains(actvalue))
        	{
        		brexist= true;
        		break;
         	}
		}
         if(brexist)
         {
        	 System.out.println(expvalue+"  EXPECTED VALUE IS PRESENT,TEST PASS");
         }else
         {
        	 System.out.println(expvalue+"  EXPECTED VALUE IS PRESENT,TEST FAIL");
         }
         
         
         
         
         
         
         
         driver.close();
         
         
	}

}
