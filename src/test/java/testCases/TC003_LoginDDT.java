package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "Datadriven")
	public void verify_loginDDT(String email, String pwd, String exp) throws InterruptedException {
		logger.info("*** Started TC003_LoginDDT ***");

		try {
			// HomePage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			// LoginPage
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();

			// Checking after login
			MyAccountPage macc = new MyAccountPage(driver);
			boolean myAccountExists = macc.isMyAccountPageExist();
			boolean warningExists = lp.isWarningMessageExist();  // reuse same lp object

			if (exp.equalsIgnoreCase("Valid")) {
				if (myAccountExists) {
					macc.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.fail("Login failed for valid credentials.");
				}
			}
			else if (exp.equalsIgnoreCase("Invalid")) {
				if (warningExists) {
					Assert.assertTrue(true);
				} else {
					Assert.fail("Login passed for invalid credentials!");
				}
			}

		} catch (Exception e) {
			Assert.fail();
		}

		Thread.sleep(3000);
		logger.info("*** Finished TC003_LoginDDT ***");
	}
}
