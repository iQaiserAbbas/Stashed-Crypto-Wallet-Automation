package com.stashed.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.stashed.qa.base.TestBase;
import com.stashed.qa.pages.CreateAccountPage;
import com.stashed.qa.pages.DashboardPage;
import com.stashed.qa.pages.ImportAccountPage;
import com.stashed.qa.pages.SigninToWalletPage;

public class ImportAccountTest extends TestBase{
	
	SigninToWalletPage signinToWalletPage;
	ImportAccountPage importAccountPage;
	DashboardPage dashboardPage;
	
	public ImportAccountTest() {
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
				importAccountPage = new ImportAccountPage();
				dashboardPage = new DashboardPage();
			}
			
			@Test(priority = 2, groups = "Regression", description = ("Test Case Description: Import New Account with Private Key in Existing Wallet"))
			public void importNewAccountWithPrivateKey() throws InterruptedException {
				dashboardPage.ClickOnDropdown();
				Thread.sleep(2000);
				dashboardPage.ClickOnImportAccount();
				importAccountPage.importNewPrivateKey(prop.getProperty("New_PrivateKey"));
				dashboardPage = importAccountPage.addNewTagAndImportAccount(prop.getProperty("ImportNewAccountENS"));
				Thread.sleep(5000);
			}
			
			@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Import Account with Private Key that already has ENS"))
			public void importAccountWithPrivateKey() throws InterruptedException {
				dashboardPage.ClickOnDropdown();
				Thread.sleep(2000);
				dashboardPage.ClickOnImportAccount();
				importAccountPage.importNewPrivateKey(prop.getProperty("PrivateKey"));
				dashboardPage = importAccountPage.importAccount();
				Thread.sleep(5000);
			}
			
			@AfterMethod
			public void tearDown() {
				driver.quit();
			}

}
