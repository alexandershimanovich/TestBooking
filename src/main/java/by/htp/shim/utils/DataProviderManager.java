package by.htp.shim.utils;

import org.testng.annotations.DataProvider;

public class DataProviderManager {

	@DataProvider(name = "Cities")

	public static Object[][] credentials() {

		return new Object[][] { { "Minsk" }, { "Manchester" } };

	}

}
