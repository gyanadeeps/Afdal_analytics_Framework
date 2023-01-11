package pageobjects.pages;


import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.w3c.dom.html.HTMLInputElement;
import pageobjects.PageFactoryClasses.AfdalPageFactory;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.*;

public class AfdalAnalyticsSettings implements IAfdalAnalyticsSettings {
  SelenideElement getAcceptCookie_Button = $x("//button[contains(text(),'مُوَافق')]");
  SelenideElement getSignin_Button = $x("//a[@role='button'][contains(text(),'تسجيل الدخول')]");

  SelenideElement getEmailInput = $x("//input[@id='email']");

  SelenideElement getPasswordInput = $x("//input[@name='password']");
  //  SelenideElement getSubmit_SignInButton = $x("//button[contains(text(),'سجل الدخول')]");
  SelenideElement getSubmit_SignInButton = $x("//*[@id='submit-button']");
  SelenideElement ClickSettings = $x("//*[@id='settings']/a/span");
  SelenideElement getProfile_Personly = $x("/html/body/div[1]/header/div[2]/ul/li[1]");

  SelenideElement getFirstName = $x("//input[@placeholder='أدخل اسمك']");
  SelenideElement FirstNm_ERROR_MSG = $x("//div[@class='user-billing-content-wrapper']//div[2]//div[2]//div[1]//p[contains(text(),'حقل الاسم الأول مطلوب.')]");
  SelenideElement getLastName = $x("//input[@placeholder='أدخل اسمك الأخير']");
  SelenideElement LastNm_ERROR_MSG = $x("//p[contains(text(),'حقل الاسم الأخير مطلوب.')]");
  SelenideElement getCity = $x("//input[@placeholder='أدخل مدينتك']");
  SelenideElement getCountryTimeZone = $x("//div[@id='timezone-picker']");

  SelenideElement getSave_SaveButton = $x("//div/button[@type='submit']");
  SelenideElement getEmail_ID = $x("//div/input[@value='demo@afdal.com']");
  SelenideElement getPostalCode = $x("//input[@placeholder='أدخل رمزك البريدي']");
  SelenideElement Postal_Code_Error_msg = $x("//p[contains(text(),'يمكنك إضافة أرقام فقط فى خانة الرمز البريدي')]");
  SelenideElement getStreetAddress = $x("//input[@placeholder='أدخل عنوانك']");
  SelenideElement getPhoneNumber = $x(" //input[@placeholder='أدخل رقم هاتفك']");
  SelenideElement Ph_no_ERR_Msg = $x("//p[contains(text(),'يمكنك إضافة أرقام فقط فى خانة الهاتف')]");
  SelenideElement getWebsite = $x("//input[@name='website']");
  SelenideElement getSuccess_Msg = $x("//div[@class='toast-message']");
  SelenideElement Website_Error_msg = $x("//div[@class='center-error']//p[@class='error-p-user-page user-padding-p']");
  SelenideElement getCountry = $x("//div[@id='country-picker']");
  ElementsCollection getCountryOptnList = $$x("//div[@id='timezone-picker']//div[@class='user-profile-select-list-wrapper']//li");
  SelenideElement getMain_heading = $x("//h1[contains(text(),'الإعدادات')]");
  SelenideElement getTheAccount = $x("/html/body/div[1]/main/div/p");
  SelenideElement getUserProfileImg = $x("//img[@alt='User image']");
  SelenideElement getInvoices_tab = $x("//ul[@class='settings-menu-list']//li[@class='settings-menu-item settings-menu-item-billing']");

