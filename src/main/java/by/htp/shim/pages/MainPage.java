package by.htp.shim.pages;

import static by.htp.shim.utils.PropertiesReader.getPropertyValue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage {

	private static final String URL = getPropertyValue("URL");

	@FindBy(xpath = "//li[@data-id='language_selector']")
	private WebElement labelChangeLanguage;

	@FindBy(xpath = "//a[contains(@hreflang, 'en-gb')]")
	private WebElement labelEnglishLanguage;

	@FindBy(xpath = "//input[@id='ss']")
	private WebElement formSearchDestination;

	@FindBy(xpath = "//div[contains(@data-placeholder, 'Check-in date')]")
	private WebElement formCheckInDate;

	@FindBy(xpath = "//td[@data-id='1527811200000']")
	private WebElement dateIn;

	@FindBy(xpath = "//select[@id='group_adults']")
	private WebElement formNumberOfAdults;

	@FindBy(xpath = "//select[@id='group_children']")
	private WebElement formNumberOfChildren;

	@FindBy(xpath = "//select[@id='no_rooms']")
	private WebElement formNumberOfRooms;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement buttonSubmit;

	@FindBy(xpath = "//div[@class='sr_header ']")
	private WebElement mainSearchInfo;

	@FindBy(xpath = "//div[@class='room_details ']/h4")
	private WebElement adultsInfo;

	@FindBy(xpath = "//a[@data-ga-track='click|Product Expansion|flights|kayak (index)']")
	private WebElement tabFlights;

	public MainPage(WebDriver driver) {
		super(driver);
	}

	public MainPage putEnglishLanguage() {
		labelChangeLanguage.click();
		labelEnglishLanguage.click();
		return this;
	}

	public void putCity(String nameOfCity) {
		new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(formSearchDestination));
		formSearchDestination.clear();
		formSearchDestination.sendKeys(nameOfCity);
	}

	public void putNumberOfAdults(String numberOfAdults) {
		formNumberOfAdults.click();
		formNumberOfAdults.sendKeys(numberOfAdults);
		formNumberOfAdults.sendKeys(Keys.ENTER);
	}

	public void putDateOfTrip() {
		formCheckInDate.click();
		dateIn.click();
	}

	public MainPage clickSubmit() {
		buttonSubmit.click();
		return this;
	}

	public String takeMainSearchInfo() {
		return mainSearchInfo.getText();
	}

	public String takeAdultsInfo() {
		return adultsInfo.getText();
	}

	public FlightsPage clickTabFlights() {
		tabFlights.click();
		return new FlightsPage(driver);
	}

	@Override
	public void openPage() {
		driver.get(URL);
	}

}
