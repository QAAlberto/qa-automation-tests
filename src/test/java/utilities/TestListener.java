package utilities;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

import java.io.File;

import static pages.BasePage.logger;
import static pages.Utils.getBrowserLogs;
import static pages.Utils.takeSnapShot;

public class TestListener extends BaseTest implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        logger.info((iTestResult.getMethod().getMethodName() + " started!"));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        if(nodeThread.get() == null){
            test.get().pass("Test passed");
            test.remove();
            logger.info((iTestResult.getMethod().getMethodName() + " passed!"));
        }else{
            nodeThread.get().pass("Test passed");
            nodeThread.remove();
            logger.info((iTestResult.getMethod().getMethodName() + " passed!"));
        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Object currentClass = iTestResult.getInstance();
        WebDriver driver = ((BaseTest) currentClass).getDriver();
        takeSnapShot(driver, System.getProperty("user.dir") +  File.separator + "downloads" + File.separator + "error.png");
        String logs = getBrowserLogs(driver);
        if(nodeThread.get() == null){
            test.get().fail(iTestResult.getThrowable()).addScreenCaptureFromPath("/downloads/error.png");
            test.get().info(logs);
            test.remove();
        }else{
            nodeThread.get().fail(iTestResult.getThrowable()).addScreenCaptureFromPath("/downloads/error.png");
            nodeThread.remove();
        }

        logger.error(iTestResult.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        test.get().skip(iTestResult.getThrowable());
        logger.info((iTestResult.getMethod().getMethodName() + " skipped!"));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println(("onTestFailedButWithinSuccessPercentage for " + iTestResult.getMethod().getMethodName()));
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("Extent Reports Test Suite started!");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println(("Extent Reports Test Suite is ending!"));
        extent.flush();
    }
}
