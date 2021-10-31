package com.mindtree.pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.mindtree.exception.PageObjectException;
import com.mindtree.exception.ReusableComponentException;
import com.mindtree.reusablecomponents.WebDriverSupport;
import com.mindtree.uistore.CartPageUi;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class CartPage extends CartPageUi {
	WebDriver driver;
	Logger log;
	ExtentTest test;

	public CartPage(WebDriver driver, Logger log, ExtentTest test) {
		this.driver = driver;
		this.log = log;
		this.test = test;
	}

	public void addToCart(String quantt) throws ReusableComponentException, Exception {
		try {
			Select quant = new Select(driver.findElement(quantity));
			quant.selectByValue(quantt);
			WebDriverSupport.click(driver, addToCartButton, "Cart Page", "Add To Cart", log, test);
			Thread.sleep(1000);
		} catch (Exception e) {
			ExtentLogUtilities.fail(driver, test, e.getMessage(), log);
			throw new PageObjectException(e.getMessage());
		}

	}
}
