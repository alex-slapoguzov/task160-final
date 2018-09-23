package by.issoft.training;


import by.issoft.training.driver.Driver;
/*import by.issoft.training.driverStrategy.DriverStrategy;
import by.issoft.training.driverStrategy.GridDriverStrategy;
import by.issoft.training.driverStrategy.LocalDriverStrategy;
import by.issoft.training.driverStrategy.SaucelabsDriverStrategy;*/
import by.issoft.training.listener.GmailListener;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@Listeners(GmailListener.class)
public class TestBase {

	public static String browser;


/*	@Parameters({"Browser-name", "driverStrategy"})
	@BeforeSuite()
	public void initSystem(@Optional String browser, String driverStrategy) {
		TestBase.browser = browser;
		//Driver.initSystem(browser, driverStrategy);//setWebDriverStrategy(browser, driverStrategy);
	}*/
}
