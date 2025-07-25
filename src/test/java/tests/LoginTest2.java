package tests;

import base.BaseTest;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest2 extends BaseTest {

    @Test
    public void loginTest1() {

        LoginPage  loginPage = new LoginPage(page);
        HomePage  homePage = new HomePage(page);

        test.info("Navigating to the login page");
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        test.info("Entering username and password");
        loginPage.addUsername("Admin");
        loginPage.addPassword("admin1234");
        test.info("Clicking the login button");
        loginPage.clickLoginButton();
        test.info("Clicking the Time link");
        homePage.clickTimeLink();
        test.info("All steps completed successfully");

    }

    @Test
    public void loginTest2() {

        test.skip("This test is skipped intentionally");

        throw new SkipException("Skipping this test intentionally");


    }

    @Test
    public void loginTest3() {

        LoginPage  loginPage = new LoginPage(page);
        HomePage  homePage = new HomePage(page);

        test.info("Navigating to the login page");
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        test.info("Entering username and password");
        loginPage.addUsername("Admin");
        loginPage.addPassword("admin123");
        test.info("Clicking the login button");
        loginPage.clickLoginButton();
        test.info("Clicking the Time link");
        //homePage.clickTimeLink();


    }
}
