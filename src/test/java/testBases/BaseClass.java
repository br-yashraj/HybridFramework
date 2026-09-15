package testBases;

import java.io.FileReader;
//import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;
	public Logger logger;
	public Properties p;

	@BeforeClass(groups = { "Master", "Sanity", "Regression", "DataDriven" })
	@Parameters({ "os", "browser" })

	public void setUp(@Optional("windows") String os, @Optional("chrome") String browser) throws IOException {
		// Reading Properties file
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p = new Properties();
		p.load(file);

		logger = LogManager.getLogger(this.getClass());

		// Browser SetUp

		// When Remote environment
		if (p.getProperty("env_var").equalsIgnoreCase("remote")) {

			DesiredCapabilities capabilities = new DesiredCapabilities();

			// For OS
			if (os.equalsIgnoreCase("Windows")) {
				capabilities.setPlatform(Platform.WIN11);
			} else if (os.equalsIgnoreCase("Mac")) {
				capabilities.setPlatform(Platform.MAC);
			} else {
				System.out.println("No matching Os");
				return;
			}

			// For Browser
			if (browser.equalsIgnoreCase("chrome")) {
				capabilities.setBrowserName("chrome");
			} else if (browser.equalsIgnoreCase("Edge")) {
				capabilities.setBrowserName("MicrosoftEdge");
			} else {
				System.out.println("No Matching Browser");
				return;
			}
			driver = new RemoteWebDriver(new URL("https://localhost:4444/wd/hub"), capabilities);
		}

		// When Environemnet is local
		if (p.getProperty("env_var").equalsIgnoreCase("local")) {
			switch (browser) {
			case "chrome":
				ChromeOptions options = new ChromeOptions();

				Map<String, Object> prefs = new HashMap<>();

				// Disable Chrome password manager
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);

				// IMPORTANT: Disable password leak detection
				prefs.put("profile.password_manager_leak_detection", false);

				options.setExperimentalOption("prefs", prefs);

				// Additional protection against the leak-detection popup
				options.addArguments("--disable-save-password-bubble");
				options.addArguments("--disable-features=PasswordLeakDetection,PasswordManagerLeakDetection");

				driver = new ChromeDriver(options);
				break;

			case "edge":
				driver = new EdgeDriver();
				break;

			default:
				System.out.println("Invalid Browser");
				return;
			}
		}

		// Maximize the window
		driver.manage().window().maximize();

		// Implicitly Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Open URL
		driver.get(p.getProperty("appURL"));
//		driver.get("https://tutorialsninja.com/demo/");
	}

	@AfterClass(groups = { "Master", "Sanity", "Regression", "DataDriven" })
	public void tearDown() {
		driver.quit();
	}
}
