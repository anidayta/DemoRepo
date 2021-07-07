package com.spice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.spice.qa.base.TestBase;

public class SignUpPage extends TestBase{

	//page Factory - OR:(object repository)
	
	@findBy(name="first_name", xpath = "//input[@id='first-name']")
	WebElement first_name;
	
	@findBy (name= "last_name", xpath= "//input[@id='last-name']")
	WebElement last_name;
	
	@findBy(name = "email", xpath = "//input[@id='email']")
	WebElement email;
	
	@findBy(name = "password", xpath = "//input[@id='password']")
	WebElement password;
	
	@findBy(name = "checkbox", xpath = "//input[@id='eula']")
	WebElement checkbox;
	
	@findBy(xpath="//input[@id='tp-sign-up']", name = "submit")
	WebElement submit;
	
	
	//initialzing the Page object
	public void SingUpPage() {
		PageFactory.initElements(driver, this);
		
		
	}

	//Actions
	
	public String validateSignUpPageTitle() {
		return driver.getTitle();
	}
	
		public boolean validateCheckbox() {
			return checkbox.isDisplayed();
			
		}
		
			public void signUp(String fn, String ln, String mail, String pwd) {
				first_name.sendKeys(fn);
				last_name.sendKeys(ln);
				email.sendKeys(mail);
				password.sendKeys(pwd);
				checkbox.click();
				submit.click();
	
				
			}
		
	}
	




