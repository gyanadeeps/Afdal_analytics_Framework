package utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtilInternal {
    private static final String REGEXP = "(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])";
    private static final String REGEXPFORSTRING = "[^0-9]";

    public static List<String> splitCamelCaseString(String s) {
        return new ArrayList<>(Arrays.asList(s.split("REGEXP")));
    }

    public static String beatifyCamelCaseString(String s) {
        return String.join(" ", splitCamelCaseString(s));
    }

    public static String getLinkFromString(String message) {
        String substring = message.substring(message.indexOf("https://"));
        return substring.substring(0, substring.indexOf("\n"));
    }

    public static String getVerificationCodeFromString(String message) {
        String substring = message.substring(message.indexOf("Verification Code"));
        return substring.substring(19, substring.indexOf("\n"));
    }

    public static String beautify(String s) {
        return String.join(" ", new ArrayList<>(Arrays.asList(s.split(REGEXP))));
    }
    public static String currencyConversion(String s) {
        return s.replaceAll(REGEXPFORSTRING, "");
    }
}