package pageobjects.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import pageobjects.PageFactoryClasses.AfdalPageFactory;

import static com.codeborne.selenide.Selenide.*;

public class AfdalAnalyticsSignInPage implements IAfdalAnalyticsSignInPage
{

    // Accept Cookies.................
    SelenideElement getAcceptCookie_Button = $x("//button[contains(text(),'مُوَافق')]");

    SelenideElement getDescription_Cookie = $x("//p[contains(text(), \"نحن نستخدم ملفات تعريف الارتباط على موقعنا لأغراض التعريف والتحليل. باستخدام هذا الموقع فإنك توافق ع\")]");

    SelenideElement getCloseCookie_CrossSign = $x("//div[@id='cookie-close-btn']");


//    SelenideElement getSignin_Button = $x("//nav//a[contains(text(),\"تسجيل الدخول\")]");

    SelenideElement getSignin_Button = $x("//a[@role='button'][contains(text(),'تسجيل الدخول')]");

    SelenideElement getHeader_Signin = $x("//h3[contains(text(), \"سجل الدخول\")]");

    SelenideElement getHeader_SubscribeLink = $x("//a[@href=\"https://staging.afdalanalytics.com/signup\"]");

    SelenideElement getHeader_SubscribeLinkDescription = $x("//a//u[contains(text(), \"قم بالإشتراك\")]");

    SelenideElement getEmailInput = $x("//input[@id='email']");

    SelenideElement getSubHeader_Email = $x("//label[contains(text(),\"البريد الإلكتروني\")]");

    SelenideElement getPasswordInput = $x("//input[@name=\"password\"]");

    SelenideElement getSubHeader_Password = $x("//label[@id=\"password\" and contains(text(), 'كلمة المرور')]");

    SelenideElement getShowIcon_Password = $x("//i[@id='icon']");

    SelenideElement getCheckBoxbutton = $x("//input[@id=\"exampleCheck1\"]");

    SelenideElement getSubDescription_CheckBox = $x("//label[contains(text(), 'احتفظ بتسجيل دخولي')]");

    SelenideElement getLink_ForgotYourPassword = $x("//a[@href=\"https://staging.afdalanalytics.com/reset-password\"]");

    SelenideElement getLinkDescription_ForgotYourPassword = $x("//u[contains(text(),'نسيت رقمك السري؟')]");

    SelenideElement getSubmit_SignInButton = $x("//button[contains(text(),'سجل الدخول')]");

    SelenideElement getAlert_EmailPasswordRequired = $x("//div[@class='alert alert-danger alert-block mb-0']//strong[contains(text(),'حقل بريد إلكتروني مطلوب. حقل كلمة المرور مطلوب.')]");

    SelenideElement getAlert_EmailRequired = $x("//div[@class='alert alert-danger alert-block mb-0']//strong[contains(text(),'حقل بريد إلكتروني مطلوب.')]");
    SelenideElement getAlert_InvalidEmail = $x("//div[@class='alert alert-danger alert-block mb-0']//strong[contains(text(),'عليك إدخال بريد إلكتروني صحيح')]");

    SelenideElement getAlert_InvalidLoginAndWrongPassword = $x("//div[@class='alert alert-danger alert-block mb-0']//strong[contains(text(),'معلومات الدخول خاطئة او كلمة المرور خاطئة')]");
    SelenideElement AlertCloseButton = $x("//button[@class=\"close\"]");

    SelenideElement getSubHeader_OrSignUpWithIn = $x("//span[contains(text(),'أو قم بتسجيل الدخول باستخدام')]");

    SelenideElement getIcon_Google = $x("//a[@id=\"googleAuth\"]");

    SelenideElement getIcon_LinkedIn = $x("//a[@id='linkedIn']");

    SelenideElement getIcon_Apple = $x("//a[@id='apple']");

    SelenideElement getLogout_AfdalAnalytics = $x("//div[@class='side-bar-icon']");


