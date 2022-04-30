package Reporting;

import data.SystemProperties;
import engine.DriverBinaryManager;
import org.testng.*;
import org.testng.collections.Lists;
import org.testng.internal.Utils;
import org.testng.log4testng.Logger;
import org.testng.xml.XmlSuite;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static data.SystemProperties.FILE_SEPERATOR;
import static data.SystemProperties.USERDIR;

/**
 * Reporter that generates a single-page HTML report of the suite test results.
 * <p>
 */
public class TestNGCustomReport implements IReporter {

    private static final Logger LOG = Logger.getLogger(TestNGCustomReport.class);
    private static String timeZone = "GMT-7";
    private static int totalTestCasePass=0;
    private static int totalTestCaseFail=0;
    private static int totalTestCaseExecuted=0;
    private static long totalTimeDuration=0;

    private static SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
    private static SimpleDateFormat sdftime = new SimpleDateFormat("HH:mm:ss a");
    private static String outFilename = "TestNG_Custom_Report.html";
    private static NumberFormat integerFormat = NumberFormat.getIntegerInstance();
    private static NumberFormat decimalFormat = NumberFormat.getNumberInstance();
    private static ConcurrentHashMap<String, List<Integer>> testModuleResults;
    private static ConcurrentHashMap<String, List<String>> testCaseResults;
    protected PrintWriter writer;
    protected List<SuiteResult> suiteResults = Lists.newArrayList();
    private StringBuilder buffer = new StringBuilder();
    private String currentDate;


    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        try {
            currentDate=ExtentManager.currentDate;
            writer = createWriter(USERDIR + FILE_SEPERATOR + "Artifacts");
            testCaseResults = new ConcurrentHashMap<>();
            testModuleResults = new ConcurrentHashMap<String, List<Integer>>();
            //System.out.print("Custom report**********************");
        } catch (IOException e) {
            LOG.error("Unable to create output file", e);
            return;
        }
        for (ISuite suite : suites) {
            suiteResults.add(new SuiteResult(suite));

        }

        for (SuiteResult suiteresult : suiteResults) {
           // for (TestResult testresult : suiteresult.getTestResults()) {
            for(int i=0;i<suiteresult.getTestResults().size();i++){
                totalTestCasePass = totalTestCasePass+suiteresult.getTestResults().get(i).getPassedTestCount();
                totalTestCaseFail = totalTestCaseFail+suiteresult.getTestResults().get(i).getFailedTestCount();
                totalTimeDuration = totalTimeDuration+suiteresult.getTestResults().get(i).getDuration();

            }
            totalTestCaseExecuted= totalTestCasePass+totalTestCaseFail;

            totalTimeDuration=Math.abs(totalTimeDuration/1000);

        }

