package IbatAttemptToRecovery.IbatErrorHandling;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry_Logic implements IRetryAnalyzer{

	int retry_count=2;
	int current_count=0;
	public boolean retry(ITestResult result) {
		if(current_count<retry_count) {
			current_count++;
			return true;
			
		}
		
		return false;
	}

}
