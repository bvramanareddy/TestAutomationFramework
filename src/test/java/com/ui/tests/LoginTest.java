package com.ui.tests;

import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends TestBase{

    Logger logger = LoggerUtility.getLogger(this.getClass());

    @Test(description = "Verify Valid user Login Functionality", groups = {"Login", "UserLogin"})
    public void verifyLoginFunctionality(){
        logger.info("Now Logging into application with credentials");
        assertEquals(homePage.goToLoginPage().doLoginWith("cehon16664@ofular.com", "Rocket").getUserNamePostLogin(), "Ramana Reddy");
    }


}
