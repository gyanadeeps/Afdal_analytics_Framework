package pageobjects.pages;


import com.codeborne.selenide.*;
import org.testng.Assert;
import pageobjects.PageFactoryClasses.AfdalAnalyticsSignUpPageFactory;


import static com.codeborne.selenide.Selenide.*;

public class AfdalAnalyticsSignUpPage implements IAfdalAnalyticsSignUpPage{


    SelenideElement getAcceptCookie_Button = $x("//button[contains(text(),'مُوَافق')]");

    SelenideElement getCloseCookie_CrossSign = $x("//div[@id='cookie-close-btn']");
    SelenideElement getSubscribeForFree = $x("//a[contains(text(),'اشترك مجانا')]");
    SelenideElement getHeader_Subscribe = $x("//h3[contains(text(),'اشترك')]");

    SelenideElement getLink_Login = $x("//p[@class='sign-up-subtitle text-center text-white signup-page-link-signin sign-up-sub signup-rev font-20-lh-42-semi-bold']//u[contains(text(),'تسجيل الدخول')]");

    SelenideElement getHeaderDescription_Subscribe = $x("//p[@class='sign-up-subtitle text-center text-white signup-page-link-signin sign-up-sub signup-rev font-20-lh-42-semi-bold']//span[@class='signup-already-have-account']");

    SelenideElement getSubHeader_FirstName = $x("//body/div[@class='sign-up-4k']/div[@class='circle-wrapper-block']/div[@class='container mr-cont circle-content p-0']/form[@name='signupForm']/div[1]/div[1]");

    SelenideElement getSubHeader_FirstNameInput = $x("//input[@name='first_name']");

    SelenideElement getSubHeader_LastName = $x("//body/div[@class='sign-up-4k']/div[@class='circle-wrapper-block']/div[@class='container mr-cont circle-content p-0']/form[@name='signupForm']/div[1]/div[2]");

    SelenideElement getSubHeader_LastNameInput = $x("//input[@name='last_name']");

    SelenideElement getSubHeader_Email = $x("//label[contains(text(),'البريد الإلكتروني')]");
    SelenideElement getSubHeader_EmailInput = $x("//input[@name='email']");

    SelenideElement getAlert_EmailInvalid = $x("//div[@class='center-error']//p[contains(text(),'تنسيق بريد إلكتروني غير صالح.')]");
    SelenideElement getSubHeader_CompanyName = $x("(//div[@class='forms-wrapper small text-right'])[3]");
    SelenideElement getSubHeader_CompanyNameInput = $x("//input[@name ='company']");

    SelenideElement getSubHeader_Function = $x("//div[@class='forms-wrapper big-wrapper small text-right']");
    SelenideElement getSubHeader_PositionInput = $x("//div[@id='select-role']");

    SelenideElement getSubHeader_PositionInputDropDownIcon = $x("//div[@id='role-icon']");
    ElementsCollection getPositionOptions = $$x("//ul[@id='list-role']//li");

    SelenideElement getSubHeader_ConfirmPassword = $x("(//div[@class='forms-wrapper small text-right'])[5]");
    SelenideElement getSubHeader_ConfirmPasswordInput = $x("//input[@id='confirm_password']");

    SelenideElement getSubHeader_Password = $x("(//div[@class='forms-wrapper small text-right'])[4]");
    SelenideElement getSubHeader_PasswordInput = $x("//input[@id='password']");

    SelenideElement getCheckbox_Terms = $x("//input[@id='exampleCheck1 mb-3']");

    SelenideElement getSubscribeButton = $x("//div[@class='forms-wrapper text-center']//button[contains(text(),'اشترك')]");

    SelenideElement getSubHeader_OrSignupWithText = $x("//span[contains(text(),'أو قم بالتسجيل باستخدام')]");


    SelenideElement getAppleIcon = $x("//a[@id=\"apple\"]");

    SelenideElement getLinkedInIcon = $x("//a[@id=\"linkedIn\"]");

    SelenideElement getGoogleIcon = $x("//a[@id=\"googleAuth\"]");

    SelenideElement getTwitterFooterIcon = $x("//div[@class='footer-social-links']//a[@class='footer-social-link footer-social-link--twitter']");

