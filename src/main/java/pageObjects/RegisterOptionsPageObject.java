package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.RegisterOptionsPageUI;

public class RegisterOptionsPageObject extends AbstractPage {

	WebDriver driver;

	public RegisterOptionsPageObject(WebDriver mappingDriver) {

		driver = mappingDriver;
	}
	
	public boolean isRegisterOptionsPageDisplayed() {		
		return isControlDisplayed(driver, RegisterOptionsPageUI.REGISTER_OPTIONS_PAGE_TITLE);
	}
	
	public RegisterPageObject clickApplyNowButtonOnSelectiveSection() {
		waitForControlClickable(driver, RegisterOptionsPageUI.APPLY_NOW_SELECTIVE);
		clickToElement(driver, RegisterOptionsPageUI.APPLY_NOW_SELECTIVE);
		
		return PageFactoryManager.openRegisterPage(driver);
	}
	
	public PricingPageObject clickQuoteButton() {
		waitForControlClickable(driver, RegisterOptionsPageUI.QUOTE_BUTTON);
		clickToElement(driver, RegisterOptionsPageUI.QUOTE_BUTTON);
		
		return PageFactoryManager.openPricingPage(driver);
	}
	
	public RegisterFacilityPageObject clickApplyNowButtonOnFacilitySection() {
		waitForControlClickable(driver, RegisterOptionsPageUI.APPLY_NOW_FACCILITY);
		clickToElement(driver, RegisterOptionsPageUI.APPLY_NOW_FACCILITY);
		
		return PageFactoryManager.openRegisterFacilityPage(driver);
	}
}
