package test.HomePage;

import BaseClasses.AfdalAnalyticsBaseTest;
import ImplementationClasses.AfdalAnalyticsSignInImpl;
import ImplementationClasses.AfdalAnalyticsSignUpImpl;
import org.testng.annotations.Test;

public class AfdalSignupPageValidation extends AfdalAnalyticsBaseTest {

    @Test(description = "Verify Signup Page")
    public void verifySignupPage_Arabic() {



        add(new AfdalAnalyticsSignUpImpl()).trigger();
    }

}
