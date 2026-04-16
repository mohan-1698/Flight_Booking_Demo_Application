package com.srm.hackathon.flightbook.listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;
import com.srm.hackathon.flightbook.utils.ExtentManager;
import com.srm.hackathon.flightbook.utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        String path = ScreenshotUtil.captureScreenshot(result.getName());

        test.get().fail(result.getThrowable())
                .addScreenCaptureFromPath(path);
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
        extent.flush();
    }
}