package com.stashed.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.stashed.qa.utils.TestUtils;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		// this constructor is to read properties from config file
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\H-P\\eclipse-workspace\\Stashed\\src\\main\\java\\com\\stashed\\qa\\config\\config.properties");
			prop.load(ip);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			
			//1. for opening local chrome profile with logged in gmail
			//2. close all chrome instances before running this test
			options.addArguments("user-data-dir=C:\\Users\\H-P\\AppData\\Local\\Google\\Chrome\\User Data");
			options.addArguments("--profile-directory=Profile 9");
			
			//3. added the below line because was facing error: Unable to establish websocket connection
			options.addArguments("--remote-allow-origins=*");

			driver = new ChromeDriver(options);
			
		} 
		
		else if (browserName.equals("FF")) {
			FirefoxOptions options = new FirefoxOptions();
			driver = new FirefoxDriver(options);
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtils.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtils.IMPLICIT_WAIT));
		
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		


		
	}
}
