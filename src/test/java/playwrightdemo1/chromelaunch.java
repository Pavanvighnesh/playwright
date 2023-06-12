package playwrightdemo1;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class chromelaunch {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright=Playwright.create();
		LaunchOptions lp= new LaunchOptions();
		   lp.setChannel("chrome");
		   lp.setHeadless(false);
		Browser browser= playwright.chromium().launch(lp);
		Page page=browser.newPage();
		
		page.navigate("https://www.netflix.com/in/");
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots.png")).setFullPage(true));
		//page.locator("a:text(\"Sign In\")").click();
		page.locator("a:text(\"Sign In\")").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("screenshots2.png")));
		
		//String title=page.title();
		//System.out.println(title);
		//browser.close();
		//playwright.close();

	}

}
