package utilities;

import Reporting.ExtentTestManager;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import data.SystemProperties;
import engine.DriverUtils;
import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static utilities.StringUtilInternal.beautify;

@Log
public class LoggingHandler implements InvocationHandler {

    private final Object target;
    private int stepNumber = 0;

    public LoggingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String itfName = method.getDeclaringClass().getSimpleName();
        //Remove 'I' letter
        String actionName = "Method: [" + method.getName() + "]";
        String className = beautify(itfName.substring(1));
        String methodName = beautify(StringUtils.capitalize(method.getName()));
        String message = className + " >> " + methodName;
        long startMillis = System.currentTimeMillis();

        try {
            Object invoke = method.invoke(target, args);
            long endMillis = System.currentTimeMillis();
            if (message.toLowerCase().contains("verify") || (SystemProperties.SCREENSHOT_ON_EVERY_STEP)) {
                // DriverUtils.getScreenshot();
                Markup m = MarkupHelper.createLabel(DriverUtils.screenShotEmbedHtml(DriverUtils.getScreenshot()), ExtentColor.TRANSPARENT);
                ExtentTestManager.getTest().createNode(message, actionName).log(Status.INFO, convertArgsToParameters(args, method)).log(Status.PASS, m);
            } else {
                ExtentTestManager.getTest().createNode(message, actionName).log(Status.INFO, convertArgsToParameters(args, method)).log(Status.PASS, "Test Step successfully executed");
            }
            return invoke;

        } catch (Throwable e) {
            long endMillis = System.currentTimeMillis();
            Markup m = MarkupHelper.createLabel(DriverUtils.screenShotEmbedHtml(DriverUtils.getScreenshot()), ExtentColor.TRANSPARENT);
            ExtentTestManager.getTest().createNode(message, actionName).log(Status.INFO, convertArgsToParameters(args, method)).log(Status.FAIL, e.getCause()).log(Status.FAIL, m);


            throw e.getCause();
        }
    }


    private String convertArgsToParameters(Object[] args, Method method) {
        try {
            if (args == null) {
                return List.of().toString();
            } else {
                String param = Arrays.stream(args)
                        .map(Object::toString)
                        .collect(Collectors.joining(", "));
                return "{" + param + "}";
            }
        } catch (Exception e) {
            log.info("No Arguments present in the method");
            return "No Arguments present in the method";
        }
    }
}