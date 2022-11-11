package pageobjects.pages;


import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.PageFactoryClasses.AfdalAnalyticsSignUpPageFactory;


import static com.codeborne.selenide.Selenide.*;

public class AfdalAnalyticsSignUpPage implements IAfdalAnalyticsSignUpPage{


    SelenideElement closeCookie = $x("//div[@id='cookie-close-btn']");

    SelenideElement subscribeForFreeTextButton = $x("//a[contains(text(),'اشترك مجانا')]");
    SelenideElement subscribeHeader = $x("//h3[contains(text(),'اشترك')]");

    SelenideElement loginLink = $x("//a[@href=\"https://staging.afdalanalytics.com/login\"]//u[contains(text(),'تسجيل الدخول')]");

    SelenideElement subscribeDescription = $x("//p[contains(text(),\"ان كنت بالفعل مستخدم؟ \")]");

    SelenideElement firstnameText = $x("//label[contains(text(),'الاسم الأول')]");

    SelenideElement firstName = $x("//input[@name='first_name']");

    SelenideElement firstNameAlert = $x("//p[contains(text(),'حقل الاسم الأول مطلوب.')]");

    SelenideElement lastnameText = $x("//label[contains(text(),'اسم العائلة')]");

    SelenideElement lastName = $x("//input[@name='last_name']");

    SelenideElement lastNameAlert = $x("//p[contains(text(),'حقل الاسم الأخير مطلوب.')]");

    SelenideElement emailText = $x("//label[contains(text(),'البريد الإلكتروني')]");
    SelenideElement email = $x("//input[@name='email']");

    SelenideElement emailAlert = $x("//p[contains(text(),'حقل بريد إلكتروني مطلوب.')]");

    SelenideElement companyNameText = $x("//label[contains(text(),'إسم الشركة')]");
    SelenideElement companyName = $x("//input[@name ='company']");
    SelenideElement companyAlert = $x("//p[contains(text(),'حقل شركة مطلوب.')]");

    SelenideElement positionText = $x("//label[contains(text(),'موضع')]");

    SelenideElement positionDropDown = $x("//div[@id='role-icon']");
    ElementsCollection positionOptions = $$x("//ul[@id='list-role']//li");

    SelenideElement positionAlert = $x("//p[contains(text(),'حقل الدور مطلوب.')]");


    SelenideElement confirmPasswordText = $x("//label[contains(text(),'اكد كلمة المرور')]");
    SelenideElement confirmPassword = $x("//input[@id='confirm_password']");

    SelenideElement passwordText = $x("//label[contains(.,'كلمة المرور *')]");
    SelenideElement password = $x("//input[@id='password']");

    SelenideElement passwordAlert = $x("//form[@name='signupForm']//p[contains(text(), \"يجب أن تحتوي كلمة المرور على 8 أحرف على الأقل\")]");

    SelenideElement termsCheckbox = $x("//input[@id='exampleCheck1 mb-3']");

    SelenideElement subscribe = $x("(//button[contains(text(),'اشترك')])[1]");

    SelenideElement orSignUpWithText = $x("//span[contains(text(),'أو قم بالتسجيل باستخدام')]");


    SelenideElement appleicon = $x("//a[@id=\"apple\"]");

    SelenideElement linkedInIcon = $x("//a[@id=\"linkedIn\"]");

    SelenideElement googleIcon = $x("//a[@id=\"googleAuth\"]");

    SelenideElement twitterFooterIcon = $x("//a[@href=\"https://twitter.com/afdalanalytics\"]");

    SelenideElement instagramFooterIcon = $x("//a[@href=\"https://www.instagram.com/afdalanalytics\"]");

    SelenideElement facebookFooterIcon = $x("//a[@href=\"https://www.facebook.com/Afdal.Analytics\"]");

    SelenideElement linkedInFooterIcon = $x("//a[@href=\"https://www.linkedin.com/company/afdalanalytics\"]");


