package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class HomePage extends BasePage {

	// Calling Parent BasePage Constructor
	// Invoking Parent constructor to this
	public HomePage(WebDriver driver) {

		super(driver); // super is used for parent
	}

	// Locators
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement lnkAccount;

	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement lnkRegister;

	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement lnkLogin;

	@Test
	public void clickAccount() {
		lnkAccount.click();
	}

	@Test
	public void clickRegister() {
		lnkRegister.click();
	}

	public void clickLogin() {
		lnkLogin.click();
	}

}
