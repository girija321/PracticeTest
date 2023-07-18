package testNGpractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testDemo2 {
	
	
	@Test()jjjhjj
	public void loginTest() {
		System.out.println("tc1: login test");
	}
 @Test(dependsOnMethods= "loginTest")
	 public void addUserTest() {
		 System.out.println("tc2: addUser Test");
 }
@Test()
public void editUser() {
	System.out.println("tc3: editUser");
}
	
	
}