    @Override
    public IAfdalAnalyticsSignInPage verify_SignIn_UI() {

        // Assertion on PopUp-Cookie...........


//        getDescription_Cookie.shouldHave(Condition.exactText("نحن نستخدم ملفات تعريف الارتباط على موقعنا لأغراض التعريف والتحليل. باستخدام هذا الموقع فإنك توافق ع"));
        System.out.println(getCloseCookie_CrossSign.isDisplayed());
        System.out.println(getAcceptCookie_Button.isDisplayed());
        getAcceptCookie_Button.shouldHave(Condition.exactText("مُوَافق")).click();


//        Assertion on SignIn Button.........
        System.out.println(getSignin_Button.isDisplayed());
        getSignin_Button.shouldHave(Condition.exactText("تسجيل الدخول"));
        getSignin_Button.waitUntil(Condition.visible,4000).click();

//  Assertion on Sign In Subscribe Description and Link............
        getHeader_Signin.shouldHave(Condition.exactText("سجل الدخول"));
        getHeader_SubscribeLinkDescription.shouldHave(Condition.exactText("قم بالإشتراك"));
        getHeader_SubscribeLink.shouldHave(Condition.visible).click();
        back();



// Assertion on Email Section.......

        getSubHeader_Email.shouldHave(Condition.exactText("البريد الإلكتروني"));
        System.out.println(getSubHeader_Email);
        getEmailInput.isDisplayed();
        getEmailInput.setValue("demo@afdal.com");
        getEmailInput.clear();

        //Assertion on Password Section.................

        getSubHeader_Password.waitUntil(Condition.visible,1000).shouldHave(Condition.exactText("كلمة المرور"));

        getPasswordInput.isDisplayed();
        getPasswordInput.setValue("demo2022");
        getPasswordInput.clear();

//        PasswordShowHide.shouldBe(Condition.visible);



//        Assertion on Checkbox Button..........
        getCheckBoxbutton.click();
        getCheckBoxbutton.shouldBe(Condition.visible,Condition.checked);
        getSubDescription_CheckBox.shouldHave(Condition.exactText("احتفظ بتسجيل دخولي"));

        // Assertion on Forgot your password link............
        getLinkDescription_ForgotYourPassword.shouldHave(Condition.exactText("نسيت رقمك السري؟"));
        getLink_ForgotYourPassword.shouldBe(Condition.visible);

//      Assertion on Or SignUp withIn Section...................\
        getSubHeader_OrSignUpWithIn.shouldHave(Condition.exactText("أو قم بتسجيل الدخول باستخدام"));

        getIcon_Google.shouldBe(Condition.visible);

        getIcon_LinkedIn.shouldBe(Condition.visible);

        getIcon_Apple.shouldBe(Condition.visible);

        getSubmit_SignInButton.shouldHave(Condition.exactText("سجل الدخول"));

        return AfdalPageFactory.getHomepage();


    }






    //    Sign in with all filed are empty_N..........
    @Override
    public  IAfdalAnalyticsSignInPage verify_Signin_with_all_filed_are_empty_N(){
        refresh();
//        getSignin_Button.waitUntil(Condition.visible,3000).click();
        getSubmit_SignInButton.shouldBe(Condition.visible).click();
        getAlert_EmailPasswordRequired.shouldHave(Condition.exactText("حقل بريد إلكتروني مطلوب. حقل كلمة المرور مطلوب."));
        AlertCloseButton.click();
        return AfdalPageFactory.getHomepage();
    }



    @Override
    public  IAfdalAnalyticsSignInPage Email_password_field(){
        refresh();
        getSignin_Button.waitUntil(Condition.visible,3000).click();
        getEmailInput.sendKeys("demo@afdal.com");
        getPasswordInput.sendKeys("demo2022");
        getCheckBoxbutton.click();
        getSubmit_SignInButton.hover().click();
        getLogout_AfdalAnalytics.click();
        return AfdalPageFactory.getHomepage();


    }



    @Override
    public IAfdalAnalyticsSignInPage Email_empty_password_field_N() {
        refresh();
        getSignin_Button.click();
        getEmailInput.sendKeys("demo@afdal.com");
        getCheckBoxbutton.click();
        getSubmit_SignInButton.isEnabled();
        return AfdalPageFactory.getHomepage();

    }


    @Override
    public IAfdalAnalyticsSignInPage Empty_Email_Fill_password_field_N() {
        getSignin_Button.waitUntil(Condition.visible,3000).click();
        getPasswordInput.setValue("demo2022");
        getCheckBoxbutton.click();
        getSubmit_SignInButton.click();
        getAlert_EmailRequired.shouldHave(Condition.exactText("حقل بريد إلكتروني مطلوب."));
        AlertCloseButton.click();
        return AfdalPageFactory.getHomepage();
    }


    @Override
    public IAfdalAnalyticsSignInPage Email_validation_N() {

        getSignin_Button.waitUntil(Condition.visible,3000).click();
        refresh();
        getEmailInput.setValue("testatgmail.com");
//        String email_error1 = String.valueOf(getEmailInput.setValue("testatgmail.com"));
//        Assert.assertEquals(email_error1,"test@gmail.com");
        getPasswordInput.sendKeys("demo2022");
        getCheckBoxbutton.click();
        getSubmit_SignInButton.click();
        getAlert_InvalidEmail.shouldHave(Condition.exactText("عليك إدخال بريد إلكتروني صحيح"));

        refresh();

        getEmailInput.setValue("test@gmail");
//        String email_error2 = String.valueOf(getEmailInput.setValue("test@gmail"));
//        Assert.assertEquals(email_error2,"test@gmail.com");
        getPasswordInput.sendKeys("demo2022");
        getCheckBoxbutton.click();
        getSubmit_SignInButton.click();
        getAlert_InvalidLoginAndWrongPassword.shouldHave(Condition.text("معلومات الدخول خاطئة او كلمة المرور خاطئة"));


        refresh();


        getEmailInput.setValue("test@gmailcom");
//        String email_error3 = String.valueOf(getEmailInput.setValue("test@gmailcom"));
//        Assert.assertEquals(email_error3,"test@gmail.com");
        getPasswordInput.sendKeys("demo2022");
        getCheckBoxbutton.click();
        getSubmit_SignInButton.click();
        getAlert_InvalidLoginAndWrongPassword.shouldHave(Condition.text("معلومات الدخول خاطئة او كلمة المرور خاطئة"));



        refresh();

        getEmailInput.setValue("test@gmailcom");
//        String email_error4 = String.valueOf(getEmailInput.setValue("@gmail"));
//        Assert.assertEquals(email_error4,"test@gmail.com");
        getPasswordInput.sendKeys("demo2022");
        getCheckBoxbutton.click();
        getSubmit_SignInButton.click();
        getAlert_InvalidLoginAndWrongPassword.shouldHave(Condition.text("معلومات الدخول خاطئة او كلمة المرور خاطئة"));



        return AfdalPageFactory.getHomepage();
    }


