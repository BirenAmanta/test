package com.mindtree.pageobject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.exception.PageObjectException;
import com.mindtree.exception.ReusableComponentException;
import com.mindtree.reusablecomponents.WebDriverSupport;
import com.mindtree.uistore.SearchBookUi;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class SearchBook extends SearchBookUi {

	WebDriver driver;
	Logger log;
	ExtentTest test;

	public SearchBook(WebDriver driver, Logger log, ExtentTest test) {
		this.driver = driver;
		this.log = log;
		this.test = test;
	}

	public void searchAndAdd(String bookName) throws ReusableComponentException, Exception {
		try {
			WebDriverSupport.sendKeys(driver, searchBox, "Home Page", "Search Box", log, test, bookName);
			WebDriverSupport.click(driver, searchButton, "Home Page", "Search Button", log, test);
			Thread.sleep(1000);
			List<WebElement> searchResult = driver.findElements(resultsTitle);
			for (WebElement temp : searchResult) {
				System.out.println(temp.getText());
				if (temp.getText().contains(bookName)) {
					WebDriverSupport.clickByWebElement(driver, temp, "Search Page", bookName, log, test);
					break;
				}
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			ExtentLogUtilities.fail(driver, test, e.getMessage(), log);
			throw new PageObjectException(e.getMessage());
		}
	}
}
