package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.LoginOptionsPageUI;

public class LoginOptionsPageObject extends AbstractPage {

	WebDriver driver;
	
	public LoginOptionsPageObject (WebDriver mappingDriver) {
		
		driver = mappingDriver;
	}
	
	public boolean isLoginOptionsPageDisplayed() {		
		return isControlDisplayed(driver, LoginOptionsPageUI.LOGIN_OPTIONS_PAGE_TITLE);
	}	
	
	public LoginPageObject clickLoginButton() {
		waitForControlClickable(driver, LoginOptionsPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginOptionsPageUI.LOGIN_BUTTON);
		waitForControlInVisible(driver, AbstractPageUI.LOADING_BAR);
		return PageFactoryManager.openLoginPage(driver);
	}
	
	public RegisterPageObject clickApplySelectiveLink() {
		waitForControlClickable(driver, LoginOptionsPageUI.APPLY_SELECTIVE_LINK);
		clickToElement(driver, LoginOptionsPageUI.APPLY_SELECTIVE_LINK);
		waitForControlInVisible(driver, AbstractPageUI.LOADING_BAR);
		return PageFactoryManager.openRegisterPage(driver);
	}
	

	public RegisterFacilityPageObject clickApplyFacilityLink() {
		waitForControlClickable(driver, LoginOptionsPageUI.APPLY_FACILITY_LINK);
		clickToElement(driver, LoginOptionsPageUI.APPLY_FACILITY_LINK);
		waitForControlInVisible(driver, AbstractPageUI.LOADING_BAR);
		return PageFactoryManager.openRegisterFacilityPage(driver);
	}
	
}
