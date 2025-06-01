package com.ui.tests;

import com.ui.pages.HomePage;
import com.ui.pojos.User;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.constants.Browser.CHROME;
import static org.testng.Assert.assertEquals;

@Listeners({com.ui.listners.TestListerner.class})
public class LoginTestUsingExcelDataUsingRetryAnalyzer extends TestBase{


    @Test(description = "Verify user Login Functionality with multiple users read From Excel",
            groups = {"Login", "UserLogin"},
            dataProviderClass = com.ui.loginDataProviders.LoginDataProvider.class,
            dataProvider = "LoginTestExcelDataProvider",retryAnalyzer = com.ui.listners.MyReteyAnalyzer.class)
    public void verifyLoginFunctionalityWithDifferentUsersFromExcelRetryAnalyser(User user){

        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserNamePostLogin(), "Ramana Reddy");

    }
}
