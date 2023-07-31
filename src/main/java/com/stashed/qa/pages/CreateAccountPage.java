package com.stashed.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stashed.qa.base.TestBase;

public class CreateAccountPage extends TestBase{
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[2]/div[3]/div[1]/input")
	WebElement enterTagInput;
	
	@FindBy(id="create-account-new-btn")
	WebElement createBtn;
	
	@FindBy(id="btn")
	WebElement useThisAccountBtn;
	
	
	// Initializing the Page Objects:
			public CreateAccountPage() {
				PageFactory.initElements(driver, this);
			}
			
		// Actions
				
				//add new tag and hit on create button
				public void addNewTag(String Tag) {
					enterTagInput.sendKeys(Tag);
					createBtn.click();
				}
				
				public DashboardPage useAccountInDashboard () {
					useThisAccountBtn.click();
					return new DashboardPage();
				}

}
