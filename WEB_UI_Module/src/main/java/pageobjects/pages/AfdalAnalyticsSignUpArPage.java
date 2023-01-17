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
import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AfdalAnalyticsSignUpArPage implements IAfdalAnalyticsSignUpArPage {
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

    SelenideElement Subscribe_Button_On_SignUp_Page = $x("//button[text()='اشترك']");
    SelenideElement Enter_Phone_Or_Email_Error = $x("//div[@id='alert-div']");
    SelenideElement Phone_Number_field = $x("//input[@id='phone']");
    SelenideElement Afdal_signup_checkbox = $x("//div/input[@id='checkbox-terms']");
    SelenideElement Google_SignUp_Button = $x("//p[contains(text(),'تسجيل الدخول باستخدام جوجل')]");
    SelenideElement Gmail_Enter_Email_or_Phone = $x("//input[@type='email']");
    SelenideElement Reg_With_PhnNo_Fname =$x("//div/div/input[@id='first_name']");
    SelenideElement Reg_With_PhnNo_Lname = $x("//div/div/input[@id='last_name']");
    SelenideElement Reg_With_PhnNo_CompanyName = $x("//div/input[@id='company']");
    SelenideElement Reg_With_PhnNo_Password = $x("//div/div/input[@id='password']");
    SelenideElement Password_Eye_Icon =$x(" //div/span[@onclick='showPassword('password')']");
    SelenideElement Reg_With_PhnNo_ConfrmPassword = $x("//div/input[@id='confirm_password']");
    SelenideElement ConfrmPassword_Eye_Icon = $x("//div/span[@onclick='showPassword('confirm')']");
    SelenideElement Submit_Buttn = $x("(//div/button[@type='submit'])[1]");
    SelenideElement SignIn_Email_Field = $x("//div/input[@id='email']");
    SelenideElement SignUp_Email_Fname = $x("//div/input[@id='first_name']");
    SelenideElement SignUp_E_Lname = $x("//div/input[@id='last_name']");
    SelenideElement SignUp_E_CompanyName = $x("//div/input[@id='company']");
    SelenideElement SignUp_E_Phone = $x("//div/input[@id='phone']");
    SelenideElement SignUp_E_Passwrd = $x("//div/input[@id='password']");
    SelenideElement SignUp_E_ConfrmPasswrd = $x("//div/input[@id='confirm_password']");
    SelenideElement SignUp_E_CreateAccount = $x("//button[@type='submit'][1]");

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
    public IAfdalAnalyticsSignUpArPage Sign_Up_Verify_Valid_phone_No() throws InterruptedException {
        Phone_Number_field.sendKeys("+1 (215) 268-8872");
        //Afdal_signup_checkbox.click();
        getWebDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Selenide.executeJavaScript("arguments[0].click()", Subscribe_Button_On_SignUp_Page);
        getWebDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

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
        Thread.sleep(4000);



        return AfdalPageFactory.getNewSignUp();
    }



    public IAfdalAnalyticsSignUpArPage Sign_Up_With_Valid_Gmail() throws InterruptedException {
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
            Gmail_Input_Field.setValue("Test806680@gmail.com");
            //Gmail_Next_Bttn.click();
             Selenide.executeJavaScript("arguments[0].click()", Gmail_Next_Bttn);
           //  Thread.sleep(4000);
            // Gmail_Passwrd_Field.setValue("Shnueljoe");
             Thread.sleep(4000);
            // Selenide.executeJavaScript("arguments[0].click()", Gmail_Passwrd_Nxt_Bttn);


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
        SignIn_Email_Field.setValue("Test806680@gmail.com");
        Thread.sleep(4000);
        //Afdal_signup_checkbox.click();
        Thread.sleep(4000);
        Subscribe_Button_On_SignUp_Page.click();
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
        SignUp_E_Phone.setValue("+371-24-906-921");
        SignUp_E_Passwrd.setValue("demo2022");
        SignUp_E_ConfrmPasswrd.setValue("demo2022");
       // SignUp_E_CreateAccount.click();
        new Actions(WebDriverRunner.getWebDriver()).moveToElement(SignUp_E_CreateAccount).click().build().perform();
        Thread.sleep(4000);


        return AfdalPageFactory.getNewSignUp();
    }

    @Override
    public IAfdalAnalyticsSignUpArPage SignUp_With_Valid_Gmail_By_Close_the_Popup_N()
    {

        return AfdalPageFactory.getNewSignUp();
    }




}







