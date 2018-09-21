package by.issoft.training;

import by.issoft.training.dataProvider.DataProviders;
import by.issoft.training.driver.Driver;
import by.issoft.training.pages.*;
import by.issoft.training.pages.folders.InboxFolder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyTheAbilityToSendEmailsTest {

	private LoginPage loginPage;
	private PasswordPage passwordPage;
	private MailPage mailPage;
	private ChangeAccountPage changeAccountPage;
	private NewLetterPage newLetterPage;
	private InboxFolder inboxFolder;

	@BeforeMethod
	public void setUp() {
		loginPage = new LoginPage();
		passwordPage = new PasswordPage();
		mailPage = new MailPage();
		changeAccountPage = new ChangeAccountPage();
		newLetterPage = new NewLetterPage();
		inboxFolder = new InboxFolder();
		Driver.openHomePage();
	}

	@Test(dataProvider = "verifyTheAbilityToSendEmails", dataProviderClass = DataProviders.class)
	public void verifyTheAbilityToSendEmailsTest(String emailUser_1, String passwordUser_1,
												 String emailUser_2, String passwordUser_2) {
		loginPage.typeLogin(emailUser_1);
		passwordPage.isPasswordPageLoadInTime();
		passwordPage.typePassword(passwordUser_1);
		mailPage.isMailPageLoadInTime();
		mailPage.clickComposeButton();
		newLetterPage.sendEmailToUser(emailUser_2);
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
		mailPage.refreshPage();
		Assert.assertTrue(inboxFolder.isLetterInInboxFolder(), "Letter hasn't came!");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		Driver.closeDriver();
	}
}
