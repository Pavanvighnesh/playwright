package playwrightdemo1;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class selectingallcheckboxes {

	public static void main(String[] args) {
		 Playwright playwright = Playwright.create();
		  Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		  
		   BrowserContext browsercontext= browser.newContext();
		   Page page=browsercontext.newPage();
		   page.navigate("https://selectorshub.com/xpath-practice-page/");
		   //page.pause();
		  // page.locator("//span[@id='nav-link-accountList-nav-line-1']").click();
		Locator checkboxs = page.locator("//table[@id=\"resultTable\"]//input[@type=\"checkbox\"]");
		           
		        for(int i=0;i<=checkboxs.count();i++) {
		        	checkboxs.nth(i).click();
		        }
		       
                          
	}

}
