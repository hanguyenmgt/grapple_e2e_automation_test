package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.TermOfUsePageUI;

public class TermOfUsePageObject extends AbstractPage {

	WebDriver driver;

	public TermOfUsePageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public void openLoginPageURL(String url) {
		openAnyURL(driver, url);
	}

	public boolean isTermOfusePageDisplayed() {
		return isControlDisplayed(driver, TermOfUsePageUI.TERM_OF_USE_PAGE_TITLE);
	}
}
