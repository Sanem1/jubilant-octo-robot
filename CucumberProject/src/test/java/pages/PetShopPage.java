package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConfigReader;

import java.time.Duration;

public class PetShopPage {
	private static WebDriver driver;
	private WebDriverWait wait;

	public PetShopPage(WebDriver driver) {
		PetShopPage.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getExplicitWait()));
	}

	// Locators
	public static final By CLOSE_ICON = By.cssSelector(".svg-inline--fa.fa-xmark");
	public static final By CATEGORY_MENU = By.className("categories-icon");
	public static final By PET_SHOP_LINK = By.id("header-categories--pet-shop-c-a0");
	public static final By OUTSIDE_ELEMENT = By.xpath("//div[@class='chip-sort-row desktop-only']");
	public static final By SORT_DROPDOWN = By.cssSelector(".mat-mdc-select-arrow-wrapper[class*='ng-tns-']");
	public static final By SORT_LOWEST_PRICE = By.xpath("//span[@class='mdc-list-item__primary-text'][contains(text(),'Önce En Düşük Fiyat')]");
	public static final By PRICE_ELEMENTS = By.xpath("//div[@class='price-container']");

}