    SelenideElement getInstagramFooterIcon = $x("//div[@class='footer-social-links']//a[@class='footer-social-link footer-social-link--instagram']");

    SelenideElement getFacebookFooterIcon = $x("//div[@class='footer-social-links']//a[@class='footer-social-link footer-social-link--facebook']");

    SelenideElement getLinkedInFooterIcon = $x("//div[@class='footer-social-links']//a[@class='footer-social-link footer-social-link--linkedin']");




    @Override
    public  IAfdalAnalyticsSignUpPage Signup_Verify_UI() {



//        Assertion on Sign Up Section.......

        getSubscribeForFree.click();
        getHeader_Subscribe.shouldHave(Condition.exactText("اشترك"));
        String headerDescription = getHeaderDescription_Subscribe.getText();
        Assert.assertEquals(headerDescription, "ان كنت بالفعل مستخدم؟");
        String loginLink = getLink_Login.getText();
        Assert.assertEquals(loginLink,"تسجيل الدخول");

        String firstName = getSubHeader_FirstName.getText();
        Assert.assertEquals(firstName,"الاسم الأول *");
        getSubHeader_FirstNameInput.shouldBe(Condition.visible);


        String lastName = getSubHeader_LastName.getText();
        Assert.assertEquals(lastName,"اسم العائلة *");
        getSubHeader_LastNameInput.shouldBe(Condition.visible);

        String email = getSubHeader_Email.getText();
        Assert.assertEquals(email,"البريد الإلكتروني *");
        getSubHeader_Email.shouldBe(Condition.visible);

        String function = getSubHeader_Function.getText();
//        Assert.assertEquals(function,"وظيفة *");
        getSubHeader_PositionInput.shouldBe(Condition.visible);

        String companyName = getSubHeader_CompanyName.getText();
        Assert.assertEquals(companyName,"إسم الشركة *");
        getSubHeader_CompanyNameInput.shouldBe(Condition.visible);


        String password = getSubHeader_Password.getText();
        Assert.assertEquals(password,"كلمة المرور *");
        getSubHeader_PasswordInput.shouldBe(Condition.visible);

        String confirmPassword = getSubHeader_ConfirmPassword.getText();
        Assert.assertEquals(confirmPassword, "اكد كلمة المرور*");
        getSubHeader_CompanyNameInput.shouldBe(Condition.visible);

        getCheckbox_Terms.shouldBe(Condition.visible);

        getSubscribeButton.shouldBe(Condition.visible);

        // Assertion on Or Signup with Section..................
        getSubHeader_OrSignupWithText.shouldHave(Condition.exactText("أو قم بالتسجيل باستخدام"));

        getGoogleIcon.shouldBe(Condition.visible);

        getLinkedInIcon.shouldBe(Condition.visible);

        getAppleIcon.shouldBe(Condition.visible);

        return AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }




    @Override
    public IAfdalAnalyticsSignUpPage SignUp_with_all_filed_empty_N() {


        getAcceptCookie_Button.click();
        getSubscribeForFree.click();
        getSubscribeButton.isEnabled();
        return  AfdalAnalyticsSignUpPageFactory.getSignUpPage();

    }


    @Override
    public IAfdalAnalyticsSignUpPage SignUp_with_valid_data() {
        refresh();
        getSubHeader_FirstNameInput.sendKeys("Ankur");
        getSubHeader_LastNameInput.sendKeys("Behl");
        getSubHeader_EmailInput.sendKeys("Demo@gmail.com");
        getSubHeader_PositionInput.click();
        getSubHeader_PositionInputDropDownIcon.click();
        executeJavaScript("arguments[0].click();", getSubHeader_PositionInputDropDownIcon);
        System.out.println(getPositionOptions.size());
        for (SelenideElement e: getPositionOptions) {
            String text = e.getText();
            System.out.println(text);
            if (text.equals("مطور")) {
                e.click();
            }
        }
        getSubHeader_CompanyNameInput.sendKeys("Vtechys");
        getSubHeader_PasswordInput.sendKeys("12345678");
        getSubHeader_ConfirmPasswordInput.sendKeys("12345678");
        getCheckbox_Terms.click();
        getSubscribeButton.click();
        back();
        return AfdalAnalyticsSignUpPageFactory.getSignUpPage();

    }