  SelenideElement getGetInvoices_Downld_button = $x("//a[@class='user-billing-invoice-button']");
  SelenideElement getYour_Subscription = $x("//div[@class='custom-bg-grey-light padding-20-40 border-radius-10 shadow-display']//span[@class='text-light float-right']");
  SelenideElement getSubscriptionModification = $x("//h2[@class='user-billing-history-title font-24-lh-28-medium']//button[contains(text(),'تعديل الاشتراك')]");
  SelenideElement Manage_Subscription = $x("//div[@id='edit-subscription']//div[@class='paymant-method-modal-header-wrap']//h3[contains(text(),'إدارة اشتراكك')]");
  SelenideElement Your_Subscription = $x("//h3[contains(text(),'إدارة اشتراكك')]");
  SelenideElement Available_Actions = $x("//div[@id='edit-subscription']//div[@class='paymant-method-modal-wrap']//h3[contains(text(),'الإجراءات المتاحة')]");
  //font[contains(text(),'change')]
  SelenideElement Subscription_Change_Button = $x("//div[@id='edit-subscription']/div[@role='document']/div[@class='paymant-method-modal-wrap']/div[@class='paymant-method-modal-right-side mr-10-en']/div[1]//a[contains(text(),'تغيير')]");
  SelenideElement getControlPanel = $x("//div[@class='settings-top-bar']//h1[contains(text(),'لوحات تحكم')]");
  SelenideElement Choose_your_Subcription = $x("//h2[contains(text(),'اختر اشتراكك')]");
  SelenideElement get_Manage_Sub_Close = $x("//div[@id='edit-subscription']//button[@aria-label='Close']");
  SelenideElement DataAnalytic_Consulting = $x("//div[@class='user-billing-subscription-package box-shadow']//span[contains(text(),'استشارات تحليل البيانات')]");
  SelenideElement Invoices_Buttn_Subheadr = $x("//font[contains(text(),'ريد كاسل كابيتال بارتنرز')]");
  SelenideElement Link_Under_Inv_But_Subheadr = $x("//font[contains(text(),'legal@afdalanalytics.com')]");
  SelenideElement Add_Payment_method = $x("//button[contains(text(),'إضافة طريقة دفع')]");
  SelenideElement Payment_Methd_Mngt = $x("//h3[contains(text(),'إدارة طريقة الدفع')]");
  SelenideElement H_Your_Subscription = $x("//div[@id='payment-method']//h3[@class='paymant-method-modal-second-title font-24-lh-28-medium ml-0-en'][contains(text(),'اشتراكك')]");
  SelenideElement H_your_pay_method = $x("//h3[contains(text(),'طريقة الدفع الخاصة بك')]");
  SelenideElement Close_Add_Pay_Method = $x("//button[@aria-label='قريب']");
  SelenideElement H_Your_pay_method_Opt1 = $x("//div[@id='pm_1LyI82CmgWNu3hKQN0ICVCK9']//p[contains(@class,'paymant-method-modal-right-side-card-title font-15-lh-20-semi-medium')][contains(text(),'ك visa بطاقة موقعة باسم Demo')]");
  SelenideElement H_Your_pay_method_Opt2 = $x("//font[contains(text(),'ك visa بطاقة موقعة باسم Demo')]");
  SelenideElement H_Your_pay_method_Opt3 = $x("//div[@class='paymant-method-modal-right-side-info']");
  SelenideElement amendment = $x("//a[contains(text(),'تعديل')]");
  SelenideElement Addition = $x("//a[@id='add-payment-method-btn']");
  SelenideElement Sub_Add_Payment_Method = $x("//h3[@class='paymant-method-modal-second-title font-24-lh-28-medium']//font//font[contains(text(),'Add a payment method')]");
  SelenideElement PayIcon = $x("//div[@class='paymant-method-modal-right-side-first-field-paypal']");
  SelenideElement MasterCardIcon = $x("//div[@class='paymant-method-modal-right-side-first-field-mastercard']");
  SelenideElement VisaIcon = $x("//div[@class='paymant-method-modal-right-side-first-wrap']//div[@class='paymant-method-modal-right-side-first-field-visa']");
  SelenideElement Card_Selection_DRpDwn = $x("//select[@id='payment-selector']");
  SelenideElement Name_On_Card = $x("//input[@id='card-holder-name']");
  SelenideElement Card_Information = $x("//div[@id='card-element']");
  SelenideElement Card_Number = $x("//*[@id='root']/form/div/div[2]/span[1]/span[2]/div/div[2]/span/input");
  SelenideElement Card_Expiry = $x("//*[@id='root']/form/div/div[2]/span[2]/span/span/input");
  SelenideElement CVC = $x("//*[@id='root']/form/div/div[2]/span[3]/span/span/input");
  SelenideElement Expiry = $x("//*[@id='root']/form/div/div[2]/span[2]/span/span/input");
  SelenideElement Add_new_pay_Methd_Buttn = $x("//button[@id='card-button']");
  SelenideElement Add_new_pay_Methd_Buttn_ERR = $x("//font[contains(text(),'Your card number is incomplete.')]");
  SelenideElement Choose_Sub_$10 = $x("//div[@id='tabs']//a[@class='new-pricing-section-tab-link ']");
  SelenideElement UsersTab = $x("//a[@class='settings-link font-24-lh-28-medium']//font//font[contains(text(),'users')]");
  SelenideElement Activity = $x("//h3[contains(text(),'نشاط')]");
  SelenideElement Compny_Details = $x("//h3[contains(text(),'تفاصيل الشركة')]");
  SelenideElement View_All_btn = $x("//button[@id='latest-activity']//font//font[contains(text(),'View all')]");
  SelenideElement Users_list = $x("//h3[contains(text(),'قائمة المستخدم')]");
  SelenideElement Users_inputBox = $x("//input[@placeholder='بحث']");
  SelenideElement Recent_Activity = $x("//h3[contains(text(),'الأنشطة الاخيرة')]");
  SelenideElement History = $x("//p[@class='user-team-add-form-text text-ml font-14-lh-16-light']");
  SelenideElement activity = $x("//p[contains(text(),'نشاط')]");
  SelenideElement Users = $x("//p[@class='user-team-add-form-text font-14-lh-16-light'][contains(text(),'المستخدمين')]");
  SelenideElement Date_Time_Picker = $x("//input[@id='datetime-picker']");
  SelenideElement Year_label = $x("//input[@aria-label='Year']");
  SelenideElement Year_Up_Arrw = $x("//span[@class='arrowUp']");
  SelenideElement Year_Dwn_Arrw = $x("//span[@class='arrowDown']");
  SelenideElement Add_new_user_button = $x("//button[@id='addNewUser']");
  SelenideElement Add_new_U_Fullname = $x("//input[@placeholder='John Doe']");
  SelenideElement Add_new_U_Email = $x("input[placeholder='namesurname@email.com']");
  SelenideElement Add_new_U_Profession = $x("//select[@id='select-role']");
  SelenideElement Add_new_U_Cofrm_Bttn = $x("//button[contains(text(),'اكد')]");
  SelenideElement Add_new_U_Close_Bttn = $x("//button[@id='close']");
  SelenideElement Add_more_Users = $x("//h3[contains(text(),'إضافة المزيد من المستخدمين')]");
  SelenideElement Full_name = $x("//p[contains(text(),'الاسم الكامل')]");
  SelenideElement Email = $x("//*[@id='form']/div[2]/p");
  SelenideElement Profession = $x("//*[@id='form']/div[1]/p");
  SelenideElement Essl_Descrptn = $x("//div[@id='essential']//p[@class='new-pricing-section-plan-description']");
  SelenideElement Essl_Des_Data_L1 = $x("//*[@id='essential']/div[1]/p[1]");
  SelenideElement Essl_Des_Data_L2 = $x("//*[@id='essential']/div[1]/p[2]/font/font");
  SelenideElement Essl_Des_Data_L3 = $x("//*[@id='essential']/div[1]/p[3]/font/font");
  SelenideElement Essl_Des_Data_L4 = $x("//*[@id='essential']/div[1]/p[4]/font/font");
  SelenideElement Essl_Des_Data_L5 = $x("//*[@id='essential']/div[1]/p[5]/font/font");
  SelenideElement Essl_Des_Data_L6 = $x("//*[@id='essential']/div[1]/p[6]/font/font");

