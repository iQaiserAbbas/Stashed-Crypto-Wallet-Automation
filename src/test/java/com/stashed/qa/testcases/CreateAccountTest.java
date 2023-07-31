package com.stashed.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.stashed.qa.base.TestBase;
import com.stashed.qa.pages.CreateAccountPage;
import com.stashed.qa.pages.DashboardPage;
import com.stashed.qa.pages.SigninToWalletPage;

public class CreateAccountTest extends TestBase{
	
	SigninToWalletPage signinToWalletPage;
	CreateAccountPage createAccountPage;
	DashboardPage dashboardPage;
	
	public CreateAccountTest() {
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
				createAccountPage = new CreateAccountPage();
				dashboardPage = new DashboardPage();
			}
			
			@Test(priority = 2, groups = "Regression", description = ("Test Case Description: Create New Account"))
			public void createNewAccount() throws InterruptedException {
				dashboardPage.ClickOnDropdown();
				Thread.sleep(2000);
				dashboardPage.ClickOnCreateAccount();
				createAccountPage.addNewTag(prop.getProperty("CreateNewAccountENS"));
				dashboardPage = createAccountPage.useAccountInDashboard();
			}
			
			@AfterMethod
			public void tearDown() {
				driver.quit();
			}

}
