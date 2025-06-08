package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BrowserUtility {
    private static final By PAYMENT_BY_WIRE_BUTTON_LOCATOR= By.xpath("//a[@title='Pay by bank wire']");
    private static final By CONFIRM_ORDER_BUTTON_LOCATOR = By.xpath("//p[contains(@class,'cart_navigation')]/button");
    private static final By SUCCESS_MESSAGE_LOCATOR = By.xpath("//p[contains(@class,'success')]");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public String makePaymentByWire() {
        clickOn(PAYMENT_BY_WIRE_BUTTON_LOCATOR);
        clickOn(CONFIRM_ORDER_BUTTON_LOCATOR);
       return getVisibleText(SUCCESS_MESSAGE_LOCATOR);
    }

}
