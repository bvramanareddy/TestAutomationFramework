package com.ui.tests;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojos.AddressPOJO;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewAddressTest extends TestBase{

    private MyAccountPage myAccountPage;
    private AddressPage addressPage;
    private AddressPOJO addressPOJO;

    @BeforeMethod(description = "Valid User Login to application")
    public void setUp(){
        myAccountPage = homePage.goToLoginPage().doLoginWith("cehon16664@ofular.com", "Rocket");
        addressPOJO = new AddressPOJO("Infosys", "40 Wye Valley", "Scarborogh", "Toronto", "12345", "7896764567", "1234567898", "Nothing", "MyHomeAdd", "California");
    }
    @Test
    public void addNewAddress(){
       myAccountPage.goToAddAddressPage().saveNewAddress(addressPOJO);
    }
}
