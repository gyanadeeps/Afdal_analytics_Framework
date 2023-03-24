package pageobjects.pages;

public interface IAfdalAnalyticsSignUpArPage {

    IAfdalAnalyticsSignUpArPage Sign_Up_Ar_Verify_Ui();
    IAfdalAnalyticsSignUpArPage SignUp_Check_Already_have_an_account_Sign_in_BTN();

    IAfdalAnalyticsSignUpArPage Sign_Up_Verify_All_Fields_Empty() throws InterruptedException;

    IAfdalAnalyticsSignUpArPage Sign_Up_Verify_Valid_phone_No() throws InterruptedException;

    IAfdalAnalyticsSignUpArPage Sign_Up_With_Valid_Gmail() throws InterruptedException;

    IAfdalAnalyticsSignUpArPage Sign_Up_With_Valid_LinkedIN() throws InterruptedException;

    IAfdalAnalyticsSignUpArPage Sign_Up_With_Valid_Email() throws InterruptedException;

    IAfdalAnalyticsSignUpArPage SignUp_With_Valid_Gmail_By_Close_the_Popup_N() throws InterruptedException;
    IAfdalAnalyticsSignUpArPage SignUp_With_Valid_PhoneNo_Without_Checked_afdal_terms_checkbox_N();
    IAfdalAnalyticsSignUpArPage SignUp_With_Valid_Email_Without_Checked_afdal_terms_checkbox_N();
    IAfdalAnalyticsSignUpArPage SignUp_Page_Step2_Password_validation_N_lessThan8();

    IAfdalAnalyticsSignUpArPage SignUp_Page_Step2_Password_validation_EqlsOrMoreThan8();
}