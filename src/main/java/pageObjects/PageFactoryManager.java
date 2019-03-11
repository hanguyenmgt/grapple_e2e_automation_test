package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
	public static HomePageObject openHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static LoginPageObject openLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
		
	public static LoginOptionsPageObject openLoginOptionsPage(WebDriver driver) {
		return new LoginOptionsPageObject(driver);
	}

	public static RegisterPageObject openRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static RegisterOptionsPageObject openRegisterOptionsPage(WebDriver driver) {
		return new RegisterOptionsPageObject(driver);
	}
	
	public static FAQPageObject openFAQPage(WebDriver driver) {
		return new FAQPageObject(driver);
	}
	
	public static PricingPageObject openPricingPage(WebDriver driver) {
		return new PricingPageObject(driver);
	}
	
	public static PartnerPageObject openPartnerPage(WebDriver driver) {
		return new PartnerPageObject(driver);
	}
	
	public static BlogsPageObject openBlogsPage(WebDriver driver) {
		return new BlogsPageObject(driver);
	}
	
	public static AboutPageObject openAboutPage(WebDriver driver) {
		return new AboutPageObject(driver);
	}

	public static ContactPageObject openContactPage(WebDriver driver) {
		return new ContactPageObject(driver);
	}

	public static RegisterFacilityPageObject openRegisterFacilityPage(WebDriver driver) {
		return new RegisterFacilityPageObject(driver);
	}
}
