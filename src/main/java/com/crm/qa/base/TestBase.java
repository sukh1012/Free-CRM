package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public  static WebEventListener webEventListener;
	public static EventFiringWebDriver e_driver;
	
	public TestBase() {
		prop = new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream("C:\\Users\\Sukhwinder Singh\\eclipse-workspace\\FreeCRMTest"
					+ "\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static WebDriver initialization() {
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Sukhwinder\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();//launch chrome
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "D:\\Sukhwinder\\Selenium\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();//launch chrome
		}
		
		webEventListener = new WebEventListener();
		e_driver = new EventFiringWebDriver(driver);
		e_driver.register(webEventListener);
		driver = e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		


		return driver;
		
	}
	
	
}
