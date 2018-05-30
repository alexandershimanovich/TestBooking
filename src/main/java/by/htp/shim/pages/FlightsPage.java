package by.htp.shim.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightsPage extends AbstractPage {

	@FindBy(xpath = "//div[@class='keel-container s-t-bp']")
	private WebElement taglineOfPage;

	@FindBy(xpath = "//label[@class='r9-radiobuttonset-label r9-radiobuttonset-label-checked focus']")
	private WebElement buttonOnWay;

	@FindBy(xpath = "//div[@class='roundtrip rtow']//div[@class='fieldBlock airportBlock originBlock']/div/input")
	private WebElement formOriginLocation;

	@FindBy(xpath = "//div[@class='col-field col-airport col-destination switch']/div/input")
	private WebElement formDestinationLocation;

	@FindBy(xpath = "//div[@class='keel-grid dateRangeGrid']/div[1]/div/div[2]")
	private WebElement formDateOfFlight;

	@FindBy(xpath = "//div[@class='fieldBlock buttonBlock']")
	private WebElement buttonFind;

	@FindBy(xpath = "//div[@class='col-field time depart']/div[2]")
	private List<WebElement> listOfLocations;

	@FindBy(xpath = "//div[@class='best-flights-header']")
	private WebElement blockBestFlight;

	public FlightsPage(WebDriver driver) {
		super(driver);
	}

	public String takeTaglineOfPage() {
		return taglineOfPage.getText();
	}

	public void putOriginLocation(String originLocation) {
		formOriginLocation.click();
		formOriginLocation.clear();
		formOriginLocation.sendKeys(originLocation);
		formOriginLocation.sendKeys(Keys.ENTER);
	}

	public void putDestinationLocation(String destinationLocation) {
		formDestinationLocation.click();
		formDestinationLocation.clear();
		formDestinationLocation.sendKeys(destinationLocation);
		formDestinationLocation.sendKeys(Keys.ENTER);
	}

	public void putDateOfFlight(String dateOfFlight) {
		buttonOnWay.click();

		formDateOfFlight.click();
		formDateOfFlight.sendKeys(dateOfFlight);
		formDateOfFlight.sendKeys(Keys.ENTER);
	}

	public void putSubmit() {
		buttonFind.click();
	}

	public String takeOriginLocation() {
		return listOfLocations.get(0).getText();
	}

	public boolean isBlockofBestFlight() {
		new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(blockBestFlight));
		return blockBestFlight.isDisplayed();
	}

	@Override
	public void openPage() {
	}

}