package pageobjects.pages;

public interface IAfdalAnalyticsSignInPage
{




  IAfdalAnalyticsSignInPage verify_SignIn_UI();


  IAfdalAnalyticsSignInPage verify_Signin_with_all_filed_are_empty_N();


  IAfdalAnalyticsSignInPage Email_password_field();


  IAfdalAnalyticsSignInPage Email_empty_password_field_N();


  IAfdalAnalyticsSignInPage Empty_Email_Fill_password_field_N();



  IAfdalAnalyticsSignInPage Email_validation_N() throws InterruptedException;
  IAfdalAnalyticsSignInPage Password_validation_N();




  IAfdalAnalyticsSignInPage Signin_with_apple_N() throws InterruptedException;

  IAfdalAnalyticsSignInPage Signin_with_google_N() throws InterruptedException;

  IAfdalAnalyticsSignInPage Signin_with_linkedIn_N() throws InterruptedException;
  IAfdalAnalyticsSettings Switch_To_Settings_page();

  IAfdalAnalyticsPricingPage Verify_Pricing_UI();
  // IAfdalAnalyticsPricingPage Switch_To_PricingPage();


}
