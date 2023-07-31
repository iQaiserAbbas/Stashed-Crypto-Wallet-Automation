package com.stashed.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.stashed.qa.base.TestBase;
import com.stashed.qa.pages.DashboardPage;
import com.stashed.qa.pages.SigninToWalletPage;
import com.stashed.qa.utils.WindowHandler;

public class SigninToWalletTest extends TestBase{
	
	SigninToWalletPage signinToWalletPage;
	WindowHandler windowHandler;
	DashboardPage dashboardPage;

	
	public SigninToWalletTest() {
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
		windowHandler = new WindowHandler(driver);
	}
	
	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Signin/onboarding for New User"))
	public void Signin() throws InterruptedException {
		signinToWalletPage.ClickOnSigninButton();
		Thread.sleep(2000);
		signinToWalletPage.ClickOnContinueWithGoogleButton();
	    windowHandler.switchWindows("child");
	    signinToWalletPage.ClickOnGoogleAccount();
	    windowHandler.switchWindows("parent");
	    Thread.sleep(10000);
	    dashboardPage = signinToWalletPage.LoginToDashboard(prop.getProperty("Password"));
	    Thread.sleep(7000);
	    
	    
		//signinToWalletPage.EnterGmailAdress(prop.getProperty("gmail"));
		//signinToWalletPage.EnterGmailPassword(prop.getProperty("gmailPassword"));
		
	}
	
	@Test(priority = 2)
	public void clickOnContinueWithGoogleBtn() {
		signinToWalletPage.ClickOnContinueWithGoogleButton();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
