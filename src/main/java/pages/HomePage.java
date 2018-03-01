package pages;

import org.apache.log4j.Logger;
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
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickBtnLogout() {
		log.info("clicking logout button started");
		log.info("switching to frame mainpanel");
		driver.switchTo().frame("mainpanel");
		log.info("switched to frame mainpanel");

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", btnLogout);
		
		log.info("clicked on logout button");
		driver.switchTo().defaultContent();
		log.info("switched to default content from frame mainpanel");


	}
	
	public boolean isLogoutDisplayed() {
		driver.switchTo().frame("mainpanel");
		return btnLogout.isDisplayed();
	}
	
	public LoginPage Logout() {
		clickBtnLogout();
		return new LoginPage();
	}

}
