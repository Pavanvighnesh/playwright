package playwrightdemo1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class handlingalerts {

	public static void main(String[] args) {
		Playwright playwright= Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		   BrowserContext brcontext=browser.newContext();
		   Page page=brcontext.newPage();
		   page.onDialog(dialog ->{
			   String output = dialog.message();
			   System.out.println(output);
			   dialog.accept("vighnesh");
			 //  dialog.accept();   
		                          });
		   page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
		   page.waitForTimeout(3000);
		 //  page.locator("//button[text()='Click for JS Alert']").click();
		     // String text = page.textContent("#result");
		   //   System.out.println(text);
		  // page.locator("//button[text()='Click for JS Confirm']").click();
		   page.locator("//button[text()='Click for JS Prompt']").click();
		

	}

}
