package PART24.com.qa.JavaScriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


       /*JavaScriptExecutor is an Interface which provides mechanism to execute javaScript
		through selenium driver*/
		
		
		//Actions we can perform using javaScript Executor
		
	/*  Flashing an element
		Drawing a boarder around the element
		capture the title of the page
		click in some element
		Generate alert info 
		Refresh the page
		Scrolling the page
		*/
		
         

		/*public  static void flash(WebElement element,WebDriver driver)
		{
			String bgcolor=element.getCssValue("backgroundcolor");  //white
			
			
			for(int i=0;i<500;i++) {
			changeColor()
				
			}
		}
		
		     public static void changeColor(String color, WebElement element, WebDriver driver) {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.backgroundcolor= '" + color + "'", element);
			
			
			try {
				Thread.sleep(20);
			}catch(InterruptedException e) {		
			}
		 
		}
		
	}*/


           public class JavaScriptUtil {
		
		public static void drawBorder(WebElement element, WebDriver driver) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].style.border='3px solid red'", element);
			
		}
		
		
		public static String getTitleJsScript(WebDriver driver)
		{
			JavascriptExecutor js=((JavascriptExecutor) driver);
			String title=js.executeScript("return document.title;").toString();
			
			return title;
			
		}
          
		 public static void clickElementByJS(WebElement element, WebDriver driver) {
			 JavascriptExecutor js = ((JavascriptExecutor) driver);
			 js.executeScript("arguments[0].click()", element);
		 }
		 
		 public static void generateAlertByJS(WebElement element, WebDriver driver) {
			 JavascriptExecutor js = ((JavascriptExecutor) driver);
			 //js.executeScript("alert('" + message +"')");
		 }
		 
		
		 public static void refreshPageByJS(WebDriver driver) {
			 JavascriptExecutor js = ((JavascriptExecutor) driver);
			 js.executeScript("history.go(0)");
		 }
		 
		 
		 public static void scrollIntoView(WebElement element, WebDriver driver) {
			 JavascriptExecutor js = ((JavascriptExecutor) driver);
			 js.executeScript("arguments[0].scrollIntoView(true)",element);
		 }
		 
		 
		 
}

