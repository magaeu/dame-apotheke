package com.shop.apotheke.ui.pages;

import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    private final String REDIRECT_AFTER_REGISTER_URL = "/nx/account/?after=registration#register";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        return wait.urlToBe(BASE_SHOP_APOTHEKE_URL + REDIRECT_AFTER_REGISTER_URL);
    }
}
