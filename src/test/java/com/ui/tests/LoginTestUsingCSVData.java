package com.ui.tests;

import com.ui.pages.HomePage;
import com.ui.pojos.User;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.constants.Browser.CHROME;
import static org.testng.Assert.assertEquals;

@Listeners(com.ui.listners.TestListerner.class)
public class LoginTestUsingCSVData extends TestBase{


    @Test(description = "Verify user Login Functionality with multiple users read From CSV", groups = {"Login", "UserLogin"}, dataProviderClass = com.ui.loginDataProviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider")
    public void verifyLoginFunctionalityWithDifferentUsers(User user){
        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserNamePostLogin(), "Ramana Reddy");
    }

}
