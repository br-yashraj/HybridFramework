package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	// Locator
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement displayedAccount;

	@FindBy(xpath = "//div/a[normalize-space() ='Logout']")
	WebElement linkLogout;

	// Actions
	public boolean ValidateMyAccountPage() {

		try {
			return displayedAccount.isDisplayed();
			// if not displayed thhen it wont't return false it'll return expection that's
			// why we use catch to return false.

		} catch (Exception e) {
			return false;
		}
	}

	// Logout
	public void clickLogout() {
		linkLogout.click();
	}

}