    @Override
    public  IAfdalAnalyticsSignUpPage Signup_Verify_UI() {
        closeCookie.click();
        subscribeForFreeTextButton.click();
        subscribeHeader.shouldHave(Condition.text("اشترك"));
        subscribeDescription.shouldHave(Condition.text("ان كنت بالفعل مستخدم؟ "));
        loginLink.shouldBe(Condition.visible);

        firstnameText.shouldHave(Condition.text("الاسم الأول "));
        firstName.shouldBe(Condition.visible);

        lastnameText.shouldHave(Condition.text("اسم العائلة "));
        lastName.shouldBe(Condition.visible);

        emailText.shouldHave(Condition.text("البريد الإلكتروني "));
        emailText.shouldBe(Condition.visible);

//        positionText.shouldHave(Condition.text("موضع"));
        positionDropDown.shouldBe(Condition.visible);

        companyNameText.shouldHave(Condition.text("إسم الشركة "));
        companyName.shouldBe(Condition.visible);

        passwordText.shouldHave(Condition.text("كلمة المرور "));
        password.shouldBe(Condition.visible);

        confirmPasswordText.shouldHave(Condition.text("اكد كلمة المرور"));
        companyName.shouldBe(Condition.visible);

        executeJavaScript("arguments[0].click();", termsCheckbox);
        termsCheckbox.shouldBe(Condition.visible,Condition.checked);

        subscribe.shouldBe(Condition.visible);

        orSignUpWithText.shouldHave(Condition.text("أو قم بالتسجيل باستخدام"));

        googleIcon.shouldBe(Condition.visible);

        linkedInIcon.shouldBe(Condition.visible);

        appleicon.shouldBe(Condition.visible);

        return AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }



    @Override
    public IAfdalAnalyticsSignUpPage SignUp_with_all_filed_empty_N() {
        refresh();
        closeCookie.click();
        subscribeForFreeTextButton.waitUntil(Condition.visible, 3000).click();
        closeCookie.click();
        subscribe.shouldBe(Condition.disabled);
        return  AfdalAnalyticsSignUpPageFactory.getSignUpPage();

    }



    @Override
    public IAfdalAnalyticsSignUpPage SignUp_with_valid_data() throws InterruptedException {
        refresh();
        closeCookie.click();
        subscribeForFreeTextButton.waitUntil(Condition.visible, 3000).click();
        closeCookie.click();
        firstName.setValue("Ankur");
        lastName.setValue("Behl");
        email.setValue("moz34.qwert@gmail.com");
        Thread.sleep(10000);
        executeJavaScript("arguments[0].click();", positionDropDown);
        System.out.println(positionOptions.size());
        for (SelenideElement e: positionOptions) {
            String text = e.getText();
            System.out.println(text);
            if (text.equals("مطور")) {
                e.click();
            }
        }
        companyName.setValue("Vtechys");
        password.setValue("demo2022");
        confirmPassword.setValue("demo2022");
        executeJavaScript("arguments[0].click();", termsCheckbox);
//        subscribe.click();
        executeJavaScript("arguments[0].click();", subscribe);
        //        WebDriverRunner.getWebDriver().findElement(By.xpath("(//button[contains(text(),'اشترك')])[1]")).click();
        return AfdalAnalyticsSignUpPageFactory.getSignUpPage();

    }






    @Override
    public IAfdalAnalyticsSignUpPage SignUp_Enter_all_data_Except_Companyname_N() {
// verify Subscribe header.....

        refresh();
        closeCookie.click();
        subscribeForFreeTextButton.waitUntil(Condition.visible, 3000).click();
        closeCookie.click();
        firstName.sendKeys("Ankur");
        lastName.sendKeys("Behl");
        email.setValue("moz34.qwert@gmail.com");

//        WebDriverRunner.getWebDriver().findElement(By.xpath("//div[@id='role-icon']")).click();
//    positionDropDown.click();
        executeJavaScript("arguments[0].click();", positionDropDown);

        System.out.println(positionOptions.size());
        for (SelenideElement e: positionOptions) {
            String text = e.getText();
            System.out.println(text);
            if (text.equals("مطور")) {
                e.click();
            }
        }
        password.sendKeys("demo2022");
        confirmPassword.sendKeys("demo2022");
        executeJavaScript("arguments[0].click();", termsCheckbox);
        executeJavaScript("arguments[0].click();", subscribe);
        closeCookie.click();
        companyAlert.shouldHave(Condition.text("حقل شركة مطلوب."));
        return AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }




    @Override
    public IAfdalAnalyticsSignUpPage SignUp_Enter_all_data_Except_Position_N() {
        refresh();
        closeCookie.click();
        subscribeForFreeTextButton.waitUntil(Condition.visible, 3000).click();
        closeCookie.click();
        firstName.sendKeys("Ankur");
        lastName.sendKeys("Behl");
        email.sendKeys("moz34.qwert@gamil.com");
        companyName.sendKeys("Vtechys");
        password.sendKeys("demo2022");
        confirmPassword.sendKeys("demo2022");
        termsCheckbox.click();
        subscribe.click();
        closeCookie.click();
        positionAlert.shouldHave(Condition.text("حقل الدور مطلوب."));

        return AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }


