package pageobjects.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pageobjects.PageFactoryClasses.AfdalPageFactory;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

public class AfdalAnalyticsPricingPage implements IAfdalAnalyticsPricingPage
{

    SelenideElement Pricing_Buttn = $x("//ul[@class='navbar-nav']//li[@id='mainmenu-aftersub-item1']");
    SelenideElement Pricing_Header = $x("//h2[contains(text(),'خطة الدفع الأمثل لنمو أعمالك التجارية')]");
    SelenideElement Pricing_Sub_Header =$x("//div[contains(@class,'about-pricing-header')]//p[contains(@class,'')][contains(text(),'ابدأ تجربتك المجانية في منصة أفضل التحليلات، وسنرا')]");
    SelenideElement Essl_Plan = $x("//div[@id='tabs']//a[@href='#essential']");
    SelenideElement Plus_Plan = $x("/html/body/main/div[3]/div/a[2]");
    SelenideElement Entrprise_Plan = $x("/html/body/main/div[3]/div/a[3]");
    SelenideElement Essl_Plan_Subscription_Bttn = $x("//div[@id='essential-mobile']//a[contains(@class,'new-pricing-section-choose-btn-trail')][contains(text(),'نسخة تجريبية مجانية لمدة 14 يوماً')]");
    SelenideElement Plus_Plan_SubScription_Buttn = $x("//div[@id='plus-mobile']//a[contains(@class,'btn-warning new-pricing-section-choose-btn')][contains(text(),'اشترك')]");
    SelenideElement Entrprise_Plan_SubScription_Buttn = $x("//div[@id='enterprise-mobile']//a[contains(@class,'btn-warning new-pricing-section-choose-btn')][contains(text(),'اشترك')]");
    SelenideElement Essl_Descrptn = $x("//p[@class='new-pricing-section-plan-description'][contains(text(),'الباقة الأساسية مخصصة لأصحاب الأعمال الحرة، والشرك')]");
    SelenideElement Essl_Des_Data_L1 =$x("//*[@id='essential']/div[1]/p[1]/font/font");
    SelenideElement Essl_Des_Data_L2 =$x("//*[@id='essential']/div[1]/p[2]/font/font");
    SelenideElement Essl_Des_Data_L3 = $x("//*[@id='essential']/div[1]/p[3]/font/font");
    SelenideElement Essl_Des_Data_L4 =$x("//*[@id='essential']/div[1]/p[4]/font/font");
    SelenideElement Essl_Des_Data_L5 = $x("//*[@id='essential']/div[1]/p[5]/font/font");
    SelenideElement Essl_Des_Data_L6 = $x("//*[@id='essential']/div[1]/p[6]/font/font");
    SelenideElement Plus_P_Descrptn = $x("//*[@id='plus']/p[2]/font/font");
    SelenideElement Plus_P_Descrptn_L1 = $x("//*[@id='plus']/div[1]/p[1]");
    SelenideElement Plus_P_Descrptn_L2 = $x("//*[@id='plus']/div[1]/p[2]");
    SelenideElement Plus_P_Descrptn_L3 = $x("//*[@id='plus']/div[1]/p[3]");
    SelenideElement Plus_P_Descrptn_L4 = $x("//*[@id='plus']/div[1]/p[4]");
    SelenideElement Plus_P_Descrptn_L5 = $x("//*[@id='plus']/div[1]/p[5]");
    SelenideElement Plus_P_Descrptn_L6 = $x("//*[@id='plus']/div[1]/p[6]");
    SelenideElement Plus_P_Descrptn_L7 = $x("//*[@id='plus']/div[1]/p[7]");
    SelenideElement Plus_P_Descrptn_L8 = $x("//*[@id='plus']/div[1]/p[8]");
    SelenideElement Entr_Plan_Descrptn = $x("//*[@id='enterprise']/p[2]");
    SelenideElement Entr_Plan_Des_Data_L1 = $x("//*[@id='enterprise']/div[1]/p[1]");
    SelenideElement Entr_Plan_Des_Data_L2 = $x("//*[@id='enterprise']/div[1]/p[2]");
    SelenideElement Entr_Plan_Des_Data_L3 = $x("//*[@id='enterprise']/div[1]/p[3]");
    SelenideElement Entr_Plan_Des_Data_L4 = $x("//*[@id='enterprise']/div[1]/p[4]");
    SelenideElement Entr_Plan_Des_Data_L5 = $x("//*[@id='enterprise']/div[1]/p[5]");
    SelenideElement Entr_Plan_Des_Data_L6 = $x("//*[@id='enterprise']/div[1]/p[6]");
    SelenideElement Entr_Plan_Des_Data_L7 = $x("//*[@id='enterprise']/div[1]/p[7]");
    SelenideElement Subscribe_Header= $x("//h3[@class='sign-up-title font-74-weight-700 text-white text-center text-nowrap']//font//font[contains(text(),'Subscribe')]");
    SelenideElement Fname = $x(" //input[@placeholder='الاسم الأول']");
    SelenideElement Lname = $x("//input[@placeholder='اسم العائلة']");
    SelenideElement Email = $x("//input[@placeholder='email@companyexample.com']");
    SelenideElement Function = $x("//div[@id='select-role']");
    SelenideElement Company_name = $x("//input[@placeholder='إسم الشركة']");
    SelenideElement Password = $x("//input[@id='password']");
    SelenideElement Confrm_Passwrd = $x("//input[@id='confirm_password']");
    SelenideElement I_agreed_Checkbx = $x("//input[@id='exampleCheck1 mb-3']");
    SelenideElement privacy_policy = $x("//font[contains(text(),'Privacy Policy')]");
    SelenideElement Subsrcibe_bttn = $x("//button[contains(text(),'اشترك')]");
    SelenideElement Freq_asked_Q_Header = $x("//h2[contains(text(),'الأسئلة المتكررة')] ");
    SelenideElement Freq_Sub_header = $x("//section[contains(@class,'about-pricing-faq-block')]//p[contains(@class,'')][contains(text(),'ابدأ تجربتك المجانية في منصة أفضل التحليلات، وسنرا')]");
    SelenideElement Freq_Q1 = $x("/html/body/main/section[2]/ul/li[1]/div[1]");
    SelenideElement Freq_Q2 = $x("/html/body/main/section[2]/ul/li[2]/div[1]");
    SelenideElement Freq_Q3 = $x("/html/body/main/section[2]/ul/li[3]/div[1]");
    SelenideElement Freq_Q4 = $x("/html/body/main/section[2]/ul/li[4]/div[1]");
    SelenideElement Freq_Q5 = $x("/html/body/main/section[2]/ul/li[5]/div[1]");
    SelenideElement Freq_Q6 = $x("/html/body/main/section[2]/ul/li[6]/div[1]");
    SelenideElement Freq_Q7 = $x("/html/body/main/section[2]/ul/li[7]/div[1]");
    SelenideElement Freq_Q1_close = $x("//main[contains(@class,'about-pricing')]//li[1]//div[1]//div[1]");
    SelenideElement Freq_Q2_close = $x("body > main:nth-child(23) > section:nth-child(5) > ul:nth-child(3) > li:nth-child(2) > div:nth-child(1) > div:nth-child(2)");
    SelenideElement Freq_Q3_close = $x("/html/body/main/section[2]/ul/li[3]/div[1]/div");
    SelenideElement Freq_Q4_close = $x("//main[@class='about-pricing']//li[4]//div[1]//div[1]");
    SelenideElement Freq_Q5close = $x("//li[5]//div[1]//div[1]");
    SelenideElement Freq_Q6_close = $x("/html/body/main/section[2]/ul/li[6]/div[1]/div");
    SelenideElement Freq_Q7_close = $x("/html/body/main/section[2]/ul/li[7]/div[1]/div");
    SelenideElement Footr_Start_today = $x("//h2[contains(text(),'ابدأ اليوم')]");
    SelenideElement Footr_Sub_F = $x("//p[@class='get-started-text font-18-lh-25-light']");
    SelenideElement SignUp_Fr_Free_Buttn = $x("//a[@class='orange-button get-started-orange-button font-20-lh-42-semi-bold']");
    SelenideElement getLinkedInIcon = $x("//a[@class='footer-social-link footer-social-link--linkedin']");
    SelenideElement getFacebookFooterIcon = $x("//a[@class='footer-social-link footer-social-link--facebook']");
    SelenideElement getInstagramFooterIcon = $x("//a[@class='footer-social-link footer-social-link--instagram']");
    SelenideElement getTwitterFooterIcon = $x("//a[@class='footer-social-link footer-social-link--twitter']");
    SelenideElement getCloseCookie_CrossSign = $x("//div[@id='cookie-close-btn']");
    SelenideElement getAcceptCookie_Button = $x("//button[contains(text(),'مُوَافق')]");
    SelenideElement get1 = $x("");




