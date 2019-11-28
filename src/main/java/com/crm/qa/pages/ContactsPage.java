package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath="//div[contains(@class, 'ui header')]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//button[contains(@class, 'ui linked')]//i[@class='edit icon']")
	WebElement newContactsBtn;
	
	@FindBy(xpath="//input[contains(@name, 'first_name')]")
	WebElement firstName;
	
	@FindBy(xpath="//input[contains(@name, 'last_name')]")
	WebElement lastName;
	
	@FindBy(xpath="//div[@name='company']//input")
	WebElement company;
	
	@FindBy(xpath="//i[@class='save icon']")
	WebElement saveBtn;
	
	//initializing the page objects.
		public ContactsPage() {
			PageFactory.initElements(driver, this);// all the elements of this class will be initialized with driver.
			// 'this' means it is pointing to current class object i.e. to the elements of current class.
		}
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//td[contains(text(), '"+name+"')]")).click();
	}
	
	public void clickOnNewBtn() {
		newContactsBtn.click();
	}
	
	public void createNewContact(String ftName, String ltName, String comp) {
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
