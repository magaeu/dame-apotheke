package com.shop.apotheke.ui.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import setup.BrowserType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class WebDriverFactory {

    private static final Map<BrowserType, Supplier<WebDriver>> driverMap = new HashMap<>();
    private static final Supplier<WebDriver> chromeDriverSupplier = () -> {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    };

    private static final Supplier<WebDriver> chromeDriverHeadlessSupplier = () -> {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--start-maximized");
        return new ChromeDriver(chromeOptions);
    };

    private static final Supplier<WebDriver> firefoxDriverSupplier = () -> {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    };

    static {
        driverMap.put(BrowserType.CHROME, chromeDriverSupplier);
        driverMap.put(BrowserType.FIREFOX, firefoxDriverSupplier);
        driverMap.put(BrowserType.CHROME_HEADLESS, chromeDriverHeadlessSupplier);
    }

    public static WebDriver getDriver(BrowserType type){
        return driverMap.get(type).get();
    }
}
