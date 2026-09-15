package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterPage extends BasePage {

	// Calling Parent BasePage Constructor
	// Invoking Parent constructor to this
	public AccountRegisterPage(WebDriver driver) {

		super(driver);
	}

	// Locators
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFname;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLname;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephnoe;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPass;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConfirmPass;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement switchPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	// Actions
	public void setFname(String fname) {
		txtFname.sendKeys(fname);
	}

	public void setLname(String lname) {
		txtLname.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setTelephone(String phone) {
		txtTelephnoe.sendKeys(phone);
	}

	public void setPass(String pass) {
		txtPass.sendKeys(pass);
	}

	public void setConfirmPass(String confirmPass) {
		txtConfirmPass.sendKeys(confirmPass);
	}

	public void onPolicy() {
		switchPolicy.click();
	}

	public void btnClickRegister() {
		btnContinue.click();
	}

	public String getConfirmation() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

}
