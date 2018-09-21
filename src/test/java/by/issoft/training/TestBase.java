package by.issoft.training.tests;

import by.issoft.training.listener.GmailListener;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

@Listeners(GmailListener.class)
public class TestBase {

	/*@Parameters({})
	@BeforeSuite()
	public void initSystem(String browser)   {

	}

	private static void setWebDriverStrategy(String driverStrategy) {

		switch (driverStrategy) {
			case "grid":
				webDriverStrategy = new GridWebDriverStrategy();
				break;
			case "local":
				webDriverStrategy = new LocalWebDriverStrategy();
				break;
			case "saucelabs":
				webDriverStrategy = new GridWebDriverStrategy();
				break;
			default:
				webDriverStrategy = new LocalWebDriverStrategy();
				break;
		}

	}*/
}