    @Override
    public IAfdalAnalyticsPricingPage Verify_Pricing_UI() {
        Pricing_Buttn.click();
        Pricing_Header.shouldHave(Condition.exactText("خطة الدفع الأمثل لنمو أعمالك التجارية"));
        Pricing_Sub_Header.shouldHave(Condition.exactText("ابدأ تجربتك المجانية في منصة أفضل التحليلات، وسنرافقك في كل مراحل نمو مشروعك"));
        Footr_Start_today.shouldHave(Condition.exactText("ابدأ اليوم"));
        Footr_Sub_F.shouldHave(Condition.exactText("تهدف منصة أفضل التحليلات لمساعدة فرق التسويق في بناء أعمال ناجحة باستخدام أدوات جمع البيانات."));
        SignUp_Fr_Free_Buttn.shouldHave(Condition.exactText("اشترك مجانا"));
        SignUp_Fr_Free_Buttn.shouldBe(Condition.visible);

        return AfdalPageFactory.getPricing();
    }
    @Override
    public IAfdalAnalyticsPricingPage Verify_Is_Essl_Plan_Auto_Selected() throws InterruptedException {
        //Pricing_Buttn.click();
        //executeJavaScript("arguments[0].click();", Pricing_Buttn);
        getAcceptCookie_Button.shouldHave(Condition.exactText("مُوَافق")).click();
        new Actions(WebDriverRunner.getWebDriver()).moveToElement(Pricing_Buttn).doubleClick().build().perform();
        Thread.sleep(4000);
        System.out.println(getCloseCookie_CrossSign.isDisplayed());
        System.out.println(getAcceptCookie_Button.isDisplayed());

        Pricing_Buttn.getText();

        Thread.sleep(4000);
        Boolean Select = Essl_Plan.isSelected();
        System.out.println("Selected"+Select);

        //Assertions
        Essl_Plan.shouldHave(Condition.text("الأساسية"));
        assert Essl_Plan.exists();


        return AfdalPageFactory.getPricing();
    }

