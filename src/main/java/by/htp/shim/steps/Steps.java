package by.htp.shim.steps;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import by.htp.shim.driver.DriverSingleton;
import by.htp.shim.pages.FlightsPage;
import by.htp.shim.pages.MainPage;

public class Steps {

	private ArrayList<String> tabs;
	private WebDriver driver;

	public void openBrowser() {
		driver = DriverSingleton.getDiver();
	}

	public void closeBrowser() {
		DriverSingleton.closeDriver();
	}

	public void openWebSite() {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
	}

	public void changeToEnglishLanguage() {
		MainPage mainPage = new MainPage(driver);
		mainPage.putEnglishLanguage();
	}

	public void enterNameOfCityAndNumberOfAdults(String nameOfCity, String numberOfAdults) {
		MainPage mainPage = new MainPage(driver);
		mainPage.putCity(nameOfCity);
		mainPage.putNumberOfAdults(numberOfAdults);
		mainPage.putDateOfTrip();
		mainPage.clickSubmit();
	}

	public void enterFullDetailsOfTrip(String nameOfCity) {
		MainPage mainPage = new MainPage(driver);
		mainPage.putCity(nameOfCity);
		mainPage.putDateOfTrip();
		mainPage.clickSubmit();
	}

	public String getInfoAboutCity() {
		MainPage mainPage = new MainPage(driver);
		return mainPage.takeMainSearchInfo().split(":")[0];
	}

	public String takeInfoAboutAdults() {
		MainPage mainPage = new MainPage(driver);
		return mainPage.takeAdultsInfo();
	}

	public void changeTabToFlight() {
		MainPage mainPage = new MainPage(driver);
		mainPage.clickTabFlights();
		tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}

	public String getInfoAboutTaglineOfPage() {
		FlightsPage flightPage = new FlightsPage(driver);
		return flightPage.takeTaglineOfPage();
	}

	public void enterFullDetailsOfFlight(String originLocation, String destinationLocation, String dateOfFlight) {
		FlightsPage flightPage = new FlightsPage(driver);
		flightPage.putOriginLocation(originLocation);
		flightPage.putDestinationLocation(destinationLocation);
		flightPage.putDateOfFlight(dateOfFlight);
		flightPage.putSubmit();
	}

	public String getTitleFromActualFlight() {
		FlightsPage flightPage = new FlightsPage(driver);
		return flightPage.takeOriginLocation();
	}

	public boolean currentBlockIsDisplay() {
		FlightsPage flightPage = new FlightsPage(driver);
		return flightPage.isBlockofBestFlight();
	}

}
