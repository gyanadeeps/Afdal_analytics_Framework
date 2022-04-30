package utilities;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class JavaScriptFunction {

    public static void scrollIntoView(SelenideElement element){
        int y = element.getLocation().y;
        Selenide.executeJavaScript("window.scrollTo(0," + (y - 150) + ")");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private static Long getHtmlCount() {
        var script = "\tvar begin = document.all;\n" +
                "\treturn begin.length;";
        return Selenide.executeJavaScript(script);
    }
    private static Long getParentHtmlCount(By source) {
        var script = "return document.querySelector(arguments[0]).querySelectorAll('*').length;";
        return Selenide.executeJavaScript(script, getLocator(source));
    }

    private static String getLocator(By locator) {
        String label = "cssSelector: ";
        return locator.toString().split(label)[1];
    }

}