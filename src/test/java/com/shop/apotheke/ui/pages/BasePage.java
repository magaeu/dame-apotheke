package com.shop.apotheke.ui.pages;

import org.openqa.selenium.WebDriver;
import setup.Waiter;

public class BasePage {

    protected WebDriver driver;
    protected Waiter wait;

    protected static final String BASE_SHOP_APOTHEKE_URL = "https://www.shop-apotheke.com";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new Waiter(driver);
    }
}
