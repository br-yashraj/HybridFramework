package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	// Calling Parent BasePage Constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// Locators

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPass;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement clickLogin;

	// Actions
	public void inputEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void inputPass(String pass) {
		txtPass.sendKeys(pass);
	}

	public void clickLogin() {
		clickLogin.click();
	}

}
