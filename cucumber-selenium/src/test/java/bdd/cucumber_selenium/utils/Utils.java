package bdd.cucumber_selenium.utils;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Utils {

	WebDriver driver;

	public void getDriver() {
		driver.get(Constants.URL);
	}

	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "F:\\PROGRAMMING\\SDET\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	public void findElement(String xpath, String event, String payload) {
		switch (event) {
		case Constants.CLICK:
			driver.findElement(By.xpath(xpath)).click();
			break;
		case Constants.SEND_KEYS:
			driver.findElement(By.xpath(xpath)).sendKeys(payload);
			break;
		}

	}

	public String getText(String xPath) {
		return driver.findElement(By.xpath(xPath)).getText();
	}

	public void validateText(String expected, String actual) {
		assertEquals(expected, actual);
	}

	public void waitUntil(String xPath) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
	}

	public void getAlert() {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
	}

}
