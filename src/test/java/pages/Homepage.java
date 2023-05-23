package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Homepage extends BasePage {

    private final By cookieNotificationAcceptLocator = By.id("accept-cookie-notification");

    public Homepage(RemoteWebDriver driver) {
        super(driver);
    }

    public void acceptCookies() {
        driver.findElement(cookieNotificationAcceptLocator).click();
    }
}
