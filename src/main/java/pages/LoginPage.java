package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase {
	
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
		txtUsername.sendKeys(username);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clickLoginBtn() {
		btnLogin.click();
	}
	
	public HomePage login(String uname, String pass) {
		setUsername(uname);
		setPassword(pass);
	
		driver.switchTo().frame("intercom-borderless-frame");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@class='intercom-blocks']"))).build().perform();
		driver.findElement(By.xpath("//div[@class='intercom-borderless-dismiss-button']//span")).click();
		clickLoginBtn();
		return new HomePage();
	}

}
