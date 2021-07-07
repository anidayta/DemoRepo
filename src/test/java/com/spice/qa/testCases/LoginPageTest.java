package com.spice.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.spice.pages.LoginPage;
import com.spice.qa.base.TestBase;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	
	//createConstuctor using super constructor
	public LoginPageTest() {
		super();
		
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		  loginPage = new LoginPage();

	}
	
	@Test
	public void LoginPageTitle() {
	String title = loginPage.validateLoginPageTitle();
	Assert.assertEquals(title, "Login");
	
	}
	
	@Test
	public void logintest() {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	
	
}



