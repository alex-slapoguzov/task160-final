package by.issoft.training;

import by.issoft.training.dataProvider.DataProviders;
import by.issoft.training.driver.Driver;
import by.issoft.training.pages.LoginPage;
import by.issoft.training.pages.MailPage;
import by.issoft.training.pages.OpenLetterPage;
import by.issoft.training.pages.PasswordPage;
import by.issoft.training.pages.folders.InboxFolder;
import by.issoft.training.pages.folders.TrashFolder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyThatDeletedEmailIsListedInTrashTest {

	private LoginPage loginPage;
	private MailPage mailPage;
	private PasswordPage passwordPage;
	private OpenLetterPage openLetterPage;
	private InboxFolder inboxFolder;
	private TrashFolder trashFolder;

	@BeforeMethod
	public void setUp() {
		loginPage = new LoginPage();
		passwordPage = new PasswordPage();
		mailPage = new MailPage();
		openLetterPage = new OpenLetterPage();
		inboxFolder = new InboxFolder();
		trashFolder = new TrashFolder();
		Driver.openHomePage();
	}

	@Test(dataProvider = "verifyThatDeletedEmailIsListedInTrashTest", dataProviderClass = DataProviders.class)
	public void verifyThatDeletedEmailIsListedInTrashTest(String emailUser_1, String passwordUser_1) {
		loginPage.typeLogin(emailUser_1);
		passwordPage.isPasswordPageLoadInTime();
		passwordPage.typePassword(passwordUser_1);
		mailPage.isMailPageLoadInTime();
		inboxFolder.openRandomLetterInInboxFolder();
		openLetterPage.isOpenLetterPageLoadInTime();
		String subject = openLetterPage.getSubjectFromLetter();
		openLetterPage.clickDeleteButton();
		mailPage.clickTrashFolderLink();
		Assert.assertTrue(trashFolder.isLetterInTrashFolder(subject), "Delete email is not in the trash folder!");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		Driver.closeDriver();
	}
}
