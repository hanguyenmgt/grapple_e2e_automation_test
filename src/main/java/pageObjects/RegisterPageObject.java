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
	
	public void selectTermCheckbox() {
		waitForControlVisible(driver, RegisterPageUI.TERM_CHECKBOX);
		checkTheCheckbox(driver, RegisterPageUI.TERM_CHECKBOX);
	}
	
	public RegisterSellerPageObject clickRegisterButton() {
		waitForControlVisible(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		waitForControlInVisible(driver, AbstractPageUI.LOADING_BAR);
		return PageFactoryManager.openProfilePage(driver);
	}
	
	public FAQPageObject clickEligibleToSellLink() {
		waitForControlVisible(driver, RegisterPageUI.ELIGIBLE_TO_SELL_LINK);
		clickToElement(driver, RegisterPageUI.ELIGIBLE_TO_SELL_LINK);
		waitForControlInVisible(driver, AbstractPageUI.LOADING_BAR);
		return PageFactoryManager.openFAQPage(driver);
	}
	
	public TermOfUsePageObject clickTermOfUseLink() {
		waitForControlVisible(driver, RegisterPageUI.TERM_OF_USE_LINK);
		clickToElement(driver, RegisterPageUI.TERM_OF_USE_LINK);
		waitForControlInVisible(driver, AbstractPageUI.LOADING_BAR);
		return PageFactoryManager.openTermOfUsePage(driver);
	}
}
