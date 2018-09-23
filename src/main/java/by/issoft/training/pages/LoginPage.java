package by.issoft.training.pages;

import by.issoft.training.util.Waiter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LoginPage extends Page {

	@FindBy(id = "identifierId")
	private WebElement loginField;

	@FindBy(id = "identifierId")
	private List<WebElement> loginFieldList;

	@FindBy(xpath = "//*[@id = 'identifierNext' or " + "@id = 'passwordNext']")
	private WebElement nextButton;

	@FindBy(css = ".aXBtI.I0VJ4d.Wic03c .whsOnd.zHQkBf")
	private WebElement passwordField;

	@FindBy(id = "profileIdentifier")
	private WebElement selectAccount;

	@FindBy(id = "headingText")
	private WebElement headingTextNode;

	@FindBy(xpath = "//div[@class=\"TnvOCe k6Zj8d XraQ3b bLzI3e\"]")
	private WebElement changeAccount;

	@FindBy(xpath = "//div[@class=\"TnvOCe k6Zj8d XraQ3b bLzI3e\"]")
	private List<WebElement> changeAccountList;

	@FindBy(xpath = "//div[@class=\"qZp31e\"]")
	private WebElement googleImage;

	public LoginPage() {
		super();
	}

	public boolean isLoginPageLoadInTime() {
		return isPageLoadInTime(headingTextNode, googleImage);
	}

	public MailPage login(String email, String password) {
		if (isElementDisplayed(loginFieldList)) {
			loginField.sendKeys(email);
			nextButton.click();
			Waiter.getWebDriverWait().until(ExpectedConditions.visibilityOf(passwordField));
			passwordField.sendKeys(password);
			nextButton.click();
		} else if (!(isElementDisplayed(changeAccountList))) {
			clickSelectAccount();
			clickChangeAccount();
			Waiter.getWebDriverWait().until(ExpectedConditions.visibilityOf(loginField));
			loginField.sendKeys(email);
			nextButton.click();
			Waiter.getWebDriverWait().until(ExpectedConditions.visibilityOf(passwordField));
			passwordField.sendKeys(password);
			nextButton.click();
		} else {
			clickChangeAccount();
			Waiter.getWebDriverWait().until(ExpectedConditions.visibilityOf(loginField));
			loginField.sendKeys(email);
			nextButton.click();
			Waiter.getWebDriverWait().until(ExpectedConditions.visibilityOf(passwordField));
			passwordField.sendKeys(password);
			nextButton.click();
		}

		return new MailPage();
	}

	public void clickSelectAccount() {
		selectAccount.click();
	}

	public void clickChangeAccount() {
		Waiter.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(changeAccount));
		changeAccount.click();
	}
}
