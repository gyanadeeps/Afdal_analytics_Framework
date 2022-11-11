package ImplementationClasses;


import BaseClasses.AfdalAnalyticsSignupPage;
import BaseClasses.Feature;
import pageobjects.pages.IAfdalAnalyticsSignUpPage;

public class AfdalAnalyticsSignUpImpl extends AfdalAnalyticsSignupPage implements Feature {


    private IAfdalAnalyticsSignUpPage homePage;
    @Override
    public void init() {


        homePage = openAfdalAnalyticsPage();


    }

    @Override
    public void execute() {

        try {

            homePage.Signup_Verify_UI();
            homePage.SignUp_with_all_filed_empty_N();
            homePage.SignUp_with_valid_data();
            homePage.SignUp_Enter_all_data_Except_Companyname_N();
            homePage.SignUp_Enter_all_data_Except_Position_N();
            homePage.SignUp_Enter_all_data_Except_Email_N();
            homePage.SignUp_Enter_all_data_Except_Firstname_N();
            homePage.SignUp_Enter_all_data_Except_Lastname_N();
            homePage.Email_validation_N();
            homePage.Password_validation_N();
            homePage.Click_on_SignIn();
            homePage.SignUp_with_google_N();
            homePage.SignUp_with_apple_N();
            homePage.SignUp_with_linkedIn_N();
            homePage.verifyTwitterIcon();
            homePage.verifyInstagramIcon();
            homePage.verifyFacebookIcon();

            homePage.verifyLinkedInIcon();


        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }


}
