package by.issoft.training.tests;

import by.issoft.training.TestBase;
import by.issoft.training.dataProvider.DataProviders;
import by.issoft.training.driver.Driver;
import by.issoft.training.pages.LoginPage;
import by.issoft.training.pages.MailPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogoutTest extends TestBase {

	private LoginPage loginPage;
	private MailPage mailPage;

	@BeforeClass()
	public void setUp() {
		loginPage = new LoginPage();
		mailPage = new MailPage();
	}

	@Test(dataProvider = "loginWithValidCredentials", dataProviderClass = DataProviders.class)
	public void logoutFromGmailTest(String email, String password) {
		Driver.openHomePage();
		loginPage.login(email, password);
		mailPage.isMailPageLoadInTime();
		mailPage.logout();
		Assert.assertTrue(loginPage.isLoginPageLoadInTime(), "User with " + email + " and " + password + " wasn't signed out");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		Driver.closeDriver();
	}
}
