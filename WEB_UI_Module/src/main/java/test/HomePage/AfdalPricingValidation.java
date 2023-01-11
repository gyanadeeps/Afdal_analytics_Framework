package test.HomePage;

import BaseClasses.AfdalAnalyticsBaseTest;
import ImplementationClasses.AfdalAnalyticsPricingImpl;
import org.testng.annotations.Test;

public class AfdalPricingValidation extends AfdalAnalyticsBaseTest {
    @Test(description = "Verify Pricing Page")
    public void verifyPricing_Arabic() {

        add(new AfdalAnalyticsPricingImpl()).trigger();
    }
}
