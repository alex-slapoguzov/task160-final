package by.issoft.training;

import by.issoft.training.dataProvider.DataProviders;
import by.issoft.training.driver.Driver;
import by.issoft.training.pages.LoginPage;
import by.issoft.training.pages.MailPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginAndLogoutTest {

    private LoginPage loginPage;
    private MailPage mailPage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage();
        mailPage = new MailPage();
        Driver.openHomePage();
    }

    @Test(dataProvider = "loginWithValidCredentials", dataProviderClass = DataProviders.class)
    public void loginToGmailWithValidCredentialsTest(String email, String password) {
        loginPage.login(email, password);
        Assert.assertTrue(mailPage.isMailPage(), "User with " + email + " and " + password + " wasn't signed in");
    }

    @Test(dataProvider = "loginWithValidCredentials", dataProviderClass = DataProviders.class)
    public void logoutFromGmail(String email, String password) {
        loginPage.login(email, password);
        mailPage.isMailPage();
        mailPage.logout();
        Assert.assertTrue(loginPage.isLoginPage(), "User with " + email + " and " + password + " wasn't signed out");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        Driver.closeDriver();
    }
}
