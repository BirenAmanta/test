package com.mindtree.uistore;

import org.openqa.selenium.By;

public class HindiPageUi {
	public static By hindiBook = By.cssSelector("li.navmenu-item.navmenu-id-hindi-books a.navmenu-link");
	public static By seeMore = By.xpath("//ul[@data-filter-group='Author']//li  //a[contains(text(),'See more')]");
	public static By author = By.xpath("//ul[@data-filter-group='Author'] //span[@class='filter-text']");
	public static By language = By.xpath("//ul[@data-filter-group='Language'] //span[@class='filter-text']");
	public static By resultsTitle = By.xpath("//h2[@class='productitem--title']");
	public static By quickShop = By.xpath("//button[contains(text(),'Quick shop')]");
	public static By addToCartPage = By.xpath("//div[@class='modal-inner']//article[@class='product--outer']");

}
