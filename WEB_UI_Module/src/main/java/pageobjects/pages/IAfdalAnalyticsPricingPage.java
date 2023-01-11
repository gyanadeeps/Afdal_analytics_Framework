package pageobjects.pages;

public interface IAfdalAnalyticsPricingPage {

    IAfdalAnalyticsPricingPage Verify_Pricing_UI();

    IAfdalAnalyticsPricingPage Verify_Is_Essl_Plan_Auto_Selected() throws InterruptedException;

    IAfdalAnalyticsPricingPage Switch_To_PricingPage();
    IAfdalAnalyticsPricingPage Verify_Is_Plus_Plan_Displayed();
    IAfdalAnalyticsPricingPage Verify_Is_Entr_Plan_Displayed();
    IAfdalAnalyticsPricingPage Validation_Price_Tables();
   /* IAfdalAnalyticsPricingPage Verify_Freq_Asked_Q_UI();
    IAfdalAnalyticsPricingPage Validation_Auto_Selected_Essl_plans_Data();
    IAfdalAnalyticsPricingPage Validation_Plus_plan_Correct_Data();
    IAfdalAnalyticsPricingPage Validation_EnterPrc_Plan_Correct_Data();

    IAfdalAnalyticsPricingPage SignIn_with_LinkedIn_N();

    IAfdalAnalyticsPricingPage verifyFacebookIcon();

    IAfdalAnalyticsPricingPage verifyInstagramIcon();

    IAfdalAnalyticsPricingPage verifyTwitterIcon();

    IAfdalAnalyticsPricingPage Switch_To_PricingPage();


*/
}
