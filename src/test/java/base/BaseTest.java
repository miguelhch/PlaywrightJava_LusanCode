package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ExtentManager;

import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeMethod
    public void setUp(Method method) {

        extent = ExtentManager.getInstance();
        test = extent.createTest(method.getName());
        // Common setup code for tests can be placed here
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
        page = browser.newPage();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        // Common teardown code for tests can be placed here
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail("Test failed: " + result.getThrowable());
            String screenshotPath = utils.ScreenshotUtil.takeScreenshot(page, result.getName());
            System.out.println("Screenshot path: " + screenshotPath);

            try {
                byte[] imageBytes = Files.readAllBytes(Paths.get(screenshotPath));
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                test.addScreenCaptureFromBase64String(base64Image, "screenshot");
            } catch (Exception e) {
                System.err.println("Failed to attach screenshot: " + e.getMessage());
            }

        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test passed");
        } else {
            test.skip("Test skipped");
        }

        extent.flush();

        if(browser != null) {
            browser.close();
        }
        if(playwright != null) {
            playwright.close();
        }
    }
}
