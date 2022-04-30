package utilities;

import com.codeborne.selenide.Command;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeleniumUtils {

    public static void dragAndDrop(SelenideElement from, SelenideElement to) {
        new Actions(WebDriverRunner.getWebDriver())
                .clickAndHold((from.scrollIntoView(false)))
                .moveToElement(to)
                .click(to).perform();
    }


    public static Command<SelenideElement> jsClick() {
        return ((proxy, locator, args) -> {
            Selenide.executeJavaScript("arguments[0].click()", proxy);
            Selenide.sleep(2000);
            return proxy;
        });
    }

    public static void switchToNewTab(int totalNoOfWindows) {
        try {
            WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 10);
            wait.until(ExpectedConditions.numberOfWindowsToBe(totalNoOfWindows));
            String currentTab = WebDriverRunner.getWebDriver().getWindowHandle();
            for (String handle : WebDriverRunner.getWebDriver().getWindowHandles()) {
                if (!handle.equals(currentTab)) {
                    WebDriverRunner.getWebDriver().switchTo().window(handle);
                }
            }
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
    }

    public static void closeCurrentTab() {
        WebDriver driver = WebDriverRunner.getWebDriver();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    public static String getUrl() {

        Pattern p = Pattern.compile("((http|ftp|https):\\/\\/)?(([\\w.-]*))\\.com");
        Matcher m = p.matcher("");
        if (m.find()) {
            return m.group();
        }
        return "https://ivp-dit0.lightning.force.com/";
    }
}