package tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HeaderComponent;
import pages.Homepage;
import pages.SignInPage;
import runners.BrowserStackRunner;

public class TechScreenTests extends BrowserStackRunner {

    @Test
    void techScreenTest() {
        driver.navigate().to("https://www.browserstack.com");

        Homepage homepage = new Homepage(driver);
        homepage.acceptCookies();

        HeaderComponent header = new HeaderComponent(driver);
        header.navigateToSignIn();

        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(System.getenv("TEST_USERNAME"), System.getenv("TEST_PASSWORD"));

        // Assert that the homepage includes a link to Invite Users and retrieve the link’s URL
        WebElement inviteTeamLink = header.getInviteTeamLink();
        Assert.assertTrue(inviteTeamLink.getTagName().equals("a"));
        annotate("Invite Users HREF: " + inviteTeamLink.getAttribute("href"), "info", driver);

        header.signOut();
    }

    public void annotate(String data, String level, WebDriver driver) {
        final JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("browserstack_executor: {\"action\": \"annotate\", \"arguments\": {\"data\": \"" + data + "\", \"level\": \"" + level + "\"}}");
    }
}