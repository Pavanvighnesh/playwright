package basenew;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;

import playwrightPOM.opencartapplication;
import playwrightpages.homepage;

public class basetest {
	opencartapplication app;
	Page page;
	protected homepage hmpage;
	protected Properties prop;

	@BeforeTest
	public void setup() {
		app = new opencartapplication();
		prop=app.ini_prpo();
		page = app.initbrowser(prop);
		hmpage = new homepage(page);
		
	}
	@AfterTest
	public void teardown() {
		page.context().browser().close();
	}
}
