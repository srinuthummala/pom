package TestCases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import utility.Utility;



public class LoginPageTest extends TestBase {
	public static Logger log = Utility.getLogger(LoginPageTest.class);

	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		 super();
	}
	
	@BeforeMethod
	public void init() {
		initialization();
		loginPage= new LoginPage();
		homePage = new HomePage();
		
	}
	
	@Test
	public void verifyLogin() {
		log.info("======started verify login test method==========");
		loginPage.login(prop.getProperty("userid"),prop.getProperty("password"));
		log.info("=======verify login test method completed==========");

	}
	
	@AfterMethod
	public void quit() {
		driver.close();
	}

}
