package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerPractice {

	@Test(retryAnalyzer = vtiger.GenericUtilities.RetryAnalyzerImplementation.class)
	
	public void analyzerPractice() {
		
		
		//wantedly i am making my script to fail case 2:
		Assert.fail();
		
		System.out.println("hello");
	}
}

