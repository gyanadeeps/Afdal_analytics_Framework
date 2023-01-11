package pageobjects.PageFactoryClasses;


import org.jetbrains.annotations.NotNull;
import pageobjects.pages.*;


public class AfdalPageFactory extends PageFactory
{

    public static IAfdalAnalyticsSignInPage getHomepage()
    {
        return wrap(new AfdalAnalyticsSignInPage(), IAfdalAnalyticsSignInPage.class);
    }
    public static IAfdalAnalyticsSettings getSettings() {

        return wrap(new AfdalAnalyticsSettings(), IAfdalAnalyticsSettings.class);
    }
    public static IAfdalAnalyticsPricingPage getPricing()
    {

        return wrap(new AfdalAnalyticsPricingPage(), IAfdalAnalyticsPricingPage.class);
    }

}
