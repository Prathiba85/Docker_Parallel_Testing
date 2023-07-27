package coms.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	//webElement
	
	@FindBy(xpath ="//input[@name='firstName']")private WebElement firstnameText;
	@FindBy(xpath ="//input[@name='lastName']")private WebElement lastnameText;
	@FindBy(xpath ="//input[@name='email']")private WebElement username;
	@FindBy(xpath="//input[@name='password']")private WebElement password;
	@FindBy(xpath="//input[@name='confirmPassword']")private WebElement confirm_password;
	@FindBy(xpath="//input[@value='submit']")private WebElement submit;
	
	public RegistrationPage (WebDriver driver )
	{
		this.driver = driver;
		
		this.wait=new WebDriverWait(driver, 30);
		PageFactory.initElements(driver,this);
	}
	public void goTo()
	{
		driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
		wait.until(ExpectedConditions.visibilityOf(this.firstnameText));
	}
	
	
	public void enterUserDetails(String firstname,String lastname)
	{
		firstnameText.sendKeys(firstname);
		lastnameText.sendKeys(lastname);
		
	}
	
	public void enterUserCredentials(String username, String password)
	{
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		this.confirm_password.sendKeys(password);
	}
	
	public void submit()
	{
		this.submit.click();
	}
}
