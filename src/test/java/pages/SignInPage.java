package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage extends BasePage {

    private final By usernameFieldLocator = By.id("user_email_login");
    private final By passwordFieldLocator = By.id("user_password");
    private final By signInButtonLocator = By.id("user_submit");

    public SignInPage(RemoteWebDriver driver) {
        super(driver);
    }

    public void signIn(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until((driver) -> driver.findElement(usernameFieldLocator).isDisplayed());

        WebElement userNameField = driver.findElement(usernameFieldLocator);
        WebElement passwordField = driver.findElement(passwordFieldLocator);
        WebElement signInButton = driver.findElement(signInButtonLocator);

        userNameField.sendKeys(username);
        passwordField.sendKeys(password);
        signInButton.click();
    }
}