  SelenideElement Your_Curr_Plan = $x("//div[@id='essential']//p[@class='font-18-lh-25-semi-bold'][contains(text(),'خطتك الحالية')]");
  SelenideElement getCountry_PositionInput = $x("//div[@id='country-picker']//p[@id='country-displayed-value']");
  ElementsCollection getCountryPositionOptions = $$x("//div[@id='country-picker']//div[@class='user-profile-select-list-wrapper']//li[1]");

  private HTMLInputElement getCountryTime;

  public AfdalAnalyticsSettings() {
  }


  @Override
  public IAfdalAnalyticsSettings Verify_UI() {
    getAcceptCookie_Button.click();
    getSignin_Button.click();
    getEmailInput.setValue("demo@Afdal.com");
    getPasswordInput.setValue("demo2022");
    getSubmit_SignInButton.click();
    return AfdalPageFactory.getSettings();
  }

  @Override
  public IAfdalAnalyticsSettings ClickOnNavigationMenu() throws InterruptedException {
    ClickSettings.waitUntil(Condition.visible, 4000).click();
    //getProfile_Personly.click();
    //Assertion on URL

    //Assertions on Settings UI
    ClickSettings.shouldHave(Condition.exactText("الإعدادات"));//settings
    getMain_heading.shouldHave(Condition.exactText("الإعدادات"));//Profile_Personly
    getTheAccount.shouldHave(Condition.exactText("الحساب"));//the Account
    getUserProfileImg.shouldBe(Condition.visible);//User profile img
    return AfdalPageFactory.getSettings();
  }

