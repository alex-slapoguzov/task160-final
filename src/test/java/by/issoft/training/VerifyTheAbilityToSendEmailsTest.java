package by.issoft.training;

import by.issoft.training.dataProvider.DataProviders;
import by.issoft.training.driver.Driver;
import by.issoft.training.pages.ChangeAccountPage;
import by.issoft.training.pages.LoginPage;
import by.issoft.training.pages.MailPage;
import by.issoft.training.pages.PasswordPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyTheAbilityToSendEmailsTest {

	private LoginPage loginPage;
	private PasswordPage passwordPage;
	private MailPage mailPage;
	private ChangeAccountPage changeAccountPage;

	@BeforeMethod
	public void setUp() {
		loginPage = new LoginPage();
		passwordPage = new PasswordPage();
		mailPage = new MailPage();
		changeAccountPage = new ChangeAccountPage();
		Driver.openHomePage();
	}

	@Test(dataProvider = "verifyTheAbilityToSendEmails", dataProviderClass = DataProviders.class)
	public void verifyTheAbilityToSendEmailsTest(String emailUser_1, String passwordUser_1,
												 String emailUser_2, String passwordUser_2) {
		loginPage.typeLogin(emailUser_1);
		passwordPage.isPasswordPageLoadInTime();
		passwordPage.typePassword(passwordUser_1);
		mailPage.isMailPageLoadInTime();
		mailPage.sendEmailToUser(emailUser_2);
		mailPage.waitUndoLinkDisappears();
		mailPage.logout();
		passwordPage.isPasswordPageLoadInTime();
		passwordPage.clickSelectAccount();
		changeAccountPage.isChangeAccountPageLoadInTime();
		changeAccountPage.clickChangeAccount();
		loginPage.isLoginPageLoadInTime();
		loginPage.typeLogin(emailUser_2);
		passwordPage.isPasswordPageLoadInTime();
		passwordPage.typePassword(passwordUser_2);
		mailPage.isMailPageLoadInTime();
		Assert.assertTrue(mailPage.isLetterHasCame(emailUser_1), "Letter hasn't came!");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		Driver.closeDriver();
	}
}
