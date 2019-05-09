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
import pageObjects.LoginOptionsPageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageFactoryManager;
import pageObjects.RegisterSellerPageObject;
import pageObjects.RegisterOptionsPageObject;
import testData.Login;

public class User_06_Login_Page extends AbstractTest {

	WebDriver driver;
	WebDriverWait wait;

	private HomePageObject homePage;
	private LoginOptionsPageObject loginOptionsPage;
	private LoginPageObject loginPage;
	private RegisterOptionsPageObject registerOptionsPage;
	private RegisterSellerPageObject registerSellerPage;
	private ContactPageObject contactPage;

	String email, password, incorrectEmail, incorrectPassword, name;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String url) {
		driver = openMultiBrowsers(browser, url);
		homePage = PageFactoryManager.openHomePage(driver);
		loginOptionsPage = homePage.openLoginOptionsPage(driver);
		loginPage = loginOptionsPage.clickLoginButton();

		email = Login.EMAIL;
		password = Login.PASSWORD;
		incorrectEmail = Login.INVALID_EMAIL;
		incorrectPassword = Login.INVALID_PASSWORD;
		name = Login.NAME;
	}
	
	@Test
	public void TC_01_Verify_Apply_Now_Link_Works() {
		
		registerOptionsPage = loginPage.clickApplyNowLink();
		registerOptionsPage.isRegisterOptionsPageDisplayed();
		
		loginOptionsPage = registerOptionsPage.openLoginOptionsPage(driver);
		loginPage = loginOptionsPage.clickLoginButton();
	}
	
	@Test
	public void TC_02_Verify_Contact_Us_Link_Works() {
		contactPage = loginPage.clickContactUsLink();
		contactPage.isContactPageDisplayed();
		
		loginOptionsPage = contactPage.openLoginOptionsPage(driver);
		loginPage = loginOptionsPage.clickLoginButton();
	}
	
	@Test
	public void TC_03_Verify_Email_Is_Required() {
		loginPage.inputToDynamicTextbox(driver, "", "email");
		loginPage.inputToDynamicTextbox(driver, password, "password");
		loginPage.clickLoginButton();
		
		// we can't get validation message for this type (it's browser message) so just
		// verify it's still staying at Login page
		verifyTrue(loginPage.isLoginPageDisplayed());
	}
	
	@Test
	public void TC_04_Verify_Password_Is_Required() {
		loginPage.inputToDynamicTextbox(driver, email, "email");
		loginPage.inputToDynamicTextbox(driver, "", "password");
		loginPage.clickLoginButton();
		
		// we can't get validation message for this type (it's browser message) so just
		// verify it's still staying at Login page
		verifyTrue(loginPage.isLoginPageDisplayed());
	}
	
	@Test
	public void TC_05_Verify_User_Can_Not_Login_With_Incorrect_Email() {
		loginPage.inputToDynamicTextbox(driver, incorrectEmail, "email");
		loginPage.inputToDynamicTextbox(driver, password, "password");
		loginPage.clickLoginButton();
		
		verifyTrue(loginPage.isFailedValidationMesageDisplayed(driver));
	}
	
	@Test
	public void TC_06_Verify_User_Can_Not_Login_With_Incorrect_Password() {
		loginPage.inputToDynamicTextbox(driver, email, "email");
		loginPage.inputToDynamicTextbox(driver, incorrectPassword, "password");
		loginPage.clickLoginButton();
		
		verifyTrue(loginPage.isFailedValidationMesageDisplayed(driver));
	}

	@Test
	public void TC_07_Verify_User_Can_Login_With_Correct_Email_And_Password() {
		loginPage.inputToDynamicTextbox(driver, email, "email");
		loginPage.inputToDynamicTextbox(driver, password, "password");
		registerSellerPage = loginPage.clickLoginButton();
		
		verifyTrue(registerSellerPage.isRegisterSellerPageDisplayed());
			
	}

	@AfterClass
	public void afterClass() {
		quitDriver(driver);
	}

}
