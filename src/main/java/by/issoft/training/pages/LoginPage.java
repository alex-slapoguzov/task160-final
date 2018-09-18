package by.issoft.training.pages;

import by.issoft.training.util.Waiter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends Page {

	@FindBy(id = "identifierId")
	private WebElement loginField;

	@FindBy(xpath = "//div[@id=\"identifierNext\"]//span")
	private WebElement nextButton;

	@FindBy(css = ".aXBtI.I0VJ4d.Wic03c .whsOnd.zHQkBf")
	private WebElement passwordField;

	@FindBy(id = "profileIdentifier")
	private WebElement selectAccount;

	public LoginPage() {
		super();
	}

	public MailPage login(String email, String password) {
		loginField.sendKeys(email);
		nextButton.click();
		Waiter.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(passwordField));
		passwordField.sendKeys(password);
		nextButton.click();

		return new MailPage();
	}

	public boolean isLoginPage() {
		if (Waiter.getWebDriverWait().until(ExpectedConditions.visibilityOf(passwordField)).isDisplayed()
				&& Waiter.getWebDriverWait().until(ExpectedConditions.visibilityOf(nextButton)).isDisplayed()) {
			return true;
		} else return false;
	}

	public void clickSelectAccount() {
		selectAccount.click();
	}
}
