package com.mindtree.uistore;

import org.openqa.selenium.By;

public class BooksDropDownUi {
	public static By allBooks = By.cssSelector("li.navmenu-item.navmenu-item-parent.navmenu-id-books");
	public static By dropDowns = By.cssSelector(
			"li.navmenu-item.navmenu-item-parent.navmenu-id-books ul.navmenu.navmenu-depth-2.navmenu-submenu a");
	public static By NCERTClassses = By.xpath("//li[@class='filter-item']");
	public static By author = By.xpath("//ul[@data-filter-group='Author'] //span[@class='filter-text']");
	public static By language = By.xpath("//ul[@data-filter-group='Language'] //span[@class='filter-text']");
	public static By seeMore = By.xpath("//ul[@data-filter-group='Author']//li  //a[contains(text(),'See more')]");
	public static By searchBooks = By.xpath("//li//h2[@class='productitem--title']");

}
