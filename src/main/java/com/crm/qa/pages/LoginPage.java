package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//Page Factory or Object Repository
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signUpBtn;
	
	//initializing the page objects.
	public LoginPage() {
		PageFactory.initElements(driver, this);// all the elements of this class will be initialized with driver.
		// 'this' means it is pointing to current class object i.e. to the elements of current class.
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String mail, String pwd) {
		email.sendKeys(mail);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();// returning object of homepage class as after login, user will be on home page.
	}
	
	
	
}
