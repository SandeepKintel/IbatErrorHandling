package IbatAttemptToRecovery.IbatErrorHandling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Lsbf_LoginPage extends LsbfDatasheet
{
	WebDriver driver;
	
	@FindBy(xpath="//a[@class='jetpack-sso-toggle wpcom']")
	WebElement LoginOption;
	
	@FindBy(xpath="//input[@id='user_login']")
	WebElement EnterUsername;
	
	@FindBy(xpath="//input[@id='user_pass']")
	WebElement EnterPassword;
	
	@FindBy(xpath="//input[@id='wp-submit']")
	WebElement LoginButton;
	

	
	public void ClickLoginOption()
	{
		LoginOption.click();
	}

	public void InputUsername()
	{
		System.out.println(username);
		EnterUsername.sendKeys(username);
		
	}
	
	public void InputPassword() throws InterruptedException
	{
		EnterPassword.sendKeys(password);	
		
	}
	
	public void ClickLoginButton()
	{
		LoginButton.click();
	}
	
	
	public Lsbf_LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	
	}

}
