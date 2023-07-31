package com.stashed.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stashed.qa.base.TestBase;

public class DashboardPage extends TestBase{
	
	@FindBy(id="accounr-modal-open")
	WebElement dropdown;
	
	@FindBy(id="create-account-modal-btn")
	WebElement createAccountTxt;
	
	@FindBy(id="import-account-modal-btn")
	WebElement importAccountTxt;
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	// Click on dropdown
	public void ClickOnDropdown() {
		dropdown.click();
	}
	
	// Click on Create Account text
	public void ClickOnCreateAccount() {
		createAccountTxt.click();
	}
	
	// Click on Create Account text
	public void ClickOnImportAccount() {
		importAccountTxt.click();
	}

}
