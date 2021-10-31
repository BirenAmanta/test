package com.mindtree.uistore;

import org.openqa.selenium.By;

public class CartPageUi {
	public static By quantity = By.xpath("//*[@id='product-quantity-select']");
	public static By addToCartButton = By.cssSelector("button.cbb-frequently-bought-add-button");
}
