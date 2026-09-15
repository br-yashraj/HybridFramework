package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

// This java class only contain constructor because contructor is used by all Page Object classes
// Parent of all the PageObject class because every classes need a contructor so every classes in PageObject package will extend this class

public class BasePage {

	WebDriver driver;

	public BasePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this); // this is here used to locate the current page if we use loginPage then
												// this BasePage object nahi, balki us waqt ka actual current object
												// (LoginPage) hai.
	}

}
