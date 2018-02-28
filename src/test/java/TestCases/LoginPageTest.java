package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	
	public LoginPageTest() {
		 super();
	}
	
	@BeforeMethod
	public void init() {
		initialization();
		loginPage= new LoginPage();
	}
	
	@Test
	public void verifyLogin() {
		loginPage.login(prop.getProperty("userid"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}

}
