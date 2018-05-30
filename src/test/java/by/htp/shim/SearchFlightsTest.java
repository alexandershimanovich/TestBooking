package by.htp.shim;

import org.testng.annotations.Test;

import by.htp.shim.steps.Steps;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class SearchFlightsTest {

	private static final String TAGLINE = "Search hundreds of travel sites at once.";
	private static final String ORIGIN_LOCATION = "Minsk";
	private static final String DESTINATION_LOCATION = "Lviv";
	private static final String DATE_OF_FLIGHT = "1/06";
	private static final String ORIGIN_LOCATION_MSQ = "MSQ";
	private Steps steps;

	@BeforeMethod(description = "Open Browser")
	public void start() {
		steps = new Steps();
		steps.openBrowser();
		steps.openWebSite();
		steps.changeToEnglishLanguage();
		steps.changeTabToFlight();
	}

	@Test
	public void positivePageTest() {
		steps.getInfoAboutTaglineOfPage();
		Assert.assertEquals(steps.getInfoAboutTaglineOfPage(), TAGLINE);
	}

	@Test
	public void positiveOriginLocationTest() {
		steps.enterFullDetailsOfFlight(ORIGIN_LOCATION, DESTINATION_LOCATION, DATE_OF_FLIGHT);
		String originLocation = steps.getTitleFromActualFlight();
		Assert.assertEquals(originLocation, ORIGIN_LOCATION_MSQ);
	}

	@Test
	public void bestFlightIsTrue() {
		steps.enterFullDetailsOfFlight(ORIGIN_LOCATION, DESTINATION_LOCATION, DATE_OF_FLIGHT);
		Assert.assertTrue(steps.currentBlockIsDisplay());
	}

	@AfterMethod(description = "Close Browser")
	public void finish() {
		steps.closeBrowser();
	}

}
