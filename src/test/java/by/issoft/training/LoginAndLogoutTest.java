package by.issoft.training;

import by.issoft.training.dataProvider.DataProviders;
import by.issoft.training.driver.Driver;
import by.issoft.training.pages.LoginPage;
import by.issoft.training.pages.MailPage;
import by.issoft.training.pages.PasswordPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginAndLogoutTest {

	private LoginPage loginPage;
	private PasswordPage passwordPage;
	private MailPage mailPage;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		loginPage = new LoginPage();
		passwordPage = new PasswordPage();
		mailPage = new MailPage();
		Driver.openHomePage();
	}

	/*@Test(dataProvider = "loginWithValidCredentials", dataProviderClass = DataProviders.class)
	public void loginToGmailWithValidCredentialsTest(String email, String password) {
		loginPage.typeLogin(email);
		passwordPage.isPasswordPageLoadInTime();
		passwordPage.typePassword(password);
		Assert.assertTrue(mailPage.isMailPageLoadInTime(), "User with " + email + " and " + password + " wasn't signed in");
	}*/

	@Test(dataProvider = "loginWithValidCredentials", dataProviderClass = DataProviders.class)
	public void logoutFromGmail(String email, String password) {
		loginPage.typeLogin(email);
		passwordPage.isPasswordPageLoadInTime();
		passwordPage.typePassword(password);
		mailPage.isMailPageLoadInTime();
		mailPage.logout();
		Assert.assertTrue(passwordPage.isPasswordPageLoadInTime(), "User with " + email + " and " + password + " wasn't signed out");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		Driver.closeDriver();
	}
}
