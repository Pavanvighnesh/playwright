package playwrightdemo1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class browsercontext {

	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		      BrowserContext brc1 = browser.newContext();
		    Page page1=  brc1.newPage();
		    page1.navigate("https://www.amazon.com/");
		     System.out.println(page1.title());
		      
		     BrowserContext brc2 = browser.newContext();
		       Page page2 =brc2.newPage();
		       page2.navigate("https://omayo.blogspot.com/2013/05/page-one.html");
		       System.out.println(page2.title());
		     //  page2.navigate("https://www.amazon.com/");
		       
		       brc1.close();
		       page1.close();
		              
		       brc2.close();
		       page2.close();
	}

}
