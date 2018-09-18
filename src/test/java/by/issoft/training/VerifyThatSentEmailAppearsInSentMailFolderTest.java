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

public class VerifyThatSentEmailAppearsInSentMailFolderTest {

	private LoginPage loginPage;
	private MailPage mailPage;
	private PasswordPage passwordPage;

	@BeforeMethod
	public void setUp() {
		loginPage = new LoginPage();
		passwordPage = new PasswordPage();
		mailPage = new MailPage();
		Driver.openHomePage();
	}

	@Test(dataProvider = "verifyThatSentEmailAppearsInSentMailFolder", dataProviderClass = DataProviders.class)
	public void verifyThatSentEmailAppearsInSentMailFolderTest(String emailUser_1, String passwordUser_1, String emailUser_2) {
		loginPage.typeLogin(emailUser_1);
		passwordPage.isPasswordPageLoadInTime();
		passwordPage.typePassword(passwordUser_1);
		mailPage.isMailPageLoadInTime();
		mailPage.sendEmailToUser(emailUser_2);
		mailPage.waitUndoLinkDisappears();
		mailPage.clickSentFolderLink();
		Assert.assertTrue(mailPage.isLetterHasSent(emailUser_2), "Sent email is not in the sent mail folder!");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		Driver.closeDriver();
	}
}
