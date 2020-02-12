package PART08.com.qa.dropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC04_Handling_Dropdown {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://primusbank.qedgetech.com/");
        
        Select blist = new Select(driver.findElement(By.id("drlist")));
        //blist.selectByValue("srnagar");//SELECTING A VALUE
        
        //COUNT NO OF ITEMS AND DISPLAY
        List<WebElement>branches=blist.getOptions();
        String str1,str2;
        boolean ordered=true;
        String expvalue,actvalue;
        expvalue="srnagar09098";
        boolean brexist=false;
        System.out.println("TOTAL NUMBER OF BRANCHES->" +branches.size());
        for (int i = 1; i < branches.size(); i++) {
        	System.out.println("TOTAL BRANCHES NAMES ARE->"+branches.get(i).getText());
        	actvalue=branches.get(i).getText();
        	if(expvalue.contains(actvalue)) {
        		brexist=true;
        		break;
        	}
			
		}
        
        if(brexist) {
        	System.out.println(expvalue+"->EXPECTED VALUE IS PRESENT,TEST PASS");
        }else {
        	System.out.println(expvalue+"->EXPECTED VALUE IS NOT PRESENT,TEST FAIL");
        }
        //verifing order or not
        for (int i = 2; i < branches.size(); i++) {
        	str1=branches.get(i-1).getText();
        	str2=branches.get(i).getText();
        	if(str2.compareTo(str1)<0) {
        		ordered=false;
        		break;
        	}
			
		}
        if(ordered) {
        	System.out.println("VALUES ARE IN ORDER,TEST PASS");
        }else {
        	System.out.println("VALUES ARE NOT IN ORDER,TEST FAIL");
        }
        	driver.close();
	}

}
