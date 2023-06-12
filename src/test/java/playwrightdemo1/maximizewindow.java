package playwrightdemo1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class maximizewindow {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		  Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		   BrowserContext browsercontext= browser.newContext(new Browser.NewContextOptions().setViewportSize(1500, 768));
		   Page page=browsercontext.newPage();
		   page.navigate("https://www.amazon.com/");

	}

}
