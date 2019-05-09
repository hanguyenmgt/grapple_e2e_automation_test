package com.grapple.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.FAQPageObject;
import pageObjects.HomePageObject;
import pageObjects.PageFactoryManager;
import pageObjects.RegisterSellerPageObject;
import pageObjects.RegisterPageObject;
import pageObjects.TermOfUsePageObject;
import testData.Register;

public class User_05_Register_Page extends AbstractTest {

	WebDriver driver;
	WebDriverWait wait;

	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private RegisterSellerPageObject registerSellerPage;
	private FAQPageObject faqPage;
	private TermOfUsePageObject termPage;

	String email, name, password, phone, invalidEmail, existingEmail;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String url) {
		driver = openMultiBrowsers(browser, url);
		homePage = PageFactoryManager.openHomePage(driver);
		registerPage = homePage.clickApplyNowButtonOnSelectiveInvoiceSection();

		email = String.format(Register.EMAIL, randomNumber());
		name = String.format(Register.NAME, randomNumber());
		password = Register.PASSWORD;
		phone = String.format(Register.PHONE, randomNumber(8));
		invalidEmail = Register.INVALID_EMAIL;
		existingEmail = Register.EXISTING_EMAIL;
	}
	
	@Test
	public void TC_01_Verify_Eligible_To_Seller_Link_Works() {
		faqPage = registerPage.clickEligibleToSellLink();
		verifyTrue(faqPage.isFAQPageDisplayed());
		homePage = faqPage.openHomePage(driver);
		registerPage = homePage.clickApplyNowButtonOnSelectiveInvoiceSection();
	}
	
	@Test
	public void TC_02_Verify_Term_Of_Use_Link_Works() {
		termPage = registerPage.clickTermOfUseLink();
		verifyTrue(termPage.isTermOfusePageDisplayed());
		homePage = termPage.openHomePage(driver);
		registerPage = homePage.clickApplyNowButtonOnSelectiveInvoiceSection();
	}

	@Test
	public void TC_03_Verify_Term_Check_Box_Is_Required_To_Select() {
		registerPage.inputToDynamicTextbox(driver, name, "name");
		registerPage.inputToDynamicTextbox(driver, email, "email");
		registerPage.inputToDynamicTextbox(driver, phone, "phone");
		registerPage.inputToDynamicTextbox(driver, password, "password");
		registerPage.clickRegisterButton();
		
		// we can't get validation message for this type (it's browser message) so just
		// verify it's still staying at Register page
		verifyTrue(registerPage.isRegisterPageDisplayed());
	}

	@Test
	public void TC_04_Verify_Name_Is_Required() {
		registerPage.inputToDynamicTextbox(driver, email, "email");
		registerPage.inputToDynamicTextbox(driver, phone, "phone");
		registerPage.inputToDynamicTextbox(driver, password, "password");
		registerPage.selectTermCheckbox();
		registerPage.inputToDynamicTextbox(driver, "","name");
		registerPage.clickRegisterButton();
 
		verifyTrue(registerPage.isRegisterPageDisplayed());
	}

	@Test
	public void TC_05_Verify_Email_Is_Required() {
		registerPage.inputToDynamicTextbox(driver, name, "name");
		registerPage.inputToDynamicTextbox(driver, phone, "phone");
		registerPage.inputToDynamicTextbox(driver, password, "password");
		registerPage.inputToDynamicTextbox(driver, "", "email");
		registerPage.clickRegisterButton();

		verifyTrue(registerPage.isRegisterPageDisplayed());
	}

	@Test
	public void TC_06_Verify_Phone_Is_Required() {
		registerPage.inputToDynamicTextbox(driver, name, "name");
		registerPage.inputToDynamicTextbox(driver, email, "email");
		registerPage.inputToDynamicTextbox(driver, password, "password");
		registerPage.inputToDynamicTextbox(driver, "", "phone");
		registerPage.clickRegisterButton();

		verifyTrue(registerPage.isRegisterPageDisplayed());
	}

	@Test
	public void TC_07_Verify_Password_Is_Required() {
		registerPage.inputToDynamicTextbox(driver, name, "name");
		registerPage.inputToDynamicTextbox(driver, email, "email");
		registerPage.inputToDynamicTextbox(driver, phone, "phone");
		registerPage.inputToDynamicTextbox(driver, "", "password");
		registerPage.clickRegisterButton();

		verifyTrue(registerPage.isRegisterPageDisplayed());
	}
	
	@Test
	public void TC_08_Verify_Email_Format_Is_Validated() {
		registerPage.inputToDynamicTextbox(driver, name, "name");
		registerPage.inputToDynamicTextbox(driver, invalidEmail, "email");
		registerPage.inputToDynamicTextbox(driver, phone, "phone");
		registerPage.inputToDynamicTextbox(driver, password, "password");
		registerPage.clickRegisterButton();
		
		verifyTrue(registerPage.isRegisterPageDisplayed());
	}
	
	@Test
	public void TC_09_Verify_Email_Is_Unique() {
		registerPage.inputToDynamicTextbox(driver, name, "name");
		registerPage.inputToDynamicTextbox(driver, existingEmail, "email");
		registerPage.inputToDynamicTextbox(driver, phone, "phone");
		registerPage.inputToDynamicTextbox(driver, password, "password");
		registerPage.clickRegisterButton();
				
		verifyTrue(registerPage.isFailedValidationMesageDisplayed(driver));
	}

	@Test
	public void TC_10_Verify_Register_Success_When_Proving_All_Valid_Info() {
		registerPage.inputToDynamicTextbox(driver, name, "name");
		registerPage.inputToDynamicTextbox(driver, email, "email");
		registerPage.inputToDynamicTextbox(driver, phone, "phone");
		registerPage.inputToDynamicTextbox(driver, password, "password");
		registerSellerPage = registerPage.clickRegisterButton();
		
		verifyTrue(registerSellerPage.isRegisterSellerPageDisplayed());
	}

	@AfterClass
	public void afterClass() {
		quitDriver(driver);
	}

}
