package test.HomePage;

import BaseClasses.AfdalAnalyticsBaseTest;
import ImplementationClasses.AfdalAnalyticsSettingsImpl;
import org.testng.annotations.Test;


    public class AfdalSettingsValidation extends AfdalAnalyticsBaseTest {
        @Test(description = "Verify Settings Page")
        public void verifySettings_Arabic() {

            add(new AfdalAnalyticsSettingsImpl()).trigger();
        }
    }

