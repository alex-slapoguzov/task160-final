package by.issoft.training.dataProvider;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "loginWithValidCredentials")
    public Object[][] loginWithValidCredentials() {
        return new Object[][]{
                {"seleniumtests10", "060788avavav"},
                {"seleniumtests30", "060788avavav"},
                {"seleniumtests40", "060788avavav"}
        };
    }

    @DataProvider(name = "verifyTheAbilityToSendEmails")
    public Object[][] verifyTheAbilityToSendEmails() {
        return new Object[][]{
                {"seleniumtests10", "060788avavav", "seleniumtests30", "060788avavav"},
        };
    }
}
