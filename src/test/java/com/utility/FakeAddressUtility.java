package com.utility;

import com.github.javafaker.Faker;
import com.ui.pojos.AddressPOJO;

import java.util.Locale;

public class FakeAddressUtility {

    private static AddressPOJO addressPOJO;
    public static AddressPOJO getFakeAddress(){
        Faker faker = new Faker(Locale.US);
        addressPOJO = new AddressPOJO(faker.company().name(), faker.address().buildingNumber(),faker.address().streetAddress(), faker.address().city(), faker.numerify("#####"), faker.phoneNumber().cellPhone(), faker.phoneNumber().cellPhone(), "Nothing to share", "MyHomeAddress", faker.address().state());
        return addressPOJO;
    }
}
