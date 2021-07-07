package com.spice.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.spice.qa.util.TestUtilclass;

public class TestBase {
	
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
	
		try {

		prop = new Properties(); //create prop as a object
		FileInputStream ip = new FileInputStream("C:\\Users\\user\\eclipse-workspace\\McLendTest\\src\\main\\java\\com\\spice\\qa\\config\\config.properties");
		prop.load(ip);
		 
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
}
	
	public static void initialization() {
	String browserName = prop.getProperty("browser");
	if(browserName.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();	
	
	}
	getDriver().manage().window().maximize();
	getDriver().manage().deleteAllCookies();
	getDriver().manage().timeouts().pageLoadTimeout(TestUtilclass.PAGE_LOAD_TIMOUT, TimeUnit.SECONDS);
	getDriver().manage().timeouts().implicitlyWait(TestUtilclass.IMPLICIT_WAIT, TimeUnit.SECONDS);
	getDriver().get(prop.getProperty("url"));
}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		TestBase.driver = driver;
	}
}