    @Override
    public IAfdalAnalyticsPricingPage Verify_Is_Plus_Plan_Displayed() {
        //Assertions
        Plus_Plan.shouldHave(Condition.exactText("$50"));
        return AfdalPageFactory.getPricing();
    }

    @Override
    public IAfdalAnalyticsPricingPage Verify_Is_Entr_Plan_Displayed() {
        Entrprise_Plan.isDisplayed();
        //Assertions
        Entrprise_Plan.shouldHave(Condition.exactText("$100"));
        return AfdalPageFactory.getPricing();
    }

    @Override
    public IAfdalAnalyticsPricingPage Validation_Price_Tables() {
        ArrayList<String> ColumnList = new ArrayList<String>();
        ElementsCollection Colum_list =$$("//div[@class='about-pricing-compare-plans-wrapper font-24-lh-50-medium']");
        for (SelenideElement Column:Colum_list)
        {
            String ColmnName = Column.getText();
            ColumnList.add(ColmnName);
        }
        System.out.println("Print size of Column:"+ColumnList.size());
        System.out.println("Print Column list:"+ColumnList);
        Assert.assertTrue(Colum_list.contains("الشاملة"));
        Assert.assertTrue(Colum_list.contains("الإضافية"));
        Assert.assertTrue(Colum_list.contains("الأساسية"));
        System.out.println("Reviwed column names Successfully");


        return AfdalPageFactory.getPricing();
    }
/*
    @Override
    public IAfdalAnalyticsPricingPage Verify_Freq_Asked_Q_UI()
    {
        //Assertions on Freq Asked Questions
        Freq_asked_Q_Header.shouldHave(Condition.exactText("الأسئلة المتكررة"));
        Freq_Sub_header.shouldHave(Condition.exactText("ابدأ تجربتك المجانية في منصة أفضل التحليلات، وسنرافقك في كل مراحل نمو مشروعك"));

        Freq_Q1.click();
        Freq_Q1.should(Condition.exactText(" هل يمكنني الاشتراك في منصة أفضل التحليلات مجاناً؟"));
        Freq_Q1_close.click();

        Freq_Q2.click();
        Freq_Q2.shouldHave(Condition.exactText("هل يوجد سعر خاص للشركات؟"));
        Freq_Q2_close.click();

        Freq_Q3.click();
        Freq_Q3.shouldHave(Condition.exactText("هل يمكنني إضافة مصدر بيانات من أي منصة؟"));
        Freq_Q3_close.click();

        Freq_Q4.click();
        Freq_Q4.shouldHave(Condition.exactText("هل حجم البيانات المستوردة محدود، حقاً؟"));
        Freq_Q4_close.click();

        Freq_Q5.click();
        Freq_Q5.shouldHave(Condition.exactText("هل يمكنني الحصول على قوالب للوحات التحكم؟"));
        Freq_Q5close.click();

        Freq_Q6.click();
        Freq_Q6.shouldHave(Condition.exactText("ما الذي أحصل عليه في جلسة استشارة التحليلات لمدة ساعة؟"));
        Freq_Q6_close.click();

        Freq_Q7.click();
        Freq_Q7.shouldHave(Condition.exactText("ما هي طبيعة التدريب الشهري؟"));
        Freq_Q7_close.click();
        return AfdalPageFactory.getPricing();
    }

    @Override
    public IAfdalAnalyticsPricingPage Validation_Auto_Selected_Essl_plans_Data() {
        Essl_Descrptn.shouldHave(Condition.exactText("الباقة الأساسية مخصصة لأصحاب الأعمال الحرة، والشركات الصغيرة, وإلى من هم بحاجة لخيارات إعداد التقارير الأساسية "));
        Essl_Des_Data_L1.shouldHave(Condition.exactText("رابط واحد"));
        Essl_Des_Data_L2.shouldHave(Condition.exactText("متاحة إلى 5 مستخدمين"));
        Essl_Des_Data_L3.shouldHave(Condition.exactText("عدد غير محدود من لوحات تحكم معدّة مسبقا"));
        Essl_Des_Data_L4.shouldHave(Condition.exactText("بيانات سابقة أقصاها سنة"));
        Essl_Des_Data_L5.shouldHave(Condition.exactText("ساعة واحدة في استشارات التحليلات"));
        Essl_Des_Data_L6.shouldHave(Condition.exactText("قاعدة تعلم"));
        Essl_Plan_Subscription_Bttn.should(Condition.visible);

        return AfdalPageFactory.getPricing();
    }

    @Override
    public IAfdalAnalyticsPricingPage Validation_Plus_plan_Correct_Data() {
        Plus_P_Descrptn.shouldHave(Condition.exactText("من خلال الباقة الإضافية يتم تجميع كافة البيانات من أي منصة، وأي مكان، ثُم تحويلها إلى فِرق الاتصال "));
        Plus_P_Descrptn_L1.shouldHave(Condition.exactText("$10 لكل رابط"));
        Plus_P_Descrptn_L2.shouldHave(Condition.exactText("5 روابط"));
        Plus_P_Descrptn_L3.shouldHave(Condition.exactText("عدد مستخدمين غير محدود"));
        Plus_P_Descrptn_L4.shouldHave(Condition.exactText("لوحات تحكم مخصصة غير محدودة"));
        Plus_P_Descrptn_L5.shouldHave(Condition.exactText("بيانات سابقة غير محدودة"));
        Plus_P_Descrptn_L6.shouldHave(Condition.exactText("إدارة حساب مخصصة"));
        Plus_P_Descrptn_L7.shouldHave(Condition.exactText("تدريب شهري للفريق"));
        Plus_P_Descrptn_L8.shouldHave(Condition.exactText("التحكم في صلاحيات و أذونات المستخدم"));
        Plus_Plan_SubScription_Buttn.should(Condition.visible);

        return AfdalPageFactory.getPricing();
    }

    @Override
    public IAfdalAnalyticsPricingPage Validation_EnterPrc_Plan_Correct_Data() {
        Entr_Plan_Descrptn.shouldHave(Condition.exactText("الباقة الشاملة مخصصة للعلامات التجارية، ووكالات التسويق، تزودهم بتقارير تسويقية متقدمة. كما توفر دعم تقني، وحماية البيانات للمؤسسات "));
        Entr_Plan_Des_Data_L1.shouldHave(Condition.exactText("$5 لكل رابط"));
        Entr_Plan_Des_Data_L2.shouldHave(Condition.exactText("20 رابط"));
        Entr_Plan_Des_Data_L3.shouldHave(Condition.exactText("عدد مستخدمين غير محدود"));
        Entr_Plan_Des_Data_L4.shouldHave(Condition.exactText("لوحة تحكم مخصصة لكل رابط وملف تعريف"));
        Entr_Plan_Des_Data_L5.shouldHave(Condition.exactText("بيانات سابقة أقصاها سنتين"));
        Entr_Plan_Des_Data_L6.shouldHave(Condition.exactText("استشارات تحليلات شهرية"));
        Entr_Plan_Des_Data_L7.shouldHave(Condition.exactText("دعم الدردشة والفيديو"));
        Entrprise_Plan_SubScription_Buttn.should(Condition.visible);
        return AfdalPageFactory.getPricing();
    }

    @Override
    public IAfdalAnalyticsPricingPage SignIn_with_LinkedIn_N() {
        getLinkedInIcon.click();
        switchTo().window(1);
        boolean linkedinURL = WebDriverRunner.getWebDriver().getCurrentUrl().startsWith("https://www.linkedin.com/");
        Assert.assertTrue(linkedinURL);
        String linkedinTitle = WebDriverRunner.getWebDriver().getTitle();
        Assert.assertEquals(linkedinTitle,"LinkedIn Login, Sign in | LinkedIn");
        closeWindow();
        switchTo().window(0);
        return AfdalPageFactory.getPricing();
    }

     @Override
    public IAfdalAnalyticsPricingPage verifyFacebookIcon() {
        executeJavaScript("arguments[0].click();", getFacebookFooterIcon);

        switchTo().window(1);
        boolean linkedinURL = WebDriverRunner.getWebDriver().getCurrentUrl().startsWith("https://www.facebook.com/login/?next=https%3A%2F%2Fwww.facebook.com%2FAfdal.Analytics");
            Assert.assertTrue(linkedinURL);
            String linkedinTitle = WebDriverRunner.getWebDriver().getTitle();
            Assert.assertEquals(linkedinTitle,"Log into Facebook");
        closeWindow();
        switchTo().window(0);
        return  AfdalPageFactory.getPricing();
    }

    @Override
    public IAfdalAnalyticsPricingPage verifyInstagramIcon() {
//        getInstagramFooterIcon.click();
        executeJavaScript("arguments[0].click();", getInstagramFooterIcon);
        switchTo().window(1);
        boolean instagramIcon = WebDriverRunner.getWebDriver().getCurrentUrl().startsWith("https://www.instagram.com/afdalanalytics/");
        Assert.assertTrue(instagramIcon);
        closeWindow();
        switchTo().window(0);
        return AfdalPageFactory.getPricing();
    }


    @Override
    public IAfdalAnalyticsPricingPage verifyTwitterIcon() {
//        getTwitterFooterIcon.click();
        executeJavaScript("arguments[0].click();", getTwitterFooterIcon);
        switchTo().window(1);
        boolean twitterIcon = WebDriverRunner.getWebDriver().getCurrentUrl().startsWith("https://twitter.com/afdalanalytics");
        Assert.assertTrue(twitterIcon);
        String twitterTitle = WebDriverRunner.getWebDriver().getTitle();
        Assert.assertEquals(twitterTitle,"Afdal Analytics - أفضل التحليلات (@AfdalAnalytics) / Twitter");
        switchTo().window(0);
        return  AfdalPageFactory.getPricing();
    }

 */
    @Override
    public IAfdalAnalyticsPricingPage Switch_To_PricingPage() {

        return AfdalPageFactory.getPricing();
    }





}


