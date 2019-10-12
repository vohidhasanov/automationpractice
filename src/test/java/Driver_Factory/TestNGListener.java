package Driver_Factory;

import Utils.Reporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {

    public void onTestStart(ITestResult result)
    {
        Reporter.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        Reporter.step.pass("Test Passed");
    }

    public void onTestFailure(ITestResult result) {
        Reporter.step.fail("Test Failed \n"+ result.getThrowable());
    }

    public void onTestSkipped(ITestResult result) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
    }

    public void onFinish(ITestContext context) {
    }

}
