package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * This class provides implementation to the iTestListener Interface of TestNG
 * @author ganta
 *
 */

public class ListenersImplementation implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName + "----- Test Execution Started-----");
		
		//add @Test to extent report
		test=report.createTest(MethodName);
	}

	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName + "----- Test PASS-----");
		
		//Log the PASS statement to extent report
		test.log(Status.PASS, MethodName + "----- Test PASS-----");
		
	}

	public void onTestFailure(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName + "----- Test Fail-----");
		
		//Log the FAIL status to extent report
		test.log(Status.FAIL, MethodName + "----- Test Fail-----");
		
		SeleniumUtility s=new SeleniumUtility();
		JavaUtility j=new JavaUtility();
		
		String screenshotName=MethodName+"-"+j.getDate();
		
		try {
			String path = s.captureScreenshot(BaseClass.sDriver, screenshotName);
			
			//Attach screenshot to extent report
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName + "----- Test SKIPPED-----");
		
		//add the SKIP to the extent report
		test.log(Status.SKIP, MethodName + "----- Test SKIPPED-----");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		System.out.println("-----suite execution STARTED-----");
		
		//Extent Report configuraion
		
		ExtentSparkReporter rep=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getDate()+".html");
		rep.config().setDocumentTitle("Execution Report");
		rep.config().setReportName("VTiget execution Report");
		rep.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(rep);
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Browser", "Microsoft Edge");
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Reporter Name", "Pavithra");
	}

	public void onFinish(ITestContext context) {
		System.out.println("----- suite Execution ENDED-----");
		
		//Generate Extent Report
		report.flush();
		
	}
	
	 

}
