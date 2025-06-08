package com.ui.tests;

import com.ui.pages.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.ui.listners.TestListerner.class)
public class SearchProductTest extends TestBase{

    private MyAccountPage myAccountPage;
    private static final String SEARCH_KEYWORD ="printed summer dress";

    @BeforeMethod(description = "Valid User Login to application")
    public void setUp(){
        myAccountPage = homePage.goToLoginPage().doLoginWith("cehon16664@ofular.com", "Rocket");
    }
    @Test(description = "Verify if the logged user is able to search and results are correctly displayed", groups = {"E2E", "Smoke", "Sanity", "Seach"})
    public void verifyProductSearchTest(){
       boolean actualResult=  myAccountPage.searchForProduct(SEARCH_KEYWORD).isSearchKeywordPresentInResults(SEARCH_KEYWORD);
        Assert.assertTrue(actualResult);

    }

}
