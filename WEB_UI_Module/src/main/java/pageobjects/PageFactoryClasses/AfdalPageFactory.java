package pageobjects.PageFactoryClasses;


import pageobjects.pages.*;


public class AfdalPageFactory extends PageFactory
{

    public static IAfdalAnalyticsSignInPage getHomepage()
    {
        return wrap(new AfdalAnalyticsSignInPage(), IAfdalAnalyticsSignInPage.class);
    }

}
