package com.mindtree.utilities;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentLogUtilities {
	public static void pass(WebDriver Driver, ExtentTest test, String msg, Logger log) throws IOException {
		test.log(LogStatus.PASS, msg);
		log.debug(msg);
		new ScreenShot(Driver, System.getProperty("user.dir") + "/ScreenShots/pass/").saveScreenShots();
	}

	public static void fail(WebDriver Driver, ExtentTest test, String msg, Logger log) throws IOException {
		test.log(LogStatus.FAIL, msg);
		log.error(msg);
		new ScreenShot(Driver, System.getProperty("user.dir") + "/ScreenShots/fail/").saveScreenShots();
	}

}
