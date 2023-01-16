package ImplementationClasses;

import BaseClasses.AfdalAnalyticsLoginPage;
import BaseClasses.Feature;
import pageobjects.pages.IAfdalAnalyticsSignInPage;

public class AfdalAnalyticsSignUpArImpl extends AfdalAnalyticsLoginPage implements Feature {

    private IAfdalAnalyticsSignInPage homePage;
    @Override
    public void init()
    {

        homePage = openAfdalAnalticsPage();
    }

    @Override
    public void execute() {
        try {

            homePage.Switch_to_SignUp_Page()
                    .Sign_Up_Ar_Verify_Ui()
                    .Sign_Up_Verify_All_Fields_Empty()
                    //.Sign_Up_Verify_Valid_phone_No()
                    //.Sign_Up_With_Valid_Gmail()
                    .Sign_Up_With_Valid_Email()
                    .SignUp_With_Valid_Gmail_By_Close_the_Popup_N();





        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
