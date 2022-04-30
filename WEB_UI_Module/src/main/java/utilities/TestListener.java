package utilities;

import Reporting.ExtentTestManager;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import data.SystemProperties;
import engine.DriverUtils;
import lombok.extern.java.Log;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static engine.DriverUtils.getScreenshotFile;

@Log
public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        log.info("\u001B[34m" +"**************** Running test method -->  " + result.getMethod().getMethodName() + " ****************"+"\u001B[0m");
        ExtentTestManager.startTest(result.getTestClass().getRealClass().getSimpleName(), testCaseDescription(result), result.getTestClass().getRealClass().getPackage().getName());
      /*  SynapseArtifacts synapseArtifacts = getSynapseRTAnnotation(result);
        if (synapseArtifacts != null) {
            String[] synapsertAnnotationKeyArray = getSynapseRTAnnotation(result).testcaseKey().split(",");
            for (String tcKey : synapsertAnnotationKeyArray) {
                TestCaseReportPaths.putTestCaseKeys(reportsPathWithTestCaseThreadIDMap.get((int) (long) (Thread.currentThread().getId())), tcKey.trim());
            }
        }*/
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("\u001B[32m" +"**************** Test method Passed -> [" + result.getMethod().getMethodName() + "]  successfully on Thread -> "+Thread.currentThread().getId()+" ****************"+"\u001B[0m");
        Markup m = MarkupHelper.createLabel("<b>Test Method " + result.getMethod().getMethodName() + " Successful</b>", ExtentColor.GREEN);
        Markup screenshotHtml = MarkupHelper.createLabel(DriverUtils.screenShotEmbedHtml(DriverUtils.getScreenshot()), ExtentColor.TRANSPARENT);
        ExtentTestManager.getTest().pass(m).pass(screenshotHtml);
      /*  SynapseArtifacts synapseArtifacts = getSynapseRTAnnotation(result);
        if (synapseArtifacts != null) {
            setTestCaseResults(synapseArtifacts, TestExecutionStatus.Passed, "Test Method " + result.getMethod().getMethodName() + " executed Successfully.");
        }*/
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        String destFile= SystemProperties.FAILEDSCREENSHOTFOLDER + result.getMethod().getMethodName() + ".png";
        log.warning("\033[0;31m" +"**************** Test Failed -> " + result.getMethod().getMethodName() + ", in thread ->  " + Thread.currentThread().getId()+ " ****************"+"\u001B[0m");
        Markup m = MarkupHelper.createLabel(failureMessage(result), ExtentColor.RED);
        Markup screenshotHtml = MarkupHelper.createLabel(DriverUtils.screenShotEmbedHtml(DriverUtils.getScreenshot()), ExtentColor.TRANSPARENT);
        ExtentTestManager.getTest().fail(m).fail(screenshotHtml);
        getScreenshotFile(destFile);
        /*SynapseArtifacts synapseArtifacts = getSynapseRTAnnotation(result);
        if (synapseArtifacts != null) {
            setTestCaseResults(synapseArtifacts, TestExecutionStatus.Failed, "Test Method " + result.getMethod().getMethodName() + " Failed. Reason for Failure: " + result.getThrowable().toString());

        }*/

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("\u001B[36m" +" **************** Test method" + result.getMethod().getMethodName() + " skipped. ****************"+"\u001B[0m");
        ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.info("\u001B[32m" +"**************** Test failed but within percentage % " + result.getMethod().getMethodName()+"\u001B[0m");
    }

    @Override
    public void onStart(ITestContext context) {
        //log.info("\u001B[35m" +"**************** Running the Test Suite with " + context.getSuite().getAllMethods().size() + " tests. ****************");
    }

    @Override
    public void onFinish(ITestContext context) {
        //log.info("\u001B[32m" +"**************** Test Suite with size: " + context.getSuite().getAllMethods().size()+ " ending. ****************");


    }



    private String testCaseDescription(ITestResult result) {
        String link = "";
        // link = "<a href='PLEASE LINK THE TEST CASE WITH JIRA' target='_blank'><u><i>JIRA LINK</i></u></a>";
            return link + "<p>" + result.getMethod().getDescription() + "</p>";

    }




    private String failureMessage(ITestResult result) {
        String html = "<details>\n" + "  <summary><b> Exception Occurred in: " + result.getTestClass().getRealClass().getCanonicalName() + "," + "<p><u><i>Click here to see full details:</i></u></b></p></summary>\n" +
                "  <p>" + result.getThrowable() + "</p>\n" +
                "</details>\n";
        return html;
    }



}
