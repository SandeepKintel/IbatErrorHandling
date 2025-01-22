package IbatAttemptToRecovery.IbatErrorHandling;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ibat_Pages 
{

		WebDriver driver;
		
		@FindBy(xpath="//a[contains(text(),'ALUMNI')]")
		WebElement AluminiPage;
		
		@FindBy(xpath="(//input[@class='components-text-control__input'])[1]")
		WebElement Heading;
		
		@FindBy(xpath="(//a[@class='next-page button'])[2]")
		WebElement NextPageButton;
		
		
		@FindBy(xpath="//button[contains(text(),'Attempt Block Recovery')]")
		List<WebElement> AttemptRecoveryButtonList;
		
		@FindBy(xpath="//button[contains(text(),'Attempt Block Recovery')]")
		WebElement AttemptRecoveryButton;
		
		@FindBy(xpath="//button[contains(text(),'Save')]")
		WebElement SaveButton;
		
		public void ActionOnHeading()
		{
			Heading.sendKeys("." + Keys.BACK_SPACE);
			System.out.println("Action Performed Successfuly");
		}
		
		public void ClickAluminiPage()
		{
			AluminiPage.click();
			System.out.println();
		}
				
		public void ClickAttemptBlockRecovery(WebDriver driver) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			if(AttemptRecoveryButtonList.size()>0) 
			{
				for(int i=0; i<AttemptRecoveryButtonList.size(); i++)
				{
					wait.until(ExpectedConditions.visibilityOfAllElements(AttemptRecoveryButtonList.get(i)));
				    js.executeScript("arguments[0].scrollIntoView(true);", AttemptRecoveryButtonList.get(i));
				    wait.until(ExpectedConditions.elementToBeClickable(AttemptRecoveryButtonList.get(i)));
				    AttemptRecoveryButtonList.get(i).click();   
				}

			}

			else {
					try {
						wait.until(ExpectedConditions.visibilityOf(AttemptRecoveryButton));
					    js.executeScript("arguments[0].scrollIntoView(true);", AttemptRecoveryButton);
					    wait.until(ExpectedConditions.elementToBeClickable(AttemptRecoveryButton));
						AttemptRecoveryButton.click();
						
					}catch(NoSuchElementException e) {
						System.out.println("Handling the Exception");
					}catch(ElementClickInterceptedException e)
					{
						System.out.println("Exception Handeled");
					}

			}
		}
		
		public void ClickSaveButton()
		{
			SaveButton.click();
		}
		
		public void ClickNextPage()
		{
			NextPageButton.click();
		}
		
		public Ibat_Pages(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
	}
