package com.mindtree.uistore;

import org.openqa.selenium.By;

public class SearchBookUi {
	public static By searchBox = By.xpath("//input[@placeholder='What are you looking for?']");
	public static By searchButton = By.xpath("//button[@aria-label='Search']");
	public static By resultsTitle = By.xpath("//h2[@class='productitem--title']");
}
