package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.BlogsPageUI;

public class BlogsPageObject extends AbstractPage {

	WebDriver driver;

	public BlogsPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public boolean isBlogsPageDisplayed() {		
		return isControlDisplayed(driver, BlogsPageUI.BLOGS_PAGE_TITLE);
	}
}
