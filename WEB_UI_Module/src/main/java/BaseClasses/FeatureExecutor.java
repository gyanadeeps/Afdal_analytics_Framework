package BaseClasses;

import com.codeborne.selenide.WebDriverRunner;
import data.StringUtilInternal;
import lombok.extern.java.Log;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import java.util.List;

@Log
public class FeatureExecutor {
    private final List<Feature> features;

    public FeatureExecutor(List<Feature> features) {
        this.features = features;
    }

    public void execute() {
        features.forEach(f -> {
            String name = StringUtilInternal.beatifyCamelCaseString(f.getClass().getSimpleName());
            performFeature(name, f);
        });
    }

    private void performFeature(String name, Feature feature) {
        log.info("INIT test-------> "+ feature + " in thread " + Thread.currentThread().getId());
        feature.init();
        log.info("Execute test-------> "+ feature + " in thread " + Thread.currentThread().getId());
        feature.execute();
        SessionId sessionid = ((RemoteWebDriver) WebDriverRunner.getWebDriver()).getSessionId();
        log.info("Session is -> " + sessionid + "for feature -> " + feature);
    }
}