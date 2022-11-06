package pageLayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLayer.BaseClass;

public class FlightResultsPage extends BaseClass {

	@FindBy(xpath = "//button[text() = 'OKAY, GOT IT!']")
	WebElement popUp;

	@FindBy(xpath = "//div[@class='sortby-dom-sctn departure_sorter ']")
	WebElement sortByDeparture;

	@FindBy(xpath = "//p[@class='boldFont blackText airlineName']")
	List<WebElement> flightNames;

	@FindBy(xpath = "//p[@class='blackText fontSize18 blackFont white-space-no-wrap']")
	List<WebElement> flightPrices;

	public FlightResultsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	public void popUpClose() {

		popUp.click();

	}

	public void sort() {

		sortByDeparture.click();

	}

	public void printSecondCheapestFlightDetails() {

		HashMap<Integer, String> cat = new HashMap<Integer, String>();

		int price;
		String name;

		for (int i = 0; i < flightNames.size(); i++) {

			price = Integer.parseInt(flightPrices.get(i).getText().replaceAll("[^0-9]", ""));
			name = flightNames.get(i).getText();

			cat.put(price, name);

		}

		ArrayList<Integer> p = new ArrayList<Integer>(cat.keySet());
		Collections.sort(p);

		System.out.println("2nd cheapest ticket Price is : INR " + p.get(1));
		System.out.println("Flight Name for 2nd cheapest ticket Price is : " + cat.get(p.get(1)));
	}

}
