package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Map;

/**
 * All page objects inherit from the base page.
 */
public abstract class BasePage {
    protected final RemoteWebDriver driver;

    public RemoteWebDriver getDriver() {
        return this.driver;
    }

    public BasePage(RemoteWebDriver driver) {
        this.driver = driver;
    }
}