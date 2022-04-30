package BaseClasses;

import pageobjects.PageFactoryClasses.AfdalPageFactory;
import pageobjects.pages.IAfdalAnalyticsSignInPage;

import static com.codeborne.selenide.Selenide.open;
import static data.SystemProperties.AFDALANALYTICS_URL;

public class AfdalAnalyticsLoginPage {



    public IAfdalAnalyticsSignInPage openAfdalAnalticsPage()
    {
        open(AFDALANALYTICS_URL);

        return AfdalPageFactory.getHomepage();
    }


}
