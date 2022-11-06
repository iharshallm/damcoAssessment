package testLayer;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseLayer.BaseClass;
import pageLayer.FlightResultsPage;
import pageLayer.SearchFlightsPage;

public class searchFlightEndToEnd extends BaseClass {

	@BeforeTest()
	public void setUp() {
		BaseClass.initialize();
	}

	@Test(priority = 1)
	public void searchPg() {
		SearchFlightsPage search = new SearchFlightsPage(driver);
		search.handlePopUp();
		search.searchFrom("Delhi");
		search.searchTo("Mumbai");
		search.selectDate();
		search.hitSearch();
	}

	@Test(priority = 2)
	public void resultsPg() {
		FlightResultsPage results = new FlightResultsPage(driver);
		results.popUpClose();
		results.sort();
		results.printSecondCheapestFlightDetails();
	}

}
