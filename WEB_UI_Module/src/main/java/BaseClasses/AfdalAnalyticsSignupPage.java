package BaseClasses;

import pageobjects.PageFactoryClasses.AfdalAnalyticsSignUpPageFactory;
import pageobjects.pages.IAfdalAnalyticsSignUpPage;

import static com.codeborne.selenide.Selenide.open;
import static data.SystemProperties.AFDALANALYTICS_URL;

public class AfdalAnalyticsSignupPage {


    public IAfdalAnalyticsSignUpPage openAfdalAnalyticsPage()
    {
        open(AFDALANALYTICS_URL);

        return AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }

}
