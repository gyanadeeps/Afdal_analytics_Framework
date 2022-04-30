package engine.webdriver;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static data.SystemProperties.REMOTE_URL;

public interface BrowserStackDriver extends WebDriverProvider {

    default WebDriver instantiateEdgeDriver(DesiredCapabilities caps)
    {
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Edge");
        caps.setCapability("name", "EcloudMs"); // test name
        caps.setCapability("browserstack.local", "false");
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability(" browserstack.video", "false");

        //Cookie cookie1 = new Cookie.Builder("key", "value").sameSite("Lax").build();
        if (REMOTE_URL == null) {
            throw new IllegalArgumentException("Remote URL can not be null");
        }
        try {
            RemoteWebDriver remoteWebDriver = new RemoteWebDriver(new URL(REMOTE_URL), caps);
            remoteWebDriver.setFileDetector(new LocalFileDetector());
            return remoteWebDriver;

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
    default WebDriver instantiateSafariDriver(DesiredCapabilities caps) {
        caps.setCapability("os", "OS X");
        caps.setCapability("os_version", "Big Sur");
        caps.setCapability("name", "EcloudMs");
        caps.setCapability("browser", "Safari");
        caps.setCapability("browser_version", "14.0");
        caps.setCapability("browserstack.local", "false");

        //Cookie cookie1 = new Cookie.Builder("key", "value").sameSite("Lax").build();
        if (REMOTE_URL == null) {
            throw new IllegalArgumentException("Remote URL can not be null");
        }
        try {
            RemoteWebDriver remoteWebDriver = new RemoteWebDriver(new URL(REMOTE_URL), caps);
            remoteWebDriver.setFileDetector(new LocalFileDetector());
            return remoteWebDriver;

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }


    }
}
