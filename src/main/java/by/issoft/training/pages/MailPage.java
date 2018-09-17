package by.issoft.training.pages;

import by.issoft.training.util.Waiter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailPage extends Page {

    @FindBy(xpath = "//a[@class=\"gb_me gb_dc gb_De\"]")
    private WebElement gmailTitleNode;

    @FindBy(xpath = "//div[@class='gb_Qc gb_ib gb_Sg gb_R']/a")
    private WebElement userAccountButton;

    @FindBy(id = "gb_71")
    private WebElement signOutButton;

    @FindBy(xpath = "//div[@class=\"T-I J-J5-Ji T-I-KE L3\"]")
    private WebElement composeButton;

    @FindBy(xpath = "//div[@class=\"wO nr l1\"]/textarea")
    private WebElement recipientsField;

    @FindBy(xpath = "//div[@class=\"T-I J-J5-Ji aoO T-I-atl L3\"]")
    private WebElement sendButton;

    @FindBy(xpath = "//div[@class=\"aoD az6\"]/input")
    private WebElement subjectField;

    private final static String subjectText = "Final task";

    public MailPage() {
        super();
    }

    public boolean isMailPage() {
        if (Waiter.getWebDriverWait().until(ExpectedConditions.visibilityOf(userAccountButton)).isDisplayed()
                && Waiter.getWebDriverWait().until(ExpectedConditions.visibilityOf(gmailTitleNode)).isDisplayed()) {
            return true;
        } else return false;
    }

    public LoginPage logout() {
        userAccountButton.click();
        Waiter.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(signOutButton));
        signOutButton.click();

        return new LoginPage();
    }

    public void clickComposeButton(){
        composeButton.click();
    }

    public void typeMailInRecipientsField(String user){
        String email = user + "@gmail.com";
        recipientsField.click();
        recipientsField.sendKeys(email);
    }

    public void typeSubjectInSubjectField(){
      //  subjectField.click();
        subjectField.sendKeys(subjectText);
    }

    public void clickSendButton(){
        sendButton.click();
    }

    public void sendEmailToUser(String user){
        clickComposeButton();
        Waiter.getWebDriverWait().until(ExpectedConditions.visibilityOf(recipientsField));
        typeMailInRecipientsField(user);
        typeSubjectInSubjectField();
        clickSendButton();
    }
}
