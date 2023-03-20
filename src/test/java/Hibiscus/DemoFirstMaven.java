package Hibiscus;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class DemoFirstMaven {
	@BeforeTest
	public void bt() {
		System.out.println("beforeTest");
		
	}
	@Test(enabled = true, priority = 0)
	public void login() {
		System.out.println("login");
		
	}
	@Test(enabled = true, priority = 2)
	public void homepage() {
		System.out.println("homepage");
	}
	@Test(enabled = true, priority = 1)
	public void search() {
		System.out.println("search");
	}

}
