package com.stashed.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stashed.qa.pages.DashboardPage;
import com.stashed.qa.base.TestBase;

public class SigninToWalletPage extends TestBase{
	
	//Page Factory
	@FindBy(id = "welcome-signin-btn")
	WebElement signinBtn;
	
	@FindBy(id = "signin-google")
	WebElement continueWithGoogleBtn;
	
	@FindBy(id = "identifierId")
	WebElement emailInputField;
	
	@FindBy(id = "identifierNext")
	WebElement identifierNextBtn;
	
	@FindBy(name = "Passwd")
	WebElement passwordInputField;
	
	@FindBy(id = "passwordNext")
	WebElement passwordNextBtn;
	
	@FindBy(xpath = "//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div/div/ul/li[1]/div")
	WebElement googleAccount;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[3]/div[3]/div/input")
	WebElement backupPasswordInput;
	
	@FindBy(id="signin-otp-password")
	WebElement ContinueBtn;
		
	
	// Initializing the Page Objects:
		public SigninToWalletPage() {
			PageFactory.initElements(driver, this);
		}

	
	// Actions
		// Click on Sign In button
		public void ClickOnSigninButton() {
			signinBtn.click();
		}
		
		// Click on Continue with Google button
		public void ClickOnContinueWithGoogleButton() {
			continueWithGoogleBtn.click();
			String parent=driver.getWindowHandle();
			
			System.out.println(parent);
			System.out.println(driver.switchTo().window(parent).getTitle());
			System.out.println("after log");
		}
		
		//enter gmail address and hit next
		public void EnterGmailAdress(String gmail) {
			emailInputField.sendKeys(gmail);
			identifierNextBtn.click();
		}
		
		//enter gmail password and hit next
		public void EnterGmailPassword(String Pwd) {
			passwordInputField.sendKeys(Pwd);
			passwordNextBtn.click();
		}
		
		//click on your gmail address
		public void ClickOnGoogleAccount() {
			googleAccount.click();
		}
		
		public DashboardPage LoginToDashboard (String Password) {
			backupPasswordInput.sendKeys(Password);
			ContinueBtn.click();
			return new DashboardPage();
		}

}
