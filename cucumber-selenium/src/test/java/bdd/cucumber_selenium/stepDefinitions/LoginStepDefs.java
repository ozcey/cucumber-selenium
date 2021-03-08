package bdd.cucumber_selenium.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bdd.cucumber_selenium.page_objects.LoginPage;
import bdd.cucumber_selenium.page_objects.PageObjectManager;
import bdd.cucumber_selenium.utils.Constants;
import bdd.cucumber_selenium.utils.Utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class LoginStepDefs {

	WebDriver driver;
	Utils utils;
	PageObjectManager pageObjectManager;
	LoginPage loginPage;

	@Before
	public void before() {
		utils = new Utils(driver);
		utils.setUp();
		pageObjectManager = utils.getPageObjectManager();
	}

	@After
	public void after() {
		utils.tearDown();
	}

	@Given("^User navigates to home page on the website$")
	public void user_navigates_to_home_page_on_the_website() throws Throwable {
		utils.getDriver();
	}

	@And("^User clicks on the login button on home page$")
	public void user_clicks_on_the_login_button_on_home_page() throws Throwable {
		loginPage = pageObjectManager.getLoginPage();
		loginPage.clickLoginButton();
	}

	@Then("^User should be taken the successful login page$")
	public void user_should_be_taken_the_successful_login_page() throws Throwable {
		WebElement loginText = loginPage.getLoginText();
		utils.waitUntil(loginText);
		utils.validateText("Login", loginText.getText());
	}

	@And("^User enters a valid username$")
	public void user_enters_a_valid_username() throws Throwable {
		loginPage.enterUsername("markj@gmail.com");
	}

	@And("^User enters a valid password$")
	public void user_enters_a_valid_password() throws Throwable {
		loginPage.enterPassword("password");
	}

	@When("^User clicks on the login button$")
	public void user_clicks_on_the_login_button() throws Throwable {
		loginPage.clickSubmitButton();
	}

	@Then("^User should be taken the successful customer page$")
	public void user_should_be_taken_the_successful_customer_page() throws Throwable {
		WebElement customerText = loginPage.getCustomerText();
		utils.waitUntil(customerText);
		utils.validateText("Customer List", customerText.getText());
	}

	@And("^User enters an invalid username (.+)$")
	public void user_enters_an_invalid_username(String username) throws Throwable {
		loginPage.enterUsername(username);
	}

	@And("^User enters an invalid password (.+)$")
	public void user_enters_an_invalid_password(String password) throws Throwable {
		loginPage.enterPassword(password);
	}

	@Then("^User gets an (.+) message$")
	public void user_gets_an_message(String error) throws Throwable {
		WebElement usernameErrorText = loginPage.getUsernameErrorText();
		utils.waitUntil(usernameErrorText);
		utils.validateText(error, usernameErrorText.getText());
	}

	@And("^User clicks on the dropdwon menu on navbar$")
	public void user_clicks_on_the_dropdwon_menu_on_navbar() throws Throwable {
		loginPage.clickDropdownButton();
	}

	@When("^User clicks on the logout button$")
	public void user_clicks_on_the_logout_button() throws Throwable {
		WebElement logoutButton = loginPage.getLogoutButton();
		utils.waitUntil(logoutButton);
		loginPage.clickLogoutButton();
	}

}
