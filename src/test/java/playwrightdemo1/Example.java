package playwrightdemo1;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page=browser.newPage();
		page.navigate("https://omayo.blogspot.com/2013/05/page-one.html");
     
     // Page.locator("#HTML2").getByRole(AriaRole.TEXTBOX).click();
      //Page.locator("#HTML2").getByRole(AriaRole.TEXTBOX).fill("");
      page.locator("#HTML2").getByRole(AriaRole.TEXTBOX).press("Enter");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Button2")).click();
     
      page.locator("#HTML31 input[type=\"text\"]").click();
      page.locator("#HTML31 input[type=\"text\"]").fill("PAVAN");
      page.pause();
      page.locator("#HTML31 input[type=\"password\"]").click();
      page.locator("#HTML31 input[type=\"password\"]").fill("KUMAR");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
      Page page1 = page.waitForPopup(() -> {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Open a popup window")).click();
      });
    }
  }
}