    @Override
    public IAfdalAnalyticsSignUpPage SignUp_Enter_all_data_Except_Companyname_N() {
// verify Subscribe header.....

        refresh();
        getSubHeader_FirstNameInput.sendKeys("Ankur");
        getSubHeader_LastNameInput.sendKeys("Behl");
        getSubHeader_EmailInput.sendKeys("Demo@gmail.com");
        getSubHeader_PositionInput.click();
        getSubHeader_PositionInputDropDownIcon.click();
        executeJavaScript("arguments[0].click();", getSubHeader_PositionInputDropDownIcon);
        System.out.println(getPositionOptions.size());
        for (SelenideElement e: getPositionOptions) {
            String text = e.getText();
            System.out.println(text);
            if (text.equals("مطور")) {
                e.click();
            }
        }
        getSubHeader_PasswordInput.sendKeys("12345678");
        getSubHeader_ConfirmPasswordInput.sendKeys("12345678");
        getCheckbox_Terms.click();
        getSubscribeButton.click();
        return AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }



    @Override
    public IAfdalAnalyticsSignUpPage SignUp_Enter_all_data_Except_Position_N() {
        refresh();

        getSubHeader_FirstNameInput.sendKeys("Ankur");
        getSubHeader_LastNameInput.sendKeys("Behl");
        getSubHeader_EmailInput.sendKeys("Demo@gmail.com");
        getSubHeader_CompanyNameInput.sendKeys("Vtechys");
        getSubHeader_PasswordInput.sendKeys("12345678");
        getSubHeader_ConfirmPasswordInput.sendKeys("12345678");
        getCheckbox_Terms.click();
        getSubscribeButton.click();

        return AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }

    @Override
    public IAfdalAnalyticsSignUpPage SignUp_Enter_all_data_Except_Email_N () {
        refresh();

        getSubHeader_FirstNameInput.sendKeys("Ankur");
        getSubHeader_LastNameInput.sendKeys("Behl");
        getSubHeader_PositionInput.click();
        getSubHeader_PositionInputDropDownIcon.click();
        executeJavaScript("arguments[0].click();", getSubHeader_PositionInputDropDownIcon);
        System.out.println(getPositionOptions.size());
        for (SelenideElement e: getPositionOptions) {
            String text = e.getText();
            System.out.println(text);
            if (text.equals("مطور")) {
                e.click();
            }
        }
        getSubHeader_CompanyNameInput.sendKeys("Vtechys");
        getSubHeader_PasswordInput.sendKeys("12345678");
        getSubHeader_ConfirmPasswordInput.sendKeys("12345678");
        getCheckbox_Terms.click();
        getSubscribeButton.click();
        return AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }

    @Override
    public IAfdalAnalyticsSignUpPage SignUp_Enter_all_data_Except_Firstname_N() {
        refresh();
        getSubHeader_LastNameInput.sendKeys("Behl");
        getSubHeader_EmailInput.sendKeys("Demo@gmail.com");
        getSubHeader_PositionInput.click();
        getSubHeader_PositionInputDropDownIcon.click();
        executeJavaScript("arguments[0].click();", getSubHeader_PositionInputDropDownIcon);
        System.out.println(getPositionOptions.size());
        for (SelenideElement e: getPositionOptions) {
            String text = e.getText();
            System.out.println(text);
            if (text.equals("مطور")) {
                e.click();
            }
        }
        getSubHeader_CompanyNameInput.sendKeys("Vtechys");
        getSubHeader_PasswordInput.sendKeys("12345678");
        getSubHeader_ConfirmPasswordInput.sendKeys("12345678");
        getCheckbox_Terms.click();
        getSubscribeButton.click();
        return AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }

