package Driver_Factory;

import Utils.Reporter;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {
    private Logger logger =  Logger.getLogger(TestNGListener.class);
@Override
    public void onTestStart(ITestResult result)
    {
        Reporter.createTest(result.getMethod().getMethodName());
        logger.info("onTestStart");
        try {
            throw new RuntimeException("error is thrown");
        }  catch (Exception e) {
            logger.error(e.getMessage());
        }

        logger.error("error");
        logger.debug("dubug");
        System.out.println("onTestStart");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Reporter.step.pass("Test Passed");
        System.out.println("onTestSuccess");
    }

    public void onTestFailure(ITestResult result) {
        Reporter.step.fail("Test Failed \n"+ result.getThrowable());
        System.out.println("onTestFailure");
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped");
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
