package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.FAQPageUI;

public class FAQPageObject extends AbstractPage {

	WebDriver driver;

	public FAQPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public boolean isFAQPageDisplayed() {		
		return isControlDisplayed(driver, FAQPageUI.FAQ_PAGE_TITLE);
	}
}
