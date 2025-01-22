package IbatAttemptToRecovery.IbatErrorHandling;

import java.util.NoSuchElementException;
import org.openqa.selenium.ElementClickInterceptedException;



public class CommonAttemptToRecovery extends Ibat_LaunchAndQuit
{
	public void AttemptToRecoveryCommon() throws InterruptedException
	{
		Ibat_Pages al = new Ibat_Pages(driver);
	
		if(al.AttemptRecoveryButtonList.size()>0) 
		{
			try {
				try {
					al.ClickAttemptBlockRecovery(driver);
				}catch(ElementClickInterceptedException e) {
					System.out.println("Handling Exception");
				}
			System.out.println("test verified for if condition");
			al.ActionOnHeading();
			al.ClickSaveButton();
			Thread.sleep(5000);
			
			}catch(NoSuchElementException e)
			{
				System.out.println("Handeled Exception");
			}
			
		}else{
			try {
			System.out.println("test verified");
			al.ActionOnHeading();
			al.ClickSaveButton();
			Thread.sleep(4000);
			}catch(NoSuchElementException e)
			{
				System.out.println("Handeled Exception");
			}
		}
		
	}
}

