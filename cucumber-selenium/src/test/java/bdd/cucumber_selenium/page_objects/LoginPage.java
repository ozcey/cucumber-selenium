package bdd.cucumber_selenium.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\\\"mat-input-0\\\"]")
	private static WebElement username;

	@FindBy(how = How.XPATH, using = "//*[@id=\\\"mat-input-1\\")
	private static WebElement password;

	@FindBy(how = How.XPATH, using = "//*[@id=\\\"navbarSupportedContent\\\"]/ul[2]/li[2]/a")
	private static WebElement loginButton;

	@FindBy(how = How.XPATH, using = "/html/body/app-root/section/main/app-login/section/mat-card/form/button")
	private static WebElement submitButton;

	@FindBy(how = How.XPATH, using = "/html/body/app-root/section/main/app-login/section/mat-card/mat-card-title")
	private static WebElement loginText;

	@FindBy(how = How.XPATH, using = "//*[@id=\\\"mat-tab-label-0-1\\\"]/div")
	private static WebElement customerText;

	@FindBy(how = How.XPATH, using = "//*[@id=\"mat-error-0\"]")
	private static WebElement usernameError;

	@FindBy(how = How.XPATH, using = "//*[@id=\"mat-error-1\"]")
	private static WebElement passwordError;

	@FindBy(how = How.XPATH, using = "//*[@id=\"navbarDropdown\"]")
	private static WebElement dropDown;

	@FindBy(how = How.XPATH, using = "//*[@id=\"navbarSupportedContent\"]/ul[2]/li[2]/div/a[2]")
	private static WebElement logoutButton;

	public void enterUsername(String uname) {
		username.sendKeys(uname);
	}

	public void enterPassword(String pass) {
		username.sendKeys(pass);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public void clickSubmitButton() {
		submitButton.submit();
	}

	public WebElement getLoginText() {
		return loginText;
	}

	public WebElement getCustomerText() {
		return customerText;
	}

	public WebElement getUsernameErrorText() {
		return usernameError;
	}

	public WebElement getPassowrdErrorText() {
		return passwordError;
	}
	
	public WebElement getLogoutButton() {
		return logoutButton;
	}

	public void clickDropdownButton() {
		dropDown.click();
	}

	public void clickLogoutButton() {
		logoutButton.click();
	}

}
