package com.grapple.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.AboutPageObject;
import pageObjects.BlogsPageObject;
import pageObjects.ContactPageObject;
import pageObjects.FAQPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginOptionsPageObject;
import pageObjects.PageFactoryManager;
import pageObjects.PartnerPageObject;
import pageObjects.PricingPageObject;
import pageObjects.RegisterFacilityPageObject;
import pageObjects.RegisterOptionsPageObject;
import pageObjects.RegisterPageObject;

public class User_01_Homepage extends AbstractTest {

	WebDriver driver;
	WebDriverWait wait;

	private HomePageObject homePage;
	private RegisterOptionsPageObject registerOptionsPage;
	private RegisterPageObject registerPage;
	private LoginOptionsPageObject loginOptionsPage;
	private PricingPageObject pricingPage;
	private RegisterFacilityPageObject registerFacilityPage;
	private AboutPageObject aboutPage;
	private FAQPageObject faqPage;
	private PartnerPageObject partnerPage;
	private BlogsPageObject blogPage;
	private ContactPageObject contactPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String url) {
		driver = openMultiBrowsers(browser, url);
		homePage = PageFactoryManager.openHomePage(driver);
	}

	@Test
	public void TC_01_Verify_Home_Page_Displayed() {
		verifyTrue(homePage.isHomePageDisplayed());
	}

	@Test
	public void TC_02_Verify_User_Is_Able_To_Open_Register_Options_Page() {
		registerOptionsPage = homePage.clickApplyNowButton();
		verifyTrue(registerOptionsPage.isRegisterOptionsPageDisplayed());
		homePage = registerOptionsPage.openHomePage(driver);
	}

	@Test
	public void TC_03_Verify_User_Is_Able_To_Open_Login_Options_Page() {
		loginOptionsPage = homePage.clickLoginButton(driver);
		verifyTrue(loginOptionsPage.isLoginOptionsPageDisplayed());
		homePage = loginOptionsPage.openHomePage(driver);
	}

	@Test
	public void TC_04_Verify_User_Is_Able_To_Open_Product_Preview_Page() {
		homePage.clickProductReview();
		homePage.switchToWindowByTitle(driver, "Grapple Reviews - ProductReview.com.au");
		verifyEquals(homePage.getCurrentURL(driver), "https://www.productreview.com.au/listings/grapple");
		homePage.switchToWindowByTitle(driver, "Grapple: Invoice Finance - Manage Business Cash Flow with Funding");
	}

	@Test
	public void TC_05_Verify_User_Is_Able_To_Open_Register_Page_When_Clicking_On_Apply_Now_Button_On_Selective_Invoice() {
		registerPage = homePage.clickApplyNowButtonOnSelectiveInvoiceSection();
		verifyTrue(registerPage.isRegisterPageDisplayed());
		homePage = registerPage.openHomePage(driver);
	}

	@Test
	public void TC_06_Verify_User_Is_Able_To_Open_Pricing_Page_When_Clicking_On_Quote_Button_On_Selective_Invoice() {
		pricingPage = homePage.clickQuoteButton();
		verifyTrue(pricingPage.isPricingPageDisplayed());
		homePage = pricingPage.openHomePage(driver);
	}

	@Test
	public void TC_07_Verify_User_Is_Able_To_Open_Register_Facility_Page_When_Clicking_On_Apply_Now_Button_On_Facility_Invoice() {
		registerFacilityPage = homePage.clickApllyNowButtonOnFacilitySection();
		verifyTrue(registerFacilityPage.isRegisterFacilityPageDisplayed());
		homePage = registerFacilityPage.openHomePage(driver);
	}

	@Test
	public void TC_08_Verify_User_Is_Able_To_Open_About_Us_Page_When_Clicking_On_About_Us_Button() {
		aboutPage = homePage.clickAboutUsButton();
		verifyTrue(aboutPage.isAboutUsPageDisplayed());
		homePage = aboutPage.openHomePage(driver);
	}

	@Test
	public void TC_09_Verify_User_Is_Able_To_Open_Register_Options_Page_When_Clicking_On_Apply_Now_Button_On_Unlock_Funds() {
		registerOptionsPage = homePage.clickApllyNowButtonOnUnlockFundsSection();
		verifyTrue(registerOptionsPage.isRegisterOptionsPageDisplayed());
		homePage = registerOptionsPage.openHomePage(driver);
	}

	@Test
	public void TC_10_Verify_User_Is_Able_To_Open_FAQ_Page_When_Clicking_On_FAQ_Menu_Item() {
		faqPage = (FAQPageObject) homePage.openDynamicPage(driver, "FAQ");
		verifyTrue(faqPage.isFAQPageDisplayed());
		homePage = faqPage.openHomePage(driver);
	}

	@Test
	public void TC_11_Verify_User_Is_Able_To_Open_Pricing_Page_When_Clicking_On_Pricing_Menu_Item() {
		pricingPage = (PricingPageObject) homePage.openDynamicPage(driver, "Pricing");
		verifyTrue(pricingPage.isPricingPageDisplayed());
		homePage = pricingPage.openHomePage(driver);
	}
	
	@Test
	public void TC_12_Verify_User_Is_Able_To_Open_Partner_Page_When_Clicking_On_Partner_Menu_Item() {
		partnerPage = (PartnerPageObject) homePage.openDynamicPage(driver, "Partner");
		verifyTrue(partnerPage.isParterPageDisplayed());
		homePage = partnerPage.openHomePage(driver);
	}
	
	@Test
	public void TC_13_Verify_User_Is_Able_To_Open_Blogs_Page_When_Clicking_On_Blogs_Menu_Item() {
		blogPage = (BlogsPageObject) homePage.openDynamicPage(driver, "Blogs");
		verifyTrue(blogPage.isBlogsPageDisplayed());
		homePage = blogPage.openHomePage(driver);
	}
	
	@Test
	public void TC_14_Verify_User_Is_Able_To_Open_About_Page_When_Clicking_On_About_Menu_Item() {
		aboutPage = (AboutPageObject) homePage.openDynamicPage(driver, "About");
		verifyTrue(aboutPage.isAboutUsPageDisplayed());
		homePage = aboutPage.openHomePage(driver);
	}
	
	@Test
	public void TC_15_Verify_User_Is_Able_To_Open_Contact_Page_When_Clicking_On_Contact_Menu_Item() {
		contactPage = (ContactPageObject) homePage.openDynamicPage(driver, "Contact");
		verifyTrue(contactPage.isContactPageDisplayed());
		homePage = contactPage.openHomePage(driver);
	}

	@AfterClass
	public void afterClass() {
		quitDriver(driver);
	}

}