  @Override
  public IAfdalAnalyticsSettings ClearAllFields() {
    refresh();

    return AfdalPageFactory.getSettings();
  }

 /* @Override
  public IAfdalAnalyticsSettings ClickOnSave_Button() {
    executeJavaScript("arguments[0].click();", getSave_SaveButton);

    getSave_SaveButton.waitUntil(Condition.visible, 3000).submit();

    //getSave_SaveButton.should(Condition.visible,);
    //Assertion on Fname
        /*FirstNm_ERROR_MSG.shouldHave(Condition.visible);
        String Expected_F_ERR_MSG = FirstNm_ERROR_MSG.getValue();
        System.out.println("Expected_F_ERR_MSG");
        String Actual_F_ERR_MSG = "حقل الاسم الأول مطلوب.";
        Assert.assertEquals(Expected_F_ERR_MSG, Actual_F_ERR_MSG);
        System.out.println("Test Passed");

        //Assertion on Lname
        String Expected_L_ERR_MSG = LastNm_ERROR_MSG.getText();
        String Actual_L_ERR_MSG = "حقل الاسم الأخير مطلوب.";
        Assert.assertEquals(Expected_L_ERR_MSG, Actual_L_ERR_MSG);
        System.out.println("Test Passed");
        return AfdalPageFactory.getSettings();
    }
*/
    @Override
    public IAfdalAnalyticsSettings SaveWithAll_Fields() {
      refresh();
      getFirstName.clear();
      getFirstName.sendKeys("GyanDeep");
      getLastName.clear();
      getLastName.sendKeys("Sahoo");
      getCity.clear();
      getCity.sendKeys("California");
      getCountry.click();

      getCountry_PositionInput.click();

      executeJavaScript("arguments[0].click();", getCountry_PositionInput);

      System.out.println(getCountryPositionOptions.size());

      for (SelenideElement e: getCountryPositionOptions)
      {

        String text = e.getText();

        System.out.println(text);

        if (text.equals("ساموا-الأمريكي"))
        {

          e.click();

        }

      }
      getStreetAddress.clear();
      getStreetAddress.sendKeys("Test 1234");
      getPostalCode.clear();
      getPostalCode.sendKeys("12345");
      getPhoneNumber.clear();
      getPhoneNumber.sendKeys("123456789");
      getWebsite.clear();
      getWebsite.sendKeys("www.yahoo.com");
      getCountryTimeZone.click();
      executeJavaScript("arguments[0].click();", getCountryTimeZone);

      System.out.println(getCountryOptnList.size());

      for (SelenideElement f: getCountryOptnList)
      {

        String text = f.getText();

        System.out.println(text);

        if (text.equals("\n" +
                "                      GMT+1:00\n" +
                "                    "))
        {

          f.click();

        }

      }


      executeJavaScript("arguments[0].click();", getSave_SaveButton);
      return AfdalPageFactory.getSettings();
    }