    @Override
    public IAfdalAnalyticsSignUpPage SignUp_Enter_all_data_Except_Lastname_N() {
        refresh();

        getSubHeader_FirstNameInput.sendKeys("Ankur");
        getSubHeader_EmailInput.sendKeys("Demo@gmail.com");
        getSubHeader_PositionInput.click();
        getSubHeader_PositionInputDropDownIcon.click();
        executeJavaScript("arguments[0].click();", getSubHeader_PositionInputDropDownIcon);
        System.out.println(getPositionOptions.size());
        for (SelenideElement e: getPositionOptions) {
            String text = e.getText();
            System.out.println(text);
            if (text.equals("مطور")) {
                e.click();
            }
        }
        getSubHeader_CompanyNameInput.sendKeys("Vtechys");
        getSubHeader_PasswordInput.sendKeys("12345678");
        getSubHeader_ConfirmPasswordInput.sendKeys("12345678");
        getCheckbox_Terms.click();
        getSubscribeButton.click();
        return AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }

    @Override
    public IAfdalAnalyticsSignUpPage Email_validation_N() throws InterruptedException {
        refresh();

        getSubHeader_FirstNameInput.sendKeys("Ankur");
        getSubHeader_LastNameInput.sendKeys("Behl");
//        String email_error1 = String.valueOf(getSubHeader_EmailInput.setValue("testatgmail.com"));
//        Assert.assertEquals(email_error1,"test@gmail.com");
        getSubHeader_EmailInput.setValue("testatgmail.com");
        getSubHeader_PositionInput.click();
        getSubHeader_PositionInputDropDownIcon.click();
        executeJavaScript("arguments[0].click();", getSubHeader_PositionInputDropDownIcon);
        System.out.println(getPositionOptions.size());
        for (SelenideElement e: getPositionOptions) {
            String text = e.getText();
            System.out.println(text);
            if (text.equals("مطور")) {
                e.click();
            }
        }
        getSubHeader_CompanyNameInput.sendKeys("Vtechys");
        getSubHeader_PasswordInput.sendKeys("12345678");
        getSubHeader_ConfirmPasswordInput.sendKeys("12345678");
        getCheckbox_Terms.click();
        getSubscribeButton.click();
        getAlert_EmailInvalid.shouldHave(Condition.exactText("تنسيق بريد إلكتروني غير صالح."));
        Thread.sleep(4000);


        refresh();


        getSubHeader_FirstNameInput.sendKeys("Ankur");
        getSubHeader_LastNameInput.sendKeys("Behl");
//        String email_error2 = String.valueOf(getSubHeader_EmailInput.setValue("test@gmail"));
//        Assert.assertEquals(email_error2,"test@gmail.com");
        getSubHeader_EmailInput.setValue("test@gmail");
        getSubHeader_PositionInput.click();
        getSubHeader_PositionInputDropDownIcon.click();
        executeJavaScript("arguments[0].click();", getSubHeader_PositionInputDropDownIcon);
        System.out.println(getPositionOptions.size());
        for (SelenideElement e: getPositionOptions) {
            String text = e.getText();
            System.out.println(text);
            if (text.equals("مطور")) {
                e.click();
            }
        }
        getSubHeader_CompanyNameInput.sendKeys("Vtechys");
        getSubHeader_PasswordInput.sendKeys("12345678");
        getSubHeader_ConfirmPasswordInput.sendKeys("12345678");
        getCheckbox_Terms.click();
        getSubscribeButton.click();
        getAlert_EmailInvalid.shouldHave(Condition.exactText("تنسيق بريد إلكتروني غير صالح."));



        Thread.sleep(4000);
        refresh();
        getSubHeader_FirstNameInput.sendKeys("Ankur");
        getSubHeader_LastNameInput.sendKeys("Behl");
//        String email_error3 = String.valueOf(getSubHeader_EmailInput.setValue("test@gmailcom"));
//        Assert.assertEquals(email_error3,"test@gmail.com");
        getSubHeader_EmailInput.setValue("test@gmailcom");
        getSubHeader_PositionInput.click();
        getSubHeader_PositionInputDropDownIcon.click();
        executeJavaScript("arguments[0].click();", getSubHeader_PositionInputDropDownIcon);
        System.out.println(getPositionOptions.size());
        for (SelenideElement e: getPositionOptions) {
            String text = e.getText();
            System.out.println(text);
            if (text.equals("مطور")) {
                e.click();
            }
        }
        getSubHeader_CompanyNameInput.sendKeys("Vtechys");
        getSubHeader_PasswordInput.sendKeys("demo123456");
        getSubHeader_ConfirmPasswordInput.sendKeys("demo123456");
        getCheckbox_Terms.click();
        getSubscribeButton.click();
        getAlert_EmailInvalid.shouldHave(Condition.exactText("تنسيق بريد إلكتروني غير صالح."));

        Thread.sleep(4000);

        refresh();

        getSubHeader_FirstNameInput.sendKeys("Ankur");
        getSubHeader_LastNameInput.sendKeys("Behl");
//        String email_error4 = String.valueOf(getSubHeader_EmailInput.setValue("@gmail"));
//        Assert.assertEquals(email_error4,"test@gmail.com");
        getSubHeader_EmailInput.setValue("@gmail");
        getSubHeader_PositionInput.click();
        getSubHeader_PositionInputDropDownIcon.click();
        executeJavaScript("arguments[0].click();", getSubHeader_PositionInputDropDownIcon);
        System.out.println(getPositionOptions.size());
        for (SelenideElement e: getPositionOptions) {
            String text = e.getText();
            System.out.println(text);
            if (text.equals("مطور")) {
                e.click();
            }
        }
        getSubHeader_CompanyNameInput.sendKeys("Vtechys");
        getSubHeader_PasswordInput.sendKeys("12345678");
        getSubHeader_ConfirmPasswordInput.sendKeys("12345678");
        getCheckbox_Terms.click();
        getSubscribeButton.click();
        getAlert_EmailInvalid.shouldHave(Condition.exactText("تنسيق بريد إلكتروني غير صالح."));
        return AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }

