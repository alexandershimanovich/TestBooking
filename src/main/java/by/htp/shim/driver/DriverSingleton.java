package by.htp.shim.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static by.htp.shim.utils.PropertiesReader.getPropertyValue;

public abstract class DriverSingleton {

	private static WebDriver driver;
	private static final int IMPLICIT_WAIT = Integer.parseInt(getPropertyValue("IMPLICIT_WAIT"));
	private static final int PAGE_LOAD_TIMEOUT = Integer.parseInt(getPropertyValue("PAGE_LOAD_TIMEOUT"));

	private DriverSingleton() {
	}

	public static WebDriver getDiver() {
		if (driver == null) {
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		return driver;
	}

	public static void closeDriver() {
		driver.quit();
		driver = null;
	}

}
