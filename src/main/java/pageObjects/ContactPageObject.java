package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.ContactPageUI;

public class ContactPageObject extends AbstractPage {

	WebDriver driver;

	public ContactPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public boolean isContactPageDisplayed() {		
		return isControlDisplayed(driver, ContactPageUI.CONTACT_PAGE_TITLE);
	}
}
