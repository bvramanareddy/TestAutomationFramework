package com.ui.tests;

import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners(com.ui.listners.TestListerner.class)
public class InvalidCredsLoginTest extends TestBase {


    Logger logger = LoggerUtility.getLogger(this.getClass());
    private static final String INVALID_USEREMAIL = "bodd@aol.com";
    private static final String INVALID_PASSWORD = "Qwerty12345$";


    @Test(description = "Verify InValid user Login Functionality and Observe user is getting the error message  ", groups = {"Login", "UserLogin", "InvalidLogin"})
    public void verifyInvalidCredsLoginFunctionality() {
        logger.info("Now trying to Login into application with Invalid credentials");
        assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_USEREMAIL, INVALID_PASSWORD).getErrorMessage(), "Authentication failed.");

    }
}
