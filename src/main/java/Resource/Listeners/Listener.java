
package Listeners;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resource.base;
import utilities.ExtentReporter;

public class Listener extends base implements ITestListener {

	WebDriver driver=null;
ExtentReports ExtentReport=ExtentReporter.getExtendReport();
ExtentTest extendtest;
ThreadLocal<ExtentTest> extenttestthread=new ThreadLocal<ExtentTest> ();
	@Override
	public void onTestStart(ITestResult result) {
		
		String testname = result.getName();
		 extendtest = ExtentReport.createTest(testname+"Execution started");
		 extenttestthread.set(extendtest);
	}
	

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String testname = result.getName();
		
		//extendtest.log(Status.PASS, testname+"Got passed");
		extenttestthread.get().log(Status.PASS, testname+"Got passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		WebDriver driver=null;
		String testName=result.getName();
		
		//extendtest.fail(result.getThrowable());
		extenttestthread.get().fail(result.getThrowable());
		try {
			 driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());//code to get driver 
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			String screeshot=takeScreenshot(testName,driver);
			extenttestthread.get().addScreenCaptureFromPath(screeshot,testName);
		}catch(IOException e) {
			e.printStackTrace();
		}
	
	}
	

	
		
	

	private String takeScreenshot(String testName, WebDriver driver2) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void onTestSkipped(ITestResult result) {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ExtentReport.flush();
	}

	
}
