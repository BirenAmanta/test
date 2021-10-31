package com.mindtree.reusablecomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mindtree.exception.UtilityException;
import com.mindtree.utilities.GetProperties;

public class Base extends GetProperties {

	public Base() throws UtilityException, Exception {
		super();
	}

	static public WebDriver driver;

	public static WebDriver initialize() {
		if (driver == null) {
			if (get.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + get.getProperty("path"));
				driver = new ChromeDriver();
			} else if (get.getProperty("browser").equals("firefox")) {

			} else if (get.getProperty("browser").equals("IE")) {

			}
		}
		return driver;
	}
}
