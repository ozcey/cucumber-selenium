package bdd.cucumber_selenium.utils;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import bdd.cucumber_selenium.page_objects.PageObjectManager;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class Utils {

	WebDriver driver;

	public Utils(WebDriver driver) {
		driver = this.driver;
	}

	public PageObjectManager getPageObjectManager() {
		return new PageObjectManager(driver);
	}

	public void getDriver() {
		driver.get(Constants.BaseURL.getName());
	}

	public void setUp() {
		System.setProperty(Constants.DRIVER.getName(), Constants.DRIVER_PATH.getName());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	public void validateText(String expected, String actual) {
		assertEquals(expected, actual);
	}

	public void waitUntil(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void getAlert() {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
	}

}
