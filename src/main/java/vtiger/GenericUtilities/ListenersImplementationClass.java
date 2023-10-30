package vtiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


/**
 * this class provides implementation to ITestListener interface of testNG
 * @author Bhumika 
 *
 */
public class ListenersImplementationClass implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	
	public void onTestStart(ITestResult result) {
		String testscriptName = result.getMethod().getMethodName();
		System.out.println(testscriptName+ "===test script execution started === ");
		
		//create a test script - recognise each @Test
		test = report.createTest(testscriptName);
	}
	
	public void onTestSuccess(ITestResult result) {
		String testscriptName = result.getMethod().getMethodName();
		System.out.println(testscriptName+ "=== Passed === ");
		
		//Log the success
		test.log(Status.PASS, testscriptName+" == PASS ==");
		
	}
	
	public void onTestFailure(ITestResult result) {
		
		//Screenshot
		//Exception for failure
		String testscriptName = result.getMethod().getMethodName();
		System.out.println(testscriptName+ "=== Failed === ");
		
//		Exception for failure
		System.out.println(result.getThrowable());
		
		//log for failure
		test.log(Status.FAIL, testscriptName+" == Fail ==");
		test.log(Status.INFO, result.getThrowable());
		

		//Screenshot
		String screenShotName = testscriptName + new JavaUtility().getSystemDate();
				
		WebDriverUtility w = new WebDriverUtility();
		try {
			
			String path = w.captureScreenShot(BaseClass.sdriver, screenShotName);
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		String testscriptName = result.getMethod().getMethodName();
		System.out.println(testscriptName+ "=== Skipped === ");
		
		//Exception for failure
		System.out.println(result.getThrowable());
		
		//log for Skip
		test.log(Status.SKIP, testscriptName+" == skipped ==");
		test.log(Status.INFO, result.getThrowable());
	}
	
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//		String testscriptName = result.getMethod().getMethodName();
//		System.out.println( "=== Skipped === ");
	}
	
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}
	
	public void onStart(ITestContext context) {
		
		System.out.println( "=== Suite Execution started === ");
		
        //Basic Report configuration //Report-17-10-2023-20-04-20.html
		ExtentSparkReporter html = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDate()+".html");
		html.config().setTheme(Theme.DARK);
		html.config().setDocumentTitle("Execution Report");
		html.config().setReportName("Vtiger execution Report");
	
	    report = new ExtentReports();
		report.attachReporter(html);
		report.setSystemInfo("Base Browser", "Firefox");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Reporter Name", "Chaitra");
		
	}
	
	public void onFinish(ITestContext context) {
		
		System.out.println( "=== Suite Execution finished === ");
		
		//Report genertion
		report.flush();
		
	}
	
	
}
