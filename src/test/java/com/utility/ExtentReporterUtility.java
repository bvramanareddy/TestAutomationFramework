package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterUtility {

    private static ExtentReports extentReports;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static void setUpSparkReporter(String fileName){
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/ExtentReports/"+ fileName);
        extentReports = new ExtentReports();

        extentReports.attachReporter(extentSparkReporter);
    }

    public static void createExtentTest(String testName){
        ExtentTest test = extentReports.createTest(testName);
        extentTest.set(test);
    }
    public static ExtentTest getTest(){
        return extentTest.get();
    }

    public static void flushReport(){
        extentReports.flush();
    }
}
