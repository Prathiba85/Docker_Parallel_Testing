package coms.newtours.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	//WebElement
	
	@FindBy(xpath ="//select[@name='passCount']")private WebElement Passangers;
	@FindBy(xpath ="//input[@name='findFlights']")private WebElement submitbtn;
	
	
	public FlightDetailsPage (WebDriver driver )
	{
		this.driver = driver;
		this.wait=new WebDriverWait(driver, 30);
		PageFactory.initElements(driver,this);
	}
	
	public void selectPassengers(String noOfPasangers)
	{
		this.wait.until(ExpectedConditions.elementToBeClickable(Passangers));
		Select select = new Select(Passangers);
		select.selectByValue(noOfPasangers);
	}
	
	public void gotofindflightspage()
	{
		JavascriptExecutor js =(JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();",submitbtn);
				
		//this.submitbtn.click();
		//submitbtn.click();
	}
}
