package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.RegisterFacilityPageUI;

public class RegisterFacilityPageObject extends AbstractPage {

	WebDriver driver;

	public RegisterFacilityPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public void openLoginPageURL(String url) {
		openAnyURL(driver, url);
	}

	public boolean isRegisterFacilityPageDisplayed() {
		return isControlDisplayed(driver, RegisterFacilityPageUI.REGISTER_PAGE_TITLE);
	}
}
