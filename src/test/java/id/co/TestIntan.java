package id.co;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestIntan {
    @Test
    @DisplayName("Test Login Positve Test")
    public void LoginPositiveTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://practicetestautomation.com/practice-test-login/");
        page.locator("#username").type("student");
        page.locator("#password").type("Password123");
        page.locator("#submit").click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions()
                .setName("submit")).last().click();

        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Test Login Negative Username")
    public void LoginNegativeUsernameTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://practicetestautomation.com/practice-test-login/");
        page.locator("#username").type("incorrectUser");
        page.locator("#password").type("Password123");
        page.locator("#submit").click();

        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Test Login Negative Password")
    public void LoginNegativePasswordTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://practicetestautomation.com/practice-test-login/");
        page.locator("#username").type("student");
        page.locator("#password").type("incorrectPassword");
        page.locator("#submit").click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions()
                .setName("submit")).last().click();
        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Test Add Row")
    public void AddRowTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://practicetestautomation.com/practice-test-exceptions/");
        page.locator("#add_btn").click();
        page.close();
        browser.close();
        playwright.close();
    }

}
