package pageobjects.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pageobjects.PageFactoryClasses.AfdalPageFactory;

import static com.codeborne.selenide.Selenide.$x;

public class AfdalAnalyticsSignInPage implements IAfdalAnalyticsSignInPage
{


    SelenideElement ok_btn = $x(".//div[@class='main-block']//button[contains(text(),'مُوَافق')]");
    SelenideElement login_btn = $x("//nav//a[contains(text(),'تسجيل الدخول')]");





    @Override
    public IAfdalAnalyticsSignInPage clickOnSignInButton()
    {
        ok_btn.waitUntil(Condition.visible,4000).click();
        login_btn.waitUntil(Condition.visible,4000).click();
        return AfdalPageFactory.getHomepage();
    }

    @Override
    public IAfdalAnalyticsSignInPage clickOnSignUpButton() {
        return null;
    }


}
