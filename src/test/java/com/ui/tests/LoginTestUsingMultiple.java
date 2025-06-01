package com.ui.tests;

import com.ui.pages.HomePage;
import com.ui.pojos.User;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.constants.Browser.CHROME;
import static org.testng.Assert.assertEquals;

public class LoginTestUsingMultiple extends TestBase {
    HomePage homePage;


    @Test(description = "Verify Valid user Login Functionality with multiple users", groups = {"Login", "UserLogin"}, dataProviderClass = com.ui.loginDataProviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
    public void verifyLoginFunctionalityWithDifferentUsers(User user){
        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserNamePostLogin(), "Ramana Reddy");
    }

}
