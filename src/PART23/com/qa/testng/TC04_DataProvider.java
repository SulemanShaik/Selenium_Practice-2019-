package PART23.com.qa.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC04_DataProvider {

     @DataProvider
	public Object[][] testData()
	{
		Object[][] obj = new Object[5][2];
		
		obj[0][0]="user1";
		obj[0][1]="password";
		
		obj[1][0]="user2";
		obj[1][1]="password";
		
		obj[2][0]="user3";
		obj[2][1]="password";
		
		obj[3][0]="user4";
		obj[3][1]="password";
		
		obj[4][0]="user5";
		obj[4][1]="password";
		
		
		
		return obj;
		
		
		
	}
	
     @Test(dataProvider="testData")
	public void test(String username,String password) {
    	 System.out.println("Test Must be run in 5 times");
    	 System.out.println(username);
    	 System.out.println(password);
     }

}
