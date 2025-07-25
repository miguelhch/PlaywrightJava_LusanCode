package utils;

import com.microsoft.playwright.Page;

import java.nio.file.Paths;

public class ScreenshotUtil {

    public static String takeScreenshot(Page page, String testName) {

        String timestamp = String.valueOf(System.currentTimeMillis());
        String screenshotPath = "test-output/screenshots/" + testName + "_" + timestamp + ".jpg";

        try {
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(screenshotPath)).setFullPage(false));
            System.out.println("Screenshot taken: " + screenshotPath);
        } catch (Exception e) {
            System.err.println("Failed to take screenshot: " + e.getMessage());
        }
        return screenshotPath;
    }
}
