package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AboutPageUI;

public class AboutPageObject extends AbstractPage {

	WebDriver driver;

	public AboutPageObject(WebDriver mappingDriver) {

		driver = mappingDriver;
	}
	
	public boolean isAboutUsPageDisplayed() {		
		return isControlDisplayed(driver, AboutPageUI.ABOUT_US_PAGE_TITLE);
	}
	
}
