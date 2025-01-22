package IbatAttemptToRecovery.IbatErrorHandling;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Ibat_AttempBlockRecover_Pages_Test extends Ibat_LaunchAndQuit
{
	@Test
	public void AttempBlockRecover_Pages_Test() throws EncryptedDocumentException, IOException, InterruptedException
	{
		LsbfDatasheet ld = new LsbfDatasheet();
		ld.getData();
		
		Lsbf_LoginPage lp = new Lsbf_LoginPage(driver);
		Lsbf_Homepage hp = new Lsbf_Homepage(driver);
	
		lp.ClickLoginOption();
		lp.InputUsername();
		lp.InputPassword();
		lp.ClickLoginButton();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(hp.Pages));
		hp.HoverOnPage(driver);
		hp.ClickAllPages();
		EditPages();
		NextPageOperation();
				
	}
	
	
	public static void EditPages() throws InterruptedException
	{
		CommonAttemptToRecovery at=new CommonAttemptToRecovery();
		
		List<WebElement> li = driver.findElements(By.xpath("//a[@class='row-title']"));
		System.out.println(li.size());
		Actions actions = new Actions(driver);
		
		for(int i=0; i<li.size(); i++)
		{
	        actions.keyDown(Keys.CONTROL).click(li.get(i)).keyUp(Keys.CONTROL).perform();
	        Set<String> allWindows = driver.getWindowHandles();
			Iterator<String> i1 = allWindows.iterator();
			String ParentWindow=(String) i1.next();
			String ChildWindow = (String) i1.next();
			driver.switchTo().window(ChildWindow);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			try {
			at.AttemptToRecoveryCommon();
			}catch(NoSuchElementException e)
			{
				System.out.println("Handeled Exception");
			}
			driver.close();
			driver.switchTo().window(ParentWindow);
		}
	}
	
	
	public static void NextPageOperation() throws InterruptedException
	{
		Ibat_Pages ibat  = new Ibat_Pages(driver);
		while(ibat.NextPageButton.isEnabled())
		{
			ibat.ClickNextPage();	
			EditPages();
		}
		
		/*if(ibat.NextPageButton.isEnabled())
		{
			ibat.ClickNextPage();	
			EditPages();
		}else {
			System.out.println("This is the last Page");
		}*/
	}
}
