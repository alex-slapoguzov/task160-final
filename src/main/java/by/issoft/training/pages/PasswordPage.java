package by.issoft.training.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordPage extends Page {

	@FindBy(css = ".aXBtI.I0VJ4d.Wic03c .whsOnd.zHQkBf")
	private WebElement passwordField;

	@FindBy(id = "passwordNext")
	private WebElement nextButton;

	@FindBy(id = "profileIdentifier")
	private WebElement selectAccount;

	public PasswordPage() {
		super();
	}

	public boolean isPasswordPageLoadInTime() {
		return isPageLoadInTime(passwordField, nextButton);
	}

	public MailPage typePassword(String password) {
		passwordField.sendKeys(password);
		nextButton.click();

		return new MailPage();
	}


	public void clickSelectAccount() {
		selectAccount.click();
	}
}
