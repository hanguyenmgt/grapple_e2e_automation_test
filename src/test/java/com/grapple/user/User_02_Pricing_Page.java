package com.grapple.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.ContactPageObject;
import pageObjects.HomePageObject;
import pageObjects.PageFactoryManager;
import pageObjects.PricingPageObject;
import pageObjects.RegisterPageObject;

public class User_02_Pricing_Page extends AbstractTest {

	WebDriver driver;
	WebDriverWait wait;

	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private PricingPageObject pricingPage;
	private ContactPageObject contactPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String url) {
		driver = openMultiBrowsers(browser, url);
		homePage = PageFactoryManager.openHomePage(driver);
		pricingPage = (PricingPageObject) homePage.openDynamicPage(driver, "Pricing");
	}

	@Test
	public void TC_01_Verify_Funding_Amount_Is_Required() {
		pricingPage.inputToAmountTextbox("");
		pricingPage.clickOnQuoteButton();
		
		verifyTrue(pricingPage.isQuoteButtonDisplayed());
	}
	
	@Test
	public void TC_02_Verify_Funding_Amount_Must_Be_Or_Greater_Than_1000() {
		pricingPage.inputToAmountTextbox("999");
		pricingPage.clickOnQuoteButton();
		
		verifyTrue(pricingPage.isQuoteButtonDisplayed());
	}
	
	@Test
	public void TC_03_Verify_Platform_Costs_And_Daily_Costs_Are_Correct_With_Fund_Amount_Is_1000() {
		pricingPage.inputToAmountTextbox("2500");
		pricingPage.clickOnQuoteButton();
		
		verifyEquals(pricingPage.getFundAmountText().trim(), "$2,500");
		verifyEquals(pricingPage.getPlatformCostText().trim(), "$220");
		verifyEquals(pricingPage.getDailyCostText().trim(), "$0.41");
		
		pricingPage.clickOnBackButton();
	}
	
	@Test
	public void TC_04_Verify_Platform_Costs_And_Daily_Costs_Are_Correct_With_Fund_Amount_Is_20000() {
		pricingPage.inputToAmountTextbox("20000");
		pricingPage.clickOnQuoteButton();
		
		verifyEquals(pricingPage.getFundAmountText().trim(), "$20,000");
		verifyEquals(pricingPage.getPlatformCostText().trim(), "$311.33");
		verifyEquals(pricingPage.getDailyCostText().trim(), "$3.29");
		
		pricingPage.clickOnBackButton();
	}
	
	@Test
	public void TC_05_Verify_Register_Link_Works() {
		registerPage = pricingPage.clickRegisterLink();
		verifyTrue(registerPage.isRegisterPageDisplayed());
		
		pricingPage = (PricingPageObject) registerPage.openDynamicPage(driver, "Pricing");	
	}

	@Test
	public void TC_06_Verify_Contact_Us_Link_Works() {
		contactPage = pricingPage.clickContactLink();
		verifyTrue(contactPage.isContactPageDisplayed());
	}

	@AfterClass
	public void afterClass() {
		quitDriver(driver);
	}

}
