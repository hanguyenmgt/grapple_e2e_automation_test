package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.PricingPageUI;

public class PricingPageObject extends AbstractPage {

	WebDriver driver;

	public PricingPageObject(WebDriver mappingDriver) {

		driver = mappingDriver;
	}
	
	public boolean isPricingPageDisplayed() {		
		return isControlDisplayed(driver, PricingPageUI.PRICING_PAGE_TITLE);
	}
	
	public RegisterPageObject clickRegisterLink() {
		waitForControlClickable(driver, PricingPageUI.REGISTER_LINK);
		clickToElement(driver, PricingPageUI.REGISTER_LINK);
		
		return PageFactoryManager.openRegisterPage(driver);		
	}
	
	public ContactPageObject clickContactLink() {
		waitForControlClickable(driver, PricingPageUI.CONTACT_LINK);
		clickToElement(driver, PricingPageUI.CONTACT_LINK);
		
		return PageFactoryManager.openContactPage((driver));		
	}
	
	public void inputToAmountTextbox(String value) {
		waitForControlVisible(driver, PricingPageUI.AMOUNT_TEXTBOX);
		sendkeyToElement(driver, PricingPageUI.AMOUNT_TEXTBOX, value);		
	}
	
	public void clickOnQuoteButton() {
		waitForControlClickable(driver, PricingPageUI.QUOTE_BUTTON);
		clickToElement(driver, PricingPageUI.QUOTE_BUTTON);		
	}
	
	public String getFundAmountText() {
		waitForControlVisible(driver, PricingPageUI.FUND_AMOUNT_LABLE);
		return getTextElement(driver, PricingPageUI.FUND_AMOUNT_LABLE);
	}
	
	public String getPlatformCostText() {
		waitForControlVisible(driver, PricingPageUI.PLATFORM_COST_LABLE);
		return getTextElement(driver, PricingPageUI.PLATFORM_COST_LABLE);
	}
	
	public String getDailyCostText() {
		waitForControlVisible(driver, PricingPageUI.DAILY_COST_LABLE);
		return getTextElement(driver, PricingPageUI.DAILY_COST_LABLE);
	}
	
	public void clickOnBackButton() {
		waitForControlClickable(driver, PricingPageUI.BACK_BUTTON);
		clickToElement(driver, PricingPageUI.BACK_BUTTON);		
	}
	
	public boolean isQuoteButtonDisplayed() {
		return isControlDisplayed(driver, PricingPageUI.QUOTE_BUTTON);
	}
}
