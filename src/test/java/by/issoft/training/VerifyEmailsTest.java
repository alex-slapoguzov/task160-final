package by.issoft.training;

import by.issoft.training.dataProvider.DataProviders;
import by.issoft.training.driver.Driver;
import by.issoft.training.pages.LoginPage;
import by.issoft.training.pages.MailPage;
import by.issoft.training.pages.NewLetterPage;
import by.issoft.training.pages.folders.InboxFolder;
import by.issoft.training.pages.folders.SentFolder;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyEmailsTest {

	private LoginPage loginPage;
	private MailPage mailPage;
	private NewLetterPage newLetterPage;
	private InboxFolder inboxFolder;
	private SentFolder sentFolder;

	private final String LOGIN = "seleniumtests10";
	private final String PASSWORD = "060788avavav";

	@BeforeClass
	public void beforeClass() {
		loginPage = new LoginPage();
		mailPage = new MailPage();
		newLetterPage = new NewLetterPage();
		inboxFolder = new InboxFolder();
		sentFolder = new SentFolder();

		Driver.openHomePage();
		loginPage.login(LOGIN, PASSWORD);
		mailPage.isMailPageLoadInTime();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		Driver.openHomePage();
	}

	@Test(dataProvider = "verifyTheAbilityToSendEmails", dataProviderClass = DataProviders.class)
	public void verifyTheAbilityToSendEmailsTest(String email, String password) {
		mailPage.clickComposeButton();
		newLetterPage.sendEmailToUser(email);
		mailPage.waitUndoLinkDisappears();
		mailPage.logout();
		loginPage.isLoginPageLoadInTime();
		loginPage.login(email, password);
		mailPage.isMailPageLoadInTime();
		mailPage.refreshPage();
		Assert.assertTrue(inboxFolder.isLetterInInboxFolder(), "Letter hasn't came!");
	}

	@Test(dataProvider = "verifyThatSentEmailAppearsInSentMailFolder", dataProviderClass = DataProviders.class)
	public void verifyThatSentEmailAppearsInSentMailFolderTest(String user) {
		mailPage.clickComposeButton();
		newLetterPage.sendEmailToUser(user);
		mailPage.waitUndoLinkDisappears();
		mailPage.refreshPage();
		mailPage.clickSentFolderLink();
		Assert.assertTrue(sentFolder.isLetterInSentFolder(), "Sent email is not in the sent mail folder!");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		Driver.closeDriver();
	}
}
