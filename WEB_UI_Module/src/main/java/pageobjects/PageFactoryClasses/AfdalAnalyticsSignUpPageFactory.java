package pageobjects.PageFactoryClasses;

import pageobjects.pages.AfdalAnalyticsSignUpPage;
import pageobjects.pages.IAfdalAnalyticsSignUpPage;

public class AfdalAnalyticsSignUpPageFactory extends PageFactory{

    public static IAfdalAnalyticsSignUpPage getSignUpPage() {

        return wrap(new AfdalAnalyticsSignUpPage(), IAfdalAnalyticsSignUpPage.class);


    }
}
