package com.mindtree.pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.exception.PageObjectException;
import com.mindtree.utilities.ExtentLogUtilities;
import com.mindtree.utilities.GetProperties;
import com.relevantcodes.extentreports.ExtentTest;

public class ValidatePageTitle extends GetProperties {
	WebDriver driver;
	Logger log;
	ExtentTest test;

	public ValidatePageTitle(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}

	public void validate() throws PageObjectException, Exception {
		String title = get.getProperty("title");
		if (title.equalsIgnoreCase(driver.getTitle())) {
			ExtentLogUtilities.pass(driver, test, "Page opend with title " + title, log);
		} else {
			try {
				ExtentLogUtilities.fail(driver, test, "Page not opened with title " + title, log);
			} catch (Exception e) {
				throw new PageObjectException(e.getMessage());
			}
		}
	}
}
