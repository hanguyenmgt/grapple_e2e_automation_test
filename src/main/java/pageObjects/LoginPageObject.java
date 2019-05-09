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
	
	public RegisterOptionsPageObject clickApplyNowLink() {
		waitForControlVisible(driver, LoginPageUI.APPLY_NOW_LINK);
		clickToElement(driver, LoginPageUI.APPLY_NOW_LINK);
		
		return PageFactoryManager.openRegisterOptionsPage(driver);
	}
	
	public ContactPageObject clickContactUsLink() {
		waitForControlVisible(driver, LoginPageUI.CONTACT_LINK);
		clickToElement(driver, LoginPageUI.CONTACT_LINK);
		
		return PageFactoryManager.openContactPage(driver);
	}
	
	public RegisterSellerPageObject clickLoginButton() {
		waitForControlVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		
		return PageFactoryManager.openProfilePage(driver);
	}
}