    @Override
    public IAfdalAnalyticsSettings Validatio_of_Lname_Fname_email_Empty () {
      getCity.clear();
      getCity.sendKeys("California");
      getCountry.click();

      getCountry_PositionInput.click();

      executeJavaScript("arguments[0].click();", getCountry_PositionInput);

      System.out.println(getCountryPositionOptions.size());

      for (SelenideElement e: getCountryPositionOptions)
      {

        String text = e.getText();

        System.out.println(text);

        if (text.equals("ساموا-الأمريكي"))
        {

          e.click();

        }

      }
      getStreetAddress.clear();
      getStreetAddress.sendKeys("Test 1234");
      getPostalCode.clear();
      getPostalCode.sendKeys("12345");
      getPhoneNumber.clear();
      getPhoneNumber.sendKeys("123456789");
      getWebsite.clear();
      getWebsite.sendKeys("www.yahoo.com");
      getCountryTimeZone.click();
      executeJavaScript("arguments[0].click();", getCountryTimeZone);

      System.out.println(getCountryOptnList.size());

      for (SelenideElement f: getCountryOptnList)
      {

        String text = f.getText();

        System.out.println(text);

        if (text.equals("GMT+1:00"))
        {

          f.click();

        }

      }


      executeJavaScript("arguments[0].click();", getSave_SaveButton);
      return AfdalPageFactory.getSettings();
    }

    @Override
    public IAfdalAnalyticsSettings Verify_Mandatory_fields_filling () {
      getFirstName.clear();
      getFirstName.sendKeys("Gyandeep");
      getLastName.clear();
      getLastName.sendKeys("Sahoo");
      executeJavaScript("arguments[0].click();", getSave_SaveButton);
      return AfdalPageFactory.getSettings();
    }

    @Override
    public IAfdalAnalyticsSettings Verify_SuccessMsg_With_all_filled_fields () {
      refresh();
      getFirstName.clear();
      getFirstName.sendKeys("Gyan");
      getLastName.clear();
      getLastName.sendKeys("Sahoo");
      getCity.clear();
      getCity.sendKeys("California");
      getCountry.click();

      getCountry_PositionInput.click();

      executeJavaScript("arguments[0].click();", getCountry_PositionInput);

      System.out.println(getCountryPositionOptions.size());

      for (SelenideElement e: getCountryPositionOptions)
      {

        String text = e.getText();

        System.out.println(text);

        if (text.equals("ساموا-الأمريكي"))
        {

          e.click();

        }

      }
      getStreetAddress.clear();
      getStreetAddress.sendKeys("Test 1234");
      getPostalCode.clear();
      getPostalCode.sendKeys("12345");
      getPhoneNumber.clear();
      getPhoneNumber.sendKeys("123456789");
      getWebsite.clear();
      getWebsite.sendKeys("www.yahoo.com");
      getCountryTimeZone.click();
      executeJavaScript("arguments[0].click();", getCountryTimeZone);

      System.out.println(getCountryOptnList.size());

      for (SelenideElement f: getCountryOptnList)
      {

        String text = f.getText();

        System.out.println(text);

        if (text.equals("GMT+1:00"))
        {

          f.click();

        }

      }


      executeJavaScript("arguments[0].click();", getSave_SaveButton);
      String Expected_Success_MSG = getSuccess_Msg.getText();
      String Actual_Success_MSG = "تم تحديث الملف الشخصي بنجاح";
      Assert.assertEquals(Expected_Success_MSG, Actual_Success_MSG);
      System.out.println("Test Passed");
      return AfdalPageFactory.getSettings();
    }

