package by.issoft.training.pages.folders;

import by.issoft.training.pages.OpenLetterPage;
import by.issoft.training.pages.Page;
import by.issoft.training.util.Random;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InboxFolder extends Page {

	@FindBy(xpath = "//div[@class=\"UI\"]//tr//span[@class=\"bog\"]/span")
	private List<WebElement> subjectFieldInLetterInInboxFolderList;

	public InboxFolder() {
		super();
	}

	public boolean isLetterInInboxFolder() {
		return isLetterInFolder(subjectFieldInLetterInInboxFolderList, subjectText);
	}

	private WebElement getRandomLetterFromInboxFolder() {
		int randomNumberLetter = Random.randomNumberFromList(subjectFieldInLetterInInboxFolderList);

		return subjectFieldInLetterInInboxFolderList.get(randomNumberLetter);
	}

	public OpenLetterPage openRandomLetterInInboxFolder() {
		getRandomLetterFromInboxFolder().click();

		return new OpenLetterPage();
	}
}
