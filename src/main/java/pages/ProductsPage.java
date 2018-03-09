package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.Utility;

public class ProductsPage extends TestBase {
	
	public static Logger log = Utility.getLogger(ProductsPage.class);
	
	@FindBy(xpath="//input[@value='New Product']")
	WebElement btnNewProduct;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement txtProductName;
	
	@FindBy(xpath="//input[@id='cost']")
	WebElement txtCost;
	
	@FindBy(xpath="//input[@id='retail_value']")
	WebElement txtRetailValue;
	
	@FindBy(xpath="//input[@id='wholesale']")
	WebElement txtwholesalePrice;
	
	@FindBy(xpath="//textarea[@name='description']/../../following-sibling::tr//input[@value='Save']")
	WebElement btnSave;
	
	
	public ProductsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void createNewProduct(String pName, String cost, String retailPrice, String wholesalePrice) {
		log.info("*********** createNewProduct function started ***********");
		if(btnNewProduct.isDisplayed()) {
			btnNewProduct.click();
			setText(txtProductName, pName);
			setText(txtCost, cost);
			setText(txtRetailValue, retailPrice);
			setText(txtwholesalePrice, wholesalePrice);
			click(btnSave);
		}else {
			throw new RuntimeException("retun to products to create new one");
		}
		
		log.info("*********** createNewProduct function started ***********");		
	}

}
