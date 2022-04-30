package engine;

import com.codeborne.selenide.WebDriverRunner;
import lombok.extern.java.Log;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@Log
public final class DriverUtils {

    private static final String SESSION_TIMED_OUT_OR_NOT_FOUND = "Session timed out or not found";

    public static void stop() {
        log.info(String.format("Trying to get screenshot before closing WebDriver [%s]", getCurrentThreadId()));
        log.info("Get count for threads" + Thread.activeCount());
        log.info(String.format("Trying to close WebDriver in thread [%s]", getCurrentThreadId()));
        try {
            WebDriverRunner.closeWebDriver();
            log.info(String.format("Closed WebDriver in thread [%s]", getCurrentThreadId()));
        } catch (WebDriverException e) {
            if (e.getMessage().contains(SESSION_TIMED_OUT_OR_NOT_FOUND)) {
                log.info(Arrays.toString(Thread.currentThread().getStackTrace()));
                log.info(String.format("Was not able to close WebDriver in thread [%s] because [%s]",
                        getCurrentThreadId(), SESSION_TIMED_OUT_OR_NOT_FOUND));
            } else {
                throw e;
            }
        }
        log.info("WebDriver successfully closed");
    }

    private static long getCurrentThreadId() {
        return Thread.currentThread().getId();
    }

    public static String getScreenshot() {
        log.info(String.format("Trying to get screenshot in thread [%s]", getCurrentThreadId()));
        if (WebDriverRunner.hasWebDriverStarted()) {
            log.info(String.format("WebDriver is opened in thread [%s], trying to get screenshot", getCurrentThreadId()));
            String screenshotBase64;
            try {
                screenshotBase64 = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BASE64);
            } catch (WebDriverException e) {
                if (e.getMessage().contains(SESSION_TIMED_OUT_OR_NOT_FOUND)) {
                    log.info(String.format("Was not able to get screenshot in thread [%s] because [%s]",
                            getCurrentThreadId(), SESSION_TIMED_OUT_OR_NOT_FOUND));
                    screenshotBase64 = SESSION_TIMED_OUT_OR_NOT_FOUND;
                } else {
                    throw e;
                }
            }
            log.info(String.format("Successfully got screenshot in thread [%s]", getCurrentThreadId()));
            return screenshotBase64;
        } else {
            log.info(String.format("WebDriver is not opened in thread [%s], returning empty screenshot", getCurrentThreadId()));
            return "No ScreenShot taken.";
        }
    }

    public synchronized static String screenShotEmbedHtml(String screenshot){
        String html=null;
        screenshot=getScreenshot();
        html=  "<a href=\"data:image/png;base64,"+screenshot+"\" data-featherlight=\"image\"><span class=\"label grey badge white-text text-white\">Screenshot-img</span></a>\n" ;
        return html;
    }
    public static void getScreenshotFile(String fileWithPath) {
        log.info(String.format("Trying to get screenshot in thread [%s]", getCurrentThreadId()));
        if (WebDriverRunner.hasWebDriverStarted()) {
            log.info(String.format("WebDriver is opened in thread [%s], trying to get screenshot", getCurrentThreadId()));
            File SrcFile;
            try {
               SrcFile = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.FILE);
                File DestFile=new File(fileWithPath);
                FileUtils.copyFile(SrcFile, DestFile);

            } catch (WebDriverException | IOException e) {



                }

            log.info(String.format("Successfully got screenshot in thread [%s]", getCurrentThreadId()));

        } else
        {

        }


    }

}