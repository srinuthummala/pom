package pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.Utility;

public class HomePage extends TestBase {
	public static Logger log = Utility.getLogger(HomePage.class);
	
	@FindBy(xpath="//div[@class='noprint']//table//tr//td[4]/a/i")
	WebElement btnLogout;
	
	@FindBy(xpath="//div[@id='navmenu']//li/a[text()='Companies']")
	WebElement ddCompanies;
	@FindBy(xpath="//a[@title='Companies']/following-sibling::ul/li/a[@title='New Company']")
	WebElement optoinNewCompany;
	@FindBy(xpath="//a[@title='Companies']/following-sibling::ul/li/a[@title='Combined Form']")
	WebElement optoinCombinedForm;
	@FindBy(xpath="//a[@title='Companies']/following-sibling::ul/li/a[@title='Full Search Form']")
	WebElement optoinFullSearchForm;
	
	
	@FindBy(xpath="//div[@id='navmenu']//li/a[text()='Contacts']")
	WebElement ddContacts;
	
	@FindBy(xpath="//div[@id='navmenu']//li/a[text()='Deals']")
	WebElement ddDeals;
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickBtnLogout() {
		log.info("**********clicking logout button started************");
		log.info("switching to frame mainpanel");
		driver.switchTo().frame("mainpanel");
		log.info("switched to frame mainpanel");

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", btnLogout);
		
		log.info("clicked on logout button");
		driver.switchTo().defaultContent();
		log.info("switched to default content from frame mainpanel");
		log.info("********** logout button functionality ended************");


	}
	
	public boolean isLogoutDisplayed() {
		driver.switchTo().frame("mainpanel");
		return btnLogout.isDisplayed();
	}
	
	public LoginPage Logout() {
		clickBtnLogout();
		return new LoginPage();
	}
	
	public void clickOnCompanies() {
		log.info("******** navigating to companies list **********");
		log.info("switching to mainpanel frame ");
		driver.switchTo().frame("mainpanel");
		log.info("clicking on companies link from menu bar");
		click(ddCompanies);	
		driver.switchTo().defaultContent();
		log.info("switched to default content");
		log.info("******** navigated to companies list **********");


	}
	public NewCompanyPage clickOnNewCompany() {
		log.info("******** navigating to new company to fill form **********");

		log.info("switching to mainpanel frame ");
		driver.switchTo().frame("mainpanel");
		log.info("mouse hovering on companies link");
		mouseHoverOn(ddCompanies);
		log.info("clicking on new company");
		click(optoinNewCompany);
		driver.switchTo().defaultContent();
		log.info("switched to default content");
		log.info("******** navigated to new company to fill form **********");

		return new NewCompanyPage();
	}

}