    @Override
    public IAfdalAnalyticsSignUpPage Password_validation_N() throws InterruptedException {

        refresh();

        getSubHeader_FirstNameInput.sendKeys("Ankur");
        getSubHeader_LastNameInput.sendKeys("Behl");
        getSubHeader_EmailInput.sendKeys("demo2@gmail.com");
        getSubHeader_PositionInput.click();
        getSubHeader_PositionInputDropDownIcon.click();
        executeJavaScript("arguments[0].click();", getSubHeader_PositionInputDropDownIcon);
        System.out.println(getPositionOptions.size());
        for (SelenideElement e: getPositionOptions) {
            String text = e.getText();
            System.out.println(text);
            if (text.equals("مطور")) {
                e.click();
            }
        }
        getSubHeader_CompanyNameInput.sendKeys("Vtechys");
//        String passord_error1 = String.valueOf(getSubHeader_PasswordInput.setValue("12345"));
//        Assert.assertEquals(passord_error1,"123456");
        getSubHeader_PasswordInput.setValue("demo1");
        getSubHeader_ConfirmPasswordInput.sendKeys("demo1");
        getCheckbox_Terms.click();
        getSubscribeButton.shouldBe(Condition.disabled);

        refresh();
        getSubHeader_FirstNameInput.sendKeys("Ankur");
        getSubHeader_LastNameInput.sendKeys("Behl");
        getSubHeader_EmailInput.sendKeys("Demo@gmail.com");
        getSubHeader_PositionInput.click();
        getSubHeader_PositionInputDropDownIcon.click();
        executeJavaScript("arguments[0].click();", getSubHeader_PositionInputDropDownIcon);
        System.out.println(getPositionOptions.size());
        for (SelenideElement e: getPositionOptions) {
            String text = e.getText();
            System.out.println(text);
            if (text.equals("مطور")) {
                e.click();
            }
        }
        getSubHeader_CompanyNameInput.sendKeys("Vtechys");
//        String passord_error2 = String.valueOf(getSubHeader_PasswordInput.setValue("123456"));
//        Assert.assertEquals(passord_error2,"123456");
        getSubHeader_PasswordInput.setValue("demo2022");
        getSubHeader_ConfirmPasswordInput.sendKeys("demo2022");
        getCheckbox_Terms.click();
        getSubscribeButton.shouldBe(Condition.enabled);
        return AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }

