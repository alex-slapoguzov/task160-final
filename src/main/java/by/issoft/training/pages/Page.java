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
}
