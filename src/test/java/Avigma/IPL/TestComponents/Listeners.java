package Avigma.IPL.TestComponents;
import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext ;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Report.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener{
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>();
	
	@Override 
	public void onTestStart(ITestResult result) {
        //test = extent.createTest(result.getMethod().getMethodName());
		extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override 
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Passed");
	}

	
	@Override 
	public void onTestFailure(ITestResult result) {
        if (extentTest != null) {
        	extentTest.get().fail(result.getThrowable());
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").
					get(result.getInstance());
		} catch (Exception el) {
			
			el.printStackTrace();
		}
		
		
		
		String filePath = null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	}
	}
	
	@Override 
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
