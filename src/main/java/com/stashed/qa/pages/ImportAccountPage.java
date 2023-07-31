package com.stashed.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stashed.qa.base.TestBase;

public class ImportAccountPage extends TestBase{
	
	@FindBy(id="import-account-key")
	WebElement privateKeyInput;
	
	@FindBy(id="import-account-pkey-btn")
	WebElement importBtn;
	
	//while importing private key for the first time
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[2]/div[3]/div/input")
	WebElement enterTagInput;
	
	@FindBy(id="import-account-name-btn")
	WebElement importBtnOnTagScreen;
	
	
	// Initializing the Page Objects:
	public ImportAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	//add new private key and hit on import button
	public void importNewPrivateKey(String NewPrivateKey) {
		privateKeyInput.sendKeys(NewPrivateKey);
		importBtn.click();
	}
	
	//add new tag and hit on import button
	public DashboardPage addNewTagAndImportAccount(String Tag) {
		enterTagInput.sendKeys(Tag);
		importBtnOnTagScreen.click();
		return new DashboardPage();
	}
	
	//with existing tag hit on import button
	public DashboardPage importAccount() {
		importBtnOnTagScreen.click();
		return new DashboardPage();
	}


}
