package baseLayer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseClass {

	protected static WebDriver driver;

	public static void initialize() {

		System.setProperty("webdriver.edge.driver", "Drivers/msedgedriver.exe");

		driver = new EdgeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://www.makemytrip.com/flights/");

	}

}
