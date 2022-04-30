package Reporting.customOperation;

import Reporting.ExtentTestManager;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class DataInsertionExtentReport {
    public static void jsonDataInsert(String StepName, String data) {

        Markup m = MarkupHelper.createCodeBlock(data, CodeLanguage.JSON);
        ExtentTestManager.getTest().createNode(StepName).info(m);
    }


    public static void xmlDataInsert(String StepName, String data) {

        Markup m = MarkupHelper.createCodeBlock(data, CodeLanguage.XML);
        ExtentTestManager.getTest().createNode(StepName).info(m);
    }


    public static void dataInsertion(String StepName, String data) {

        ExtentTestManager.getTest().createNode(StepName).info(data);
    }

    public static void dataInsertionPass(String StepName, String data, String passReason) {

        ExtentTestManager.getTest().createNode(StepName).info(data).pass(passReason);
    }

    public static void dataInsertionFail(String StepName, String data, String FailureReason) {

        ExtentTestManager.getTest().createNode(StepName).info(data).fail(FailureReason);
    }

}
