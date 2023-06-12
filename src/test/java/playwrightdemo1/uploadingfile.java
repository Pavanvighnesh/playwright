package playwrightdemo1;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class uploadingfile {

	public static void main(String[] args) {
		Playwright playwright= Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		 BrowserContext brcontext = browser.newContext();
		 Page page=brcontext.newPage();
		 page.navigate("https://omayo.blogspot.com/2013/05/page-one.html");
		 page.check("#radio2");
		 page.uncheck("#checkbox1");
		// page.setInputFiles("#uploadfile",Paths.get("applogin.json"));
		// page.waitForTimeout(3000);
		// page.setInputFiles("#uploadfile", new Path[0]);
		

	}

}
