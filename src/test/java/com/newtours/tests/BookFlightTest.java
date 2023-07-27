package com.newtours.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coms.newtours.pages.FindFlightPage;
import coms.newtours.pages.FlightConfirmationPage;
import coms.newtours.pages.FlightDetailsPage;
import coms.newtours.pages.RegistrationConfirmationPage;
import coms.newtours.pages.RegistrationPage;
import tests.BaseTest;

public class BookFlightTest extends BaseTest  {
	//private WebDriver driver;
	private String noOfPassanengers;
	private String expectedprice;
@BeforeTest
	@Parameters ({"noOfPassanengers","expectedprice"})
	public void setupParameter(String noOfPassengers,String expectedprice)
	{ 
		this.noOfPassanengers= noOfPassengers;
		this.expectedprice = expectedprice;
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\sanpr\\Desktop\\Jmeter Examples\\chromedriver.exe");
		//this.driver=new ChromeDriver();
	}
	
	@Test(priority =1)
	public void TC01_RegistrationPageTest()
	{
		RegistrationPage rp = new RegistrationPage(driver);
		rp.goTo();
		rp.enterUserCredentials("selenium","docker");
		rp.enterUserCredentials("selenium", "docker");
		rp.enterUserDetails("selenium","docker");
		rp.submit();
	}
	
	@Test(priority =2)
	public void TC02_RegistrationConfirmationPage()
	{
		RegistrationConfirmationPage rc = new RegistrationConfirmationPage(driver);
		rc.gotoFlights();
	}
	
	
	@Test(priority =3)
	public void TC03_FlightDetailsPage() throws InterruptedException
	{
		FlightDetailsPage fd = new FlightDetailsPage(driver);
		fd.selectPassengers(this.noOfPassanengers);
		Thread.sleep(2000);
		fd.gotofindflightspage();
		FindFlightPage ffp = new FindFlightPage(driver);
		ffp.clickfirstSubmitButton();
		ffp.gotFlightConfirmationPage();
		
	}
	
	@Test(priority =4)
	public void TC04_printConfirmation()
	{
		FlightConfirmationPage fcp = new FlightConfirmationPage(driver);
		String price = fcp.printConfirmation();
		Assert.assertEquals(price, this.expectedprice);
	}
	
	
}
