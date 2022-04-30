package Reporting;


import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import lombok.extern.java.Log;
import utilities.DateUtil;

import java.io.File;


@Log
public class ExtentManager {
    private static ExtentReports extent;
    private static String documentTitle = "Automation Report";
    private static String fileSeperator = System.getProperty("file.separator");
    private static String reportFilepath = System.getProperty("user.dir") + fileSeperator + "Artifacts";
    static String reportName;
    static String reportFileLocation;
    private static int executedCasesCounter;
    public static String currentDate;


    public static synchronized ExtentReports getInstance() {

        return extent;
    }


    public synchronized ExtentReports createInstance() {

        try {
            currentDate=DateUtil.currentDate();
            reportName = "NCSA_Automation_" + currentDate + ".html";
            String reportFolder = getReportPath(reportFilepath);
            reportFileLocation = reportFolder + fileSeperator + reportName;
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportFileLocation);
            htmlReporter.config().setTheme(Theme.DARK);
            htmlReporter.config().setDocumentTitle(documentTitle);
            htmlReporter.config().setEncoding("utf-8");
            htmlReporter.config().setReportName(reportName);
            htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

            extent = new ExtentReports();
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Tool", "NCSA Automation");
            /*extent.setSystemInfo("User", System.getProperty("user.name"));
            extent.setSystemInfo("User ID", System.getProperty("user.id"));
            extent.setSystemInfo("User Email", System.getProperty("user.email"));*/
            extent.setSystemInfo("Build Number", System.getenv("BUILD_NUMBER"));
            extent.setSystemInfo("Build URL", System.getenv("BUILD_URL"));
            extent.setSystemInfo("Build ID", System.getenv("BUILD_ID"));

            extent.setAnalysisStrategy(AnalysisStrategy.TEST);
            extent.getStats();
            extent.attachReporter(htmlReporter);
        } catch (Exception e) {
            e.getCause();
        }
        return extent;
    }


    private static String getReportPath(String path) {

        File testDirectory = new File(path);
        if (!testDirectory.exists()) {
            testDirectory.mkdir();

            }

        return reportFilepath;
    }
}