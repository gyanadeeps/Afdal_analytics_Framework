package Reporting;

import Reporting.Models.TestCaseKeys;
import com.aventstack.extentreports.ExtentTest;
import lombok.extern.java.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * OB: extentTestMap holds the information of thread ids and ExtentTest instances.
 * ExtentReports instance created by calling getReporter() method from ExtentManager.
 * At startTest() method, an instance of ExtentTest created and put into extentTestMap with current thread id.
 * At endTest() method, test ends and ExtentTest instance got from extentTestMap via current thread id.
 * At getTest() method, return ExtentTest instance in extentTestMap by using current thread id.
 */
@Log
public class ExtentTestManager {
    public static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
    //public static ExtentReports extent = ExtentManager.getInstance();

    public static synchronized ExtentTest getTest() {
        return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));

    }

    public static synchronized void endTest(ExtentTest test) {
        try {
            test.getExtent().flush();
        }
        catch(Throwable e){
            log.info("Not Ble to Flush" + e.getMessage());
        }
    }

    public static synchronized ExtentTest startTest(String testName, String description, String category) {
        try {
            ExtentTest test =ExtentManager.getInstance().createTest(testName, description).assignCategory(category);
            extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
            TestCaseKeys.reportsPathWithTestCaseThreadIDMap.put((int) (long) (Thread.currentThread().getId()), ExtentManager.reportFileLocation);
            return test;
        } catch (NullPointerException e) {
            log.info("Exception in Create the Test Case Object in Extent Report:" + e.getMessage());
            return null;
        }
    }


}