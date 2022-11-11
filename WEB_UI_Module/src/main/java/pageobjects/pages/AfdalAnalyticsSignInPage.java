package pageobjects.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import pageobjects.PageFactoryClasses.AfdalPageFactory;

import static com.codeborne.selenide.Selenide.*;

public class AfdalAnalyticsSignInPage implements IAfdalAnalyticsSignInPage
{


//    SelenideElement ok_btn = $x(".//div[@class='main-block']//button[contains(text(),'مُوَافق')]");
//    SelenideElement login_btn = $x("//nav//a[contains(text(),'تسجيل الدخول')]");


    SelenideElement closeCookie = $x("//div[@id='cookie-close-btn']");
    SelenideElement signIn = $x("//nav//a[contains(text(),\"تسجيل الدخول\")]");

    SelenideElement signInHeader = $x("//h3[contains(text(), \"سجل الدخول\")]");

    SelenideElement subscribeLink = $x("//a[@href=\"https://staging.afdalanalytics.com/signup\"]");

    SelenideElement subscribeLinkText = $x("//a//u[contains(text(), \"قم بالإشتراك\")]");

//    SelenideElement Subscribe_Link_Description = $x("//*[@id=\"form\"]/p/font/font[contains(text(),'\n" +
//            "                إذا لم تكن مستخدمًا؟\n" +
//            "            ')]");

    SelenideElement email = $x("//input[@id='email']");

    SelenideElement emailText = $x("//label[contains(text(),\"البريد الإلكتروني\")]");

    SelenideElement password = $x("//input[@name=\"password\"]");

    SelenideElement passwordText = $x("//label[@id=\"password\" and contains(text(), 'كلمة المرور')]");

    SelenideElement passwordShowHide = $x("//i[@id='icon']");

    SelenideElement checkboxButton = $x("//input[@id=\"exampleCheck1\"]");

    SelenideElement checkboxDescription = $x("//label[contains(text(), 'احتفظ بتسجيل دخولي')]");

    SelenideElement forgotYourPasswordLink = $x("//a[@href=\"https://staging.afdalanalytics.com/reset-password\"]");

    SelenideElement forgotYourPasswordLinkText = $x("//u[contains(text(),'نسيت رقمك السري؟')]");

    SelenideElement SignInButton = $x("//button[contains(text(),'سجل الدخول')]");

    SelenideElement logout = $x("//nav[@id=\"sidebar\"]//a[@href='/logout']");

    //    SelenideElement AlertText = $x("//strong[contains(text(),'حقل بريد إلكتروني مطلوب. حقل كلمة المرور مطلوب.')]");
    SelenideElement alertText = $x("//strong[contains(text(),'حقل كلمة المرور مطلوب.')]");

    //    SelenideElement AlertText2 = $x("//strong[contains(text(),'حقل كلمة المرور مطلوب.')]");

    SelenideElement alertText4 = $x("//div[@class='alert alert-danger alert-block mb-0']//strong[starts-with(text(),\"عليك إدخال بريد إلكتروني صحيح\")]");
    //    SelenideElement AlertText3 = $x("//strong[contains(text(),'عليك إدخال بريد إلكتروني صحيح')]");
    SelenideElement alertCloseButton = $x("//button[@class=\"close\"]");

    SelenideElement orSigninWith = $x("//span[contains(text(),'أو قم بتسجيل الدخول باستخدام')]");

    SelenideElement googleIcon = $x("//a[@id=\"googleAuth\"]");

    SelenideElement linkedInIcon = $x("//a[@id='linkedIn']");

    SelenideElement appleIcon = $x("//a[@id='apple']");






//
//    @Override
//    public IAfdalAnalyticsSignInPage clickOnSignInButton()
//    {
//        ok_btn.waitUntil(Condition.visible,4000).click();
//        login_btn.waitUntil(Condition.visible,4000).click();
//        return AfdalPageFactory.getHomepage();
//    }


