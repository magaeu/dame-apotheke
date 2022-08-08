package com.shop.apotheke.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.shop.apotheke.ui.constants.Locators.*;
import static com.shop.apotheke.ui.constants.Messages.LOGIN_PAGE_ERROR;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage extends BasePage {

    private static final String PAGE_TITLE = "Anmelden";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void goToLoginPage() {
        driver.navigate().to(BASE_SHOP_APOTHEKE_URL + "/nx/login");
        assertTrue(driver.getTitle().contains(PAGE_TITLE),
                LOGIN_PAGE_ERROR);
        wait.presenceOfElement(BIN_EIN_MENSCH);
    }

    public void login(String userName, String password) {
        getUserNameField().sendKeys(userName);
        getPasswordField().sendKeys(password);
        getSubmitButton().submit();
    }

    private WebElement getUserNameField() {
        return driver.findElement(By.id(USERNAME_FIELD));
    }

    private WebElement getPasswordField() {
        return driver.findElement(By.id(PASSWORD_FIELD));
    }

    private WebElement getSubmitButton() {
        return driver.findElement(By.id(LOGIN_BUTTON));
    }

    public boolean getErrorNotification() {
        return wait.presenceOfElement(ERROR_NOTIFICATION);
    }
}
