package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public final class MyAccountPage extends BrowserUtility {

    private static final By USER_NAME_LOCATOR= By.xpath("//a[@title='View my customer account']/span");
    private static final By ADD_NEW_ADDRESS_LINK_LOCATOR= By.xpath("//a[@title='Add my first address']");
    private static final By SEARCH_BOX_TEXT_LOCATOR = By.id("search_query_top");
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public String getUserNamePostLogin(){
        return getVisibleText(USER_NAME_LOCATOR);
    }

    public SearchResultPage searchForProduct(String productName){
        enterText(SEARCH_BOX_TEXT_LOCATOR, productName);
        enterSpecialKey(SEARCH_BOX_TEXT_LOCATOR, Keys.ENTER);
        SearchResultPage searchResultPage =  new SearchResultPage(getDriver());
        return searchResultPage;
    }

    public AddressPage goToAddAddressPage(){
        clickOn(ADD_NEW_ADDRESS_LINK_LOCATOR);
        return new AddressPage(getDriver());

    }
}


