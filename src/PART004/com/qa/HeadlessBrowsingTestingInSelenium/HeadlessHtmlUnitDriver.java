package PART004.com.qa.HeadlessBrowsingTestingInSelenium;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HeadlessHtmlUnitDriver {

	public static void main(String[] args) {

		HtmlUnitDriver  driver = new HtmlUnitDriver ();
		
		driver.get("https://www.facebook.com/");
		System.out.println("Title of the page :"+driver.getTitle());
		System.out.println("Current url of the page:"+driver.getCurrentUrl());
		
		
	}

}