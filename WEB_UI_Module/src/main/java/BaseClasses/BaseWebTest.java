package BaseClasses;


import Reporting.ExtentManager;
import Reporting.ExtentTestManager;
import com.codeborne.selenide.WebDriverRunner;
import engine.DriverBinaryManager;
import engine.DriverConfigurator;
import engine.DriverUtils;
import engine.webdriver.BrowserStackDriverImplementation;
import lombok.extern.java.Log;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.AllureListener;
import utilities.TestListener;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static data.SystemProperties.*;
import static java.lang.System.getProperties;

@Log
@Listeners({TestListener.class, AllureListener.class})
public class BaseWebTest {
    private final static ConcurrentMap<String, Object> ENV_PROPERTIES = new ConcurrentHashMap<>();
    DesiredCapabilities cap=new DesiredCapabilities();
    BrowserStackDriverImplementation a=new BrowserStackDriverImplementation();




    @BeforeTest
    protected void beforeSuite(ITestContext context)
    {
       new ExtentManager().createInstance();


            DriverBinaryManager.setupWebDriverBinary();

            //System.out.println("Suite Name --> "+ SUITENAME);
            System.out.println("URL Name --> " + AFDALANALYTICS_URL);
        }







    @BeforeMethod(description = "Initialize web driver configuration")
    protected void beforeMethod(Method method) {
        //System.out.println("Driver Type --> "+ DRIVER_TYPE);
            DriverConfigurator.configure(DRIVER_TYPE);


    }

    @AfterMethod(alwaysRun = true, description = "Close driver")
    protected void tearDown(Method method, ITestResult testResult, ITestContext testContext) {
        if(testResult.getStatus()==3) {
            ExtentTestManager.getTest().getExtent().removeTest(ExtentTestManager.getTest());
            testContext.getFailedTests().removeResult(testResult);

        }
        else {
            ExtentTestManager.endTest(ExtentTestManager.getTest());
        }
        if (ENV_PROPERTIES.isEmpty()) {
            ENV_PROPERTIES.put("java_version", getProperties().getProperty("java.vm.version"));
            ENV_PROPERTIES.put("os_name", getProperties().getProperty("os.name"));
            ENV_PROPERTIES.put("github_user_email", getProperties().getProperty("github_user_email", "Github User Email not found"));
            ENV_PROPERTIES.put("github_user_name", getProperties().getProperty("github_user_name", "Github User Name not found"));
            ENV_PROPERTIES.put("URL", AFDALANALYTICS_URL);
            ENV_PROPERTIES.putAll(((RemoteWebDriver) WebDriverRunner.getWebDriver()).getCapabilities().asMap());
        }
        SessionId sessionid = ((RemoteWebDriver) WebDriverRunner.getWebDriver()).getSessionId();
        log.info("Session is -> " + sessionid);
        System.out.println(LocalDateTime.now());
        DriverUtils.stop();


    }

    @AfterSuite(alwaysRun = true)
    protected void afterSuite() {

        try {



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    @AfterClass
//    public void mobileTearDown() throws IOException
//    {
//        driver.quit();
//
//    }

    @AfterTest
    public void getReport() throws IOException
    {
        System.out.println("After test");
//        String command="copy";
//        try {
//            Process process = Runtime.getRuntime().exec("D:\\Web_API_Mobile_framework\\copy.bat");
//            System.out.println("the output stream is "+process.getOutputStream());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
