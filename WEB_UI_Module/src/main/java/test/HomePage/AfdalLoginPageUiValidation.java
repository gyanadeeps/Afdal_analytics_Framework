package test.HomePage;

import BaseClasses.AfdalAnalyticsBaseTest;
import ImplementationClasses.AfdalAnalyticsSignInImpl;
import org.testng.annotations.Test;



public class AfdalLoginPageUiValidation extends AfdalAnalyticsBaseTest
{
    @Test(description = "Verify Login Page")
    public void verifyLoginPage_Arabic()
    {

        add(new AfdalAnalyticsSignInImpl()).trigger();
    }


}
