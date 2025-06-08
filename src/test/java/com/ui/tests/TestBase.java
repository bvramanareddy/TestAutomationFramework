package com.ui.tests;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class TestBase {
    protected HomePage homePage;
    Logger logger = LoggerUtility.getLogger(this.getClass());
    private boolean isLamdaTest;


    @Parameters({"browser", "isLamdaTest", "isHeadless"})
    @BeforeMethod(description = "Load the HomePage of the website")
    public void setUp(
            @Optional("chrome") String browser,
            @Optional("false") boolean isLamdaTest,
            @Optional("false") boolean isHeadless, ITestResult result) {
        this.isLamdaTest= isLamdaTest;
        WebDriver lambdaDriver;
        if (isLamdaTest) {
            lambdaDriver = LambdaTestUtility.initializeLambdaTestSession(browser, result.getMethod().getMethodName());
            homePage = new HomePage(lambdaDriver);
        } else {
            logger.info("Loading the HomePage");
            homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
        }
    }

    //@AfterMethod
    public void tearDown() {

        if (isLamdaTest) {
            logger.info("Closing the LamdaSession");

            LambdaTestUtility.quitLamdaTestSession();
        } else {
            logger.info("Closing the browser");
            homePage.quitBrowser();
        }
    }

    public BrowserUtility getInstance() {
        return homePage;
    }
}
