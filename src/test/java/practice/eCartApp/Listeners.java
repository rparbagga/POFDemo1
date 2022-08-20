package practice.eCartApp;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;
import resources.base;

public class Listeners extends base implements ITestListener {
	
	ExtentTest test;
	ExtentReports extent=ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>(); //Make objects of <Extent Test> class thread safe to run tests in parallel
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		test= extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		//test.log(Status.PASS, "Test Passed");  //in sequential
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//Code to take screenshot when testcase fails
								
				//test.fail(result.getThrowable()); //to get logs of fails in sequential
		extentTest.get().fail(result.getThrowable()); //in parallel

		WebDriver driver2 =null;
		String testMethodName =result.getMethod().getMethodName(); //So that we get name of failed method in test case
		
		try {
			driver2 =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());  //So that we get the real instance of driver
			
		} catch(Exception e)
		{
			//e.printStackTrace();	
		}
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver2),testMethodName ); //to display scrnshot to extentreport
			//getScreenShotPath(testMethodName,driver2);  //error here if base file not inherited  
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
		extent.flush();
	}

}
