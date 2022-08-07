package com.shop.apotheke.ui.tests;

import com.shop.apotheke.ui.pages.LoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        loginPage.login("standard_user", "secret_sauce");
//        assertTrue(new ProductsPage(driver).isLoaded());
    }

    @Test
    @DisplayName("01.2 Login user with invalid credentials")
    public void loginWithInvalidCredentials() {
        LoginPage loginPage = goToLoginPage();
        loginPage.login("hue@someuser.com", "huehue");
        assertTrue(new LoginPage(driver).getErrorNotification(), "Error notification was not displayed");
    }

    private LoginPage goToLoginPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        return loginPage;
    }
}
