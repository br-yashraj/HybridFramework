package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoRunner {

	WebDriver driver;

	@BeforeClass
	void setup() throws InterruptedException {

		ChromeOptions options = new ChromeOptions();

		// Separate Selenium Chrome profile
		options.addArguments("user-data-dir=C:\\selenium\\chrome-profile");

		// Optional stability arguments
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");

		driver = new ChromeDriver(options);

		driver.get("https://tutorialsninja.com/demo/");

		Thread.sleep(5000);
	}

	@Test
	void RegisterTest() {

		// If you want Tutorial Ninja:

		HomePage hp = new HomePage(driver);

		hp.clickAccount();
		hp.clickRegister();
	}
}
