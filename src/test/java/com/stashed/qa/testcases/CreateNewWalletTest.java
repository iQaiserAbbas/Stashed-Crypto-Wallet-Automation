package com.stashed.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.stashed.qa.base.TestBase;
import com.stashed.qa.pages.CreateNewWalletPage;
import com.stashed.qa.pages.DashboardPage;
import com.stashed.qa.pages.SigninToWalletPage;
import com.stashed.qa.utils.WindowHandler;

public class CreateNewWalletTest extends TestBase{
	
	SigninToWalletPage signinToWalletPage;
	CreateNewWalletPage createNewWalletPage;
	WindowHandler windowHandler;
	DashboardPage dashboardPage;
	
	public CreateNewWalletTest() {
		super(); //to call superclass constructor
	}
	
	// test cases should be separated -- independent with each other
		// before each test case -- launch the browser and login
		// @test -- execute test case
		// after each test case -- close the browser
		
		@BeforeMethod
		public void setUp() throws InterruptedException {
			initialization();
			signinToWalletPage = new SigninToWalletPage();
			createNewWalletPage = new CreateNewWalletPage();
			windowHandler = new WindowHandler(driver);
		}
		
		@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Create Stashed Account for New User"))
		public void Signup() throws InterruptedException {
			createNewWalletPage.ClickOnCreateAccountButton();
			Thread.sleep(2000);
			createNewWalletPage.ClickOnContinueWithGoogleButton();
			windowHandler.switchWindows("child");
			createNewWalletPage.ClickOnNewGoogleAccount();
			windowHandler.switchWindows("parent");
		    Thread.sleep(10000);
		    createNewWalletPage.enterPasswordAndConfirmPassword(prop.getProperty("Password"), prop.getProperty("ConfirmPassword"));
		    createNewWalletPage.enterPhoneNumber(prop.getProperty("CountryName"), prop.getProperty("PhoneNumber"));
		    createNewWalletPage.ClickOnOtpInput(prop.getProperty("OTP"));
		    createNewWalletPage.ClickOnOtpVerifyButton();
		    Thread.sleep(2000);
		    createNewWalletPage.answerSecurityQuestions(prop.getProperty("Ans1"), prop.getProperty("Ans2"), prop.getProperty("Ans3"));
		    dashboardPage = createNewWalletPage.SignupToDashboard(prop.getProperty("ENS"));
		    Thread.sleep(5000);
		}
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}

}