    @Override
    public IAfdalAnalyticsSignUpPage SignUp_without_checking_Afdal_terms_checkbox_N() {
        refresh();
        getSubHeader_FirstNameInput.sendKeys("Ankur");
        getSubHeader_LastNameInput.sendKeys("Behl");
        getSubHeader_EmailInput.sendKeys("Demo@gmail.com");
        getSubHeader_PositionInput.click();
        getSubHeader_PositionInputDropDownIcon.click();
        executeJavaScript("arguments[0].click();", getSubHeader_PositionInputDropDownIcon);
        System.out.println(getPositionOptions.size());
        for (SelenideElement e: getPositionOptions) {
            String text = e.getText();
            System.out.println(text);
            if (text.equals("مطور")) {
                e.click();
            }
        }
        getSubHeader_CompanyNameInput.sendKeys("Vtechys");
        getSubHeader_PasswordInput.sendKeys("12345678");
        getSubHeader_ConfirmPasswordInput.sendKeys("12345678");
        getSubscribeButton.click();
        getCheckbox_Terms.isSelected();
        return AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }

    @Override
    public IAfdalAnalyticsSignUpPage SignUp_checking_Afdal_terms_with_checkbox() throws InterruptedException {
        refresh();
        getSubHeader_FirstNameInput.sendKeys("Ankur");
        getSubHeader_LastNameInput.sendKeys("Behl");
        getSubHeader_EmailInput.sendKeys("Demo@gmail.com");
        getSubHeader_PositionInput.click();
        getSubHeader_PositionInputDropDownIcon.click();
        executeJavaScript("arguments[0].click();", getSubHeader_PositionInputDropDownIcon);
        System.out.println(getPositionOptions.size());
        for (SelenideElement e: getPositionOptions) {
            String text = e.getText();
            System.out.println(text);
            if (text.equals("مطور")) {
                e.click();
            }
        }
        getSubHeader_CompanyNameInput.sendKeys("Vtechys");
        getSubHeader_PasswordInput.sendKeys("12345678");
        getSubHeader_ConfirmPasswordInput.sendKeys("12345678");
        getCheckbox_Terms.click();
        getCheckbox_Terms.shouldBe(Condition.checked);
        getSubscribeButton.click();


        return AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }

    @Override
    public IAfdalAnalyticsSignUpPage Click_on_SignIn() {
        refresh();
        getSubHeader_FirstNameInput.sendKeys("Ankur");
        getSubHeader_LastNameInput.sendKeys("Behl");
        getSubHeader_EmailInput.sendKeys("Demo@gmail.com");
        getSubHeader_PositionInput.click();
        getSubHeader_PositionInputDropDownIcon.click();
        executeJavaScript("arguments[0].click();", getSubHeader_PositionInputDropDownIcon);
        System.out.println(getPositionOptions.size());
        for (SelenideElement e: getPositionOptions) {
            String text = e.getText();
            System.out.println(text);
            if (text.equals("مطور")) {
                e.click();
            }
        }
        getSubHeader_CompanyNameInput.sendKeys("Vtechys");
        getSubHeader_PasswordInput.sendKeys("12345678");
        getSubHeader_ConfirmPasswordInput.sendKeys("12345678");
        getCheckbox_Terms.click();
        getSubscribeButton.click();
        return AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }

    @Override
    public IAfdalAnalyticsSignUpPage SignUp_with_google_N() {
        getGoogleIcon.click();
        switchTo().window(1);
        boolean googleURL = WebDriverRunner.getWebDriver().getCurrentUrl().startsWith("https://accounts.google.com/");
        Assert.assertTrue(googleURL);
        String googleTitle = WebDriverRunner.getWebDriver().getTitle();
        Boolean title = googleTitle.contains("Google Accounts");
        Assert.assertTrue(title);
//        Assert.assertEquals(googleTitle,"Sign in - Google Accounts");
        System.out.println(googleTitle);
//        Assert.assertTrue(Boolean.parseBoolean(googleTitle),"Sign In - Google");
        closeWindow();
        switchTo().window(0);
        return AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }

