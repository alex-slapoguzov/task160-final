package by.issoft.training;

import by.issoft.training.driver.Driver;
import by.issoft.training.pages.LoginPage;
import by.issoft.training.pages.MailPage;
import by.issoft.training.pages.OpenLetterPage;
import by.issoft.training.pages.folders.InboxFolder;
import by.issoft.training.pages.folders.TrashFolder;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyThatDeletedEmailIsListedInTrashTest extends TestBase {

	private LoginPage loginPage;
	private MailPage mailPage;
	private InboxFolder inboxFolder;
	private OpenLetterPage openLetterPage;
	private TrashFolder trashFolder;

	private final String LOGIN = "seleniumtests30";
	private final String PASSWORD = "060788avavav";

	@BeforeClass
	public void beforeClass() {
		loginPage = new LoginPage();
		mailPage = new MailPage();
		inboxFolder = new InboxFolder();
		openLetterPage = new OpenLetterPage();
		trashFolder = new TrashFolder();

		Driver.openHomePage();
		loginPage.login(LOGIN, PASSWORD);
		mailPage.isMailPageLoadInTime();
	}

	@Test()
	public void verifyThatDeletedEmailIsListedInTrashTest() {
		inboxFolder.openRandomLetterInInboxFolder();
		openLetterPage.isOpenLetterPageLoadInTime();
		String subject = openLetterPage.getSubjectFromLetter();
		openLetterPage.clickDeleteButton();
		mailPage.clickTrashFolderLink();
		Assert.assertTrue(trashFolder.isLetterInTrashFolder(subject), "Delete email is not in the trash folder!");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		Driver.closeDriver();
	}
}
