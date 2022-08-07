package com.shop.apotheke.ui.tests;

import com.shop.apotheke.ui.setup.WebDriverFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import setup.BrowserType;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = WebDriverFactory.getDriver(BrowserType.CHROME);
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void tearDown() {
        if (driver == null) {
            return;
        }
        driver.close();
        driver.quit();
    }
}
