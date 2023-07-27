package com.searchmodule.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	//webElement
	
	@FindBy(xpath ="//input[@aria-label='Search with DuckDuckGo']")private WebElement txt_search;
	@FindBy(xpath ="//a[text()='Videos']")private WebElement videos;
	@FindBy(xpath ="//img[@class='tile__media__img  js-lazyload']")private List <WebElement> videos_list;
	@FindBy(xpath ="//input[@id='search_button']")private WebElement btn_search;
	
	
	public SearchPage (WebDriver driver )
	{
		this.driver = driver;
		
		this.wait=new WebDriverWait(driver, 30);
		PageFactory.initElements(driver,this);
	}
	
	public void gotoduckduckgo()
	{
		this.driver.get("https://duckduckgo.com/");
	}
	
	public void Search (String Keyword) throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(this.txt_search));
		this.txt_search.sendKeys(Keyword);
		//wait.until(ExpectedConditions.visibilityOf(this.btn_search));
		//Thread.sleep(2000);
		//JavascriptExecutor js =(JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();",this.btn_search);
		
		/*
		//this.btn_search.click();
		
		Actions keyboard = new Actions(driver);
		
		keyboard.keyDown(this.txt_search,Keys.ENTER);*/
		
	}
	/*
	public void click_video ()
	{
		wait.until(ExpectedConditions.visibilityOf(this.videos));
		this.videos.click();
	}
	
	public void get_videoslist ()
	{
		By by = By.className("title-vid");
		wait.until(ExpectedConditions.numberOfElementsToBe(by, 10));
		System.out.println(this.videos_list.size());
	}*/
}
