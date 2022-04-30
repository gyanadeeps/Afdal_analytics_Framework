package utilities;

import Reporting.ExtentTestManager;
import Reporting.customOperation.DataInsertionExtentReport;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;

import java.util.HashMap;
import java.util.HashSet;

public class MapCompareMethods {


    public void keySetComparison(HashMap<Integer, HashMap<String, String>> mapUIActual, HashMap<Integer, HashMap<String, String>> mapConfigSheetExpected) {

        int uiDataSize = mapUIActual.keySet().size();
        int configSheetSize = mapConfigSheetExpected.keySet().size();
        boolean failSafeFlag = false;

        HashSet<Integer> unionKeys = new HashSet<>(mapUIActual.keySet());
        unionKeys.addAll(mapConfigSheetExpected.keySet());

        if (configSheetSize > uiDataSize) {
            unionKeys.removeAll(mapUIActual.keySet());
            DataInsertionExtentReport.dataInsertionFail("Colleges having Rankings are missing from ranking table on UI page", unionKeys.toString(), "Colleges with following ranking/s not present on UI--> " + unionKeys.toString());
            ExtentTestManager.getTest().fail("Following colleges having ranking: " + unionKeys.toString() + " not present on web page.");
            Assert.fail("Following colleges having ranking: " + unionKeys.toString() + " not present on web page.");

        }

        if (uiDataSize > configSheetSize) {
            unionKeys.removeAll(mapConfigSheetExpected.keySet());
            DataInsertionExtentReport.dataInsertionFail("Colleges having Rankings as given below are not present on UI page", unionKeys.toString(), "Colleges with following ranking/s not present in Config Excel/CSV Sheet--> " + unionKeys.toString());
            ExtentTestManager.getTest().fail("Following colleges on webpage having ranking: " + unionKeys.toString() + " not present in excel/csv sheet.");
            Assert.fail("Following colleges on webpage having ranking: " + unionKeys.toString() + " not present in excel/csv sheet.");

        }

        if (uiDataSize == configSheetSize) {
            for (int key1 : mapUIActual.keySet()) {
                //DataInsertionExtentReport.dataInsertion("Comparing the value for College having Rank: " + key1, "");
                //mapConfigSheetExpected.get(key1);
                ExtentTest test = ExtentTestManager.getTest().createNode("Comparing the value for College having Rank: " + key1, "");
                try {
                    for (String key2 : mapUIActual.get(key1).keySet()) {
                        String configSheetValue = mapConfigSheetExpected.get(key1).get(key2);
                        String UiValue = mapUIActual.get(key1).get(key2);
                        if (UiValue.equalsIgnoreCase(configSheetValue)) {
                            test.pass("Column Name :'" + key2 + "' --> Excel Value: " + configSheetValue + " | " + "UI Value: " + UiValue);
                            // DataInsertionExtentReport.dataInsertionPass("Comparing the value of " + key2 + " for College having Rank: " + key1, "Excel Value: " + configSheetValue + " | " + "UI Value: " + UiValue, "Comparison Successfully. Data matching for" + key2);

                        } else {
                            test.fail("Column Name :'" + key2 + "' --> Excel Value: " + configSheetValue + " | " + "UI Value: " + UiValue);
                            failSafeFlag = true;
                        }//DataInsertionExtentReport.dataInsertionFail("Comparing the value of " + key2 + " for College having Rank: " + key1, "Excel Value: " + configSheetValue + " | " + "UI Value: " + UiValue, "Data NOT matching for column: " + key2);
                    }
                } catch (Exception e) {
                    test.fail("College Name with rank :'" + key1 + "' not present in Config Excel sheet");
                    failSafeFlag = true;
                }

            }
            if (failSafeFlag == true) {
                Assert.fail("There is a mismatch between UI webpage and Config Sheet data. Please follow the report steps below for detailed failure reasons.");
            }


        }

    }


}
