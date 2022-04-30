package utilities;

import Reporting.ExtentTestManager;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.codeborne.selenide.WebDriverRunner;
import data.SystemProperties;
import engine.DriverUtils;
import io.qameta.allure.Attachment;
import lombok.extern.java.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static engine.DriverUtils.getScreenshotFile;

@Log
public class AllureListener implements ITestListener
{
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value="Page Screenshot",type="image/png")
    public byte[] saveFailureScreenShot(WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    @Override
    public void onTestStart(ITestResult iTestResult)
    {
        log.info("\u001B[34m" +"**************** Running test method -->  " + iTestResult.getMethod().getMethodName() + " ****************"+"\u001B[0m");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult)
    {
        log.info("\u001B[32m" +"**************** Test method Passed -> [" + iTestResult.getMethod().getMethodName() + "]  successfully on Thread -> "+Thread.currentThread().getId()+" ****************"+"\u001B[0m");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult)
    {
        System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
        Object testClass = iTestResult.getInstance();
        WebDriver driver = WebDriverRunner.getWebDriver();
        // Allure ScreenShot and SaveTestLog
        if (driver != null) {
            System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult));
            saveFailureScreenShot(driver);
        }
        saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult)
    {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult)
    {
        log.info("\u001B[36m" +" **************** Test method" + iTestResult.getMethod().getMethodName() + " skipped. ****************"+"\u001B[0m");
        ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
