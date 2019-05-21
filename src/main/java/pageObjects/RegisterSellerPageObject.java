package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.RegisterSellerPageUI;

public class RegisterSellerPageObject extends AbstractPage {

	WebDriver driver;

	public RegisterSellerPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public boolean isRegisterSellerPageDisplayed() {
		return isControlDisplayed(driver, RegisterSellerPageUI.PAGE_TITLE);
	}

	public SettingPageObject clickSettingButton() {		
		waitForControlClickable(driver, AbstractPageUI.SETTING_MENU);
		clickToElement(driver,  AbstractPageUI.SETTING_MENU);
		waitForControlInVisible(driver, AbstractPageUI.LOADING_BAR);
		return PageFactoryManager.openSettingPage(driver);
	}
}
