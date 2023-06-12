package playwrightdemo1;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class automaticloginrec {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		  Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
          
		  BrowserContext browsercontext= browser.newContext(new Browser.NewContextOptions()
				  .setRecordVideoDir(Paths.get("myvideos/"))
				 .setRecordVideoSize(700, 800));
		   Page page=browsercontext.newPage();
		   browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("applogin.json")));

		 page.navigate("https://tutorialsninja.com/demo/");
		 page.waitForTimeout(2000);
		   page.locator("//span[text()='My Account']").click();
		   page.waitForTimeout(2000);
		   page.click("a:text('Login')");
		   page.waitForTimeout(2000);
		  // page.locator("//a[text()='Login']").click();
		  page.locator("#input-email").fill("vignesh.kumar@rogvic.com");
		  page.waitForTimeout(2000);
		   //page.fill("#input-email","vignesh.kumar@rogvic.com" );
		  page.locator("#input-password").fill("qwerty12345");
		  page.waitForTimeout(2000);
		   page.locator("//input[@value='Login']").click();
		   browsercontext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("applogin.json")));
     browsercontext.close();
     page.close();
     playwright.close();
	}

}
