package project1;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class p1maven 
{
	 @BeforeTest
	 public void bt()
	 {
		 System.out.println("beforesuite");
	 }
	
	 @Test(enabled = false , priority=0)
	 public void login()
	 {
		 System.out.println("login successful");
	 }
	 
	 @Test(enabled = true , priority=1)
	 public void homepage()
	 {
		 System.out.println("homepage successful"); 
	 }
	 
	 @Test(priority=0 , dependsOnMethods = "login",alwaysRun = true)
	 public void search()
	 {
		 System.out.println("search successful");
	 }
}
