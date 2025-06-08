package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressConfirmPage extends BrowserUtility {

    private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR= By.name("processAddress");
    public AddressConfirmPage(WebDriver driver) {
        super(driver);
    }

    public ShipmentPage goToShipmentPage(){
        clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
        return new ShipmentPage(getDriver());
    }
}
