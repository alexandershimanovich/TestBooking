package by.htp.shim;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.shim.steps.Steps;
import by.htp.shim.utils.DataProviderManager;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class SearchHotelsTest {

	private Steps steps;
	private static final String DESIRED_CITY = "Minsk";
	private static final String NUMBER_OF_ADULTS = "9";

	@BeforeMethod(description = "Open Browser")
	public void start() {
		steps = new Steps();
		steps.openBrowser();
		steps.openWebSite();
		steps.changeToEnglishLanguage();
	}

	@Test(dataProvider = "Cities", dataProviderClass = DataProviderManager.class)
	public void correctNameOfCityTest(String city) {
		steps.enterFullDetailsOfTrip(city);
		Assert.assertEquals(city, steps.getInfoAboutCity());
	}

	@Test
	public void correctNumberOfAdualts() {
		steps.enterNameOfCityAndNumberOfAdults(DESIRED_CITY, NUMBER_OF_ADULTS);
		Assert.assertEquals(steps.takeInfoAboutAdults(), "Recommended for " + NUMBER_OF_ADULTS + " adults");
	}

	@AfterMethod(description = "Close Browser")
	public void finish() {
		steps.closeBrowser();
	}

}
