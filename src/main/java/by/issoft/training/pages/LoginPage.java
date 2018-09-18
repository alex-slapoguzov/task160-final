package by.issoft.training.pages;

import by.issoft.training.util.Waiter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends Page {

	@FindBy(id = "identifierId")
	private WebElement loginField;

	@FindBy(id = "identifierNext")
	private WebElement nextButton;

	public LoginPage() {
		super();
	}

	public boolean isLoginPageLoadInTime() {
		return isPageLoadInTime(loginField, nextButton);
	}

	public PasswordPage typeLogin(String email) {
		loginField.sendKeys(email);
		nextButton.click();

		return new PasswordPage();
	}
}
