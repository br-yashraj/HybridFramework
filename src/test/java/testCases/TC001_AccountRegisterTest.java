package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterPage;
import pageObjects.HomePage;
import testBases.BaseClass;

// TC001 -> Acoount Register Successfully
public class TC001_AccountRegisterTest extends BaseClass {

	@Test(priority = 1, dataProvider = "dp", groups = { "Regression", "Master" })
	public void verify_Register(String fname, String lname, String email) {

		try {
			logger.info("**** Starting TC001_AccountRegisterTest ****");

			// Calling POM
			HomePage hp = new HomePage(driver);
			hp.clickAccount();
			logger.info("Clicked My Account");

			hp.clickRegister();
			logger.info("Clicked Register Link");

			// Calling POM
			AccountRegisterPage register = new AccountRegisterPage(driver);

			logger.info("Providing all Details");

			register.setFname(fname);

			register.setLname(lname);

			register.setEmail(email); // DataProvider

			register.setTelephone("8340276262"); // Hard-Coded

			register.setPass("Yash@123");

			register.setConfirmPass("Yash@123");

			register.onPolicy();

			register.btnClickRegister();

			// Validating Success Message
			logger.info("Validating Successfull Register");

			String message = register.getConfirmation();

			if (message.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);

			} else {
				logger.error("Test Failed");
				logger.debug("Debug Logs");
				Assert.fail();
			}
		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("**** Finished ****");

	}

	@DataProvider(name = "dp")
	public Object[][] DataSet() {

		Object data[][] = { { "Yash", "Raj", "yashraj161111@yopmail.com", } };

		return data;

	}

}
