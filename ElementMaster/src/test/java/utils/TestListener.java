package utils;

import org.testng.*;
import org.openqa.selenium.*;
import base.BaseTest;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        BaseTest test = (BaseTest) result.getInstance();
        WebDriver driver = test.getDriver();
        ScreenshotUtil.capture(driver, result.getName());
    }
}