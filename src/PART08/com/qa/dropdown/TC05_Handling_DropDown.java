package PART08.com.qa.dropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC05_Handling_DropDown {

	public static void main(String[] args) {
            
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.manage().deleteAllCookies();
	        driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        driver.get("http://primusbank.qedgetech.com/");
	        
	        Select sel = new Select(driver.findElement(By.xpath("//*[@id='drlist']")));
	         // sel.selectByValue("ameerpett");//Selecting a value
	        //PRinting All Values
	       /* List<WebElement>seldrop=sel.getOptions();
	       for(int i=1;i<seldrop.size();i++)
	       {
	    	    System.out.println(seldrop.get(i).getText());
	    	
	       }*/
	        
	        //Verifying 
	       /*String actvalue,expvalue;
	       boolean flag= false;
	       expvalue="ameerpett123456";
	        
	       List<WebElement>seldrop=sel.getOptions();
	       for(int i=1;i<seldrop.size();i++)
	       {
	    	   actvalue=seldrop.get(i).getText();
	    	   if(actvalue.contains(expvalue)) 
	    	   {
	    		   flag=true;
	    		   break;
	    	   }
	    	
	       }
	       if(flag) 
	       {
	    	   System.out.println(expvalue+"is present");
	       }else {
	    	   System.out.println(expvalue+"is  not present");
	       }
	        
	        */
	        
	        //Verifying order or not
	        
	        String str1,str2;
	        boolean ordered=true;
	        
	        List<WebElement>seldrop=sel.getOptions();
		       for(int i=1;i<seldrop.size();i++) {
		    	   str1=seldrop.get(i).getText();
		    	   str2=seldrop.get(i).getText();
		    	   
		    	   if(str1.compareToIgnoreCase(str2)<0) {
		    		   ordered= false;
		    		   break;
		    	   }
		       }
		       if(ordered) {
		    	   System.out.println("list is ordered");
		    	   }
		    	   else {
		    		   
		    		   System.out.println("list is not ordered");
		    	   
		       }
	        
	}

}