    @Override
    public IAfdalAnalyticsSignUpPage SignUp_Enter_all_data_Except_Email_N () {
        refresh();
        closeCookie.click();
        subscribeForFreeTextButton.waitUntil(Condition.visible, 3000).click();
        closeCookie.click();
        firstName.sendKeys("Ankur");
        lastName.sendKeys("Behl");
        executeJavaScript("arguments[0].click();", positionDropDown);
        System.out.println(positionOptions.size());
        for (SelenideElement e: positionOptions) {
            String text = e.getText();
            System.out.println(text);
            if (text.equals("مطور")) {
                e.click();
            }
        }
        companyName.sendKeys("Vtechys");
        password.sendKeys("demo2022");
        confirmPassword.sendKeys("demo2022");
        executeJavaScript("arguments[0].click();", termsCheckbox);
//        subscribe.click();
        executeJavaScript("arguments[0].click();", subscribe);
        closeCookie.click();
        emailAlert.shouldHave(Condition.text("حقل بريد إلكتروني مطلوب."));
        return AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }




    @Override
    public IAfdalAnalyticsSignUpPage SignUp_Enter_all_data_Except_Firstname_N() throws InterruptedException {
        refresh();
        closeCookie.click();
        subscribeForFreeTextButton.waitUntil(Condition.visible, 3000).click();
        closeCookie.click();
        lastName.sendKeys("Behl");
        email.sendKeys("Demo@afdal.com");
        executeJavaScript("arguments[0].click();", positionDropDown);
        Thread.sleep(10000);
        System.out.println(positionOptions.size());
        for (SelenideElement e: positionOptions) {
            String text = e.getText();
            System.out.println(text);
            if (text.equals("مطور")) {
                e.click();
            }
        }
        companyName.sendKeys("Vtechys");
        password.sendKeys("demo2022");
        confirmPassword.sendKeys("demo2022");
        executeJavaScript("arguments[0].click();", termsCheckbox);
//        subscribe.click();
        executeJavaScript("arguments[0].click();", subscribe);

        closeCookie.click();
        firstNameAlert.shouldHave(Condition.text("حقل الاسم الأول مطلوب."));
        return AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }

    @Override
    public IAfdalAnalyticsSignUpPage SignUp_Enter_all_data_Except_Lastname_N() {
        refresh();
        closeCookie.click();
        subscribeForFreeTextButton.waitUntil(Condition.visible, 3000).click();
        closeCookie.click();
        firstName.sendKeys("Ankur");
        email.sendKeys("moz34.qwert@gmail.com");

//        positionDropDown.click();
        executeJavaScript("arguments[0].click();", positionDropDown);

        System.out.println(positionOptions.size());
        for (SelenideElement e: positionOptions) {
            String text = e.getText();
            System.out.println(text);
            if (text.equals("مطور")) {
                e.click();
            }
        }        companyName.sendKeys("Vtechys");
        password.sendKeys("demo2022");
        confirmPassword.sendKeys("demo2022");
        executeJavaScript("arguments[0].click();", termsCheckbox);
//        subscribe.click();
        executeJavaScript("arguments[0].click();", subscribe);

        closeCookie.click();
        lastNameAlert.shouldHave(Condition.text("حقل الاسم الأخير مطلوب."));
        return AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }




