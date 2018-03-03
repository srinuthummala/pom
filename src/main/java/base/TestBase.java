package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import utility.Utility;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public static Logger log = Utility.getLogger(TestBase.class);
	public TestBase() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
				
	}
	
	
	public void initialization() {
		
		String browserName = prop.getProperty("browser");
		log.info(browserName+" browser launching");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/drivers/chromedriver2.33.exe");
			//options = new ChromeOptions();
			//options.addArguments("window-size = 1400,800");
			//options.addArguments("headless");
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		log.info(browserName+" browser launched");

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		String url = prop.getProperty("url");
		log.info("launching url: "+url);
		driver.get(url);
		log.info("url launched");
		
	}
	
	
	
	public void setText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}
	
	public void click(WebElement element) {
		element.click();
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	public boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public void mouseHoverOn(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
}
