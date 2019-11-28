package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//span[contains(@class, 'user-display')]")
	@CacheLookup //This annotation is to store the element in cache and look in cache for that element for all next calls.
	// This annotation should only be used with those elements whose dom structure will not change in future.
	WebElement userNameLabel;
	
	@FindBy(xpath="//span[contains(text(), 'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//span[contains(text(), 'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//span[contains(text(), 'Tasks')]")
	WebElement tasksLink;
	
	
	//initializing the page objects.
		public HomePage() {
			PageFactory.initElements(driver, this);// all the elements of this class will be initialized with driver.
			// 'this' means it is pointing to current class object i.e. to the elements of current class.
		}
		
		public String verifyHomePageTitle() {
			return driver.getTitle();
		}
		
		public boolean verifyCorrectUserName() {
			return userNameLabel.isDisplayed();
		}
		
		public ContactsPage clickOnContactsLink() {
			contactsLink.click();
			return new ContactsPage();
		}
		
		public DealsPage clickOnDealsLink() {
			dealsLink.click();
			return new DealsPage();
		}
		
		public TasksPage clickOnTasksLink() {
			tasksLink.click();
			return new TasksPage();
		}
		
		
	
	
}
