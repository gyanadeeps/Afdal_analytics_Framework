package pageobjects.pages;

import java.io.IOException;

public interface IAfdalAnalyticsSettings {
    IAfdalAnalyticsSettings Verify_UI();
    IAfdalAnalyticsSettings ClickOnNavigationMenu() throws InterruptedException;
    IAfdalAnalyticsSettings ClearAllFields();
    //IAfdalAnalyticsSettings ClickOnSave_Button();

    IAfdalAnalyticsSettings SaveWithAll_Fields();
    IAfdalAnalyticsSettings Validatio_of_Lname_Fname_email_Empty();
    IAfdalAnalyticsSettings Verify_Mandatory_fields_filling();
    IAfdalAnalyticsSettings Verify_SuccessMsg_With_all_filled_fields();

    IAfdalAnalyticsSettings Verify_Invalid_Postal_code();

    IAfdalAnalyticsSettings Verify_Valid_Postal_code();
    IAfdalAnalyticsSettings Validate_Disabled_Email_id_cant_be_changed();
    IAfdalAnalyticsSettings Validate_Ph_no_should_accept_Numbers_only();
    IAfdalAnalyticsSettings Verify_Ph_no_with_Invalid_Credentias();
    IAfdalAnalyticsSettings Validate_WebSite_with_Valid_format();

    IAfdalAnalyticsSettings Validate_WebSite_with_Invalid_format() throws InterruptedException;
    //IAfdalAnalyticsSettings Profile_Picture_Should_Accept_Valid_Format() throws IOException, InterruptedException;

    IAfdalAnalyticsSettings Click_on_Invoices_Tab() throws InterruptedException;
    IAfdalAnalyticsSettings Validate_Billing_History_Section();

     IAfdalAnalyticsSettings Validate_Invoice_UI() throws InterruptedException;

    IAfdalAnalyticsSettings Validation_Subscription_modification_Button() throws InterruptedException;
    IAfdalAnalyticsSettings Validation_PopUp_Close_Button();
    IAfdalAnalyticsSettings Invoice_Download();
   /* IAfdalAnalyticsSettings Add_Payment_Method_with_all_data();
    IAfdalAnalyticsSettings Add_Payment_method_with_all_empty_field();
    IAfdalAnalyticsSettings Verify_Users_tab();
    IAfdalAnalyticsSettings Add_new_User();

     */



}
