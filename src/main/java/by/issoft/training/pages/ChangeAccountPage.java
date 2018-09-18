package by.issoft.training.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangeAccountPage extends Page {

	@FindBy(xpath = "//div[@class=\"TnvOCe k6Zj8d XraQ3b bLzI3e\"]")
	private WebElement changeAccount;

	@FindBy(css = ".q4UYxb")
	private WebElement deleteAccountButton;

	public ChangeAccountPage() {
		super();
	}

	public boolean isChangeAccountPageLoadInTime(){
		return isPageLoadInTime(changeAccount, deleteAccountButton);
	}

	public void clickChangeAccount(){
		changeAccount.click();
	}
}
