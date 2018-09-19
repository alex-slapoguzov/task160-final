package by.issoft.training.pages;

import by.issoft.training.driver.Driver;
import by.issoft.training.util.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

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

	public void refreshPage() {
		Driver.getDriver().navigate().refresh();
	}

	public boolean isLetterInFolder(String mail, List<WebElement> listWithLetter, String subjectText, By emailFieldByLetterInFolder, By subjectFieldByLetterInFolder) {
		refreshPage();
		List<WebElement> letterWithGivenEmailAndSubjectList = new ArrayList<WebElement>();
		String gmailEmail = mail + "@gmail.com";

		for (WebElement element : listWithLetter) {
			if (element.findElement(emailFieldByLetterInFolder).getAttribute("email").equals(gmailEmail)
					&& element.findElement(subjectFieldByLetterInFolder).getText().equals(subjectText)) {
				letterWithGivenEmailAndSubjectList.add(element);
			}
		}

		if (letterWithGivenEmailAndSubjectList.size() == 1) {
			return true;
		} else return false;
	}
}
