package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class LoginPage extends BrowserUtility {

    private static final By EMAIL_TEXT_LOCATOR = By.id("email");
    private  static  final By PASSWORD_TEXT_BOX_LOCATOR = By.id("passwd");
    private  static  final By SUBMIT_LOGIN_BUTTON_LOCATOR = By.id("SubmitLogin");
    private static final By ERROR_MESSAGE_LOCATOR = By.xpath("//div[contains(@class,'alert-danger')]/ol/li");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountPage doLoginWith(String email, String password){
        enterText(EMAIL_TEXT_LOCATOR, email);
        enterText(PASSWORD_TEXT_BOX_LOCATOR,password);
        clickOn(SUBMIT_LOGIN_BUTTON_LOCATOR);
        MyAccountPage myAccount= new MyAccountPage(getDriver());
        return myAccount;
    }

    public LoginPage doLoginWithInvalidCredentials(String email, String password){
        enterText(EMAIL_TEXT_LOCATOR, email);
        enterText(PASSWORD_TEXT_BOX_LOCATOR,password);
        clickOn(SUBMIT_LOGIN_BUTTON_LOCATOR);
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;
    }

    public String getErrorMessage(){
        return getVisibleText(ERROR_MESSAGE_LOCATOR);
    }

}
