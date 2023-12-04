package id.co;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.util.List;


public class pkp {
    @Test
    @DisplayName("Test Web PKP")
    public void test1() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch();
        Page page = browser.newPage();
        page.navigate("http://www.programsbuzz.com/user/login");
        System.out.println(page.title());
    }

    @Test
    @DisplayName("Check url")
    public void teshttps() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("http://10.8.11.1:8761/");
        String currentUrl = page.url();
        String expectedUrl = "http://10.8.11.1:8761/";
        if (currentUrl.equals(expectedUrl)) {
            System.out.println("URL is correct: " + currentUrl);
        } else {
            System.out.println("URL is incorrect. Expected: " + expectedUrl + ", but got: " + currentUrl);
        }
        // System.out.println(currentUrl);
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("CheckPlaceHolder")
    public void CheckPlaceHolder() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.programsbuzz.com/user/login");

        Locator searchBar = page.locator("#edit-keys");
        String placeText = searchBar.getAttribute("placeholder");

        if (placeText.contains("Enter the terms you wish to search for")) {

            System.out.println("PASS");

        } else {
            System.out.println("FAIL! No such texts");
        }
    }

    @Test
    @DisplayName("Checkbox")
    public void assertCheckBox() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("http://autopract.com/selenium/dropdown1/");
        Locator locator = page.locator("select.custom-select option >> nth=-2");
        String attributeV = locator.getAttribute("value");

        if (attributeV.equals("item3")) {
            System.out.println("Attribute value is correct!");
        } else {
            System.out.println("Attribute value is incorrect.");
        }
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Tooltip Chack Test")
    public void TooltipCheckTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://jqueryui.com/tooltip/");
        FrameLocator frameOne = page.frameLocator(".demo-frame");
        Locator ageBox = frameOne.locator("#age");
        Locator toolTipText = frameOne.locator(".ui-tooltip-content");
        ageBox.hover();
        String textContent = toolTipText.textContent();
        System.out.println(textContent);
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Soft Assertion")
    public void SoftAssectionTest() {
        Playwright playwright = Playwright.create();
        BrowserContext browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newContext();
        Page page = browser.newPage();
        page.navigate("https://www.programsbuzz.com/user/login");
        page.locator("#edit-name").type("yuji");
        page.locator("#edit-pass").type("yuji");
        page.locator("(//input[@type='submit'])[2]").click();
        String actualText = page.locator("//a[normalize-space()='Forgot your password?']").textContent();
        System.out.println(actualText);
        String expectedText = "Forgot your password?";
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(actualText, expectedText, "Matched");

        System.out.println("This part is executed");
        soft.assertAll();
        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("AssertTitleTest")
    public void AsserTitleTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("http://www.programsbuzz.com");
        String title = page.title();
        String expectedTitle = "ProgramsBuzz - Online Technical Courses";
        if (title.equalsIgnoreCase(expectedTitle)) {
            System.out.println("Title Match Verfied");
        } else {
            System.out.println("Not a match!!");
        }
        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("AssertTextOnWebPageTest")
    public void AssertTextOnWebPageTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("http://www.programsbuzz.com");
        Locator body = page.locator("body");
        String bodyText = body.textContent();
        Assert.assertFalse(bodyText.contains("Spam Message"), "Spam Text Not Found!!");

        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Get Current URL Java")
    public void getCurrentURLJava() {
        Playwright playwright = Playwright.create();
        BrowserContext browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newContext();
        Page page = browser.newPage();
        page.navigate("http://www.programsbuzz.com/user/login");
        page.locator("#edit-name").type("Naruto");
        page.locator("#edit-pass").type("uzumaki");

        String currentUrl = page.url();
        System.out.println(currentUrl);

        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Click Browser Back and Forward Button")
    public void ClickBrowserBackandForwardButton() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.programsbuzz.com");
        page.locator("#edit-submit--3").click();
        page.locator("//input[@id='edit-keys']").type("Playwright");
        page.locator("//input[@id='edit-submit']").click();
        page.goBack();
        page.goForward();
        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Navigate to URL")
    public void NavigatetoURLTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("http://autopract.com/selenium/upload1/");
        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Refresh Page")
    public void RefreshPage() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("http://autopract.com/selenium/popup/");
        page.reload();
        page.locator("//a[normalize-space()='JQuery Popup Model']").click();
        String textContent = page.locator("//p[normalize-space()='This is Sample Popup.']").textContent();
        System.out.println(textContent);
        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Maximize Browser")
    public void MaximizeBrowser() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        browser.newContext(new Browser.NewContextOptions().setViewportSize(1800, 880));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
//        int width = (int) screenSize.getWidth();
//        int height = (int) screenSize.getHeight();
//        BrowserContext newContext = browser.newContext(new  Browser.NewContextOptions().setViewportSize(width2, height2));
//        Page page = newContext.newPage();
        Page page = browser.newPage();
        page.navigate("https://www.google.co.id");
        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Get First and Last Element in Playwright Java")
    public void getFirstAndLastElementTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        //Find the first element using first method
        page.navigate("https://www.programsbuzz.com/search/node?keys=playwright+java");
        Locator listEle = page.locator("//h3[@class='search-result__title']");
        listEle.first().click();

        //Find the first element using nth method
        page.navigate("https://www.programsbuzz.com/search/node?keys=playwright+java");
        Locator listEle2 = page.locator("//h3[@class='search-result__title']");
        listEle2.nth(0).click();

        //Find the last element using first method
        page.navigate("https://www.programsbuzz.com/search/node?keys=playwright+java");
        Locator listEle3 = page.locator("//h3[@class='search-result__title']");
        listEle3.last().click();

        //Find the last element using nth method
        page.navigate("https://www.programsbuzz.com/search/node?keys=playwright+java");
        Locator listEle4 = page.locator("//h3[@class='search-result__title']");
        listEle4.nth(-1).click();

        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Get List of Elements")
    public void getListofElements() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://www.programsbuzz.com/search/node?keys=playwright+java");
        Locator listEle = page.locator("//h3[@class='search-result__title']");
        int count = listEle.count();
        Assert.assertEquals(count, 10);

        // Nth content filter
        page.navigate("https://www.programsbuzz.com/search/node?keys=playwright+java");
        String textContent = listEle.nth(1).textContent();
        System.out.println(textContent);

        //Display a list of texts
        page.navigate("https://www.programsbuzz.com/search/node?keys=playwright+java");
        List<String> allTextContents = listEle.allTextContents();
        System.out.println(allTextContents);
        allTextContents.forEach(System.out::println);

        for (int i = 0; i < allTextContents.size(); i++) {
            System.out.println(i + 1 + "." + allTextContents.get(i));
        }

        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("XPath Selector")
    public void XPathSelector() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://www.programsbuzz.com/user/login");
        page.locator("//input[@id= 'edit-name']").type("Naruto");
        page.locator("//input[@id= 'edit-pass']").type("Sasskeh");
        page.locator("//input[@id= 'edit-submit']").click();

        page.navigate("https://www.programsbuzz.com");
        String textContent = page.locator("div.container-fluid ul li >> nth=6").textContent();
        System.out.println(textContent);

        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Handle Dropdown")
    public void HandleDropdown() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("http://autopract.com/selenium/dropdown1/");
        page.selectOption(".custom-select", "item2");

        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Dynamic Dropdown")
    public void DynamicDorpdown() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("http://autopract.com/selenium/dropdown4/");
        page.locator("//span[@class='caret']").click();
        Locator countries = page.locator("//div[@role='combobox']");
        List<String> allInnerTexts = countries.allInnerTexts();

        allInnerTexts.forEach(System.out::println);

        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Handle Autocomplete")
    public void HandleAutocomplete() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        String expectedText = "Indonesia";
        page.navigate("https://demo.automationtesting.in/AutoComplete.html");
        Locator autoC = page
                .locator("//div[@class='ui-autocomplete-multiselect ui-state-default ui-widget ui-state-active']");
        int autoCcount = autoC.count();
        System.out.println("autoCcount:" + autoCcount);

        page.pause();

        for (int i = 0; i < autoCcount; i++) {
            String autoCText = autoC.nth(i).textContent();
            if (autoCText == expectedText) {
                autoC.nth(i).click();
                break;
            }
        }
        page.close();
        browser.close();
        playwright.close();
    }
}
