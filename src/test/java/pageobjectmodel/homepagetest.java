package pageobjectmodel;

import org.testng.Assert;
import org.testng.annotations.Test;

import basenew.basetest;

public class homepagetest extends basetest {

	@Test
	public void homepagetitletest() {
		String acttitle = hmpage.gethomepagetitle();
		Assert.assertEquals(acttitle, "Your Store");
		

	}
	@Test
	public void homepageurl() {
		String url = hmpage.gethomepageurl();
		Assert.assertEquals(url,prop.getProperty("url"));
		
	}
	@Test
	public void searchtest() {
		String actualheader = hmpage.dosearch("iphone");
		Assert.assertEquals(actualheader, "Search - iphone");
	}
	

	

	}

