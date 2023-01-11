package ImplementationClasses;

import BaseClasses.AfdalAnalyticsLoginPage;
import BaseClasses.Feature;
import pageobjects.pages.IAfdalAnalyticsSignInPage;

public class AfdalAnalyticsPricingImpl extends AfdalAnalyticsLoginPage implements Feature {
    private IAfdalAnalyticsSignInPage homePage;
    @Override
    public void init() {

        homePage = openAfdalAnalticsPage();
    }

    @Override
    public void execute()  {
        try {


        homePage.Verify_Pricing_UI()
                .Verify_Is_Essl_Plan_Auto_Selected()
                .Verify_Is_Plus_Plan_Displayed()
                .Verify_Is_Entr_Plan_Displayed()
                .Validation_Price_Tables();


    }catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}


