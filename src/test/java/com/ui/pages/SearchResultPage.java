package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class SearchResultPage extends BrowserUtility {

    private static final By PRODUCT_LISTING_TITLE_LOCATOR = By.xpath("//span[@class='lighter']");
    private static final By ALL_PRODUCT_LISTING_NAMES = By.xpath("//h5[@itemprop='name']/a");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public String getSearchTitle() {
        return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
    }

    public boolean isSearchKeywordPresentInResults(String searchKeyWord) {
       List<String> keywordsList=  Arrays.asList(searchKeyWord.toLowerCase().split(" "));
        List<String> productNamesLsit= getAllVisibleText(ALL_PRODUCT_LISTING_NAMES);
        boolean result =productNamesLsit.stream().anyMatch(name-> (keywordsList.stream().anyMatch(name.toLowerCase()::contains)));
        return result;
    }

    public ProductDetailsPage clickOnFirstProductAtIndex(int index){

        clickOn(getAllElements(ALL_PRODUCT_LISTING_NAMES).get(index));
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(getDriver());
        return productDetailsPage;

    }
}
