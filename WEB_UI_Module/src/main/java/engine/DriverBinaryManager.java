package engine;

import engine.webdriver.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.safari.SafariDriver;
import utilities.EnumUtil;

import static data.SystemProperties.DRIVER_TYPE;

public final class DriverBinaryManager {
    public static String browserVersion=null;

    public static void setupWebDriverBinary() {
        DriverType driver = EnumUtil.searchEnum(DriverType.class, e -> e.name().equals(DRIVER_TYPE), DRIVER_TYPE);


        switch (driver) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                browserVersion=WebDriverManager.chromedriver().getDownloadedVersion();
                break;

            case FF:
                WebDriverManager.firefoxdriver().setup();
                browserVersion=WebDriverManager.firefoxdriver().getDownloadedVersion();
                break;

            case IE:
                WebDriverManager.iedriver().setup();
                browserVersion=WebDriverManager.iedriver().getDownloadedVersion();
                break;

            case EDGE:
                WebDriverManager.edgedriver().setup();
                browserVersion=WebDriverManager.edgedriver().getDownloadedVersion();
                break;
            case SAFARI:
                 new SafariDriver();


            default:
                throw new IllegalArgumentException(String.format("No implementation for provided driver type: " +
                        "Driver Type[%s]", DRIVER_TYPE));
        }
    }


}