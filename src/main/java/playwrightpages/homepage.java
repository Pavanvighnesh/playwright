package playwrightpages;

import com.microsoft.playwright.Page;

public class homepage {
	Page page;
	private String search="//input[@name=\"search\"]";
    private String searchbutton="span button[type='button']";
    private String searchitem="//h1[text()=\"Search - iphone\"]";
    

    public homepage(Page page) {
    	this.page=page;
     }
       
     public String gethomepagetitle() {
    	String title = page.title();
    	System.out.println("page title is:"+ title);
		return title;
	
    	 
     }
     public String gethomepageurl() {
    	String url= page.url();
    	System.out.println("page url is"+url);
    	return url;
    	
     }
     public String dosearch(String productname) {
    	 page.fill(search, productname);
    	 page.click(searchbutton);
    	String header = page.textContent(searchitem);
    	System.out.println(header);
    	return header;
     }
     
     }