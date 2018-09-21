package by.issoft.training.pages;

import by.issoft.training.util.Waiter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailPage extends Page {

	@FindBy(xpath = "//a[@class=\"gb_me gb_dc gb_De\"]")
	private WebElement gmailTitleNode;

	@FindBy(xpath = "//div[@class='gb_Qc gb_ib gb_Sg gb_R']/a")
	private WebElement userAccountButton;

	@FindBy(id = "gb_71")
	private WebElement signOutButton;

	@FindBy(xpath = "//div[@class=\"T-I J-J5-Ji T-I-KE L3\"]")
	private WebElement composeButton;

	@FindBy(id = "link_undo")
	private WebElement undoLink;

	@FindBy(xpath = "//a[text()='Sent']")
	private WebElement sentFolderLink;

	@FindBy(xpath = "//a[text()='Trash']")
	private WebElement trashFolderLink;

	public MailPage() {
		super();
	}

	public boolean isMailPageLoadInTime() {
		return isPageLoadInTime(userAccountButton, gmailTitleNode);
	}

	public PasswordPage logout() {
		userAccountButton.click();
		Waiter.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(signOutButton));
		signOutButton.click();

		return new PasswordPage();
	}

	public NewLetterPage clickComposeButton() {
		composeButton.click();

		return new NewLetterPage();
	}

	public void waitUndoLinkDisappears() {
		Waiter.getWebDriverWait().until(ExpectedConditions.invisibilityOf(undoLink));
	}

	public void clickSentFolderLink() {
		sentFolderLink.click();
	}

	public void clickTrashFolderLink() {
		trashFolderLink.click();
	}
}
