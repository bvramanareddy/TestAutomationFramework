package com.ui.tests;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojos.AddressPOJO;
import com.utility.FakeAddressUtility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewFirstAddressFakerTest extends TestBase{

    private MyAccountPage myAccountPage;
    private AddressPage addressPage;
    private AddressPOJO addressPOJO;

    @BeforeMethod(description = "Valid First Time User Login to application")
    public void setUp(){
        myAccountPage = homePage.goToLoginPage().doLoginWith("cehon16664@ofular.com", "Rocket");
        addressPOJO = FakeAddressUtility.getFakeAddress();
    }
    @Test (description = "Adding a new Address for a first time user - Using Dynamic data by Faker")
    public void addNewAddressUsingFaker(){
        String newAddress = myAccountPage.goToAddAddressPage().saveNewAddress(addressPOJO);
        Assert.assertEquals(newAddress, addressPOJO.getAddressAlias().toUpperCase());
    }
}
