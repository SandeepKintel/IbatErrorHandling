package IbatAttemptToRecovery.IbatErrorHandling;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;


@Listeners(ListenersPro.class)
public class Ibat_LaunchAndQuit extends ListenersPro
{
	
	@BeforeMethod()
	public void LaunchBrowser()
	{
		driver= new ChromeDriver();
		driver.get("https://gus-incubator-wp-stage.go-vip.net/wp-admin/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@AfterMethod
	public void CloseBrowser() throws InterruptedException
	{
		Thread.sleep(5000);
		//driver.quit();
	}
	
}
