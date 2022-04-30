package engine.webdriver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxRemoteDriverProvider implements RemoteDriver {

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, getFirefoxOptions());
        return instantiateDriver(capabilities);
    }

    private FirefoxOptions getFirefoxOptions() {
        FirefoxProfile profile = new FirefoxProfile();

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--window-size=1920,1080");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        options.setAcceptInsecureCerts(true);

        options.setProfile(profile).setLegacy(false).setPageLoadStrategy(PageLoadStrategy.NORMAL);

        return options;
    }
}
