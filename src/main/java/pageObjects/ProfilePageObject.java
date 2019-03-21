package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.ProfilePageUI;

public class ProfilePageObject extends AbstractPage {

	WebDriver driver;

	public ProfilePageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public boolean isUserNameDisplayed(String userName) {
		return isControlDisplayed(driver, ProfilePageUI.USER_NAME_TITLE, userName);
	}

	public String getDynamicUserInfo(String value) {
		waitForControlVisible(driver, ProfilePageUI.DYNAMIC_TABLE_ROW, value);
		return getTextElement(driver, ProfilePageUI.DYNAMIC_TABLE_ROW, value);
	}
	
	public SettingPageObject clickSettingButton() {
		waitForControlClickable(driver, ProfilePageUI.SETTING_BUTTON);
		clickToElement(driver, ProfilePageUI.SETTING_BUTTON);
		
		return PageFactoryManager.openSettingPage(driver);
				
	}
	
	public void clickRegisterSellerButton() {
		waitForControlClickable(driver, ProfilePageUI.REGISTER_SELLER_BUTTON);
		clickToElement(driver, ProfilePageUI.REGISTER_SELLER_BUTTON);
	}
}
