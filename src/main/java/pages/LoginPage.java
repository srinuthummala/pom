package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.Utility;

public class LoginPage extends TestBase {
	public static Logger log = Utility.getLogger(LoginPage.class);

	
	@FindBy(xpath="//div/input[@name='username']")
	WebElement txtUsername;
	
	@FindBy(xpath="//div/input[@name='password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//div/input[@value='Login']")
	WebElement btnLogin;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void setUsername(String username) {
		log.info("entering username :  "+username);
		txtUsername.sendKeys(username);
	}
	
	public void setPassword(String password) {
		log.info("entering password :  "+password);

		txtPassword.sendKeys(password);
	}
	
	public void clickLoginBtn() {
		log.info("clicking login button");
		btnLogin.click();
		log.info("clicking login button");

	}
	
	public HomePage login(String uname, String pass) {
		
		log.info("**********started login functionality***************");
		log.info("entering username :  "+uname);
		setText(txtUsername, uname);
		log.info("entering password :  "+pass);
		setText(txtPassword, pass);
		//setUsername(uname);
		//setPassword(pass);
	
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", btnLogin);
		
		log.info("************* login functionality done *****************");

		
		/*driver.switchTo().frame("intercom-borderless-frame");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@class='intercom-blocks']"))).build().perform();
		driver.findElement(By.xpath("//div[@class='intercom-borderless-dismiss-button']//span")).click();*/
		//clickLoginBtn();
		return new HomePage();
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

}
