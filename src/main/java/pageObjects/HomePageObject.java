package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.HomePageUI;

public class HomePageObject extends AbstractPage {

	WebDriver driver;

	public HomePageObject(WebDriver mappingDriver) {

		driver = mappingDriver;
	}
		
	public RegisterOptionsPageObject clickApplyNowButton() {		
		waitForControlVisible(driver, HomePageUI.APPLY_NOW_BUTTON);
		clickToElement(driver, HomePageUI.APPLY_NOW_BUTTON);
		
		return PageFactoryManager.openRegisterOptionsPage(driver);
	}
	
	public void clickProductReview() {		
		waitForControlVisible(driver, HomePageUI.PRODUCT_REVIEW);
		clickToElement(driver, HomePageUI.PRODUCT_REVIEW);
	}
	
	public boolean isHomePageDisplayed() {		
		return isControlDisplayed(driver, HomePageUI.HOME_PAGE_TITLE);
	}
	
	public RegisterPageObject clickApplyNowButtonOnSelectiveInvoiceSection() {		
		waitForControlVisible(driver, HomePageUI.APPLY_NOW_SELECTIVE);
		clickToElement(driver, HomePageUI.APPLY_NOW_SELECTIVE);
		
		return PageFactoryManager.openRegisterPage(driver);
	}	
	
	public PricingPageObject clickQuoteButton() {		
		waitForControlVisible(driver, HomePageUI.QUOTE_BUTTON);
		clickToElement(driver, HomePageUI.QUOTE_BUTTON);
		
		return PageFactoryManager.openPricingPage(driver);
	}
	
	public RegisterFacilityPageObject clickApllyNowButtonOnFacilitySection() {		
		waitForControlVisible(driver, HomePageUI.APPLY_NOW_FACCILITY);
		clickToElement(driver, HomePageUI.APPLY_NOW_FACCILITY);
		
		return PageFactoryManager.openRegisterFacilityPage(driver);
	}
	
	public RegisterOptionsPageObject clickApllyNowButtonOnUnlockFundsSection() {		
		waitForControlVisible(driver, HomePageUI.APPLY_NOW_UNLOCK_FUNDS);
		clickToElement(driver, HomePageUI.APPLY_NOW_UNLOCK_FUNDS);
		
		return PageFactoryManager.openRegisterOptionsPage(driver);
	}
	
	public AboutPageObject clickAboutUsButton() {		
		waitForControlVisible(driver, HomePageUI.ABOUT_US_BUTTON);
		clickToElement(driver, HomePageUI.ABOUT_US_BUTTON);
		
		return PageFactoryManager.openAboutPage(driver);
	}
}
