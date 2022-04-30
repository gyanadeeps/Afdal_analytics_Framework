package engine.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class EdgeRemoteDriverProvider implements RemoteDriver {
    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        WebDriver driver = instantiateDriver(DesiredCapabilities.edge());
        return driver;
    }
}
