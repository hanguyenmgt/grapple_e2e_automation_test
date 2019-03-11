package com.grapple.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.HomePageObject;
import pageObjects.LoginOptionsPageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageFactoryManager;
import pageObjects.RegisterFacilityPageObject;
import pageObjects.RegisterPageObject;

public class User_04_Login_Options_Page extends AbstractTest {

	WebDriver driver;
	WebDriverWait wait;

	private HomePageObject homePage;
	private RegisterFacilityPageObject registerFacilityPage;
	private LoginOptionsPageObject loginOptionsPage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String url) {
		driver = openMultiBrowsers(browser, url);
		homePage = PageFactoryManager.openHomePage(driver);
		loginOptionsPage = homePage.clickLoginButton(driver);
	}
	
	@Test
	public void TC_01_Verify_Login_Button_Works() {
		loginPage = loginOptionsPage.openLoginPage();
		
		verifyTrue(loginPage.isLoginPageDisplayed());
		
		loginOptionsPage = loginPage.clickLoginButton(driver);
	}
	
	@Test
	public void TC_02_Verify_Apply_Selective_Link_Works() {
		registerPage = loginOptionsPage.clickApplySelectiveLink();
		
		verifyTrue(registerPage.isRegisterPageDisplayed());
		
		loginOptionsPage = registerPage.clickLoginButton(driver);
	}
	
	@Test
	public void TC_03_Verify_Apply_Facility_Link_Works() {
		registerFacilityPage = loginOptionsPage.clickApplyFacilityLink();
		
		verifyTrue(registerFacilityPage.isRegisterFacilityPageDisplayed());
		
		loginOptionsPage = registerFacilityPage.clickLoginButton(driver);
	}
	
	@AfterClass
	public void afterClass() {
		quitDriver(driver);
	}

}
