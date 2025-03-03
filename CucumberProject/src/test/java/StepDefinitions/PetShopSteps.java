package StepDefinitions;

import io.cucumber.java.en.*;
import io.cucumber.java.en.Given;
import pages.PetShopPage;
import utils.ConfigReader;
import utils.WebDriverFactory;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PetShopSteps {

	public static WebDriver driver;

	@Given("Given The user navigates to homepage on {string}")
	public void given_the_user_navigates_to_homepage_on(String browser) {
		try {
			driver = WebDriverFactory.getDriver(browser);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigReader.getImplicitWait()));
			driver.get(ConfigReader.getUrl());
		} catch (Exception e) {
			System.out.println("Error occured. " + e.getMessage());
		}
	}

	@When("The user selects the Pet Shop category from the Kategoriler section")
	public void the_user_selects_the_category_from_the_section() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getExplicitWait()));
			Actions actions = new Actions(driver);
			JavascriptExecutor js = (JavascriptExecutor) driver;

			WebElement closeIcon = driver.findElement(PetShopPage.CLOSE_ICON);
			actions.moveToElement(closeIcon).click().perform();

			WebElement categoryMenu = driver.findElement(PetShopPage.CATEGORY_MENU);
			actions.moveToElement(categoryMenu).perform();
			WebElement petShopLink = wait.until(ExpectedConditions.elementToBeClickable(PetShopPage.PET_SHOP_LINK));
			js.executeScript("arguments[0].click();", petShopLink);
			System.out.println("Pet Shop kategorisine tıklandı");
		} catch (Exception e) {
			System.out.println("Error occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("The user verifies that the page is displayed")
	public void the_user_verifies_that_the_page_is_displayed() {
		try {

			String currentUrl = driver.getCurrentUrl();
			currentUrl.contains("https://www.migros.com.tr/pet-shop-c-a0");
			System.out.println("Sayfa yüklendi. Validasyon başarılı:" + currentUrl + " doğrulandı");

		} catch (Exception e) {
			System.out.println("Error occured: " + e.getMessage());
		}
	}

	@When("The user sorts the products by lowest price first")
	public void the_user_sorts_products() {
		try {
			Actions actions = new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getExplicitWait()));
			WebElement outsideElement = driver.findElement(PetShopPage.OUTSIDE_ELEMENT);
			actions.moveToElement(outsideElement).click().perform();

			WebElement sortproduct1 = driver.findElement((PetShopPage.SORT_DROPDOWN));
			actions.moveToElement(sortproduct1).click().perform();
			System.out.println("Önerilenlere tıklandı.");

			WebElement sortproduct2= wait.until(ExpectedConditions.elementToBeClickable(PetShopPage.SORT_LOWEST_PRICE));
			//WebElement sortproduct2 = driver.findElement(PetShopPage.SORT_LOWEST_PRICE);
			actions.moveToElement(sortproduct2).click().perform();
			System.out.println("Öncelikle en düşük seçildi");

		} catch (Exception e) {
			System.out.println("Error occured: " + e.getMessage());
		}
	}

	@Then("The user verifies that the products are sorted by lowest price first")
	public void the_user_verifies_sorted_products() {

		try {

			List<WebElement> priceElements = driver.findElements(PetShopPage.PRICE_ELEMENTS);
			List<Double> actualPrices = new ArrayList<Double>();

			for (WebElement element : priceElements) {
				String priceText = element.getText().replaceAll("[^0-9.]", "").replace(",", ".");
				if (!priceText.isEmpty()) {
					actualPrices.add(Double.parseDouble(priceText));
				}
			}

			List<Double> expectedPrices = new ArrayList<Double>(actualPrices);
			Collections.sort(expectedPrices);
			DecimalFormat df = new DecimalFormat("#.##");

			System.out.println("Gerçek fiyatlar:");
			for (Double price : actualPrices) {
				System.out.println(df.format(price));
			}

			System.out.println("Beklenen fiyatlar:");
			for (Double price : expectedPrices) {
				System.out.println(df.format(price));
			}

			System.out.println("Validasyon başarılı ");
		} catch (Exception e) {
			System.out.println("Error occured: " + e.getMessage());
		}

	}

}
