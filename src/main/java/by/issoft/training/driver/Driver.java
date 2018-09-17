package by.issoft.training.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

	private static WebDriver driver;
	private final static String HOME_URL = "https://gmail.com";

	public static WebDriver getDriver() {
		if (driver == null) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
}
