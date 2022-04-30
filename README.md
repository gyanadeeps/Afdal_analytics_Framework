Selenide Documentation References:-

1) https://selenide.org/documentation.html
2) https://selenide.org/javadoc/current/
3) https://legacy.gitbook.com/book/selenide/user-guide/details


# Test Automation Project

This Automation framework is designed for NCSA Sports. It supports automation testing of Web applications.
* For UI testing, Selenide as a wrapper on top of Selenium
* Desktop chrome/firefox/Safari browser for UI testing
* Extent Report for reporting

Additionally, test environment and system variables is going to be configured in SystemProperites.class file in **java/data/SystemProperties.class**.

## Table of Contents

1. Development requirements
2. Configuring test project
3. Creating tests
4. Running tests
5. Extent Report
6. Project structure


## 1. Development requirements

**Required:** Chrome/Firefox/Safari browser, Java Development Kit 11 (JDK11) and maven 3 should be present on environment in order to develop and/or run the tests.

## 2. Configuring test project

Run this command to ensure the code has no errors:

```
$ mvn clean install -DskipTests=true
```

## 3. Creating tests

Test classes must be inherited from `web.BaseWebTest.class` or the class which is its child.
It contains a set of auxiliary methods which carry out useful work behind the scene such as downloading/starting/stopping the browser driver, collecting environment properties for reporting purpose, activating TestNG listeners and so on.

## 4. Running tests

To trigger the execution of the test cases you have to specify the next parameters:

* ***Suite:*** `-Dsuite={suite}` where `{suite}` is suite name without `.xml`
* ***Browser:*** `-Ddriver.type={driver.type}` where `{driver.type}` is value from `engine.webdriver.DriverType.class`. All the values need to be set in `SystemProperties.class` file in data package.
  In case of executing the test cases on the remote machine you have to enable remote driver `-Dremote.driver.status=ENABLED ` and `-Dremote.url={remote.url}`. All the values need to be set in `SystemProperties.class` file in data package.
* ***Test Case Specific Browser:*** Use annotaion at testcase level from `engine.webdriver.ThreadAssignedBrowserType.class` to assign particular browser type to testcase e.g. `@ThreadAssignedBrowserType(browser = "FF")` for invoking test case with firefox/Safari browser

```
$ mvn clean install -Dsuite={suite} -Ddriver.type={driver.type} 
```

## 5. Extent report

Once tests were executed `/Artifacts` directory will contain all the reports. Extent Report generated during executing will be residing in the folder with timestamp appended with name `NCSA_Automation+{suiteName}` .


## 6. Project structure

* `BaseClasses` package should contain base classes which are further extended by test cases written in test package.
* `test` package should contain automated test case classes
* `pageobjects` package should contain page object classes along with page factory model for driving AUT (Application Under Test) through Web UI
* `utilities` package that contains general utilities classes used across the framework.
* `ImplementationClasses` package should contain packages specific to NCSA portal and having all the functional flow of test cases which are called by test methods from `test` packages
* `data` package should contain `SyystemProperties.class` along with `enum` classes and data models which are used across the framework
* `engine` package having all the webdriver specific classes used for deciding & invoking the browser type for test cases 
* `Reporting` module should contain classes regarding Extent Report