    @Override
    public IAfdalAnalyticsSettings Verify_Invalid_Postal_code ()
    {
      getPostalCode.clear();
      getPostalCode.sendKeys("Test_123");
      getSave_SaveButton.submit();
      //Assertion on less than 5 postal code
      String Expected_P_ERR_MSG = Postal_Code_Error_msg.getText();
      String Actual_P_ERR_MSG = "يمكنك إضافة أرقام فقط فى خانة الرمز البريدي";
      Assert.assertEquals(Expected_P_ERR_MSG, Actual_P_ERR_MSG);
      System.out.println("Test Passed");
      return AfdalPageFactory.getSettings();
    }

    @Override
    public IAfdalAnalyticsSettings Verify_Valid_Postal_code () {
      getPostalCode.sendKeys("12345");
      getSave_SaveButton.submit();

      return AfdalPageFactory.getSettings();
    }

    @Override
    public IAfdalAnalyticsSettings Validate_Disabled_Email_id_cant_be_changed () {
      //Assertion on Emailid Field
      Assert.assertEquals(true, getEmail_ID.is(Condition.disabled));
      System.out.println("Element is disabled - Assert passed");
      return AfdalPageFactory.getSettings();
    }

    @Override
    public IAfdalAnalyticsSettings Validate_Ph_no_should_accept_Numbers_only () {
      getPhoneNumber.clear();
      getPhoneNumber.sendKeys("8749870498");
      getSave_SaveButton.submit();
      return AfdalPageFactory.getSettings();
    }

    @Override
    public IAfdalAnalyticsSettings Verify_Ph_no_with_Invalid_Credentias ()
    {
      getPhoneNumber.clear();
      getPhoneNumber.sendKeys("abdhhhhhhh");
      getPhoneNumber.sendKeys("4783778edf");
      getSave_SaveButton.submit();
      //Assertions on Phone Number

      String Expected_Phn_ERR_MSG = Ph_no_ERR_Msg.getText();
      String Actual_Phn_ERR_MSG = "يمكنك إضافة أرقام فقط فى خانة الهاتف";
      Assert.assertEquals(Expected_Phn_ERR_MSG, Actual_Phn_ERR_MSG);
      System.out.println("Test Passed");
      return AfdalPageFactory.getSettings();
    }

    @Override
    public IAfdalAnalyticsSettings Validate_WebSite_with_Valid_format () {
      getWebsite.sendKeys("abc1@gmail.com");
      getSave_SaveButton.submit();
      return AfdalPageFactory.getSettings();
    }

    @Override
    public IAfdalAnalyticsSettings Validate_WebSite_with_Invalid_format () throws InterruptedException {
      getWebsite.clear();
      getWebsite.sendKeys("google.com");
      getSave_SaveButton.submit();
      Thread.sleep(4000);
      //Assertion on website

     /* String Exp_Web_ERR_MSG = Website_Error_msg.getText();
      String Act_Web_ERR_MSG = "تنسيق موقع غير صالح.";
      Assert.assertEquals(Exp_Web_ERR_MSG, Act_Web_ERR_MSG);
      System.out.println("Test passed");
      Thread.sleep(4000);*/
      return AfdalPageFactory.getSettings();
    }

  /*
  @Override
    public IAfdalAnalyticsSettings Profile_Picture_Should_Accept_Valid_Format () throws
    IOException, InterruptedException {
      getUserProfileImg.click();
      Thread.sleep(3000);
      Runtime.getRuntime().exec("C:\Users\gs1\Desktop\Afdal_analytics_Framework-main\WEB_UI_Module\src\main\Test\PngItem_2720656.png");
      getUserProfileImg.shouldBe(Condition.image);
      getUserProfileImg.shouldBe(Condition.visible);
      return AfdalPageFactory.getSettings();
    }

*/

    //INVOICE TAB

    @Override
    public IAfdalAnalyticsSettings Click_on_Invoices_Tab () throws InterruptedException {

      new Actions(WebDriverRunner.getWebDriver()).moveToElement(getInvoices_tab).build().perform();
      new Actions(WebDriverRunner.getWebDriver()).moveToElement(getInvoices_tab).click().build().perform();
      Thread.sleep(4000);

      return AfdalPageFactory.getSettings();
    }

