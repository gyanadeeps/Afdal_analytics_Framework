package engine;

import com.codeborne.selenide.Configuration;
import engine.webdriver.*;
import utilities.EnumUtil;

import java.time.Duration;

import static data.SystemProperties.DRIVER_TYPE;
import static data.SystemProperties.REMOTE_DRIVER_STATUS;

public final class DriverConfigurator {


    public static void configure(String driverType) {
        Configuration.timeout = Duration.ofSeconds(10).toMillis();
        Configuration.startMaximized = true;
        Configuration.reopenBrowserOnFail = true;
        Configuration.savePageSource = false;
        Configuration.screenshots = false;
        Configuration.pageLoadStrategy= "normal";
        Configuration.browser=  getDriverClassName(driverType);
    }

    private static String getDriverClassName(String driverType) {
        RemoteDriverState remoteDriverStatus = EnumUtil.searchEnum(RemoteDriverState.class, e -> e.name().equals(REMOTE_DRIVER_STATUS), REMOTE_DRIVER_STATUS);
        DriverType driver = EnumUtil.searchEnum(DriverType.class, e -> e.name().equals(driverType), driverType);

        switch (remoteDriverStatus) {
            case DISABLED: {
                switch (driver) {
                    case CHROME:
                        //System.out.print("IN CHROM CONFIG --> " + driverType);
                        return ChromeDriverProvider.class.getName();

                    case FF:
                        return FirefoxDriverProvider.class.getName();

                    case IE:
                        return IEDriverProvider.class.getName();

                    case EDGE:
                        return EdgeDriverProvider.class.getName();

                    case SAFARI:
                        return EdgeDriverProvider.class.getName();

                    default:
                        throw new IllegalArgumentException(String.format("No valid implementation for provided driver type: " +
                                "Driver Type[%s]", DRIVER_TYPE));

                }

            }

            case ENABLED: {
                switch (driver) {
                    case CHROME:
                        return ChromeRemoteDriverProvider.class.getName();

                    case FF:
                        return FirefoxRemoteDriverProvider.class.getName();

                    case EDGE:
                        return EdgeRemoteDriverProvider.class.getName();

                    default:
                        throw new IllegalArgumentException(String.format("No valid implementation for provided driver type: " +
                                "Driver Type[%s]", DRIVER_TYPE));

                }
            }

            default:
                throw new IllegalArgumentException(String.format("No valid status for Remote Driver is provided: " +
                        "Remote driver Status[%s]", REMOTE_DRIVER_STATUS));


        }
    }
}