    @Override
    public IAfdalAnalyticsSignInPage verify_SignIn_UI() {
        refresh();
        closeCookie.click();
        signIn.waitUntil(Condition.visible,4000).click();
        closeCookie.click();

        signInHeader.shouldHave(Condition.exactText("سجل الدخول"));

//    Subscribe_Link_Description.shouldHave(Condition.exactText("\n" +
//////                "                إذا لم تكن مستخدمًا؟\n" +
//                "            "));

        subscribeLink.shouldHave(Condition.visible);

        subscribeLinkText.shouldHave(Condition.exactText("قم بالإشتراك"));

        emailText.shouldHave(Condition.exactText("البريد الإلكتروني"));

        passwordText.waitUntil(Condition.visible,1000).shouldHave(Condition.exactText("كلمة المرور"));

        passwordShowHide.shouldBe(Condition.visible);

        checkboxButton.click();
        checkboxButton.shouldBe(Condition.visible,Condition.checked);
        checkboxDescription.shouldHave(Condition.exactText("احتفظ بتسجيل دخولي"));

        forgotYourPasswordLinkText.shouldHave(Condition.exactText("نسيت رقمك السري؟"));
        forgotYourPasswordLink.shouldBe(Condition.visible);

        orSigninWith.shouldHave(Condition.exactText("أو قم بتسجيل الدخول باستخدام"));

        googleIcon.shouldBe(Condition.visible);

        linkedInIcon.shouldBe(Condition.visible);

        appleIcon.shouldBe(Condition.visible);

        SignInButton.shouldHave(Condition.exactText("سجل الدخول"));

        return AfdalPageFactory.getHomepage();

    }



    @Override
    public  IAfdalAnalyticsSignInPage verify_Signin_with_all_filed_are_empty_N(){
        refresh();
        closeCookie.click();
        signIn.waitUntil(Condition.visible,3000).click();
        closeCookie.click();
        SignInButton.shouldBe(Condition.visible).click();
        closeCookie.click();
        alertText.shouldHave(Condition.exactText("حقل بريد إلكتروني مطلوب. حقل كلمة المرور مطلوب."));
        alertCloseButton.click();
        return AfdalPageFactory.getHomepage();
    }




    @Override
    public  IAfdalAnalyticsSignInPage Email_password_field() {
        refresh();
        closeCookie.click();
        signIn.waitUntil(Condition.visible, 3000).click();
        closeCookie.click();
        email.sendKeys("Demo@afdal.com");
        password.sendKeys("demo2022");
        checkboxButton.click();
        SignInButton.click();
        System.out.println(WebDriverRunner.getWebDriver().getCurrentUrl());
        System.out.println(WebDriverRunner.getWebDriver().getTitle());
        Selenide.executeJavaScript("arguments[0].click();", logout);
        return AfdalPageFactory.getHomepage();


    }



    @Override
    public IAfdalAnalyticsSignInPage Email_empty_password_field_N() {
        refresh();
        closeCookie.click();
        signIn.waitUntil(Condition.visible,3000).click();
        closeCookie.click();
        email.sendKeys("Demo@afdal.com");
        checkboxButton.click();
        SignInButton.click();
        closeCookie.click();
        alertText.should(Condition.exactText("حقل كلمة المرور مطلوب."));
        alertCloseButton.click();
        return AfdalPageFactory.getHomepage();

    }





    @Override
    public IAfdalAnalyticsSignInPage Empty_Email_Fill_password_field_N() {
        refresh();
        closeCookie.click();
        signIn.waitUntil(Condition.visible,3000).click();
        closeCookie.click();
        password.sendKeys("demo2022");
        checkboxButton.click();
        SignInButton.click();
        closeCookie.click();
//        AlertText2.shouldHave(Condition.text("حقل كلمة المرور مطلوب."));
        alertCloseButton.click();
        return AfdalPageFactory.getHomepage();
    }






