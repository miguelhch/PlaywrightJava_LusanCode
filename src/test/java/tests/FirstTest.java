package tests;

import base.BaseTest;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test
    public void verifyTitle(){
        page.navigate("https://google.com/ncr");
        if (page.isVisible("button:has-text('Accept all')")) {
            page.click("button:has-text('Accept all')");
        }
        System.out.println("Title: " + page.title());
    }

    /*public static void main(String[] args) {

        try(Playwright playwright = Playwright.create()) {
            // Launch the browser
            Browser browser = playwright.chromium().launch(new com.microsoft.playwright.BrowserType.LaunchOptions()
                    .setHeadless(false)
                    .setSlowMo(1000));

            // Create a new page
            Page page = browser.newPage();

            // Navigate to a URL
            page.navigate("https://google.com");

            // Perform actions on the page
            System.out.println("Title: " + page.title());

            // Close the browser
            browser.close();
        }
    }*/
}
