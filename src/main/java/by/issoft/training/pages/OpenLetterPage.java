package by.issoft.training.pages;

import by.issoft.training.util.Waiter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OpenLetterPage extends Page {

	@FindBy(xpath = "//h2[@class=\"hP\"]")
	private WebElement subjectField;

	@FindBy(xpath = "//div[@class=\" G-atb D E\"]")
	private WebElement toolbar;

	@FindBy(xpath = "//div[@class=\"T-I J-J5-Ji T-I-Js-Gs aap T-I-awG T-I-ax7 L3\"]")
	private WebElement moreButton;

	@FindBy(xpath = "//div[@id=\"tm\"]//div[@class=\"cj\"]")
	private WebElement deleteThisMessage;

	public OpenLetterPage() {
		super();
	}

	public boolean isOpenLetterPageLoadInTime() {
		return isPageLoadInTime(subjectField, toolbar);
	}

	public String getSubjectFromLetter() {
		return subjectField.getText();
	}

	public MailPage clickDeleteButton() {
		moreButton.click();
		deleteThisMessage.click();

		return new MailPage();
	}
}
