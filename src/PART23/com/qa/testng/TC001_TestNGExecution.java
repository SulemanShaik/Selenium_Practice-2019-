package PART23.com.qa.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


//Verify the output.

/*in beforeSuite
in beforeTest
in beforeClass
in beforeMethod
in test case 1
in afterMethod
in beforeMethod
in test case 2
in afterMethod
in afterClass
in afterTest
in afterSuite*/

public class TC001_TestNGExecution {
	
	
	@BeforeSuite
	public void test1() 
	{
		System.out.println("@Before Suite");
	}
	
	@BeforeTest
	public void test2() 
	{
		System.out.println("@Before Test");
	}

	@BeforeClass
	public void test3() 
	{
		System.out.println("@Before Class");
	}
	
	@BeforeMethod
	public void test4() 
	{
		System.out.println("@Before Method");
	}
	
	@Test
	public void test5() 
	{
		System.out.println("TestCase1");
	}
	
	@Test
	public void test10() 
	{
		System.out.println("Testcase2");
	}
	
	@AfterSuite
	public void test6() 
	{
		System.out.println("@After Suite");
	}
	
	@AfterTest
	public void test7() 
	{
		System.out.println("@After Test");
	}
	
	@AfterClass
	public void test8() 
	{
		System.out.println("@After Class");
	}
	
	@AfterMethod
	public void test9() 
	{
		System.out.println("@After method");
	}
	
	
	
	
	
}
