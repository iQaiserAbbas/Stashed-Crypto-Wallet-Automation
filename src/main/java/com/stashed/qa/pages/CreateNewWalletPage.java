package com.stashed.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stashed.qa.base.TestBase;

public class CreateNewWalletPage extends TestBase{
	
	@FindBy(id="welcome-create-account-btn")
	WebElement CreateAccountbtn;
	
	@FindBy(id="signup-google-btn")
	WebElement continueWithGoogleBtn;
	
	@FindBy(xpath = "//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div/div/ul/li[1]/div/div[1]/div/div[2]/div[2]")
	WebElement googleAccount;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[3]/div/div[1]/input")
	WebElement enterPasswordInput;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[3]/div/div[2]/input")
	WebElement enterConfirmPasswordInput;
	
	@FindBy(id="backup-password-checkbox-off")
	WebElement checkboxTerms;
	
	@FindBy(id="backup-password-continue-btn")
	WebElement ContinueBtn;
	
	@FindBy(id="country-select")
	WebElement selectCountry;
	
	@FindBy(id="search-country")
	WebElement searchCountry;
	
	@FindBy(xpath = "/html/body/div[2]/div[3]/ul/li[167]")
	WebElement selectPakistan;
	
	@FindBy(id="phone-number-input")
	WebElement phoneNumberInputField;
	
	@FindBy(id="phone-number-verify")
	WebElement VerifyBtn;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[1]/input[1]")
	WebElement otpInputField;
	
	@FindBy(id="otp-vrify-btn")
	WebElement otpVerifyBtn;
	
	@FindBy(id="answer-1")
	WebElement answerOneInputField;
	
	@FindBy(id="answer-checkbox-1")
	WebElement checkboxOne;
	
	@FindBy(id="answer-2")
	WebElement answerTwoInputField;
	
	@FindBy(id="answer-checkbox-2")
	WebElement checkboxTwo;
	
	@FindBy(id="answer-3")
	WebElement answerThreeInputField;
	
	@FindBy(id="answer-checkbox-3")
	WebElement checkboxThree;
	
	@FindBy(id="security-question-btn")
	WebElement confirmQuestionBtn;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[3]/div/input")
	WebElement ensInput;
	
	@FindBy(id="create-account-ens-btn")
	WebElement continueToDashboardBtn;
		
	
	// Initializing the Page Objects:
		public CreateNewWalletPage() {
			PageFactory.initElements(driver, this);
		}
		
	// Actions
			// Click on Create Account button
			public void ClickOnCreateAccountButton() {
				CreateAccountbtn.click();
			}
	
			// Click on Continue with Google button
			public void ClickOnContinueWithGoogleButton() {
				continueWithGoogleBtn.click();
				String parent=driver.getWindowHandle();
				
				System.out.println(parent);
				System.out.println(driver.switchTo().window(parent).getTitle());
				System.out.println("after log");
			}
			
			//click on your gmail address
			public void ClickOnNewGoogleAccount() {
				googleAccount.click();
			}
			
			//enter password, confirm password, accept terms and hit continue button
			public void enterPasswordAndConfirmPassword (String Password, String ConfirmPassword) {
				enterPasswordInput.sendKeys(Password);
				enterConfirmPasswordInput.sendKeys(ConfirmPassword);
				checkboxTerms.click();
				ContinueBtn.click();
			}
			
			//search and select country Pakistan then enter phone number and hit verify button
			public void enterPhoneNumber (String CountryName, String PhoneNumber) {
				selectCountry.click();
				searchCountry.sendKeys(CountryName);
				selectPakistan.click();
				phoneNumberInputField.sendKeys(PhoneNumber);
				VerifyBtn.click();
			}
			
			//click on OTP input field
			public void ClickOnOtpInput(String OTP) {
				otpInputField.click();
				otpInputField.sendKeys(OTP);
			}
			
			//click on OTP verify button
			public void ClickOnOtpVerifyButton() {
				otpVerifyBtn.click();
			}
			
			//answer all security questions and hit on confirm button
			public void answerSecurityQuestions (String Ans1, String Ans2, String Ans3) throws InterruptedException {
				answerOneInputField.click();
				answerOneInputField.sendKeys(Ans1);
				checkboxOne.click();
				checkboxOne.isSelected();
				checkboxOne.isEnabled();
				
				answerTwoInputField.click();
				answerTwoInputField.sendKeys(Ans2);
				checkboxTwo.click();
				checkboxTwo.isEnabled();
				checkboxTwo.isSelected();
				
				answerThreeInputField.click();
				answerThreeInputField.sendKeys(Ans3);
				checkboxThree.click();
				checkboxThree.isEnabled();
				checkboxThree.isSelected();
				
				confirmQuestionBtn.click();
			}
			
			public DashboardPage SignupToDashboard (String Ens) {
				ensInput.sendKeys(Ens);
				continueToDashboardBtn.click();
				return new DashboardPage();
			}

}
