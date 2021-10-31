package com.mindtree.pageobject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.exception.PageObjectException;
import com.mindtree.reusablecomponents.WebDriverSupport;
import com.mindtree.uistore.HindiPageUi;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class HindiBook extends HindiPageUi {

	WebDriver driver;
	Logger log;
	ExtentTest test;

	public HindiBook(WebDriver driver, Logger log, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}

	public void buyHindiBook(String lang, String book, String Author) throws PageObjectException, Exception {
		try {
			WebDriverSupport.click(driver, hindiBook, "Home page", "Hindi Book", log, test);
			WebDriverSupport.click(driver, seeMore, "Home page", "More Authors", log, test);
			List<WebElement> authors = driver.findElements(author);
			for (WebElement author : authors) {
				System.out.println(author.getText());
				if (author.getText().equalsIgnoreCase(Author)) {

					WebDriverSupport.clickByWebElement(driver, author, "Hindi Books Page", "Author", log, test);
					break;
				}
			}
			Thread.sleep(1000);
			List<WebElement> languages = driver.findElements(language);
			for (WebElement lag : languages) {
				System.out.println(lag.getText());
				if (lag.getText().trim().equalsIgnoreCase(lang)) {
					System.out.println(lag.getText());
					WebDriverSupport.clickByWebElement(driver, lag, "Hindi Books Page", lang, log, test);
					break;
				}
			}
			Thread.sleep(1000);
			List<WebElement> books = driver.findElements(resultsTitle);
			for (WebElement tempBook : books) {
				String title = tempBook.getText();
				System.out.println(book);
				if (title.contains(book)) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,350)", "");
					System.out.println("True");
					WebDriverSupport.clickByWebElement(driver, tempBook, "Hindi Books Page", "Book Name", log, test);
					break;
				}
				System.out.println(title + " go");
			}
			Thread.sleep(1000);

		} catch (Exception e) {
			ExtentLogUtilities.fail(driver, test, e.getMessage(), log);
			throw new PageObjectException(e.getMessage());
		}
	}
}
