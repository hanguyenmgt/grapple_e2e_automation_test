package com.grapple.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.HomePageObject;
import pageObjects.PageFactoryManager;
import pageObjects.PricingPageObject;
import pageObjects.RegisterFacilityPageObject;
import pageObjects.RegisterOptionsPageObject;
import pageObjects.RegisterPageObject;

public class User_03_Registor_Options_Page extends AbstractTest {

	WebDriver driver;
	WebDriverWait wait;

	private HomePageObject homePage;
	private RegisterOptionsPageObject registerOptionsPage;
	private RegisterFacilityPageObject registerFacilityPage;
	private RegisterPageObject registerPage;
	private PricingPageObject pricingPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String url) {
		driver = openMultiBrowsers(browser, url);
		homePage = PageFactoryManager.openHomePage(driver);
		registerOptionsPage = homePage.clickApplyNowButton();
	}
	
	@Test
	public void TC_01_Verify_Apply_Selective_Invoice_Works() {
		registerPage = registerOptionsPage.clickApplyNowButtonOnSelectiveSection();
		
		verifyTrue(registerPage.isRegisterPageDisplayed());
		
		homePage = registerPage.openHomePage(driver);
		registerOptionsPage = homePage.clickApplyNowButton();
	}

	@Test
	public void TC_02_Verify_Quote_Button_Works() {
		pricingPage = registerOptionsPage.clickQuoteButton();
		
		verifyTrue(pricingPage.isPricingPageDisplayed());
		
		homePage = registerPage.openHomePage(driver);
		registerOptionsPage = homePage.clickApplyNowButton();
	}
	
	@Test
	public void TC_03_Verify_Apply_Facility_Invoice_Works() {
		registerFacilityPage = registerOptionsPage.clickApplyNowButtonOnFacilitySection();
		
		verifyTrue(registerFacilityPage.isRegisterFacilityPageDisplayed());
		
		homePage = registerFacilityPage.openHomePage(driver);
		registerOptionsPage = homePage.clickApplyNowButton();
	}
	
	@AfterClass
	public void afterClass() {
		quitDriver(driver);
	}

}