    @Override
    public IAfdalAnalyticsSignInPage Email_validation_N() throws InterruptedException {
        refresh();
        closeCookie.click();
        signIn.waitUntil(Condition.visible, 3000).click();
        refresh();
        closeCookie.click();
        email.setValue("demoatafdal.com");
        password.setValue("demo2022");
        checkboxButton.click();
        SignInButton.click();
        closeCookie.click();
        alertText4.shouldBe(Condition.text("عليك إدخال بريد إلكتروني صحيح"));
        alertCloseButton.click();

        Thread.sleep(10000);
        refresh();
        closeCookie.click();
        email.setValue("demo@afdal");
        password.setValue("demo2022");
        checkboxButton.click();
        SignInButton.click();
        closeCookie.click();
//        alertText4.shouldBe(Condition.text("عليك إدخال بريد إلكتروني صحيح"));
//        String alert4 = alertText4.getSelectedText();
//        Assert.assertEquals(alert4, "عليك إدخال بريد إلكتروني صحيح");
        alertCloseButton.click();

        Thread.sleep(3000);
        refresh();
        closeCookie.click();
        email.setValue("@gmail");
        password.sendKeys("demo2022");
        checkboxButton.click();
        SignInButton.click();
        closeCookie.click();
//        alertText4.shouldBe(Condition.text("عليك إدخال بريد إلكتروني صحيح"));
        alertCloseButton.click();


        Thread.sleep(3000);
        refresh();
        closeCookie.click();
        password.setValue("demo@afdalcom");
        password.sendKeys("demo2022");
        checkboxButton.click();
        SignInButton.click();
        closeCookie.click();
//        alertText4.shouldBe(Condition.text("عليك إدخال بريد إلكتروني صحيح"));
        alertCloseButton.click();


        return AfdalPageFactory.getHomepage();
    }





    @Override
    public IAfdalAnalyticsSignInPage Password_validation_N(){

        refresh();
        closeCookie.click();
        signIn.waitUntil(Condition.visible, 3000).click();
        refresh();
        closeCookie.click();
        email.setValue("demo@afdal.com");
        password.setValue("demo1");
        SignInButton.shouldBe(Condition.disabled);


        refresh();
        closeCookie.click();
        email.setValue("demo@afdal.com");
        password.setValue("demo2022");
        SignInButton.shouldBe(Condition.enabled);


        return AfdalPageFactory.getHomepage();

    }



    @Override
    public IAfdalAnalyticsSignInPage ClickOn_SignUp() {

        refresh();
        closeCookie.click();
        signIn.waitUntil(Condition.visible, 3000).click();
        closeCookie.click();
        subscribeLink.click();
        System.out.println(WebDriverRunner.getWebDriver().getCurrentUrl());
        System.out.println(WebDriverRunner.getWebDriver().getTitle());
        return AfdalPageFactory.getHomepage();

    }

    @Override
    public IAfdalAnalyticsSignInPage Signin_with_apple_N() throws InterruptedException {
        refresh();
        closeCookie.click();
        signIn.waitUntil(Condition.visible, 3000).click();
        closeCookie.click();
        Thread.sleep(4000);
        appleIcon.click();
        switchTo().window(1);
        System.out.println(WebDriverRunner.getWebDriver().getCurrentUrl());
        System.out.println(WebDriverRunner.getWebDriver().getTitle());
        closeWindow();
        switchTo().window(0);
        return AfdalPageFactory.getHomepage();
    }





    @Override
    public IAfdalAnalyticsSignInPage Signin_with_google_N() throws InterruptedException {
        refresh();
        closeCookie.click();
        signIn.waitUntil(Condition.visible, 3000).click();
        closeCookie.click();
        Thread.sleep(2000);
        googleIcon.click();
        switchTo().window(1);
        System.out.println(WebDriverRunner.getWebDriver().getCurrentUrl());
        System.out.println(WebDriverRunner.getWebDriver().getTitle());
        closeWindow();
        switchTo().window(0);
        return AfdalPageFactory.getHomepage();
    }



    @Override
    public IAfdalAnalyticsSignInPage Signin_with_linkedIn_N() throws InterruptedException {
        refresh();
        closeCookie.click();
        signIn.waitUntil(Condition.visible, 3000).click();
        closeCookie.click();
        Thread.sleep(2000);
        linkedInIcon.click();
        switchTo().window(1);
        System.out.println(WebDriverRunner.getWebDriver().getCurrentUrl());
        System.out.println(WebDriverRunner.getWebDriver().getTitle());
        closeWindow();
        switchTo().window(0);
        return AfdalPageFactory.getHomepage();
    }







}
