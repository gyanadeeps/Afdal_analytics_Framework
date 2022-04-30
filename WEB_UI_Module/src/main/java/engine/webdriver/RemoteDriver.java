package engine.webdriver;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static data.SystemProperties.REMOTE_URL;

interface RemoteDriver extends WebDriverProvider {

    default WebDriver instantiateDriver(DesiredCapabilities capabilities) {
        capabilities.setCapability("enableVNC", false);
        capabilities.setCapability("enableVideo", false);
        //Cookie cookie1 = new Cookie.Builder("key", "value").sameSite("Lax").build();
        if (REMOTE_URL == null) {
            throw new IllegalArgumentException("Remote URL can not be null");
        }
        try {
            RemoteWebDriver remoteWebDriver = new RemoteWebDriver(new URL(REMOTE_URL), capabilities);
            remoteWebDriver.setFileDetector(new LocalFileDetector());
            return remoteWebDriver;

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}

/*interface RemoteDriver extends WebDriverProvider {

    default WebDriver instantiateDriver(DesiredCapabilities capabilities) {
        final String REMOTE_DRIVER_URL_PROPERTY = "driver.remote.url";
        capabilities.setCapability("enableVNC", false);
        capabilities.setCapability("enableVideo", false);
        //Cookie cookie1 = new Cookie.Builder("key", "value").sameSite("Lax").build();
        if (REMOTE_URL == null) {
            throw new IllegalArgumentException("Remote URL can not be null");
        }
        try {
            *//*RemoteWebDriver remoteWebDriver = new RemoteWebDriver(new URL(REMOTE_URL), capabilities);
            remoteWebDriver.setFileDetector(new LocalFileDetector());*//*

            String remoteDriverUrl = System.getProperty(REMOTE_DRIVER_URL_PROPERTY);
            capabilities.setBrowserName("chrome");
            //capabilities.setBrowserName("MicrosoftEdge");
            //capabilities.setBrowserName("firefox");
            WebDriver driver = new RemoteWebDriver(URI.create(remoteDriverUrl).toURL(), capabilities);
            return driver;

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}*/
