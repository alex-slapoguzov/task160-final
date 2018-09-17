package by.issoft.training;

import by.issoft.training.dataProvider.DataProviders;
import by.issoft.training.driver.Driver;
import by.issoft.training.pages.LoginPage;
import by.issoft.training.pages.MailPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyThatSentEmailAppearsInSentMailFolderTest {

	private LoginPage loginPage;
	private MailPage mailPage;

	@BeforeMethod
	public void setUp() {
		loginPage = new LoginPage();
		mailPage = new MailPage();
		Driver.openHomePage();
	}

	@Test(dataProvider = "verifyThatSentEmailAppearsInSentMailFolder", dataProviderClass = DataProviders.class)
	public void verifyThatSentEmailAppearsInSentMailFolderTest(String emailUser_1, String passwordUser_1, String emailUser_2) {
		loginPage.login(emailUser_1, passwordUser_1);
		mailPage.isMailPage();
		mailPage.sendEmailToUser(emailUser_2);
		mailPage.waitUndoLinkDisappears();
		mailPage.clickSentFolderLink();
		Assert.assertTrue(mailPage.isLetterHasCame(emailUser_2), "Sent email is not in the sent mail folder!");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		Driver.closeDriver();
	}
}
