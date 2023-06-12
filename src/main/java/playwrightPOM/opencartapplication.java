package playwrightPOM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class opencartapplication  {
	Playwright playwright;
	Browser browser;
	BrowserContext brcontext;
	Page page;
	 Properties prop;
	
public Page initbrowser(Properties prop) {
	String browsername=prop.getProperty("browser");
	System.out.println("browser name is :"+ browsername);
	 playwright= Playwright.create();
	 
	  switch(browsername.toLowerCase()) {
	  case "chromium":
	 browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	  break;
	  case "firefox":
		  browser=  playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		  break;
	  case "chrome":
		  browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		  break;
	    default:
	    	System.out.println("invalid");
	    	break; 
	  }
	  brcontext=browser.newContext();
	  page=brcontext.newPage();
	  page.navigate(prop.getProperty("url"));
	  return page;
	
}
public Properties ini_prpo() {
	try {
		FileInputStream ip=new FileInputStream("C:\\Users\\lenovo R3\\eclipse-workspace new\\playwrightdemo\\src\\test\\resources\\config\\config.properties");
       prop=new Properties();
       try {
		prop.load(ip);
	} catch (IOException e) {
		e.printStackTrace();
	}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	return prop;
}
}
