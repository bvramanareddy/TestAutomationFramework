package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShipmentPage extends BrowserUtility {

    private static final By TERMS_OF_SERVICE_CHECKBOX_LOCATOR = By.xpath("//div[@class='checker']");
    private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.name("processCarrier");

    public ShipmentPage(WebDriver driver) {
        super(driver);
    }

    public ShipmentPage checkTheTermsOfServiceCheckBox() {
        clickOnCheckBox(TERMS_OF_SERVICE_CHECKBOX_LOCATOR);
        return new ShipmentPage(getDriver());
    }

    public PaymentPage goToPaymentsPage() {
        clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
        return new PaymentPage(getDriver());
    }
}
