package by.issoft.training.pages.folders;

import by.issoft.training.pages.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SentFolder extends Page {

	@FindBy(xpath = "//div[@class=\"ae4 UI\"]//tr//span[@class=\"bog\"]/span")
	private List<WebElement> subjectFieldInLetterInSENTFolderList;

	public SentFolder() {
		super();
	}

	public boolean isLetterInSentFolder() {
		return isLetterInFolder(subjectFieldInLetterInSENTFolderList, subjectText);
	}
}
