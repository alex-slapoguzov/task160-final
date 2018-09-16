package by.issoft.training.util;

import by.issoft.training.driver.Driver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {

    public static WebDriverWait getWebDriverWait() {
        return new WebDriverWait(Driver.getDriver(), 15);
    }
}
