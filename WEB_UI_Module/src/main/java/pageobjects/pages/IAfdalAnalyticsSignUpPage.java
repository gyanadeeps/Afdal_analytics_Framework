package pageobjects.pages;public interface IAfdalAnalyticsSignUpPage {
    IAfdalAnalyticsSignUpPage Signup_Verify_UI();


    IAfdalAnalyticsSignUpPage SignUp_with_all_filed_empty_N();
    IAfdalAnalyticsSignUpPage SignUp_with_valid_data() throws InterruptedException;
    //
    IAfdalAnalyticsSignUpPage SignUp_Enter_all_data_Except_Companyname_N();

    IAfdalAnalyticsSignUpPage SignUp_Enter_all_data_Except_Position_N();
    IAfdalAnalyticsSignUpPage SignUp_Enter_all_data_Except_Email_N();
    IAfdalAnalyticsSignUpPage SignUp_Enter_all_data_Except_Firstname_N() throws InterruptedException;
    IAfdalAnalyticsSignUpPage SignUp_Enter_all_data_Except_Lastname_N();
    IAfdalAnalyticsSignUpPage Email_validation_N() throws InterruptedException;
    IAfdalAnalyticsSignUpPage Password_validation_N() throws InterruptedException;
//    IAfdalAnalyticsSignUpPage SignUp_without_checking_Afdal_terms_checkbox_N();
//    IAfdalAnalyticsSignUpPage SignUp_checking_Afdal_terms_with_checkbox() throws InterruptedException;


    IAfdalAnalyticsSignUpPage SignUp_without_checking_Afdal_terms_checkbox_N();

    IAfdalAnalyticsSignUpPage SignUp_checking_Afdal_terms_with_checkbox() throws InterruptedException;

    IAfdalAnalyticsSignUpPage Click_on_SignIn() throws InterruptedException;

    IAfdalAnalyticsSignUpPage SignUp_with_google_N() throws InterruptedException;

    IAfdalAnalyticsSignUpPage SignUp_with_linkedIn_N() throws InterruptedException;

    IAfdalAnalyticsSignUpPage SignUp_with_apple_N() throws InterruptedException;


    IAfdalAnalyticsSignUpPage verifyTwitterIcon() throws InterruptedException;


    // Instagram Icon Button.....
    IAfdalAnalyticsSignUpPage verifyInstagramIcon() throws InterruptedException;

    // Facebook Icon Button.....
    IAfdalAnalyticsSignUpPage verifyFacebookIcon() throws InterruptedException;

    // LinkedIn Icon Button.....
    IAfdalAnalyticsSignUpPage verifyLinkedInIcon() throws InterruptedException;


}
