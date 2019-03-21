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
import pageObjects.ProfilePageObject;
import pageObjects.SettingPageObject;
import testData.Login;

public class User_07_Setting_Page extends AbstractTest {

	WebDriver driver;
	WebDriverWait wait;

	private HomePageObject homePage;
	private LoginOptionsPageObject loginOptionsPage;
	private LoginPageObject loginPage;
	private ProfilePageObject profilePage;
	private SettingPageObject settingPage;

	String email, password, phone, name, updatedEmail, updatedPassword, updatedName, updatedPhone;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String url) {
		driver = openMultiBrowsers(browser, url);
		homePage = PageFactoryManager.openHomePage(driver);
		loginOptionsPage = homePage.openLoginOptionsPage(driver);
		loginPage = loginOptionsPage.clickLoginButton();
		
		email = Login.EMAIL;
		password = Login.PASSWORD;
			
		loginPage.inputToDynamicTextbox(driver, email, "email");
		loginPage.inputToDynamicTextbox(driver, password, "password");
		profilePage = loginPage.clickLoginButton();
		settingPage = profilePage.clickSettingButton();
		
		email = settingPage.getTextDynamicTextBox(driver, "value", "email");
		name = settingPage.getTextDynamicTextBox(driver, "value", "name");
		phone = settingPage.getTextDynamicTextBox(driver, "value", "phone");		
		password = Login.PASSWORD;
		
		updatedEmail = email + ".au";
		updatedName = name + " Updated";
		updatedPhone = "0982080032";
		updatedPassword = "123123";
		
	}
	
	@Test
	public void TC_01_Verify_User_Is_Able_To_Update_Name() {
		settingPage.inputToDynamicTextbox(driver, updatedName, "name");
		settingPage.clickToDynamicButton("Update name");
		
		verifyTrue(settingPage.isDynamicSuccessMessageDisplayed("Name updated."));
	}
	
	@Test
	public void TC_02_Verify_User_Is_Able_To_Update_Phone() {
		settingPage.inputToDynamicTextbox(driver, updatedPhone, "phone");
		settingPage.clickToDynamicButton("Update phone");
		
		verifyTrue(settingPage.isDynamicSuccessMessageDisplayed("Phone updated."));
	}
	
	@Test
	public void TC_03_Verify_User_Is_Able_To_Update_Email() {
		settingPage.inputToDynamicTextbox(driver, updatedEmail, "email");
		settingPage.clickToDynamicButton("Update email");
		
		verifyTrue(settingPage.isDynamicSuccessMessageDisplayed("Email updated"));
	}
	
	@Test
	public void TC_04_Verify_User_Is_Able_To_Update_Password() {
		settingPage.inputToDynamicTextbox(driver, updatedPassword, "password");
		settingPage.clickToDynamicButton("Update password");
		
		verifyTrue(settingPage.isDynamicSuccessMessageDisplayed("Password updated."));
	}
	
	@Test
	public void TC_05_Verify_User_Is_Able_To_Login_With_New_Email_And_Password() {
		settingPage.clickLogoutButton(driver);
		loginPage = settingPage.clickConfirmLogoutButton(driver);
		
		loginPage.inputToDynamicTextbox(driver, updatedEmail, "email");
		loginPage.inputToDynamicTextbox(driver, updatedPassword, "password");
		profilePage = loginPage.clickLoginButton();
		settingPage = profilePage.clickSettingButton();
		
		verifyEquals(settingPage.getTextDynamicTextBox(driver, "value", "email"), updatedEmail);
		verifyEquals(settingPage.getTextDynamicTextBox(driver, "value", "name"), updatedName);
		verifyEquals(settingPage.getTextDynamicTextBox(driver, "value", "phone"), updatedPhone);
	}


	@AfterClass
	public void afterClass() {
		settingPage.inputToDynamicTextbox(driver, name, "name");
		settingPage.clickToDynamicButton("Update name");
		
		verifyTrue(settingPage.isDynamicSuccessMessageDisplayed("Name updated."));
		
		settingPage.inputToDynamicTextbox(driver, phone, "phone");
		settingPage.clickToDynamicButton("Update phone");
		
		verifyTrue(settingPage.isDynamicSuccessMessageDisplayed("Phone updated."));
		
		settingPage.inputToDynamicTextbox(driver, email, "email");
		settingPage.clickToDynamicButton("Update email");
		
		verifyTrue(settingPage.isDynamicSuccessMessageDisplayed("Email updated."));
		
		settingPage.inputToDynamicTextbox(driver, password, "password");
		settingPage.clickToDynamicButton("Update password");
		
		verifyTrue(settingPage.isDynamicSuccessMessageDisplayed("Password updated."));
		
		quitDriver(driver);
	}

}
