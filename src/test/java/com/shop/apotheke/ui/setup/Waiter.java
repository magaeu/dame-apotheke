package setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {

    private static final Duration TIMEOUT = Duration.ofSeconds(10);
    private static final Duration POLLING = Duration.ofSeconds(100);

    private final WebDriverWait wait;

    public Waiter(WebDriver driver) {
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
    }

    public boolean presenceOfElement(String locator) {
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator))).isDisplayed();
    }

    public boolean urlToBe(String expectedUrl) {
        return wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }
}
