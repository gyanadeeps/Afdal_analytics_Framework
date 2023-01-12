package pageobjects.pages;

public interface IAfdalAnalyticsSignUpArPage {

    IAfdalAnalyticsSignUpArPage Sign_Up_Ar_Verify_Ui();

    IAfdalAnalyticsSignUpArPage Sign_Up_Verify_All_Fields_Empty() throws InterruptedException;

    IAfdalAnalyticsSignUpArPage Sign_Up_Verify_Valid_phone_No();

    IAfdalAnalyticsSignUpArPage Sign_Up_With_InValid_Gmail() throws InterruptedException;

    IAfdalAnalyticsSignUpArPage Sign_Up_With_Valid_Email();

    IAfdalAnalyticsSignUpArPage SignUp_With_Valid_Gmail_By_Close_the_Popup_N();
}
