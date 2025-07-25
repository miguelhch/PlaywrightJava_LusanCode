package pages;

import com.microsoft.playwright.Page;

public class HomePage {

    private final Page page;
    private final String timeLink = "getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(\"Time\"))";

    public HomePage(Page page) {
        this.page = page;
    }

    public void clickTimeLink() {
        page.getByRole(com.microsoft.playwright.options.AriaRole.LINK, new Page.GetByRoleOptions().setName("Time")).click();
        //page.click(timeLink);
    }
}
