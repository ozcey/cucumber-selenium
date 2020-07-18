package bdd.cucumber_selenium.utils;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Utils {

	public void setUp(WebDriver driver) {
		System.setProperty("webdriver.chrome.driver", "F:\\PROGRAMMING\\SDET\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
//		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
	}

	public void tearDown(WebDriver driver) {
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	public WebElement findElelement(WebDriver driver, String xPath) {
		return driver.findElement(By.xpath(xPath));
	}

	public void validateText(String expected, String actual) {
		assertEquals(expected, actual);
	}

	public  void waitUntil(WebDriver driver, String xPath) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
	}

}
