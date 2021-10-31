package com.mindtree.pageobject;

import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.mindtree.exception.PageObjectException;
import com.mindtree.reusablecomponents.WebDriverSupport;
import com.mindtree.uistore.BooksDropDownUi;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class BooksDropDown extends BooksDropDownUi {

	WebDriver driver;
	Logger log;
	ExtentTest test;

	public BooksDropDown(WebDriver driver, Logger log, ExtentTest test) {
		this.driver = driver;
		this.log = log;
		this.test = test;
	}

	public void addBookCart(String bookName, String type, String Author, String Language)
			throws PageObjectException, IOException {
		try {
			new Actions(driver).moveToElement(driver.findElement(allBooks)).build().perform();
			Thread.sleep(1000);
			List<WebElement> dropDown = driver.findElements(dropDowns);
			System.out.println(dropDown.size());
			for (WebElement Drops : dropDown) {
				System.out.println(Drops.getText());
				if (type.equalsIgnoreCase("ncert books") && type.equalsIgnoreCase(Drops.getText())) {
					WebDriverSupport.clickByWebElement(driver, Drops, "Home page", type, log, test);
					Thread.sleep(1000);
					List<WebElement> authors = driver.findElements(NCERTClassses);
					for (WebElement temp : authors) {
						System.out.println(temp.getText());
						if (temp.getText().equalsIgnoreCase(Author)) {
							WebDriverSupport.clickByWebElement(driver, temp, "NCERT page", "Author", log, test);
							break;
						}
					}
					Thread.sleep(1000);
					List<WebElement> books = driver.findElements(searchBooks);
					for (WebElement temp : books) {
						System.out.println(temp.getText());
						if (temp.getText().equalsIgnoreCase(bookName)) {
							WebDriverSupport.clickByWebElement(driver, temp, "NCERT page", bookName, log, test);
							break;
						}
					}
					break;
				} else if (type.equalsIgnoreCase(Drops.getText())) {
					WebDriverSupport.clickByWebElement(driver, Drops, "Home Page", type, log, test);
					Thread.sleep(1000);
					if (driver.findElements(seeMore).size() > 0)
						WebDriverSupport.click(driver, seeMore, type + "Page", "see more", log, test);

					Thread.sleep(1000);
					List<WebElement> classes = driver.findElements(author);
					for (WebElement temp : classes) {
						System.out.println(temp.getText());
						if (temp.getText().equalsIgnoreCase(Author)) {
							WebDriverSupport.clickByWebElement(driver, temp, type + " page", "Author", log, test);
							break;
						}
					}
					Thread.sleep(1000);
					List<WebElement> languages = driver.findElements(language);
					for (WebElement temp : languages) {
						System.out.println(temp.getText());
						if (temp.getText().equalsIgnoreCase(Language)) {
							WebDriverSupport.clickByWebElement(driver, temp, type + " page", "Author", log, test);
							break;
						}
					}
					Thread.sleep(1000);
					List<WebElement> books = driver.findElements(searchBooks);
					for (WebElement temp : books) {
						System.out.println(temp.getText());
						if (temp.getText().equalsIgnoreCase(bookName)) {
							WebDriverSupport.clickByWebElement(driver, temp, type + " page", bookName, log, test);
							break;
						}
					}
					break;
				}

			}
		} catch (Exception e) {
			ExtentLogUtilities.fail(driver, test, e.getMessage(), log);
			throw new PageObjectException(e.getMessage());
		}
	}
}
