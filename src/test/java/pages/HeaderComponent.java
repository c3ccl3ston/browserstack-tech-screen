package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderComponent extends BasePage {

    // Locators
    protected final By inviteTeamLinkLocator = By.id("invite-link");
    protected final By signInLinkLocator = By.className("sign-in-link");
    protected final By accountMenuLocator = By.id("account-menu-toggle");
    protected final By signOutLinkLocator = By.id("sign_out_link");

    // Mobile specific locators
    protected final By hamburgerMenuLocator = By.id("primary-menu-toggle");
    protected final By mobileSignInLinkLocator = By.cssSelector("li.hide-md a[href='/users/sign_in']");
    protected final By mobileSignOutLinkLocator = By.cssSelector("li.hide-md a.sign_out_link");

    public HeaderComponent(RemoteWebDriver driver) {
        super(driver);
    }

    public WebElement getInviteTeamLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((driver) -> driver.findElement(inviteTeamLinkLocator));
        return driver.findElement(inviteTeamLinkLocator);
    }

    public void navigateToSignIn() {
        try {
            driver.findElement(signInLinkLocator).click();
        } catch (ElementNotInteractableException e) {
            driver.findElement(hamburgerMenuLocator).click();
            driver.findElement(mobileSignInLinkLocator).click();
        }
    }

    public void signOut() {
        try {
            driver.findElement(accountMenuLocator).click();
            driver.findElement(signOutLinkLocator).click();
        } catch (ElementNotInteractableException e) {
            driver.findElement(hamburgerMenuLocator).click();
            driver.findElement(mobileSignOutLinkLocator).click();
        }
    }
}
