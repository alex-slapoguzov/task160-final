package by.issoft.training.pages;

import by.issoft.training.driver.Driver;
import by.issoft.training.util.Waiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Page {

	protected WebDriver driver;

	public Page() {
		driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	public boolean isPageLoadInTime(WebElement element1, WebElement element2) {
		if (Waiter.getWebDriverWait().until(ExpectedConditions.visibilityOf(element1)).isDisplayed()
				&& Waiter.getWebDriverWait().until(ExpectedConditions.visibilityOf(element2)).isDisplayed()) {
			return true;
		} else return false;
	}
}
