package by.issoft.training.pages.folders;

import by.issoft.training.pages.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TrashFolder extends Page {

	@FindBy(xpath = "//div[@class=\"ae4 UI\"]//tr//span[@class=\"bog\"]/span")
	private List<WebElement> subjectFieldInLetterInTRASHFolderList;

	public TrashFolder() {
		super();
	}

	public boolean isLetterInTrashFolder(String subject) {
		return isLetterInFolder(subjectFieldInLetterInTRASHFolderList, subject);
	}
}
