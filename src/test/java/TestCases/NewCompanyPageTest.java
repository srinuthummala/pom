package TestCases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.NewCompanyPage;
import utility.Utility;

public class NewCompanyPageTest extends TestBase {
	public static Logger log = Utility.getLogger(NewCompanyPageTest.class);

	LoginPage loginPage;
	HomePage homePage;
	NewCompanyPage newCompanyPage;

	public NewCompanyPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("userid"),prop.getProperty("password"));
	}
		
	@Test(dataProvider="data")
	public void verfyNewCompanyFeature(String company, String branch, String revenue) {
		
		log.info("====== verifying new company feature======");
		newCompanyPage = homePage.clickOnNewCompany();
		newCompanyPage.fillForm(company, branch, revenue);
		log.info("clicking on companies menu");
		//homePage.clickOnCompanies();
		log.info("verifying company is added or not");
		Assert.assertTrue(newCompanyPage.isCompanyNameExists(company));
		log.info("company added successfully");
		log.info("====== verifying new company feature success======");
	}
	
	@DataProvider
	public Object[][] data(){
		Object[][] data = {{"srinu10", "civil","300"},{"srinu11", "ele","400"}};
		return data;
	}
	
	//@Test
	public void loo() {
		System.out.println(newCompanyPage.listOfCompanies());
	}
	
	@AfterTest
	public void quit() {
		driver.quit();
	}
}
