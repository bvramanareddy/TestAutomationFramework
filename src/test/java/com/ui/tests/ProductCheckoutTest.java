package com.ui.tests;

import com.constants.Size;
import com.ui.pages.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductCheckoutTest extends TestBase{

    private SearchResultPage searchResultPage;
    private static final String SEARCH_TERM ="Printed Summer Dress";
    @BeforeMethod(description = "user logs into Application and search for Dress product")
    public void setUp(){
    searchResultPage = homePage.goToLoginPage().doLoginWith("cehon16664@ofular.com", "Rocket").
            searchForProduct(SEARCH_TERM);

    }
    @Test(description = "Verify if the logged in user is able to place DRESS order",  groups = {"E2E", "Smoke"})
    public void checkoutTest(){

        String orderConfirmationMessage= searchResultPage.clickOnFirstProductAtIndex(2).changeSize(Size.L).addProductToCart().
                proceedToCheckout().clickOnProceddToCheckoutAndGotoAddressConfirmPage().goToShipmentPage()
                .checkTheTermsOfServiceCheckBox().goToPaymentsPage().makePaymentByWire();
        Assert.assertTrue(orderConfirmationMessage.contains("complete"));
    }
}
