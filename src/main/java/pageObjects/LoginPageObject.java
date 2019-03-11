package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends AbstractPage {

	WebDriver driver;
	
	public LoginPageObject (WebDriver mappingDriver) {
		
		driver = mappingDriver;
	}
	
	public boolean isLoginPageDisplayed() {		
		return isControlDisplayed(driver, LoginPageUI.LOGIN_OPTIONS_PAGE_TITLE);
	}
}
