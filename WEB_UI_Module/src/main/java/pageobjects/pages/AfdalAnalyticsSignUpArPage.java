package pageobjects.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;
import pageobjects.PageFactoryClasses.AfdalPageFactory;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AfdalAnalyticsSignUpArPage implements IAfdalAnalyticsSignUpArPage {

    SoftAssert Assert = new SoftAssert();

    SelenideElement getAcceptCookie_Button = $x("//button[contains(text(),'مُوَافق')]");
    SelenideElement SignUp_Button = $x("//a[text()='اشترك مجانا']");
    SelenideElement Subscribe_Now = $x("//p[contains(text(),'اشترك الآن')]");
    SelenideElement SignIn_button = $x("//a[contains(text(),'سجل الدخول')]");
    SelenideElement LinkedIn_H_Icon = $x("//*[name()='path' and contains(@d,'M0 20.5C0 ')]");
    SelenideElement Google_Icon = $x("//a[@id='googleAuth']//div[@class='mt-3']//*[name()='svg']");
    SelenideElement Gmail_Input_Field = $x("//input[@id='identifierId']");
    SelenideElement Gmail_Passwrd_Field = $x("//div[@id='password']/div/div/div/input");
    SelenideElement Gmail_Next_Bttn = $x("(//button/div[@class='VfPpkd-Jh9lGc'])[2]");
    SelenideElement Gmail_Passwrd_Nxt_Bttn = $x("(//button[@type='button'])[2]");
    SelenideElement SignIW_Google_Invalid_Email_ID_Error_msg = $x("");
    SelenideElement Wrong_Gmail_Uname_Err_msg = $x("//div[@class='o6cuMc']");

    SelenideElement Subscribe_Button_On_SignUp_Page = $x("//button[@type='submit'][1]");
    SelenideElement Enter_Phone_Or_Email_Error = $x("//div[@id='alert-div']");
    SelenideElement Phone_Number_field = $x("//input[@id='phone']");
    SelenideElement Invalid_Phone_SignUp = $x("//p[@id='phone-error']");
    SelenideElement Afdal_signup_checkbox = $x("//input[@id='checkbox-terms']");
    SelenideElement Google_SignUp_Button = $x("//a[@id='googleAuth']");
    SelenideElement Gmail_Enter_Email_or_Phone = $x("//input[@type='email']");
    SelenideElement Reg_With_PhnNo_Fname =$x("//div/div/input[@id='first_name']");
    SelenideElement Reg_With_PhnNo_Lname = $x("//div/div/input[@id='last_name']");
    SelenideElement Reg_With_PhnNo_CompanyName = $x("//div/input[@id='company']");
    SelenideElement Reg_With_PhnNo_Password = $x("//div/div/input[@id='password']");
    SelenideElement Password_Eye_Icon =$x(" //div/span[@onclick='showPassword('password')']");
    SelenideElement Reg_With_PhnNo_ConfrmPassword = $x("//div/input[@id='confirm_password']");
    SelenideElement ConfrmPassword_Eye_Icon = $x("//div/span[@onclick='showPassword('confirm')']");
    SelenideElement Submit_Buttn = $x("(//div/button[@type='submit'])[1]");
    SelenideElement SignUp_Email_Field = $x("//div/input[@id='email']");
    SelenideElement SignUp_Email_Fname = $x("//div/input[@id='first_name']");
    SelenideElement SignUp_E_Lname = $x("//div/input[@id='last_name']");
    SelenideElement SignUp_E_CompanyName = $x("//div/input[@id='company']");
    SelenideElement SignUp_E_Phone = $x("//div/input[@id='phone']");
    SelenideElement SignUp_E_Passwrd = $x("//div/input[@id='password']");
    SelenideElement SignUp_E_ConfrmPasswrd = $x("//div/input[@id='confirm_password']");
    SelenideElement SignUp_E_CreateAccount = $x("//button[@type='submit'][1]");
    SelenideElement SignInLink = $x("//div[contains(@class,'text-center mt-5')]//div[contains(@class,'mt-3 mb-5')]//a[contains(text(),'سجل الدخول')]");
    SelenideElement Linkedin_SignUp_Button = $x("//a/p[contains(@class,'linkedin-signup-text-ar')]");
    SelenideElement LinkedinEmail = $x("//input[@id='username']");
    SelenideElement LinkedinPassword = $x("//input[@id='password']");
    SelenideElement LinkedinSignIn_button = $x("//button[@type='submit']");
    SelenideElement LinkedInCode = $x("//input[@id='input__email_verification_pin']");
    SelenideElement Gmail_ERR_MSG = $x("//div[@class='o6cuMc Jj6Lae']");
    SelenideElement ERRSignUpPhn_Without_Chk_T_C = $x("//div[@id='alert-div']");
    SelenideElement ERRSignUpEmail_Without_Chk_T_C = $x("");
    public String GetRandomString(int Length)
    {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = Length;
        Random random = new Random();
        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
    public String GetRandomEmailGenerator(int Length)
    {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = Length;
        String emailId = GetRandomString(Length)+"@gmail.com";
        Random random = new Random();
        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public String GetRandomMobileNumber(int Length)
    {
        int leftLimit = 48; // letter 'a'
        int rightLimit = 57; // letter 'z'
        int targetStringLength = Length;
        Random random = new Random();
        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }


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
        //Subscribe_Button_On_SignUp_Page.shouldHave(Condition.enabled);

        return AfdalPageFactory.getNewSignUp();
    }

    @Override
    public IAfdalAnalyticsSignUpArPage SignUp_Check_Already_have_an_account_Sign_in_BTN() {
        SignUp_Button.click();
        SignInLink.click();
        String expectedURL = "https://staging.afdalanalytics.com/login";
        String redirectURL=WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertEquals(redirectURL,expectedURL);
        System.out.println("Pass");

        return AfdalPageFactory.getNewSignUp();
    }

    @Override
    public IAfdalAnalyticsSignUpArPage Sign_Up_Verify_All_Fields_Empty() throws InterruptedException {

            //Thread.sleep(5000);
            SignUp_Button.click();
            Subscribe_Button_On_SignUp_Page.click();
            Thread.sleep(4000);

        String Expected_Err_MSG = Enter_Phone_Or_Email_Error.getText();
        String Actual_Err_MSG ="الهاتف أو البريد الإلكتروني مطلوب";
        Assert.assertEquals(Expected_Err_MSG, Actual_Err_MSG);
        System.out.println("Test Passed");

        return AfdalPageFactory.getNewSignUp();
    }

    @Override
    public IAfdalAnalyticsSignUpArPage Sign_Up_Verify_Valid_phone_No() throws InterruptedException {
        refresh();
        SignUp_Button.click();
        String Mobile_No = "+3"+GetRandomMobileNumber(11);
        Phone_Number_field.sendKeys(Mobile_No);
        //Afdal_signup_checkbox.click();
        getWebDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Selenide.executeJavaScript("arguments[0].click()", Subscribe_Button_On_SignUp_Page);
        getWebDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(4000);

        //Assertion to check redirection on next page
        String expectedURL = "https://staging.afdalanalytics.com/demo-dashboard";
        String redirectURL=WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertEquals(redirectURL,expectedURL);


        Set<String> Windows = WebDriverRunner.getWebDriver().getWindowHandles();//Switch windows to gmail Signup.
        Iterator<String> iterator = Windows.iterator();
        String subWindowsHandler = null;
        while (iterator.hasNext()) {
            subWindowsHandler = iterator.next();
        }
        WebDriverRunner.getWebDriver().switchTo().window(subWindowsHandler);
        Thread.sleep(4000);
        Reg_With_PhnNo_Fname.sendKeys("Gyandeep");
        Reg_With_PhnNo_Lname.sendKeys("Sahoo");
        Reg_With_PhnNo_CompanyName.sendKeys("Vtechys");
        Reg_With_PhnNo_Password.sendKeys("demo2023");
        //Password_Eye_Icon.click();
        Reg_With_PhnNo_ConfrmPassword.sendKeys("demo2023");
        //ConfrmPassword_Eye_Icon.click();
        Submit_Buttn.submit();
        getWebDriver().navigate().back();
        // Assertion on SignUp with Invalid Phone Numbers
        refresh();
        Phone_Number_field.sendKeys("2@$%^&54");
        Selenide.executeJavaScript("arguments[0].click()", Subscribe_Button_On_SignUp_Page);
        String Expected_L_ERR_MSG = Invalid_Phone_SignUp.getText();
        String Actual_L_ERR_MSG = "رقم الهاتف غير صحيح";
        Assert.assertEquals(Expected_L_ERR_MSG, Actual_L_ERR_MSG);
        System.out.println("Test Passed");
        refresh();
        Phone_Number_field.sendKeys("000000000000");
        Selenide.executeJavaScript("arguments[0].click()", Subscribe_Button_On_SignUp_Page);
        String Expected_ERR_MSG = Invalid_Phone_SignUp.getText();
        String Actual_ERR_MSG = "رقم الهاتف غير صحيح";
        Assert.assertEquals(Expected_ERR_MSG, Actual_ERR_MSG);
        refresh();
        Phone_Number_field.sendKeys("fyyffyyfyyyyf");
        Selenide.executeJavaScript("arguments[0].click()", Subscribe_Button_On_SignUp_Page);
        String Expected_Err_MSG = Invalid_Phone_SignUp.getText();
        String Actual_Err_MSG = "رقم الهاتف غير صحيح";
        Assert.assertEquals(Expected_Err_MSG, Actual_Err_MSG);

        Thread.sleep(4000);


        return AfdalPageFactory.getNewSignUp();
    }
    @Override
    public IAfdalAnalyticsSignUpArPage Sign_Up_With_Valid_Gmail() throws InterruptedException {
            getWebDriver().navigate().back();
            Thread.sleep(4000);
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
            //Assertion to check redirection on next page
        String expectedURL = "https://accounts.google.com/o/oauth2/auth/identifier?client_id=44984746641-ns8maglmhid5qbt3sfkfdrlrpm53hdip.apps.googleusercontent.com&redirect_uri=https%3A%2F%2Fstaging.afdalanalytics.com%2Fauth%2Fgoogle%2Fcallback&scope=openid%20profile%20email&response_type=code&state=0PTePA5ZuJv3ateXnblhzRy9Y4mUUnizwRIEAFNm&service=lso&o2v=1&flowName=GeneralOAuthFlow";
        String redirectURL=WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertEquals(redirectURL,expectedURL);
        Thread.sleep(2000);
        //TC 14
        //Assertion on Invalid Gmail
        Gmail_Input_Field.setValue("abc@gmailcom");
        Selenide.executeJavaScript("arguments[0].click()", Gmail_Next_Bttn);

        String Expected_L_ERR_MSG = Gmail_ERR_MSG.getText();
        String Actual_L_ERR_MSG = "Enter a valid email or phone number";
        Assert.assertEquals(Expected_L_ERR_MSG, Actual_L_ERR_MSG);
        getWebDriver().navigate().back();
        Thread.sleep(4000);

        return AfdalPageFactory.getNewSignUp();
    }

    @Override
    public IAfdalAnalyticsSignUpArPage Sign_Up_With_Valid_LinkedIN() throws InterruptedException {
        getWebDriver().navigate().back();
        getWebDriver().close();
        Thread.sleep(4000);
        SignUp_Button.click();
        Thread.sleep(4000);
        Selenide.executeJavaScript("arguments[0].click()", Linkedin_SignUp_Button);//Google_SignUp_Button.click();
        getWebDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Set<String> Windows = WebDriverRunner.getWebDriver().getWindowHandles();//Switch windows to gmail Signup.
        Iterator<String> iterator = Windows.iterator();
        String subWindowsHandler = null;
        while (iterator.hasNext()) {
            subWindowsHandler = iterator.next();
        }
        WebDriverRunner.getWebDriver().switchTo().window(subWindowsHandler);
        String expectedURL = "https://www.linkedin.com/uas/login?session_redirect=%2Foauth%2Fv2%2Flogin-success%3Fapp_id%3D77012683%26auth_type%3DAC%26flow%3D%257B%2522scope%2522%253A%2522r_liteprofile%2Br_emailaddress%2522%252C%2522state%2522%253A%2522Zl2BR0o0xIDyIYZl1wcnB4kqaDkCvxHFauPRTrMz%2522%252C%2522appId%2522%253A77012683%252C%2522authorizationType%2522%253A%2522OAUTH2_AUTHORIZATION_CODE%2522%252C%2522currentStage%2522%253A%2522LOGIN_SUCCESS%2522%252C%2522currentSubStage%2522%253A0%252C%2522authFlowName%2522%253A%2522generic-permission-list%2522%252C%2522creationTime%2522%253A1679515494502%252C%2522redirectUri%2522%253A%2522https%253A%252F%252Fstaging.afdalanalytics.com%252Fauth%252Flinkedin%252Fcallback%2522%257D&fromSignIn=1&trk=oauth&cancel_redirect=%2Foauth%2Fv2%2Flogin-cancel%3Fapp_id%3D77012683%26auth_type%3DAC%26flow%3D%257B%2522scope%2522%253A%2522r_liteprofile%2Br_emailaddress%2522%252C%2522state%2522%253A%2522Zl2BR0o0xIDyIYZl1wcnB4kqaDkCvxHFauPRTrMz%2522%252C%2522appId%2522%253A77012683%252C%2522authorizationType%2522%253A%2522OAUTH2_AUTHORIZATION_CODE%2522%252C%2522currentStage%2522%253A%2522LOGIN_SUCCESS%2522%252C%2522currentSubStage%2522%253A0%252C%2522authFlowName%2522%253A%2522generic-permission-list%2522%252C%2522creationTime%2522%253A1679515494502%252C%2522redirectUri%2522%253A%2522https%253A%252F%252Fstaging.afdalanalytics.com%252Fauth%252Flinkedin%252Fcallback%2522%257D";
        String redirectURL=WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertEquals(redirectURL,expectedURL);
        getWebDriver().navigate().back();

        return AfdalPageFactory.getNewSignUp();
    }

    @Override
    public IAfdalAnalyticsSignUpArPage Sign_Up_With_Valid_Email() throws InterruptedException {
        getWebDriver().navigate().back();
        String URL = getWebDriver().getCurrentUrl();
        System.out.println(URL);
        Thread.sleep(4000);
        SignUp_Button.click();
        Thread.sleep(4000);
        String emailId = GetRandomString(7)+"@gmail.com";
        String emailIdi = GetRandomString(7)+"@"+GetRandomString(5)+".com";
        SignUp_Email_Field.setValue(emailId);
        Thread.sleep(4000);
        //Afdal_signup_checkbox.click();
        Thread.sleep(4000);
        Subscribe_Button_On_SignUp_Page.click();
        Thread.sleep(4000);

        //Assertion to check redirection on next page
        String expectedURL = "https://staging.afdalanalytics.com/demo-dashboard";
        String redirectURL=WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertEquals(redirectURL,expectedURL);
        Thread.sleep(4000);

        Set<String> Windows = WebDriverRunner.getWebDriver().getWindowHandles();//Switch windows to gmail Signup.
        Iterator<String> iterator = Windows.iterator();
        String subWindowsHandler = null;
        while (iterator.hasNext()) {
            subWindowsHandler = iterator.next();
        }
        WebDriverRunner.getWebDriver().switchTo().window(subWindowsHandler);
        Thread.sleep(4000);
        SignUp_Email_Fname.setValue("Gyandeep");
        SignUp_E_Lname.setValue("Sahoo");
        SignUp_E_CompanyName.setValue("Vtechys");
        SignUp_E_Phone.setValue("+46731298920");
        SignUp_E_Passwrd.setValue("demo2022");
        SignUp_E_ConfrmPasswrd.setValue("demo2022");
        new Actions(WebDriverRunner.getWebDriver()).moveToElement(SignUp_E_CreateAccount).click().build().perform();
        Thread.sleep(4000);

        return AfdalPageFactory.getNewSignUp();
    }

    @Override
    public IAfdalAnalyticsSignUpArPage SignUp_With_Valid_Gmail_By_Close_the_Popup_N() throws InterruptedException {
        getWebDriver().navigate().back();
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
        getWebDriver().close();

        return AfdalPageFactory.getNewSignUp();
    }

    @Override
    //bug
    public IAfdalAnalyticsSignUpArPage SignUp_With_Valid_PhoneNo_Without_Checked_afdal_terms_checkbox_N() {
        SignUp_Button.click();
        String Mobile_No = "+6"+GetRandomMobileNumber(11);
        Phone_Number_field.sendKeys(Mobile_No);
        Subscribe_Button_On_SignUp_Page.click();

        return AfdalPageFactory.getNewSignUp();
    }

    @Override
    //bug
    public IAfdalAnalyticsSignUpArPage SignUp_With_Valid_Email_Without_Checked_afdal_terms_checkbox_N() {
        SignUp_Button.click();
        String emailId = GetRandomString(7)+"@gmail.com";
        SignUp_Email_Field.setValue((emailId));
        Subscribe_Button_On_SignUp_Page.click();

        return AfdalPageFactory.getNewSignUp();
    }

    @Override
    public IAfdalAnalyticsSignUpArPage SignUp_Page_Step2_Password_validation_N_lessThan8() {
        SignUp_Button.click();

        return AfdalPageFactory.getNewSignUp();
    }
    @Override
    public IAfdalAnalyticsSignUpArPage SignUp_Page_Step2_Password_validation_EqlsOrMoreThan8() {
        return AfdalPageFactory.getNewSignUp();
    }


}







