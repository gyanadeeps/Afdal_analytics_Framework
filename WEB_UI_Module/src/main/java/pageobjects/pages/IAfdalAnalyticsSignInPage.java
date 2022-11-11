package pageobjects.pages;

public interface IAfdalAnalyticsSignInPage
{

//  IAfdalAnalyticsSignInPage clickOnSignInButton();


  IAfdalAnalyticsSignInPage verify_SignIn_UI();


  IAfdalAnalyticsSignInPage verify_Signin_with_all_filed_are_empty_N();


  IAfdalAnalyticsSignInPage Email_password_field();


  IAfdalAnalyticsSignInPage Email_empty_password_field_N();


  IAfdalAnalyticsSignInPage Empty_Email_Fill_password_field_N();



  IAfdalAnalyticsSignInPage Email_validation_N() throws InterruptedException;
  IAfdalAnalyticsSignInPage Password_validation_N();

  IAfdalAnalyticsSignInPage ClickOn_SignUp();
  IAfdalAnalyticsSignInPage Signin_with_apple_N() throws InterruptedException;

  IAfdalAnalyticsSignInPage Signin_with_google_N() throws InterruptedException;

  IAfdalAnalyticsSignInPage Signin_with_linkedIn_N() throws InterruptedException;



}
