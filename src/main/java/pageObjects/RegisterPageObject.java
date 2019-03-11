package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {

	WebDriver driver;

	public RegisterPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public void openLoginPageURL(String url) {
		openAnyURL(driver, url);
	}

	public boolean isRegisterPageDisplayed() {
		return isControlDisplayed(driver, RegisterPageUI.REGISTER_PAGE_TITLE);
	}
}
