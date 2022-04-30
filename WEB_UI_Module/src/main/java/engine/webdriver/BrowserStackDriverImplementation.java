package engine.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserStackDriverImplementation implements BrowserStackDriver{
    @Override
    public WebDriver instantiateEdgeDriver(DesiredCapabilities caps) {
        return BrowserStackDriver.super.instantiateEdgeDriver(caps);
    }

    @Override
    public WebDriver instantiateSafariDriver(DesiredCapabilities caps) {
        return BrowserStackDriver.super.instantiateSafariDriver(caps);
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        return null;
    }
}
