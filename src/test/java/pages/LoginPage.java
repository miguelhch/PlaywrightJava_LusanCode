package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage {

    private Page page;

    private final String useranmeTextbox = "getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(\"Username\"))";
    private final String passwordTextbox = "getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(\"Password\"))";
    private final String loginButton = "getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(\"Login\"))";

    public LoginPage(Page page){
        this.page = page;
    }

    public void addUsername(String username) {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).fill(username);
        //page.fill(useranmeTextbox, username);
    }

    public void addPassword(String password) {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill(password);
        //page.fill(passwordTextbox, password);
    }

    public void clickLoginButton() {
        page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
        //page.click(loginButton);
    }

    public void login(String username, String password) {
        addUsername(username);
        addPassword(password);
        clickLoginButton();
    }
}
