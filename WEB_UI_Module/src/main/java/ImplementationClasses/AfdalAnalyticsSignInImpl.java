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

      homePage.clickOnSignInButton();
     } catch (Exception exception) {
      exception.printStackTrace();
     }
    }
}
