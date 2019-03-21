package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.SettingPageUI;

public class SettingPageObject extends AbstractPage {

	WebDriver driver;

	public SettingPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public void openLoginPageURL(String url) {
		openAnyURL(driver, url);
	}
		
	public void clickToDynamicButton(String buttonName) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_BUTTON, buttonName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_BUTTON, buttonName);
	}
	
	public boolean isDynamicSuccessMessageDisplayed(String message) {
		return isControlDisplayed(driver, SettingPageUI.DYNAMIC_SUCCESS_MESSAGE, message);
	}
}
