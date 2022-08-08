package com.shop.apotheke.ui.tests;

import com.shop.apotheke.ui.pages.LoginPage;
import com.shop.apotheke.ui.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.shop.apotheke.ui.constants.Messages.ERROR_NOTIFICATION_NOT_DISPLAYED;
import static com.shop.apotheke.ui.constants.Messages.MAIN_PAGE_NOT_DISPLAYED;
import static com.shop.apotheke.ui.constants.UserInputs.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageTest extends BaseTest {

    @Test
    @DisplayName("01. Open page")
    public void openPageTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
    }

    @Test
    @DisplayName("01.1 Login user with valid credentials")
    public void loginWithValidCredentials() {
        LoginPage loginPage = goToLoginPage();
        loginPage.login(VALID_USER_EMAIL, VALID_USER_PASSWORD);
        assertTrue(new MainPage(driver).isLoaded(), MAIN_PAGE_NOT_DISPLAYED);
    }

    @Test
    @DisplayName("01.2 Login user with invalid credentials")
    public void loginWithInvalidCredentials() {
        LoginPage loginPage = goToLoginPage();
        loginPage.login(INVALID_USER_EMAIL, INVALID_USER_PASSWORD);
        assertTrue(new LoginPage(driver).getErrorNotification(), ERROR_NOTIFICATION_NOT_DISPLAYED);
    }

    private LoginPage goToLoginPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        return loginPage;
    }
}
