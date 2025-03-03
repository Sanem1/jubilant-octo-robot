package Hooks;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import StepDefinitions.PetShopSteps;

public class TestLifecycle {
	public static WebDriver driver;

	@After
	public void teardown() {
		if (PetShopSteps.driver != null) {
			System.out.println("Driver kapatılıyor...");
			PetShopSteps.driver.quit();
			PetShopSteps.driver = null;
		}
	}
}
