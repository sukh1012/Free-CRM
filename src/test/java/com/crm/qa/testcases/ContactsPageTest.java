package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	String sheetName="contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		contactsPage = new ContactsPage();
		loginPage= new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(2000);
		contactsPage = homePage.clickOnContactsLink();
		Thread.sleep(2000);
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel() throws InterruptedException {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts label is missing on the page");
		Thread.sleep(2000);
	}
	
	@Test(priority=2)
	public void selectContactsTest() throws InterruptedException {
		contactsPage.selectContactsByName("Tom Peter");
		Thread.sleep(2000);
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest() throws InterruptedException {
		contactsPage.selectContactsByName("Tom Peter");
		contactsPage.selectContactsByName("Sam Peter");
		Thread.sleep(2000);
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String firstName, String lastName, String company) {
		contactsPage.clickOnNewBtn();
		//contactsPage.createNewContact("John", "Peter", "Google");
		contactsPage.createNewContact(firstName, lastName, company);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
