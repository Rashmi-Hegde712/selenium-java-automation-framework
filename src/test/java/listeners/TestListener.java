package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.testproject.uiandapiautomation.utils.ExtentReportManager;
import com.testproject.uiandapiautomation.utils.ExtentTestManager;
import com.testproject.uiandapiautomation.utils.ScreenshotUtil;

public class TestListener implements ITestListener {
	
	private ExtentReports extent;
	
	@Override
	public void onStart(ITestContext context) {
	    // Initialize ExtentReports
	    extent = ExtentReportManager.getExtent();
	    System.out.println("Test context started: " + context.getName());
	}
	
	@Override
    public void onTestStart(ITestResult result) {
		ExtentTest test = extent.createTest(
            result.getMethod().getMethodName());
        ExtentTestManager.setTest(test);
        System.out.println("Listener thread: " + Thread.currentThread().getId() + ", ExtentTest: " + ExtentTestManager.getTest());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().pass("Test Passed");
        ExtentTestManager.removeTest();
    }

	@Override
    public void onTestFailure(ITestResult result) {
				
		ExtentTest test = ExtentTestManager.getTest();
        if (test != null) {
        	 // Log failure reason
            test.fail(result.getThrowable());
            
         // Take screenshot
            String screenshotPath =
                    ScreenshotUtil.takeScreenshot(result.getMethod().getMethodName());

            if (screenshotPath != null) {
                test.addScreenCaptureFromPath(screenshotPath, "Failure Screenshot");        
            }
        }
	}
	
	 @Override
	    public void onTestSkipped(ITestResult result) {
	        ExtentTestManager.getTest().skip(result.getThrowable());
	        ExtentTestManager.removeTest();
	    }
	
	 @Override
	    public void onFinish(ITestContext context) {
		 if (extent != null) {
			 extent.flush();
	     }
	}
}