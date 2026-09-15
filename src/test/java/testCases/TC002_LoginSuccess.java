package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBases.BaseClass;

public class TC002_LoginSuccess extends BaseClass {

	@Test(groups = { "Sanity", "Master" })
	public void LoginSuccess() {

		try {
			HomePage hp = new HomePage(driver);

			// Click on Account
			hp.clickAccount();

			// Click on Login
			hp.clickLogin();

			// Calling LoginPage POM
			LoginPage lp = new LoginPage(driver);

			// Input Email through properties file
			lp.inputEmail(p.getProperty("id"));

			// Input Password through properties file
			lp.inputPass(p.getProperty("pass"));

			// Click on Login btn
			lp.clickLogin();

			// Calling MyAccount POM
			MyAccountPage myAccount = new MyAccountPage(driver);

			boolean targetPage = myAccount.ValidateMyAccountPage();
			Assert.assertEquals(targetPage, true);

		} catch (Exception e) {
			Assert.fail();
			System.out.println(e.getMessage());
		}

	}

}
