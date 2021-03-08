package bdd.cucumber_selenium.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Constants {

	LOGIN_TEXT("Login"), USERNAME("markj@gmail.com"), PASSWORD("password"), CUSTOMER_TEXT("Customer List"),
	DRIVER("webdriver.chrome.driver"), DRIVER_PATH("F:\\PROGRAMMING\\SDET\\chromedriver_win32\\chromedriver.exe"),
	BaseURL("http://localhost:4200");

	private final String name;

}
