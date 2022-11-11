package ImplementationClasses;

import BaseClasses.Feature;
import BaseClasses.AfdalAnalyticsLoginPage;
import data.SystemProperties;
import pageobjects.pages.IAfdalAnalyticsSignInPage;

public class AfdalAnalyticsSignInImpl extends AfdalAnalyticsLoginPage implements Feature
{
   private IAfdalAnalyticsSignInPage homePage;
    @Override
    public void init()
    {
        homePage = openAfdalAnalticsPage();
    }

    @Override
    public void execute() {
     try {

//      homePage.clickOnSignInButton();

      homePage.verify_SignIn_UI();
      homePage.verify_Signin_with_all_filed_are_empty_N();
      homePage.Email_password_field();
      homePage.Email_empty_password_field_N();
      homePage.Empty_Email_Fill_password_field_N();
      homePage.Email_validation_N();
      homePage.Password_validation_N();
      homePage.ClickOn_SignUp();
      homePage.Signin_with_apple_N();
      homePage.Signin_with_google_N();
      homePage.Signin_with_linkedIn_N();






     } catch (Exception exception) {
      exception.printStackTrace();
     }
    }
}
