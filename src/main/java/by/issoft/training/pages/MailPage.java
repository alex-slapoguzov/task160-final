package by.issoft.training.pages;

import by.issoft.training.driver.Driver;
import by.issoft.training.util.Random;
import by.issoft.training.util.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class MailPage extends Page {

	@FindBy(xpath = "//a[@class=\"gb_me gb_dc gb_De\"]")
	private WebElement gmailTitleNode;

	@FindBy(xpath = "//div[@class='gb_Qc gb_ib gb_Sg gb_R']/a")
	private WebElement userAccountButton;

	@FindBy(id = "gb_71")
	private WebElement signOutButton;

	@FindBy(xpath = "//div[@class=\"T-I J-J5-Ji T-I-KE L3\"]")
	private WebElement composeButton;

	@FindBy(xpath = "//div[@class=\"wO nr l1\"]/textarea")
	private WebElement recipientsField;

	@FindBy(xpath = "//div[@class=\"T-I J-J5-Ji aoO T-I-atl L3\"]")
	private WebElement sendButton;

	@FindBy(xpath = "//div[@class=\"aoD az6\"]/input")
	private WebElement subjectField;

	@FindBy(xpath = "//tr[@class='zA zE']")
	private List<WebElement> listWithLettersInInboxFolder;

	@FindBy(id = "link_undo")
	private WebElement undoLink;

	@FindBy(xpath = "//a[text()='Sent']")
	private WebElement sentFolderLink;

	private final static By EMAIL_FIELD_IN_TABLE_LOCATOR_BY_LETTER_IN_INBOX = By.xpath("//span[@class=\"zF\"]");
	private final static By SUBJECT_FIELD_IN_TABLE_LOCATOR_BY_LETTER_IN_INBOX = By.xpath("//span[@class=\"bog\"]/span");

	private final static By EMAIL_FIELD_IN_TABLE_LOCATOR_BY_LETTER_IN_SENT = By.xpath("//div[@class=\"yW\"]/span");
	private final static By SUBJECT_FIELD_IN_TABLE_LOCATOR_BY_LETTER_IN_SENT = By.xpath("//div[@class=\"xS\"]//span[@class=\"bog\"]");
	private final static String subject = "Subject+";
	private final static String subjectText = Random.randomizeSubject(subject);

	public MailPage() {
		super();
	}

	public boolean isMailPageLoadInTime() {
		return isPageLoadInTime(userAccountButton, gmailTitleNode);
	}

	public LoginPage logout() {
		userAccountButton.click();
		Waiter.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(signOutButton));
		signOutButton.click();

		return new LoginPage();
	}

	public void clickComposeButton() {
		composeButton.click();
	}

	public void typeMailInRecipientsField(String user) {
		String email = user + "@gmail.com";
		recipientsField.click();
		recipientsField.sendKeys(email);
	}

	public void typeSubjectInSubjectField() {
		subjectField.sendKeys(subjectText);
	}

	public void clickSendButton() {
		sendButton.click();
	}

	public void sendEmailToUser(String user) {
		clickComposeButton();
		Waiter.getWebDriverWait().until(ExpectedConditions.visibilityOf(recipientsField));
		typeMailInRecipientsField(user);
		typeSubjectInSubjectField();
		clickSendButton();
	}

	public boolean isLetterHasCame(String mail) {
		refreshPage();
		List<WebElement> letterWithGivenEmailAndSubjectList = new ArrayList<WebElement>();
		String gmailEmail = mail + "@gmail.com";

		for (WebElement element : listWithLettersInInboxFolder) {
			if (element.findElement(EMAIL_FIELD_IN_TABLE_LOCATOR_BY_LETTER_IN_INBOX).getAttribute("email").equals(gmailEmail)
					&& element.findElement(SUBJECT_FIELD_IN_TABLE_LOCATOR_BY_LETTER_IN_INBOX).getText().equals(subjectText)) {
				letterWithGivenEmailAndSubjectList.add(element);
			}
		}

		if (letterWithGivenEmailAndSubjectList.size() > 1) {
			return true;
		} else return false;
	}

	public boolean isLetterHasSent(String mail) {
		refreshPage();
		List<WebElement> letterWithGivenEmailAndSubjectList = new ArrayList<WebElement>();
		String gmailEmail = mail + "@gmail.com";

		for (WebElement element : listWithLettersInInboxFolder) {
			if (element.findElement(EMAIL_FIELD_IN_TABLE_LOCATOR_BY_LETTER_IN_SENT).getAttribute("email").equals(gmailEmail)
					&& element.findElement(SUBJECT_FIELD_IN_TABLE_LOCATOR_BY_LETTER_IN_SENT).getText().equals(subjectText)) {
				letterWithGivenEmailAndSubjectList.add(element);
			}
		}

		if (letterWithGivenEmailAndSubjectList.size() > 1) {
			return true;
		} else return false;
	}

	public void waitUndoLinkDisappears() {
		Waiter.getWebDriverWait().until(ExpectedConditions.invisibilityOf(undoLink));
	}

	public void clickSentFolderLink() {
		sentFolderLink.click();
	}
}
