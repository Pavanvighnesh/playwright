package playwrightdemo1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class handleframes {

	public static void main(String[] args) {
	   Playwright playwright = Playwright.create();
	  Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	   BrowserContext browsercontext= browser.newContext();
	   Page page=browsercontext.newPage();
	   page.navigate("https://www.globalsqa.com/demo-site/frames-and-windows/#Open%20New%20Tab");
	   page.locator("text=IFRAME").first().click();
	   page.frame("globalSqa").locator("//img[@alt='Manual Online Testing Training']").click();
	
	}

}
