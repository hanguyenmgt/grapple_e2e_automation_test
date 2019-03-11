package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.PartnerPageUI;

public class PartnerPageObject extends AbstractPage {

	WebDriver driver;

	public PartnerPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public boolean isParterPageDisplayed() {		
		return isControlDisplayed(driver, PartnerPageUI.HOME_PAGE_TITLE);
	}
}
