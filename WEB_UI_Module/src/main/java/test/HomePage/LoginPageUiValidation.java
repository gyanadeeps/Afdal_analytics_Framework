package test.HomePage;

import BaseClasses.AfdalAnalyticsBaseTest;
import ImplementationClasses.AfdalAnalyticsSignInImpl;
import org.testng.annotations.Test;



public class LoginPageUiValidation extends AfdalAnalyticsBaseTest
{
    @Test(description = "Verify Login Page")
    public void verifyHomePage()
    {

        add(new AfdalAnalyticsSignInImpl()).trigger();
    }


}
