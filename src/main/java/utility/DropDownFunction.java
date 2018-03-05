package utility;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownFunction {
	public void mSelectByText(WebDriver driver, WebElement wDropdown, String vText) {
		try {
			Select Dropdown = new Select(wDropdown);
			Dropdown.selectByVisibleText(vText);
		} catch (Exception E) {
			System.out.println("Error in selecting dropdown option by visible text.");
		}
	}

	public void mSelectByIndex(WebDriver driver, WebElement wDropdown, int vIndex) {
		try {
			Select Dropdown = new Select(wDropdown);
			Dropdown.selectByIndex(vIndex);
		} catch (Exception E) {
			System.out.println("Error in selecting dropdown option by index.");
		}
	}

	public void mSelectByValue(WebDriver driver, WebElement wDropdown, String vValue) {
		try {
			Select Dropdown = new Select(wDropdown);
			Dropdown.selectByValue(vValue);
		} catch (Exception E) {
			System.out.println("Error in selecting dropdown option by value.");
		}
	}

	public List<String> mGetAllOptions(WebDriver driver, WebElement wDropdown) {
		List<String> Option = new ArrayList<String>();

		try {
			Select Dropdown = new Select(wDropdown);

			List<WebElement> temp = Dropdown.getOptions();

			for (int i = 0; i < temp.size(); i++) {
				Option.add(temp.get(i).getText());
			}

		} catch (Exception E) {
			System.out.println("Error in getting options from dropdown");
		}
		return Option;
	}

}
