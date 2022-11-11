package test.HomePage;

import BaseClasses.AfdalAnalyticsBaseTest;
import ImplementationClasses.AfdalAnalyticsSignInImpl;
import ImplementationClasses.AfdalAnalyticsSignUpImpl;
import org.testng.annotations.Test;

public class AfdalSignupPageValidation extends AfdalAnalyticsBaseTest {

    @Test(description = "Verify Login Page")
    public void verifySignupPage() {



        add(new AfdalAnalyticsSignUpImpl()).trigger();
    }

}
