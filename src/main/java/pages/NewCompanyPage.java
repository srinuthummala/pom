package pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;
import utility.Utility;

public class NewCompanyPage extends TestBase {
	public static Logger log = Utility.getLogger(NewCompanyPage.class);

	@FindBy(xpath="//legend[contains(text(), 'Create New  Company')]")
	WebElement labelCreateNewCompany;
	
	@FindBy(xpath="//input[@name='company_name']")
	WebElement txtCompanyName;
	
	@FindBy(xpath="//input[@name='industry']")
	WebElement txtIndustry;
	
	@FindBy(xpath="//input[@name='annual_revenue']")
	WebElement txtAnnualRevenue;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement btnSave;
	
	@FindBys({@FindBy(xpath="//a[@context='company']")})
	List<WebElement> listCompanyNames;
	
	public NewCompanyPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean labelPresent() {
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isDisplayed(labelCreateNewCompany);
	}
	
	public void fillForm(String name, String industry, String revenue) {
		log.info("switching to frame \"mainpanel\" ");
		driver.switchTo().frame("mainpanel");
		log.info("entering text into comapany name field: "+name);
		setText(txtCompanyName, name);
		//txtCompanyName.sendKeys(name);
		log.info("entering text into industry field: "+industry);
		setText(txtIndustry, industry);
		log.info("entering text into revenue field: "+revenue);
		setText(txtAnnualRevenue, revenue);
		click(btnSave);
		driver.switchTo().defaultContent();
		log.info("switched back to defaultcontent");

	}
	
	public boolean isCompanyNameExists(String name) {
		log.info("switching to frame \"mainpanel\" ");
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//div[@id='navmenu']//li/a[text()='Companies']")).click();
		List<WebElement> list =driver.findElements(By.xpath("//a[@context='company']"));
		//WebElement element=CompanyName.findElement(By.xpath("//a[contains(text(), '"+name+"')]"));
		Boolean flag =false;
		for(WebElement ele : list) {
			String str = ele.getText();
			if(str.equals(name)) {
				flag=true;
				break;
			}
			
		}
		
		log.info("switching back to defaultcontent");
		driver.switchTo().defaultContent();
		return flag;
	}
	
	public int listOfCompanies() {
		
		log.info("switching to frame \"mainpanel\" ");
		driver.switchTo().frame("mainpanel");
		//List<WebElement> list =driver.findElements(By.xpath("//a[@context='company']"));
		int i = listCompanyNames.size();
		log.info("switching back to defaultcontent");
		driver.switchTo().defaultContent();
		return i;
	}

		
}
