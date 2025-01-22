package IbatAttemptToRecovery.IbatErrorHandling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Lsbf_Homepage 
{
	WebDriver driver;
	
	@FindBy(xpath="//div[contains(text(),'Pages')]")
	WebElement Pages;
	
	@FindBy(xpath="//a[contains(text(),'All Pages')]")
	WebElement AllPages;
	
	@FindBy(xpath="//h1[contains(text(),'Pages')]")
	WebElement PagesText;
	
	@FindBy(xpath="//div[contains(text(),'Appearance')]")
	WebElement AppearanceText;

	
	
	
	
	public void HoverOnPage(WebDriver driver)
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(Pages).perform();
	}
	
	public void ClickAllPages()
	{
		AllPages.click();
	}
	
	public void ClickAppearanceButton()
	{
		AppearanceText.click();
	}
	
	
	public Lsbf_Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
			

}
