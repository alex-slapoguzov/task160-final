package by.issoft.training.pages;

import by.issoft.training.util.Waiter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewLetterPage extends Page {

	@FindBy(xpath = "//div[@class=\"wO nr l1\"]/textarea")
	private WebElement recipientsField;

	@FindBy(xpath = "//div[@class=\"T-I J-J5-Ji aoO T-I-atl L3\"]")
	private WebElement sendButton;

	@FindBy(xpath = "//div[@class=\"aoD az6\"]/input")
	private WebElement subjectField;

	public NewLetterPage() {
		super();
	}

	private void typeMailInRecipientsField(String user) {
		String email = user + "@gmail.com";
		recipientsField.click();
		recipientsField.sendKeys(email);
	}

	private void typeSubjectInSubjectField() {
		subjectField.sendKeys(subjectText);
	}

	private void clickSendButton() {
		sendButton.click();
	}

	public MailPage sendEmailToUser(String user) {
		Waiter.getWebDriverWait().until(ExpectedConditions.visibilityOf(recipientsField));
		typeMailInRecipientsField(user);
		typeSubjectInSubjectField();
		clickSendButton();

		return new MailPage();
	}
}
