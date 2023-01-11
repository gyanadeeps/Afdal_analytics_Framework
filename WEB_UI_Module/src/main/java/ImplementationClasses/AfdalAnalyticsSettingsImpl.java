package ImplementationClasses;

import BaseClasses.AfdalAnalyticsLoginPage;
import BaseClasses.Feature;
import pageobjects.pages.IAfdalAnalyticsSettings;
import pageobjects.pages.IAfdalAnalyticsSignInPage;

public class AfdalAnalyticsSettingsImpl extends AfdalAnalyticsLoginPage implements Feature {
    private IAfdalAnalyticsSignInPage homePage;
    @Override
    public void init()
    {

        homePage = openAfdalAnalticsPage();
    }


    @Override
    public void execute() {
        try {
            homePage.Switch_To_Settings_page().Verify_UI().ClickOnNavigationMenu()
            //.ClickOnSave_Button();
            .SaveWithAll_Fields()
            .Validatio_of_Lname_Fname_email_Empty()
             .Verify_Mandatory_fields_filling()
            .Verify_SuccessMsg_With_all_filled_fields()
           .Verify_Invalid_Postal_code()
            .Verify_Valid_Postal_code()
           .Validate_Disabled_Email_id_cant_be_changed()
            .Validate_Ph_no_should_accept_Numbers_only()
            .Verify_Ph_no_with_Invalid_Credentias()
            .Validate_WebSite_with_Valid_format()
            .Validate_WebSite_with_Invalid_format()
            //.Profile_Picture_Should_Accept_Valid_Format()
            .Click_on_Invoices_Tab()
            .Validate_Billing_History_Section()
            .Validate_Invoice_UI()
            .Validation_Subscription_modification_Button()
           .Validation_PopUp_Close_Button()
            .Invoice_Download();
           /*.Add_Payment_Method_with_all_data()
            .Add_Payment_method_with_all_empty_field()
            .Verify_Users_tab().Add_new_User();

                     */



        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }



}




