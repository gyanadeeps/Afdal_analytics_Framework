package engine;

import data.SystemProperties;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    int counter=0;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(counter < SystemProperties.RETRY_COUNT)
        {
            counter++;
            return true;
        }
        return false;
    }
    }

