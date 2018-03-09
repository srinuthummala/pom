package pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import base.TestBase;
import utility.Utility;

public class NewCompanyPage extends TestBase {
	public static Logger log = Utility.getLogger(NewCompanyPage.class);

	@FindBy(xpath = "//legend[contains(text(), 'Create New  Company')]")
	WebElement labelCreateNewCompany;

	@FindBy(xpath = "//input[@name='company_name']")
	WebElement txtCompanyName;

	@FindBy(xpath = "//input[@name='industry']")
	WebElement txtIndustry;

	@FindBy(xpath = "//input[@name='annual_revenue']")
	WebElement txtAnnualRevenue;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement btnSave;

	@FindBys({ @FindBy(xpath = "//a[@context='company']") })
	List<WebElement> listCompanyNames;

	@FindBy(xpath = "//input[@name='client_id']")
	WebElement chbxCompanyName;

	@FindBy(xpath = "//select[@name='status']")
	WebElement ddStatus;;

	@FindBy(xpath = "//select[@name='category']")
	WebElement ddCategory;

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

	public void newCompanyForm(String name, String industry, String revenue, String vText) {
		log.info("entering text into comapany name field: " + name);
		setText(txtCompanyName, name);
		log.info("entering text into industry field: " + industry);
		setText(txtIndustry, industry);
		log.info("entering text into revenue field: " + revenue);
		setText(txtAnnualRevenue, revenue);
		log.info("selecting dropdown value: " + vText);
		mSelectByText(ddStatus, vText);
		click(btnSave);
	}

	public void createNewCompany(String name, String industry, String revenue, String vText) {
		log.info("**********form filling started ******");
		log.info("switching to frame \"mainpanel\" ");
		driver.switchTo().frame("mainpanel");

		newCompanyForm(name, industry, revenue, vText);
		log.info("form filling done");

		driver.switchTo().defaultContent();
		log.info("switched back to defaultcontent");
		log.info("**********form filling done ******");

	}

	public boolean isCompanyNameExists(String name) {
		log.info("*********** verfying company name presence********");
		// log.info("switching to frame \"mainpanel\" ");
		// driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//div[@id='navmenu']//li/a[text()='Companies']")).click();
		List<WebElement> list = driver.findElements(By.xpath("//a[@context='company']"));
		// WebElement element=CompanyName.findElement(By.xpath("//a[contains(text(),
		// '"+name+"')]"));
		Boolean flag = false;
		for (WebElement ele : list) {
			String str = ele.getText();
			if (str.equals(name)) {
				flag = true;
				log.info("company is present in companies list");
				break;
			}
			flag = false;
			//log.info("company is not present in companies list");

		}

		// log.info("switching back to defaultcontent");
		// driver.switchTo().defaultContent();
		log.info("*********** verfyied company name presence********");

		return flag;
	}

	public int listOfCompanies() {

		log.info("switching to frame \"mainpanel\" ");
		driver.switchTo().frame("mainpanel");
		// List<WebElement> list
		// =driver.findElements(By.xpath("//a[@context='company']"));
		int i = listCompanyNames.size();
		log.info("switching back to defaultcontent");
		driver.switchTo().defaultContent();
		return i;
	}

	public void deleteComany(String name) {
		log.info("******** started company deletion **********");
		log.info("switching to frame \"mainpanel\" ");
		driver.switchTo().frame("mainpanel");
		// driver.findElement(By.xpath("//div[@id='navmenu']//li/a[text()='Companies']")).click();
		List<WebElement> list = driver.findElements(By.xpath("//a[@context='company']"));
		// WebElement element=CompanyName.findElement(By.xpath("//a[contains(text(),
		// '"+name+"')]"));
		Boolean flag = false;
		for (WebElement ele : list) {
			String str = ele.getText();
			if (str.equals(name)) {
				WebElement element = driver
						.findElement(By.xpath("//a[contains(text(), '" + name + "')]/../preceding-sibling::td/input"));
				element.click();
				log.info(element.isSelected());
				driver.findElement(
						By.xpath("//a[contains(text(), '" + name + "')]/../following-sibling::td/a/i[@title='Delete']"))
						.click();
				// System.out.println(element.isSelected());
				Alert alert = driver.switchTo().alert();
				alert.accept();
				flag = true;
				break;
			} else {
				log.info("company name is not present: " + name);
				throw new RuntimeException("company name is not present in list to delete: " + name);

			}
		}

		log.info("switching back to defaultcontent");
		driver.switchTo().defaultContent();
		log.info("******** company deletion completed **********");
	}

	public void editCompanyDetais(String name, String industry, String revenue, String vText) {
		log.info("********************** editCompanyDetais function ******************");
		log.info("started editing company details");
		if (isCompanyNameExists(name)) {
			WebElement edit = driver.findElement(By
					.xpath("//form[@id=\"vCompaniesForm\"]//td/a[text()='" + name + "']/../following-sibling::td/a/i"));
			edit.click();
			log.info("editing existing company details");
			newCompanyForm(name, industry, revenue, vText);
			log.info("existing company details edited");
		} else {
			log.info("company notpresent in companies list");
			throw new RuntimeException("company name is not listed in list of companies: " + name);
		}
		log.info("company details edited");
		log.info("************************* editCompanyDetais function done *********************");
	}
}
