package playwrightdemo1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class playwritefirstcode {

	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://omayo.blogspot.com/2013/05/page-one.html");
		String title=page.title();
		System.out.println(title);
		//browser.close();
		//playwright.close();
		/*import com.microsoft.playwright.*;
		import com.microsoft.playwright.options.*;
		import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
		import java.util.*;

		public class Example {
		  public static void main(String[] args) {
		    try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
		        .setHeadless(false));
		      BrowserContext context = browser.newContext();
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Blogs").setExact(true)).click();
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("SeleniumByArun")).click();
		    }
		  }
		}

	}*/
	}
}