    @Override
    public IAfdalAnalyticsSignUpPage SignUp_with_linkedIn_N() {
        getLinkedInIcon.click();
        switchTo().window(1);
        boolean linkedinURL = WebDriverRunner.getWebDriver().getCurrentUrl().startsWith("https://www.linkedin.com/");
        Assert.assertTrue(linkedinURL);
        String linkedinTitle = WebDriverRunner.getWebDriver().getTitle();
        Assert.assertEquals(linkedinTitle,"LinkedIn Login, Sign in | LinkedIn");
        closeWindow();
        switchTo().window(0);
        return  AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }


    @Override
    public IAfdalAnalyticsSignUpPage SignUp_with_apple_N() {
        getAppleIcon.click();
        switchTo().window(1);
        boolean appleURL = WebDriverRunner.getWebDriver().getCurrentUrl().startsWith("https://appleid.apple.com/");
        Assert.assertTrue(appleURL);
        String appleTitle = WebDriverRunner.getWebDriver().getTitle();
        Assert.assertEquals(appleTitle,"403 Forbidden");
        closeWindow();
        switchTo().window(0);
        return  AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }

    @Override
    public IAfdalAnalyticsSignUpPage verifyTwitterIcon() {
//        getTwitterFooterIcon.click();
        executeJavaScript("arguments[0].click();", getTwitterFooterIcon);
        switchTo().window(1);
        boolean twitterIcon = WebDriverRunner.getWebDriver().getCurrentUrl().startsWith("https://twitter.com/afdalanalytics");
        Assert.assertTrue(twitterIcon);
        String twitterTitle = WebDriverRunner.getWebDriver().getTitle();
        Boolean titleTwitter = twitterTitle.contains("Twitter");
        System.out.println(twitterTitle);
        Assert.assertTrue(titleTwitter);
//        Assert.assertEquals(twitterTitle,"Profile / Twitter");
//        Assert.assertEquals(twitterTitle,"Afdal Analytics - أفضل التحليلات (@AfdalAnalytics) / Twitter");
        switchTo().window(0);
        return  AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }

    @Override
    public IAfdalAnalyticsSignUpPage verifyInstagramIcon() {
//        getInstagramFooterIcon.click();
        executeJavaScript("arguments[0].click();", getInstagramFooterIcon);
        switchTo().window(1);
        boolean instagramIcon = WebDriverRunner.getWebDriver().getCurrentUrl().startsWith("https://www.instagram.com/afdalanalytics/");
        Assert.assertTrue(instagramIcon);
        closeWindow();
        switchTo().window(0);
        return  AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }

    @Override
    public IAfdalAnalyticsSignUpPage verifyLinkedInIcon() {
        executeJavaScript("arguments[0].click();", getLinkedInFooterIcon);
        switchTo().window(1);
        boolean linkedinFooterURL = WebDriverRunner.getWebDriver().getCurrentUrl().startsWith("https://www.linkedin.com/");
            Assert.assertTrue(linkedinFooterURL);
            String linkedinFooterTitle = WebDriverRunner.getWebDriver().getTitle();
            Assert.assertEquals(linkedinFooterTitle,"Sign in | LinkedIn");
        closeWindow();
        switchTo().window(0);
        return  AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }

    @Override
    public IAfdalAnalyticsSignUpPage verifyFacebookIcon() {

//        getFacebookFooterIcon.click();
        executeJavaScript("arguments[0].click();", getFacebookFooterIcon);

        switchTo().window(1);
        boolean facebookUrl = WebDriverRunner.getWebDriver().getCurrentUrl().startsWith("https://www.facebook.com/login/?next=https%3A%2F%2Fwww.facebook.com%2FAfdal.Analytics");
            Assert.assertTrue(facebookUrl);
            String facebookTitle = WebDriverRunner.getWebDriver().getTitle();
//            Assert.assertEquals(facebookTitle,"Facebook");
//        System.out.println(facebookTitle);
//        Assert.assertTrue(Boolean.parseBoolean(facebookTitle), "Facebook");
        closeWindow();

        switchTo().window(0);
        return  AfdalAnalyticsSignUpPageFactory.getSignUpPage();
    }

}
