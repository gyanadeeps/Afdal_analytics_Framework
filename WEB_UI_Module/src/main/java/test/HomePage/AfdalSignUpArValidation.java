package test.HomePage;

import BaseClasses.AfdalAnalyticsBaseTest;

import ImplementationClasses.AfdalAnalyticsSignUpArImpl;
import org.testng.annotations.Test;

public class AfdalSignUpArValidation extends AfdalAnalyticsBaseTest{
        @Test(description = "Verify SignUp Button")
        public void verifySignUpPage_Arabic() {

            add(new AfdalAnalyticsSignUpArImpl()).trigger();
        }
    }

