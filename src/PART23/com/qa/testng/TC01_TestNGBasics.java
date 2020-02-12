package PART23.com.qa.testng;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



//Pre conditions starting with @Before
/*@Suite
@BeforeClass
@BeforeTest
@BeforeMethod*/


//Testcases starting with @Test 
 
//@Test


/*
 * //Post conditions starting with @After
 * @AfterMethod
 * @AfterTest
 * @AfterClass
 *
 * 
*/

//Testing pattern

/*@BeforeMethod
@Test
@AfterMethod*/




public class TC01_TestNGBasics {
	
	        @BeforeMethod
            public void setUp() {
            	System.out.println("This is set up method");
            	
            }
            
	         
	         @Test
            public void login() {
            	System.out.println("login test successfully");
            }
            
            
            @AfterMethod
            public void tearDown() {
            	System.out.println("This is tearDown method");
            	
            }
            
            
            
            //Priority Base Test
            
            @Test(priority=2)
            public void setup1() {
            System.out.println("Send Mail Test");
            	
            }
            @Test(priority=1)
            public void Login1() {
            	System.out.println("Receive mail - mail Test");
            }
            
            
            
            //Skipping Method From Test Execution
            
            
            @Test
            public void a() {
            	System.out.println("Send Mail Test");
            }
            
            
            @Test(enabled=true)
            public void b() {
            	System.out.println("Receive Mail  Mail Test-2");
            }
            
            @Test(enabled=false)
            public void c() {
            	System.out.println("Receive Mail  Mail Test-3");
            }
            
            @Test(enabled=true)
            public void d() {
            	System.out.println("Receive Mail  Mail Test-4");
            }
            
            @Test(enabled=false)
            public void e() {
            	System.out.println("Receive Mail  Mail Test-5");
            }
            
            
            
            
            
}
