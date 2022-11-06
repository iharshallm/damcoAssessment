package pageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLayer.BaseClass;

public class SearchFlightsPage extends BaseClass {

	@FindBy(xpath = "//div[@data-cy='outsideModal']")
	WebElement overlay;

	@FindBy(xpath = "//input[@id='fromCity']")
	WebElement fromBtn;

	@FindBy(xpath = "//input[@placeholder='From']")
	WebElement fromInput;

	@FindBy(xpath = "//ul[@role='listbox']//li[1]")
	WebElement suggestionOne;

	@FindBy(xpath = "//input[@id='toCity']")
	WebElement toBtn;

	@FindBy(xpath = "//input[@placeholder='To']")
	WebElement toInput;

	@FindBy(xpath = "//p[@data-cy='departureDate']")
	WebElement dateBtn;

	@FindBy(xpath = "//div[@aria-label='Mon Nov 14 2022']")
	WebElement dateToSelect;

	@FindBy(xpath = "//a[text() = 'Search']")
	WebElement searchBtn;

	public SearchFlightsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void handlePopUp() {
		overlay.click();
	}

	public void searchFrom(String from) {
		fromBtn.click();
		fromInput.sendKeys(from);
	}

	public void searchTo(String to) {
		toBtn.click();
		toInput.sendKeys(to);
	}

	public void selectDate() {
		dateBtn.click();
		dateToSelect.click();
	}

	public void hitSearch() {
		searchBtn.click();
	}
}
