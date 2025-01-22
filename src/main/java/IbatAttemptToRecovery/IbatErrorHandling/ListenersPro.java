package IbatAttemptToRecovery.IbatErrorHandling;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersPro implements ITestListener {
	
	static WebDriver driver;

	
	public void onTestSuccess(ITestResult result) {
		
		ITestListener.super.onTestSuccess(result);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination= new File("C:\\Users\\sandeep.kumar\\eclipse-workspace\\LsbfErrorHandling\\ScreenShots\\Pass\\TCPassed"+Math.random()+".png");
		try {
			FileHandler.copy(source, destination);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		
		ITestListener.super.onTestFailedWithTimeout(result);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination= new File("C:\\Users\\sandeep.kumar\\eclipse-workspace\\LsbfErrorHandling\\ScreenShots\\Failed\\TC_Failed"+Math.random()+".png");
		try {
			FileHandler.copy(source, destination);
		} catch (IOException e) {
	
			e.printStackTrace();
		}
	}
		
	
	
	
	

}
