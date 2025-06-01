package com.ui.pages;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.JsonUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.constants.Env.DEV;


public final class HomePage extends BrowserUtility {
    private static final By SIGN_IN_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]");

    public HomePage(Browser browserName, boolean isHeadless) {
        super(browserName, isHeadless);
        goToWebsite(JsonUtility.readJSON(DEV));
    }

    public HomePage(WebDriver driver) {
        super(driver);
        goToWebsite(JsonUtility.readJSON(DEV));

    }

    public LoginPage goToLoginPage(){
    maximizeWindow();
    clickOn(SIGN_IN_LOCATOR);
    LoginPage loginPage =  new LoginPage(getDriver());
    return loginPage;
    }
}
