package coms.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationConfirmationPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	//webElement
	
	@FindBy(xpath ="//a[text()=' sign-in ']")private WebElement signin;
	@FindBy(xpath ="//a[text()='Flights']")private WebElement flights_link;
	
	
	public RegistrationConfirmationPage (WebDriver driver )
	{
		this.driver = driver;
		
		this.wait=new WebDriverWait(driver, 30);
		PageFactory.initElements(driver,this);
	}
	
	public void gotoFlights()
	{
		wait.until(ExpectedConditions.visibilityOf(this.signin));
		this.flights_link.click();
	}
}
