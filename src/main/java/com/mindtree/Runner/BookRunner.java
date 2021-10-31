package com.mindtree.Runner;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.mindtree.exception.PageObjectException;
import com.mindtree.exception.UtilityException;
import com.mindtree.pageobject.*;
import com.mindtree.reusablecomponents.Base;
import com.mindtree.utilities.ExtentLogUtilities;
import com.mindtree.utilities.GetProperties;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BookRunner extends Base {
	public BookRunner() throws UtilityException, Exception {
		super();
	}

	static Logger log;
	static ExtentTest test;
	static ExtentReports report;

	@BeforeTest
	public void initilize() throws InterruptedException, IOException {
		report = new ExtentReports(System.getProperty("user.dir") + "\\reports\\" + "ExtentReportResults-"
				+ System.currentTimeMillis() + "-.html");
		log = Logger.getLogger(BookRunner.class.getName());
		driver = initialize();
		test = report.startTest("Home Page");
		driver.get(GetProperties.get.getProperty("url"));
		driver.manage().window().maximize();
		ExtentLogUtilities.pass(driver, test, "URL Opened", log);
		report.endTest(test);
		report.flush();

	}

	@Test(priority = 1)
	public void validate() throws PageObjectException, Exception {
		test = report.startTest("Validate Page");
		new ValidatePageTitle(driver, log, test).validate();
		report.endTest(test);
		report.flush();
	}

	@Test(priority = 2, dataProvider = "homepage")
	public void HomePage(String BookName, String Author, String language, String quant)
			throws PageObjectException, Exception {
		test = report.startTest("Home Page");
		new HindiBook(driver, log, test).buyHindiBook(language, BookName, Author);
		Thread.sleep(1000);
		new CartPage(driver, log, test).addToCart(quant);
		Thread.sleep(1000);
		report.endTest(test);
		report.flush();
	}

	@Test(priority = 3, dataProvider = "dropdown")
	public void dropDownSelector(String BookName, String type, String Author, String language, String quant)
			throws PageObjectException, Exception {
		test = report.startTest("Drop Down List");
		new BooksDropDown(driver, log, test).addBookCart(BookName, type, Author, language);
		Thread.sleep(1000);
		new CartPage(driver, log, test).addToCart(quant);
		Thread.sleep(1000);
		report.endTest(test);
		report.flush();
	}

	@Test(priority = 4, dataProvider = "search")
	public void searchBook(String bookName, String quanty) throws PageObjectException, Exception {
		test = report.startTest("Search Book");
		new SearchBook(driver, log, test).searchAndAdd(bookName);
		;
		Thread.sleep(1000);
		new CartPage(driver, log, test).addToCart(quanty);
		Thread.sleep(1000);
		report.endTest(test);
		report.flush();
	}

	@Test(priority = 5, dataProvider = "cover")
	public void mobileCover(String BrandName, String Model, String quantity) throws PageObjectException, Exception {
		test = report.startTest("Cover Page");
		new MobileCoverOrder(driver, log, test).orderCover(BrandName, Model);
		Thread.sleep(1000);
		new CartPage(driver, log, test).addToCart(quantity);
		Thread.sleep(1000);
		report.endTest(test);
		report.flush();
	}

	@DataProvider
	public String[][] homepage() {
		String data[][] = new String[1][4];
		data[0][0] = "KARMABHUMI";
		data[0][1] = "Premchand";
		data[0][2] = "English";
		data[0][3] = "3";
		return data;

	}

	@DataProvider
	public String[][] dropdown() {
		String data[][] = new String[1][5];
		data[0][0] = "The Lost Symbol, Inferno & Origin (Set of 3 Dan Brown Combo Hardcover Edition)";
		data[0][1] = "Books Combo";
		data[0][2] = "Dan Brown";
		data[0][3] = "English";
		data[0][4] = "2";

		return data;

	}

	@DataProvider
	public String[][] search() {
		String data[][] = new String[1][2];
		data[0][0] = "Wings of Fire";
		data[0][1] = "4";
		return data;
	}

	@DataProvider
	public String[][] cover() {
		String data[][] = new String[1][3];
		data[0][0] = "Apple";
		data[0][1] = "iPhone 11";
		data[0][2] = "2";
		return data;
	}

	@AfterTest
	public void terminate() throws InterruptedException {

		Thread.sleep(1000);
		driver.quit();

	}
}