package com.mindtree.pageobject;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.exception.PageObjectException;
import com.mindtree.reusablecomponents.WebDriverSupport;
import com.mindtree.uistore.MobileCoverOrderUi;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class MobileCoverOrder extends MobileCoverOrderUi {

	WebDriver driver;
	Logger log;
	ExtentTest test;

	public MobileCoverOrder(WebDriver driver, Logger log, ExtentTest test) {
		this.driver = driver;
		this.log = log;
		this.test = test;
	}

	public void orderCover(String brandname, String brandModel) throws PageObjectException, IOException {
		try {
			WebDriverSupport.click(driver, mobileCover, "Home Page", "Mobile Cover", log, test);
			Thread.sleep(1000);
			List<WebElement> brands = driver.findElements(brandName);
			for (WebElement temp : brands) {
				if (temp.getText().equalsIgnoreCase(brandname)) {
					WebDriverSupport.clickByWebElement(driver, temp, "Mobile Cover", brandname, log, test);
					List<WebElement> brandmodels = driver.findElements(models);
					System.out.println(brandmodels.size());
					if (brandmodels.size() > 0) {
						for (WebElement tempName : brandmodels) {
							if (tempName.getText().equalsIgnoreCase(brandModel)) {
								WebDriverSupport.clickByWebElement(driver, tempName, "Model Page", brandModel, log,
										test);
								Thread.sleep(1000);
								List<WebElement> titles = driver.findElements(resultsTitle);
								if (titles.size() > 0) {
									for (WebElement cover : titles) {
										WebDriverSupport.clickByWebElement(driver, cover, "Cover Page", cover.getText(),
												log, test);
										break;
									}
									break;
								} else {
									break;
								}
							}
						}
						break;
					} else {
						break;
					}
				}
			}
		} catch (Exception e) {
			ExtentLogUtilities.fail(driver, test, e.getMessage(), log);
			throw new PageObjectException(e.getMessage());
		}

	}

}
