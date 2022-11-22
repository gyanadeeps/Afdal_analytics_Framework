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


            homePage.SignUp_with_all_filed_empty_N();
            homePage.Signup_Verify_UI();
            homePage.SignUp_with_valid_data();
            homePage.SignUp_Enter_all_data_Except_Companyname_N();
            homePage.SignUp_Enter_all_data_Except_Position_N();
            homePage.SignUp_Enter_all_data_Except_Email_N();
            homePage.SignUp_Enter_all_data_Except_Firstname_N();
            homePage.SignUp_Enter_all_data_Except_Lastname_N();
            homePage.Email_validation_N();
            homePage.Password_validation_N();
            homePage.SignUp_without_checking_Afdal_terms_checkbox_N();
            homePage.SignUp_checking_Afdal_terms_with_checkbox();
            homePage.SignUp_with_google_N();
            homePage.SignUp_with_apple_N();
            homePage.SignUp_with_linkedIn_N();
            homePage.verifyFacebookIcon();
            homePage.verifyInstagramIcon();
            homePage.verifyFacebookIcon();
            homePage.verifyTwitterIcon();


        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }


}
