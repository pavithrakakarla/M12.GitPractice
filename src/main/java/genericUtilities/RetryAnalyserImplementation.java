package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementation to IRetryAnalyser interface
 * of TestNG
 * @author ganta
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer {
	
	int count = 0;
	int retryCount = 3; //manual Analysis

	public boolean retry(ITestResult result) {
		
		while(count<retryCount)
		{
			//0<3 1<3 2<3 3<3
			count++; // 1 2 3 
			return true; //retry retry retry
		}
		
		
		return false; //stop retry
	}

}
