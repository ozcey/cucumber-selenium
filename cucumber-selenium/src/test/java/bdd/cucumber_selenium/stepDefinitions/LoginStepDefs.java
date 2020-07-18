package bdd.cucumber_selenium.stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class LoginStepDefs {

	WebDriver driver;

	@Before
	public void before() {
		System.setProperty("webdriver.chrome.driver", "F:\\PROGRAMMING\\SDET\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
	}

	@After
	public void after() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	@Given("^User navigates to home page on the website$")
	public void user_navigates_to_home_page_on_the_website() throws Throwable {
		driver.get("http://localhost:4200");
	}

	@And("^User clicks on the login button on home page$")
	public void user_clicks_on_the_login_button_on_home_page() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[2]/li[2]/a")).click();
	}

	@Then("^User should be taken the successful login page$")
	public void user_should_be_taken_the_successful_login_page() throws Throwable {
		String text = driver
				.findElement(By.xpath("/html/body/app-root/section/main/app-login/section/mat-card/mat-card-title"))
				.getText();
		assertEquals("Login", text);
	}

	@And("^User enters a valid username$")
	public void user_enters_a_valid_username() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).sendKeys("markj@gmail.com");

	}

	@And("^User enters a valid password$")
	public void user_enters_a_valid_password() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).sendKeys("password");
	}

	@When("^User clicks on the login button$")
	public void user_clicks_on_the_login_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/section/main/app-login/section/mat-card/form/button")).click();
	}

	@Then("^User should be taken the successful customer page$")
	public void user_should_be_taken_the_successful_customer_page() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"mat-tab-label-0-1\"]/div")));
		String text = driver.findElement(By.xpath("//*[@id=\"mat-tab-label-0-1\"]/div")).getText();
		assertEquals("Customer List", text);
	}

}