    @Override
    public IAfdalAnalyticsSignUpPage Email_validation_N() throws InterruptedException {
        refresh();
        closeCookie.click();
        subscribeForFreeTextButton.waitUntil(Condition.visible, 3000).click();
        closeCookie.click();
        firstName.sendKeys("Ankur");
        lastName.sendKeys("Behl");
        email.clear();
        email.setValue("testatgmail.com");
        executeJavaScript("arguments[0].click();", positionDropDown);
        System.out.println(positionOptions.size());
        for (SelenideElement e: positionOptions) {
            String text = e.getText();
            System.out.println(text);
            if (text.equals("مطور")) {
                e.click();
            }
        }
        companyName.sendKeys("Vtechys");
        password.clear();
        password.sendKeys("demo2022");
        confirmPassword.sendKeys("demo2022");
        executeJavaScript("arguments[0].click();", termsCheckbox);
//        subscribe.click();
        executeJavaScript("arguments[0].click();", subscribe);

        Thread.sleep(10000);


        refresh();
        closeCookie.click();

        firstName.sendKeys("Ankur");
        lastName.sendKeys("Behl");
        email.clear();
        email.setValue("test@gmail");
        executeJavaScript("arguments[0].click();", positionDropDown);
        System.out.println(positionOptions.size());
        for (SelenideElement e: positionOptions) {
            String text = e.getText();
            System.out.println(text);
            if (text.equals("مطور")) {
                e.click();
            }
        }
        companyName.sendKeys("Vtechys");
        password.clear();
        password.sendKeys("demo2022");
        confirmPassword.sendKeys("demo2022");
        executeJavaScript("arguments[0].click();", termsCheckbox);
//        subscribe.click();
        executeJavaScript("arguments[0].click();", subscribe);

        Thread.sleep(10000);
        refresh();
        closeCookie.click();
        firstName.sendKeys("Ankur");
        lastName.sendKeys("Behl");
        email.clear();
        email.setValue("demo@afdalcom");
        executeJavaScript("arguments[0].click();", positionDropDown);
        System.out.println(positionOptions.size());
        for (SelenideElement e: positionOptions) {
            String text = e.getText();
            System.out.println(text);
            if (text.equals("مطور")) {
                e.click();
            }
        }
        companyName.sendKeys("Vtechys");
        password.clear();
        password.sendKeys("demo2022");
        confirmPassword.sendKeys("demo2022");
        executeJavaScript("arguments[0].click();", termsCheckbox);
//        subscribe.click();
        executeJavaScript("arguments[0].click();", subscribe);

        Thread.sleep(10000);

        refresh();
        closeCookie.click();
        firstName.sendKeys("Ankur");
        lastName.sendKeys("Behl");
        email.clear();
        email.setValue("@gmail");
        executeJavaScript("arguments[0].click();", positionDropDown);
        System.out.println(positionOptions.size());
        for (SelenideElement e: positionOptions) {
            String text = e.getText();
            System.out.println(text);
            if (text.equals("مطور")) {
                e.click();
            }
        }
        companyName.sendKeys("Vtechys");
        password.clear();
        password.sendKeys("demo2022");
        confirmPassword.sendKeys("demo2022");
        executeJavaScript("arguments[0].click();", termsCheckbox);
//        subscribe.click();
        executeJavaScript("arguments[0].click();", subscribe);

        return AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }








    @Override
    public IAfdalAnalyticsSignUpPage Password_validation_N() throws InterruptedException {

        refresh();
        closeCookie.click();
        subscribeForFreeTextButton.waitUntil(Condition.visible, 3000).click();
        closeCookie.click();
        firstName.sendKeys("Ankur");
        lastName.sendKeys("Behl");
        email.setValue("demo@afdal.com");
        Selenide.executeJavaScript("arguments[0].click();", positionDropDown);
        System.out.println(positionOptions.size());
        for (SelenideElement e: positionOptions) {
            String text = e.getText();
            System.out.println(text);
            if (text.equals("مطور")) {
                e.click();
            }
        }
        companyName.sendKeys("Vtechys");
        password.sendKeys("demo");
        confirmPassword.sendKeys("demo");
        Selenide.executeJavaScript("arguments[0].click();", termsCheckbox);
        subscribe.shouldBe(Condition.disabled);
        passwordAlert.shouldHave(Condition.text("يجب أن تحتوي كلمة المرور على 8 أحرف على الأقل"));




        refresh();
        closeCookie.click();
        email.setValue("demo@afdal.com");
        firstName.sendKeys("Ankur");
        lastName.sendKeys("Behl");
        email.setValue("demo@afdal.com");
        Thread.sleep(10000);
        Selenide.executeJavaScript("arguments[0].click();", positionDropDown);
        Thread.sleep(10000);
        System.out.println(positionOptions.size());
        for (SelenideElement e: positionOptions) {
            String text = e.getText();
//            System.out.println(text);
            if (text.equals("مطور")) {
                Selenide.executeJavaScript("arguments[0].click();", e);

            }
        }
        companyName.sendKeys("Vtechys");
        password.sendKeys("demo2022");
        confirmPassword.sendKeys("demo2022");
        Selenide.executeJavaScript("arguments[0].click();", termsCheckbox);
        subscribe.shouldBe(Condition.enabled);


        return AfdalAnalyticsSignUpPageFactory.getSignUpPage();

    }

