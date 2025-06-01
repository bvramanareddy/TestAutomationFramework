package com.utility;

import com.constants.Browser;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BrowserUtility {

    Logger logger = LoggerUtility.getLogger(this.getClass());


    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public WebDriver getDriver() {
        return driver.get();
    }

    public BrowserUtility(WebDriver driver){
        super();
        this.driver.set(driver);
    }

    public BrowserUtility(String browserName){
        if (browserName.equalsIgnoreCase("chrome")){
            driver.set(new ChromeDriver());
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver.set(new EdgeDriver());
        }
        else {
            System.out.println("Invalid Browser Selection- Please enter Chrome or Edge");
        }
    }

    public BrowserUtility(Browser browserName){
        if (browserName==Browser.CHROME){
            driver.set(new ChromeDriver());
        } else if (browserName==Browser.EDGE) {
            driver.set(new EdgeDriver());
        }
        else if (browserName==Browser.FIREFOX) {
            driver.set(new FirefoxDriver());
        }
            else {
            System.out.println("Invalid Browser Selection- Please enter Chrome or Edge");
        }
    }

    public BrowserUtility(Browser browserName, boolean isHeadLess){
        if (browserName==Browser.CHROME){
            if (isHeadLess) {
                logger.info("Launching " + browserName + " with headless mode as " + isHeadLess);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                driver.set(new ChromeDriver(options));
            }
            else {
                driver.set(new ChromeDriver());

            }
        } else if (browserName==Browser.EDGE) {
            if (isHeadLess) {
                logger.info("Launching " + browserName + " with headless mode as " + isHeadLess);
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
                driver.set(new EdgeDriver(options));
            }
            else {
                driver.set(new EdgeDriver());

            }
        }
        else if (browserName==Browser.FIREFOX) {
            if (isHeadLess) {
                logger.info("Launching " + browserName + " with headless mode as " + isHeadLess);
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                driver.set(new FirefoxDriver(options));
            }
            else {
                driver.set(new FirefoxDriver());

            }
        }
        else {
            System.out.println("Invalid Browser Selection- Please enter Chrome or Edge");
        }
    }

    public void goToWebsite(String url){
        driver.get().get(url);
    }
    public void maximizeWindow(){
        driver.get().manage().window().maximize();
    }
    public void clickOn(By locator){
        WebElement element=  driver.get().findElement(locator);
        element.click();
    }
    public void enterText(By locator, String textToEnter){
        WebElement element = driver.get().findElement(locator);
        element.sendKeys(textToEnter);
    }
    public String getVisibleText(By locator){
        WebElement element =  driver.get().findElement(locator);
        return element.getText();
    }

    public String takeScreenshot(String fileName){
      TakesScreenshot screenshot =  (TakesScreenshot)driver.get();
        File screenShotData =  screenshot.getScreenshotAs(OutputType.FILE);
        Date date=  new Date();
        SimpleDateFormat format =  new SimpleDateFormat("HH-mm-ss");
        String timeStamp = format.format(date);

        String path = System.getProperty("user.dir")+"/Screenshots/"+ fileName+" - "+timeStamp+".png";
        File screenShotFile = new File(path);
        try {
            FileUtils.copyFile(screenShotData, screenShotFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return path;
    }

    public void quitBrowser(){
        driver.get().quit();
    }
}
