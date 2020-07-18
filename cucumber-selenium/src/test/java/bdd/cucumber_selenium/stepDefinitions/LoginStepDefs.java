package bdd.cucumber_selenium.stepDefinitions;

import bdd.cucumber_selenium.utils.Constants;
import bdd.cucumber_selenium.utils.Utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class LoginStepDefs {

	Utils utils;

	@Before
	public void before() {
		utils = new Utils();
		utils.setUp();
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
		utils.findElement("//*[@id=\"navbarSupportedContent\"]/ul[2]/li[2]/a", Constants.CLICK, null);

	}

	@Then("^User should be taken the successful login page$")
	public void user_should_be_taken_the_successful_login_page() throws Throwable {
		utils.validateText("Login",
				utils.getText("/html/body/app-root/section/main/app-login/section/mat-card/mat-card-title"));
	}

	@And("^User enters a valid username$")
	public void user_enters_a_valid_username() throws Throwable {
		utils.findElement("//*[@id=\"mat-input-0\"]", Constants.SEND_KEYS, "markj@gmail.com");
	}

	@And("^User enters a valid password$")
	public void user_enters_a_valid_password() throws Throwable {
		utils.findElement("//*[@id=\"mat-input-1\"]", Constants.SEND_KEYS, "password");

	}

	@When("^User clicks on the login button$")
	public void user_clicks_on_the_login_button() throws Throwable {
		utils.findElement("/html/body/app-root/section/main/app-login/section/mat-card/form/button", Constants.CLICK,
				null);
	}

	@Then("^User should be taken the successful customer page$")
	public void user_should_be_taken_the_successful_customer_page() throws Throwable {
		String xpath = "//*[@id=\"mat-tab-label-0-1\"]/div";
		utils.waitUntil(xpath);
		utils.validateText("Customer List", utils.getText(xpath));
	}

}