    @Override
    public IAfdalAnalyticsSettings Validate_Billing_History_Section () {
      ElementsCollection T_Data = $$(By.xpath("//table/tbody[@class='user-billing-transactions-list']//td"));
      System.out.println(T_Data.size());

      boolean data_Status = true;
      for (SelenideElement ele : T_Data)
      {
        String text = ele.getText();
        System.out.println(text);
        if (text.equals("$15")) {
          boolean Status = true;
          break;
        }

      }
      Assert.assertTrue(data_Status, "Data is present");
      System.out.println("Data is not present");
      return AfdalPageFactory.getSettings();
    }

    public IAfdalAnalyticsSettings Validate_Invoice_UI() throws InterruptedException {
      //Assertion on Invoices UI
      //getInvoices_tab.shouldHave(Condition.text("الفواتير"));
     getYour_Subscription.shouldHave(Condition.text("اشتراكك"));
      getSubscriptionModification.shouldHave(Condition.exactText("تعديل الاشتراك"));
      DataAnalytic_Consulting.shouldHave(Condition.exactText("استشارات تحليل البيانات"));
      //getSubscriptionModification.click();


      //  Thread.sleep(4000);
      // Choose_Sub_$15.click()
      return AfdalPageFactory.getSettings();
    }
    @Override
    public IAfdalAnalyticsSettings Validation_Subscription_modification_Button () throws InterruptedException {

     Thread.sleep(4000);
      new Actions(WebDriverRunner.getWebDriver()).moveToElement(getSubscriptionModification).click().build().perform();
      //Assertion on Subscription modification
      getSubscriptionModification.shouldHave(Condition.exactText("تعديل الاشتراك"));
      Manage_Subscription.shouldHave((Condition.exactText("إدارة اشتراكك")));
     // Your_Subscription.shouldHave(Condition.exactText("اشتراكك"));
      Available_Actions.shouldHave(Condition.exactText("الإجراءات المتاحة"));
      Subscription_Change_Button.click();
      Thread.sleep(4000);
      //getControlPanel.shouldHave(Condition.exactText("لوحات تحك"));
      Choose_your_Subcription.shouldHave(Condition.exactText("اختر اشتراكك"));


      //Assertions on ChooseYour Sub Page
      //On $15
     // Essl_Descrptn.shouldHave(Condition.exactText("الباقة الأساسية مخصصة لأصحاب الأعمال الحرة، والشركات الصغيرة, وإلى من هم بحاجة لخيارات إعداد التقارير الأساسية "));
      Essl_Des_Data_L1.shouldHave(Condition.exactText("\n" +
              "                        رابط واحد\n" +
              "                    "));
      Essl_Des_Data_L2.shouldHave(Condition.exactText("متاحة إلى 5 مستخدمين"));
      Essl_Des_Data_L3.shouldHave(Condition.exactText("عدد غير محدود من لوحات تحكم معدّة مسبقا"));
      Essl_Des_Data_L4.shouldHave(Condition.exactText("بيانات سابقة أقصاها سنة"));
      Essl_Des_Data_L5.shouldHave(Condition.exactText("ساعة واحدة في استشارات التحليلات"));
      Essl_Des_Data_L6.shouldHave(Condition.exactText("قاعدة تعلم"));
      Your_Curr_Plan.shouldHave(Condition.exactText("خطتك الحالية"));
      back();

      return AfdalPageFactory.getSettings();
    }
  @Override
  public IAfdalAnalyticsSettings Validation_PopUp_Close_Button () {
    get_Manage_Sub_Close.click();
    return AfdalPageFactory.getSettings();
  }
  @Override
  public IAfdalAnalyticsSettings Invoice_Download () {
    getGetInvoices_Downld_button.click();
    getGetInvoices_Downld_button.shouldHave(Condition.visible);


    return AfdalPageFactory.getSettings();
  }

/*
    @Override
    public IAfdalAnalyticsSettings Add_Payment_Method_with_all_data () {
      Add_Payment_method.click();
      //Assertions on Add_Payment_Method UI
      Add_Payment_method.shouldHave(Condition.exactText("إضافة طريقة دفع"));
      Payment_Methd_Mngt.shouldHave(Condition.exactText("إدارة طريقة الدفع"));
      H_Your_Subscription.shouldHave(Condition.exactText("اشتراكك"));
      H_your_pay_method.shouldHave(Condition.exactText("طريقة الدفع الخاصة بك"));
      H_Your_pay_method_Opt1.isEnabled();
      H_Your_pay_method_Opt2.is(Condition.disabled);
      H_Your_pay_method_Opt3.is(Condition.disabled);
      Addition.click();
      //Assertion on Payment Addition
      Sub_Add_Payment_Method.shouldHave(Condition.exactText("إضافة طريقة دفع"));
      PayIcon.shouldBe(Condition.visible);
      MasterCardIcon.shouldBe(Condition.visible);
      VisaIcon.shouldBe(Condition.visible);
      //Card Selection for Payment
      Select Card = new Select(Card_Selection_DRpDwn);
      Card.selectByValue("PayPal");
      Name_On_Card.sendKeys("Gyandeep Sahoo");
      Card_Number.sendKeys("047877656789768");
      Card_Expiry.sendKeys();
      CVC.sendKeys("456");
      Expiry.sendKeys("9/23");
      Add_new_pay_Methd_Buttn.click();

      amendment.click();
      Close_Add_Pay_Method.shouldBe(Condition.visible);
      Close_Add_Pay_Method.click();
      return AfdalPageFactory.getSettings();

    }

    @Override
    public IAfdalAnalyticsSettings Add_Payment_method_with_all_empty_field () {
      Add_new_pay_Methd_Buttn.click();
      //Assertion for error msg of Card information empty fields
      String Expected_Card_ERR_MSG = Add_new_pay_Methd_Buttn_ERR.getText();
      String Actual_Card_ERR_MSG = "Your card number is incomplete.";
      Assert.assertEquals(Expected_Card_ERR_MSG, Actual_Card_ERR_MSG);
      System.out.println("Test Passed");

      return AfdalPageFactory.getSettings();
    }
    //Users Validation
    @Override
    public IAfdalAnalyticsSettings Verify_Users_tab () {
      UsersTab.shouldHave(Condition.exactText("المستخدمين"));
      Activity.shouldHave(Condition.exactText("نشاط"));
      Compny_Details.shouldHave(Condition.exactText("نشاط"));
      Users_list.shouldHave(Condition.exactText("قائمة المستخدم"));
      Users_inputBox.sendKeys("Gyandeep");

      View_All_btn.click();
      //Assetions on View_All tab
      Recent_Activity.shouldHave(Condition.exactText("الأنشطة الاخيرة"));
      History.shouldHave(Condition.exactText("التاريخ"));
      activity.shouldHave(Condition.exactText("نشاط"));
      Users.shouldHave(Condition.exactText("المستخدمين"));


      Date_Time_Picker.click();
      Year_label.click();
      Calendar cal = Calendar.getInstance();
      int Day = cal.get(Calendar.DAY_OF_MONTH);
      int month = cal.get(Calendar.MONTH);
      int year = cal.get(Calendar.YEAR);
      Calendar.getInstance();

      return AfdalPageFactory.getSettings();
    }

    @Override
    public IAfdalAnalyticsSettings Add_new_User () {
      Add_new_user_button.click();
      Add_new_U_Fullname.sendKeys("Tanuja");
      Add_new_U_Email.sendKeys("gyandeep@gmail.com");
      Add_new_U_Profession.click();
      $(By.cssSelector("#select-role")).selectOption("صاحب");
      Add_new_U_Cofrm_Bttn.click();
      Add_new_U_Close_Bttn.click();

      //Assertions on Add_New_User_UI
      Add_more_Users.shouldHave(Condition.exactText("إضافة المزيد من المستخدمين"));
      Full_name.shouldHave(Condition.exactText("الاسم الكامل"));
      Email.shouldHave(Condition.exactText("البريد الإلكتروني"));
      Profession.shouldHave(Condition.exactText("إختر مهنتك"));
      Add_new_user_button.shouldBe(Condition.visible);

      return AfdalPageFactory.getSettings();
    }
*/

  }


