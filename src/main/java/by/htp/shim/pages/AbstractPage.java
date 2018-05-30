package by.htp.shim.pages;

import static by.htp.shim.utils.PropertiesReader.getPropertyValue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

	protected static final int EXPLICIT_WAIT = Integer.parseInt(getPropertyValue("EXPLICIT_WAIT"));
	protected WebDriver driver;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public abstract void openPage();
}
