package com.ui.listners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReporterUtility;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListerner implements ITestListener {

    Logger logger = LoggerUtility.getLogger(this.getClass());
    ExtentSparkReporter extentSparkReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;

    public void onTestStart(ITestResult result) {
        logger.info(result.getMethod().getMethodName());
        logger.info(result.getMethod().getDescription());
        logger.info(Arrays.toString(result.getMethod().getGroups()));
        ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());

    }

    public void onTestSuccess(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + " " + "PASSED");
        ExtentReporterUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " " + "PASSED");

    }

    public void onTestFailure(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + " " + "FAILED");
        logger.info(result.getThrowable().getMessage());
        ExtentReporterUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " " + "FAILED");
        ExtentReporterUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());
        Object testclass= result.getInstance();
        BrowserUtility browserUtility= ((TestBase)testclass).getInstance();
        logger.info("Capturing Screenshot for the FAILED test");
        String screenshotPath = browserUtility.takeScreenshot(result.getMethod().getMethodName());
        logger.info("Attaching the Screenshot to HTML report");
        ExtentReporterUtility.getTest().addScreenCaptureFromPath(screenshotPath);
    }

    public void onTestSkipped(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + " " + "SKIPPED");
        ExtentReporterUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " " + "SKIPPED");

    }

    public void onStart(ITestContext context) {
        logger.info("Test Suite Started");
        ExtentReporterUtility.setUpSparkReporter("myAutomationReport.html");
    }

    public void onFinish(ITestContext context) {
        logger.info("Test Suite Started");
        ExtentReporterUtility.flushReport();
    }
}
