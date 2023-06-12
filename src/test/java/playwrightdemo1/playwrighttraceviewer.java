package playwrightdemo1;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.nio.file.Paths;
import java.util.*;

public class playwrighttraceviewer {
  public static void main(String[] args) {
    Playwright playwright = Playwright.create();
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      context.tracing().start(new Tracing.StartOptions()
    		  .setScreenshots(true)
    		  .setSnapshots(true)
               .setSources(true));
      Page page=  browser.newPage();
      page.navigate("https://www.amazon.com/");
      //BrowserContext context = browser.newContext();
      page.getByPlaceholder("Search Amazon").click();
      page.getByPlaceholder("Search Amazon").fill("oneplus");
      page.getByPlaceholder("Search Amazon").press("Enter");
      page.navigate("https://www.amazon.com/OnePlus-Dual-SIM-Smartphone-Hasselblad-Processor/dp/B0BNWPSCGB/ref=sr_1_2_sspa?crid=42VBJGGMEP6F&keywords=oneplus&qid=1684134411&sprefix=oneplus%2Caps%2C562&sr=8-2-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUEzSVJQUDU4NFJLQlE4JmVuY3J5cHRlZElkPUEwNTUxMTI1MTU2M0JRTU9IMTA2WSZlbmNyeXB0ZWRBZElkPUEwODc2NjcwMjhJMzVWRjdTOUJOTiZ3aWRnZXROYW1lPXNwX2F0ZiZhY3Rpb249Y2xpY2tSZWRpcmVjdCZkb05vdExvZ0NsaWNrPXRydWU=");
      page.getByTitle("Add to Shopping Cart").click();
      page.locator("#sw-gtc").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Go to Cart")).click();
      context.tracing().stop(new Tracing.StopOptions()
    		  .setPath(Paths.get("trace.zip")));
    }
  }
