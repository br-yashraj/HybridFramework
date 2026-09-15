package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBases.BaseClass;
import utilities.DataProviderClass;

public class TC003_LoginDataDriven extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviderClass.class, groups = "DataDriven")
	public void LoginDatadriven(String email, String password, String expectedResult) {

		try {

			// Go to HomePage
			HomePage hp = new HomePage(driver);
			hp.clickAccount();
			hp.clickLogin();

			// Calling LoginPage POM
			LoginPage lp = new LoginPage(driver);
			lp.inputEmail(email);
			lp.inputPass(password);
			lp.clickLogin();

			// Calling MyAccount POM
			MyAccountPage myAccount = new MyAccountPage(driver);
			boolean targetPage = myAccount.ValidateMyAccountPage();

			if (expectedResult.equalsIgnoreCase("Valid")) {
				if (targetPage == true) {
					Assert.assertTrue(true);
					myAccount.clickLogout();
				} else {
					Assert.fail();
				}
			} else {
				if (targetPage == true) {
					Assert.fail();
					myAccount.clickLogout();
				} else {
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception occurred: " + e.getMessage());
		}

	}
}