        convertInToModule(testCaseResults);
        writeDocumentStart();
        writeHead();
        writeBody();
        writeDocumentEnd();
        writer.close();



    }

    protected PrintWriter createWriter(String outdir) throws IOException {
        new File(outdir).mkdirs();
        return new PrintWriter(new BufferedWriter(new FileWriter(new File(outdir, outFilename))));
    }

    protected void writeDocumentStart() {
        writer.println(
                "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN\" \"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">");
        writer.print("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
    }

    protected void writeHead() {
        writer.print("<head>");
        writer.print("<title>Afdal Analytics Report</title>");
        writeStylesheet();
        writer.print("</head>");
    }

    protected void writeStylesheet() {
        writer.print("<style type=\"text/css\">");
        writer.print("table {margin-bottom:15px;border-collapse:collapse;empty-cells:show}");
        writer.print("th,td {border:2px solid #007;padding:.25em .5em}");
        writer.print("th {vertical-align:bottom}");
        writer.print("td {vertical-align:center}");
        writer.print("table a {font-weight:bold}");
        writer.print(".stripe td {background-color: #E6EBF9}");
        writer.print(".num {text-align:center}");
        writer.print(".passedodd td ");
        writer.print(".passedeven td ");
//writer.print(".skippedodd td {background-color: #DDD}");
//writer.print(".skippedeven td {background-color: #CCC}");
        writer.print(".failedodd td,.attn ");
        writer.print(".failedeven td,.stripe .attn ");
        writer.print(".stacktrace {white-space:pre;font-family:monospace}");
        writer.print(".totop {font-size:85%;text-align:center;border-bottom:2px solid #000}");
        writer.print("</style>");
    }

    protected void writeBody() {

        writer.print("<body>");
        writeReportTitle("Afdal Analytics Automation Report");
        writeProjectDetails();
        writeSuiteSummary();
        writeScenarioSummary();
        writeScenarioDetails();
        writer.print("</body>");
    }

    protected void writeReportTitle(String title) {
        writer.print("<center><h1>" + title + " - " + currentDate + "</h1></center>");
    }

    protected void writeDocumentEnd() {
        writer.print("</html>");
    }

    protected void writeProjectDetails() {

        writer.print("<table>");
        writer.print("<tr style=\"background-color:powderblue;\">");
        writer.print("<th># Environment Variables</th>");
        writer.print("<th># Values</th>");
        writer.print("</tr>");
        writer.print("<tr>");
        writer.println("<th>Jenkins Job URL</td>");
        writer.print("<td> "+ SystemProperties.BUILD_URL +" </td>");
        writer.print("</tr>");
        writer.print("<tr>");
        writer.println("<th>Build Number</td>");
        writer.print("<td> "+ SystemProperties.BUILD_NUMBER +" </td>");
        writer.print("</tr>");
        writer.print("<tr>");
        writer.println("<th>Detailed Report URL"+"&#x2a;</td>");
        writer.print("<td> "+ SystemProperties.BUILD_URL+"AfdalAnalytics_5fAutomation_5fReport/" +" </td>");
        writer.print("</tr>");

        writer.print("<tr>");
        writer.println("<th>Allure Report URL"+"&#x2a;</td>");
        writer.print("<td> "+ SystemProperties.BUILD_URL+"allure/" +" </td>");
        writer.print("</tr>");

        writer.print("<tr>");
        writer.println("<th>AWS_BUILD"+"&#x2a;</td>");
        writer.print("<td> "+ SystemProperties.AWS_BUILD+" </td>");
        writer.print("</tr>");


        writer.print("<tr>");
        writer.println("<th>Environment URL </td>");
        writer.print("<td> "+ SystemProperties.AFDALANALYTICS_URL +" </td>");
        writer.print("</tr>");
        writer.print("<tr>");
        writer.println("<th>Browser</td>");
        writer.print("<td> "+SystemProperties.DRIVER_TYPE+ " {<i>"+ DriverBinaryManager.browserVersion +"<i>}"+"</td>");
        writer.print("</tr>");
        writer.print("<tr>");
        writer.println("<th>Executed Date</td>");
        writer.print("<td> "+currentDate+" </td>");
        writer.print("</tr>");
        writer.print("</table>");
        writer.print("<p style=\"color:blue;font-size:12px;\">&#x2a;Please use Jenkins Username and Password to access the Detailed report.</p>");
        //writer.print("&#x2a;"+"Please use Jenkins Username and Password to access Extent report.");

    }


    protected void writeSuiteSummary() {

        int totalPassedTests = 0;
        int totalSkippedTests = 0;
        int totalFailedTests = 0;
        long totalDuration = 0;

        writer.print("<table>");
        writer.print("<tr style=\"background-color:powderblue;\">");
        writer.print("<th> Executed</th>");
        writer.print("<th># Passed</th>");
        //writer.print("<th># Skipped</th>");
        writer.print("<th ># Failed</th>");
        writer.print("<th> Duration</th>");
        //writer.print("<th>Included Groups</th>");
        //writer.print("<th>Excluded Groups</th>");
        writer.print("</tr>");

        int testIndex = 0;

 /*writer.print("<tr><th colspan=\"8\">");
 writer.print(Utils.escapeHtml(suiteResult.getSuiteName()));
 writer.print("</th></tr>");*/


            writer.print("<tr");
            if ((testIndex % 2) == 1) {
                writer.print(" class=\"stripe\"");
            }
            writer.print(">");

            buffer.setLength(0);
            writeTableData(integerFormat.format(totalTestCaseExecuted), "num");
            writeTableData(integerFormat.format(totalTestCasePass), "num");
            //writeTableData(integerFormat.format(skippedTests), (skippedTests > 0 ? "num attn" : "num"));
            writeTableData(integerFormat.format(totalTestCaseFail),   "num");
            String sec=integerFormat.format(totalTimeDuration);
            int totalTome=(int)totalTimeDuration;
            String timeDuration= formatSeconds(totalTome);

            writeTableData(timeDuration,"num");
            //writeTableData(testResult.getIncludedGroups());
            //writeTableData(testResult.getExcludedGroups());

            writer.print("</tr>");


            testIndex++;


        writer.print("</table>");
    }

    /**
     * Writes a summary of all the test scenarios.
     */
    protected void writeScenarioSummary() {

        writer.print("<table>");
        writer.print("<thead>");
        writer.print("<tr style=\"background-color:powderblue;\">");
        writer.print("<th>Module</th>");
        writer.print("<th>Test Case</th>");
        //writer.print("<th>Test Case</th>");
        writer.print("<th>Start</th>");
        writer.print("<th>Seconds</th>");
        writer.print("<th>Result</th>");
        writer.print("</tr>");
        writer.print("</thead>");

        int testIndex = 0;
        int scenarioIndex = 0;
        for (SuiteResult suiteResult : suiteResults) {
            writer.print("<tbody><tr><th colspan=\"5\">");
            writer.print(Utils.escapeHtml(suiteResult.getSuiteName()));
            writer.print("</th></tr></tbody>");

            for (TestResult testResult : suiteResult.getTestResults()) {
                writer.print("<tbody id=\"t");
                writer.print(testIndex);
                writer.print("\">");

                String moduleName = Utils.escapeHtml(testResult.getTestName());

                scenarioIndex += writeScenarioSummary(moduleName + " &#8212; failed (configuration methods)",
                        testResult.getFailedConfigurationResults(), "failed", scenarioIndex);
                scenarioIndex += writeScenarioSummary(moduleName + " &#8212; Failed", testResult.getFailedTestResults(),
                        "failed", scenarioIndex);
 /*scenarioIndex += writeScenarioSummary(testName + " &#8212; skipped (configuration methods)",
 testResult.getSkippedConfigurationResults(), "skipped", scenarioIndex);
 scenarioIndex += writeScenarioSummary(testName + " &#8212; skipped", testResult.getSkippedTestResults(),
 "skipped", scenarioIndex);*/
                scenarioIndex += writeScenarioSummary(moduleName + " &#8212; Passed", testResult.getPassedTestResults(),
                        "passed", scenarioIndex);

                writer.print("</tbody>");

                testIndex++;
            }
        }

        writer.print("</table>");
    }

    /**
     * Writes the scenario summary for the results of a given state for a single
     * test.
     */
    private int writeScenarioSummary(String description, List<ClassResult> classResults, String cssClassPrefix,
                                     int startingScenarioIndex) {
        int scenarioCount = 0;
        if (!classResults.isEmpty()) {
            writer.print("<tr><th colspan=\"5\">");
            writer.print(description);
            writer.print("</th></tr>");

            int scenarioIndex = startingScenarioIndex;
            int classIndex = 0;
            for (ClassResult classResult : classResults) {

                String cssClass = cssClassPrefix + ((classIndex % 2) == 0 ? "even" : "odd");

                buffer.setLength(0);
                String moduleName= description.split("&")[0];
                int scenariosPerClass = 0;
                int methodIndex = 0;
                for (MethodResult methodResult : classResult.getMethodResults()) {
                    List<ITestResult> results = methodResult.getResults();
                    int resultsCount = results.size();
                    assert resultsCount > 0;

                    ITestResult aResult = results.iterator().next();

                    String methodName = Utils.escapeHtml(aResult.getMethod().getMethodName());
                    long start = aResult.getStartMillis();
                    long duration = aResult.getEndMillis() - start;

                    // The first method per class shares a row with the class
                    // header
                    if (methodIndex > 0) {
                        buffer.append("<tr class=\"").append(cssClass).append("\">");

                    }
                    String testcaseResult=null;
                    if(aResult.getStatus()==1){
                        //System.out.println("For Pass Case -->" + aResult.getStatus());
                        testcaseResult=" bgcolor=\"#00cc00\">PASS";

                    }
                    if(aResult.getStatus()==2){
                        //System.out.println("For FAIL Case -->" + aResult.getStatus());
                        testcaseResult=" bgcolor=\"#ff3333\">FAIL";
                    }

                    // Write the timing information with the first scenario per method
                    buffer.append("<td><a href=\"#m").append(scenarioIndex).append("\">")
                            .append(methodName + "</a></td>")
                            //.append("<td rowspan=\"1\">" + aResult.getName() + "</td>")
                            .append("<td rowspan=\"").append(resultsCount).append("\">")
                            .append(parseUnixTimeToTimeOfDay(start)).append("</td>").append("<td rowspan=\"")
                            .append(resultsCount).append("\">")
                            .append(decimalFormat.format(millisecondsToSeconds(duration))).append("</td>")
                            .append("<td rowspan=\"").append(resultsCount).append("\"")
                            .append(testcaseResult)
                            .append("</td></tr>");
                    scenarioIndex++;

                    // Write the remaining scenarios for the method
                    for (int i = 1; i < resultsCount; i++) {
                        buffer.append("<tr class=\"").append(cssClass).append("\">").append("<td><a href=\"#m")
                                .append(scenarioIndex).append("\">").append(methodName + "</a></td>")
                                .append("<td rowspan=\"1\">" + aResult.getName() + "</td></tr>");
                        scenarioIndex++;
                    }

                    scenariosPerClass += resultsCount;
                    methodIndex++;
                }

                // Write the test results for the class
                writer.print("<tr class=\"");
                writer.print(cssClass);
                writer.print("\">");
                writer.print("<td rowspan=\"");
                writer.print(scenariosPerClass);
                writer.print("\">");
                writer.print(moduleName);
                writer.print("</td>");
                writer.print(buffer);

                classIndex++;
            }
            scenarioCount = scenarioIndex - startingScenarioIndex;
        }
        return scenarioCount;
    }

    /**
     * Writes the details for all test scenarios.
     */
    protected void writeScenarioDetails() {
        int scenarioIndex = 0;
        for (SuiteResult suiteResult : suiteResults) {
            for (TestResult testResult : suiteResult.getTestResults()) {
                if(testResult.passedTestCount>0){


                }
                else {
                    writer.print("<h2>");
                    writer.print(Utils.escapeHtml(testResult.getTestName()));
                    writer.print("</h2>");
                }
                scenarioIndex += writeScenarioDetails(testResult.getFailedConfigurationResults(), scenarioIndex);
                scenarioIndex += writeScenarioDetails(testResult.getFailedTestResults(), scenarioIndex);
                //scenarioIndex += writeScenarioDetails(testResult.getSkippedConfigurationResults(), scenarioIndex);
                //scenarioIndex += writeScenarioDetails(testResult.getSkippedTestResults(), scenarioIndex);
                //scenarioIndex += writeScenarioDetails(testResult.getPassedTestResults(), scenarioIndex);
            }
        }
    }

    /**
     * Writes the scenario details for the results of a given state for a single
     * test.
     */
    private int writeScenarioDetails(List<ClassResult> classResults, int startingScenarioIndex) {
        int scenarioIndex = startingScenarioIndex;
        for (ClassResult classResult : classResults) {
            String className = classResult.getClassName();
            for (MethodResult methodResult : classResult.getMethodResults()) {
                List<ITestResult> results = methodResult.getResults();
                assert !results.isEmpty();

                ITestResult mResult = results.iterator().next();
                String label = Utils.escapeHtml(
                        className + "#" + mResult.getMethod().getMethodName() + " ( " + mResult.getName() + " )");
                for (ITestResult result : results) {
                    writeScenario(scenarioIndex, label, result);
                    scenarioIndex++;
                }
            }
        }

        return scenarioIndex - startingScenarioIndex;
    }

    /**
     * Writes the details for an individual test scenario.
     */
    private void writeScenario(int scenarioIndex, String label, ITestResult result) {
        writer.print("<h3 id=\"m");
        writer.print(scenarioIndex);
        writer.print("\">");
        writer.print(label);
        writer.print("</h3>");

        writer.print("<table class=\"result\">");

        // Write test parameters (if any)
        Object[] parameters = result.getParameters();
        int parameterCount = (parameters == null ? 0 : parameters.length);
        if (parameterCount > 0) {
            writer.print("<tr class=\"param\">");
            for (int i = 1; i <= parameterCount; i++) {
                writer.print("<th>Parameter #");
                writer.print(i);
                writer.print("</th>");
            }
            writer.print("</tr><tr class=\"param stripe\">");
            for (Object parameter : parameters) {
                writer.print("<td>");
                writer.print(Utils.escapeHtml(Utils.toString(parameter, Object.class)));
                writer.print("</td>");
            }
            writer.print("</tr>");
        }

        // Write reporter messages (if any)
        List<String> reporterMessages = Reporter.getOutput(result);
        if (!reporterMessages.isEmpty()) {
            writer.print("<tr><th");
            if (parameterCount > 1) {
                writer.print(" colspan=\"");
                writer.print(parameterCount);
                writer.print("\"");
            }
            writer.print(">Messages</th></tr>");

            writer.print("<tr><td");
            if (parameterCount > 1) {
                writer.print(" colspan=\"");
                writer.print(parameterCount);
                writer.print("\"");
            }
            writer.print(">");
            writeReporterMessages(reporterMessages);
            writer.print("</td></tr>");
        }

        // Write exception (if any)
        Throwable throwable = result.getThrowable();
        if (throwable != null) {
            writer.print("<tr><th");
            if (parameterCount > 1) {
                writer.print(" colspan=\"");
                writer.print(parameterCount);
                writer.print("\"");
            }
            writer.print(">");
            writer.print((result.getStatus() == ITestResult.SUCCESS ? "Expected Exception" : "Exception"));
            writer.print("</th></tr>");

            writer.print("<tr><td");
            if (parameterCount > 1) {
                writer.print(" colspan=\"");
                writer.print(parameterCount);
                writer.print("\"");
            }
            writer.print(">");
            writeStackTrace(throwable);
            writer.print("</td></tr>");
        }

        writer.print("</table>");
        writer.print("<p class=\"totop\"><a href=\"#summary\">back to summary</a></p>");
    }

    protected void writeReporterMessages(List<String> reporterMessages) {
        writer.print("<div class=\"messages\">");
        Iterator<String> iterator = reporterMessages.iterator();
        assert iterator.hasNext();
        writer.print(Utils.escapeHtml(iterator.next()));
        while (iterator.hasNext()) {
            writer.print("<br/>");
            writer.print(Utils.escapeHtml(iterator.next()));
        }
        writer.print("</div>");
    }

    @SuppressWarnings("deprecation")
    protected void writeStackTrace(Throwable throwable) {
        writer.print("<div class=\"stacktrace\">");
        //Utils.stackTrace(throwable.getCause(), true)[0]
        writer.print(throwable);
        writer.print("</div>");
    }

    /**
     * Writes a TH element with the specified contents and CSS class names.
     *
     * @param html the HTML contents
     * @param cssClasses the space-delimited CSS classes or null if there are no
     * classes to apply
     */
    protected void writeTableHeader(String html, String cssClasses) {
        writeTag("th", html, cssClasses);
    }

    /**
     * Writes a TD element with the specified contents.
     *
     * @param html the HTML contents
     */
    protected void writeTableData(String html) {
        writeTableData(html, null);
    }

    /**
     * Writes a TD element with the specified contents and CSS class names.
     *
     * @param html the HTML contents
     * @param cssClasses the space-delimited CSS classes or null if there are no
     * classes to apply
     */
    protected void writeTableData(String html, String cssClasses) {
        writeTag("td", html, cssClasses);
    }

    /**
     * Writes an arbitrary HTML element with the specified contents and CSS class
     * names.
     *
     * @param tag the tag name
     * @param html the HTML contents
     * @param cssClasses the space-delimited CSS classes or null if there are no
     * classes to apply
     */
    protected void writeTag(String tag, String html, String cssClasses) {
        writer.print("<");
        writer.print(tag);
        if (cssClasses != null) {
            writer.print(" class=\"");
            writer.print(cssClasses);
            writer.print("\"");
        }
        writer.print(">");
        writer.print(html);
        writer.print("</");
        writer.print(tag);
        writer.print(">");
    }

    /**
     * Groups {@link TestResult}s by suite.
     */
    protected static class SuiteResult {
        private final String suiteName;
        private final List<TestResult> testResults = Lists.newArrayList();

        public SuiteResult(ISuite suite) {
            suiteName = suite.getName();
            for (ISuiteResult suiteResult : suite.getResults().values()) {
                testResults.add(new TestResult(suiteResult.getTestContext()));
            }
        }

        public String getSuiteName() {
            return suiteName;
        }

        /**
         * @return the test results (possibly empty)
         */
        public List<TestResult> getTestResults() {
            return testResults;
        }
    }

    /**
     * Groups {@link ClassResult}s by test, type (configuration or test), and
     * status.
     */
    protected static class TestResult {
        /**
         * Orders test results by class name and then by method name (in lexicographic
         * order).
         */
        protected static final Comparator<ITestResult> RESULT_COMPARATOR = new Comparator<ITestResult>() {
            @Override
            public int compare(ITestResult o1, ITestResult o2) {
                int result = o1.getTestClass().getName().compareTo(o2.getTestClass().getName());
                if (result == 0) {
                    result = o1.getMethod().getMethodName().compareTo(o2.getMethod().getMethodName());
                }
                return result;
            }
        };

        private final String testName;
        private final List<ClassResult> failedConfigurationResults;
        private final List<ClassResult> failedTestResults;
        private final List<ClassResult> skippedConfigurationResults;
        private final List<ClassResult> skippedTestResults;
        private final List<ClassResult> passedTestResults;
        private final int failedTestCount;
        private final int skippedTestCount;
        private final int passedTestCount;
        private final long duration;
        private final String includedGroups;
        private final String excludedGroups;

        public TestResult(ITestContext context) {
            testName = context.getName();

            Set<ITestResult> failedConfigurations = context.getFailedConfigurations().getAllResults();
            Set<ITestResult> failedTests = context.getFailedTests().getAllResults();
            Set<ITestResult> skippedConfigurations = context.getSkippedConfigurations().getAllResults();
            Set<ITestResult> skippedTests = context.getSkippedTests().getAllResults();
            Set<ITestResult> passedTests = context.getPassedTests().getAllResults();

            failedConfigurationResults = groupResults(failedConfigurations);
            failedTestResults = groupResults(failedTests);
            skippedConfigurationResults = groupResults(skippedConfigurations);
            skippedTestResults = groupResults(skippedTests);
            passedTestResults = groupResults(passedTests);

            failedTestCount = failedTests.size();
            skippedTestCount = skippedTests.size();
            passedTestCount = passedTests.size();

            duration = context.getEndDate().getTime() - context.getStartDate().getTime();

            includedGroups = formatGroups(context.getIncludedGroups());
            excludedGroups = formatGroups(context.getExcludedGroups());
        }

        /**
         * Groups test results by method and then by class.
         */
        protected List<ClassResult> groupResults(Set<ITestResult> results) {
            List<ClassResult> classResults = Lists.newArrayList();
            if (!results.isEmpty()) {
                List<MethodResult> resultsPerClass = Lists.newArrayList();
                List<ITestResult> resultsPerMethod = Lists.newArrayList();

                List<ITestResult> resultsList = Lists.newArrayList(results);
                Collections.sort(resultsList, RESULT_COMPARATOR);
                Iterator<ITestResult> resultsIterator = resultsList.iterator();
                assert resultsIterator.hasNext();

                ITestResult result = resultsIterator.next();
                resultsPerMethod.add(result);

                String previousClassName = result.getTestClass().getName();
                String previousMethodName = result.getMethod().getMethodName();
                while (resultsIterator.hasNext()) {
                    result = resultsIterator.next();

                    String className = result.getTestClass().getName();
                    if (!previousClassName.equals(className)) {
                        // Different class implies different method
                        assert !resultsPerMethod.isEmpty();
                        resultsPerClass.add(new MethodResult(resultsPerMethod));
                        resultsPerMethod = Lists.newArrayList();

                        assert !resultsPerClass.isEmpty();
                        classResults.add(new ClassResult(previousClassName, resultsPerClass));
                        resultsPerClass = Lists.newArrayList();

                        previousClassName = className;
                        previousMethodName = result.getMethod().getMethodName();
                    } else {
                        String methodName = result.getMethod().getMethodName();
                        if (!previousMethodName.equals(methodName)) {
                            assert !resultsPerMethod.isEmpty();
                            resultsPerClass.add(new MethodResult(resultsPerMethod));
                            resultsPerMethod = Lists.newArrayList();

                            previousMethodName = methodName;
                        }
                    }
                    resultsPerMethod.add(result);
                }
                assert !resultsPerMethod.isEmpty();
                resultsPerClass.add(new MethodResult(resultsPerMethod));
                assert !resultsPerClass.isEmpty();
                classResults.add(new ClassResult(previousClassName, resultsPerClass));
            }
            return classResults;
        }

        public String getTestName() {
            return testName;
        }

        /**
         * @return the results for failed configurations (possibly empty)
         */
        public List<ClassResult> getFailedConfigurationResults() {
            return failedConfigurationResults;
        }

        /**
         * @return the results for failed tests (possibly empty)
         */
        public List<ClassResult> getFailedTestResults() {
            return failedTestResults;
        }

        /**
         * @return the results for skipped configurations (possibly empty)
         */
        public List<ClassResult> getSkippedConfigurationResults() {
            return skippedConfigurationResults;
        }

        /**
         * @return the results for skipped tests (possibly empty)
         */
        public List<ClassResult> getSkippedTestResults() {
            return skippedTestResults;
        }

        /**
         * @return the results for passed tests (possibly empty)
         */
        public List<ClassResult> getPassedTestResults() {
            return passedTestResults;
        }

        public int getFailedTestCount() {
            return failedTestCount;
        }

        public int getSkippedTestCount() {
            return skippedTestCount;
        }

        public int getPassedTestCount() {
            return passedTestCount;
        }

        public long getDuration() {
            return duration;
        }

        public String getIncludedGroups() {
            return includedGroups;
        }

        public String getExcludedGroups() {
            return excludedGroups;
        }

        public void reportSend() {

        }

        /**
         * Formats an array of groups for display.
         */
        protected String formatGroups(String[] groups) {
            if (groups.length == 0) {
                return "";
            }

            StringBuilder builder = new StringBuilder();
            builder.append(groups[0]);
            for (int i = 1; i < groups.length; i++) {
                builder.append(", ").append(groups[i]);
            }
            return builder.toString();
        }
    }

    /**
     * Groups {@link MethodResult}s by class.
     */
    protected static class ClassResult {
        private final String className;
        private final List<MethodResult> methodResults;

        /**
         * @param className the class name
         * @param methodResults the non-null, non-empty {@link MethodResult} list
         */
        public ClassResult(String className, List<MethodResult> methodResults) {
            this.className = className;
            this.methodResults = methodResults;
        }

        public String getClassName() {
            return className;
        }

        /**
         * @return the non-null, non-empty {@link MethodResult} list
         */
        public List<MethodResult> getMethodResults() {
            return methodResults;
        }
    }

    /**
     * Groups test results by method.
     */
    protected static class MethodResult {
        private final List<ITestResult> results;

        /**
         * @param results the non-null, non-empty result list
         */
        public MethodResult(List<ITestResult> results) {
            this.results = results;
        }

        /**
         * @return the non-null, non-empty result list
         */
        public List<ITestResult> getResults() {
            return results;
        }
    }

    /*
     * Methods to improve time display on report
     */
    protected String getDateAsString() {
        Date date = new Date();
        sdfdate.setTimeZone(TimeZone.getTimeZone(timeZone));
        return sdfdate.format(date);
    }

    protected String parseUnixTimeToTimeOfDay(long unixSeconds) {
        Date date = new Date(unixSeconds);
        sdftime.setTimeZone(TimeZone.getTimeZone(timeZone));
        return sdftime.format(date);
    }

    protected double millisecondsToSeconds(long ms) {
        return new BigDecimal(ms / 1000.00).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    protected void convertInToModule(Map<String, List<String>> resultMap) {

        for (String key : resultMap.keySet()) {
            String moduleName = key.substring(0, key.lastIndexOf("."));
            if (!testModuleResults.keySet().contains(moduleName)) {
                String lengthResult = resultMap.get(key).get(0);

                List<Integer> moduleResultinfo = new ArrayList<>(3);

                if (lengthResult.substring(lengthResult.lastIndexOf(":") + 1, lengthResult.length()).equals("PASS")) {

                    int total = Integer.parseInt(lengthResult.substring(0, lengthResult.lastIndexOf(":")));
                    int duration = Integer.parseInt(resultMap.get(key).get(1));
                    //List<Integer> moduleResultinfo = new ArrayList<>();
                    moduleResultinfo.add(0, total);
                    moduleResultinfo.add(1, 0);
                    moduleResultinfo.add(2, duration);

                    //moduleResultinfo.add(0, resultMap.get(key).get(0).substring(0, resultMap.get(key).get(0).lastIndexOf(":")));
                    testModuleResults.put(moduleName, moduleResultinfo);
                }

                if (lengthResult.substring(lengthResult.lastIndexOf(":") + 1, lengthResult.length()).equals("FAIL")) {

                    int total = Integer.parseInt(lengthResult.substring(0, lengthResult.lastIndexOf(":")));
                    int duration = Integer.parseInt(resultMap.get(key).get(1));
                    moduleResultinfo.add(0, 0);
                    moduleResultinfo.add(1, total);
                    moduleResultinfo.add(2, duration);
                    //moduleResultinfo.add(0, resultMap.get(key).get(0).substring(0, resultMap.get(key).get(0).lastIndexOf(":")));
                    testModuleResults.put(moduleName, moduleResultinfo);
                }


            } else {
                String lengthResult = resultMap.get(key).get(0);
                //List<Integer> moduleResultinfo = new ArrayList<>(3);
                if (lengthResult.substring(lengthResult.lastIndexOf(":")+1, lengthResult.length()).equals("PASS")) {
                    List<Integer> moduleResultinfo = new ArrayList<>(3);
                    int duration = testModuleResults.get(moduleName).get(2) + Integer.parseInt(resultMap.get(key).get(1));
                    int tcCount = Integer.parseInt(lengthResult.substring(0, lengthResult.lastIndexOf(":")));
                    int passCount = testModuleResults.get(moduleName).get(0) + tcCount;
                    int failCount = testModuleResults.get(moduleName).get(1);

                    moduleResultinfo.add(0,passCount );
                    moduleResultinfo.add(1, failCount);
                    moduleResultinfo.add(2, duration);
                    testModuleResults.put(moduleName, moduleResultinfo);
                    //moduleResultinfo.add(0, passCount);
                    //moduleResultinfo.add(0, resultMap.get(key).get(0).substring(0, resultMap.get(key).get(0).lastIndexOf(":")));
                    //testModuleResults.put(moduleName, testModuleResults);
                }

                if (lengthResult.substring(lengthResult.lastIndexOf(":")+1, lengthResult.length()).equals("FAIL")) {
                    List<Integer> moduleResultinfo = new ArrayList<>(3);
                    int duration = testModuleResults.get(moduleName).get(2) + Integer.parseInt(resultMap.get(key).get(1));
                    int tcCount = Integer.parseInt(lengthResult.substring(0, lengthResult.lastIndexOf(":")));
                    int passCount = testModuleResults.get(moduleName).get(0) ;
                    int failCount = testModuleResults.get(moduleName).get(1) + tcCount;
                    moduleResultinfo.add(0,passCount );
                    moduleResultinfo.add(1, failCount);
                    moduleResultinfo.add(2, duration);
                    testModuleResults.put(moduleName, moduleResultinfo);
                }


            }




        }


    }

    public static String formatSeconds(int timeInSeconds)
    {
        int secondsLeft = timeInSeconds % 3600 % 60;
        int minutes = (int) Math.floor(timeInSeconds % 3600 / 60);
        int hours = (int) Math.floor(timeInSeconds / 3600);

        String HH = ((hours       < 10) ? "0" : "") + hours;
        String MM = ((minutes     < 10) ? "0" : "") + minutes;
        String SS = ((secondsLeft < 10) ? "0" : "") + secondsLeft;

        return HH + ":" + MM + ":" + SS;
    }

}

