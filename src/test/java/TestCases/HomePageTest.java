package TestCases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import utility.Utility;

public class HomePageTest extends TestBase {
	public static Logger log = Utility.getLogger(HomePageTest.class);

	
	 HomePage homePage;
	 LoginPage loginPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void init() {
		initialization();
		homePage= new HomePage();
		loginPage = new LoginPage();
	}
	
	@Test
	public void veryLogoutFunctionality()
	{
		log.info("started veryLogoutFunctionality ");
		loginPage.login(prop.getProperty("userid"),prop.getProperty("password"));
		homePage.clickBtnLogout();
		Assert.assertEquals("CRMPRO", loginPage.getLoginPageTitle());
		log.info(" veryLogoutFunctionality success ");

	}
	
	 
}