    @Override
    public IAfdalAnalyticsSignUpPage Click_on_SignIn() throws InterruptedException {
        refresh();
        closeCookie.click();
        subscribeForFreeTextButton.waitUntil(Condition.visible, 3000).click();
        closeCookie.click();
        loginLink.click();
        System.out.println(WebDriverRunner.getWebDriver().getCurrentUrl());
        System.out.println(WebDriverRunner.getWebDriver().getTitle());
        Thread.sleep(4000);
        return AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }

    @Override
    public IAfdalAnalyticsSignUpPage SignUp_with_apple_N() throws InterruptedException {
        refresh();
        closeCookie.click();
        subscribeForFreeTextButton.waitUntil(Condition.visible, 3000).click();
        closeCookie.click();
        Thread.sleep(4000);

        appleicon.click();
        switchTo().window(1);
        System.out.println(WebDriverRunner.getWebDriver().getCurrentUrl());
        System.out.println(WebDriverRunner.getWebDriver().getTitle());
        closeWindow();
        switchTo().window(0);
        return AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }











    @Override
    public IAfdalAnalyticsSignUpPage SignUp_with_google_N() throws InterruptedException {
        refresh();
        closeCookie.click();
        subscribeForFreeTextButton.waitUntil(Condition.visible, 3000).click();
        closeCookie.click();
        Thread.sleep(4000);
        googleIcon.click();
        switchTo().window(1);
        System.out.println(WebDriverRunner.getWebDriver().getCurrentUrl());
        System.out.println(WebDriverRunner.getWebDriver().getTitle());
        closeWindow();
        switchTo().window(0);
        return AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }



    @Override
    public IAfdalAnalyticsSignUpPage SignUp_with_linkedIn_N() throws InterruptedException {
        refresh();
        closeCookie.click();
        subscribeForFreeTextButton.waitUntil(Condition.visible, 3000).click();
        closeCookie.click();
        Thread.sleep(2000);
        linkedInIcon.click();
        switchTo().window(1);
        System.out.println(WebDriverRunner.getWebDriver().getCurrentUrl());
        System.out.println(WebDriverRunner.getWebDriver().getTitle());
        closeWindow();
        switchTo().window(0);
        return AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }


    @Override
    public IAfdalAnalyticsSignUpPage verifyTwitterIcon() throws InterruptedException {
        refresh();
        closeCookie.click();
        subscribeForFreeTextButton.waitUntil(Condition.visible, 3000).click();
        closeCookie.click();
        Thread.sleep(10000);
        twitterFooterIcon.click();
        switchTo().window(1);
        System.out.println(WebDriverRunner.getWebDriver().getTitle());
        System.out.println(WebDriverRunner.getWebDriver().getCurrentUrl());
        closeWindow();
        switchTo().window(0);
        return  AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }

    @Override
    public IAfdalAnalyticsSignUpPage verifyInstagramIcon() throws InterruptedException {
        refresh();
        closeCookie.click();
        subscribeForFreeTextButton.waitUntil(Condition.visible, 3000).click();
        closeCookie.click();
        Thread.sleep(10000);
        instagramFooterIcon.click();
        switchTo().window(1);
        System.out.println(WebDriverRunner.getWebDriver().getTitle());
        System.out.println(WebDriverRunner.getWebDriver().getCurrentUrl());
        closeWindow();
        switchTo().window(0);
        return  AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }

    @Override
    public IAfdalAnalyticsSignUpPage verifyLinkedInIcon() throws InterruptedException {
        refresh();
        closeCookie.click();
        subscribeForFreeTextButton.waitUntil(Condition.visible, 3000).click();
        closeCookie.click();
        Thread.sleep(10000);
        linkedInFooterIcon.click();
        switchTo().window(1);
        System.out.println(WebDriverRunner.getWebDriver().getTitle());
        System.out.println(WebDriverRunner.getWebDriver().getCurrentUrl());
        return  AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }

    @Override
    public IAfdalAnalyticsSignUpPage verifyFacebookIcon() throws InterruptedException {
        refresh();
        closeCookie.click();
        subscribeForFreeTextButton.waitUntil(Condition.visible, 3000).click();
        closeCookie.click();
        Thread.sleep(10000);
        facebookFooterIcon.click();
        switchTo().window(1);
        System.out.println(WebDriverRunner.getWebDriver().getTitle());
        System.out.println(WebDriverRunner.getWebDriver().getCurrentUrl());
        closeWindow();
        switchTo().window(0);
        return  AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }



}
