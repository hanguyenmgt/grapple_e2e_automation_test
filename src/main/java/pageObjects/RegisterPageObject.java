package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstractPageUI;
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
	
	public void inputToDynamicTextbox(String message, String value) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TEXT_BOX, value);
		sendkeyToElement(driver, AbstractPageUI.DYNAMIC_TEXT_BOX, message, value);
	}

	public void selectTermCheckbox() {
		//waitForControlVisible(driver, RegisterPageUI.TERM_CHECKBOX);
		checkTheCheckbox(driver, RegisterPageUI.TERM_CHECKBOX);
	}
	
	public ProfilePageObject clickRegisterButton() {
		waitForControlVisible(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		
		return PageFactoryManager.openProfilePage(driver);
	}
	
	public FAQPageObject clickEligibleToSellLink() {
		waitForControlVisible(driver, RegisterPageUI.ELIGIBLE_TO_SELL_LINK);
		clickToElement(driver, RegisterPageUI.ELIGIBLE_TO_SELL_LINK);
		
		return PageFactoryManager.openFAQPage(driver);
	}
	
	public TermOfUsePageObject clickTermOfUseLink() {
		waitForControlVisible(driver, RegisterPageUI.TERM_OF_USE_LINK);
		clickToElement(driver, RegisterPageUI.TERM_OF_USE_LINK);
		
		return PageFactoryManager.openTermOfUsePage(driver);
	}
	
	public boolean isFailedValidationMesageDisplayed() {
		return isControlDisplayed(driver, RegisterPageUI.FAILED_VALIDATION_MESSAGE);
	}
	
	public boolean isSuccessValidationMesageDisplayed() {
		//return isControlDisplayed(driver, RegisterPageUI.SUCCESS_VALIDATION_MESSAGE);
		waitForControlVisible(driver, RegisterPageUI.SUCCESS_VALIDATION_MESSAGE);
		return true;
	}
}
