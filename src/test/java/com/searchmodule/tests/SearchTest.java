package com.searchmodule.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.searchmodule.pages.SearchPage;

import tests.BaseTest;

public class SearchTest extends BaseTest {

	
	@Test(priority =1)
	@Parameters ({"keyword"})
	public void TC01_SearchText(String keyword) throws InterruptedException
	{
		SearchPage sp = new SearchPage(driver);
		sp.gotoduckduckgo();
		sp.Search(keyword);
		//sp.click_video();
		//sp.get_videoslist();		
	}
	
	
	
}