    @Override
    public IAfdalAnalyticsSignInPage Password_validation_N() {

        getSignin_Button.waitUntil(Condition.visible,3000).click();
        getEmailInput.setValue("Demo@afdal.com");
//        String passord_error1 = String.valueOf(Password.setValue("12345"));
//        Assert.assertEquals(passord_error1,"123456");
        getPasswordInput.setValue("12345");
        getCheckBoxbutton.click();
        getSubmit_SignInButton.click();
        Boolean buttonEnabled = getSubmit_SignInButton.isEnabled();
        Assert.assertFalse(buttonEnabled);


        refresh();

        getEmailInput.sendKeys("Demo@afdal.com");
//        String passord_error2 = String.valueOf(Password.setValue("123456"));
//        Assert.assertEquals(passord_error2,"123456");
        getPasswordInput.setValue("demo2022");
        getCheckBoxbutton.click();
        getSubmit_SignInButton.click();
        getLogout_AfdalAnalytics.click();


        return AfdalPageFactory.getHomepage();

    }


    @Override
    public IAfdalAnalyticsSignInPage Signin_with_apple_N() {

        getSignin_Button.waitUntil(Condition.visible, 3000).click();
        getIcon_Apple.click();
        switchTo().window(1);
        boolean appleURL = WebDriverRunner.getWebDriver().getCurrentUrl().startsWith("https://appleid.apple.com/");
        Assert.assertTrue(appleURL);
        String appleTitle = WebDriverRunner.getWebDriver().getTitle();
        Assert.assertEquals(appleTitle,"403 Forbidden");
        closeWindow();
        switchTo().window(0);
        return AfdalPageFactory.getHomepage();
    }



    @Override
    public IAfdalAnalyticsSignInPage Signin_with_google_N() {
        getSignin_Button.waitUntil(Condition.visible, 3000).click();
        getIcon_Google.click();
        switchTo().window(1);
        boolean googleURL = WebDriverRunner.getWebDriver().getCurrentUrl().startsWith("https://accounts.google.com/");
        Assert.assertTrue(googleURL);
        String googleTitle = WebDriverRunner.getWebDriver().getTitle();
        Boolean title = googleTitle.contains("Google Accounts");
        Assert.assertTrue(title);
//        Assert.assertEquals(googleTitle,"Sign in - Google Accounts");
        System.out.println("googleTitle");
//        Assert.assertTrue(Boolean.parseBoolean(googleTitle), "Sign in - Google Accounts");
//        Assert.assertEquals(googleTitle, "Sign in - Google Accounts");
        closeWindow();
        switchTo().window(0);
        return AfdalPageFactory.getHomepage();
    }

    @Override
    public IAfdalAnalyticsSignInPage Signin_with_linkedIn_N() {
        refresh();
        getSignin_Button.waitUntil(Condition.visible, 3000).click();
        getIcon_LinkedIn.click();
        switchTo().window(1);
        boolean linkedinURL = WebDriverRunner.getWebDriver().getCurrentUrl().startsWith("https://www.linkedin.com/");
        Assert.assertTrue(linkedinURL);
        String linkedinTitle = WebDriverRunner.getWebDriver().getTitle();
        Assert.assertEquals(linkedinTitle,"LinkedIn_H_Icon Login, Sign in | LinkedIn_H_Icon");
        closeWindow();
        switchTo().window(0);
        return AfdalPageFactory.getHomepage();
    }

    @Override
    public IAfdalAnalyticsSettings Switch_To_Settings_page() {

        return AfdalPageFactory.getSettings();
    }

    @Override
    public IAfdalAnalyticsPricingPage Verify_Pricing_UI() {
        return AfdalPageFactory.getPricing();
            }

    @Override
    public IAfdalAnalyticsSignUpArPage Switch_to_SignUp_Page() {
        return AfdalPageFactory.getNewSignUp();
    }

    /*@Override
    public IAfdalAnalyticsPricingPage Switch_To_PricingPage() {
        return AfdalPageFactory.getPricing();
    }
*/

}
