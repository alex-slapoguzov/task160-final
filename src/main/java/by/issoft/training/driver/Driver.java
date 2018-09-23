package by.issoft.training.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

	private static WebDriver driver;
	private static String browser;
	private final static String HOME_URL = "https://gmail.com";

	public static WebDriver getDriver() {
		if (driver == null) {
			if (browser != null) {
				switch (browser) {
					case "Firefox":
						driver = new FirefoxDriver();
						break;
					case "Chrome":
						driver = new ChromeDriver();
						break;
				}
			} else {
				driver = new ChromeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		}
		return driver;
	}

	public static void openHomePage() {
		getDriver().get(HOME_URL);
	}

	public static void closeDriver() {
		getDriver().quit();
		driver = null;
	}

/*	public static void initSystem(String browser, String driverStrategy) {
		DriverStrategy webDriverStrategy;
		switch (driverStrategy) {
			case "grid":
				webDriverStrategy = new GridDriverStrategy();
				break;
			case "local":
				webDriverStrategy = new LocalDriverStrategy(browser);
				break;
			case "saucelabs":
				webDriverStrategy = new SaucelabsDriverStrategy();
				break;
			default:
				webDriverStrategy = new LocalDriverStrategy(browser);
				break;
		}
	}*/

}
