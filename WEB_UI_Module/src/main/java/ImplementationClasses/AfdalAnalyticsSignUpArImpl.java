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
                    .SignUp_Check_Already_have_an_account_Sign_in_BTN()
                    .Sign_Up_Verify_All_Fields_Empty()
                    //.Sign_Up_Verify_Valid_phone_No()
                    //.Sign_Up_With_Valid_Gmail()
                    //.Sign_Up_With_Valid_LinkedIN()
                     .Sign_Up_With_Valid_Email()
                    //.SignUp_With_Valid_Gmail_By_Close_the_Popup_N()
                    //.SignUp_With_Valid_PhoneNo_Without_Checked_afdal_terms_checkbox_N()
                    .SignUp_With_Valid_Email_Without_Checked_afdal_terms_checkbox_N()
                    //.SignUp_Page_Step2_Password_validation_N_lessThan8()
                   // .SignUp_Page_Step2_Password_validation_EqlsOrMoreThan8()
                    //.SignUp_With_Valid_PhoneNo_Step2_INValid_First_Name_N()
                    //.SignUp_WithValid_PhoneNo_Step2_INValid_Last_Name_N()
                  // .SignUp_WithValid_PhoneNo_Step2_INValid_Company_Name_N()
         //           .SignUp_WithValid_PhoneNo_Step2_INValid_Password_N()
          //          .SignUp_WithValid_PhoneNo_Step2_leave_all_fields_empty_N()
         //           .SignUp_WithValid_PhoneNo_Step2_Skip_To_demoPage()
                    .SignUp_With_Valid_Email_Step2_ValidNamesAndPassword()
                    .SignUp_With_Valid_Email_Step2_INValid_FirstName_N()
                    .SignUp_With_Valid_Email_Step2_INValid_LastName_N()
                    .SignUp_With_Valid_Email_Step2_INValid_Company_Name_N()
                    .SignUp_With_Valid_Email_Step2_INValid_Phone_No_N()
                    .SignUp_With_Valid_Email_Step2_INValid_Password_N()
                    .SignUp_With_Valid_Email_Step2_With_All_Field_empty_N()
                    .SignUp_With_Valid_Email_Step2_Skip_To_demo_Page();








        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
