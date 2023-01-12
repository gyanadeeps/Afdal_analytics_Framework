package pageobjects.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pageobjects.PageFactoryClasses.AfdalPageFactory;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AfdalAnalyticsSignUpArPage implements IAfdalAnalyticsSignUpArPage {
    SelenideElement getAcceptCookie_Button = $x("//button[contains(text(),'مُوَافق')]");
    SelenideElement SignUp_Button = $x("//a[text()='اشترك مجانا']");
    SelenideElement Subscribe_Now = $x("//p[contains(text(),'اشترك الآن')]");
    SelenideElement SignIn_button = $x("//a[contains(text(),'سجل الدخول')]");
    SelenideElement LinkedIn_H_Icon = $x("//*[name()='path' and contains(@d,'M0 20.5C0 ')]");
    SelenideElement Google_Icon = $x("//a[@id='googleAuth']//div[@class='mt-3']//*[name()='svg']");
    SelenideElement Gmail_Input_Field = $x("//input[@id='identifierId']");
    SelenideElement Gmail_Next_Bttn = $x("(//button/div[@class='VfPpkd-Jh9lGc'])[2]");
    SelenideElement Wrong_Gmail_Uname_Err_msg = $x("//div[@class='o6cuMc']");

    SelenideElement Subscribe_Button_On_SignUp_Page = $x("//button[text()='اشترك']");
    SelenideElement Enter_Phone_Or_Email_Error = $x("//div[@id='alert-div']");
    SelenideElement Phone_Number_field = $x("//input[@id='phone']");
    SelenideElement Afdal_signup_checkbox = $x("//input[@id='checkbox-terms']");
    SelenideElement Google_SignUp_Button = $x("//p[text()='تسجيل الدخول باستخدام جوجل']");
    SelenideElement Gmail_Enter_Email_or_Phone = $x("//input[@type='email']");


    @Override
    public IAfdalAnalyticsSignUpArPage Sign_Up_Ar_Verify_Ui() {
        getAcceptCookie_Button.click();
        SignUp_Button.click();
        //Assertion to Verify SignUp Button has visible Text
        SignUp_Button.shouldHave(Condition.exactText("اشترك مجانا"));
        System.out.println("اشترك مجانا");
        Subscribe_Now.shouldHave(Condition.exactText("اشترك الآن"));
        SignIn_button.shouldHave(Condition.visible);
        SignIn_button.shouldHave(Condition.exactText("سجل الدخول"));
        LinkedIn_H_Icon.shouldHave(Condition.visible);
        Google_Icon.shouldHave(Condition.visible);
        Subscribe_Button_On_SignUp_Page.shouldHave(Condition.enabled);

        return AfdalPageFactory.getNewSignUp();
    }

    @Override
    public IAfdalAnalyticsSignUpArPage Sign_Up_Verify_All_Fields_Empty() throws InterruptedException {

            //Thread.sleep(5000);
            Subscribe_Button_On_SignUp_Page.click();
            Thread.sleep(4000);
        String Expected_Err_MSG = Enter_Phone_Or_Email_Error.getText();
        String Actual_Err_MSG ="الهاتف أو البريد الإلكتروني مطلوب";
        Assert.assertEquals(Expected_Err_MSG, Actual_Err_MSG);
        System.out.println("Test Passed");

        return AfdalPageFactory.getNewSignUp();
    }

    @Override
    public IAfdalAnalyticsSignUpArPage Sign_Up_Verify_Valid_phone_No() {
        Phone_Number_field.sendKeys("+1541-708-3275");
        //Afdal_signup_checkbox.click();
        getWebDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Selenide.executeJavaScript("arguments[0].click()", Subscribe_Button_On_SignUp_Page);
        return AfdalPageFactory.getNewSignUp();
    }

    @Override
    public IAfdalAnalyticsSignUpArPage Sign_Up_With_InValid_Gmail() throws InterruptedException {
            Thread.sleep(4000);
            getWebDriver().navigate().back();
            String URL = getWebDriver().getCurrentUrl();
            System.out.println(URL);
            SignUp_Button.click();
            Thread.sleep(4000);
            Selenide.executeJavaScript("arguments[0].click()", Google_SignUp_Button);//Google_SignUp_Button.click();
            getWebDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            Set<String> Windows = WebDriverRunner.getWebDriver().getWindowHandles();//Switch windows to gmail Signup.
            Iterator<String> iterator = Windows.iterator();
            String subWindowsHandler = null;
            while (iterator.hasNext()) {
                subWindowsHandler = iterator.next();
            }
            WebDriverRunner.getWebDriver().switchTo().window(subWindowsHandler);
            Thread.sleep(2000);
            Gmail_Input_Field.setValue("devtempmail1+imktzrnagu@gmail.com");
            //Gmail_Next_Bttn.click();
        Selenide.executeJavaScript("arguments[0].click()", Gmail_Next_Bttn);





        return AfdalPageFactory.getNewSignUp();
    }

    @Override
    public IAfdalAnalyticsSignUpArPage Sign_Up_With_Valid_Email() {

        return AfdalPageFactory.getNewSignUp();
    }

    @Override
    public IAfdalAnalyticsSignUpArPage SignUp_With_Valid_Gmail_By_Close_the_Popup_N() {

        return AfdalPageFactory.getNewSignUp();
    }


}







