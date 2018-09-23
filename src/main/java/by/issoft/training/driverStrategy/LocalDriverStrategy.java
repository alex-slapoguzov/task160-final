/*
package by.issoft.training.driverStrategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class LocalDriverStrategy implements DriverStrategy {

	private final static String HOME_URL = "https://gmail.com";
	private static String browser;

	public LocalDriverStrategy(String browser) {
	}

	//@Override
	public void setStrategy() {
		WebDriver driver = null;

		switch (browser) {
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "chrome":
				driver = new ChromeDriver();
				break;
			default:
				driver = new FirefoxDriver();
				break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

		return driver;
	}


	public static void openHomePage() {
		setStrategy().get(HOME_URL);
	}

	public static void closeDriver() {
		setStrategy().quit();
		//driver = null;
	}


}
*/
