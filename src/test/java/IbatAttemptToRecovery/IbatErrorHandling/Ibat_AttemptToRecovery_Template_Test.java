package IbatAttemptToRecovery.IbatErrorHandling;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Ibat_AttemptToRecovery_Template_Test extends Ibat_LaunchAndQuit 
{
	@Test
	public void AttempBlockRecover_Templates_Test() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		LsbfDatasheet ld = new LsbfDatasheet();
		ld.getData();
		
		Lsbf_LoginPage lp = new Lsbf_LoginPage(driver);
		Lsbf_Homepage hp = new Lsbf_Homepage(driver);
		IbatTemplates it = new IbatTemplates(driver);
		
	
		lp.ClickLoginOption();
		lp.InputUsername();
		lp.InputPassword();
		lp.ClickLoginButton();
		hp.ClickAppearanceButton();
		it.ClickEditor();
		it.ClickTemplate();
		EditTemplate();
		
	}
	
	public static void EditTemplate() throws InterruptedException
	{
	
		Ibat_Pages al = new Ibat_Pages(driver);
		IbatTemplates it = new IbatTemplates(driver);
		List<WebElement> listofTemplate=driver.findElements(By.xpath("//div[@class='dataviews-wrapper']/div[2]/div"));
		int NoOfTemplates = listofTemplate.size();
					
		for(int i=0; i<NoOfTemplates; i++)
		{
			List<WebElement> listofTemplate2=driver.findElements(By.xpath("//div[@class='dataviews-wrapper']/div[2]/div"));
			System.out.println(listofTemplate2.size());
			listofTemplate2.get(i).click();
			if(al.AttemptRecoveryButtonList.size()>0) 
			{
				try {
					try {
						al.ClickAttemptBlockRecovery(driver);
					}catch(ElementClickInterceptedException e) {
						System.out.println("Handling Exception");
					}
				System.out.println("test verified for if condition");
				driver.switchTo().frame(it.IframeLocator);
				System.out.println("switched to Iframe");
				it.EnableContactField(driver);
				it.ClickContactUsField();
				driver.switchTo().defaultContent();
				System.out.println("switched to default frame");
				al.ClickSaveButton();
				it.ClickTempSaveButton();
				Thread.sleep(4000);
				driver.navigate().back();
					
				}catch(NoSuchElementException e)
				{
					System.out.println("Handeled Exception");
				}
				
			}else{
				try {
				System.out.println("test verified");
				driver.switchTo().frame(it.IframeLocator);
				System.out.println("switched to Iframe");
				it.EnableContactField(driver);
				it.ClickContactUsField();
				driver.switchTo().defaultContent();
				System.out.println("switched to default frame");
				al.ClickSaveButton();
				it.ClickTempSaveButton();
				Thread.sleep(4000);
				driver.navigate().back();
				}
				catch(NoSuchElementException e)
				{
					System.out.println("Handeled Exception");
				}
			}
			
		}
			
	}

}
