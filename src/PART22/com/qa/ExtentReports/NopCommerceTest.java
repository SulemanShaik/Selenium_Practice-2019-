package PART22.com.qa.ExtentReports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class NopCommerceTest {
	
	public WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	
	    

          @BeforeTest   
	      public void setExtent() 
	      {
	    	 
        	htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/myReport.html");
        	
        	htmlReporter.config().setDocumentTitle("Automation Report");   //Title of the report
        	htmlReporter.config().setReportName("Funtional Report");    //Name of the Report
        	htmlReporter.config().setTheme(Theme.DARK);
        	
        	extent= new ExtentReports();
        	extent.attachReporter(htmlReporter);
        	
        	extent.setSystemInfo("HostName", "Localhost");
        	extent.setSystemInfo("OS", "Windows8");
        	extent.setSystemInfo("TesterName", "Suleman");
        	extent.setSystemInfo("Browser", "Chrome");
        	
	      }
          
          
          @AfterTest
        	public void endReport()
        	{
        		
        		extent.flush();
        		
        	}
        	
        	  @BeforeMethod
        	  public void setUp()
        	  {
        		  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
        			WebDriver driver=new ChromeDriver();
        			driver.manage().window().maximize();
        			driver.manage().deleteAllCookies();
        			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        			
        			driver.get("https://www.nopcommerce.com/");
        	  }
        	  
	      @Test
	      public void nopCommercetitleTest()
	      {
	    	 extent.createTest("nopCommercetitleTest") ;
	    	 String title=driver.getTitle();
	    	 Assert.assertEquals(title, "Free and open-source eCommerce platform. ASP.NET based shopping cart. - nopCommerce");
	    	  
	    	  
	      }
	       @Test
	        public void nopCommercelogotest()
	        {
	        	extent.createTest("nopCommercelogotest");
	        	Boolean status=driver.findElement(By.xpath("//a[@class='desktop-logo']//img")).isDisplayed();
	            Assert.assertTrue(status);
	        }
	        @Test
	        public void nopCommercelogintest()
	        {
	        
	        	extent.createTest("nopCommercelogintest");
	        	Assert.assertTrue(true);
	        }
		
	        
	        @AfterMethod
		  public void tearDown(ITestResult result) throws IOException
		  {
			 
			  if(result.getStatus()==ITestResult.FAILURE)
			  {
				  test.log(Status.FAIL, "TEST CASE FAILED IS"+result.getName());        //to add name in extent report
				  test.log(Status.FAIL, "TEST CASE FAILED IS"+result.getThrowable());   //to add exception/error in extent report
				  
				  String screenshotpath=NopCommerceTest.getScreenshot(driver,result.getName());
				  
				           test.addScreenCaptureFromPath(screenshotpath); //adding screenshot
			   }                   
				           
			     else if(result.getStatus()==ITestResult.SKIP)
			     {
			    	 test.log(Status.SKIP, "TEST CASE SKIPPED IS"+result.getName());  
			     }
			  
			     else if(result.getStatus()==ITestResult.SUCCESS) 
			     {
			    	 test.log(Status.PASS, "TEST CASE SUCCESS IS"+result.getName());  
			     }
			  driver.quit();
		  }
		  
		    public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException
		    {
		    	String dateName= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		    	
		    	TakesScreenshot ts= (TakesScreenshot) driver;
		    	File source = ts.getScreenshotAs(OutputType.FILE);
		    	
		    	String destination=System.getProperty("user.dir")+"\\Screenshots" + screenshotName + dateName +".png";
		    	
		    	File finalDestination = new File(destination);
		    	FileUtils.copyFile(source, finalDestination);
		    	return destination;
		    }
		    
		  
	}


