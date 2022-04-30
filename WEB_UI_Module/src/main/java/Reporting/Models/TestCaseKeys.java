package Reporting.Models;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TestCaseKeys {
    public static Multimap<String, String> reportsPathTestCasesMultiMap = ArrayListMultimap.create();
    public static Map<Integer, String> reportsPathWithTestCaseThreadIDMap = new HashMap<Integer, String>();

    public static void putTestCaseKeys(String reportPath, String TcKey) {

        reportsPathTestCasesMultiMap.put(reportPath, TcKey);

    }

    public static Collection<String> getTestCaseKeys(String reportPath) {

        return reportsPathTestCasesMultiMap.get(reportPath);

    }
}
